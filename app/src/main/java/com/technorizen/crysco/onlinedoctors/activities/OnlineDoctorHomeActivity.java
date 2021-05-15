package com.technorizen.crysco.onlinedoctors.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.technorizen.crysco.R;
import com.technorizen.crysco.activities.DoctorProfileActivity;
import com.technorizen.crysco.databinding.ActivityOnlineDoctorHomeBinding;

public class OnlineDoctorHomeActivity extends AppCompatActivity {

    Context mContext = OnlineDoctorHomeActivity.this;
    ActivityOnlineDoctorHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_online_doctor_home);

        init();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.llDoctorProfile1.setOnClickListener(v -> {
            startActivity(new Intent(mContext, DoctorProfileActivity.class)
                    .putExtra("which_type","online_doctor")
            );
        });

        binding.request1.setOnClickListener(v -> {
            startActivity(new Intent(mContext, BookTestPacakgesOnlineActivity.class));
        });

        binding.tvMore.setOnClickListener(v -> {
            startActivity(new Intent(mContext, MoreDoctorsActivity.class)
                    .putExtra("which_type","online_doctor"));
        });

        binding.request2.setOnClickListener(v -> {
            startActivity(new Intent(mContext, BookTestPacakgesOnlineActivity.class));
        });


    }


}
