package com.android.contacts.framework.api.rcs;

import android.content.Context;
import com.android.contacts.framework.api.rcs.IRcsApi;
import kotlin.jvm.internal.i;

/* compiled from: RcsManager.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15601a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static IRcsApi f15602b = IRcsApi.f15597a.a();

    public static final String a(String phoneNumber) {
        String f10;
        i.f(phoneNumber, "phoneNumber");
        IRcsApi iRcsApi = f15602b;
        if (iRcsApi == null || (f10 = iRcsApi.f(phoneNumber)) == null) {
            return "";
        }
        return f10;
    }

    public static final String b() {
        String c10;
        IRcsApi iRcsApi = f15602b;
        if (iRcsApi == null || (c10 = iRcsApi.c()) == null) {
            return "";
        }
        return c10;
    }

    public static final boolean c(String str) {
        IRcsApi iRcsApi = f15602b;
        if (iRcsApi != null) {
            return iRcsApi.a(str);
        }
        return false;
    }

    public static final void d(Context context, boolean z10) {
        i.f(context, "context");
        IRcsApi iRcsApi = f15602b;
        if (iRcsApi != null) {
            iRcsApi.e(context, z10);
        }
    }

    public static final boolean e() {
        IRcsApi iRcsApi = f15602b;
        if (iRcsApi != null) {
            return iRcsApi.d();
        }
        return false;
    }

    public static final void f(String phoneNumber, IRcsApi.a listener, boolean z10) {
        i.f(phoneNumber, "phoneNumber");
        i.f(listener, "listener");
        IRcsApi iRcsApi = f15602b;
        if (iRcsApi != null) {
            iRcsApi.b(phoneNumber, listener, z10);
        }
    }
}
