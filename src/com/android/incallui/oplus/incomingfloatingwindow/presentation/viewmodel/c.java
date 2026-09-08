package com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel;

import android.view.View;
import com.android.incallui.Log;
import kotlin.jvm.internal.i;

/* compiled from: FloatingWindowLifecycleViewModel.kt */
/* loaded from: classes.dex */
public abstract class c extends com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.a {

    /* renamed from: g, reason: collision with root package name */
    public final String f19056g;

    /* renamed from: h, reason: collision with root package name */
    public final b f19057h;

    /* renamed from: i, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f19058i;

    /* compiled from: FloatingWindowLifecycleViewModel.kt */
    /* loaded from: classes.dex */
    public static final class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c.this.u();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (view != null) {
                view.removeOnAttachStateChangeListener(this);
            }
            c.this.v();
        }
    }

    public c(String tag, b eventBus) {
        i.f(tag, "tag");
        i.f(eventBus, "eventBus");
        this.f19056g = tag;
        this.f19057h = eventBus;
        this.f19058i = new a();
    }

    public final View.OnAttachStateChangeListener s() {
        return this.f19058i;
    }

    public final b t() {
        return this.f19057h;
    }

    public void u() {
        Log.d(this.f19056g, "onCreate: ");
    }

    public void v() {
        Log.d(this.f19056g, "onDestroy: ");
    }
}
