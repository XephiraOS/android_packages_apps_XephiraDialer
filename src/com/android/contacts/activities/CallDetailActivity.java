package com.android.contacts.activities;

import C7.e;
import H7.b;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import com.android.contacts.ContactsActivity;
import com.android.contacts.calllog.x;
import com.android.contacts.detail.DetailActivityFragment;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.CommonFeatureOption;

/* loaded from: classes.dex */
public class CallDetailActivity extends ContactsActivity {

    /* renamed from: q, reason: collision with root package name */
    public DetailActivityFragment f13600q = null;

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean H0() {
        return true;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean Q0() {
        return false;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (e.c(getIntent(), "open_from_dialog", false)) {
            overridePendingTransition(R.anim.dialog_open_enter, R.anim.dialog_open_exit);
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean o1() {
        return CommonFeatureOption.o(this);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof DetailActivityFragment) {
            this.f13600q = (DetailActivityFragment) fragment;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        DetailActivityFragment detailActivityFragment = this.f13600q;
        if (detailActivityFragment != null && detailActivityFragment.N3()) {
            return;
        }
        try {
            super.onBackPressed();
        } catch (Exception e10) {
            b.c("CallDetailActivity", "DetailActivity onBackPressed " + e10);
            finish();
        }
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (RequestPermissionsActivity.p2(this)) {
            return;
        }
        setContentView(p1());
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (isChangingConfigurations()) {
            x.b(this).a();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        DetailActivityFragment detailActivityFragment = this.f13600q;
        if (detailActivityFragment != null && detailActivityFragment.U3(i10, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    public int p1() {
        return R.layout.contact_call_detail_activity_fragment;
    }
}
