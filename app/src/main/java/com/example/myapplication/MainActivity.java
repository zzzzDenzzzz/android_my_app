package com.example.myapplication;

import static com.example.myapplication.StringConst.EMPTY_STRING;
import static com.example.myapplication.StringConst.ENTER_EMAIL;
import static com.example.myapplication.StringConst.ENTER_NAME;
import static com.example.myapplication.StringConst.FORM_SUBMITTED_SUCCESSFULLY;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameEditText = findViewById(R.id.nameEditText_id);
        EditText emailEditText = findViewById(R.id.emailEditText_id);
        Button submitButton = findViewById(R.id.submitButton_id);

        submitButton.setOnClickListener(view -> {
            String name = getString(nameEditText);
            String email = getString(emailEditText);

            if (TextUtils.isEmpty(name)) {
                showToast(ENTER_NAME);
            } else if (TextUtils.isEmpty(email)) {
                showToast(ENTER_EMAIL);
            } else {
                showToast(FORM_SUBMITTED_SUCCESSFULLY);
                clearFieldsForm(nameEditText, emailEditText);
            }
        });
    }

    private void clearFieldsForm(EditText ...texts) {
        for (EditText text : texts) {
            text.setText(EMPTY_STRING);
        }
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    private @NonNull String getString(EditText text) {
        return text.getText().toString().trim();
    }
}