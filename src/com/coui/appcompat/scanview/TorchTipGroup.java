package com.coui.appcompat.scanview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.i;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: TorchTipGroup.kt */
/* loaded from: classes.dex */
public final class TorchTipGroup {
    private static final int ANGLE_COUNT = 4;
    private static final int ANGLE_INCREASE_STEP = 90;
    private static final long ANIMATION_DURATION = 250;
    private static final float APPEAR_ANIM_END = 1.0f;
    private static final float APPEAR_ANIM_START = 0.0f;
    private static final float DISAPPEAR_CONTROL_Y1 = 0.0f;
    private static final float DISAPPEAR_CONTROL_Y2 = 1.0f;
    private final LinearLayout bottomTorchTip;
    private final Context context;
    private int currentShowingIndex;
    private final LinearLayout flippedTorchTip;
    private final LinearLayout leftTorchTip;
    private final LinearLayout rightTorchTip;
    private boolean showTorchTip;
    private final LinearLayout[] torchTipGroup;
    public static final Companion Companion = new Companion(null);
    private static final float DISAPPEAR_CONTROL_X1 = 0.33f;
    private static final float DISAPPEAR_CONTROL_X2 = 0.67f;
    private static final PathInterpolator animPathInterpolator = new PathInterpolator(DISAPPEAR_CONTROL_X1, 0.0f, DISAPPEAR_CONTROL_X2, 1.0f);

    /* compiled from: TorchTipGroup.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void disappear$default(Companion companion, View view, InterfaceC1637a interfaceC1637a, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                interfaceC1637a = new InterfaceC1637a<q>() { // from class: com.coui.appcompat.scanview.TorchTipGroup$Companion$disappear$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // v9.InterfaceC1637a
                    public /* bridge */ /* synthetic */ q invoke() {
                        invoke2();
                        return q.f35511a;
                    }
                };
            }
            companion.disappear(view, interfaceC1637a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void show$default(Companion companion, View view, InterfaceC1637a interfaceC1637a, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                interfaceC1637a = new InterfaceC1637a<q>() { // from class: com.coui.appcompat.scanview.TorchTipGroup$Companion$show$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // v9.InterfaceC1637a
                    public /* bridge */ /* synthetic */ q invoke() {
                        invoke2();
                        return q.f35511a;
                    }
                };
            }
            companion.show(view, interfaceC1637a);
        }

        public final void disappear(final View view, final InterfaceC1637a<q> onEnd) {
            i.f(view, "view");
            i.f(onEnd, "onEnd");
            if (view.getVisibility() == 0) {
                ObjectAnimator disappear$lambda$3 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, view.getAlpha(), 0.0f);
                disappear$lambda$3.setInterpolator(TorchTipGroup.animPathInterpolator);
                disappear$lambda$3.setDuration(TorchTipGroup.ANIMATION_DURATION);
                i.e(disappear$lambda$3, "disappear$lambda$3");
                disappear$lambda$3.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.scanview.TorchTipGroup$Companion$disappear$lambda$3$$inlined$doOnEnd$1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        i.f(animator, "animator");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        i.f(animator, "animator");
                        view.setVisibility(8);
                        view.setAlpha(1.0f);
                        onEnd.invoke();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        i.f(animator, "animator");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        i.f(animator, "animator");
                    }
                });
                disappear$lambda$3.start();
            }
        }

        public final boolean isPortrait(int i10) {
            if (((i10 / 90) % 4) % 2 == 0) {
                return true;
            }
            return false;
        }

        public final void show(View view, final InterfaceC1637a<q> onEnd) {
            i.f(view, "view");
            i.f(onEnd, "onEnd");
            if (view.getVisibility() == 0) {
                return;
            }
            view.setAlpha(0.0f);
            view.setVisibility(0);
            ObjectAnimator show$lambda$1 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, view.getAlpha(), 1.0f);
            show$lambda$1.setInterpolator(TorchTipGroup.animPathInterpolator);
            show$lambda$1.setDuration(TorchTipGroup.ANIMATION_DURATION);
            i.e(show$lambda$1, "show$lambda$1");
            show$lambda$1.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.scanview.TorchTipGroup$Companion$show$lambda$1$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    i.f(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.f(animator, "animator");
                    InterfaceC1637a.this.invoke();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    i.f(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    i.f(animator, "animator");
                }
            });
            show$lambda$1.start();
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public TorchTipGroup(Context context) {
        i.f(context, "context");
        this.context = context;
        LinearLayout torchTipGroup = getTorchTipGroup();
        torchTipGroup.setId(Z8.e.f6076C);
        torchTipGroup.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        this.bottomTorchTip = torchTipGroup;
        LinearLayout torchTipGroup2 = getTorchTipGroup();
        torchTipGroup2.setId(Z8.e.f6080E);
        torchTipGroup2.setRotation(90.0f);
        torchTipGroup2.setVisibility(8);
        torchTipGroup2.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        this.leftTorchTip = torchTipGroup2;
        LinearLayout torchTipGroup3 = getTorchTipGroup();
        torchTipGroup3.setId(Z8.e.f6078D);
        torchTipGroup3.setRotation(180.0f);
        torchTipGroup3.setVisibility(8);
        torchTipGroup3.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        this.flippedTorchTip = torchTipGroup3;
        LinearLayout torchTipGroup4 = getTorchTipGroup();
        torchTipGroup4.setId(Z8.e.f6082F);
        torchTipGroup4.setRotation(270.0f);
        torchTipGroup4.setVisibility(8);
        torchTipGroup4.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        this.rightTorchTip = torchTipGroup4;
        this.torchTipGroup = new LinearLayout[]{torchTipGroup, torchTipGroup4, torchTipGroup3, torchTipGroup2};
        this.currentShowingIndex = -1;
    }

    private final void bindViewTorchEvent(View view, final InterfaceC1637a<q> interfaceC1637a, final InterfaceC1637a<q> interfaceC1637a2) {
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.scanview.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean bindViewTorchEvent$lambda$5;
                bindViewTorchEvent$lambda$5 = TorchTipGroup.bindViewTorchEvent$lambda$5(InterfaceC1637a.this, interfaceC1637a2, view2, motionEvent);
                return bindViewTorchEvent$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindViewTorchEvent$lambda$5(InterfaceC1637a onActionDown, InterfaceC1637a onActionUp, View view, MotionEvent motionEvent) {
        i.f(onActionDown, "$onActionDown");
        i.f(onActionUp, "$onActionUp");
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1 && action != 3) {
                return false;
            }
            onActionUp.invoke();
            return false;
        }
        onActionDown.invoke();
        return true;
    }

    public static final void disappear(View view, InterfaceC1637a<q> interfaceC1637a) {
        Companion.disappear(view, interfaceC1637a);
    }

    private final LinearLayout getTorchTipGroup() {
        View getTorchTipGroup$lambda$8 = View.inflate(this.context, Z8.f.f6188x, null);
        i.e(getTorchTipGroup$lambda$8, "getTorchTipGroup$lambda$8");
        getTorchTipGroup$lambda$8.setVisibility(8);
        getTorchTipGroup$lambda$8.setAlpha(0.0f);
        i.d(getTorchTipGroup$lambda$8, "null cannot be cast to non-null type android.widget.LinearLayout");
        return (LinearLayout) getTorchTipGroup$lambda$8;
    }

    public static final boolean isPortrait(int i10) {
        return Companion.isPortrait(i10);
    }

    public static final void show(View view, InterfaceC1637a<q> interfaceC1637a) {
        Companion.show(view, interfaceC1637a);
    }

    public final void attachToRoot(ViewGroup viewGroup) {
        i.f(viewGroup, "viewGroup");
        viewGroup.addView(this.bottomTorchTip);
        viewGroup.addView(this.leftTorchTip);
        viewGroup.addView(this.rightTorchTip);
        viewGroup.addView(this.flippedTorchTip);
    }

    public final void bindTouchEvent(InterfaceC1637a<q> onActionDown, InterfaceC1637a<q> onActionUp) {
        i.f(onActionDown, "onActionDown");
        i.f(onActionUp, "onActionUp");
        for (LinearLayout linearLayout : this.torchTipGroup) {
            bindViewTorchEvent(linearLayout, onActionDown, onActionUp);
        }
    }

    public final LinearLayout getBottomTorchTip() {
        return this.bottomTorchTip;
    }

    public final View getCurrentShowingTorchTip() {
        int i10 = this.currentShowingIndex;
        if (i10 >= 0) {
            return this.torchTipGroup[i10];
        }
        return null;
    }

    public final LinearLayout getFlippedTorchTip() {
        return this.flippedTorchTip;
    }

    public final LinearLayout getLeftTorchTip() {
        return this.leftTorchTip;
    }

    public final LinearLayout getRightTorchTip() {
        return this.rightTorchTip;
    }

    public final boolean getShowTorchTip() {
        return this.showTorchTip;
    }

    public final void removeAll(ViewGroup viewGroup) {
        i.f(viewGroup, "viewGroup");
        viewGroup.removeView(this.bottomTorchTip);
        viewGroup.removeView(this.leftTorchTip);
        viewGroup.removeView(this.rightTorchTip);
        viewGroup.removeView(this.flippedTorchTip);
    }

    public final void setOrientation(int i10) {
        if (!this.showTorchTip) {
            return;
        }
        int i11 = (i10 / 90) % 4;
        int length = this.torchTipGroup.length;
        for (int i12 = 0; i12 < length; i12++) {
            if (i12 == i11) {
                Companion.show$default(Companion, this.torchTipGroup[i12], null, 2, null);
                this.currentShowingIndex = i12;
            } else {
                Companion.disappear$default(Companion, this.torchTipGroup[i12], null, 2, null);
            }
        }
    }

    public final void setShowTorchTip(boolean z10) {
        this.showTorchTip = z10;
    }

    public final void setTorchTip(CharSequence torchTip) {
        i.f(torchTip, "torchTip");
        for (LinearLayout linearLayout : this.torchTipGroup) {
            ((TextView) linearLayout.findViewById(Z8.e.f6154x0)).setText(torchTip);
        }
    }

    public final void showBottom() {
        if (!this.showTorchTip) {
            return;
        }
        Companion.show$default(Companion, this.bottomTorchTip, null, 2, null);
        this.currentShowingIndex = 0;
    }

    public final void disappear() {
        int i10 = this.currentShowingIndex;
        if (i10 >= 0) {
            Companion.disappear$default(Companion, this.torchTipGroup[i10], null, 2, null);
        }
    }

    public final void setTorchTip(int i10) {
        for (LinearLayout linearLayout : this.torchTipGroup) {
            ((TextView) linearLayout.findViewById(Z8.e.f6154x0)).setText(i10);
        }
    }
}
