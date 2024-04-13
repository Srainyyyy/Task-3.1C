package com.example.a31c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class RadioButtonFragment extends Fragment {
    private TextView questionStem; // 题干文本框控件，就是选中的控件显示
    private final RadioButton[] radioButtons = new RadioButton[3]; // 单选按钮数组
    private Question question; // 题目对象
    private RadioGroup radioGroup;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 加载 RadioButtonFragment 的布局文件
        View view = inflater.inflate(R.layout.fragment_radio_button, container, false);
        // 初始化控件
        initView(view);
        // 更新题目
        if (question != null) {
            nextQuestion(question);
        }
        return view;
    }


    // 设置题目
    public void setQuestion(Question question) {
        this.question = question;
    }

    // 初始化控件
    private void initView(View view) {
        // 获取题干
        questionStem = view.findViewById(R.id.question_item);
        radioGroup = view.findViewById(R.id.radiogroup);
        // 单选控件
        radioButtons[0] = view.findViewById(R.id.radio1);
        radioButtons[1] = view.findViewById(R.id.radio2);
        radioButtons[2] = view.findViewById(R.id.radio3);
    }

    public  void  clear(){
        radioGroup.clearCheck();
    }

    // 更新题目
    public void nextQuestion(Question question) {
        this.question=question;
        // 设置题干
        questionStem.setText(question.getQuestionStem());
        // 设置选项
        String[] options = question.getOptions();
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i].setText(options[i]);
        }
    }

    // 获取答题结果
    public int getResult() {
        int selectedOptionIndex = -1;
        // 获取选中的选项
        for (int i = 0; i < radioButtons.length; i++) {
            if (radioButtons[i].isChecked()) {
                selectedOptionIndex = i;
                break;
            }
        }
        // 判断答案是否正确
        if (selectedOptionIndex == question.getCorrectOptionIndex()) {
            // 答对了
            return 1;
        } else {
            // 答错了
            return 0;
        }
    }

    public void setQuestionAndLoad(Question question) {
        this.question = question;
        if (questionStem != null) {
            nextQuestion(question);
        }
    }

}
