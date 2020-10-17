package com.technorizen.doctorgo.insurance.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.FragmentInsuranceTineSlotBinding;
import com.technorizen.doctorgo.insurance.activities.AppointmentInsuranceActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class InsuranceTineSlotFragment extends Fragment {

    Context mContext;
    FragmentInsuranceTineSlotBinding binding;


    public InsuranceTineSlotFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_insurance_tine_slot, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            getFragmentManager().popBackStack();
        });

        binding.btContinue.setOnClickListener(v -> {
            startActivity(new Intent(mContext, AppointmentInsuranceActivity.class));
        });

    }


}
