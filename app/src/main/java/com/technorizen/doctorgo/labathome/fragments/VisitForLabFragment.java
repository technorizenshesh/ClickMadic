package com.technorizen.doctorgo.labathome.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.activities.SignUpActivity;
import com.technorizen.doctorgo.databinding.FragmentVisitForLabBinding;
import com.technorizen.doctorgo.labathome.activities.LoadLabAtHomeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisitForLabFragment extends Fragment {

    Context mContext;
    FragmentVisitForLabBinding binding;

    public VisitForLabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_visit_for_lab, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });

        binding.ivPatientArrow.setOnClickListener(v -> {
            ((LoadLabAtHomeActivity)getActivity()).FragTras(new PaymentForLabFragment());
        });

        binding.ivChildArrow.setOnClickListener(v -> {
            ((LoadLabAtHomeActivity)getActivity()).FragTras(new ChildInfoLabFragment());
        });

        binding.ivCreateAccount.setOnClickListener(v -> {
            createAccountDialog();
        });

    }

    private void createAccountDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage("Are you sure you want to create a new account?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        startActivity(new Intent(mContext, SignUpActivity.class));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        ((LoadLabAtHomeActivity)getActivity()).FragTras(new FillPatientDetailFragment());
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }



}
