package com.android.contacts;

import android.content.Context;
import android.database.Cursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;

/* compiled from: GroupMetaDataLoader.java */
/* loaded from: classes.dex */
public final class N0 extends W.b {

    /* renamed from: x, reason: collision with root package name */
    public static final String[] f13157x = {"account_name", "account_type", "data_set", BreenoCallContract.BaseColumns._ID, "title", "auto_add", "favorites", "group_is_read_only", "deleted"};

    public N0(Context context, Uri uri) {
        super(context, U(uri), f13157x, V(), null, null);
    }

    public static Uri U(Uri uri) {
        if (uri != null) {
            if (uri.toString().startsWith(ContactsContract.Groups.CONTENT_URI.toString())) {
                return uri;
            }
            throw new IllegalArgumentException("Invalid group Uri: " + uri);
        }
        throw new IllegalArgumentException("Uri must not be null");
    }

    public static String V() {
        if (R0.a.f3165a == null) {
            return "auto_add=0 AND favorites=0 AND title!='Vip in ColorOS' AND title!='Business Card in ColorOS'";
        }
        return "account_type NOT NULL AND account_name NOT NULL AND auto_add=0 AND favorites=0 AND title!='Vip in ColorOS' AND title!='Business Card in ColorOS'";
    }

    @Override // W.b, W.a
    /* renamed from: N */
    public Cursor I() {
        try {
            return super.I();
        } catch (Exception e10) {
            MergeCursor mergeCursor = new MergeCursor(new Cursor[1]);
            H7.b.c("GroupMetaDataLoader", "ContactsLoader loadInBackground error " + e10);
            return mergeCursor;
        }
    }
}
