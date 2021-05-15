package com.technorizen.crysco.profile.editprofile.tabfragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.FragmentPersonalDetailBinding;

public class PersonalDetailFragment extends Fragment {

    Context mContext;
    FragmentPersonalDetailBinding binding;

    public PersonalDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_personal_detail, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.addContacNo.setOnClickListener(v -> {
           // addNumberDialog();
        });

        binding.addEmail.setOnClickListener(v -> {
          //  addEmailDialog();
        });

        binding.addIdentityCard.setOnClickListener(v -> {
           // addNumberDialog();
        });

    }

    private void addNumberDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.edit_number_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addEmailDialog();
        });

        dialog.show();
    }

    private void addEmailDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.edit_email_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
           // addBirthDialog();
        });

        dialog.show();

    }

    private void addBirthDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.edit_birth_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addgenderDialog();
        });

        dialog.show();
    }

    private void addgenderDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.edit_gender_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addCityDialog();
        });

        dialog.show();
    }

    private void addCityDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.edit_city_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);
        TextView tvPickCity = dialog.findViewById(R.id.tvPickCity);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addBloodGrpDialog();
        });

        tvPickCity.setOnClickListener(v -> {
            addlocationDialog();
        });

        dialog.show();
    }

    private void addlocationDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.edit_location);

        TextView tvNotNow = dialog.findViewById(R.id.tvNotNow);

        tvNotNow.setOnClickListener(v -> {
            dialog.dismiss();
        });

        dialog.show();
    }

    private void addBloodGrpDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.edit_blood_grp);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addMarriedDialog();
        });

        dialog.show();
    }

    private void addMarriedDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.edit_married_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addHeightDialog();
        });

        dialog.show();
    }

    private void addHeightDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.edit_height_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addWeightDialog();
        });

        dialog.show();
    }

    private void addWeightDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.edit_weight_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addInsuranceDialog();
        });

        dialog.show();
    }

    private void addInsuranceDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.edit_insurance_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);
        TextView back = dialog.findViewById(R.id.back);
        TextView tvAddInsurance = dialog.findViewById(R.id.tvAddInsurance);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        back.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addFillInsuranceDialog();
        });

        tvAddInsurance.setOnClickListener(v -> {
            addFillInsuranceDialog();
        });

        dialog.show();
    }

    private void addFillInsuranceDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.edit_fill_insurance_dilaog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView save = dialog.findViewById(R.id.save);
        TextView back = dialog.findViewById(R.id.back);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        back.setOnClickListener(v -> {
            dialog.dismiss();
        });

        save.setOnClickListener(v -> {
            dialog.dismiss();
            getActivity().finish();
        });

        dialog.show();
    }

}
