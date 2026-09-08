package com.coui.appcompat.springchain;

import B9.i;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.coui.appcompat.scrollview.COUIScrollView;
import com.coui.appcompat.uiutil.UIUtil;
import kotlin.jvm.internal.f;

/* compiled from: COUIGridSpringChainScrollView.kt */
/* loaded from: classes.dex */
public final class COUIGridSpringChainScrollView extends COUIScrollView {
    public static final Companion Companion = new Companion(null);
    private static final boolean DEBUG = true;
    private static final float MAX_DISTANCE_FACTOR = 0.25f;
    private static final float MAX_DISTANCE_RATIO = 0.5f;
    private static final float OVER_SCROLL_FACTOR = 0.3f;
    private static final String TAG = "EdgeSpringChainScrollView";
    private float curDistance;
    private float downY;
    private ICOUIGridSpringChainViewGroup edgeSpringChainViewGroup;
    private int hasReleaseSpring;
    private float inheritDistance;
    private boolean shouldUpdateDownY;

    /* compiled from: COUIGridSpringChainScrollView.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public /* synthetic */ COUIGridSpringChainScrollView(Context context, AttributeSet attributeSet, int i10, f fVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    private final float getFormalDistance(float f10, float f11) {
        float f12;
        float a10;
        float d10;
        float a11;
        float d11;
        if (f11 * f10 <= 0.0f) {
            return f10;
        }
        ICOUIGridSpringChainViewGroup iCOUIGridSpringChainViewGroup = this.edgeSpringChainViewGroup;
        if (iCOUIGridSpringChainViewGroup != null) {
            f12 = iCOUIGridSpringChainViewGroup.getLastTranslationY();
        } else {
            f12 = 0.0f;
        }
        float abs = Math.abs(f12);
        float height = (getHeight() * 0.5f) / MAX_DISTANCE_FACTOR;
        a10 = i.a(((getHeight() * 0.5f) - abs) / MAX_DISTANCE_FACTOR, 0.0f);
        d10 = i.d(a10, height);
        a11 = i.a(1 - Math.abs(f11 / d10), 0.0f);
        d11 = i.d(a11, 1.0f);
        return (d11 * (f10 - f11)) + f11;
    }

    private final boolean isReachBottomEdge() {
        View childAt = getChildAt(0);
        if (childAt == null || getScrollY() + getHeight() < childAt.getMeasuredHeight()) {
            return false;
        }
        return true;
    }

    private final boolean isReachTopEdge() {
        if (getScrollY() <= 0) {
            return true;
        }
        return false;
    }

    private final boolean onEdgeSpringEvent(MotionEvent motionEvent) {
        Integer num;
        int i10;
        ICOUIGridSpringChainViewGroup iCOUIGridSpringChainViewGroup;
        float rawY = motionEvent.getRawY(UIUtil.getAdjustmentPointerIndex(motionEvent, motionEvent.getActionIndex()));
        int action = motionEvent.getAction() & 255;
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
                        ICOUIGridSpringChainViewGroup iCOUIGridSpringChainViewGroup2 = this.edgeSpringChainViewGroup;
                        if (iCOUIGridSpringChainViewGroup2 != null) {
                            iCOUIGridSpringChainViewGroup2.updateMoveTranslation(this.curDistance, 1);
                        }
                        return true;
                    }
                    if (this.curDistance < 0.0f && isReachBottomEdge()) {
                        ICOUIGridSpringChainViewGroup iCOUIGridSpringChainViewGroup3 = this.edgeSpringChainViewGroup;
                        if (iCOUIGridSpringChainViewGroup3 != null) {
                            iCOUIGridSpringChainViewGroup3.updateMoveTranslation(this.curDistance, 2);
                        }
                        return true;
                    }
                    if (this.hasReleaseSpring != 0) {
                        this.downY = rawY;
                        ICOUIGridSpringChainViewGroup iCOUIGridSpringChainViewGroup4 = this.edgeSpringChainViewGroup;
                        if (iCOUIGridSpringChainViewGroup4 != null) {
                            iCOUIGridSpringChainViewGroup4.updateMoveTranslation(0.0f, 0);
                        }
                    } else {
                        this.downY = rawY;
                    }
                }
            }
            this.curDistance = getFormalDistance((rawY - this.downY) + this.inheritDistance, this.curDistance);
            Log.d(TAG, "onEdgeSpringEvent : ACTION_UP/CANCEL : curDistance=:" + this.curDistance + " ,isReachTopEdge()=:" + isReachTopEdge() + " ,isReachBottomEdge()=:" + isReachBottomEdge() + " ,hasReleaseSpring=:" + this.hasReleaseSpring);
            if (this.curDistance > 0.0f && isReachTopEdge()) {
                ICOUIGridSpringChainViewGroup iCOUIGridSpringChainViewGroup5 = this.edgeSpringChainViewGroup;
                if (iCOUIGridSpringChainViewGroup5 != null) {
                    iCOUIGridSpringChainViewGroup5.startRebound(1);
                }
                return true;
            }
            if (this.curDistance < 0.0f && isReachBottomEdge()) {
                ICOUIGridSpringChainViewGroup iCOUIGridSpringChainViewGroup6 = this.edgeSpringChainViewGroup;
                if (iCOUIGridSpringChainViewGroup6 != null) {
                    iCOUIGridSpringChainViewGroup6.startRebound(2);
                }
                return true;
            }
            if (this.hasReleaseSpring != 0) {
                this.downY = rawY;
                ICOUIGridSpringChainViewGroup iCOUIGridSpringChainViewGroup7 = this.edgeSpringChainViewGroup;
                if (iCOUIGridSpringChainViewGroup7 != null) {
                    iCOUIGridSpringChainViewGroup7.startRebound(0);
                }
            } else {
                this.downY = rawY;
            }
        } else {
            this.downY = rawY;
            this.curDistance = 0.0f;
            this.inheritDistance = 0.0f;
            ICOUIGridSpringChainViewGroup iCOUIGridSpringChainViewGroup8 = this.edgeSpringChainViewGroup;
            Integer num2 = null;
            if (iCOUIGridSpringChainViewGroup8 != null) {
                num = Integer.valueOf(iCOUIGridSpringChainViewGroup8.isSpringSystemRunning());
            } else {
                num = null;
            }
            if (num != null) {
                ICOUIGridSpringChainViewGroup iCOUIGridSpringChainViewGroup9 = this.edgeSpringChainViewGroup;
                if (iCOUIGridSpringChainViewGroup9 != null) {
                    num2 = Integer.valueOf(iCOUIGridSpringChainViewGroup9.isSpringSystemRunning());
                }
                kotlin.jvm.internal.i.c(num2);
                i10 = num2.intValue();
            } else {
                i10 = 0;
            }
            this.hasReleaseSpring = i10;
            if (i10 != 0 && (iCOUIGridSpringChainViewGroup = this.edgeSpringChainViewGroup) != null) {
                iCOUIGridSpringChainViewGroup.releaseSpring();
            }
            Log.d(TAG, "onEdgeSpringEvent : ACTION_DOWN : hasReleaseSpring=:" + this.hasReleaseSpring);
        }
        return false;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0 && (getChildAt(0) instanceof ICOUIGridSpringChainViewGroup)) {
            KeyEvent.Callback childAt = getChildAt(0);
            kotlin.jvm.internal.i.d(childAt, "null cannot be cast to non-null type com.coui.appcompat.springchain.ICOUIGridSpringChainViewGroup");
            this.edgeSpringChainViewGroup = (ICOUIGridSpringChainViewGroup) childAt;
        }
    }

    @Override // com.coui.appcompat.scrollview.COUIScrollView, android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.i.f(ev, "ev");
        onEdgeSpringEvent(ev);
        return super.onTouchEvent(ev);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIGridSpringChainScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.i.f(context, "context");
        setEnableVibrator(false);
        setCustomOverScrollDistFactor(0.3f);
        setOverScrollMode(0);
    }
}
