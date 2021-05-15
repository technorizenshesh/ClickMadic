package com.technorizen.crysco.profile.editprofile.tabfragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
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
import com.technorizen.crysco.databinding.FragmentMedicalEditBinding;
import com.technorizen.crysco.profile.editprofile.LoadEditProfileActivity;

public class MedicalEditFragment extends Fragment {

    Context mContext;
    FragmentMedicalEditBinding binding;

    public MedicalEditFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_medical_edit, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private void init() {

        binding.tvAllergies.setOnClickListener(v -> {
            addAllergiesDialog();
        });

        binding.tvCurrentMedication.setOnClickListener(v -> {
            addCurrentMedicationDialog();
        });

        binding.tvPastMedication.setOnClickListener(v -> {
            addPastMedicationDialog();
        });

        binding.tvChronicDisease.setOnClickListener(v -> {
            addDiseaseDialog();
        });

        binding.tvInjuries.setOnClickListener(v -> {
            addInjuryDialog();
        });

        binding.tvSurgeries.setOnClickListener(v -> {
            addSurgeryDialog();
        });

    }

    private void addAllergiesDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_allergie_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);
        TextView tvAddAllergy = dialog.findViewById(R.id.tvAddAllergy);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addedAllergiesDialog();
        });

        tvAddAllergy.setOnClickListener(v -> {
            addedAllergiesDialog();
        });

        dialog.show();
    }

    private void addedAllergiesDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_add_allergy_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView done = dialog.findViewById(R.id.done);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        done.setOnClickListener(v -> {
            saveAllergiesDialog();
        });

        dialog.show();

    }

    private void saveAllergiesDialog() {

        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_save_allergy_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView save = dialog.findViewById(R.id.save);
        TextView tvAddAllergy = dialog.findViewById(R.id.tvAddAllergy);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        save.setOnClickListener(v -> {
            dialog.dismiss();
            getActivity().finish();
            startActivity(new Intent(mContext,LoadEditProfileActivity.class));
        });

        tvAddAllergy.setOnClickListener(v -> {
            addedAllergiesDialog();
        });

        dialog.show();

    }


    private void addCurrentMedicationDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_current_medication);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);
        TextView tvAddMedication = dialog.findViewById(R.id.tvAddMedication);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addedCurrentMedicationDialog();
        });

        tvAddMedication.setOnClickListener(v -> {
            addedCurrentMedicationDialog();
        });

        dialog.show();
    }

    private void addedCurrentMedicationDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_add_current_medication);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView done = dialog.findViewById(R.id.done);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        done.setOnClickListener(v -> {
            saveCurrentMedicationDialog();
        });

        dialog.show();

    }

    private void saveCurrentMedicationDialog() {

        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_save_medication);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView save = dialog.findViewById(R.id.save);
        TextView tvAddMedication = dialog.findViewById(R.id.tvAddMedication);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        save.setOnClickListener(v -> {
            dialog.dismiss();
            getActivity().finish();
            startActivity(new Intent(mContext,LoadEditProfileActivity.class));
        });

        tvAddMedication.setOnClickListener(v -> {
            addedCurrentMedicationDialog();
        });

        dialog.show();

    }


    private void addPastMedicationDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_past_medication_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);
        TextView tvAddMedication = dialog.findViewById(R.id.tvAddMedication);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addedPastMedicationDialog();
        });

        tvAddMedication.setOnClickListener(v -> {
            addedPastMedicationDialog();
        });

        dialog.show();

    }

    private void addedPastMedicationDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_past_add_medication_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView done = dialog.findViewById(R.id.done);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        done.setOnClickListener(v -> {
            savePastMedicationDialog();
        });

        dialog.show();

    }

    private void savePastMedicationDialog() {

        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_save_medication_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView save = dialog.findViewById(R.id.save);
        TextView tvAddMedication = dialog.findViewById(R.id.tvAddMedication);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        save.setOnClickListener(v -> {
            dialog.dismiss();
            getActivity().finish();
            startActivity(new Intent(mContext,LoadEditProfileActivity.class));
        });

        tvAddMedication.setOnClickListener(v -> {
            addedPastMedicationDialog();
        });

        dialog.show();

    }


    private void addInjuryDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_chronic_disease);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);
        TextView tvAddIlleness = dialog.findViewById(R.id.tvAddIlleness);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addedInjuryDialog();
        });

        tvAddIlleness.setOnClickListener(v -> {
            addedInjuryDialog();
        });

        dialog.show();

    }

    private void addedInjuryDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_add_injury);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView done = dialog.findViewById(R.id.done);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        done.setOnClickListener(v -> {
            saveInjuryDialog();
        });

        dialog.show();

    }

    private void saveInjuryDialog() {

        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_save_injury_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView save = dialog.findViewById(R.id.save);
        TextView tvAddInjury = dialog.findViewById(R.id.tvAddInjury);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        save.setOnClickListener(v -> {
            dialog.dismiss();
            getActivity().finish();
            startActivity(new Intent(mContext,LoadEditProfileActivity.class));
        });

        tvAddInjury.setOnClickListener(v -> {
            addedInjuryDialog();
        });

        dialog.show();

    }


    private void addSurgeryDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_surgery_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);
        TextView tvAddSurgery = dialog.findViewById(R.id.tvAddSurgery);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addedSurgeryDialog();
        });

        tvAddSurgery.setOnClickListener(v -> {
            addedSurgeryDialog();
        });

        dialog.show();

    }

    private void addedSurgeryDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_add_surgery_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView done = dialog.findViewById(R.id.done);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        done.setOnClickListener(v -> {
            saveSurgeryDialog();
        });

        dialog.show();

    }

    private void saveSurgeryDialog() {

        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_save_surgery);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView save = dialog.findViewById(R.id.save);
        TextView tvAddSurgery = dialog.findViewById(R.id.tvAddSurgery);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        save.setOnClickListener(v -> {
            dialog.dismiss();
            getActivity().finish();
            startActivity(new Intent(mContext,LoadEditProfileActivity.class));
        });

        tvAddSurgery.setOnClickListener(v -> {
            addedSurgeryDialog();
        });

        dialog.show();

    }


    private void addDiseaseDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_chronic_disease);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView next = dialog.findViewById(R.id.next);
        TextView tvAddIlleness = dialog.findViewById(R.id.tvAddIlleness);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        next.setOnClickListener(v -> {
            addedDiseaseDialog();
        });

        tvAddIlleness.setOnClickListener(v -> {
            addedDiseaseDialog();
        });

        dialog.show();

    }

    private void addedDiseaseDialog() {
        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_add_illness_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView done = dialog.findViewById(R.id.done);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        done.setOnClickListener(v -> {
            saveIllenessDialog();
        });

        dialog.show();

    }

    private void saveIllenessDialog() {

        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.medical_edit_save_illeness_dialog);

        ImageView ivClose = dialog.findViewById(R.id.ivClose);
        TextView save = dialog.findViewById(R.id.save);
        TextView tvAddIlleness = dialog.findViewById(R.id.tvAddIlleness);

        ivClose.setOnClickListener(v -> {
            dialog.dismiss();
        });

        save.setOnClickListener(v -> {
            dialog.dismiss();
            getActivity().finish();
            startActivity(new Intent(mContext,LoadEditProfileActivity.class));
        });

        tvAddIlleness.setOnClickListener(v -> {
            addedDiseaseDialog();
        });

        dialog.show();

    }



}
