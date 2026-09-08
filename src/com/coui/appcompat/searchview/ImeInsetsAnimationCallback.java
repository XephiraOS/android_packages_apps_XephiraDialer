package com.coui.appcompat.searchview;

import android.view.WindowInsets;
import androidx.core.view.W;
import androidx.core.view.X;
import java.util.List;

/* compiled from: ImeInsetsAnimationCallback.kt */
/* loaded from: classes.dex */
public final class ImeInsetsAnimationCallback extends W.b {
    private OnImeAnimationListener imeListener;

    /* compiled from: ImeInsetsAnimationCallback.kt */
    /* loaded from: classes.dex */
    public interface OnImeAnimationListener {
        void onImeAnimStart();
    }

    public ImeInsetsAnimationCallback() {
        this(0, 1, null);
    }

    public final OnImeAnimationListener getImeListener() {
        return this.imeListener;
    }

    @Override // androidx.core.view.W.b
    public X onProgress(X insets, List<W> runningAnimations) {
        kotlin.jvm.internal.i.f(insets, "insets");
        kotlin.jvm.internal.i.f(runningAnimations, "runningAnimations");
        return insets;
    }

    @Override // androidx.core.view.W.b
    public W.a onStart(W animation, W.a bounds) {
        OnImeAnimationListener onImeAnimationListener;
        kotlin.jvm.internal.i.f(animation, "animation");
        kotlin.jvm.internal.i.f(bounds, "bounds");
        if ((animation.b() & WindowInsets.Type.ime()) != 0 && (onImeAnimationListener = this.imeListener) != null) {
            onImeAnimationListener.onImeAnimStart();
        }
        W.a onStart = super.onStart(animation, bounds);
        kotlin.jvm.internal.i.e(onStart, "super.onStart(animation, bounds)");
        return onStart;
    }

    public final void setImeAnimationListener(OnImeAnimationListener listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        this.imeListener = listener;
    }

    public final void setImeListener(OnImeAnimationListener onImeAnimationListener) {
        this.imeListener = onImeAnimationListener;
    }

    public /* synthetic */ ImeInsetsAnimationCallback(int i10, int i11, kotlin.jvm.internal.f fVar) {
        this((i11 & 1) != 0 ? 0 : i10);
    }

    public ImeInsetsAnimationCallback(int i10) {
        super(i10);
    }
}
