package edu.nwmissouri.personalfinancetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import edu.nwmissouri.personalfinancetracker.auth.LoginActivity;
import edu.nwmissouri.personalfinancetracker.fragments.ExpensesFragment;
import edu.nwmissouri.personalfinancetracker.fragments.ProfileFragment;
import edu.nwmissouri.personalfinancetracker.fragments.SalaryFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

//MaiActivity inherits AppCompatActivity 
public class MainActivity extends AppCompatActivity {

    //Declaration of Fragments to be used
    private Fragment salaryFragment;
    private Fragment expensesFragment;
    private Fragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize fragments
        salaryFragment = new SalaryFragment();
        expensesFragment = new ExpensesFragment();
        profileFragment = new ProfileFragment();

        // Hide the action bar (title bar)
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Initialize and set up the BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.menu_salary) {
                loadFragment(salaryFragment);
                return true;
            } else if (itemId == R.id.menu_expenses) {
                loadFragment(expensesFragment);
                return true;
            } else if (itemId == R.id.menu_profile) {
                loadFragment(profileFragment);
                return true;
            }
            return false;
        });


        // Set the initial fragment
        loadFragment(salaryFragment);

        setupViews();
    }
    
    // Load the specified fragment into the fragment container
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        fragmentTransaction.commit();
    }

    private void setupViews() {
       // findViewById(R.id.ivLogout).setOnClickListener(this::onClickOnLogout);
    }

    private void onClickOnLogout(View v) {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}
