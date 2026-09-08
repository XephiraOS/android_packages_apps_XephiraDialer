package com.android.contacts.framework.api.breenocall;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import kotlin.jvm.internal.i;

/* compiled from: BreenoCallCompat.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15560a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final IBreenoCallCompatApi f15561b = IBreenoCallCompatApi.f15556a.a();

    public static final void a(Context Context, String uniqueId, int i10) {
        i.f(Context, "Context");
        i.f(uniqueId, "uniqueId");
        IBreenoCallCompatApi iBreenoCallCompatApi = f15561b;
        if (iBreenoCallCompatApi != null) {
            iBreenoCallCompatApi.checkStartBreenoCall(Context, uniqueId, i10);
        }
    }

    public static final void b(Context context, ArrayList<String> callUniqueIds) {
        i.f(context, "context");
        i.f(callUniqueIds, "callUniqueIds");
        IBreenoCallCompatApi iBreenoCallCompatApi = f15561b;
        if (iBreenoCallCompatApi != null) {
            iBreenoCallCompatApi.deleteBreenoCallLog(context, callUniqueIds);
        }
    }

    public static final boolean c(Context context) {
        i.f(context, "context");
        IBreenoCallCompatApi iBreenoCallCompatApi = f15561b;
        if (iBreenoCallCompatApi != null) {
            return iBreenoCallCompatApi.isCallSummaryOpen(context);
        }
        return false;
    }

    public static final boolean d() {
        IBreenoCallCompatApi iBreenoCallCompatApi = f15561b;
        if (iBreenoCallCompatApi != null) {
            return iBreenoCallCompatApi.isSupportBreenoCall();
        }
        return false;
    }

    public static final boolean e(boolean z10) {
        IBreenoCallCompatApi iBreenoCallCompatApi = f15561b;
        if (iBreenoCallCompatApi != null) {
            return iBreenoCallCompatApi.isSupportCallSummary(z10);
        }
        return false;
    }

    public static final Intent f() {
        IBreenoCallCompatApi iBreenoCallCompatApi = f15561b;
        if (iBreenoCallCompatApi != null) {
            return iBreenoCallCompatApi.jumpToSettingUIIntent();
        }
        return null;
    }

    public static final void g(Runnable runnable) {
        i.f(runnable, "runnable");
        IBreenoCallCompatApi iBreenoCallCompatApi = f15561b;
        if (iBreenoCallCompatApi != null) {
            iBreenoCallCompatApi.updateBreenoCallSupport(runnable);
        }
    }
}
