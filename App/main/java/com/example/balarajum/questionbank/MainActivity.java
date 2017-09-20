package com.example.balarajum.questionbank;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button true_btn,false_btn,next_btn,prev_btn;
    private TextView quesitonText;

    private QuestionBank[] myquestions = new QuestionBank[]{
            new QuestionBank(R.string.q1,true),
            new QuestionBank(R.string.q2,false),
            new QuestionBank(R.string.q3,false),
            new QuestionBank(R.string.q3,false),
            new QuestionBank(R.string.q4,true),
            new QuestionBank(R.string.q5,true),
            new QuestionBank(R.string.q6,true),
            new QuestionBank(R.string.q7,false),
            new QuestionBank(R.string.q8,true),
            new QuestionBank(R.string.q9,false),
            new QuestionBank(R.string.q10,true),

    };
    private int currentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quesitonText= (TextView) findViewById(R.id.questn);
        updateQuestion();
        true_btn = (Button) findViewById(R.id.true_btn);
        false_btn = (Button) findViewById(R.id.false_btn);
        next_btn= (Button) findViewById(R.id.next_btn);
        true_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Correct",Toast.LENGTH_SHORT).show();
            }
        });
        false_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Incorrect",Toast.LENGTH_SHORT).show();
            }
        });
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentIndex < myquestions.length){
                    currentIndex = currentIndex +1;
                    updateQuestion();
                }else{
                    currentIndex = myquestions.length-currentIndex;
                    updateQuestion();
                }

            }
        });

    }
    private void updateQuestion(){
        int question = myquestions[currentIndex].getQuestion();
        quesitonText.setText(question);
    }

}
