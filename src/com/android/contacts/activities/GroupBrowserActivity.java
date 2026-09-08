package com.android.contacts.activities;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.android.contacts.ContactsActivity;
import com.android.contacts.group.GroupBrowserActivityFragment;
import com.oplus.dialer.R;
import kotlin.jvm.internal.i;

/* compiled from: GroupBrowserActivity.kt */
/* loaded from: classes.dex */
public final class GroupBrowserActivity extends ContactsActivity {

    /* renamed from: q, reason: collision with root package name */
    public GroupBrowserActivityFragment f13639q;

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean H0() {
        return true;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean K0() {
        GroupBrowserActivityFragment groupBrowserActivityFragment = this.f13639q;
        if (groupBrowserActivityFragment == null || !groupBrowserActivityFragment.f3()) {
            return false;
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(Fragment fragment) {
        i.f(fragment, "fragment");
        super.onAttachFragment(fragment);
        if (fragment instanceof GroupBrowserActivityFragment) {
            this.f13639q = (GroupBrowserActivityFragment) fragment;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        GroupBrowserActivityFragment groupBrowserActivityFragment = this.f13639q;
        if (groupBrowserActivityFragment != null && groupBrowserActivityFragment.h3()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.group_browser_activity_fragment);
    }
}
