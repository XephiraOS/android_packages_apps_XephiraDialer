package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper.java */
/* renamed from: androidx.core.view.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0469y {

    /* renamed from: a, reason: collision with root package name */
    public int f9523a;

    /* renamed from: b, reason: collision with root package name */
    public int f9524b;

    public C0469y(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f9524b | this.f9523a;
    }

    public void b(View view, View view2, int i10) {
        c(view, view2, i10, 0);
    }

    public void c(View view, View view2, int i10, int i11) {
        if (i11 == 1) {
            this.f9524b = i10;
        } else {
            this.f9523a = i10;
        }
    }

    public void d(View view) {
        e(view, 0);
    }

    public void e(View view, int i10) {
        if (i10 == 1) {
            this.f9524b = 0;
        } else {
            this.f9523a = 0;
        }
    }
}
