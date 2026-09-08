package com.oplus.foundation.util.feature;

import kotlin.a;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: AppMetaFeatures.kt */
/* loaded from: classes3.dex */
public final class AppMetaFeatures {

    /* renamed from: a, reason: collision with root package name */
    public static final AppMetaFeatures f28286a = new AppMetaFeatures();

    /* renamed from: b, reason: collision with root package name */
    public static final d f28287b;

    static {
        d b10;
        b10 = a.b(new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.feature.AppMetaFeatures$callRecordingSupported$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(M7.a.h(P7.a.f2961a.a(), "com.android.providers.contacts", "call_recording", "true"));
            }
        });
        f28287b = b10;
    }

    public static final boolean b() {
        if (f28286a.a() && !VirtualSupportUtils.m()) {
            return true;
        }
        return false;
    }

    public final boolean a() {
        return ((Boolean) f28287b.getValue()).booleanValue();
    }
}
