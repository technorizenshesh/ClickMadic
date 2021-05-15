package com.technorizen.crysco.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.ActivityClinicDetailBinding;

public class ClinicDetailActivity extends AppCompatActivity {

    Context mContext = ClinicDetailActivity.this;
    ActivityClinicDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_clinic_detail);

        init();

    }

    private void init() {
        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.btBook.setOnClickListener(v -> {
            startActivity(new Intent(mContext, DoctorProfileActivity.class));
        });

    }

}
