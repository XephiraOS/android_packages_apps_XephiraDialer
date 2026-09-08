package com.customize.contacts.activities;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.android.contacts.ContactsActivity;
import com.customize.contacts.fragment.SearchFragment;
import com.oplus.dialer.R;

/* compiled from: SearchActivity.kt */
/* loaded from: classes3.dex */
public final class SearchActivity extends ContactsActivity implements SearchFragment.b {

    /* renamed from: q, reason: collision with root package name */
    public SearchFragment f20550q;

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean Q0() {
        return false;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_no, R.anim.search_exit);
    }

    @Override // com.customize.contacts.fragment.SearchFragment.b
    public void h(boolean z10) {
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        SearchFragment searchFragment = this.f20550q;
        if (searchFragment == null || !searchFragment.R3()) {
            super.onBackPressed();
        }
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.search_activity);
        Fragment l02 = getSupportFragmentManager().l0(R.id.search_fragment);
        kotlin.jvm.internal.i.d(l02, "null cannot be cast to non-null type com.customize.contacts.fragment.SearchFragment");
        this.f20550q = (SearchFragment) l02;
    }
}
