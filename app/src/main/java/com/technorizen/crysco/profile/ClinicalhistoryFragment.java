package com.technorizen.crysco.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.crysco.R;
import com.technorizen.crysco.activities.DoctorProfileActivity;
import com.technorizen.crysco.databinding.FragmentClinicalhistoryBinding;
import com.technorizen.crysco.onlinedoctors.activities.BookTestPacakgesOnlineActivity;

public class ClinicalhistoryFragment extends Fragment {

    Context mContext;
    FragmentClinicalhistoryBinding binding;

    public ClinicalhistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_clinicalhistory, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.ivProfile.setOnClickListener(v -> {
            startActivity(new Intent(mContext, DoctorProfileActivity.class)
            .putExtra("which_type","nearby"));
        });

        binding.ivScheduleDoctorsApp.setOnClickListener(v -> {
            startActivity(new Intent(mContext, BookTestPacakgesOnlineActivity.class));
        });


    }


}
