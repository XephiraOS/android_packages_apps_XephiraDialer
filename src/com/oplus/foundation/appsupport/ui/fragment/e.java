package com.oplus.foundation.appsupport.ui.fragment;

import androidx.fragment.app.B;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import kotlin.jvm.internal.i;

/* compiled from: FragmentManagerExt.kt */
/* loaded from: classes3.dex */
public final class e {
    public static final void a(FragmentManager fragmentManager, Fragment fragment, int i10, int i11) {
        i.f(fragmentManager, "<this>");
        i.f(fragment, "fragment");
        B p10 = fragmentManager.p();
        p10.u(i10, i11);
        p10.r(fragment);
        p10.j();
    }

    public static /* synthetic */ void b(FragmentManager fragmentManager, Fragment fragment, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        a(fragmentManager, fragment, i10, i11);
    }

    public static final void c(FragmentManager fragmentManager, Fragment fragment, int i10, int i11) {
        i.f(fragmentManager, "<this>");
        i.f(fragment, "fragment");
        B p10 = fragmentManager.p();
        p10.u(i10, i11);
        p10.r(fragment);
        p10.l();
    }

    public static /* synthetic */ void d(FragmentManager fragmentManager, Fragment fragment, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        c(fragmentManager, fragment, i10, i11);
    }

    public static final void e(FragmentManager fragmentManager, int i10, Fragment fragment, String tag, int i11, int i12) {
        i.f(fragmentManager, "<this>");
        i.f(fragment, "fragment");
        i.f(tag, "tag");
        B p10 = fragmentManager.p();
        p10.u(i11, i12);
        p10.t(i10, fragment, tag);
        p10.j();
    }

    public static /* synthetic */ void f(FragmentManager fragmentManager, int i10, Fragment fragment, String str, int i11, int i12, int i13, Object obj) {
        int i14;
        int i15;
        if ((i13 & 8) != 0) {
            i14 = 0;
        } else {
            i14 = i11;
        }
        if ((i13 & 16) != 0) {
            i15 = 0;
        } else {
            i15 = i12;
        }
        e(fragmentManager, i10, fragment, str, i14, i15);
    }
}
