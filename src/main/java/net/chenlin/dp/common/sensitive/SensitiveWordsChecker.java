package net.chenlin.dp.common.sensitive;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 敏感词检测。
 *
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
public class SensitiveWordsChecker {

    /**
     * 根据<b>DFA</b>算法规则，将传入的检测文本<code>textStr</code>逐字与保存的敏感词map {@link WordsLoader#getWordsMap()}进行匹配。<br/>
     * 返回包含的敏感词。
     *
     * @param textStr 检测文本
     * @return 传入检测文本中包含的敏感词
     */
    @SuppressWarnings("unchecked")
    public static Set<String> checkSensitiveWord(String textStr) {
        Set<String> illWords = new HashSet<String>();
        Map<String, Map> wordsMap = WordsLoader.getWordsMap();

        for (int i = 0; i < textStr.length(); i++) {
            String currWord = String.valueOf(textStr.charAt(i));

            // 如包含当前字符，则当前字符敏感，往下找
            if (wordsMap.containsKey(currWord)) {
                StringBuilder strb = new StringBuilder();
                strb.append(currWord);
                int j = i;

                // 获取当前字符的子map
                Map<String, Map> subMap = wordsMap.get(currWord);

                // 拼配的数量
                int matchCount = 1;
                // 敏感词字符的总数量
                int wordsCount = 1;

                while (true) {
                    // 找完了
                    if (j == textStr.length() - 1) {
                        break;
                    }

                    // 下一个字符
                    j++;
                    String nextWord = String.valueOf(textStr.charAt(j));

                    if (subMap.isEmpty()) {
                        break;
                    }
                    wordsCount++;

                    // 如子map仍然包含敏感字符接着往下找
                    if (subMap.containsKey(nextWord)) {
                        strb.append(nextWord);
                        subMap = subMap.get(nextWord);
                        matchCount++;
                    }

                    // 已然不匹配了
                    if (wordsCount != matchCount) {
                        break;
                    }
                }

                // 如匹配的数量与敏感字符数量一致认为拼配到了
                if (matchCount == wordsCount) {
                    illWords.add(strb.toString());
                }
            }

        }
        return illWords;
    }
}
