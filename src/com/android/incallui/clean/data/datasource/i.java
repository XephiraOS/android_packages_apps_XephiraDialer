package com.android.incallui.clean.data.datasource;

import com.android.incallui.Call;

/* compiled from: PrimaryCallRepository.kt */
/* loaded from: classes.dex */
public final class i extends I1.a {

    /* renamed from: a, reason: collision with root package name */
    public static final i f18344a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static final H1.g<H1.b> f18345b = new H1.g<>(null, "primaryCallState");

    /* renamed from: c, reason: collision with root package name */
    public static final H1.g<H1.a> f18346c = new H1.g<>(null, "primaryCallInfo");

    @Override // I1.a
    public H1.g<H1.a> a() {
        return f18346c;
    }

    @Override // I1.a
    public H1.g<H1.b> b() {
        return f18345b;
    }

    public final void c(Call call) {
        d(call);
        a().d(G1.a.f1088a.d(call));
    }

    public final void d(Call call) {
        b().d(G1.b.f1089a.a(call));
    }
}
