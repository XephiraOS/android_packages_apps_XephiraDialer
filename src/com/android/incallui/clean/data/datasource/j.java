package com.android.incallui.clean.data.datasource;

import com.android.incallui.Call;

/* compiled from: SecondaryCallRepository.kt */
/* loaded from: classes.dex */
public final class j extends I1.a {

    /* renamed from: a, reason: collision with root package name */
    public static final j f18347a = new j();

    /* renamed from: b, reason: collision with root package name */
    public static final H1.g<H1.b> f18348b = new H1.g<>(null, "secondaryCallState");

    /* renamed from: c, reason: collision with root package name */
    public static final H1.g<H1.a> f18349c = new H1.g<>(null, "secondaryCallInfo");

    @Override // I1.a
    public H1.g<H1.a> a() {
        return f18349c;
    }

    @Override // I1.a
    public H1.g<H1.b> b() {
        return f18348b;
    }

    public final void c(Call call) {
        d(call);
        a().d(G1.a.f1088a.d(call));
    }

    public final void d(Call call) {
        b().d(G1.b.f1089a.b(call));
    }
}
