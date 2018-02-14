package com.example.apple.week5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt1,bt2;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       bt1 = (Button)findViewById(R.id.button1);
       bt2 = (Button)findViewById(R.id.button2);
       et1 = (EditText)findViewById(R.id.editText1);

       final Context context = getApplicationContext();

       final SharedPreferences sh = getSharedPreferences("YutShared",context.MODE_PRIVATE);
       final SharedPreferences.Editor editor = sh.edit();
       editor.putInt("highScore",0);
       editor.commit();

       bt1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               int inputScore = Integer.parseInt(et1.getText().toString());
               int currentScore = sh.getInt("highScore", -1);

               if (inputScore > currentScore) {
                   Toast t = Toast.makeText(context, "High score = " + inputScore, Toast.LENGTH_LONG);
                   t.show();
                   editor.putInt("HighScore", inputScore);
                   editor.commit();

               } else {
                   Toast t = Toast.makeText(context, "No new score", Toast.LENGTH_LONG);
                   t.show();
               }
           }
       });
       bt2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(),Activity2.class);
               startActivity(intent);
           }
       });
    }
}
