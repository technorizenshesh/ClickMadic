package com.technorizen.crysco.labathome.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.FragmentFillPatientDetailBinding;

public class FillPatientDetailFragment extends Fragment {

    Context mContext;
    FragmentFillPatientDetailBinding binding;

    public FillPatientDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_fill_patient_detail, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });

        binding.tvQuesMark.setOnClickListener(v -> {
            binding.tvSexDisp.setVisibility(View.VISIBLE);
        });

        binding.btContinue.setOnClickListener(v -> {
        });

    }


}
