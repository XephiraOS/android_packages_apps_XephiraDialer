package com.android.contacts.framework.baseui.util;

import android.content.Context;
import android.view.View;

/* compiled from: FeedbackAnimatorHelper.kt */
/* loaded from: classes.dex */
public final class F implements C {

    /* renamed from: a, reason: collision with root package name */
    public final View f15851a;

    public F(View view) {
        kotlin.jvm.internal.i.f(view, "view");
        this.f15851a = view;
    }

    @Override // com.android.contacts.framework.baseui.util.C
    public int a() {
        return this.f15851a.getWidth();
    }

    @Override // com.android.contacts.framework.baseui.util.C
    public void b(float f10) {
        this.f15851a.setScaleY(f10);
    }

    @Override // com.android.contacts.framework.baseui.util.C
    public void c(float f10) {
        this.f15851a.setAlpha(f10);
    }

    @Override // com.android.contacts.framework.baseui.util.C
    public void d() {
        this.f15851a.invalidate();
    }

    @Override // com.android.contacts.framework.baseui.util.C
    public void e(float f10) {
        this.f15851a.setScaleX(f10);
    }

    @Override // com.android.contacts.framework.baseui.util.C
    public float f() {
        return this.f15851a.getAlpha();
    }

    @Override // com.android.contacts.framework.baseui.util.C
    public Context getContext() {
        Context context = this.f15851a.getContext();
        kotlin.jvm.internal.i.e(context, "view.context");
        return context;
    }

    @Override // com.android.contacts.framework.baseui.util.C
    public int getHeight() {
        return this.f15851a.getWidth();
    }
}
