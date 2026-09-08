package com.customize.contacts.manager;

import java.util.List;
import java.util.Set;

/* compiled from: SimpleNumberInfo.kt */
/* loaded from: classes3.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    public final List<C> f21511a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<String> f21512b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f21513c;

    public D(List<C> list, Set<String> minMatchSet, boolean z10) {
        kotlin.jvm.internal.i.f(list, "list");
        kotlin.jvm.internal.i.f(minMatchSet, "minMatchSet");
        this.f21511a = list;
        this.f21512b = minMatchSet;
        this.f21513c = z10;
    }

    public final boolean a() {
        return this.f21513c;
    }

    public final List<C> b() {
        return this.f21511a;
    }

    public final Set<String> c() {
        return this.f21512b;
    }
}
