package com.android.contacts.framework.api.rcs;

import android.content.Context;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: IRcsApi.kt */
/* loaded from: classes.dex */
public interface IRcsApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f15597a = Companion.f15598a;

    /* compiled from: IRcsApi.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f15598a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<IRcsApi> f15599b;

        static {
            d<IRcsApi> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<IRcsApi>() { // from class: com.android.contacts.framework.api.rcs.IRcsApi$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final IRcsApi invoke() {
                    return (IRcsApi) A8.a.f202a.a(IRcsApi.class);
                }
            });
            f15599b = b10;
        }

        public final IRcsApi a() {
            return f15599b.getValue();
        }
    }

    /* compiled from: IRcsApi.kt */
    /* loaded from: classes.dex */
    public interface a {
        void a(String str, boolean z10, String str2, boolean z11);
    }

    boolean a(String str);

    void b(String str, a aVar, boolean z10);

    String c();

    boolean d();

    void e(Context context, boolean z10);

    String f(String str);
}
