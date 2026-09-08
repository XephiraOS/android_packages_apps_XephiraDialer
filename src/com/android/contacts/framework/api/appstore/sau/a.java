package com.android.contacts.framework.api.appstore.sau;

import android.content.Context;
import kotlin.jvm.internal.i;

/* compiled from: SauManager.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15548a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static ISauApi f15549b = ISauApi.f15544a.a();

    public static final void a(Context context) {
        i.f(context, "context");
        ISauApi iSauApi = f15549b;
        if (iSauApi != null) {
            iSauApi.a(context);
        }
    }
}
