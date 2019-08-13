package com.example.helloworld_androidapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button; //ボタン
import android.widget.TextView; //テキスト

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private boolean flag = false; //ボタンの状態

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //activity_main.xmlファイルをレイアウトとして登録

        //ボタン設定
        Button button = findViewById(R.id.button); //レイアウトファイルからidがbuttonのものを見つけてくる
        //テキスト設定
        textView = findViewById(R.id.textView);

        //ボタンが押された時の処理
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(flag){
                    textView.setText(R.string.test);
                    textView.setTextColor(Color.RED);
                    flag = false;
                }else{
                    textView.setText(R.string.ok);
                    textView.setTextColor(Color.BLUE);
                    flag = true;
                }
            }
        });

    }
}
