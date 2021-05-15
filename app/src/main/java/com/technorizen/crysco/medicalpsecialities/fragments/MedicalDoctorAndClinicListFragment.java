package com.technorizen.crysco.medicalpsecialities.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.FragmentMedicalDoctorAndClinicListBinding;
import com.technorizen.crysco.medicalpsecialities.activities.LoadMedicalActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MedicalDoctorAndClinicListFragment extends Fragment {

    Context mContext;
    FragmentMedicalDoctorAndClinicListBinding binding;

    public MedicalDoctorAndClinicListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_medical_doctor_and_clinic_list, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            getFragmentManager().popBackStack();
        });

        binding.tvBookApp.setOnClickListener(v -> {
            ((LoadMedicalActivity)getActivity()).FragTras(new MedicalTimeSlotFragment());
        });

        binding.profile.setOnClickListener(v -> {
            ((LoadMedicalActivity)getActivity()).FragTras(new MedicalDoctorProfileFragment());
        });

        binding.tvContactClinic.setOnClickListener(v -> {
            ((LoadMedicalActivity)getActivity()).FragTras(new MedicalClinicProfileFragment());
        });

        binding.ivFilter.setOnClickListener(v -> {
            ((LoadMedicalActivity)getActivity()).FragTras(new MedicalFilterFragment());
        });

    }

}
