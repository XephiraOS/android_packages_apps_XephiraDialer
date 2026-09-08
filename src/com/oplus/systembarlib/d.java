package com.oplus.systembarlib;

import androidx.core.view.X;
import androidx.fragment.app.Fragment;

/* compiled from: FragmentSystemBarStyle.kt */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final Fragment f29009a;

    public d(Fragment fragment) {
        kotlin.jvm.internal.i.f(fragment, "fragment");
        this.f29009a = fragment;
    }

    public final void b(X windowInsets) {
        kotlin.jvm.internal.i.f(windowInsets, "windowInsets");
        c(windowInsets, this.f29009a.isResumed());
    }

    public void c(X windowInsets, boolean z10) {
        kotlin.jvm.internal.i.f(windowInsets, "windowInsets");
    }

    public void a() {
    }
}
