package com.android.contacts.framework.api.togoogle;

import android.content.Context;
import kotlin.jvm.internal.i;

/* compiled from: MoveToGoogleManager.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15622a = new a();

    public static final boolean c() {
        if (MoveToGoogleApi.f15618a.a() != null) {
            return true;
        }
        return false;
    }

    public static final void e(Context context) {
        i.f(context, "context");
        MoveToGoogleApi a10 = MoveToGoogleApi.f15618a.a();
        if (a10 != null) {
            a10.d(context);
        }
    }

    public final void a() {
        MoveToGoogleApi a10 = MoveToGoogleApi.f15618a.a();
        if (a10 != null) {
            a10.c();
        }
    }

    public final boolean b() {
        MoveToGoogleApi a10 = MoveToGoogleApi.f15618a.a();
        if (a10 != null && a10.b()) {
            return true;
        }
        return false;
    }

    public final void d(Context context) {
        i.f(context, "context");
        MoveToGoogleApi a10 = MoveToGoogleApi.f15618a.a();
        if (a10 != null) {
            a10.a(context);
        }
    }
}
