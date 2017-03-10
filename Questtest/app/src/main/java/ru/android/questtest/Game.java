package ru.android.questtest;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;


public class Game extends AppCompatActivity {

    String answer;
    String text="";
    String nlog="Logs";
    Button ans1;
    Button ans2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button ans1 = (Button)findViewById(R.id.ans1);
        Button ans2 = (Button)findViewById(R.id.ans2);
        ans1.setText("Ответ №1");
        ans2.setText("Ответ №2");
        final TextView message = (TextView)findViewById(R.id.textView);

        View.OnClickListener check = new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
             switch (v.getId()){
                 case R.id.ans1:
                     if(answer==null) {answer="1";text=read(answer)+"\n\n";}
                     else {answer=answer+"1";text=text+read(answer)+"\n\n";}
                     message.setText(text);
                     break;
                 case R.id.ans2:
                     if(answer==null) {answer="2";text=read(answer)+"\n\n";}
                     else {answer=answer+"2";text=text+read(answer)+"\n\n";}
                     message.setText(text);
                     break;
             }
            }
        };
        ans1.setOnClickListener(check);
        ans2.setOnClickListener(check);
    }
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        String read(String answer){
            String t = null;
            int i=0;
            int n=0;
            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("Scenario.txt")));
                String str = "";
                while ((str=br.readLine())!=null){
                    Log.d(nlog,answer+";"+str);
                    Log.d(nlog,"t="+t);
                    if (i!=0){
                        Log.d(nlog,"i<>0");
                        if (n==0) t=str;
                        if (n!=0) t=t+str;
                        n=n+1;
                    }
                    if (Objects.equals(str, answer)) {i=i+1;Log.d(nlog,"i+1");}
                    if (str.length()==0) {i=0;n=0;Log.d(nlog,"Empty str");}

                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return t;
        }

}
