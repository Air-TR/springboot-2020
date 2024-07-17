package com.tr.springboot;

/**
 * 敏感词过滤
 *
 * @Author: TR
 */
public class SensitiveWordsFilter {

    public static void main(String[] args) throws Exception {

        // 定义敏感词列表
        String[] sensitiveWords = {"大傻逼", "菜逼", "吸毒", "赌博"};

        String text = "你个菜逼，还是不要打排位了";
        for (String word : sensitiveWords) {
            if (text.contains(word)) {
                // 替换敏感词为 *
                text = text.replaceAll(word, replaceString(word.length()));
            }
        }

        System.out.println(text);
    }

    public static String replaceString(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append("*");
        }
        return builder.toString();
    }

}
