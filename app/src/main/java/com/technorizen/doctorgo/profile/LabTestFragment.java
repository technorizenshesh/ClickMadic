package com.technorizen.doctorgo.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.FragmentLabTestBinding;
import com.technorizen.doctorgo.labathome.activities.LoadLabAtHomeActivity;

public class LabTestFragment extends Fragment {

    Context mContext;
    FragmentLabTestBinding binding;

    public LabTestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_lab_test, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.ivLabProfile.setOnClickListener(v -> {
            startActivity(new Intent(mContext, LoadLabAtHomeActivity.class)
            .putExtra("profile","profile"));
        });

        binding.ivScheduleLab.setOnClickListener(v -> {
            startActivity(new Intent(mContext, LoadLabAtHomeActivity.class)
                    .putExtra("time","time"));
        });

    }

}
