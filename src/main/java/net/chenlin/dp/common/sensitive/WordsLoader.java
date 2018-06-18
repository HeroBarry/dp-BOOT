package net.chenlin.dp.common.sensitive;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * 加载敏感词配置文件。<br/>
 * 将加载的敏感词按照<b>DFA</b>算法的数据结构保存到{@link #wordsMap}中。<br/>
 *
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */

public class WordsLoader {
    private static final Logger LOG = LoggerFactory.getLogger(WordsLoader.class);
    private static final String FILE_NAME = "words.txt";
    /**
     * 系统指定的文件全路径
     */
    private static String specifyPath = System.getProperty("swFilePath");

    /**
     * 按照DFA算法的数据结构保存的敏感词。<br/>
     * k=敏感词的第一个字符，v=后续字符。
     */
    @SuppressWarnings("unchecked")
    private static final Map<String, Map> wordsMap = new HashMap<String, Map>();

    static {
        // 加载
        List<String> wordLines = null;
        try {
            wordLines = loadWordsFile();
        } catch (IOException e) {
            LOG.error("load words.txt got ex:", e);
        }

        // 整理数据结构
        addToCache(wordLines);
    }

    /**
     * 加载敏感词文件。<br/>
     * 将按照顺序寻找直到找到一个。<br/>
     * 1.启动时配置的系统属性 ${swFilePath}。全路径。<br/>
     * 2.${user.dir}/words.txt。一般是bin、domain etc...<br/>
     * 3.${classpath}/words.txt。环境变量里。<br/>
     *
     * @return 敏感词列表
     * @throws IOException
     */

    private static List<String> loadWordsFile() throws IOException {
        // 指定路径

        if (!Strings.isNullOrEmpty(specifyPath) && Files.exists(Paths.get(specifyPath))) {
            LOG.debug("found words.txt at :{}", specifyPath);
            return Files.readAllLines(Paths.get(specifyPath));
        }

        // 运行时目录,bin,domain etc...
        String runDir = System.getProperty("user.dir");
        Path fp = Paths.get(runDir, FILE_NAME);
        if (!Files.exists(fp)) {
            LOG.debug("could not find words.txt at:{}", fp);

            // classpath
            try (InputStream ins = ClassLoader.getSystemResourceAsStream(FILE_NAME)) {
                if (ins == null) {
                    LOG.debug("could not find words.txt at classpath");
                    return Collections.emptyList();
                }

                LOG.warn("load default words.txt in classpath.");
                return readLines(ins);
            }
        }

        LOG.info("found words.txt in runtime dir:{}.", fp);
        return Files.readAllLines(fp);
    }

    /**
     * 逐字分割按照DFA算法的数据结构保存敏感词至{@link #wordsMap}。<br/>
     * k=敏感词的第一个字符，v=后续字符。e.g<br/>
     * 敏感词=开假发票。<br/>
     * {
     * "开":{"假":{"发":{"票":{}}}}
     * }
     *
     * @param wordLines 敏感词列表
     */
    @SuppressWarnings("unchecked")
    private static void addToCache(List<String> wordLines) {
        if (wordLines == null || wordLines.isEmpty()) {
            return;
        }
        wordLines.forEach(line -> {
            if (Strings.isNullOrEmpty(line)) {
                return;
            }

            char[] wordChars = line.toCharArray();
            // 首字
            String headWord = null;

            // 子内容
            Map<String,Map> subWordMap = null;
            for (char word : wordChars) {
                String _word = String.valueOf(word);

                // 第一个字符
                if (headWord == null) {
                    headWord = _word;
                    if (!wordsMap.containsKey(headWord)) {
                        wordsMap.put(headWord, new HashMap());
                    }
                    subWordMap = wordsMap.get(headWord);
                    continue;
                }

                // 如子内容map不包含当前字符则将当前字符保存到子中
                if (!subWordMap.containsKey(_word)) {
                    subWordMap.put(_word, new HashMap());
                    subWordMap = subWordMap.get(_word);
                    continue;
                }

                // 如包含，继续去下一个子map中寻找
                subWordMap = subWordMap.get(_word);
            }
        });
    }

    private static List<String> readLines(InputStream input) throws IOException {
        try (InputStreamReader inReader = new InputStreamReader(input);
             BufferedReader reader = new BufferedReader(inReader)) {
            List<String> list = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
            return list;
        }
    }

    public static Map<String,Map> getWordsMap() {
        return wordsMap;
    }
}
