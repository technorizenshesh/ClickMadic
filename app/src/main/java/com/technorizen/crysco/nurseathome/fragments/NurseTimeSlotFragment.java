package com.technorizen.crysco.nurseathome.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.FragmentNurseTimeSlotBinding;
import com.technorizen.crysco.nurseathome.activities.LoadNurseHomeActivity;

public class NurseTimeSlotFragment extends Fragment {

    Context mContext;
    FragmentNurseTimeSlotBinding binding;

    public NurseTimeSlotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_nurse_time_slot, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            getFragmentManager().popBackStack();
        });

        binding.btNext.setOnClickListener(v -> {
            ((LoadNurseHomeActivity)getActivity()).loadFragment(new TimeSlotsWithNurseProfileFragment());
        });

    }


}
