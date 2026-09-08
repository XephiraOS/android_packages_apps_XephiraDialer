package com.android.incallui.oplus.answerview.view;

import android.content.Context;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewPropertyAnimator;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.incallui.oplus.answerview.protocol.VoiceGuideViewBehavior;
import g2.InterfaceC1038e;
import h2.C1076a;

/* compiled from: GuideAnimatorView.kt */
/* loaded from: classes.dex */
public final class GuideAnimatorView extends AppCompatImageView implements InterfaceC1038e {

    /* renamed from: g, reason: collision with root package name */
    public static final a f18782g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public com.android.incallui.oplus.answerview.protocol.a f18783a;

    /* renamed from: b, reason: collision with root package name */
    public float f18784b;

    /* renamed from: c, reason: collision with root package name */
    public AnimatedVectorDrawable f18785c;

    /* renamed from: d, reason: collision with root package name */
    public ViewPropertyAnimator f18786d;

    /* renamed from: e, reason: collision with root package name */
    public final Animatable2.AnimationCallback f18787e;

    /* renamed from: f, reason: collision with root package name */
    public int f18788f;

    /* compiled from: GuideAnimatorView.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final void a(GuideAnimatorView guideAnimatorView) {
            if (guideAnimatorView != null) {
                guideAnimatorView.setAnimationState(1);
            }
        }

        public final void b(GuideAnimatorView guideAnimatorView) {
            if (guideAnimatorView != null) {
                guideAnimatorView.setAnimationState(2);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: GuideAnimatorView.kt */
    /* loaded from: classes.dex */
    public static final class b extends Animatable2.AnimationCallback {
        public b() {
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            AnimatedVectorDrawable mAnimatedVectorDrawable = GuideAnimatorView.this.getMAnimatedVectorDrawable();
            if (mAnimatedVectorDrawable != null) {
                mAnimatedVectorDrawable.start();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuideAnimatorView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.i.f(context, "context");
        this.f18784b = 1.0f;
        this.f18787e = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AnimatedVectorDrawable getMAnimatedVectorDrawable() {
        AnimatedVectorDrawable animatedVectorDrawable;
        if (this.f18785c == null) {
            Drawable drawable = getDrawable();
            if (drawable instanceof AnimatedVectorDrawable) {
                animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
            } else {
                animatedVectorDrawable = null;
            }
            this.f18785c = animatedVectorDrawable;
        }
        return this.f18785c;
    }

    public static final void l(GuideAnimatorView this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (this$0.f18788f == 2) {
            this$0.m();
            this$0.setVisibility(4);
        }
    }

    @Override // g2.InterfaceC1038e
    public com.android.incallui.oplus.answerview.protocol.a getMViewUserAction() {
        return null;
    }

    public final void i() {
        m();
        n();
    }

    public final void j() {
        Log.d("GuideAnimatorView", "startGuideAnimation: " + getMAnimatedVectorDrawable());
        setVisibility(0);
        i();
        setAlpha(this.f18784b);
        AnimatedVectorDrawable mAnimatedVectorDrawable = getMAnimatedVectorDrawable();
        if (mAnimatedVectorDrawable != null) {
            mAnimatedVectorDrawable.clearAnimationCallbacks();
            mAnimatedVectorDrawable.registerAnimationCallback(this.f18787e);
            mAnimatedVectorDrawable.start();
        }
    }

    public final void k() {
        Log.d("GuideAnimatorView", "startHideViewAnimation: ");
        i();
        this.f18786d = C1076a.f32047a.b(this).withEndAction(new Runnable() { // from class: com.android.incallui.oplus.answerview.view.d
            @Override // java.lang.Runnable
            public final void run() {
                GuideAnimatorView.l(GuideAnimatorView.this);
            }
        });
    }

    public final void m() {
        Log.d("GuideAnimatorView", "stopPreviousGuideAnimation: ");
        AnimatedVectorDrawable mAnimatedVectorDrawable = getMAnimatedVectorDrawable();
        if (mAnimatedVectorDrawable != null) {
            mAnimatedVectorDrawable.reset();
            mAnimatedVectorDrawable.stop();
            mAnimatedVectorDrawable.clearAnimationCallbacks();
        }
    }

    public final void n() {
        ViewPropertyAnimator updateListener;
        ViewPropertyAnimator listener;
        Log.d("GuideAnimatorView", "stopPreviousHideViewAnimation: ");
        ViewPropertyAnimator viewPropertyAnimator = this.f18786d;
        if (viewPropertyAnimator != null && (updateListener = viewPropertyAnimator.setUpdateListener(null)) != null && (listener = updateListener.setListener(null)) != null) {
            listener.cancel();
        }
        this.f18786d = null;
    }

    public final void o() {
        int i10 = this.f18788f;
        if (i10 != 1) {
            if (i10 != 2) {
                Log.d("GuideAnimatorView", "updateAnimationState: it's else AnimationState, do nothing");
                return;
            } else {
                k();
                return;
            }
        }
        j();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setAnimationState(0);
        i();
        AnimatedVectorDrawable mAnimatedVectorDrawable = getMAnimatedVectorDrawable();
        if (mAnimatedVectorDrawable != null) {
            mAnimatedVectorDrawable.clearAnimationCallbacks();
        }
        setImageDrawable(null);
        this.f18785c = null;
    }

    public final void setAnimationState(int i10) {
        if (this.f18788f != i10) {
            this.f18788f = i10;
            o();
        }
    }

    @Override // g2.InterfaceC1038e
    public void setMViewUserAction(com.android.incallui.oplus.answerview.protocol.a aVar) {
        VoiceGuideViewBehavior voiceGuideViewBehavior;
        this.f18783a = aVar;
        if (aVar instanceof VoiceGuideViewBehavior) {
            voiceGuideViewBehavior = (VoiceGuideViewBehavior) aVar;
        } else {
            voiceGuideViewBehavior = null;
        }
        if (voiceGuideViewBehavior != null) {
            float d10 = voiceGuideViewBehavior.d();
            this.f18784b = d10;
            setAlpha(d10);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuideAnimatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.i.f(context, "context");
    }

    private static /* synthetic */ void getMGuideAnimationState$annotations() {
    }
}
