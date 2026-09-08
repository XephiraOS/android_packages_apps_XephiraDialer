package com.customize.contacts.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.text.TextUtils;
import android.widget.AbsListView;
import com.android.contacts.ContactsApplication;
import com.oplus.contacts.common.ContactParcelable;
import com.oplus.dialer.R;
import com.oplus.foundation.util.OsUtils;
import java.util.ArrayList;
import java.util.List;
import w0.C1641a;

/* compiled from: ContactsUtils.java */
/* renamed from: com.customize.contacts.util.w, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0811w {

    /* renamed from: a, reason: collision with root package name */
    public static String f22186a;

    public static ArrayList<ContactParcelable> a(ArrayList<com.coloros.contacts.common.ContactParcelable> arrayList) {
        ArrayList<ContactParcelable> arrayList2 = new ArrayList<>();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            com.coloros.contacts.common.ContactParcelable contactParcelable = arrayList.get(i10);
            ContactParcelable contactParcelable2 = new ContactParcelable();
            contactParcelable2.m(contactParcelable.k());
            contactParcelable2.n(contactParcelable.getName());
            contactParcelable2.p(contactParcelable.n());
            contactParcelable2.q(contactParcelable.p());
            contactParcelable2.h(contactParcelable.j());
            contactParcelable2.i(contactParcelable.m());
            arrayList2.add(contactParcelable2);
        }
        return arrayList2;
    }

    public static String b(Context context, String str) {
        if (context == null) {
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(f22186a) && context != null) {
            f22186a = context.getString(R.string.gallery_pkg);
        }
        return f22186a;
    }

    public static String d(Context context, String str) {
        String f10 = C1641a.f(str);
        if (f10 != null) {
            return f10;
        }
        return context.getString(R.string.voicemail);
    }

    public static boolean e() {
        if (ContactsApplication.h().getResources().getInteger(R.integer.product_flavor) == 1) {
            return true;
        }
        return false;
    }

    public static boolean f() {
        if (ContactsApplication.h().getResources().getInteger(R.integer.product_flavor) == 2) {
            return true;
        }
        return false;
    }

    public static boolean g(List<?> list) {
        if (list != null && !list.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean h(Context context) {
        boolean z10 = true;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo("com.android.mms", 128).metaData;
            if (bundle != null) {
                z10 = true ^ TextUtils.equals("close", bundle.getString("rcs_group_chat"));
            }
        } catch (PackageManager.NameNotFoundException e10) {
            H7.b.c("ContactsUtils", "e = " + e10);
        }
        if (H7.a.b()) {
            H7.b.b("ContactsUtils", "show = " + z10);
        }
        return z10;
    }

    public static boolean i(Context context, String str) {
        boolean z10 = false;
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                Cursor query = context.getContentResolver().query(R0.d.c(str).buildUpon().appendQueryParameter("query_vip", "true").build(), new String[]{"is_vip"}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            if (query.getInt(0) > 0) {
                                z10 = true;
                            }
                        }
                    } finally {
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e10) {
                H7.b.c("ContactsUtils", "Exception:" + e10);
            }
            if (H7.a.b()) {
                H7.b.b("ContactsUtils", "isVipContact = " + z10 + ", number = " + H7.a.d(str));
            }
        }
        return z10;
    }

    public static void j(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str) {
        if (OsUtils.f28279e) {
            try {
                context.registerReceiver(broadcastReceiver, new IntentFilter(str), 2);
                return;
            } catch (Exception e10) {
                H7.b.c("ContactsUtils", "e =" + e10);
                return;
            }
        }
        intentFilter.addAction(str);
    }

    public static void k(Activity activity, ArrayList<com.coloros.contacts.common.ContactParcelable> arrayList) {
        l(activity, arrayList, false);
    }

    public static void l(Activity activity, ArrayList<com.coloros.contacts.common.ContactParcelable> arrayList, boolean z10) {
        Intent intent = new Intent();
        if (z10) {
            intent.putParcelableArrayListExtra("SELECTED_CONTACTS", a(arrayList));
        } else {
            intent.putParcelableArrayListExtra("SELECTED_CONTACTS", arrayList);
        }
        activity.setResult(-1, intent);
    }

    public static void m(AbsListView absListView) {
        try {
            if (C7.b.a(30, 1)) {
                new com.oplus.wrapper.widget.AbsListView(absListView).setFlingMode(D7.a.d());
            } else {
                U6.a.a(absListView, D7.a.d());
            }
        } catch (Throwable th) {
            H7.b.e("ContactsUtils", "Throwable e : " + th);
        }
    }

    public static void n(Context context, Uri uri) {
        if (uri != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.putNull("lookup_uri");
            G7.c.g(context.getContentResolver(), CallLog.Calls.CONTENT_URI, contentValues, "lookup_uri= ?", new String[]{uri.toString()});
        }
    }
}
