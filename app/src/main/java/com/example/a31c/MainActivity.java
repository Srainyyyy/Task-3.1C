package com.example.a31c;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 找到开始按钮
        Button buttonStart = findViewById(R.id.buttonStart);
        // 为开始按钮设置点击事件监听器
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取用户输入的名字
                EditText editTextName = findViewById(R.id.editTextName);
                String name = editTextName.getText().toString();

                // 创建一个意图，跳转到问题活动，并附带用户名字数据
                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                intent.putExtra("USERNAME", name);
                startActivity(intent);
            }
        });
    }
}
