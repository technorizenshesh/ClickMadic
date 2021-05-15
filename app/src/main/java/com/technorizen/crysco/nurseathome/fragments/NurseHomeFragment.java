package com.technorizen.crysco.nurseathome.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.FragmentNurseHomeBinding;
import com.technorizen.crysco.nurseathome.activities.LoadNurseHomeActivity;

public class NurseHomeFragment extends Fragment {

    Context mContext;
    FragmentNurseHomeBinding binding;

    public NurseHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_nurse_home, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            getActivity().finish();
        });

        binding.ivNurseNearby.setOnClickListener(v -> {
            ((LoadNurseHomeActivity)getActivity()).loadFragment(new NurseTimeSlotFragment());
        });

        binding.ivNurseNearb2.setOnClickListener(v -> {
            ((LoadNurseHomeActivity)getActivity()).loadFragment(new NurseTimeSlotFragment());
        });

        binding.ivNurseNearb1.setOnClickListener(v -> {
            ((LoadNurseHomeActivity)getActivity()).loadFragment(new NurseTimeSlotFragment());
        });

        binding.contactNurse1.setOnClickListener(v -> {
            ((LoadNurseHomeActivity)getActivity()).loadFragment(new NurseTimeSlotFragment());
        });

        binding.contactNurse2.setOnClickListener(v -> {
            ((LoadNurseHomeActivity)getActivity()).loadFragment(new NurseTimeSlotFragment());
        });

    }


}
