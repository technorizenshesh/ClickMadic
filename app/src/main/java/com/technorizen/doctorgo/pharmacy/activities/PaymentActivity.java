package com.technorizen.doctorgo.pharmacy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.InputType;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityPaymentBinding;

public class PaymentActivity extends AppCompatActivity {

    Context mContext = PaymentActivity.this;
    ActivityPaymentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_payment);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        init();

    }

    private void init() {

        binding.cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .postalCodeRequired(true)
                .mobileNumberRequired(true)
                .mobileNumberExplanation("SMS is required on this number")
                .setup(PaymentActivity.this);

        binding.cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);

        binding.btMakePayment.setOnClickListener(v -> {
            startActivity(new Intent(mContext, PharmaHomeActivity.class));
            finish();
        });

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

    }

}
