package com.example.jerry2001.activitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent caller = getIntent();
        Bundle mystuff = caller.getBundleExtra("pack");
        String result = mystuff.getString("result");
        String tempx = result;
        result = "";
        for(int i = 0; i < tempx.length(); ++i){
            if(tempx.charAt(i) != ' ') result += tempx.charAt(i);
        }
        String ac = mystuff.getString("AC");
        TextView temp = (TextView)findViewById(R.id.textView4);
        temp.setText(result);
        temp = (TextView)findViewById(R.id.textView6);
        temp.setText(ac);
        temp = (TextView)findViewById(R.id.textView7);
        temp.setText("AC");
    }
}
