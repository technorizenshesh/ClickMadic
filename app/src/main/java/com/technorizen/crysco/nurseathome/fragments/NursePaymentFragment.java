package com.technorizen.crysco.nurseathome.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.FragmentNursePaymentBinding;
import com.technorizen.crysco.labathome.activities.AppointmentHistory;

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
            startActivity(new Intent(mContext, AppointmentHistory.class));
        });
    }


}
