package com.customize.contacts.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import java.util.ArrayList;

/* compiled from: ContactDetails.java */
/* renamed from: com.customize.contacts.util.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0804o {

    /* renamed from: f, reason: collision with root package name */
    public static final Uri f22145f = ContactsContract.Data.CONTENT_URI;

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f22146g = {"raw_contact_id", "starred", "mimetype", "data1"};

    /* renamed from: a, reason: collision with root package name */
    public int f22147a;

    /* renamed from: b, reason: collision with root package name */
    public long f22148b;

    /* renamed from: c, reason: collision with root package name */
    public String f22149c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<String> f22150d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<String> f22151e = new ArrayList<>();

    public static C0804o a(Context context, long j10) {
        C0804o c0804o = new C0804o();
        c0804o.c(context, j10);
        return c0804o;
    }

    public static C0804o b(Context context, long j10) {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j10));
        C0804o c0804o = new C0804o();
        c0804o.j(context, arrayList);
        return c0804o;
    }

    public static long h(Context context, long j10) {
        long j11 = 0;
        try {
            Cursor query = context.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{"name_raw_contact_id"}, "_id=" + j10, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        j11 = query.getLong(0);
                    }
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e10) {
            H7.b.c("ContactDetails", "getNameRawId: exception: " + e10);
        }
        return j11;
    }

    public final void c(Context context, long j10) {
        String str = "contact_id=" + j10;
        this.f22148b = h(context, j10);
        try {
            Cursor query = context.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{BreenoCallContract.BaseColumns._ID}, str, null, null);
            if (query != null) {
                try {
                    ArrayList<Long> arrayList = new ArrayList<>();
                    while (query.moveToNext()) {
                        arrayList.add(Long.valueOf(query.getLong(0)));
                    }
                    j(context, arrayList);
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e10) {
            H7.b.c("ContactDetails", "getDetailsByContactId: exception: " + e10);
        }
    }

    public ArrayList<String> d() {
        return this.f22151e;
    }

    public final void e(Cursor cursor) {
        String string = cursor.getString(3);
        if (!TextUtils.isEmpty(string) && !this.f22151e.contains(string)) {
            this.f22151e.add(string);
        }
        this.f22147a = cursor.getInt(1);
    }

    public String f() {
        return this.f22149c;
    }

    public final void g(Cursor cursor) {
        if (this.f22149c == null) {
            this.f22149c = cursor.getString(3);
        } else if (cursor.getLong(0) == this.f22148b) {
            this.f22149c = cursor.getString(3);
        }
        this.f22147a = cursor.getInt(1);
    }

    public ArrayList<String> i() {
        return this.f22150d;
    }

    public final void j(Context context, ArrayList<Long> arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        try {
            Cursor query = context.getContentResolver().query(f22145f, f22146g, "raw_contact_id IN " + G7.a.d(arrayList), null, "raw_contact_id ASC");
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        String string = query.getString(2);
                        if ("vnd.android.cursor.item/name".equals(string)) {
                            g(query);
                        } else if ("vnd.android.cursor.item/phone_v2".equals(string)) {
                            k(query);
                        } else if ("vnd.android.cursor.item/email_v2".equals(string)) {
                            e(query);
                        }
                    } finally {
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e10) {
            H7.b.c("ContactDetails", "getPhonesAndEmailsByRawIds: exception: " + e10);
        }
    }

    public final void k(Cursor cursor) {
        String string = cursor.getString(3);
        if (!TextUtils.isEmpty(string) && !this.f22150d.contains(string)) {
            this.f22150d.add(string);
        }
        this.f22147a = cursor.getInt(1);
    }

    public int l() {
        return this.f22147a;
    }
}
