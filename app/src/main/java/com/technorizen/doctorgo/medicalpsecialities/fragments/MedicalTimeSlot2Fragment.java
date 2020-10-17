package com.technorizen.doctorgo.medicalpsecialities.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.FragmentMedicalTimeSlot2Binding;
import com.technorizen.doctorgo.onlinedoctors.activities.BookTestPacakgesOnlineActivity;

public class MedicalTimeSlot2Fragment extends Fragment {

    Context mContext;
    FragmentMedicalTimeSlot2Binding binding;

    public MedicalTimeSlot2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_medical_time_slot2, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            getFragmentManager().popBackStack();
        });

        binding.btContinue.setOnClickListener(v -> {
           startActivity(new Intent(mContext, BookTestPacakgesOnlineActivity.class));
        });

    }


}
