package com.technorizen.doctorgo.insurance.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.doctorgo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppMadeInsuranceFragment extends Fragment {


    public AppMadeInsuranceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_app_made_insurance, container, false);
    }


}
