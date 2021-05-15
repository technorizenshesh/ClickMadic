package com.technorizen.crysco.insurance.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.ActivityAppointmentInsuranceBinding;
import com.technorizen.crysco.insurance.fragments.AppMadeInsuranceFragment;
import com.technorizen.crysco.insurance.fragments.NewInsuranceAppFragment;

public class AppointmentInsuranceActivity extends AppCompatActivity {

    Context mContext = AppointmentInsuranceActivity.this;
    ActivityAppointmentInsuranceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_appointment_insurance);

        init();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new NewInsuranceAppFragment()).commit();
        binding.newAppView.setVisibility(View.VISIBLE);

        binding.tvNewAppoint.setOnClickListener(v -> {
            binding.newAppView.setVisibility(View.VISIBLE);
            binding.madeAppView.setVisibility(View.INVISIBLE);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new NewInsuranceAppFragment()).commit();
        });

        binding.tvMadeAppoint.setOnClickListener(v -> {
            binding.newAppView.setVisibility(View.INVISIBLE);
            binding.madeAppView.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new AppMadeInsuranceFragment()).commit();
        });

    }


}
