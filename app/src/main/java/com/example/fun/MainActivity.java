package com.example.fun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textView);
        final TextView insertion = findViewById(R.id.editText2);
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = insertion.getText().toString();
                insertion.setText("");
                textView.setText(message);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        final TextView textView = findViewById(R.id.textView);
        outState.putString("my_text",textView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        final TextView textView = findViewById(R.id.textView);
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString("my_text"));
    }
}
