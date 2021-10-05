package com.example.runnable_kronometre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int number;
    Runnable runnable;
    Handler handler;
    Button button;
    Button button2;
    Button button3;
    Button button4;
    int number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number=0;

        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);

        button.setEnabled(true);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);

    }
    public void basla(View view){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                textView.setText("Time:"+number);
                number++;
                textView.setText("Time:"+number);
                handler.postDelayed(runnable,1000);//1000 milisaniye. her 1 saniyede yukarıdaki işlemi yap
                number2=number;

            }
        };
        handler.post(runnable);
        button.setEnabled(false);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(false);

    }
    public void durdur(View view){
        button2.setEnabled(false);
        button4.setEnabled(true);
        handler.removeCallbacks(runnable);
        textView.setText("Time:"+number2);


    }
    public void sifirla(View view){
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button.setEnabled(true);
        handler.removeCallbacks(runnable);//arkada çalışan runnable kapadık
        number=0;
        textView.setText("Time:"+number);

    }
    public void devamEt(View view){
        button4.setEnabled(false);
        button.setEnabled(false);
        button2.setEnabled(true);
        button3.setEnabled(true);

        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                textView.setText("Time:"+number2);
                number2++;
                textView.setText("Time:"+number2);
                handler.postDelayed(runnable,1000);//1000 milisaniye. her 1 saniyede yukarıdaki işlemi yap

            }
        };
        handler.post(runnable);

    }
}