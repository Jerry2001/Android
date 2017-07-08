package com.example.jerry2001.activitydemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int a[] = new int[20];
    int b[] = new int[20];
    int one = 0;
    int mistake = 0;
    int mis1[] = new int[20];
    int swit = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean bl = false;
        Button close = (Button)findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Exit");
                alert.setMessage("Exit or Not");
                alert.setPositiveButton("Yah", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Bye", 2 ).show();
                        finish();
                    }
                });
                alert.setNegativeButton("Nah", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Ok", 2 ).show();
                        dialog.cancel();
                    }
                });
                alert.create().show();
            }
        });
    }
    public void randx(View view){
        Random rand = new Random();
        int n = rand.nextInt(15) + 1;
        String s ="";
        for(int i = 0; i < n; ++i){
            a[i] = rand.nextInt(3)+1;
            if(a[i] == 0) ++one;
            b[i] = a[i];
            s = s + a[i] + " " + '\n';
        }
        Arrays.sort(b, 0, n - 1);
        one = 0;
        for(int i = 0; i < n; ++i){
            if(a[i] == 1 && a[i] != b[i]){
                mis1[one] = i;
                ++one;
            }
        }
        for(int i = 0; i < one; ++i){
            boolean bl = true;
            int onepos = -1;
            for(int j = 0; j < one; ++j){
                int pos = mis1[i];
                if(onepos == -1 && a[j] != 1){
                    onepos = j;
                }
                if(a[j] != 1 && b[pos] == a[j]){
                    int tempx = a[j];
                    a[j] = a[pos];
                    a[pos] = tempx;
                    ++swit;
                    bl =false;
                    break;
                }
            }
        }
        TextView numarr = (TextView)findViewById(R.id.textView2);
        numarr.setText(s);
    }
    public void sub(View view){
        String sa = "Huhu, bài này em giải bằng C++ rồi nhưng em chưa viết kịp code java :'< em demo chuyển dữ liệu với mấy vòng đời thôi :'(";
        EditText editText = (EditText)findViewById(R.id.editText);
        String s = editText.getText().toString();
        Intent intent = new Intent(MainActivity.this, result.class);
        Bundle bundle = new Bundle();
        bundle.putString("result", s);
        bundle.putString("AC", sa);
        intent.putExtra("pack", bundle);
        startActivity(intent);
    }
}
