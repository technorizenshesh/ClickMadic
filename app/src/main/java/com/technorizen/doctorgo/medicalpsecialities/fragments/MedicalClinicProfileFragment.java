package com.technorizen.doctorgo.medicalpsecialities.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.FragmentMedicalClinicProfileBinding;
import com.technorizen.doctorgo.medicalpsecialities.activities.LoadMedicalActivity;

public class MedicalClinicProfileFragment extends Fragment {

    Context mContext;
    FragmentMedicalClinicProfileBinding binding;

    public MedicalClinicProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_medical_clinic_profile, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            getFragmentManager().popBackStack();
        });

        binding.tvBook1.setOnClickListener(v -> {
            ((LoadMedicalActivity)getActivity()).FragTras(new MedicalTimeSlotFragment());
        });

        binding.btBook.setOnClickListener(v -> {
            ((LoadMedicalActivity)getActivity()).FragTras(new MedicalTimeSlotFragment());
        });

        binding.tvBook2.setOnClickListener(v -> {
            ((LoadMedicalActivity)getActivity()).FragTras(new MedicalTimeSlotFragment());
        });

    }


}
