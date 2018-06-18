package net.chenlin.dp.common.privacy;

import org.apache.commons.lang3.RandomUtils;

public class ChineseAddressGeneratorBase extends BaseGenericGenerator {
    private static BaseGenericGenerator instance = new ChineseAddressGeneratorBase();

    private ChineseAddressGeneratorBase() {
    }

    public static BaseGenericGenerator getInstance() {
        return instance;
    }

    @Override
    public String generate() {
        StringBuilder result = new StringBuilder(genProvinceAndCity());
        result.append(ChineseCharUtils.genRandomLengthChineseChars(2, 3) + "路");
        result.append(RandomUtils.nextInt(1, 8000) + "号");
        result.append(ChineseCharUtils.genRandomLengthChineseChars(2, 3) + "小区");
        result.append(RandomUtils.nextInt(1, 20) + "单元");
        result.append(RandomUtils.nextInt(101, 2500) + "室");
        return result.toString();
    }

    private static String genProvinceAndCity() {
        return ChineseAreaList.provinceCityList.get(
            RandomUtils.nextInt(0, ChineseAreaList.provinceCityList.size()));
    }

}
