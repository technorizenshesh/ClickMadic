package com.technorizen.doctorgo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityDoctorBookingBinding;
import com.technorizen.doctorgo.onlinedoctors.activities.BookTestPacakgesOnlineActivity;

public class DoctorProfileActivity extends AppCompatActivity {

    Context mContext = DoctorProfileActivity.this;
    ActivityDoctorBookingBinding binding;
    String whichtype = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_doctor_booking);

        whichtype = getIntent().getStringExtra("which_type");

        init();

    }

    private void init() {

        if(whichtype.equalsIgnoreCase("online_doctor")) {
            binding.btRequest.setText("Request");
        } else if(whichtype.equalsIgnoreCase("nearby")) {
            binding.btRequest.setText("Book");
        }

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.btRequest.setOnClickListener(v -> {
            if(whichtype.equalsIgnoreCase("online_doctor")) {
                startActivity(new Intent(mContext, BookTestPacakgesOnlineActivity.class));
            } else if(whichtype.equalsIgnoreCase("nearby")) {
                startActivity(new Intent(mContext, AvailableTimeSlotsActivity.class));
            }
        });


    }


}
