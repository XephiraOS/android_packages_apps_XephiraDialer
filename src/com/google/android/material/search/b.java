package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import f4.InterfaceC1000a;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: SearchBarAnimationHelper.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    public Animator f23608d;

    /* renamed from: e, reason: collision with root package name */
    public Animator f23609e;

    /* renamed from: a, reason: collision with root package name */
    public final Set<Object> f23605a = new LinkedHashSet();

    /* renamed from: b, reason: collision with root package name */
    public final Set<AnimatorListenerAdapter> f23606b = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name */
    public final Set<AnimatorListenerAdapter> f23607c = new LinkedHashSet();

    /* renamed from: f, reason: collision with root package name */
    public boolean f23610f = true;

    /* renamed from: g, reason: collision with root package name */
    public Animator f23611g = null;

    public void a(boolean z10) {
        this.f23610f = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(SearchBar searchBar) {
        Animator animator = this.f23608d;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.f23609e;
        if (animator2 != null) {
            animator2.end();
        }
        View centerView = searchBar.getCenterView();
        if (centerView instanceof InterfaceC1000a) {
            ((InterfaceC1000a) centerView).a();
        }
        if (centerView != 0) {
            centerView.setAlpha(0.0f);
        }
    }
}
