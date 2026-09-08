package com.android.contacts;

import android.net.Uri;
import android.provider.ContactsContract;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;

/* compiled from: GroupListLoader.java */
/* loaded from: classes.dex */
public final class L0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f13144a = ContactsContract.Groups.CONTENT_SUMMARY_URI;

    /* renamed from: b, reason: collision with root package name */
    public static final String f13145b = a();

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f13146c = {"account_name", "account_type", "data_set", BreenoCallContract.BaseColumns._ID, "title", "summ_count"};

    public static String a() {
        String str = R0.a.f3165a;
        if (str == null) {
            return " case when title='Vip in ColorOS' then 1 else 2 end, case when account_name IS NULL then 1 else 2 end, account_name, title COLLATE LOCALIZED ASC";
        }
        return " case when title='Vip in ColorOS' then 1 else 2 end, case when account_name='" + str + "' then 1 else 2 end, account_name, title COLLATE LOCALIZED ASC";
    }
}
