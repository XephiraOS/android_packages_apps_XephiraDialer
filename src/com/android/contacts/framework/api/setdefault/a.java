package com.android.contacts.framework.api.setdefault;

import android.app.Activity;
import com.oplus.foundation.util.OsUtils;
import kotlin.jvm.internal.i;

/* compiled from: SetDefaultManager.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15616a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f15617b = OsUtils.f28279e;

    public static final boolean b(Activity activity) {
        SetDefaultApi a10;
        i.f(activity, "activity");
        if (f15617b && (a10 = SetDefaultApi.f15612a.a()) != null && a10.a(activity)) {
            return true;
        }
        return false;
    }

    public final void a(Activity activity) {
        SetDefaultApi a10;
        i.f(activity, "activity");
        if (f15617b && (a10 = SetDefaultApi.f15612a.a()) != null) {
            a10.b(activity);
        }
    }
}
