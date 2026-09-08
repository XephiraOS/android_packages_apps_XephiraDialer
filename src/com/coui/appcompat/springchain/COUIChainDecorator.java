package com.coui.appcompat.springchain;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.coui.appcompat.springchain.COUIGridSpringChain;
import com.coui.appcompat.springchain.api.ICheckViewEdge;
import com.coui.appcompat.uiutil.UIUtil;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: COUIChainDecorator.kt */
/* loaded from: classes.dex */
public final class COUIChainDecorator {
    public static final Companion Companion = new Companion(null);
    private static final boolean DEBUG = true;
    private static final int DEFAULT_MARGIN_VERTICAL = 24;
    private static final float FACTOR = 0.3f;
    private static final float FACTOR_RATIO = 0.2f;
    private static final float FACTOR_RATIO_1 = 0.6f;
    private static final float FACTOR_RATIO_2 = 0.75f;
    private static final float FACTOR_RATIO_3 = 0.8f;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final float MAX_DISTANCE_FACTOR = 0.25f;
    private static final float MAX_DISTANCE_RATIO = 0.5f;
    private static final float OVER_SCROLL_FACTOR = 0.3f;
    private static final String TAG = "ChainDecorator";
    private final COUIGridSpringChain.TransCalculator backToTop;
    private ICheckViewEdge checkEdge;
    private float curDistance;
    private int currentMarginVertical;
    private float downY;
    private float factor;
    private int hasReleaseSpring;
    private float inheritDistance;
    private final COUIGridSpringChain scrollGridChain;
    private boolean shouldUpdateDownY;

    /* compiled from: COUIChainDecorator.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public COUIChainDecorator(COUIGridSpringChain scrollGridChain) {
        i.f(scrollGridChain, "scrollGridChain");
        this.scrollGridChain = scrollGridChain;
        this.factor = 0.3f;
        this.currentMarginVertical = 24;
        this.backToTop = new COUIGridSpringChain.TransCalculator() { // from class: com.coui.appcompat.springchain.COUIChainDecorator$backToTop$1
            @Override // com.coui.appcompat.springchain.COUIGridSpringChain.TransCalculator
            public float getTrans(int i10, float f10, int i11) {
                float f11;
                float f12;
                float a10;
                float d10;
                float f13;
                float f14;
                int i12;
                float f15;
                float f16;
                float f17;
                float f18;
                float f19;
                if (i10 == 0) {
                    f11 = COUIChainDecorator.this.factor;
                    f12 = f10 * f11;
                } else {
                    if (i10 == 1) {
                        f13 = COUIChainDecorator.this.factor;
                        f14 = f10 * f13 * 0.2f * 0.6f;
                        i12 = COUIChainDecorator.this.currentMarginVertical;
                    } else if (i10 == 2) {
                        f15 = COUIChainDecorator.this.factor;
                        f14 = f10 * f15 * 0.2f;
                        i12 = COUIChainDecorator.this.currentMarginVertical;
                    } else if (i10 == 3) {
                        f16 = COUIChainDecorator.this.factor;
                        f14 = f10 * f16 * 0.2f * 0.6f * 0.8f;
                        i12 = COUIChainDecorator.this.currentMarginVertical;
                    } else if (i10 == 4) {
                        f17 = COUIChainDecorator.this.factor;
                        f14 = f10 * f17 * 0.2f * 0.75f;
                        i12 = COUIChainDecorator.this.currentMarginVertical;
                    } else if (i10 != 5) {
                        f19 = COUIChainDecorator.this.factor;
                        f14 = f10 * f19 * 0.2f * ((float) Math.pow(0.75d, i10 - 3));
                        i12 = COUIChainDecorator.this.currentMarginVertical;
                    } else {
                        f18 = COUIChainDecorator.this.factor;
                        f14 = f10 * f18 * 0.2f * 0.75f * 0.75f;
                        i12 = COUIChainDecorator.this.currentMarginVertical;
                    }
                    f12 = f14 - i12;
                }
                if (i11 == 1) {
                    a10 = B9.i.a(f12, 0.0f);
                    return a10;
                }
                if (i11 == 2) {
                    d10 = B9.i.d(f12, 0.0f);
                    return d10;
                }
                return f12;
            }
        };
        scrollGridChain.setTranCalculator(1);
        scrollGridChain.setTranCalculator(2);
    }

    private final float getFormalDistance(float f10, float f11) {
        float a10;
        float d10;
        float a11;
        float d11;
        if (f11 * f10 <= 0.0f) {
            return f10;
        }
        float abs = Math.abs(this.scrollGridChain.getLastTranslationY());
        float height = (getHeight() * 0.5f) / MAX_DISTANCE_FACTOR;
        a10 = B9.i.a(((getHeight() * 0.5f) - abs) / MAX_DISTANCE_FACTOR, 0.0f);
        d10 = B9.i.d(a10, height);
        a11 = B9.i.a(1 - Math.abs(f11 / d10), 0.0f);
        d11 = B9.i.d(a11, 1.0f);
        return (d11 * (f10 - f11)) + f11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initEdgeCheck$lambda$0(COUIChainDecorator this$0, View view, MotionEvent event) {
        i.f(this$0, "this$0");
        i.e(event, "event");
        this$0.onEdgeSpringEvent(event);
        return false;
    }

    private final boolean isReachBottomEdge() {
        ICheckViewEdge iCheckViewEdge = this.checkEdge;
        if (iCheckViewEdge == null || !iCheckViewEdge.isReachBottomEdge()) {
            return false;
        }
        return true;
    }

    private final boolean isReachTopEdge() {
        ICheckViewEdge iCheckViewEdge = this.checkEdge;
        if (iCheckViewEdge == null || !iCheckViewEdge.isReachTopEdge()) {
            return false;
        }
        return true;
    }

    public final COUIGridSpringChain.TransCalculator getBackToTop() {
        return this.backToTop;
    }

    public final ICheckViewEdge getCheckEdge() {
        return this.checkEdge;
    }

    public final int getHeight() {
        ICheckViewEdge iCheckViewEdge = this.checkEdge;
        if (iCheckViewEdge != null) {
            return iCheckViewEdge.getHeight();
        }
        return 0;
    }

    public final COUIGridSpringChain getScrollGridChain() {
        return this.scrollGridChain;
    }

    public final void initEdgeCheck(final ViewGroup scrollView, final ViewGroup container, boolean z10) {
        i.f(scrollView, "scrollView");
        i.f(container, "container");
        this.checkEdge = new ICheckViewEdge() { // from class: com.coui.appcompat.springchain.COUIChainDecorator$initEdgeCheck$1
            @Override // com.coui.appcompat.springchain.api.ICheckViewEdge
            public int getHeight() {
                return scrollView.getHeight();
            }

            @Override // com.coui.appcompat.springchain.api.ICheckViewEdge
            public boolean isReachBottomEdge() {
                if (scrollView.getScrollY() + scrollView.getHeight() >= container.getMeasuredHeight()) {
                    return true;
                }
                return false;
            }

            @Override // com.coui.appcompat.springchain.api.ICheckViewEdge
            public boolean isReachTopEdge() {
                if (scrollView.getScrollY() <= 0) {
                    return true;
                }
                return false;
            }
        };
        if (z10) {
            scrollView.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.springchain.a
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean initEdgeCheck$lambda$0;
                    initEdgeCheck$lambda$0 = COUIChainDecorator.initEdgeCheck$lambda$0(COUIChainDecorator.this, view, motionEvent);
                    return initEdgeCheck$lambda$0;
                }
            });
        }
    }

    public final boolean onEdgeSpringEvent(MotionEvent event) {
        i.f(event, "event");
        float rawY = event.getRawY(UIUtil.getAdjustmentPointerIndex(event, event.getActionIndex()));
        int action = event.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 5 || action == 6) {
                            this.inheritDistance = this.curDistance;
                            this.shouldUpdateDownY = true;
                            Log.d(TAG, "onEdgeSpringEvent : ACTION_POINTER_DOWN/UP : inheritDistance=:" + this.inheritDistance);
                        }
                    }
                } else {
                    if (this.shouldUpdateDownY) {
                        this.downY = rawY;
                        this.shouldUpdateDownY = false;
                    }
                    float formalDistance = getFormalDistance((rawY - this.downY) + this.inheritDistance, this.curDistance);
                    this.curDistance = formalDistance;
                    if (formalDistance > 0.0f && isReachTopEdge()) {
                        this.scrollGridChain.updateMoveTranslation(this.curDistance, 1);
                        return true;
                    }
                    if (this.curDistance < 0.0f && isReachBottomEdge()) {
                        this.scrollGridChain.updateMoveTranslation(this.curDistance, 2);
                        return true;
                    }
                    if (this.hasReleaseSpring != 0) {
                        this.downY = rawY;
                        this.scrollGridChain.updateMoveTranslation(0.0f, 0);
                    } else {
                        this.downY = rawY;
                    }
                }
            }
            this.curDistance = getFormalDistance((rawY - this.downY) + this.inheritDistance, this.curDistance);
            Log.d(TAG, "onEdgeSpringEvent : ACTION_UP/CANCEL : curDistance=:" + this.curDistance + " ,isReachTopEdge()=:" + isReachTopEdge() + " ,isReachBottomEdge()=:" + isReachBottomEdge() + " ,hasReleaseSpring=:" + this.hasReleaseSpring);
            if (this.curDistance > 0.0f && isReachTopEdge()) {
                this.scrollGridChain.startRebound(1);
                return true;
            }
            if (this.curDistance < 0.0f && isReachBottomEdge()) {
                this.scrollGridChain.startRebound(2);
                return true;
            }
            if (this.hasReleaseSpring != 0) {
                this.downY = rawY;
                this.scrollGridChain.startRebound(0);
            } else {
                this.downY = rawY;
            }
        } else {
            this.downY = rawY;
            this.curDistance = 0.0f;
            this.inheritDistance = 0.0f;
            int isSpringSystemRunning = this.scrollGridChain.isSpringSystemRunning();
            this.hasReleaseSpring = isSpringSystemRunning;
            if (isSpringSystemRunning != 0) {
                this.scrollGridChain.releaseSpring();
            }
            Log.d(TAG, "onEdgeSpringEvent : ACTION_DOWN : hasReleaseSpring=:" + this.hasReleaseSpring);
        }
        return false;
    }

    public final void setCheckEdge(ICheckViewEdge iCheckViewEdge) {
        this.checkEdge = iCheckViewEdge;
    }
}
