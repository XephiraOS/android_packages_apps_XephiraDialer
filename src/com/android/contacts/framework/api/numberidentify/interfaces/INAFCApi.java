package com.android.contacts.framework.api.numberidentify.interfaces;

import A8.a;
import java.util.List;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: INAFCApi.kt */
/* loaded from: classes.dex */
public interface INAFCApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f15583a = Companion.f15584a;

    /* compiled from: INAFCApi.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f15584a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<INAFCApi> f15585b;

        static {
            d<INAFCApi> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<INAFCApi>() { // from class: com.android.contacts.framework.api.numberidentify.interfaces.INAFCApi$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final INAFCApi invoke() {
                    return (INAFCApi) a.f202a.a(INAFCApi.class);
                }
            });
            f15585b = b10;
        }

        public final INAFCApi a() {
            return f15585b.getValue();
        }
    }

    /* compiled from: INAFCApi.kt */
    /* loaded from: classes.dex */
    public interface a {
    }

    boolean a();

    boolean b();

    boolean c();

    void d(List<String> list, a aVar);

    boolean e(String str);

    boolean f();

    boolean g();

    void h();

    int i();
}
