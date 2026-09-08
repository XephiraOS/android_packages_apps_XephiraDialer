package com.android.contacts.framework.api.togoogle;

import android.content.Context;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: MoveToGoogleApi.kt */
/* loaded from: classes.dex */
public interface MoveToGoogleApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f15618a = Companion.f15619a;

    /* compiled from: MoveToGoogleApi.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f15619a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<MoveToGoogleApi> f15620b;

        static {
            d<MoveToGoogleApi> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<MoveToGoogleApi>() { // from class: com.android.contacts.framework.api.togoogle.MoveToGoogleApi$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final MoveToGoogleApi invoke() {
                    return (MoveToGoogleApi) A8.a.f202a.a(MoveToGoogleApi.class);
                }
            });
            f15620b = b10;
        }

        public final MoveToGoogleApi a() {
            return f15620b.getValue();
        }
    }

    void a(Context context);

    boolean b();

    void c();

    void d(Context context);
}
