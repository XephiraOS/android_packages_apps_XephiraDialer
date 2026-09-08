package com.oplus.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.TextView;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.oplus.anim.EffectiveAnimationView;

/* compiled from: DialogCreator.kt */
/* loaded from: classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f29186a = new r();

    /* compiled from: DialogCreator.kt */
    /* loaded from: classes3.dex */
    public static final class a implements ViewTreeObserver.OnWindowAttachListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EffectiveAnimationView f29187a;

        public a(EffectiveAnimationView effectiveAnimationView) {
            this.f29187a = effectiveAnimationView;
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowAttached() {
            EffectiveAnimationView effectiveAnimationView = this.f29187a;
            if (effectiveAnimationView != null) {
                effectiveAnimationView.playAnimation();
            }
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowDetached() {
            EffectiveAnimationView effectiveAnimationView = this.f29187a;
            if (effectiveAnimationView != null) {
                effectiveAnimationView.pauseAnimation();
            }
        }
    }

    public static final androidx.appcompat.app.b b(Context context, String title) {
        kotlin.jvm.internal.i.f(title, "title");
        if (context != null) {
            androidx.appcompat.app.b show = new COUIAlertDialogBuilder(context, X8.n.f5035g).setCancelable(false).show();
            show.setCanceledOnTouchOutside(false);
            f29186a.a(show, title);
            return show;
        }
        return null;
    }

    public final void a(androidx.appcompat.app.b bVar, String str) {
        Window window;
        View decorView;
        if (bVar != null && (window = bVar.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            EffectiveAnimationView effectiveAnimationView = (EffectiveAnimationView) decorView.findViewById(X8.h.f4925h0);
            TextView textView = (TextView) decorView.findViewById(X8.h.f4927i0);
            if (textView != null) {
                textView.setText(str);
            }
            ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnWindowAttachListener(new a(effectiveAnimationView));
            }
        }
    }
}
