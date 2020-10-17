package com.technorizen.doctorgo.onlinedoctors.activities;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityFillPatientDetailBinding;

public class FillPatientDetailActivity extends AppCompatActivity {

    Context mContext = FillPatientDetailActivity.this;
    ActivityFillPatientDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_fill_patient_detail);

        init();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.btContinue.setOnClickListener(v -> {
            finish();
        });

    }


}
