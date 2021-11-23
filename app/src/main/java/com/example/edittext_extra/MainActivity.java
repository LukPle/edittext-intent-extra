package com.example.edittext_extra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This Activity creates a Log In Screen.
 * The user can type in an email and a password.
 * Clicking the Button will take the user to the HomeActivity.
 * The Intent will take the user input as an extra.
 *
 * Layout File: activity_main.xml
 *
 * @author Lukas Plenk
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // These are variables that are used for referencing an extra in an intent
    public static final String EXTRA_EMAIL = "com.example.edittext_extra.EXTRA_EMAIL";
    public static final String EXTRA_PASSWORD = "com.example.edittext_extra.EXTRA_PASSWORD";

    private EditText email;
    private EditText password;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.edit_email);
        password = findViewById(R.id.edit_password);

        loginButton = findViewById(R.id.button_login);
        loginButton.setOnClickListener(this);
    }

    /**
     * The method checks if the user has completed all EditText fields.
     * There is a helpful Toast Message if the input is not complete.
     * The input gets packed into the extras of an intent.
     * This intent leads to the HomeActivity.
     * @param view is a specific UI element that was clicked on.
     */
    @Override
    public void onClick(View view) {

        if(email.getText().toString().trim().isEmpty() || password.getText().toString().trim().isEmpty()) {

            Toast.makeText(this, "Please insert all information", Toast.LENGTH_LONG).show();
        }
        else {

            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            intent.putExtra(EXTRA_EMAIL, email.getText().toString());
            intent.putExtra(EXTRA_PASSWORD, password.getText().toString());
            startActivity(intent);
        }
    }
}