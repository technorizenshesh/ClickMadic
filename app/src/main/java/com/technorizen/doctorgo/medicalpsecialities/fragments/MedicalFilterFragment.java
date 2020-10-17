package com.technorizen.doctorgo.medicalpsecialities.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.FragmentMedicalFilterBinding;

public class MedicalFilterFragment extends Fragment {

    Context mContext;
    FragmentMedicalFilterBinding binding;

    public MedicalFilterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_medical_filter, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private void init() {

        binding.btApply.setOnClickListener(v -> {
            getFragmentManager().popBackStack();
        });

    }


}
