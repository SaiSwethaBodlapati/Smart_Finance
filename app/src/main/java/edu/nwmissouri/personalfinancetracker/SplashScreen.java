package edu.nwmissouri.personalfinancetracker;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import edu.nwmissouri.personalfinancetracker.auth.LoginActivity;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Hide the action bar (title bar)
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        animateLogo();
        new Handler(Looper.getMainLooper()).postDelayed(this::handleNavigation, 3000);
    }

    private void animateLogo() {


        AlphaAnimation anim = new AlphaAnimation(1.0f, 0.3f);
        anim.setRepeatCount(Animation.INFINITE);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setDuration(1000);
        findViewById(R.id.rlContainer).setAnimation(anim); // to start animation
    }

    private void handleNavigation() {

        startActivity(new Intent(SplashScreen.this, LoginActivity.class));

//        if ( getCurrentUser() == null) {
//            startActivity(new Intent(SplashScreen.this, LoginActivity.class));
//        }else {
//            startActivity(new Intent(SplashScreen.this, MainActivity.class));
//        }
        finish();
    }


}