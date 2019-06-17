package com.example.threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import
import android.view.View ;
import android.widget.TextView ;
import android.os.Handler ;
import android.os.Message ;


public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            TextView buckyText = (TextView) findViewById(R.id.buckyText);
            buckyText.setText("Nice Job !");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // understand this method

    public void clickBuckyButton(View view){

        Runnable r  = new Runnable() {
            @Override
            public void run() {

                //current time add + 10 thousand and store in futuretime variable
                long futuretime = System.currentTimeMillis() + 10000 ;
                // this while loop is run when the futuretime is ture when the system time is is grater then the future time condition is false
                while (System.currentTimeMillis() < futuretime){
                    synchronized (this){
                        try{
                            wait(futuretime-System.currentTimeMillis());

                        }catch (Exception e){

                        }
                    }
                }
                handler.sendEmptyMessage(0);
            }
        };
        Thread buckyThread = new Thread(r);
        buckyThread.run();
    }
}