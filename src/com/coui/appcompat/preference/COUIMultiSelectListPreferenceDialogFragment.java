package com.coui.appcompat.preference;

import X8.h;
import X8.j;
import X8.n;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.preference.d;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.dialog.adapter.ChoiceListAdapter;
import com.coui.appcompat.uiutil.AnimLevel;
import com.coui.appcompat.uiutil.UIUtil;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class COUIMultiSelectListPreferenceDialogFragment extends d {
    private static final String SAVE_STATE_BLUR_ANIM_LAVEL = "ListPreferenceDialogFragment.SAVE_STATE_BLUR_ANIM_LAVEL";
    private static final String SAVE_STATE_BLUR_BACKGROUND = "ListPreferenceDialogFragment.SAVE_STATE_BLUR_BACKGROUND";
    private static final String SAVE_STATE_ENTRIES = "MultiSelectListPreferenceDialogFragmentCompat.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "MultiSelectListPreferenceDialogFragmentCompat.entryValues";
    private static final String SAVE_STATE_FOLLOWHAND = "ListPreferenceDialogFragment.SAVE_STATE_FOLLOWHAND";
    private static final String SAVE_STATE_MESSAGE = "COUIMultiSelectListPreferenceDialogFragment.message";
    private static final String SAVE_STATE_NEGATIVE_BUTTON_TEXT = "COUIMultiSelectListPreferenceDialogFragment.negativeButtonTextitle";
    private static final String SAVE_STATE_POSITION = "ListPreferenceDialogFragment.SAVE_STATE_POSITION";
    private static final String SAVE_STATE_POSITIVE_BUTTON_TEXT = "COUIMultiSelectListPreferenceDialogFragment.positiveButtonText";
    private static final String SAVE_STATE_SUMMARYS = "COUIMultiSelectListPreferenceDialogFragment.summarys";
    private static final String SAVE_STATE_TITLE = "COUIMultiSelectListPreferenceDialogFragment.title";
    private static final String SAVE_STATE_VALUES = "COUIMultiSelectListPreferenceDialogFragment.values";
    private static final String TAG = "COUIMultiSelectListPreferenceDialogFragment-hkl";
    private ChoiceListAdapter mAdapter;
    private COUIAlertDialogBuilder mBuilder;
    private boolean[] mCheckboxStates;
    private CharSequence mDialogMessage;
    private int[] mDialogPosition;
    private CharSequence mDialogTitle;
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;
    private CharSequence mNegativeButtonText;
    private CharSequence mPositiveButtonText;
    private COUIMultiSelectListPreference mPreference;
    private CharSequence[] mSummaries;
    private boolean mIfFollowHand = true;
    private boolean mBlurBackground = false;
    private AnimLevel mBlurMinAnimLevel = UIUtil.ANIM_LEVEL_SUPPORT_BLUR_MIN;

    private boolean[] getCheckboxStatesFromValues(Set<String> set) {
        boolean[] zArr = new boolean[this.mEntries.length];
        int i10 = 0;
        while (true) {
            CharSequence[] charSequenceArr = this.mEntries;
            if (i10 < charSequenceArr.length) {
                zArr[i10] = set.contains(charSequenceArr[i10].toString());
                i10++;
            } else {
                return zArr;
            }
        }
    }

    private Set<String> getSelectedValues() {
        HashSet hashSet = new HashSet();
        boolean[] checkBoxStates = this.mAdapter.getCheckBoxStates();
        for (int i10 = 0; i10 < checkBoxStates.length; i10++) {
            CharSequence[] charSequenceArr = this.mEntryValues;
            if (i10 >= charSequenceArr.length) {
                break;
            }
            if (checkBoxStates[i10]) {
                hashSet.add(charSequenceArr[i10].toString());
            }
        }
        return hashSet;
    }

    public static COUIMultiSelectListPreferenceDialogFragment newInstance(String str) {
        COUIMultiSelectListPreferenceDialogFragment cOUIMultiSelectListPreferenceDialogFragment = new COUIMultiSelectListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        cOUIMultiSelectListPreferenceDialogFragment.setArguments(bundle);
        return cOUIMultiSelectListPreferenceDialogFragment;
    }

    @Override // androidx.preference.d, androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            COUIMultiSelectListPreference cOUIMultiSelectListPreference = (COUIMultiSelectListPreference) getPreference();
            this.mPreference = cOUIMultiSelectListPreference;
            this.mDialogTitle = cOUIMultiSelectListPreference.getDialogTitle();
            this.mDialogMessage = this.mPreference.getDialogMessage();
            this.mEntries = this.mPreference.getEntries();
            this.mEntryValues = this.mPreference.getEntryValues();
            this.mSummaries = this.mPreference.getSummaries();
            this.mPositiveButtonText = this.mPreference.getPositiveButtonText();
            this.mNegativeButtonText = this.mPreference.getNegativeButtonText();
            this.mCheckboxStates = getCheckboxStatesFromValues(this.mPreference.getValues());
            this.mIfFollowHand = this.mPreference.isIfFollowHand();
            this.mBlurBackground = this.mPreference.isBlurBackground();
            this.mBlurMinAnimLevel = this.mPreference.getBlurMinAnimLevel();
            return;
        }
        this.mDialogTitle = bundle.getString(SAVE_STATE_TITLE);
        this.mDialogMessage = bundle.getString(SAVE_STATE_MESSAGE);
        this.mEntries = bundle.getCharSequenceArray(SAVE_STATE_ENTRIES);
        this.mEntryValues = bundle.getCharSequenceArray(SAVE_STATE_ENTRY_VALUES);
        this.mSummaries = bundle.getCharSequenceArray(SAVE_STATE_SUMMARYS);
        this.mPositiveButtonText = bundle.getString(SAVE_STATE_POSITIVE_BUTTON_TEXT);
        this.mNegativeButtonText = bundle.getString(SAVE_STATE_NEGATIVE_BUTTON_TEXT);
        this.mCheckboxStates = bundle.getBooleanArray(SAVE_STATE_VALUES);
        this.mDialogPosition = bundle.getIntArray(SAVE_STATE_POSITION);
        this.mIfFollowHand = bundle.getBoolean(SAVE_STATE_FOLLOWHAND);
        this.mBlurBackground = bundle.getBoolean(SAVE_STATE_BLUR_BACKGROUND);
        this.mBlurMinAnimLevel = AnimLevel.valueOf(bundle.getInt(SAVE_STATE_BLUR_ANIM_LAVEL, UIUtil.ANIM_LEVEL_SUPPORT_BLUR_MIN.getIntValue()));
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public Dialog onCreateDialog(Bundle bundle) {
        Point point;
        View view;
        this.mAdapter = new ChoiceListAdapter(getContext(), j.f4983n, this.mEntries, this.mSummaries, this.mCheckboxStates, true) { // from class: com.coui.appcompat.preference.COUIMultiSelectListPreferenceDialogFragment.1
            @Override // com.coui.appcompat.dialog.adapter.ChoiceListAdapter, android.widget.Adapter
            public View getView(int i10, View view2, ViewGroup viewGroup) {
                View view3 = super.getView(i10, view2, viewGroup);
                View findViewById = view3.findViewById(h.f4902S);
                int count = getCount();
                if (findViewById != null) {
                    if (count != 1 && i10 != count - 1) {
                        findViewById.setVisibility(0);
                    } else {
                        findViewById.setVisibility(8);
                    }
                }
                return view3;
            }
        };
        Context context = getContext();
        Objects.requireNonNull(context);
        COUIAlertDialogBuilder blurBackgroundDrawable = new COUIAlertDialogBuilder(context, n.f5033e).setTitle(this.mDialogTitle).setMessage(this.mDialogMessage).setAdapter((ListAdapter) this.mAdapter, (DialogInterface.OnClickListener) this).setPositiveButton(this.mPositiveButtonText, (DialogInterface.OnClickListener) this).setNegativeButton(this.mNegativeButtonText, (DialogInterface.OnClickListener) this).setBlurBackgroundDrawable(this.mBlurBackground, this.mBlurMinAnimLevel);
        this.mBuilder = blurBackgroundDrawable;
        if (this.mIfFollowHand) {
            Point point2 = new Point();
            COUIMultiSelectListPreference cOUIMultiSelectListPreference = this.mPreference;
            if (cOUIMultiSelectListPreference != null) {
                view = cOUIMultiSelectListPreference.getPreferenceView();
                point = this.mPreference.getLastTouchPoint();
            } else {
                point = point2;
                view = null;
            }
            if (this.mDialogPosition != null) {
                int[] iArr = this.mDialogPosition;
                point = new Point(iArr[0], iArr[1]);
            }
            return this.mBuilder.create(view, point);
        }
        return blurBackgroundDrawable.create();
    }

    @Override // androidx.preference.d, androidx.preference.f
    public void onDialogClosed(boolean z10) {
        COUIMultiSelectListPreference cOUIMultiSelectListPreference;
        super.onDialogClosed(z10);
        if (!z10) {
            return;
        }
        Set<String> selectedValues = getSelectedValues();
        if (getPreference() != null && (cOUIMultiSelectListPreference = (COUIMultiSelectListPreference) getPreference()) != null && cOUIMultiSelectListPreference.callChangeListener(selectedValues)) {
            cOUIMultiSelectListPreference.setValues(selectedValues);
        }
    }

    @Override // androidx.preference.d, androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBooleanArray(SAVE_STATE_VALUES, this.mAdapter.getCheckBoxStates());
        CharSequence charSequence = this.mDialogTitle;
        if (charSequence != null) {
            bundle.putString(SAVE_STATE_TITLE, String.valueOf(charSequence));
        }
        CharSequence charSequence2 = this.mDialogMessage;
        if (charSequence2 != null) {
            bundle.putString(SAVE_STATE_MESSAGE, String.valueOf(charSequence2));
        }
        bundle.putString(SAVE_STATE_POSITIVE_BUTTON_TEXT, String.valueOf(this.mPositiveButtonText));
        bundle.putString(SAVE_STATE_NEGATIVE_BUTTON_TEXT, String.valueOf(this.mNegativeButtonText));
        bundle.putCharSequenceArray(SAVE_STATE_SUMMARYS, this.mSummaries);
        int[] iArr = {getDialog().getWindow().getAttributes().x, getDialog().getWindow().getAttributes().y};
        this.mDialogPosition = iArr;
        bundle.putIntArray(SAVE_STATE_POSITION, iArr);
        bundle.putBoolean(SAVE_STATE_FOLLOWHAND, this.mIfFollowHand);
        bundle.putBoolean(SAVE_STATE_BLUR_BACKGROUND, this.mBlurBackground);
        bundle.putInt(SAVE_STATE_BLUR_ANIM_LAVEL, this.mBlurMinAnimLevel.getIntValue());
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (getPreference() == null) {
            dismiss();
            return;
        }
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = this.mBuilder;
        if (cOUIAlertDialogBuilder != null) {
            cOUIAlertDialogBuilder.updateViewAfterShown();
        }
    }
}
