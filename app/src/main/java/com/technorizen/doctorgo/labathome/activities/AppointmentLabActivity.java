package com.technorizen.doctorgo.labathome.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityAppointmentLabBinding;
import com.technorizen.doctorgo.labathome.fragments.AppointmentsMadeFragmentLab;
import com.technorizen.doctorgo.labathome.fragments.NewAppointmentFragmentLab;

public class AppointmentLabActivity extends AppCompatActivity {

    Context mContext = AppointmentLabActivity.this;
    ActivityAppointmentLabBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_appointment_lab);

        init();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new NewAppointmentFragmentLab()).commit();
        binding.newAppView.setVisibility(View.VISIBLE);

        binding.tvNewAppoint.setOnClickListener(v -> {
            binding.newAppView.setVisibility(View.VISIBLE);
            binding.madeAppView.setVisibility(View.INVISIBLE);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new NewAppointmentFragmentLab()).commit();
        });

        binding.tvMadeAppoint.setOnClickListener(v -> {
            binding.newAppView.setVisibility(View.INVISIBLE);
            binding.madeAppView.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new AppointmentsMadeFragmentLab()).commit();
        });

    }


}
