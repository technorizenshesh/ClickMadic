package com.technorizen.doctorgo.nurseathome.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.FragmentNursePaymentBinding;
import com.technorizen.doctorgo.labathome.activities.AppointmentLabActivity;

public class NursePaymentFragment extends Fragment {

    Context mContext;
    FragmentNursePaymentBinding binding;

    public NursePaymentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_nurse_payment, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {
        binding.ivBack.setOnClickListener(v -> {
            getFragmentManager().popBackStack();
        });

        binding.btAddPayment.setOnClickListener(v -> {
            startActivity(new Intent(mContext, AppointmentLabActivity.class));
        });
    }


}
