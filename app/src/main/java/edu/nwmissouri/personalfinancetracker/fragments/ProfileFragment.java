package edu.nwmissouri.personalfinancetracker.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import edu.nwmissouri.personalfinancetracker.Manager.DatabaseManager;
import edu.nwmissouri.personalfinancetracker.R;

public class ProfileFragment extends Fragment {

    // Required empty public constructor for fragment
    public ProfileFragment() {
        //empty body
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize your database class

        // Find the TextView elements in your layout
        TextView firstNameTextView = rootView.findViewById(R.id.textFirstName);
        TextView lastNameTextView = rootView.findViewById(R.id.textLastName);
        TextView emailTextView = rootView.findViewById(R.id.textEmail);
        TextView mobileTextView = rootView.findViewById(R.id.textMobile);

        // Set the text for each TextView with data from your database
        firstNameTextView.setText(DatabaseManager.getInstance().getFirstName());
        lastNameTextView.setText(DatabaseManager.getInstance().getLastName());
        emailTextView.setText(DatabaseManager.getInstance().getEmail());
        mobileTextView.setText(DatabaseManager.getInstance().getMobile());

        // Returning the inflated view
        return rootView;
    }
}
