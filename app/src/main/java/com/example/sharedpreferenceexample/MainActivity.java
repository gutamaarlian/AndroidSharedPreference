package com.example.sharedpreferenceexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("SP", MODE_PRIVATE);
        String input = sharedPreferences.getString("input", "");
        inputText = findViewById(R.id.inp_textSharedPreference);
        inputText.setText(input);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        inputText = findViewById(R.id.inp_textSharedPreference);
        String input = inputText.getText().toString();
        myEdit.putString("input", input);
        myEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String input = sharedPreferences.getString("input", "");
        inputText = findViewById(R.id.inp_textSharedPreference);
        inputText.setText(input);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
            Log.d("nilai", savedInstanceState.getString("nilai"));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("nilai", "kena");
        outState.putString("nilai", "hai");
    }
}