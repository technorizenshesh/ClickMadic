package com.technorizen.doctorgo.labathome.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.FragmentPaymentForLabBinding;
import com.technorizen.doctorgo.labathome.activities.AppointmentLabActivity;

public class PaymentForLabFragment extends Fragment {

    Context mContext;
    FragmentPaymentForLabBinding binding;

    public PaymentForLabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_payment_for_lab, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });

        binding.btAddPayment.setOnClickListener(v -> {
            startActivity(new Intent(mContext,AppointmentLabActivity.class));
        });

    }


}
