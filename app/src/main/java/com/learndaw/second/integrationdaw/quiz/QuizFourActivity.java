package com.learndaw.second.integrationdaw.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.learndaw.second.integrationdaw.activities.GifActivity;
import com.learndaw.second.integrationdaw.fragment.LevelsActivity;
import com.learndaw.second.integrationdaw.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class QuizFourActivity extends AppCompatActivity {

    private QuestionsIVLibrary nQuestionLibrary4 = new QuestionsIVLibrary();
    private TextView nScoreView;
    private TextView nQuestionView;
    private Button nButtonChoice1;
    private Button nButtonChoice2;
    private Button nButtonChoice3;
    private Button nButtonQuit;
    private String nAnswer;
    private int nScore = 0;
    private int nQuestionNumber = 0;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private DatabaseReference myRef = database.getReference().child("Units").child(user.getUid());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_four);

        nScoreView = (TextView)findViewById(R.id.tv_score_count);
        nQuestionView = (TextView)findViewById(R.id.tv_question);
        nButtonChoice1 = (Button)findViewById(R.id.bt_choice1);
        nButtonChoice2 = (Button)findViewById(R.id.bt_choice2);
        nButtonChoice3 = (Button)findViewById(R.id.bt_choice3);
        nButtonQuit = (Button)findViewById(R.id.bt_exit);
        updateQuestion();
//Star of Button Listener for Button1
        nButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// My logic for Button goes in here
                if (nButtonChoice1.getText() == nAnswer){
                    nScore = nScore + 1;
                    updateScore(nScore);
                    updateQuestion();
// This Line is opcional
                    Toast.makeText(QuizFourActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(QuizFourActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
// End of Button Listener for Button 1
//Star of Button Listener for Button2
        nButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// My logic for Button goes in here
                if (nButtonChoice2.getText() == nAnswer){
                    nScore = nScore + 1;
                    updateScore(nScore);

                    updateQuestion();
                    Toast.makeText(QuizFourActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(QuizFourActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
// End of Button Listener for Button 2
//Star of Button Listener for Button3
        nButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// My logic for Button goes in here
                if (nButtonChoice3.getText() == nAnswer){
                    nScore = nScore + 1;
                    updateScore(nScore);
                    updateQuestion();
                    Toast.makeText(QuizFourActivity.this, "Correcto", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(QuizFourActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
// End of Button Listener for Button 3
// Star of Button Listener for Button Quit
        nButtonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLevel = new Intent(QuizFourActivity.this, LevelsActivity.class);
                startActivity(intentLevel);
            }
        });
    }
    private void updateQuestion(){

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("unit_four", nScore);
        myRef.updateChildren(childUpdates);
        if(nQuestionNumber==10) {
            finishQuiz();
        }else {
            nQuestionView.setText(nQuestionLibrary4.getQuestion(nQuestionNumber));
            nButtonChoice1.setText(nQuestionLibrary4.getChoices1(nQuestionNumber));
            nButtonChoice2.setText(nQuestionLibrary4.getChoices2(nQuestionNumber));
            nButtonChoice3.setText(nQuestionLibrary4.getChoices3(nQuestionNumber));
            nAnswer = nQuestionLibrary4.getCorrectAnswer(nQuestionNumber);
            nQuestionNumber ++;
        }
    }
    private void finishQuiz() {
        if (nScore>=8){
            Intent intentGif = new Intent(QuizFourActivity.this, GifActivity.class);
            startActivity(intentGif);
        }else {
            Intent intentLevels = new Intent(QuizFourActivity.this, LevelsActivity.class);
            startActivity(intentLevels);
        }
    }
    private void updateScore(int point){
        nScoreView.setText(""+nScore);
    }
}
