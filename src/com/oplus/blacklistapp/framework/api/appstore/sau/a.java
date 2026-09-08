package com.oplus.blacklistapp.framework.api.appstore.sau;

import android.content.Context;
import kotlin.jvm.internal.i;

/* compiled from: SauManager.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f27216a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final ISauApi f27217b = ISauApi.f27212a.a();

    public static final void a(Context context) {
        i.f(context, "context");
        ISauApi iSauApi = f27217b;
        if (iSauApi != null) {
            iSauApi.a(context);
        }
    }
}
