package com.oplus.contacts.list.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* compiled from: NoContactFragment.kt */
/* loaded from: classes3.dex */
public final class q extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public x0.r f28019a;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        x0.r c10 = x0.r.c(inflater, viewGroup, false);
        kotlin.jvm.internal.i.e(c10, "inflate(inflater, container, false)");
        this.f28019a = c10;
        if (c10 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            c10 = null;
        }
        return c10.b();
    }
}
