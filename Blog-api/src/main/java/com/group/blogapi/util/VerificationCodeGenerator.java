package com.group.blogapi.util;

import java.util.Random;

public class VerificationCodeGenerator {

    /**
     * 生成五位随机验证码
     * @return 五位随机验证码字符串
     */
    public static String generateFiveDigitCode() {
        final String digits = "0123456789";
        final int codeLength = 5;
        Random random = new Random();
        StringBuilder codeBuilder = new StringBuilder(codeLength);
        for (int i = 0; i < codeLength; i++) {
            codeBuilder.append(digits.charAt(random.nextInt(digits.length())));
        }
        return codeBuilder.toString();
    }
}