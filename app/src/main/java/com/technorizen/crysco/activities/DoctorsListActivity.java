package com.technorizen.crysco.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.ActivityDoctorsListBinding;

public class DoctorsListActivity extends AppCompatActivity {

    Context mContext = DoctorsListActivity.this;
    ActivityDoctorsListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_doctors_list);

        init();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.contactClinic.setOnClickListener(v -> {
            startActivity(new Intent(mContext,ClinicDetailActivity.class));
        });

        binding.contactClinic1.setOnClickListener(v -> {
            startActivity(new Intent(mContext,ClinicDetailActivity.class));
        });

    }

}
