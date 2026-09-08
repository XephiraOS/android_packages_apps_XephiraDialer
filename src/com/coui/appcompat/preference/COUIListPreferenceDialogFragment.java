package com.coui.appcompat.preference;

import X8.h;
import X8.n;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.preference.c;
import b9.j;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.dialog.adapter.ChoiceListAdapter;
import com.coui.appcompat.uiutil.AnimLevel;
import com.coui.appcompat.uiutil.UIUtil;

/* loaded from: classes.dex */
public class COUIListPreferenceDialogFragment extends c {
    private static final String SAVE_STATE_BLUR_ANIM_LAVEL = "ListPreferenceDialogFragment.SAVE_STATE_BLUR_ANIM_LAVEL";
    private static final String SAVE_STATE_BLUR_BACKGROUND = "ListPreferenceDialogFragment.SAVE_STATE_BLUR_BACKGROUND";
    private static final String SAVE_STATE_ENTRIES = "ListPreferenceDialogFragment.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "ListPreferenceDialogFragment.entryValues";
    private static final String SAVE_STATE_FOLLOWHAND = "ListPreferenceDialogFragment.SAVE_STATE_FOLLOWHAND";
    private static final String SAVE_STATE_INDEX = "COUIListPreferenceDialogFragment.index";
    private static final String SAVE_STATE_MESSAGE = "COUIListPreferenceDialogFragment.message";
    private static final String SAVE_STATE_POSITION = "ListPreferenceDialogFragment.SAVE_STATE_POSITION";
    private static final String SAVE_STATE_SUMMARYS = "COUListPreferenceDialogFragment.summarys";
    private static final String SAVE_STATE_TITLE = "COUIListPreferenceDialogFragment.title";
    private COUIAlertDialogBuilder mBuilder;
    private CharSequence mDialogMessage;
    private int[] mDialogPosition;
    private CharSequence mDialogTitle;
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;
    private COUIListPreference mPreference;
    private CharSequence[] mSummaries;
    private int mClickedDialogEntryIndex = -1;
    private boolean mIfFollowHand = true;
    private boolean mBlurBackground = false;
    private AnimLevel mBlurMinAnimLevel = UIUtil.ANIM_LEVEL_SUPPORT_BLUR_MIN;

    public static COUIListPreferenceDialogFragment newInstance(String str) {
        COUIListPreferenceDialogFragment cOUIListPreferenceDialogFragment = new COUIListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        cOUIListPreferenceDialogFragment.setArguments(bundle);
        return cOUIListPreferenceDialogFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveSelectedIndex() {
        int i10 = this.mClickedDialogEntryIndex;
        if (i10 >= 0) {
            CharSequence[] charSequenceArr = this.mEntryValues;
            if (i10 < charSequenceArr.length) {
                String charSequence = charSequenceArr[i10].toString();
                if (getPreference() != null) {
                    COUIListPreference cOUIListPreference = (COUIListPreference) getPreference();
                    if (cOUIListPreference.callChangeListener(charSequence)) {
                        cOUIListPreference.setValue(charSequence);
                    }
                }
            }
        }
    }

    @Override // androidx.preference.c, androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            COUIListPreference cOUIListPreference = (COUIListPreference) getPreference();
            this.mPreference = cOUIListPreference;
            if (cOUIListPreference.getEntries() != null && this.mPreference.getEntryValues() != null) {
                this.mDialogTitle = this.mPreference.getDialogTitle();
                this.mDialogMessage = this.mPreference.getDialogMessage();
                this.mSummaries = this.mPreference.getSummaries();
                COUIListPreference cOUIListPreference2 = this.mPreference;
                this.mClickedDialogEntryIndex = cOUIListPreference2.findIndexOfValue(cOUIListPreference2.getValue());
                this.mEntries = this.mPreference.getEntries();
                this.mEntryValues = this.mPreference.getEntryValues();
                this.mIfFollowHand = this.mPreference.isIfFollowHand();
                this.mBlurBackground = this.mPreference.isBlurBackground();
                this.mBlurMinAnimLevel = this.mPreference.getBlurMinAnimLevel();
                return;
            }
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.mClickedDialogEntryIndex = bundle.getInt(SAVE_STATE_INDEX, -1);
        this.mDialogTitle = bundle.getString(SAVE_STATE_TITLE);
        this.mDialogMessage = bundle.getString(SAVE_STATE_MESSAGE);
        this.mEntries = bundle.getCharSequenceArray(SAVE_STATE_ENTRIES);
        this.mEntryValues = bundle.getCharSequenceArray(SAVE_STATE_ENTRY_VALUES);
        this.mSummaries = bundle.getCharSequenceArray(SAVE_STATE_SUMMARYS);
        this.mDialogPosition = bundle.getIntArray(SAVE_STATE_POSITION);
        this.mIfFollowHand = bundle.getBoolean(SAVE_STATE_FOLLOWHAND);
        this.mBlurBackground = bundle.getBoolean(SAVE_STATE_BLUR_BACKGROUND);
        this.mBlurMinAnimLevel = AnimLevel.valueOf(bundle.getInt(SAVE_STATE_BLUR_ANIM_LAVEL, UIUtil.ANIM_LEVEL_SUPPORT_BLUR_MIN.getIntValue()));
    }

    @Override // androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public Dialog onCreateDialog(Bundle bundle) {
        boolean[] zArr;
        int i10;
        CharSequence[] charSequenceArr = this.mEntries;
        View view = null;
        if (charSequenceArr != null && (i10 = this.mClickedDialogEntryIndex) >= 0 && i10 < charSequenceArr.length) {
            boolean[] zArr2 = new boolean[charSequenceArr.length];
            zArr2[i10] = true;
            zArr = zArr2;
        } else {
            zArr = null;
        }
        COUIAlertDialogBuilder adapter = new COUIAlertDialogBuilder(requireContext(), n.f5033e).setTitle(this.mDialogTitle).setMessage(this.mDialogMessage).setNegativeButton(j.f12522d, (DialogInterface.OnClickListener) null).setBlurBackgroundDrawable(this.mBlurBackground, this.mBlurMinAnimLevel).setAdapter((ListAdapter) new ChoiceListAdapter(getContext(), X8.j.f4984o, this.mEntries, this.mSummaries, zArr, false) { // from class: com.coui.appcompat.preference.COUIListPreferenceDialogFragment.1
            @Override // com.coui.appcompat.dialog.adapter.ChoiceListAdapter, android.widget.Adapter
            public View getView(int i11, View view2, ViewGroup viewGroup) {
                View view3 = super.getView(i11, view2, viewGroup);
                View findViewById = view3.findViewById(h.f4902S);
                int count = getCount();
                if (findViewById != null) {
                    if (count != 1 && i11 != count - 1) {
                        findViewById.setVisibility(0);
                    } else {
                        findViewById.setVisibility(8);
                    }
                }
                return view3;
            }
        }, new DialogInterface.OnClickListener() { // from class: com.coui.appcompat.preference.COUIListPreferenceDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i11) {
                COUIListPreferenceDialogFragment.this.mClickedDialogEntryIndex = i11;
                COUIListPreferenceDialogFragment.this.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
                COUIListPreferenceDialogFragment.this.saveSelectedIndex();
            }
        });
        this.mBuilder = adapter;
        if (this.mIfFollowHand) {
            Point point = new Point();
            COUIListPreference cOUIListPreference = this.mPreference;
            if (cOUIListPreference != null) {
                view = cOUIListPreference.getPreferenceView();
                point = this.mPreference.getLastTouchPoint();
            }
            if (this.mDialogPosition != null) {
                int[] iArr = this.mDialogPosition;
                point = new Point(iArr[0], iArr[1]);
            }
            return this.mBuilder.create(view, point);
        }
        return adapter.create();
    }

    @Override // androidx.preference.c, androidx.preference.f
    public void onDialogClosed(boolean z10) {
        super.onDialogClosed(z10);
        if (z10 && this.mEntries != null) {
            saveSelectedIndex();
        }
    }

    @Override // androidx.preference.c, androidx.preference.f, androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(SAVE_STATE_INDEX, this.mClickedDialogEntryIndex);
        CharSequence charSequence = this.mDialogTitle;
        if (charSequence != null) {
            bundle.putString(SAVE_STATE_TITLE, String.valueOf(charSequence));
        }
        CharSequence charSequence2 = this.mDialogMessage;
        if (charSequence2 != null) {
            bundle.putString(SAVE_STATE_MESSAGE, String.valueOf(charSequence2));
        }
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
