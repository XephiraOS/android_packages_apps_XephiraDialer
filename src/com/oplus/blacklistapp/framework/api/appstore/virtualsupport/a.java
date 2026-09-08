package com.oplus.blacklistapp.framework.api.appstore.virtualsupport;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.oplus.blacklistapp.framework.api.appstore.virtualsupport.IGrpcApi;
import kotlin.jvm.internal.i;

/* compiled from: GrpcManager.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f27226a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final IGrpcApi f27227b = IGrpcApi.f27218a.a();

    /* compiled from: GrpcManager.kt */
    /* renamed from: com.oplus.blacklistapp.framework.api.appstore.virtualsupport.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0245a implements IGrpcApi.a {
    }

    public static final Cursor a(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        IGrpcApi iGrpcApi = f27227b;
        if (iGrpcApi != null) {
            return iGrpcApi.c(context, uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    public static final IGrpcApi.a b() {
        IGrpcApi.a d10;
        IGrpcApi iGrpcApi = f27227b;
        if (iGrpcApi == null || (d10 = iGrpcApi.d()) == null) {
            return new C0245a();
        }
        return d10;
    }

    public static final void c(Context context, IGrpcApi.a queryCallBack) {
        i.f(context, "context");
        i.f(queryCallBack, "queryCallBack");
        IGrpcApi iGrpcApi = f27227b;
        if (iGrpcApi != null) {
            iGrpcApi.b(context, queryCallBack);
        }
    }

    public static final boolean d(String callingPackage) {
        i.f(callingPackage, "callingPackage");
        IGrpcApi iGrpcApi = f27227b;
        if (iGrpcApi != null) {
            return iGrpcApi.a(callingPackage);
        }
        return false;
    }
}
