package com.android.contacts.compat.data;

import android.content.SharedPreferences;
import kotlin.jvm.internal.i;
import v9.InterfaceC1637a;

/* compiled from: PreferenceWrapper.kt */
/* loaded from: classes.dex */
public final class PreferenceWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f14099a;

    public PreferenceWrapper(SharedPreferences prefs) {
        i.f(prefs, "prefs");
        this.f14099a = prefs;
    }

    public final boolean a(final String key, final boolean z10) {
        i.f(key, "key");
        return ((Boolean) WashManager.e(this.f14099a, key, Boolean.valueOf(z10), new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.compat.data.PreferenceWrapper$getBoolean$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(PreferenceWrapper.this.c().getBoolean(key, z10));
            }
        })).booleanValue();
    }

    public final int b(final String key, final int i10) {
        i.f(key, "key");
        return ((Number) WashManager.e(this.f14099a, key, Integer.valueOf(i10), new InterfaceC1637a<Integer>() { // from class: com.android.contacts.compat.data.PreferenceWrapper$getInt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                return Integer.valueOf(PreferenceWrapper.this.c().getInt(key, i10));
            }
        })).intValue();
    }

    public final SharedPreferences c() {
        return this.f14099a;
    }

    public final String d(final String key, final String str) {
        i.f(key, "key");
        return (String) WashManager.e(this.f14099a, key, str, new InterfaceC1637a<String>() { // from class: com.android.contacts.compat.data.PreferenceWrapper$getString$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            public final String invoke() {
                return PreferenceWrapper.this.c().getString(key, str);
            }
        });
    }
}
