package com.technorizen.doctorgo.labathome.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.technorizen.doctorgo.R;


public class AppointmentsMadeFragmentLab extends Fragment {


    public AppointmentsMadeFragmentLab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_appointments_made_fragment_lab, container, false);

    }


}
