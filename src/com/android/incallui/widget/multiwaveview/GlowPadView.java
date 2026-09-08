package com.android.incallui.widget.multiwaveview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.android.incallui.R;
import com.android.incallui.widget.multiwaveview.Ease;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GlowPadView extends View {
    private static final boolean DEBUG = false;
    private static final int HIDE_ANIMATION_DELAY = 200;
    private static final int HIDE_ANIMATION_DURATION = 200;
    private static final int INITIAL_SHOW_HANDLE_DURATION = 200;
    private static final int RETURN_TO_HOME_DELAY = 1200;
    private static final int RETURN_TO_HOME_DURATION = 200;
    private static final int REVEAL_GLOW_DELAY = 0;
    private static final int REVEAL_GLOW_DURATION = 0;
    private static final float RING_SCALE_COLLAPSED = 0.5f;
    private static final float RING_SCALE_EXPANDED = 1.0f;
    private static final int SHOW_ANIMATION_DELAY = 50;
    private static final int SHOW_ANIMATION_DURATION = 200;
    private static final float SNAP_MARGIN_DEFAULT = 20.0f;
    private static final int STATE_FINISH = 5;
    private static final int STATE_FIRST_TOUCH = 2;
    private static final int STATE_IDLE = 0;
    private static final int STATE_SNAP = 4;
    private static final int STATE_START = 1;
    private static final int STATE_TRACKING = 3;
    private static final String TAG = "GlowPadView";
    private static final float TAP_RADIUS_SCALE_ACCESSIBILITY_ENABLED = 1.3f;
    private static final float TARGET_SCALE_COLLAPSED = 0.8f;
    private static final float TARGET_SCALE_EXPANDED = 1.0f;
    private static final int WAVE_ANIMATION_DURATION = 1350;
    private int mActiveTarget;
    private boolean mAllowScaling;
    private boolean mAlwaysTrackFinger;
    private boolean mAnimatingTargets;
    private Tweener mBackgroundAnimator;
    private ArrayList<String> mDirectionDescriptions;
    private int mDirectionDescriptionsResourceId;
    private boolean mDragging;
    private int mFeedbackCount;
    private AnimationBundle mGlowAnimations;
    private float mGlowRadius;
    private int mGrabbedState;
    private int mGravity;
    private TargetDrawable mHandleDrawable;
    private int mHorizontalInset;
    private boolean mInitialLayout;
    private float mInnerRadius;
    private int mMaxTargetHeight;
    private int mMaxTargetWidth;
    private int mNewTargetResources;
    private OnTriggerListener mOnTriggerListener;
    private float mOuterRadius;
    private TargetDrawable mOuterRing;
    private PointCloud mPointCloud;
    private int mPointerId;
    private Animator.AnimatorListener mResetListener;
    private Animator.AnimatorListener mResetListenerWithPing;
    private float mRingScaleFactor;
    private float mSnapMargin;
    private AnimationBundle mTargetAnimations;
    private ArrayList<String> mTargetDescriptions;
    private int mTargetDescriptionsResourceId;
    private ArrayList<TargetDrawable> mTargetDrawables;
    private int mTargetResourceId;
    private Animator.AnimatorListener mTargetUpdateListener;
    private ValueAnimator.AnimatorUpdateListener mUpdateListener;
    private int mVerticalInset;
    private int mVibrationDuration;
    private Vibrator mVibrator;
    private AnimationBundle mWaveAnimations;
    private float mWaveCenterX;
    private float mWaveCenterY;

    /* loaded from: classes.dex */
    public static class AnimationBundle extends ArrayList<Tweener> {
        private static final long serialVersionUID = -6319262269245852568L;
        private boolean mSuspended;

        private AnimationBundle() {
        }

        public void cancel() {
            int size = size();
            for (int i10 = 0; i10 < size; i10++) {
                get(i10).animator.cancel();
            }
            clear();
        }

        public void setSuspended(boolean z10) {
            this.mSuspended = z10;
        }

        public void start() {
            if (this.mSuspended) {
                return;
            }
            int size = size();
            for (int i10 = 0; i10 < size; i10++) {
                get(i10).animator.start();
            }
        }

        public void stop() {
            int size = size();
            for (int i10 = 0; i10 < size; i10++) {
                get(i10).animator.end();
            }
            clear();
        }
    }

    /* loaded from: classes.dex */
    public interface OnTriggerListener {
        public static final int CENTER_HANDLE = 1;
        public static final int NO_HANDLE = 0;

        void onFinishFinalAnimation();

        void onGrabbed(View view, int i10);

        void onGrabbedStateChange(View view, int i10);

        void onReleased(View view, int i10);

        void onTrigger(View view, int i10);
    }

    public GlowPadView(Context context) {
        this(context, null);
    }

    private void announceTargets() {
        StringBuilder sb = new StringBuilder();
        int size = this.mTargetDrawables.size();
        for (int i10 = 0; i10 < size; i10++) {
            String targetDescription = getTargetDescription(i10);
            String directionDescription = getDirectionDescription(i10);
            if (!TextUtils.isEmpty(targetDescription) && !TextUtils.isEmpty(directionDescription)) {
                sb.append(String.format(directionDescription, targetDescription));
            }
        }
        if (sb.length() > 0) {
            announceForAccessibility(sb.toString());
        }
    }

    private void assignDefaultsIfNeeded() {
        if (this.mOuterRadius == 0.0f) {
            this.mOuterRadius = Math.max(this.mOuterRing.getWidth(), this.mOuterRing.getHeight()) / 2.0f;
        }
        if (this.mSnapMargin == 0.0f) {
            this.mSnapMargin = TypedValue.applyDimension(1, SNAP_MARGIN_DEFAULT, getContext().getResources().getDisplayMetrics());
        }
        if (this.mInnerRadius == 0.0f) {
            this.mInnerRadius = this.mHandleDrawable.getWidth() / 10.0f;
        }
    }

    private void computeInsets(int i10, int i11) {
        int absoluteGravity = Gravity.getAbsoluteGravity(this.mGravity, getLayoutDirection());
        int i12 = absoluteGravity & 7;
        if (i12 != 3) {
            if (i12 != 5) {
                this.mHorizontalInset = i10 / 2;
            } else {
                this.mHorizontalInset = i10;
            }
        } else {
            this.mHorizontalInset = 0;
        }
        int i13 = absoluteGravity & 112;
        if (i13 != 48) {
            if (i13 != 80) {
                this.mVerticalInset = i11 / 2;
                return;
            } else {
                this.mVerticalInset = i11;
                return;
            }
        }
        this.mVerticalInset = 0;
    }

    private float computeScaleFactor(int i10, int i11, int i12, int i13) {
        float f10;
        float f11 = 1.0f;
        if (!this.mAllowScaling) {
            return 1.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.mGravity, getLayoutDirection());
        int i14 = absoluteGravity & 7;
        if (i14 != 3 && i14 != 5 && i10 > i12) {
            f10 = ((i12 * 1.0f) - this.mMaxTargetWidth) / (i10 - r2);
        } else {
            f10 = 1.0f;
        }
        int i15 = absoluteGravity & 112;
        if (i15 != 48 && i15 != 80 && i11 > i13) {
            f11 = ((i13 * 1.0f) - this.mMaxTargetHeight) / (i11 - r4);
        }
        return Math.min(f10, f11);
    }

    private void deactivateTargets() {
        int size = this.mTargetDrawables.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mTargetDrawables.get(i10).setState(TargetDrawable.STATE_INACTIVE);
        }
        this.mActiveTarget = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnFinishFinalAnimation() {
        OnTriggerListener onTriggerListener = this.mOnTriggerListener;
        if (onTriggerListener != null) {
            onTriggerListener.onFinishFinalAnimation();
        }
    }

    private void dispatchTriggerEvent(int i10) {
        vibrate();
        OnTriggerListener onTriggerListener = this.mOnTriggerListener;
        if (onTriggerListener != null) {
            onTriggerListener.onTrigger(this, i10);
        }
    }

    private float dist2(float f10, float f11) {
        return (f10 * f10) + (f11 * f11);
    }

    private void doFinish() {
        int i10 = this.mActiveTarget;
        if (i10 != -1) {
            highlightSelected(i10);
            hideGlow(200, 1200, 0.0f, this.mResetListener);
            dispatchTriggerEvent(i10);
            if (!this.mAlwaysTrackFinger) {
                this.mTargetAnimations.stop();
            }
        } else {
            hideGlow(200, 0, 0.0f, this.mResetListenerWithPing);
            hideTargets(true, false);
        }
        setGrabbedState(0);
    }

    private void dump() {
        Log.v(TAG, "Outer Radius = " + this.mOuterRadius);
        Log.v(TAG, "SnapMargin = " + this.mSnapMargin);
        Log.v(TAG, "FeedbackCount = " + this.mFeedbackCount);
        Log.v(TAG, "VibrationDuration = " + this.mVibrationDuration);
        Log.v(TAG, "GlowRadius = " + this.mGlowRadius);
        Log.v(TAG, "WaveCenterX = " + this.mWaveCenterX);
        Log.v(TAG, "WaveCenterY = " + this.mWaveCenterY);
    }

    private String getDirectionDescription(int i10) {
        ArrayList<String> arrayList = this.mDirectionDescriptions;
        if (arrayList == null || arrayList.isEmpty()) {
            this.mDirectionDescriptions = loadDescriptions(this.mDirectionDescriptionsResourceId);
            if (this.mTargetDrawables.size() != this.mDirectionDescriptions.size()) {
                Log.w(TAG, "The number of target drawables must be equal to the number of direction descriptions.");
                return null;
            }
        }
        return this.mDirectionDescriptions.get(i10);
    }

    private int getResourceId(TypedArray typedArray, int i10) {
        TypedValue peekValue = typedArray.peekValue(i10);
        if (peekValue == null) {
            return 0;
        }
        return peekValue.resourceId;
    }

    private float getRingHeight() {
        return this.mRingScaleFactor * Math.max(this.mOuterRing.getHeight(), this.mOuterRadius * 2.0f);
    }

    private float getRingWidth() {
        return this.mRingScaleFactor * Math.max(this.mOuterRing.getWidth(), this.mOuterRadius * 2.0f);
    }

    private float getScaledGlowRadiusSquared() {
        float f10;
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            f10 = this.mGlowRadius * TAP_RADIUS_SCALE_ACCESSIBILITY_ENABLED;
        } else {
            f10 = this.mGlowRadius;
        }
        return square(f10);
    }

    private String getTargetDescription(int i10) {
        ArrayList<String> arrayList = this.mTargetDescriptions;
        if (arrayList == null || arrayList.isEmpty()) {
            this.mTargetDescriptions = loadDescriptions(this.mTargetDescriptionsResourceId);
            if (this.mTargetDrawables.size() != this.mTargetDescriptions.size()) {
                Log.w(TAG, "The number of target drawables must be equal to the number of target descriptions.");
                return null;
            }
        }
        return this.mTargetDescriptions.get(i10);
    }

    private void handleCancel(MotionEvent motionEvent) {
        int findPointerIndex = motionEvent.findPointerIndex(this.mPointerId);
        if (findPointerIndex == -1) {
            findPointerIndex = 0;
        }
        switchToState(5, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex));
    }

    private void handleDown(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        float x10 = motionEvent.getX(actionIndex);
        float y10 = motionEvent.getY(actionIndex);
        switchToState(1, x10, y10);
        if (!trySwitchToFirstTouchState(x10, y10)) {
            this.mDragging = false;
        } else {
            this.mPointerId = motionEvent.getPointerId(actionIndex);
            updateGlowPosition(x10, y10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b2, code lost:
    
        if (r10 <= r5) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void handleMove(android.view.MotionEvent r29) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.widget.multiwaveview.GlowPadView.handleMove(android.view.MotionEvent):void");
    }

    private void handleUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mPointerId) {
            switchToState(5, motionEvent.getX(actionIndex), motionEvent.getY(actionIndex));
        }
    }

    private void hideGlow(int i10, int i11, float f10, Animator.AnimatorListener animatorListener) {
        this.mGlowAnimations.cancel();
        AnimationBundle animationBundle = this.mGlowAnimations;
        TimeInterpolator timeInterpolator = Ease.Quart.easeOut;
        Integer valueOf = Integer.valueOf(i11);
        Float valueOf2 = Float.valueOf(f10);
        Float valueOf3 = Float.valueOf(0.0f);
        animationBundle.add(Tweener.to(this.mPointCloud.glowManager, i10, "ease", timeInterpolator, "delay", valueOf, "alpha", valueOf2, "x", valueOf3, "y", valueOf3, "onUpdate", this.mUpdateListener, "onComplete", animatorListener));
        this.mGlowAnimations.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTargets(boolean z10, boolean z11) {
        int i10;
        float f10;
        float f11;
        this.mTargetAnimations.cancel();
        this.mAnimatingTargets = z10;
        int i11 = 200;
        int i12 = 0;
        if (z10) {
            i10 = 200;
        } else {
            i10 = 0;
        }
        if (!z10) {
            i11 = 0;
        }
        if (z11) {
            f10 = 1.0f;
        } else {
            f10 = TARGET_SCALE_COLLAPSED;
        }
        TimeInterpolator timeInterpolator = Ease.Cubic.easeOut;
        for (int size = this.mTargetDrawables.size(); i12 < size; size = size) {
            TargetDrawable targetDrawable = this.mTargetDrawables.get(i12);
            targetDrawable.setState(TargetDrawable.STATE_INACTIVE);
            this.mTargetAnimations.add(Tweener.to(targetDrawable, i10, "ease", timeInterpolator, "alpha", Float.valueOf(0.0f), "scaleX", Float.valueOf(f10), "scaleY", Float.valueOf(f10), "delay", Integer.valueOf(i11), "onUpdate", this.mUpdateListener));
            i12++;
            i11 = i11;
            f10 = f10;
        }
        int i13 = i11;
        if (z11) {
            f11 = 1.0f;
        } else {
            f11 = 0.5f;
        }
        float f12 = f11 * this.mRingScaleFactor;
        this.mTargetAnimations.add(Tweener.to(this.mOuterRing, i10, "ease", timeInterpolator, "alpha", Float.valueOf(0.0f), "scaleX", Float.valueOf(f12), "scaleY", Float.valueOf(f12), "delay", Integer.valueOf(i13), "onUpdate", this.mUpdateListener, "onComplete", this.mTargetUpdateListener));
        this.mTargetAnimations.start();
    }

    private void hideUnselected(int i10) {
        for (int i11 = 0; i11 < this.mTargetDrawables.size(); i11++) {
            if (i11 != i10) {
                this.mTargetDrawables.get(i11).setAlpha(0.0f);
            }
        }
    }

    private void highlightSelected(int i10) {
        this.mTargetDrawables.get(i10).setState(TargetDrawable.STATE_ACTIVE);
        hideUnselected(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalSetTargetResources(int i10) {
        ArrayList<TargetDrawable> loadDrawableArray = loadDrawableArray(i10);
        this.mTargetDrawables = loadDrawableArray;
        this.mTargetResourceId = i10;
        int width = this.mHandleDrawable.getWidth();
        int height = this.mHandleDrawable.getHeight();
        int size = loadDrawableArray.size();
        for (int i11 = 0; i11 < size; i11++) {
            TargetDrawable targetDrawable = loadDrawableArray.get(i11);
            width = Math.max(width, targetDrawable.getWidth());
            height = Math.max(height, targetDrawable.getHeight());
        }
        if (this.mMaxTargetWidth == width && this.mMaxTargetHeight == height) {
            updateTargetPositions(this.mWaveCenterX, this.mWaveCenterY);
            updatePointCloudPosition(this.mWaveCenterX, this.mWaveCenterY);
        } else {
            this.mMaxTargetWidth = width;
            this.mMaxTargetHeight = height;
            requestLayout();
        }
    }

    private ArrayList<String> loadDescriptions(int i10) {
        TypedArray obtainTypedArray = getContext().getResources().obtainTypedArray(i10);
        int length = obtainTypedArray.length();
        ArrayList<String> arrayList = new ArrayList<>(length);
        for (int i11 = 0; i11 < length; i11++) {
            arrayList.add(obtainTypedArray.getString(i11));
        }
        obtainTypedArray.recycle();
        return arrayList;
    }

    private ArrayList<TargetDrawable> loadDrawableArray(int i10) {
        int i11;
        TypedArray obtainTypedArray = getContext().getResources().obtainTypedArray(i10);
        int length = obtainTypedArray.length();
        ArrayList<TargetDrawable> arrayList = new ArrayList<>(length);
        for (int i12 = 0; i12 < length; i12++) {
            TypedValue peekValue = obtainTypedArray.peekValue(i12);
            Context context = getContext();
            if (peekValue != null) {
                i11 = peekValue.resourceId;
            } else {
                i11 = 0;
            }
            arrayList.add(new TargetDrawable(context, i11, 3));
        }
        obtainTypedArray.recycle();
        return arrayList;
    }

    private int resolveMeasured(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                return size;
            }
            return i11;
        }
        return Math.min(size, i11);
    }

    private void setGrabbedState(int i10) {
        if (i10 != this.mGrabbedState) {
            if (i10 != 0) {
                vibrate();
            }
            this.mGrabbedState = i10;
            OnTriggerListener onTriggerListener = this.mOnTriggerListener;
            if (onTriggerListener != null) {
                if (i10 == 0) {
                    onTriggerListener.onReleased(this, 1);
                } else {
                    onTriggerListener.onGrabbed(this, 1);
                }
                this.mOnTriggerListener.onGrabbedStateChange(this, i10);
            }
        }
    }

    private void showGlow(int i10, int i11, float f10, Animator.AnimatorListener animatorListener) {
        this.mGlowAnimations.cancel();
        this.mGlowAnimations.add(Tweener.to(this.mPointCloud.glowManager, i10, "ease", Ease.Cubic.easeIn, "delay", Integer.valueOf(i11), "alpha", Float.valueOf(f10), "onUpdate", this.mUpdateListener, "onComplete", animatorListener));
        this.mGlowAnimations.start();
    }

    private void showTargets(boolean z10) {
        int i10;
        int i11;
        this.mTargetAnimations.stop();
        this.mAnimatingTargets = z10;
        if (z10) {
            i10 = 50;
        } else {
            i10 = 0;
        }
        if (z10) {
            i11 = 200;
        } else {
            i11 = 0;
        }
        int size = this.mTargetDrawables.size();
        for (int i12 = 0; i12 < size; i12++) {
            TargetDrawable targetDrawable = this.mTargetDrawables.get(i12);
            targetDrawable.setState(TargetDrawable.STATE_INACTIVE);
            this.mTargetAnimations.add(Tweener.to(targetDrawable, i11, "ease", Ease.Cubic.easeOut, "alpha", Float.valueOf(1.0f), "scaleX", Float.valueOf(1.0f), "scaleY", Float.valueOf(1.0f), "delay", Integer.valueOf(i10), "onUpdate", this.mUpdateListener));
        }
        float f10 = this.mRingScaleFactor * 1.0f;
        this.mTargetAnimations.add(Tweener.to(this.mOuterRing, i11, "ease", Ease.Cubic.easeOut, "alpha", Float.valueOf(1.0f), "scaleX", Float.valueOf(f10), "scaleY", Float.valueOf(f10), "delay", Integer.valueOf(i10), "onUpdate", this.mUpdateListener, "onComplete", this.mTargetUpdateListener));
        this.mTargetAnimations.start();
    }

    private float square(float f10) {
        return f10 * f10;
    }

    private void startBackgroundAnimation(int i10, float f10) {
        Drawable background = getBackground();
        if (this.mAlwaysTrackFinger && background != null) {
            Tweener tweener = this.mBackgroundAnimator;
            if (tweener != null) {
                tweener.animator.cancel();
            }
            Tweener tweener2 = Tweener.to(background, i10, "ease", Ease.Cubic.easeIn, "alpha", Integer.valueOf((int) (f10 * 255.0f)), "delay", 50);
            this.mBackgroundAnimator = tweener2;
            tweener2.animator.start();
        }
    }

    private void startWaveAnimation() {
        this.mWaveAnimations.cancel();
        this.mPointCloud.waveManager.setAlpha(1.0f);
        this.mPointCloud.waveManager.setRadius(this.mHandleDrawable.getWidth() / 2.0f);
        this.mWaveAnimations.add(Tweener.to(this.mPointCloud.waveManager, 1350L, "ease", Ease.Quad.easeOut, "delay", 0, "radius", Float.valueOf(this.mOuterRadius * 2.0f), "onUpdate", this.mUpdateListener, "onComplete", new AnimatorListenerAdapter() { // from class: com.android.incallui.widget.multiwaveview.GlowPadView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                GlowPadView.this.mPointCloud.waveManager.setRadius(0.0f);
                GlowPadView.this.mPointCloud.waveManager.setAlpha(0.0f);
            }
        }));
        this.mWaveAnimations.start();
    }

    private void stopAndHideWaveAnimation() {
        this.mWaveAnimations.cancel();
        this.mPointCloud.waveManager.setAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToState(int i10, float f10, float f11) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 == 5) {
                                doFinish();
                                return;
                            }
                            return;
                        } else {
                            this.mHandleDrawable.setAlpha(0.0f);
                            showGlow(0, 0, 0.0f, null);
                            return;
                        }
                    }
                    this.mHandleDrawable.setAlpha(0.0f);
                    showGlow(0, 0, 1.0f, null);
                    return;
                }
                this.mHandleDrawable.setAlpha(0.0f);
                deactivateTargets();
                showTargets(true);
                startBackgroundAnimation(200, 1.0f);
                setGrabbedState(1);
                if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
                    announceTargets();
                    return;
                }
                return;
            }
            startBackgroundAnimation(0, 0.0f);
            return;
        }
        deactivateTargets();
        hideGlow(0, 0, 0.0f, null);
        startBackgroundAnimation(0, 0.0f);
        this.mHandleDrawable.setState(TargetDrawable.STATE_INACTIVE);
        this.mHandleDrawable.setAlpha(1.0f);
    }

    private boolean trySwitchToFirstTouchState(float f10, float f11) {
        float f12 = f10 - this.mWaveCenterX;
        float f13 = f11 - this.mWaveCenterY;
        if (!this.mAlwaysTrackFinger && dist2(f12, f13) > getScaledGlowRadiusSquared()) {
            return false;
        }
        switchToState(2, f10, f11);
        updateGlowPosition(f12, f13);
        this.mDragging = true;
        return true;
    }

    private void updateGlowPosition(float f10, float f11) {
        float x10 = f10 - this.mOuterRing.getX();
        float y10 = f11 - this.mOuterRing.getY();
        float f12 = this.mRingScaleFactor;
        this.mPointCloud.glowManager.setX(this.mOuterRing.getX() + (x10 * (1.0f / f12)));
        this.mPointCloud.glowManager.setY(this.mOuterRing.getY() + (y10 * (1.0f / f12)));
    }

    private void updatePointCloudPosition(float f10, float f11) {
        this.mPointCloud.setCenter(f10, f11);
    }

    private void updateTargetPositions(float f10, float f11) {
        ArrayList<TargetDrawable> arrayList = this.mTargetDrawables;
        int size = arrayList.size();
        float f12 = (float) ((-6.283185307179586d) / size);
        for (int i10 = 0; i10 < size; i10++) {
            TargetDrawable targetDrawable = arrayList.get(i10);
            targetDrawable.setPositionX(f10);
            targetDrawable.setPositionY(f11);
            double d10 = i10 * f12;
            targetDrawable.setX((getRingWidth() / 2.0f) * ((float) Math.cos(d10)));
            targetDrawable.setY((getRingHeight() / 2.0f) * ((float) Math.sin(d10)));
        }
    }

    private void vibrate() {
        Vibrator vibrator = this.mVibrator;
        if (vibrator != null) {
            vibrator.vibrate(VibrationEffect.createOneShot(this.mVibrationDuration, -1));
        }
    }

    public int getResourceIdForTarget(int i10) {
        TargetDrawable targetDrawable = this.mTargetDrawables.get(i10);
        if (targetDrawable == null) {
            return 0;
        }
        return targetDrawable.getResourceId();
    }

    public int getScaledSuggestedMinimumHeight() {
        return (int) ((this.mRingScaleFactor * Math.max(this.mOuterRing.getHeight(), this.mOuterRadius * 2.0f)) + this.mMaxTargetHeight);
    }

    public int getScaledSuggestedMinimumWidth() {
        return (int) ((this.mRingScaleFactor * Math.max(this.mOuterRing.getWidth(), this.mOuterRadius * 2.0f)) + this.mMaxTargetWidth);
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return (int) (Math.max(this.mOuterRing.getHeight(), this.mOuterRadius * 2.0f) + this.mMaxTargetHeight);
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return (int) (Math.max(this.mOuterRing.getWidth(), this.mOuterRadius * 2.0f) + this.mMaxTargetWidth);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.mPointCloud.draw(canvas);
        this.mOuterRing.draw(canvas);
        int size = this.mTargetDrawables.size();
        for (int i10 = 0; i10 < size; i10++) {
            TargetDrawable targetDrawable = this.mTargetDrawables.get(i10);
            if (targetDrawable != null) {
                targetDrawable.draw(canvas);
            }
        }
        this.mHandleDrawable.draw(canvas);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action != 9) {
                    if (action == 10) {
                        motionEvent.setAction(1);
                    }
                } else {
                    motionEvent.setAction(0);
                }
            } else {
                motionEvent.setAction(2);
            }
            onTouchEvent(motionEvent);
            motionEvent.setAction(action);
        }
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        float ringWidth = getRingWidth();
        float f10 = this.mHorizontalInset + ((this.mMaxTargetWidth + ringWidth) / 2.0f);
        float ringHeight = this.mVerticalInset + ((this.mMaxTargetHeight + getRingHeight()) / 2.0f);
        if (this.mInitialLayout) {
            stopAndHideWaveAnimation();
            hideTargets(false, false);
            this.mInitialLayout = false;
        }
        this.mOuterRing.setPositionX(f10);
        this.mOuterRing.setPositionY(ringHeight);
        this.mPointCloud.setScale(this.mRingScaleFactor);
        this.mHandleDrawable.setPositionX(f10);
        this.mHandleDrawable.setPositionY(ringHeight);
        updateTargetPositions(f10, ringHeight);
        updatePointCloudPosition(f10, ringHeight);
        updateGlowPosition(f10, ringHeight);
        this.mWaveCenterX = f10;
        this.mWaveCenterY = ringHeight;
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int resolveMeasured = resolveMeasured(i10, suggestedMinimumWidth);
        int resolveMeasured2 = resolveMeasured(i11, suggestedMinimumHeight);
        this.mRingScaleFactor = computeScaleFactor(suggestedMinimumWidth, suggestedMinimumHeight, resolveMeasured, resolveMeasured2);
        computeInsets(resolveMeasured - getScaledSuggestedMinimumWidth(), resolveMeasured2 - getScaledSuggestedMinimumHeight());
        setMeasuredDimension(resolveMeasured, resolveMeasured2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L2a
            if (r0 == r1) goto L23
            r2 = 2
            if (r0 == r2) goto L1f
            r2 = 3
            if (r0 == r2) goto L17
            r2 = 5
            if (r0 == r2) goto L2a
            r2 = 6
            if (r0 == r2) goto L23
            r0 = 0
            goto L31
        L17:
            r3.handleMove(r4)
            r3.handleCancel(r4)
        L1d:
            r0 = r1
            goto L31
        L1f:
            r3.handleMove(r4)
            goto L1d
        L23:
            r3.handleMove(r4)
            r3.handleUp(r4)
            goto L1d
        L2a:
            r3.handleDown(r4)
            r3.handleMove(r4)
            goto L1d
        L31:
            r3.invalidate()
            if (r0 == 0) goto L37
            goto L3b
        L37:
            boolean r1 = super.onTouchEvent(r4)
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.widget.multiwaveview.GlowPadView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void ping() {
        if (this.mFeedbackCount > 0) {
            AnimationBundle animationBundle = this.mWaveAnimations;
            if (animationBundle.size() <= 0 || !animationBundle.get(0).animator.isRunning() || animationBundle.get(0).animator.getCurrentPlayTime() >= 675) {
                startWaveAnimation();
            }
        }
    }

    public void setDirectionDescriptionsResourceId(int i10) {
        this.mDirectionDescriptionsResourceId = i10;
        ArrayList<String> arrayList = this.mDirectionDescriptions;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public void setHandleDrawable(int i10) {
        TargetDrawable targetDrawable = new TargetDrawable(getContext(), i10, 2);
        this.mHandleDrawable = targetDrawable;
        targetDrawable.setState(TargetDrawable.STATE_INACTIVE);
        requestLayout();
    }

    public void setOnTriggerListener(OnTriggerListener onTriggerListener) {
        this.mOnTriggerListener = onTriggerListener;
    }

    public void setTargetDescriptionsResourceId(int i10) {
        this.mTargetDescriptionsResourceId = i10;
        ArrayList<String> arrayList = this.mTargetDescriptions;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public void setVibrateEnabled(boolean z10) {
        if (z10 && this.mVibrator == null) {
            this.mVibrator = (Vibrator) getContext().getSystemService("vibrator");
        } else {
            this.mVibrator = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GlowPadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTargetDrawables = new ArrayList<>();
        this.mWaveAnimations = new AnimationBundle();
        this.mTargetAnimations = new AnimationBundle();
        this.mGlowAnimations = new AnimationBundle();
        this.mFeedbackCount = 3;
        this.mVibrationDuration = 0;
        this.mActiveTarget = -1;
        this.mRingScaleFactor = 1.0f;
        this.mOuterRadius = 0.0f;
        this.mSnapMargin = 0.0f;
        this.mResetListener = new AnimatorListenerAdapter() { // from class: com.android.incallui.widget.multiwaveview.GlowPadView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                GlowPadView glowPadView = GlowPadView.this;
                glowPadView.switchToState(0, glowPadView.mWaveCenterX, GlowPadView.this.mWaveCenterY);
                GlowPadView.this.dispatchOnFinishFinalAnimation();
            }
        };
        this.mResetListenerWithPing = new AnimatorListenerAdapter() { // from class: com.android.incallui.widget.multiwaveview.GlowPadView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                GlowPadView.this.ping();
                GlowPadView glowPadView = GlowPadView.this;
                glowPadView.switchToState(0, glowPadView.mWaveCenterX, GlowPadView.this.mWaveCenterY);
                GlowPadView.this.dispatchOnFinishFinalAnimation();
            }
        };
        this.mUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.incallui.widget.multiwaveview.GlowPadView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GlowPadView.this.invalidate();
            }
        };
        this.mTargetUpdateListener = new AnimatorListenerAdapter() { // from class: com.android.incallui.widget.multiwaveview.GlowPadView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (GlowPadView.this.mNewTargetResources != 0) {
                    GlowPadView glowPadView = GlowPadView.this;
                    glowPadView.internalSetTargetResources(glowPadView.mNewTargetResources);
                    GlowPadView.this.mNewTargetResources = 0;
                    GlowPadView.this.hideTargets(false, false);
                }
                GlowPadView.this.mAnimatingTargets = false;
            }
        };
        this.mGravity = 48;
        this.mInitialLayout = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GlowPadView);
        this.mInnerRadius = obtainStyledAttributes.getDimension(R.styleable.GlowPadView_innerRadius, this.mInnerRadius);
        this.mOuterRadius = obtainStyledAttributes.getDimension(R.styleable.GlowPadView_outerRadius, this.mOuterRadius);
        this.mSnapMargin = obtainStyledAttributes.getDimension(R.styleable.GlowPadView_snapMargin, this.mSnapMargin);
        this.mVibrationDuration = obtainStyledAttributes.getInt(R.styleable.GlowPadView_vibrationDuration, this.mVibrationDuration);
        this.mFeedbackCount = obtainStyledAttributes.getInt(R.styleable.GlowPadView_feedbackCount, this.mFeedbackCount);
        this.mAllowScaling = obtainStyledAttributes.getBoolean(R.styleable.GlowPadView_allowScaling, false);
        TypedValue peekValue = obtainStyledAttributes.peekValue(R.styleable.GlowPadView_handleDrawable);
        setHandleDrawable(peekValue != null ? peekValue.resourceId : R.drawable.ic_incall_audio_handle);
        this.mOuterRing = new TargetDrawable(context, getResourceId(obtainStyledAttributes, R.styleable.GlowPadView_outerRingDrawable), 1);
        this.mAlwaysTrackFinger = obtainStyledAttributes.getBoolean(R.styleable.GlowPadView_alwaysTrackFinger, false);
        int resourceId = getResourceId(obtainStyledAttributes, R.styleable.GlowPadView_pointDrawable);
        Drawable drawable = resourceId != 0 ? context.getDrawable(resourceId) : null;
        this.mGlowRadius = obtainStyledAttributes.getDimension(R.styleable.GlowPadView_glowRadius, 0.0f);
        TypedValue typedValue = new TypedValue();
        if (obtainStyledAttributes.getValue(R.styleable.GlowPadView_targetDrawables, typedValue)) {
            internalSetTargetResources(typedValue.resourceId);
        }
        ArrayList<TargetDrawable> arrayList = this.mTargetDrawables;
        if (arrayList != null && arrayList.size() != 0) {
            if (obtainStyledAttributes.getValue(R.styleable.GlowPadView_targetDescriptions, typedValue)) {
                int i10 = typedValue.resourceId;
                if (i10 != 0) {
                    setTargetDescriptionsResourceId(i10);
                } else {
                    throw new IllegalStateException("Must specify target descriptions");
                }
            }
            if (obtainStyledAttributes.getValue(R.styleable.GlowPadView_directionDescriptions, typedValue)) {
                int i11 = typedValue.resourceId;
                if (i11 != 0) {
                    setDirectionDescriptionsResourceId(i11);
                } else {
                    throw new IllegalStateException("Must specify direction descriptions");
                }
            }
            this.mGravity = obtainStyledAttributes.getInt(R.styleable.GlowPadView_android_gravity, 48);
            obtainStyledAttributes.recycle();
            setVibrateEnabled(this.mVibrationDuration > 0);
            assignDefaultsIfNeeded();
            PointCloud pointCloud = new PointCloud(drawable);
            this.mPointCloud = pointCloud;
            pointCloud.makePointCloud(this.mInnerRadius, this.mOuterRadius);
            this.mPointCloud.glowManager.setRadius(this.mGlowRadius);
            return;
        }
        throw new IllegalStateException("Must specify at least one target drawable");
    }
}
