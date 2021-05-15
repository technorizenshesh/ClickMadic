package com.technorizen.crysco.insurance.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.FragmentInsuranceProductBinding;
import com.technorizen.crysco.insurance.activities.LoadInsuranceActivity;

public class InsuranceProductFragment extends Fragment {


    Context mContext;
    FragmentInsuranceProductBinding binding;

    public InsuranceProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_insurance_product, container, false);

        iniit();

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private void iniit() {

        binding.ivBack.setOnClickListener(v -> {
            getFragmentManager().popBackStack();
        });

        binding.btAddCart.setOnClickListener(v -> {
            ((LoadInsuranceActivity)getActivity()).FragTras(new InsuranceTineSlotFragment());
        });

    }


}
