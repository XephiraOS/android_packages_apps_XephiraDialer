package com.coui.appcompat.scanview;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.i;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: IconRotateHelper.kt */
/* loaded from: classes.dex */
public final class RotateIconHelper {
    public static final Companion Companion = new Companion(null);
    public static final float LOTTIE_PROGRESS_MAX = 1.0f;
    public static final float LOTTIE_PROGRESS_MIN = 0.0f;
    private boolean isTorchOn;

    /* compiled from: IconRotateHelper.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindAlbumIconTorchEvent$lambda$1(PressFeedbackHelper pressFeedbackHelper, RotateLottieAnimationView ivAlbum, View.OnClickListener onClickAlbumAction, View view, MotionEvent motionEvent) {
        i.f(pressFeedbackHelper, "$pressFeedbackHelper");
        i.f(ivAlbum, "$ivAlbum");
        i.f(onClickAlbumAction, "$onClickAlbumAction");
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                return false;
            }
            PressFeedbackHelper.executeScaleAnimator$default(pressFeedbackHelper, false, ivAlbum, null, 4, null);
            onClickAlbumAction.onClick(ivAlbum);
            return false;
        }
        PressFeedbackHelper.executeScaleAnimator$default(pressFeedbackHelper, true, ivAlbum, null, 4, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindTorchIconTouchEvent$lambda$0(PressFeedbackHelper pressFeedbackHelper, RotateLottieAnimationView torchIv, RotateIconHelper this$0, OnTorchStateChangeListener onTorchStateChangeListener, View view, MotionEvent motionEvent) {
        i.f(pressFeedbackHelper, "$pressFeedbackHelper");
        i.f(torchIv, "$torchIv");
        i.f(this$0, "this$0");
        i.f(onTorchStateChangeListener, "$onTorchStateChangeListener");
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                return false;
            }
            PressFeedbackHelper.executeScaleAnimator$default(pressFeedbackHelper, false, torchIv, null, 4, null);
            this$0.onTorchActionUp(torchIv, onTorchStateChangeListener);
            return false;
        }
        PressFeedbackHelper.executeScaleAnimator$default(pressFeedbackHelper, true, torchIv, null, 4, null);
        return true;
    }

    private final void doLottieAnimation(RotateLottieAnimationView rotateLottieAnimationView) {
        if (this.isTorchOn) {
            rotateLottieAnimationView.playAnimation();
        } else {
            rotateLottieAnimationView.pauseAnimation();
            rotateLottieAnimationView.setFrame(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTorchActionUp(RotateLottieAnimationView rotateLottieAnimationView, OnTorchStateChangeListener onTorchStateChangeListener) {
        if (onTorchStateChangeListener.onTorchStateChange(!this.isTorchOn)) {
            this.isTorchOn = !this.isTorchOn;
            doLottieAnimation(rotateLottieAnimationView);
        }
    }

    public final void bindAlbumIconTorchEvent(final RotateLottieAnimationView ivAlbum, final View.OnClickListener onClickAlbumAction) {
        i.f(ivAlbum, "ivAlbum");
        i.f(onClickAlbumAction, "onClickAlbumAction");
        final PressFeedbackHelper pressFeedbackHelper = new PressFeedbackHelper();
        ivAlbum.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.scanview.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean bindAlbumIconTorchEvent$lambda$1;
                bindAlbumIconTorchEvent$lambda$1 = RotateIconHelper.bindAlbumIconTorchEvent$lambda$1(PressFeedbackHelper.this, ivAlbum, onClickAlbumAction, view, motionEvent);
                return bindAlbumIconTorchEvent$lambda$1;
            }
        });
    }

    public final void bindTorchIconTouchEvent(final RotateLottieAnimationView torchIv, final OnTorchStateChangeListener onTorchStateChangeListener) {
        i.f(torchIv, "torchIv");
        i.f(onTorchStateChangeListener, "onTorchStateChangeListener");
        final PressFeedbackHelper pressFeedbackHelper = new PressFeedbackHelper();
        torchIv.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.scanview.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean bindTorchIconTouchEvent$lambda$0;
                bindTorchIconTouchEvent$lambda$0 = RotateIconHelper.bindTorchIconTouchEvent$lambda$0(PressFeedbackHelper.this, torchIv, this, onTorchStateChangeListener, view, motionEvent);
                return bindTorchIconTouchEvent$lambda$0;
            }
        });
    }

    public final void bindTorchTipTouchEvent(final TorchTipGroup torchTipGroup, final RotateLottieAnimationView torchIv, final OnTorchStateChangeListener onTorchStateChangeListener) {
        i.f(torchTipGroup, "torchTipGroup");
        i.f(torchIv, "torchIv");
        i.f(onTorchStateChangeListener, "onTorchStateChangeListener");
        final PressFeedbackHelper pressFeedbackHelper = new PressFeedbackHelper();
        final PressFeedbackHelper pressFeedbackHelper2 = new PressFeedbackHelper();
        torchTipGroup.bindTouchEvent(new InterfaceC1637a<q>() { // from class: com.coui.appcompat.scanview.RotateIconHelper$bindTorchTipTouchEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            public /* bridge */ /* synthetic */ q invoke() {
                invoke2();
                return q.f35511a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                View currentShowingTorchTip = TorchTipGroup.this.getCurrentShowingTorchTip();
                if (currentShowingTorchTip != null) {
                    PressFeedbackHelper.executeScaleAnimator$default(pressFeedbackHelper, true, currentShowingTorchTip, null, 4, null);
                }
            }
        }, new InterfaceC1637a<q>() { // from class: com.coui.appcompat.scanview.RotateIconHelper$bindTorchTipTouchEvent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            public /* bridge */ /* synthetic */ q invoke() {
                invoke2();
                return q.f35511a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                View currentShowingTorchTip = TorchTipGroup.this.getCurrentShowingTorchTip();
                if (currentShowingTorchTip != null) {
                    PressFeedbackHelper.executeScaleAnimator$default(pressFeedbackHelper, false, currentShowingTorchTip, null, 4, null);
                }
                final PressFeedbackHelper pressFeedbackHelper3 = pressFeedbackHelper2;
                final RotateLottieAnimationView rotateLottieAnimationView = torchIv;
                final RotateIconHelper rotateIconHelper = this;
                final OnTorchStateChangeListener onTorchStateChangeListener2 = onTorchStateChangeListener;
                pressFeedbackHelper3.executeScaleAnimator(true, rotateLottieAnimationView, new InterfaceC1637a<q>() { // from class: com.coui.appcompat.scanview.RotateIconHelper$bindTorchTipTouchEvent$2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // v9.InterfaceC1637a
                    public /* bridge */ /* synthetic */ q invoke() {
                        invoke2();
                        return q.f35511a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        PressFeedbackHelper.executeScaleAnimator$default(PressFeedbackHelper.this, false, rotateLottieAnimationView, null, 4, null);
                        rotateIconHelper.onTorchActionUp(rotateLottieAnimationView, onTorchStateChangeListener2);
                    }
                });
            }
        });
    }

    public final boolean isTorchOn() {
        return this.isTorchOn;
    }

    public final void setTorchOn(boolean z10) {
        this.isTorchOn = z10;
    }
}
