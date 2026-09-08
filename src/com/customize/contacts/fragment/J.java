package com.customize.contacts.fragment;

import androidx.appcompat.app.ActionBar;

/* compiled from: BaseActivityFragment.kt */
/* loaded from: classes3.dex */
public class J {

    /* renamed from: a, reason: collision with root package name */
    public final BaseActivityFragment f21244a;

    /* renamed from: b, reason: collision with root package name */
    public final ActionBar f21245b;

    public J(BaseActivityFragment fragment, ActionBar actionBar) {
        kotlin.jvm.internal.i.f(fragment, "fragment");
        this.f21244a = fragment;
        this.f21245b = actionBar;
    }

    public final void a(boolean z10) {
        if (this.f21244a.g2()) {
            this.f21244a.S1(z10);
            return;
        }
        ActionBar actionBar = this.f21245b;
        if (actionBar != null) {
            actionBar.t(z10);
        }
    }

    public final void b(boolean z10) {
        if (this.f21244a.g2()) {
            this.f21244a.U1(z10);
            return;
        }
        ActionBar actionBar = this.f21245b;
        if (actionBar != null) {
            actionBar.x(z10);
        }
    }
}
