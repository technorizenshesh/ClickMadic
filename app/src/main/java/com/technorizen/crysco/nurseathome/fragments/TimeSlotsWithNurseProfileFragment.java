package com.technorizen.crysco.nurseathome.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.FragmentTimeSlotsWithNurseProfileBinding;
import com.technorizen.crysco.nurseathome.activities.LoadNurseHomeActivity;

public class TimeSlotsWithNurseProfileFragment extends Fragment {

    Context mContext;
    FragmentTimeSlotsWithNurseProfileBinding binding;

    public TimeSlotsWithNurseProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_time_slots_with_nurse_profile, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {
        binding.tvTimes.setOnClickListener(v -> {
            ((LoadNurseHomeActivity)getActivity()).loadFragment(new NursePaymentFragment());
        });
    }


}
