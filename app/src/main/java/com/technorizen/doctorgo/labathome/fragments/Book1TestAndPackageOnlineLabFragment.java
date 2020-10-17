package com.technorizen.doctorgo.labathome.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.FragmentBook1TestAndPackageOnlineLabBinding;
import com.technorizen.doctorgo.labathome.activities.LoadLabAtHomeActivity;

public class Book1TestAndPackageOnlineLabFragment extends Fragment {

    Context mContext;
    FragmentBook1TestAndPackageOnlineLabBinding binding;

    public Book1TestAndPackageOnlineLabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_book1_test_and_package_online_lab, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });

        binding.btContinue.setOnClickListener(v -> {
            ((LoadLabAtHomeActivity)getActivity()).FragTras(new Book2TestAndPackageOnlineLabFragment());
        });

    }


}
