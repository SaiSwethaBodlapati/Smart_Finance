package edu.nwmissouri.personalfinancetracker.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import edu.nwmissouri.personalfinancetracker.ActivityChart;
import edu.nwmissouri.personalfinancetracker.Manager.DatabaseManager;
import edu.nwmissouri.personalfinancetracker.R;
import edu.nwmissouri.personalfinancetracker.helper.AlertHelper;

public class SalaryFragment extends Fragment {

    public SalaryFragment() {
        // Need empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_salary, container, false);

        Button viewExpensesButton = rootView.findViewById(R.id.viewExpenses);


// Get the respective amounts from DatabaseManager
        int rdAmount = DatabaseManager.getInstance().getRD();
        int fdAmount = DatabaseManager.getInstance().getFD();
        int stocksAmount = DatabaseManager.getInstance().getStocks();

// Set the text for each TextView


        viewExpensesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActivityChart.class);
                startActivity(intent);
            }
        });



        return rootView;
    }
}

