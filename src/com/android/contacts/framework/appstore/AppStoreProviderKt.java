package com.android.contacts.framework.appstore;

import I0.a;
import J0.i;
import M0.b;
import com.android.contacts.framework.appstore.appinfo.AppInfoCompatApiImpl;
import v9.InterfaceC1637a;

/* compiled from: AppStoreProvider.kt */
/* loaded from: classes.dex */
public final class AppStoreProviderKt {

    /* renamed from: a, reason: collision with root package name */
    public static final InterfaceC1637a<AppInfoCompatApiImpl> f15623a = new InterfaceC1637a<AppInfoCompatApiImpl>() { // from class: com.android.contacts.framework.appstore.AppStoreProviderKt$providerInfoCompatApi$1
        @Override // v9.InterfaceC1637a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AppInfoCompatApiImpl invoke() {
            return AppInfoCompatApiImpl.f15636b.c();
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public static final InterfaceC1637a<a> f15624b = new InterfaceC1637a<a>() { // from class: com.android.contacts.framework.appstore.AppStoreProviderKt$providerApplicationApi$1
        @Override // v9.InterfaceC1637a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return a.f1302b.a();
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public static final InterfaceC1637a<b> f15625c = new InterfaceC1637a<b>() { // from class: com.android.contacts.framework.appstore.AppStoreProviderKt$providerSimCardApi$1
        @Override // v9.InterfaceC1637a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return b.f1740b.a();
        }
    };

    /* renamed from: d, reason: collision with root package name */
    public static final InterfaceC1637a<K0.a> f15626d = new InterfaceC1637a<K0.a>() { // from class: com.android.contacts.framework.appstore.AppStoreProviderKt$providerPermissionApi$1
        @Override // v9.InterfaceC1637a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final K0.a invoke() {
            return K0.a.f1611b.a();
        }
    };

    /* renamed from: e, reason: collision with root package name */
    public static final InterfaceC1637a<i> f15627e = new InterfaceC1637a<i>() { // from class: com.android.contacts.framework.appstore.AppStoreProviderKt$providerMissedCallApi$1
        @Override // v9.InterfaceC1637a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final i invoke() {
            return i.f1462b.a();
        }
    };

    public static final InterfaceC1637a<a> a() {
        return f15624b;
    }

    public static final InterfaceC1637a<AppInfoCompatApiImpl> b() {
        return f15623a;
    }

    public static final InterfaceC1637a<i> c() {
        return f15627e;
    }

    public static final InterfaceC1637a<K0.a> d() {
        return f15626d;
    }

    public static final InterfaceC1637a<b> e() {
        return f15625c;
    }
}
