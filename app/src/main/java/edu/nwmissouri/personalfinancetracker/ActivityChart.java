package edu.nwmissouri.personalfinancetracker;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;


public class ActivityChart extends AppCompatActivity {

    private static final String TAG = "ActivityChart";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        // Hide the action bar (title bar)
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        findViewById(R.id.ivBack).setOnClickListener((View view) -> finish());
    }


}