package com.example.helloworld_androidapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button; //ボタン
import android.widget.LinearLayout;
import android.widget.TextView; //テキスト

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private boolean flag = false; //ボタンの状態

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //レイアウトファイルは呼ばない　アプリ起動中に変更できないため
        //setContentView(R.layout.activity_main); //activity_main.xmlファイルをレイアウトとして登録 静的

        //リニアレイアウトの設定
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL); //子ビューを追加する方向を垂直方向にする
        //横幅・縦幅の指定 画面いっぱい
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        layout.setGravity(Gravity.CENTER); // レイアウト中央寄せ
        setContentView(layout);


        //ボタン設定
        //Button button = findViewById(R.id.button); //レイアウトファイルからidがbuttonのものを見つけてくる
        Button button = new Button(this);
        button.setText(R.string.push);
        float scale = getResources().getDisplayMetrics().density; // dp単位を取得 画面解像度の比率
        int buttonWidth = (int)(150 * scale);
        //横幅・縦幅の指定　buttonWidth・必要なサイズ
        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(
                buttonWidth, LinearLayout.LayoutParams.WRAP_CONTENT);
        // マージン設定
        int margins = (int)(50 * scale);
        buttonLayoutParams.setMargins(margins, margins, margins, margins);

        button.setLayoutParams(buttonLayoutParams);
        layout.addView(button);

        //テキスト設定
        //textView = findViewById(R.id.textView);
        textView = new TextView(this);
        textView.setText(R.string.hello);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30); // テキストサイズ 30sp
        textView.setTextColor(Color.rgb(0x0, 0x0, 0x0)); // テキストカラー
        //横幅・縦幅の指定　必要なサイズ
        LinearLayout.LayoutParams textLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(textLayoutParams);
        layout.addView(textView);

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
