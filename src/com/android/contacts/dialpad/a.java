package com.android.contacts.dialpad;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import com.android.contacts.activities.CallDetailActivity;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;

/* compiled from: ContactsArrays.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f14908a = {BreenoCallContract.BaseColumns._ID, "display_name", "phone_number", "data9", "index_type", "countryiso", "hasRecog"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f14909b = {BreenoCallContract.BaseColumns._ID, "display_name", "phone_number", "data9", "index_type", "countryiso", "hasRecog", "simid", "roam_call_type", OplusAutoRedialNotificationUI.TYPE, BreenoCallContract.BaseColumns.DATE};

    public static String[] a() {
        if (CommonOSPublicFeature.h()) {
            return f14909b;
        }
        return f14908a;
    }

    public static void b(Context context, long j10, String str, String str2) {
        Uri withAppendedId = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, j10);
        try {
            Intent intent = new Intent(context, (Class<?>) CallDetailActivity.class);
            intent.setData(withAppendedId);
            intent.putExtra("number", str);
            intent.putExtra("countryiso", str2);
            R7.b.c(context, intent);
        } catch (Exception unused) {
            com.oplus.foundation.util.ui.c.d(context, R.string.no_contact_found);
        }
    }
}
