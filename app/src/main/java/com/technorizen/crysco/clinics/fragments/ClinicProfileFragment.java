package com.technorizen.crysco.clinics.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.technorizen.crysco.R;
import com.technorizen.crysco.clinics.activities.LoadClinicActivity;
import com.technorizen.crysco.databinding.FragmentClinicProfileBinding;

public class ClinicProfileFragment extends Fragment {

    Context mContext;
    FragmentClinicProfileBinding binding;

    public ClinicProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_clinic_profile, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            getActivity().finish();
        });

        binding.btBook.setOnClickListener(v -> {
            ((LoadClinicActivity)getActivity()).FragTras(new ClinicTimeSlotFragment());
        });

        binding.tvBook1.setOnClickListener(v -> {
            ((LoadClinicActivity)getActivity()).FragTras(new ClinicTimeSlotFragment());
        });

        binding.tvBook2.setOnClickListener(v -> {
            ((LoadClinicActivity)getActivity()).FragTras(new ClinicTimeSlotFragment());
        });


    }

}
