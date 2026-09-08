package com.android.contacts.framework.api.infocollection;

import android.content.Context;
import kotlin.jvm.internal.i;

/* compiled from: UserInfoCollectionManager.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15581a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final IUserInfoCollectionManager f15582b = IUserInfoCollectionManager.f15577a.a();

    public static final void a(int i10) {
        IUserInfoCollectionManager iUserInfoCollectionManager = f15582b;
        if (iUserInfoCollectionManager != null) {
            iUserInfoCollectionManager.d(i10);
        }
    }

    public static final void b(int i10, String str) {
        IUserInfoCollectionManager iUserInfoCollectionManager = f15582b;
        if (iUserInfoCollectionManager != null) {
            iUserInfoCollectionManager.c(i10, str);
        }
    }

    public static final void c() {
        IUserInfoCollectionManager iUserInfoCollectionManager = f15582b;
        if (iUserInfoCollectionManager != null) {
            iUserInfoCollectionManager.b();
        }
    }

    public static final void d(Context context) {
        i.f(context, "context");
        IUserInfoCollectionManager iUserInfoCollectionManager = f15582b;
        if (iUserInfoCollectionManager != null) {
            iUserInfoCollectionManager.a(context);
        }
    }
}
