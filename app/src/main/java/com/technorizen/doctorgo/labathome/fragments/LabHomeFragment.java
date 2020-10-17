package com.technorizen.doctorgo.labathome.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.FragmentLabHomeBinding;
import com.technorizen.doctorgo.labathome.activities.LoadLabAtHomeActivity;

public class LabHomeFragment extends Fragment {

    Context mContext;
    FragmentLabHomeBinding binding;

    public LabHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_lab_home, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            getActivity().finish();
        });

        binding.cvdoctor1.setOnClickListener(v -> {
            ((LoadLabAtHomeActivity)getActivity()).FragTras(new LabDetailFragment());
        });

        binding.cvClinicProfile1.setOnClickListener(v -> {
            ((LoadLabAtHomeActivity)getActivity()).FragTras(new LabDetailFragment());
        });

        binding.cvClinicProfile2.setOnClickListener(v -> {
            ((LoadLabAtHomeActivity)getActivity()).FragTras(new LabDetailFragment());
        });

        binding.cvdoctor2.setOnClickListener(v -> {
            ((LoadLabAtHomeActivity)getActivity()).FragTras(new LabDetailFragment());
        });

        binding.cvdoctor3.setOnClickListener(v -> {
            ((LoadLabAtHomeActivity)getActivity()).FragTras(new LabDetailFragment());
        });

        binding.ivDoctorNearb1.setOnClickListener(v -> {
            ((LoadLabAtHomeActivity)getActivity()).FragTras(new LabDetailFragment());
        });

        binding.ivDoctorNearb2.setOnClickListener(v -> {
            ((LoadLabAtHomeActivity)getActivity()).FragTras(new LabDetailFragment());
        });

        binding.ivDoctorNearby.setOnClickListener(v -> {
            ((LoadLabAtHomeActivity)getActivity()).FragTras(new LabDetailFragment());
        });

        binding.contactClinic1.setOnClickListener(v -> {
            ((LoadLabAtHomeActivity)getActivity()).FragTras(new LabDetailFragment());
        });

        binding.contactClinic2.setOnClickListener(v -> {
            ((LoadLabAtHomeActivity)getActivity()).FragTras(new LabDetailFragment());
        });

    }


}
