package com.example.a31c;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // 获取上一个 Activity 传递的数据
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0); // 获取分数，默认为 0
        int totalQuestions = intent.getIntExtra("totalQuestions", 0); // 获取总题数，默认为 0

        // 根据分数和总题数计算正确率
        int correctRate = (int) ((float) score / totalQuestions * 100);

        // 显示分数和正确率
        TextView textViewScore = findViewById(R.id.textViewScore);
        textViewScore.setText("得分: " + score + " / " + totalQuestions);

    }
}
