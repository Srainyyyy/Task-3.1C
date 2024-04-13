package com.example.a31c;

import java.util.Arrays;

public class Question {
    private String questionStem; // 题干
    private String[] options; // 选项
    private int correctOptionIndex; // 正确选项的索引

    private String correctOptions; // 正确答案


    // 构造函数
    public Question(String questionStem, String[] options, int correctOptionIndex) {
        this.questionStem = questionStem;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    // 获取题干


    // 构造函数
    public Question() {
    }

    // 获取题干
    public String getQuestionStem() {
        return questionStem;
    }

    // 设置题干
    public void setQuestionStem(String questionStem) {
        this.questionStem = questionStem;
    }

    // 获取选项
    public String[] getOptions() {
        return options;
    }

    // 设置选项
    public void setOptions(String[] options) {
        this.options = options;
    }

    // 获取正确答案
    public String getCorrectOptions() {
        return correctOptions;
    }

    // 设置正确答案
    public void setCorrectOptions(String correctOptions) {
        this.correctOptions = correctOptions;
    }

    public int getCorrectOptionIndex() {
        // 将正确答案字符串拆分为数组
        String[] correctOptionsArray = correctOptions.split(",");

        // 遍历选项数组，查找正确答案的索引
        for (int i = 0; i < options.length; i++) {
            if (Arrays.asList(correctOptionsArray).contains(String.valueOf(i))) {
                return i; // 返回正确答案的索引
            }
        }

        return -1; // 如果未找到正确答案，返回 -1
    }

}
