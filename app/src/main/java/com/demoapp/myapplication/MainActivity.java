package com.demoapp.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views by their IDs
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        MaterialButton loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        // Find ImageViews by their IDs
        ImageView fbImageView = findViewById(R.id.fb);
        ImageView githubImageView = findViewById(R.id.github);
        ImageView gmailImageView = findViewById(R.id.gmail);

        // Set OnClickListener for Facebook image
        fbImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite("https://www.facebook.com/");
            }
        });

        // Set OnClickListener for GitHub image
        githubImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite("https://github.com/");
            }
        });

        // Set OnClickListener for Gmail image
        gmailImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite("https://mail.google.com/");
            }
        });

        // You can set click listeners for other buttons or views here if needed
    }

    private void login() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (isValidCredentials(email, password)) {
            showToast("Login successful!");
            // Add additional logic for successful login, such as navigating to another activity
        } else {
            showToast("Invalid credentials. Please try again.");
        }
    }

    private boolean isValidCredentials(String email, String password) {
        // Add your authentication logic here
        // For simplicity, this example always returns true
        return true;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void openWebsite(String url) {
        // Create an Intent to open a web page
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
