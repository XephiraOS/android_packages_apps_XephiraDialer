package com.coui.appcompat.preference;

import X8.n;
import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.b;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.DialogPreference;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.uiutil.AnimLevel;
import com.coui.appcompat.uiutil.UIUtil;

/* loaded from: classes.dex */
public class COUIEditTextPreferenceDialogFragment extends androidx.preference.a {
    private static final String SAVE_STATE_BLUR_BACKGROUND = "ListPreferenceDialogFragment.SAVE_STATE_BLUR_BACKGROUND";
    private static final String SAVE_STATE_TEXT = "EditTextPreferenceDialogFragment.text";
    private static final String TAG = "COUIEditTextPreferenceDialogFragment";
    private boolean mBlurBackground = false;
    private AnimLevel mBlurMinAnimLevel = UIUtil.ANIM_LEVEL_SUPPORT_BLUR_MIN;
    private COUIEditText mEditText;

    private COUIAlertDialogBuilder initCOUIAlertDialogBuilder() {
        return new COUIAlertDialogBuilder(requireContext(), n.f5033e).setTitle(getPreference().getDialogTitle()).setMessage(getPreference().getDialogMessage()).setPositiveButton(getPreference().getPositiveButtonText(), (DialogInterface.OnClickListener) this).setNegativeButton(getPreference().getNegativeButtonText(), (DialogInterface.OnClickListener) this);
    }

    public static COUIEditTextPreferenceDialogFragment newInstance(String str) {
        COUIEditTextPreferenceDialogFragment cOUIEditTextPreferenceDialogFragment = new COUIEditTextPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        cOUIEditTextPreferenceDialogFragment.setArguments(bundle);
        return cOUIEditTextPreferenceDialogFragment;
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public Dialog onCreateDialog(Bundle bundle) {
        COUIEditTextPreference cOUIEditTextPreference;
        final boolean z10;
        FragmentActivity activity = getActivity();
        COUIAlertDialogBuilder initCOUIAlertDialogBuilder = initCOUIAlertDialogBuilder();
        View onCreateDialogView = onCreateDialogView(activity);
        if (onCreateDialogView == null) {
            Log.d(TAG, "COUIEditTextPreferenceDialogFragment  contentView == null ");
            return initCOUIAlertDialogBuilder.create();
        }
        this.mEditText = (COUIEditText) onCreateDialogView.findViewById(R.id.edit);
        onBindDialogView(onCreateDialogView);
        initCOUIAlertDialogBuilder.setView(onCreateDialogView);
        if (getPreference() != null) {
            onBindDialogView(onCreateDialogView);
        }
        onPrepareDialogBuilder(initCOUIAlertDialogBuilder);
        DialogPreference preference = getPreference();
        if (preference != null && (preference instanceof COUIEditTextPreference)) {
            cOUIEditTextPreference = (COUIEditTextPreference) preference;
            this.mBlurBackground = cOUIEditTextPreference.isBlurBackground();
            this.mBlurMinAnimLevel = cOUIEditTextPreference.getBlurMinAnimLevel();
        } else {
            cOUIEditTextPreference = null;
        }
        final b create = initCOUIAlertDialogBuilder.setBlurBackgroundDrawable(this.mBlurBackground, this.mBlurMinAnimLevel).create();
        if (cOUIEditTextPreference != null) {
            z10 = cOUIEditTextPreference.isSupportEmptyInput();
        } else {
            z10 = false;
        }
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.coui.appcompat.preference.COUIEditTextPreferenceDialogFragment.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Button b10 = create.b(-1);
                if (b10 != null && !z10) {
                    b10.setEnabled(!TextUtils.isEmpty(editable));
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }
        });
        return create;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        COUIEditText cOUIEditText = this.mEditText;
        if (cOUIEditText != null) {
            cOUIEditText.setFocusable(true);
            this.mEditText.requestFocus();
            if (getDialog() != null) {
                getDialog().getWindow().setSoftInputMode(5);
            }
        }
    }

    @Override // androidx.preference.a, androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        COUIEditText cOUIEditText = this.mEditText;
        if (cOUIEditText != null) {
            bundle.putCharSequence(SAVE_STATE_TEXT, cOUIEditText.getText());
            bundle.putBoolean(SAVE_STATE_BLUR_BACKGROUND, this.mBlurBackground);
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (getPreference() == null) {
            dismiss();
        }
    }
}
