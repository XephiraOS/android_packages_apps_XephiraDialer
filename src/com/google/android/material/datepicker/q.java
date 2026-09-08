package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* compiled from: PickerFragment.java */
/* loaded from: classes3.dex */
public abstract class q<S> extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<p<S>> f23282a = new LinkedHashSet<>();

    public boolean c1(p<S> pVar) {
        return this.f23282a.add(pVar);
    }

    public void d1() {
        this.f23282a.clear();
    }
}
