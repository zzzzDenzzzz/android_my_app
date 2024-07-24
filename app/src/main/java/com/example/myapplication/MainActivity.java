package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String ENTER_NAME = "Введите имя";
    public static final String ENTER_EMAIL = "Введите email";
    public static final String FORM_SUBMITTED_SUCCESSFULLY = "Форма успешно отправлена";
    public static final String EMPTY_STRING = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameEditText = getView(R.id.nameEditText);
        EditText emailEditText = getView(R.id.emailEditText);
        Button submitButton = getView(R.id.submitButton);

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

    private <T extends View> T getView(int id) {
        return findViewById(id);
    }

    private @NonNull String getString(EditText text) {
        return text.getText().toString().trim();
    }
}