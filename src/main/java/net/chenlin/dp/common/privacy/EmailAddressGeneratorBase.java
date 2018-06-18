package net.chenlin.dp.common.privacy;

import org.apache.commons.lang3.RandomStringUtils;

public class EmailAddressGeneratorBase extends BaseGenericGenerator {
    private static BaseGenericGenerator instance = new EmailAddressGeneratorBase();

    private EmailAddressGeneratorBase() {
    }

    public static BaseGenericGenerator getInstance() {
        return instance;
    }

    @Override
    public String generate() {
        StringBuilder result = new StringBuilder();
        result.append(RandomStringUtils.randomAlphanumeric(10));
        result.append("@");
        result.append(RandomStringUtils.randomAlphanumeric(5));
        result.append(".");
        result.append(RandomStringUtils.randomAlphanumeric(3));

        return result.toString().toLowerCase();
    }
}
