package com.technorizen.doctorgo.pharmacy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivitySetDeliveryLocationBinding;

public class SetDeliveryLocationActivity extends AppCompatActivity {

    Context mContext = SetDeliveryLocationActivity.this;
    ActivitySetDeliveryLocationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_set_delivery_location);

        init();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.Done.setOnClickListener(v -> {
            startActivity(new Intent(mContext,PaymentActivity.class));
        });

    }

}
