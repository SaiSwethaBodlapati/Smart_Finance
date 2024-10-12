package edu.nwmissouri.personalfinancetracker.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.nwmissouri.personalfinancetracker.R;
import edu.nwmissouri.personalfinancetracker.adapter.ExpenseAdapter;
import edu.nwmissouri.personalfinancetracker.adapter.ExpenseItem;

public class ExpensesFragment extends Fragment {

    // Define your dummy expense data
    private List<ExpenseItem> expenseList = new ArrayList<>();

    // Define RecyclerView and adapter
    private RecyclerView recyclerView;
    private ExpenseAdapter expenseAdapter;

    public ExpensesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_expenses, container, false);

        // Initialize RecyclerView
        recyclerView = rootView.findViewById(R.id.recyclerViewExpenses);
      recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Create and set the adapter
        expenseAdapter = new ExpenseAdapter(expenseList);
        recyclerView.setAdapter(expenseAdapter);


        // Initialize the list only once
        if (expenseList.isEmpty()) {
            expenseList.add(new ExpenseItem("Grocery", "$0", "2024-10-11"));
            expenseList.add(new ExpenseItem("Dining Out", "$0", "2024-10-11"));
            expenseList.add(new ExpenseItem("Transportation", "$0", "2024-10-11"));
            expenseList.add(new ExpenseItem("Utilities", "$0", "2024-10-11"));
            expenseList.add(new ExpenseItem("Entertainment", "$0", "2024-10-11"));
            expenseList.add(new ExpenseItem("Healthcare", "$0", "2024-10-11"));
            expenseList.add(new ExpenseItem("Shopping", "$0", "2024-10-11"));
            expenseList.add(new ExpenseItem("Education", "$0", "2024-10-11"));
            expenseList.add(new ExpenseItem("Travel", "$0", "2024-10-11"));
            expenseList.add(new ExpenseItem("Insurance", "$0", "2024-10-11"));
            expenseList.add(new ExpenseItem("Home", "$0", "2024-10-11"));
            expenseList.add(new ExpenseItem("Gifts", "$0", "2024-10-11"));
            expenseList.add(new ExpenseItem("Miscellaneous", "$0", "2024-10-11"));
            // Add more initial dummy data as needed
        }  // Add more dummy data as needed

        return rootView;
    }
}
