package com.example.a31c;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {
    private int score = 0; // 答题分数
    private final List<Question> questions = new ArrayList<>(); // 题目集合
    private int currentQuestionIndex = 0; // 当前题号
    private int result; // 答题结果，正确为1，错误为0，未答题为-1
    private Button button; // 提交按钮
    private RadioButtonFragment radioButtonFragment; // 单选按钮对象


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        // 初始化题目
        initQuestions();

        // 初始化控件
        initView();



        // 加载 RadioButtonFragment


        // 加载第一题
        Question question =questions.get(0);
       // loadQuestion(questions.get(0));

        // 加载 RadioButtonFragment
        radioButtonFragment.setQuestion(question);
        replaceFragment(radioButtonFragment);
    }

    // 初始化控件
    private void initView() {
        button = findViewById(R.id.submit_button); // 初始化按钮
        radioButtonFragment=new RadioButtonFragment();

        // 设置按钮点击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 处理按钮点击事件
                handleButtonClick();
            }
        });
    }

    // 加载题目
    private void loadQuestion(Question question) {
        radioButtonFragment.setQuestionAndLoad(questions.get(currentQuestionIndex));
        replaceFragment(radioButtonFragment);
    }

    // 替换 Fragment
    private void replaceFragment(RadioButtonFragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    // 初始化题目集合
    private void initQuestions() {
        Log.e("信息更新", "执行了");
        Question question=new Question();
        //题干
        question.setQuestionStem("1+1=");
        //选项
        question.setOptions(new String[]{"1","2","3"});
        //正确的答案
        question.setCorrectOptions("1");
        //题目类型
        //把题目添加到集合中
        questions.add(question);

        Question question2=new Question();
        //题干
        question2.setQuestionStem("2+2=？");
        //选项
        question2.setOptions(new String[]{"2","3","4"});
        //正确的答案
        question2.setCorrectOptions("2");
        //把题目添加到集合中
        questions.add(question2);

        Question question3=new Question();
        //题干
        question3.setQuestionStem("3+3=？");
        //选项
        question3.setOptions(new String[]{"3","5","9"});
        //正确的答案
        question3.setCorrectOptions("2");
        //把题目添加到集合中
        questions.add(question3);

        Question question4=new Question();
        //题干
        question4.setQuestionStem("4+4=?");
        //选项
        question4.setOptions(new String[]{"4","6","8"});
        //正确的答案
        question4.setCorrectOptions("2");
        //把题目添加到集合中
        questions.add(question4);

        Question question5=new Question();
        //题干
        question5.setQuestionStem("5+5=?");
        //选项
        question5.setOptions(new String[]{"5","10","20"});
        //正确的答案
        question5.setCorrectOptions("2");
        //把题目添加到集合中
        questions.add(question5);
    }

    // 处理按钮点击事件
    private void handleButtonClick() {
        Log.d("ButtonClicked", "Button clicked!");
        // 如果是提交按钮，获取答题结果并处理
        if (button.getText().equals("Submit")) {
            result = radioButtonFragment.getResult();
            // 更新分数
            if (result == 1) {
                score++;
            }
            nextQuestion();
        } else {
            // 如果是下一题按钮，加载下一题
            if (result == 1) {
                score++;
            }
            radioButtonFragment.clear();
            nextQuestion();
        }
    }

    // 加载下一题
    private void nextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {
            loadQuestion(questions.get(currentQuestionIndex));
            //replaceFragment(new RadioButtonFragment());
            // 更新按钮文本
            if (currentQuestionIndex == questions.size() - 1) {
                button.setText("submit");
            } else {
                button.setText("next");
            }
        } else {
            // 已经是最后一题，跳转到结果页面
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("score", score);
            intent.putExtra("totalQuestions", questions.size());
            startActivity(intent);
            finish();
        }
    }
}
