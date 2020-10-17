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
import com.technorizen.doctorgo.databinding.FragmentProfileHomeBinding;
import com.technorizen.doctorgo.profile.editprofile.LoadEditProfileActivity;

public class ProfileHomeFragment extends Fragment {

    Context mContext;
    FragmentProfileHomeBinding binding;

    public ProfileHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile_home, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        getChildFragmentManager().beginTransaction().replace(R.id.frameContainer,new WomensCalenderFragment()).commit();
        binding.WomenCalView.setVisibility(View.VISIBLE);

        binding.tvEditProfile.setOnClickListener(v -> {
            startActivity(new Intent(mContext, LoadEditProfileActivity.class));
        });

        binding.tvWomenCal.setOnClickListener(v -> {

            getChildFragmentManager().beginTransaction().replace(R.id.frameContainer,new WomensCalenderFragment()).commit();

            binding.WomenCalView.setVisibility(View.VISIBLE);
            binding.ClinicalHistoryView.setVisibility(View.INVISIBLE);
            binding.labTestView.setVisibility(View.INVISIBLE);
            binding.MedicalPrepView.setVisibility(View.INVISIBLE);
            binding.MedicalReminderView.setVisibility(View.INVISIBLE);
            binding.MedicalCertificateView.setVisibility(View.INVISIBLE);
            binding.IncomingInvoiceView.setVisibility(View.INVISIBLE);
        });

        binding.tvClinicalHistory.setOnClickListener(v -> {

            getChildFragmentManager().beginTransaction().replace(R.id.frameContainer,new ClinicalhistoryFragment()).commit();

            binding.WomenCalView.setVisibility(View.INVISIBLE);
            binding.ClinicalHistoryView.setVisibility(View.VISIBLE);
            binding.labTestView.setVisibility(View.INVISIBLE);
            binding.MedicalPrepView.setVisibility(View.INVISIBLE);
            binding.MedicalReminderView.setVisibility(View.INVISIBLE);
            binding.MedicalCertificateView.setVisibility(View.INVISIBLE);
            binding.IncomingInvoiceView.setVisibility(View.INVISIBLE);
        });

        binding.tvLabTest.setOnClickListener(v -> {

            getChildFragmentManager().beginTransaction().replace(R.id.frameContainer,new LabTestFragment()).commit();

            binding.WomenCalView.setVisibility(View.INVISIBLE);
            binding.ClinicalHistoryView.setVisibility(View.INVISIBLE);
            binding.labTestView.setVisibility(View.VISIBLE);
            binding.MedicalPrepView.setVisibility(View.INVISIBLE);
            binding.MedicalReminderView.setVisibility(View.INVISIBLE);
            binding.MedicalCertificateView.setVisibility(View.INVISIBLE);
            binding.IncomingInvoiceView.setVisibility(View.INVISIBLE);
        });

        binding.tvMedicalPrep.setOnClickListener(v -> {

            getChildFragmentManager().beginTransaction().replace(R.id.frameContainer,new MedicalPrescriptionFragment()).commit();

            binding.WomenCalView.setVisibility(View.INVISIBLE);
            binding.ClinicalHistoryView.setVisibility(View.INVISIBLE);
            binding.labTestView.setVisibility(View.INVISIBLE);
            binding.MedicalPrepView.setVisibility(View.VISIBLE);
            binding.MedicalReminderView.setVisibility(View.INVISIBLE);
            binding.MedicalCertificateView.setVisibility(View.INVISIBLE);
            binding.IncomingInvoiceView.setVisibility(View.INVISIBLE);
        });

        binding.tvMedicalReminder.setOnClickListener(v -> {

            getChildFragmentManager().beginTransaction().replace(R.id.frameContainer,new MedicalReminderFragment()).commit();

            binding.WomenCalView.setVisibility(View.INVISIBLE);
            binding.ClinicalHistoryView.setVisibility(View.INVISIBLE);
            binding.labTestView.setVisibility(View.INVISIBLE);
            binding.MedicalPrepView.setVisibility(View.INVISIBLE);
            binding.MedicalReminderView.setVisibility(View.VISIBLE);
            binding.MedicalCertificateView.setVisibility(View.INVISIBLE);
            binding.IncomingInvoiceView.setVisibility(View.INVISIBLE);
        });

        binding.tvMedicalCertificate.setOnClickListener(v -> {

            getChildFragmentManager().beginTransaction().replace(R.id.frameContainer,new MedicalCertificatesFragment()).commit();

            binding.WomenCalView.setVisibility(View.INVISIBLE);
            binding.ClinicalHistoryView.setVisibility(View.INVISIBLE);
            binding.labTestView.setVisibility(View.INVISIBLE);
            binding.MedicalPrepView.setVisibility(View.INVISIBLE);
            binding.MedicalReminderView.setVisibility(View.INVISIBLE);
            binding.MedicalCertificateView.setVisibility(View.VISIBLE);
            binding.IncomingInvoiceView.setVisibility(View.INVISIBLE);
        });

        binding.tvIncomingInvoice.setOnClickListener(v -> {

            getChildFragmentManager().beginTransaction().replace(R.id.frameContainer,new IncomingInoicesFragment()).commit();

            binding.WomenCalView.setVisibility(View.INVISIBLE);
            binding.ClinicalHistoryView.setVisibility(View.INVISIBLE);
            binding.labTestView.setVisibility(View.INVISIBLE);
            binding.MedicalPrepView.setVisibility(View.INVISIBLE);
            binding.MedicalReminderView.setVisibility(View.INVISIBLE);
            binding.MedicalCertificateView.setVisibility(View.INVISIBLE);
            binding.IncomingInvoiceView.setVisibility(View.VISIBLE);
        });

    }

}
