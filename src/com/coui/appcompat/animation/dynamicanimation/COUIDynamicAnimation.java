package com.coui.appcompat.animation.dynamicanimation;

import A2.z;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.K;
import androidx.dynamicanimation.animation.d;
import androidx.dynamicanimation.animation.e;
import com.coui.appcompat.animation.COUIAnimatorMonitor;
import com.coui.appcompat.animation.dynamicanimation.COUIAnimationHandler;
import com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class COUIDynamicAnimation<T extends COUIDynamicAnimation<T>> implements COUIAnimationHandler.AnimationFrameCallback {
    public static final float MIN_VISIBLE_CHANGE_ALPHA = 0.00390625f;
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = 0.1f;
    public static final float MIN_VISIBLE_CHANGE_SCALE = 0.002f;
    private static final float THRESHOLD_MULTIPLIER = 0.75f;
    private static final float UNSET = Float.MAX_VALUE;
    private final COUIAnimatorMonitor mAnimatorMonitor;
    boolean mEnableNonMainThread;
    private final ArrayList<OnAnimationEndListener> mEndListeners;
    private long mLastFrameTime;
    float mMaxValue;
    float mMinValue;
    private float mMinVisibleChange;
    final d mProperty;
    boolean mRunning;
    boolean mStartValueIsSet;
    final Object mTarget;
    private final ArrayList<OnAnimationUpdateListener> mUpdateListeners;
    float mValue;
    float mVelocity;
    public static final ViewProperty TRANSLATION_X = new ViewProperty("translationX") { // from class: com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.1
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getTranslationX();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setTranslationX(f10);
        }
    };
    public static final ViewProperty TRANSLATION_Y = new ViewProperty("translationY") { // from class: com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.2
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getTranslationY();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setTranslationY(f10);
        }
    };
    public static final ViewProperty TRANSLATION_Z = new ViewProperty("translationZ") { // from class: com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.3
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return K.F(view);
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            K.F0(view, f10);
        }
    };
    public static final ViewProperty SCALE_X = new ViewProperty("scaleX") { // from class: com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.4
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getScaleX();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setScaleX(f10);
        }
    };
    public static final ViewProperty SCALE_Y = new ViewProperty("scaleY") { // from class: com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.5
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getScaleY();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setScaleY(f10);
        }
    };
    public static final ViewProperty ROTATION = new ViewProperty("rotation") { // from class: com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.6
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getRotation();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setRotation(f10);
        }
    };
    public static final ViewProperty ROTATION_X = new ViewProperty("rotationX") { // from class: com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.7
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getRotationX();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setRotationX(f10);
        }
    };
    public static final ViewProperty ROTATION_Y = new ViewProperty("rotationY") { // from class: com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.8
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getRotationY();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setRotationY(f10);
        }
    };

    /* renamed from: X, reason: collision with root package name */
    public static final ViewProperty f19793X = new ViewProperty("x") { // from class: com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.9
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getX();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setX(f10);
        }
    };

    /* renamed from: Y, reason: collision with root package name */
    public static final ViewProperty f19794Y = new ViewProperty("y") { // from class: com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.10
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getY();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setY(f10);
        }
    };

    /* renamed from: Z, reason: collision with root package name */
    public static final ViewProperty f19795Z = new ViewProperty(z.f196a) { // from class: com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.11
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return K.I(view);
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            K.H0(view, f10);
        }
    };
    public static final ViewProperty ALPHA = new ViewProperty("alpha") { // from class: com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.12
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getAlpha();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setAlpha(f10);
        }
    };
    public static final ViewProperty SCROLL_X = new ViewProperty("scrollX") { // from class: com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.13
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getScrollX();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setScrollX((int) f10);
        }
    };
    public static final ViewProperty SCROLL_Y = new ViewProperty("scrollY") { // from class: com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.14
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(View view) {
            return view.getScrollY();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(View view, float f10) {
            view.setScrollY((int) f10);
        }
    };

    /* loaded from: classes.dex */
    public static class MassState {
        float mValue;
        float mVelocity;
    }

    /* loaded from: classes.dex */
    public interface OnAnimationEndListener {
        void onAnimationEnd(COUIDynamicAnimation cOUIDynamicAnimation, boolean z10, float f10, float f11);
    }

    /* loaded from: classes.dex */
    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(COUIDynamicAnimation cOUIDynamicAnimation, float f10, float f11);
    }

    /* loaded from: classes.dex */
    public static abstract class ViewProperty extends d<View> {
        private ViewProperty(String str) {
            super(str);
        }
    }

    public COUIDynamicAnimation(final e eVar) {
        COUIAnimatorMonitor cOUIAnimatorMonitor = new COUIAnimatorMonitor(null);
        this.mAnimatorMonitor = cOUIAnimatorMonitor;
        this.mVelocity = 0.0f;
        this.mValue = UNSET;
        this.mStartValueIsSet = false;
        this.mEnableNonMainThread = false;
        this.mRunning = false;
        this.mMaxValue = UNSET;
        this.mMinValue = -UNSET;
        this.mLastFrameTime = 0L;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = null;
        this.mProperty = new d("FloatValueHolder") { // from class: com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.15
            @Override // androidx.dynamicanimation.animation.d
            public float getValue(Object obj) {
                return eVar.a();
            }

            @Override // androidx.dynamicanimation.animation.d
            public void setValue(Object obj, float f10) {
                eVar.b(f10);
            }
        };
        this.mMinVisibleChange = 1.0f;
        cOUIAnimatorMonitor.hookAnimator();
    }

    private void endAnimationInternal(boolean z10) {
        this.mRunning = false;
        COUIAnimationHandler.getInstance().removeCallback(this);
        this.mAnimatorMonitor.hookSpringAnimationEnd(hashCode());
        this.mLastFrameTime = 0L;
        this.mStartValueIsSet = false;
        for (int i10 = 0; i10 < this.mEndListeners.size(); i10++) {
            if (this.mEndListeners.get(i10) != null) {
                this.mEndListeners.get(i10).onAnimationEnd(this, z10, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mEndListeners);
    }

    private float getPropertyValue() {
        return this.mProperty.getValue(this.mTarget);
    }

    private static <T> void removeEntry(ArrayList<T> arrayList, T t10) {
        int indexOf = arrayList.indexOf(t10);
        if (indexOf >= 0) {
            arrayList.set(indexOf, null);
        }
    }

    private static <T> void removeNullEntries(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void startAnimationInternal() {
        if (!this.mRunning) {
            this.mRunning = true;
            if (!this.mStartValueIsSet) {
                this.mValue = getPropertyValue();
            }
            float f10 = this.mValue;
            if (f10 <= this.mMaxValue && f10 >= this.mMinValue) {
                COUIAnimationHandler.getInstance().addAnimationFrameCallback(this, 0L);
                this.mAnimatorMonitor.hookSpringAnimationStart(hashCode());
                return;
            }
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
    }

    public T addEndListener(OnAnimationEndListener onAnimationEndListener) {
        if (!this.mEndListeners.contains(onAnimationEndListener)) {
            this.mEndListeners.add(onAnimationEndListener);
        }
        return this;
    }

    public T addUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        if (!isRunning()) {
            if (!this.mUpdateListeners.contains(onAnimationUpdateListener)) {
                this.mUpdateListeners.add(onAnimationUpdateListener);
            }
            return this;
        }
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public void cancel() {
        if (!this.mEnableNonMainThread && Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        }
        if (this.mRunning) {
            endAnimationInternal(true);
        }
    }

    @Override // com.coui.appcompat.animation.dynamicanimation.COUIAnimationHandler.AnimationFrameCallback
    public boolean doAnimationFrame(long j10) {
        long j11 = this.mLastFrameTime;
        if (j11 == 0) {
            this.mLastFrameTime = j10;
            setPropertyValue(this.mValue);
            return false;
        }
        this.mLastFrameTime = j10;
        boolean updateValueAndVelocity = updateValueAndVelocity(j10 - j11);
        float min = Math.min(this.mValue, this.mMaxValue);
        this.mValue = min;
        float max = Math.max(min, this.mMinValue);
        this.mValue = max;
        setPropertyValue(max);
        this.mAnimatorMonitor.hookAfterUpdateProperty(j10);
        if (updateValueAndVelocity) {
            endAnimationInternal(false);
        }
        return updateValueAndVelocity;
    }

    public abstract float getAcceleration(float f10, float f11);

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    public float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    public abstract boolean isAtEquilibrium(float f10, float f11);

    public boolean isRunning() {
        return this.mRunning;
    }

    public void removeEndListener(OnAnimationEndListener onAnimationEndListener) {
        removeEntry(this.mEndListeners, onAnimationEndListener);
    }

    public void removeUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        removeEntry(this.mUpdateListeners, onAnimationUpdateListener);
    }

    public T setEnableNonMainThread(boolean z10) {
        this.mEnableNonMainThread = z10;
        return this;
    }

    public T setMaxValue(float f10) {
        this.mMaxValue = f10;
        return this;
    }

    public T setMinValue(float f10) {
        this.mMinValue = f10;
        return this;
    }

    public T setMinimumVisibleChange(float f10) {
        if (f10 > 0.0f) {
            this.mMinVisibleChange = f10;
            setValueThreshold(f10 * 0.75f);
            return this;
        }
        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    public void setPropertyValue(float f10) {
        this.mProperty.setValue(this.mTarget, f10);
        for (int i10 = 0; i10 < this.mUpdateListeners.size(); i10++) {
            if (this.mUpdateListeners.get(i10) != null) {
                this.mUpdateListeners.get(i10).onAnimationUpdate(this, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mUpdateListeners);
    }

    public T setStartValue(float f10) {
        this.mValue = f10;
        this.mStartValueIsSet = true;
        return this;
    }

    public T setStartVelocity(float f10) {
        this.mVelocity = f10;
        return this;
    }

    public abstract void setValueThreshold(float f10);

    public void start() {
        if (!this.mEnableNonMainThread && Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (!this.mRunning) {
            startAnimationInternal();
        }
    }

    public abstract boolean updateValueAndVelocity(long j10);

    public <K> COUIDynamicAnimation(K k10, d<K> dVar) {
        COUIAnimatorMonitor cOUIAnimatorMonitor = new COUIAnimatorMonitor(null);
        this.mAnimatorMonitor = cOUIAnimatorMonitor;
        this.mVelocity = 0.0f;
        this.mValue = UNSET;
        this.mStartValueIsSet = false;
        this.mEnableNonMainThread = false;
        this.mRunning = false;
        this.mMaxValue = UNSET;
        this.mMinValue = -UNSET;
        this.mLastFrameTime = 0L;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = k10;
        this.mProperty = dVar;
        if (dVar != ROTATION && dVar != ROTATION_X && dVar != ROTATION_Y) {
            if (dVar == ALPHA) {
                this.mMinVisibleChange = 0.00390625f;
            } else if (dVar != SCALE_X && dVar != SCALE_Y) {
                this.mMinVisibleChange = 1.0f;
            } else {
                this.mMinVisibleChange = 0.00390625f;
            }
        } else {
            this.mMinVisibleChange = 0.1f;
        }
        cOUIAnimatorMonitor.hookAnimator();
    }
}
