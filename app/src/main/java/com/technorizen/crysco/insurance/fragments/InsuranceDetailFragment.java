package com.technorizen.crysco.insurance.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.FragmentInsuranceDetailBinding;
import com.technorizen.crysco.insurance.activities.LoadInsuranceActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class InsuranceDetailFragment extends Fragment {

    Context mContext;
    FragmentInsuranceDetailBinding binding;

    public InsuranceDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_insurance_detail, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            getFragmentManager().popBackStack();
        });

        binding.rlItem1.setOnClickListener(v -> {
            ((LoadInsuranceActivity)getActivity()).FragTras(new InsuranceProductFragment());
        });

        binding.rlItem2.setOnClickListener(v -> {
            ((LoadInsuranceActivity)getActivity()).FragTras(new InsuranceProductFragment());
        });

    }


}
