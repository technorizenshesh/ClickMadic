package com.technorizen.doctorgo.medicalpsecialities.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ProfilePart2FragmentBinding;
import com.technorizen.doctorgo.medicalpsecialities.activities.LoadMedicalActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class profile_part2_fragment extends Fragment {

    Context mContext;
    ProfilePart2FragmentBinding binding;

    public profile_part2_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.profile_part2_fragment, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.btBook.setOnClickListener(v -> {
            ((LoadMedicalActivity)getActivity()).FragTras(new MedicalTimeSlotFragment());
        });

    }

}
