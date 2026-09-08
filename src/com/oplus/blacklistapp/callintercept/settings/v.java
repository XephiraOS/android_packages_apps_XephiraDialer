package com.oplus.blacklistapp.callintercept.settings;

import android.os.Bundle;
import com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment;
import com.oplus.blacklistapp.callintercept.CallInterceptController;

/* compiled from: HotPlugPreferenceFragment.java */
/* loaded from: classes3.dex */
public class v extends COUIPreferenceWithAppbarFragment implements CallInterceptController.b {
    @Override // com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment
    public String getTitle() {
        return null;
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CallInterceptController.e().d(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CallInterceptController.e().m(this);
    }

    public void u(int i10) {
        if (isAdded()) {
            requireActivity().finish();
        }
    }

    public void P0(int i10) {
    }
}
