package com.technorizen.crysco.insurance.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.crysco.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewInsuranceAppFragment extends Fragment {


    public NewInsuranceAppFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_insurance_app, container, false);

    }

}
