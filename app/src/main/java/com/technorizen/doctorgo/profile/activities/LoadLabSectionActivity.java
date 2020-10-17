package com.technorizen.doctorgo.profile.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityLoadLabSectionBinding;
import com.technorizen.doctorgo.labathome.fragments.LabDetailFragment;

public class LoadLabSectionActivity extends AppCompatActivity {

    Context mContext = LoadLabSectionActivity.this;
    ActivityLoadLabSectionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_load_lab_section);

        init();

        FragTras(new LabDetailFragment());

    }

    private void init() {

    }

    public void FragTras(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack("fragment");
        transaction.commit();
    }


    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount()>1){
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

}
