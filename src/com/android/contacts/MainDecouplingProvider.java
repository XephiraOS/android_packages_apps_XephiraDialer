package com.android.contacts;

import j1.InterfaceC1158a;
import java.util.HashMap;
import v9.InterfaceC1637a;

/* compiled from: MainDecouplingProvider.kt */
/* loaded from: classes.dex */
public final class MainDecouplingProvider {

    /* renamed from: a, reason: collision with root package name */
    public static final MainDecouplingProvider f13153a = new MainDecouplingProvider();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap<C9.c<?>, InterfaceC1637a<?>> f13154b;

    static {
        HashMap<C9.c<?>, InterfaceC1637a<?>> e10;
        e10 = kotlin.collections.E.e(m9.g.a(kotlin.jvm.internal.k.b(InterfaceC1158a.class), new InterfaceC1637a<C0578a>() { // from class: com.android.contacts.MainDecouplingProvider$mInstanceProducer$1
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final C0578a invoke() {
                return C0578a.f13579a.a();
            }
        }));
        f13154b = e10;
    }

    public final HashMap<C9.c<?>, InterfaceC1637a<?>> a() {
        return f13154b;
    }
}
