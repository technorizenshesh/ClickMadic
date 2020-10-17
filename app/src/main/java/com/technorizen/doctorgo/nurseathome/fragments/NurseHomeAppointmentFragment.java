package com.technorizen.doctorgo.nurseathome.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.technorizen.doctorgo.R;

public class NurseHomeAppointmentFragment extends Fragment {



    public NurseHomeAppointmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_nurse_appointment, container, false);
    }


}
