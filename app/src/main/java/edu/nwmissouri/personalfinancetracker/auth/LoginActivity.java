package edu.nwmissouri.personalfinancetracker.auth;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.nwmissouri.personalfinancetracker.MainActivity;
import edu.nwmissouri.personalfinancetracker.Manager.DatabaseManager;
import edu.nwmissouri.personalfinancetracker.R;
import edu.nwmissouri.personalfinancetracker.helper.AlertHelper;
import edu.nwmissouri.personalfinancetracker.helper.Utils;


public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Hide the action bar (title bar)
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        findViewById(R.id.rlSignUp).setOnClickListener(this::onClickOnSignUp);
        findViewById(R.id.btnLogin).setOnClickListener(this::onClickOnLogin);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        findViewById(R.id.btnForgotPassword).setOnClickListener(this::onClickOnResetPassword);
        findViewById(R.id.ivShowPassword).setOnClickListener(view -> onClickOnShowPassword(etPassword, (ImageView) view));
    }

    private void onClickOnSignUp(View v) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    private void onClickOnShowPassword(EditText editText, ImageView imageView) {
        if (editText.getInputType() == 129) {
            editText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            imageView.setImageDrawable(getDrawable(R.drawable.ic_hide_password));
        }else {
            editText.setInputType(129);
            imageView.setImageDrawable(getDrawable(R.drawable.ic_show_password));
        }
        editText.setSelection(editText.length());
    }

    private void onClickOnLogin(View v) {

        handleLogin(etEmail.getText().toString(), etPassword.getText().toString());
    }

    private void onClickOnResetPassword(View v) {

    }

    private void handleLogin(String email, String password) {


        if (isEmailValid(email) && isPasswordValid(password)) {
            // Your login logic here
            DatabaseManager.getInstance().setEmail(email);

            startActivity(new Intent(LoginActivity.this, MainActivity.class));

            finish();
        } else {
            // Show alerts for invalid email or empty password
            if (!isEmailValid(email)) {
                AlertHelper.showOkAlert(this, "Invalid Email", "Please enter a valid email address.");
            }else
            if (!isPasswordValid(password)) {
                AlertHelper.showOkAlert(this, "Empty Password", "Please enter your password.");
            }
        }

    }


    private boolean isEmailValid(String email) {
        if (!Utils.isValidEmail(email)) {
            return  false;
        }else {
            return true;
        }
    }

    private boolean isPasswordValid(String password) {
        // Add your password validation logic here
        return !password.isEmpty(); // Simple check for non-empty password
    }
}