package com.technorizen.doctorgo.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.activities.DoctorProfileActivity;
import com.technorizen.doctorgo.clinics.activities.LoadClinicActivity;
import com.technorizen.doctorgo.databinding.FragmentHomeBinding;
import com.technorizen.doctorgo.emergency.activities.EmergencyHomeActivity;
import com.technorizen.doctorgo.insurance.activities.LoadInsuranceActivity;
import com.technorizen.doctorgo.labathome.activities.LoadLabAtHomeActivity;
import com.technorizen.doctorgo.medicalpsecialities.activities.LoadMedicalActivity;
import com.technorizen.doctorgo.nurseathome.activities.LoadNurseHomeActivity;
import com.technorizen.doctorgo.onlinedoctors.activities.MoreDoctorsActivity;
import com.technorizen.doctorgo.onlinedoctors.activities.OnlineDoctorHomeActivity;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    Context mContext;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.llLabAtHome.setOnClickListener(v -> {
            startActivity(new Intent(mContext, LoadLabAtHomeActivity.class));
        });

        binding.tvMedicalSp.setOnClickListener(v -> {
            startActivity(new Intent(mContext, LoadMedicalActivity.class));
        });

        binding.llHealthIns.setOnClickListener(v -> {
            startActivity(new Intent(mContext, LoadInsuranceActivity.class));
        });

        binding.llEmergency.setOnClickListener(v -> {
            startActivity(new Intent(mContext, EmergencyHomeActivity.class));
        });

        binding.llNurseAtHome.setOnClickListener(v -> {
            startActivity(new Intent(mContext, LoadNurseHomeActivity.class));
        });

        binding.tvMoreNearby.setOnClickListener(v -> {
            startActivity(new Intent(mContext, MoreDoctorsActivity.class)
            .putExtra("which_type","nearby")
            );
        });

        binding.ivDoctorNearby.setOnClickListener(v -> {
            startActivity(new Intent(mContext, DoctorProfileActivity.class)
                    .putExtra("which_type","nearby")
            );
        });

        binding.ivClinicProfile.setOnClickListener(v -> {
            startActivity(new Intent(mContext, LoadClinicActivity.class)
                    .putExtra("which_type","clinicprofile")
            );
        });

        binding.tvContactClinic.setOnClickListener(v -> {
            startActivity(new Intent(mContext, LoadClinicActivity.class)
                    .putExtra("which_type","clinicprofile")
            );
        });

        binding.tvMoreClinic.setOnClickListener(v -> {
            startActivity(new Intent(mContext, LoadClinicActivity.class));
        });

        binding.llOnlineDoctors.setOnClickListener(v -> {
            startActivity(new Intent(mContext, OnlineDoctorHomeActivity.class)
            .putExtra("which_type","online_doctor")
            );
        });

        binding.rlPharmacy.setOnClickListener(v -> {
           // startActivity(new Intent(mContext, PharmaHomeActivity.class));
        });

    }


}
