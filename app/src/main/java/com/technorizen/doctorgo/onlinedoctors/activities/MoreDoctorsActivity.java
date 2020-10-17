package com.technorizen.doctorgo.onlinedoctors.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.activities.DoctorProfileActivity;
import com.technorizen.doctorgo.databinding.ActivityMoreDoctorsBinding;

public class MoreDoctorsActivity extends AppCompatActivity {

    Context mContext = MoreDoctorsActivity.this;
    ActivityMoreDoctorsBinding binding;
    String whichtype = "abc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_more_doctors);

        whichtype = getIntent().getStringExtra("which_type");

        init();

    }

    private void init() {

        if(whichtype.equalsIgnoreCase("online_doctor")) {
            binding.headerText.setText("Online");
            binding.request1.setText("Request");
            binding.request2.setText("Request");
        } else if(whichtype.equalsIgnoreCase("nearby")) {
            binding.headerText.setText("Nearby Doctors");
            binding.request1.setText("Book");
            binding.request2.setText("Book");
            binding.tvCattext.setText("Find Docotr Closest to you!");
        }

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.request1.setOnClickListener(v -> {
            if(whichtype.equalsIgnoreCase("nearby")){
                startActivity(new Intent(mContext, DoctorProfileActivity.class)
                        .putExtra("which_type","nearby")
                );
            } else if(whichtype.equalsIgnoreCase("online_doctor")) {
                startActivity(new Intent(mContext, BookTestPacakgesOnlineActivity.class)
                        .putExtra("which_type","online_doctor")
                );
            }
        });

        binding.request2.setOnClickListener(v -> {
            if(whichtype.equalsIgnoreCase("nearby")){
                startActivity(new Intent(mContext, DoctorProfileActivity.class)
                        .putExtra("which_type","nearby")
                );
            } else if(whichtype.equalsIgnoreCase("online_doctor")) {
                startActivity(new Intent(mContext, BookTestPacakgesOnlineActivity.class)
                        .putExtra("which_type","online_doctor")
                );
            }
        });

    }


}
