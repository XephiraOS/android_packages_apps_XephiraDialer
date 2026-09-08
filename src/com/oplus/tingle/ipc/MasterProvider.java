package com.oplus.tingle.ipc;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import m8.C1346c;

/* loaded from: classes3.dex */
public class MasterProvider extends ContentProvider {
    public static Object b() {
        return b.a();
    }

    public static Object d() {
        return b.b();
    }

    public final IBinder a() {
        if (L8.b.a()) {
            return Master.N7();
        }
        return (IBinder) b();
    }

    public final String c() {
        if (L8.b.a()) {
            return "com.oplus.permission.safe.SECURITY";
        }
        return (String) d();
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String str, String str2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (!e()) {
            L8.a.c("MasterProvider", "<CALL> Calling package : [" + getCallingPackage() + "] have no permission : " + c(), new Object[0]);
            bundle2.putBinder(D8.a.e(), null);
            return bundle2;
        }
        if ("sendBinder".equals(str)) {
            bundle2.putBinder(D8.a.e(), a());
        }
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final boolean e() {
        if (q8.c.e().g() || getContext().checkCallingPermission(c()) == 0) {
            return true;
        }
        return false;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        L8.a.b("MasterProvider", "Provider onCreate", new Object[0]);
        C1346c.a().c(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!e()) {
            L8.a.c("MasterProvider", "<QUERY> Calling package : [" + getCallingPackage() + "] have no permission : " + c(), new Object[0]);
            return null;
        }
        return E8.a.a(a());
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
