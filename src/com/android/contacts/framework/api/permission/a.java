package com.android.contacts.framework.api.permission;

import java.util.List;

/* compiled from: PermissionCompat.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15595a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static IPermissionApi f15596b = IPermissionApi.f15591a.a();

    public static final List<String> a() {
        IPermissionApi iPermissionApi = f15596b;
        if (iPermissionApi != null) {
            return iPermissionApi.a();
        }
        return null;
    }

    public static final boolean b() {
        IPermissionApi iPermissionApi = f15596b;
        if (iPermissionApi != null) {
            return iPermissionApi.b();
        }
        return true;
    }
}
