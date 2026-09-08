package com.android.contacts.framework.api.appstore.appinfo;

import android.app.Activity;
import android.content.Context;
import m9.d;
import m9.e;
import v9.InterfaceC1637a;

/* compiled from: IAppInfoCompatApi.kt */
/* loaded from: classes.dex */
public interface IAppInfoCompatApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f15525a = Companion.f15526a;

    /* compiled from: IAppInfoCompatApi.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f15526a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<IAppInfoCompatApi> f15527b = e.b(new InterfaceC1637a<IAppInfoCompatApi>() { // from class: com.android.contacts.framework.api.appstore.appinfo.IAppInfoCompatApi$Companion$instance$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final IAppInfoCompatApi invoke() {
                return (IAppInfoCompatApi) A8.a.f202a.a(IAppInfoCompatApi.class);
            }
        });

        public final IAppInfoCompatApi a() {
            return f15527b.getValue();
        }
    }

    String a();

    String b();

    String c();

    boolean d();

    void e(Activity activity);

    String f();

    boolean g();

    void h(Context context, Runnable runnable);

    String i();

    String j(String str);

    String k(String str);

    void l(Activity activity);

    String m();

    String n();

    boolean o();
}
