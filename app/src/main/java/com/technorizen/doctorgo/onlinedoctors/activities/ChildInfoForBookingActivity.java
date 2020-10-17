package com.technorizen.doctorgo.onlinedoctors.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityChildInfoForBookingBinding;

public class ChildInfoForBookingActivity extends AppCompatActivity {

    Context mContext = ChildInfoForBookingActivity.this;
    ActivityChildInfoForBookingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_child_info_for_booking);

        init();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.btContinue.setOnClickListener(v -> {
            startActivity(new Intent(mContext,BookingPaymentActivity.class));
        });

    }


}
