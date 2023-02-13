package com.android.example.wordlistsql;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchActivity extends AppCompatActivity {

    private TextView mTextView;
    private EditText mEditWordView;
    private WordListOpenHelper mDB;
    private Button search_button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mEditWordView = ((EditText)findViewById(R.id.search_word));
        mTextView = ((TextView) findViewById(R.id.search_result));
        mDB = new WordListOpenHelper(this);

        search_button = ((Button) findViewById(R.id.search_btn));
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showResult(view);
//                String word = mEditWordView.getText().toString();
//                boolean match= Pattern.matches("[\\s]", word);
//                if (match){
//                    showResult(view);
//                }else{
//                    mTextView.setText("No se admiten espacios en blanco");
//                }

            }
        });
    }

    public void showResult(View view){
        String word = mEditWordView.getText().toString();
        mTextView.setText("Result for " + word + ":\n\n");
        ArrayList<WordItem> words_list = mDB.search(word);
        for (int i = 0; i < words_list.size(); i++) {
            mTextView.append(words_list.get(i).getWord() + "\n");
        }
    }
}