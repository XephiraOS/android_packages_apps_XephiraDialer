package com.oplus.common.data;

import android.content.SharedPreferences;
import kotlin.jvm.internal.i;
import v9.InterfaceC1637a;

/* compiled from: PreferenceWrapper.kt */
/* loaded from: classes3.dex */
public final class PreferenceWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f27753a;

    public PreferenceWrapper(SharedPreferences prefs) {
        i.f(prefs, "prefs");
        this.f27753a = prefs;
    }

    public final int a(final String key, final int i10) {
        i.f(key, "key");
        return ((Number) WashManager.d(this.f27753a, key, Integer.valueOf(i10), new InterfaceC1637a<Integer>() { // from class: com.oplus.common.data.PreferenceWrapper$getInt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                return Integer.valueOf(PreferenceWrapper.this.b().getInt(key, i10));
            }
        })).intValue();
    }

    public final SharedPreferences b() {
        return this.f27753a;
    }
}
