package com.android.contacts.framework.api.appstore.missedcall;

import android.content.Context;
import android.os.Bundle;
import kotlin.jvm.internal.i;

/* compiled from: MissedCallManager.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15542a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static IMissedCallApi f15543b = IMissedCallApi.f15538a.a();

    public static final void a(Context context) {
        i.f(context, "context");
        IMissedCallApi iMissedCallApi = f15543b;
        if (iMissedCallApi != null) {
            iMissedCallApi.a(context);
        }
    }

    public static final void b(Context context, Bundle bundle) {
        i.f(context, "context");
        i.f(bundle, "bundle");
        IMissedCallApi iMissedCallApi = f15543b;
        if (iMissedCallApi != null) {
            iMissedCallApi.b(context, bundle);
        }
    }
}
