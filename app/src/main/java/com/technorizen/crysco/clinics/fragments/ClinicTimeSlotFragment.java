package com.technorizen.crysco.clinics.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.FragmentClinicTimeSlotBinding;
import com.technorizen.crysco.onlinedoctors.activities.BookTestPacakgesOnlineActivity;

public class ClinicTimeSlotFragment extends Fragment {

    Context mContext;
    FragmentClinicTimeSlotBinding binding;

    public ClinicTimeSlotFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_clinic_time_slot, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            getFragmentManager().popBackStack();
        });

        binding.btNext.setOnClickListener(v -> {
            startActivity(new Intent(mContext, BookTestPacakgesOnlineActivity.class));
        });

    }


}
