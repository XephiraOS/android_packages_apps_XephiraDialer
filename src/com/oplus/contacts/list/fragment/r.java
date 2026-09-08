package com.oplus.contacts.list.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import x0.s;

/* compiled from: NoContactSelectedFragment.kt */
/* loaded from: classes3.dex */
public final class r extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public s f28020a;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        s c10 = s.c(inflater, viewGroup, false);
        kotlin.jvm.internal.i.e(c10, "inflate(inflater, container, false)");
        this.f28020a = c10;
        if (c10 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            c10 = null;
        }
        return c10.b();
    }
}
