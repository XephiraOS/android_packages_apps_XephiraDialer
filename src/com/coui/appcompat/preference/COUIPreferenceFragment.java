package com.coui.appcompat.preference;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.g;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import b9.C0539i;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;

/* loaded from: classes.dex */
public class COUIPreferenceFragment extends g {
    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    private boolean mEnableInternalDivider = true;
    private COUIPreferenceItemDecoration mPreferenceItemDecoration;

    public COUIPreferenceItemDecoration getItemDecoration() {
        return this.mPreferenceItemDecoration;
    }

    @Override // androidx.preference.g
    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) layoutInflater.inflate(C0539i.f12512n, viewGroup, false);
        cOUIRecyclerView.setEnablePointerDownAction(false);
        cOUIRecyclerView.setLayoutManager(onCreateLayoutManager());
        COUIDarkModeUtil.setForceDarkAllow(cOUIRecyclerView, false);
        return cOUIRecyclerView;
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        setDivider(null);
        setDividerHeight(0);
        return onCreateView;
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onDestroyView() {
        COUIPreferenceItemDecoration cOUIPreferenceItemDecoration = this.mPreferenceItemDecoration;
        if (cOUIPreferenceItemDecoration != null) {
            cOUIPreferenceItemDecoration.onDestroy();
        }
        super.onDestroyView();
    }

    @Override // androidx.preference.g, androidx.preference.j.a
    public void onDisplayPreferenceDialog(Preference preference) {
        DialogInterfaceOnCancelListenerC0472c newInstance;
        if (getFragmentManager().m0(DIALOG_FRAGMENT_TAG) != null) {
            return;
        }
        if (preference instanceof COUIActivityDialogPreference) {
            newInstance = COUIActivityDialogFragment.newInstance(preference.getKey());
        } else if (preference instanceof COUIEditTextPreference) {
            newInstance = COUIEditTextPreferenceDialogFragment.newInstance(preference.getKey());
        } else if (preference instanceof COUIMultiSelectListPreference) {
            newInstance = COUIMultiSelectListPreferenceDialogFragment.newInstance(preference.getKey());
        } else if (preference instanceof ListPreference) {
            newInstance = COUIListPreferenceDialogFragment.newInstance(preference.getKey());
        } else {
            super.onDisplayPreferenceDialog(preference);
            return;
        }
        newInstance.setTargetFragment(this, 0);
        newInstance.show(getFragmentManager(), DIALOG_FRAGMENT_TAG);
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getListView() != null && this.mPreferenceItemDecoration != null && this.mEnableInternalDivider) {
            getListView().removeItemDecoration(this.mPreferenceItemDecoration);
            if (this.mPreferenceItemDecoration.getPreferenceScreen() == null) {
                this.mPreferenceItemDecoration = new COUIPreferenceItemDecoration(getContext(), getPreferenceScreen());
            }
            getListView().addItemDecoration(this.mPreferenceItemDecoration);
        }
    }

    public void setEnableCOUIPreferenceDivider(boolean z10) {
        this.mEnableInternalDivider = z10;
        if (z10) {
            if (getListView() != null && this.mPreferenceItemDecoration != null) {
                getListView().removeItemDecoration(this.mPreferenceItemDecoration);
                if (this.mPreferenceItemDecoration.getPreferenceScreen() == null) {
                    this.mPreferenceItemDecoration = new COUIPreferenceItemDecoration(getContext(), getPreferenceScreen());
                }
                getListView().addItemDecoration(this.mPreferenceItemDecoration);
                return;
            }
            return;
        }
        if (getListView() != null) {
            getListView().removeItemDecoration(this.mPreferenceItemDecoration);
        }
    }

    @Override // androidx.preference.g
    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        if (preferenceScreen == getPreferenceScreen()) {
            return;
        }
        super.setPreferenceScreen(preferenceScreen);
        if (this.mPreferenceItemDecoration != null && getListView() != null) {
            getListView().removeItemDecoration(this.mPreferenceItemDecoration);
        }
        this.mPreferenceItemDecoration = new COUIPreferenceItemDecoration(getContext(), preferenceScreen);
        if (getListView() != null && this.mEnableInternalDivider) {
            getListView().addItemDecoration(this.mPreferenceItemDecoration);
        }
    }

    @Override // androidx.preference.g
    public void onCreatePreferences(Bundle bundle, String str) {
    }
}
