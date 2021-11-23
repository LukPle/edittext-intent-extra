package com.example.edittext_extra;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This Activity gets the email and password as extras from the previous Activity.
 * Those values get shown as TextViews.
 *
 * Layout File: activity_home.xml
 */
public class HomeActivity extends AppCompatActivity {

    private TextView yourEmail;
    private TextView yourPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        yourEmail = findViewById(R.id.your_email);
        yourPassword = findViewById(R.id.your_password);

        Intent intent = getIntent();

        yourEmail.setText("E-Mail: " +intent.getStringExtra(MainActivity.EXTRA_EMAIL));
        yourPassword.setText("Password: " +intent.getStringExtra(MainActivity.EXTRA_PASSWORD));
    }
}