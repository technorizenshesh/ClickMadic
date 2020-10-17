package com.technorizen.doctorgo.insurance.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.FragmentInusranceHomeBinding;
import com.technorizen.doctorgo.insurance.activities.LoadInsuranceActivity;

public class InusranceHomeFragment extends Fragment {

    Context mContext;
    FragmentInusranceHomeBinding binding;

    public InusranceHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_inusrance_home, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
           getActivity().finish();
        });

        binding.llIns1.setOnClickListener(v -> {
            ((LoadInsuranceActivity)getActivity()).FragTras(new InsuranceDetailFragment());
        });

        binding.llIns2.setOnClickListener(v -> {
            ((LoadInsuranceActivity)getActivity()).FragTras(new InsuranceDetailFragment());
        });

        binding.llIns3.setOnClickListener(v -> {
            ((LoadInsuranceActivity)getActivity()).FragTras(new InsuranceDetailFragment());
        });


    }


}
