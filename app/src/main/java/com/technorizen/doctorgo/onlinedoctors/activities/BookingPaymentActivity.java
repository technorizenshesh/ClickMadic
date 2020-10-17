package com.technorizen.doctorgo.onlinedoctors.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityBookingPaymentBinding;
import com.technorizen.doctorgo.labathome.activities.AppointmentLabActivity;

public class BookingPaymentActivity extends AppCompatActivity {

    Context mContext = BookingPaymentActivity.this;
    ActivityBookingPaymentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_booking_payment);

        init();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.btAddPayment.setOnClickListener(v -> {
            startActivity(new Intent(mContext, AppointmentLabActivity.class));
        });


    }


}
