package com.android.contacts.activities;

import android.app.Activity;

/* loaded from: classes.dex */
public class RequestImportVCardPermissionsActivity extends RequestPermissionsActivity {

    /* renamed from: G, reason: collision with root package name */
    public static final String[] f13642G = {"android.permission.GET_ACCOUNTS", "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"};

    public static boolean q2(Activity activity, boolean z10) {
        return RequestPermissionsActivityBase.n2(activity, f13642G, z10, RequestImportVCardPermissionsActivity.class);
    }

    @Override // com.android.contacts.activities.RequestPermissionsActivity, com.android.contacts.activities.RequestPermissionsActivityBase
    public String[] N1() {
        return f13642G;
    }
}
