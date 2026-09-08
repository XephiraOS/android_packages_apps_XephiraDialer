package com.android.contacts.framework.api.appstore.simcard;

import android.content.Context;
import com.android.contacts.model.Account;
import java.util.ArrayList;
import kotlin.jvm.internal.i;

/* compiled from: SimCardInfoManager.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15554a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final ISimCardApi f15555b = ISimCardApi.f15550a.a();

    public static final ArrayList<Account> a(Context context) {
        i.f(context, "context");
        ISimCardApi iSimCardApi = f15555b;
        if (iSimCardApi != null) {
            return iSimCardApi.e(context);
        }
        return null;
    }

    public static final int b(Context context, String str) {
        i.f(context, "context");
        ISimCardApi iSimCardApi = f15555b;
        if (iSimCardApi != null) {
            return iSimCardApi.c(context, str);
        }
        return -1;
    }

    public static final String c(Context context, int i10) {
        i.f(context, "context");
        ISimCardApi iSimCardApi = f15555b;
        if (iSimCardApi != null) {
            return iSimCardApi.d(context, i10);
        }
        return null;
    }

    public static final boolean d(Context context) {
        i.f(context, "context");
        ISimCardApi iSimCardApi = f15555b;
        if (iSimCardApi != null) {
            return iSimCardApi.a(context);
        }
        return false;
    }

    public static final boolean e(Context context, int i10) {
        i.f(context, "context");
        ISimCardApi iSimCardApi = f15555b;
        if (iSimCardApi != null) {
            return iSimCardApi.f(context, i10);
        }
        return false;
    }

    public static final boolean f(Context context) {
        i.f(context, "context");
        ISimCardApi iSimCardApi = f15555b;
        if (iSimCardApi != null) {
            return iSimCardApi.b(context);
        }
        return false;
    }
}
