package com.oplus.blacklistapp.framework.api.appstore.virtualsupport;

import android.content.Context;

/* compiled from: VirtualSupportManager.kt */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f27228a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final IVirtualSupportApi f27229b = IVirtualSupportApi.f27222a.a();

    public static final void a(Context context) {
        IVirtualSupportApi iVirtualSupportApi = f27229b;
        if (iVirtualSupportApi != null) {
            iVirtualSupportApi.init(context);
        }
    }
}
