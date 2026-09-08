package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.W;
import androidx.core.view.X;
import f4.C1001b;
import java.util.Iterator;
import java.util.List;

/* compiled from: InsetsAnimationCallback.java */
/* loaded from: classes3.dex */
public class d extends W.b {

    /* renamed from: a, reason: collision with root package name */
    public final View f22847a;

    /* renamed from: b, reason: collision with root package name */
    public int f22848b;

    /* renamed from: c, reason: collision with root package name */
    public int f22849c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f22850d;

    public d(View view) {
        super(0);
        this.f22850d = new int[2];
        this.f22847a = view;
    }

    @Override // androidx.core.view.W.b
    public void onEnd(W w10) {
        this.f22847a.setTranslationY(0.0f);
    }

    @Override // androidx.core.view.W.b
    public void onPrepare(W w10) {
        this.f22847a.getLocationOnScreen(this.f22850d);
        this.f22848b = this.f22850d[1];
    }

    @Override // androidx.core.view.W.b
    public X onProgress(X x10, List<W> list) {
        Iterator<W> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((it.next().b() & X.k.a()) != 0) {
                this.f22847a.setTranslationY(C1001b.c(this.f22849c, 0, r0.a()));
                break;
            }
        }
        return x10;
    }

    @Override // androidx.core.view.W.b
    public W.a onStart(W w10, W.a aVar) {
        this.f22847a.getLocationOnScreen(this.f22850d);
        int i10 = this.f22848b - this.f22850d[1];
        this.f22849c = i10;
        this.f22847a.setTranslationY(i10);
        return aVar;
    }
}
