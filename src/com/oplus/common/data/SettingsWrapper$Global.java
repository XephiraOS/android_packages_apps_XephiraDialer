package com.oplus.common.data;

import android.content.ContentResolver;
import kotlin.jvm.internal.i;
import v9.InterfaceC1637a;

/* compiled from: SettingsWrapper.kt */
/* loaded from: classes3.dex */
public final class SettingsWrapper$Global {

    /* renamed from: a, reason: collision with root package name */
    public static final SettingsWrapper$Global f27754a = new SettingsWrapper$Global();

    public static final int a(ContentResolver resolver, String key, int i10, final InterfaceC1637a<Integer> function) {
        i.f(resolver, "resolver");
        i.f(key, "key");
        i.f(function, "function");
        return ((Number) WashManager.e(key, Integer.valueOf(i10), new InterfaceC1637a<Integer>() { // from class: com.oplus.common.data.SettingsWrapper$Global$getInt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                return function.invoke();
            }
        })).intValue();
    }
}
