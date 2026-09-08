package com.coui.appcompat.checkbox;

import A.h;
import X8.c;
import X8.f;
import X8.g;
import X8.o;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.S;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.state.COUIMaskRippleDrawable;
import com.coui.appcompat.state.COUIStateEffectDrawable;
import com.coui.appcompat.uiutil.COUIWorkHandler;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class COUICheckBox extends AppCompatButton implements Checkable {
    private static final int[] ALLSELECT_SET;
    private static final Rect BUTTON_DRAWABLE_BOUNDS;
    private static final boolean COUI_DEBUG;
    private static final boolean DEBUG = false;
    private static final long DEFAULT_LOAD_DRAWABLE_DELAY = 100;
    private static final int MAX_INDEX = 2;
    private static final int[] PARTSELECT_SET;
    public static final int SELECT_ALL = 2;
    public static final int SELECT_NONE = 0;
    public static final int SELECT_PART = 1;
    public static final int SELECT_UNSPECIFIC = -1;
    private static final String TAG = "COUICheckBox";
    private AccessibilityManager mAccessibilityManager;
    private final AtomicBoolean mAsyncLock;
    private boolean mBroadcasting;
    private Drawable mButtonDrawable;
    private int mButtonResource;
    private int mDrawableTextMargin;
    private COUIMaskRippleDrawable mMaskRippleDrawable;
    private OnStateChangeListener mOnStateChangeListener;
    private int mPendingState;
    private int mState;
    private COUIStateEffectDrawable mStateEffectBackground;
    private int mStyle;

    /* loaded from: classes.dex */
    public static class LoadDrawableRunnable implements Runnable {
        private final AttributeSet mAttrs;
        private final int mDefStyle;
        private final WeakReference<COUICheckBox> mWeakCheckbox;

        public LoadDrawableRunnable(COUICheckBox cOUICheckBox, AttributeSet attributeSet, int i10) {
            this.mWeakCheckbox = new WeakReference<>(cOUICheckBox);
            this.mAttrs = attributeSet;
            this.mDefStyle = i10;
        }

        private void configAnimatedVectorDrawableAndSetState(final COUICheckBox cOUICheckBox, final Drawable drawable) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                cOUICheckBox.configAnimatedVectorDrawableAndSetState(drawable);
            } else {
                cOUICheckBox.postOnAnimation(new Runnable() { // from class: com.coui.appcompat.checkbox.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        COUICheckBox.access$200(COUICheckBox.this, drawable);
                    }
                });
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            COUICheckBox cOUICheckBox = this.mWeakCheckbox.get();
            if (cOUICheckBox != null && cOUICheckBox.requestLock()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (COUICheckBox.COUI_DEBUG) {
                    Log.d(COUICheckBox.TAG, "runnable run, current thread = " + Thread.currentThread() + " start time = " + currentTimeMillis);
                }
                TypedArray obtainStyledAttributes = cOUICheckBox.getContext().obtainStyledAttributes(this.mAttrs, o.f5199S, this.mDefStyle, 0);
                Drawable drawable = obtainStyledAttributes.getDrawable(o.f5215U);
                if (drawable != null) {
                    configAnimatedVectorDrawableAndSetState(cOUICheckBox, drawable);
                }
                if (COUICheckBox.COUI_DEBUG) {
                    Log.d(COUICheckBox.TAG, "end time = " + (System.currentTimeMillis() - currentTimeMillis));
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnStateChangeListener {
        void onStateChanged(COUICheckBox cOUICheckBox, int i10);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.checkbox.COUICheckBox.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        };
        int mState;

        public String toString() {
            return "CompoundButton.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " state=" + this.mState + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Integer.valueOf(this.mState));
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.mState = 0;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mState = 0;
            this.mState = ((Integer) parcel.readValue(null)).intValue();
        }
    }

    static {
        boolean z10;
        if (!COUILog.LOG_DEBUG && !COUILog.isLoggable(TAG, 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        COUI_DEBUG = z10;
        ALLSELECT_SET = new int[]{c.f4403r0};
        PARTSELECT_SET = new int[]{c.f4411v0};
        BUTTON_DRAWABLE_BOUNDS = new Rect();
    }

    public COUICheckBox(Context context) {
        this(context, null);
    }

    public static /* synthetic */ void access$200(COUICheckBox cOUICheckBox, Drawable drawable) {
        cOUICheckBox.configAnimatedVectorDrawableAndSetState(drawable);
    }

    private void asyncLoadAnimatedVectorDrawable(Runnable runnable) {
        COUIWorkHandler.getInstance().start(runnable);
        postDelayed(runnable, 100L);
        configDefaultDrawable(this.mPendingState);
    }

    private void checkDrawableEnableState() {
        if (!isFocusable() && !isClickable()) {
            this.mMaskRippleDrawable.setDrawableEnabled(false);
        } else {
            this.mMaskRippleDrawable.setDrawableEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configAnimatedVectorDrawableAndSetState(Drawable drawable) {
        setButtonDrawable(drawable);
        jumpToCurrentState(drawable, this.mPendingState);
        int i10 = this.mPendingState;
        this.mPendingState = -1;
        setState(i10);
    }

    private void configDefaultDrawable(int i10) {
        int i11;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    i11 = -1;
                } else if (isEnabled()) {
                    i11 = g.f4854g;
                } else {
                    i11 = g.f4853f;
                }
            } else if (isEnabled()) {
                i11 = g.f4856i;
            } else {
                i11 = g.f4855h;
            }
        } else if (isEnabled()) {
            i11 = g.f4852e;
        } else {
            i11 = g.f4851d;
        }
        if (i11 != -1) {
            setButtonDrawable(i11);
        }
    }

    private void configStateDrawable() {
        this.mStateEffectBackground.setBounds(BUTTON_DRAWABLE_BOUNDS);
    }

    private void configStateEffectBackground() {
        Drawable background;
        COUIMaskRippleDrawable cOUIMaskRippleDrawable = new COUIMaskRippleDrawable(getContext());
        this.mMaskRippleDrawable = cOUIMaskRippleDrawable;
        cOUIMaskRippleDrawable.setCircleRippleMask(COUIMaskRippleDrawable.getMaskRippleRadiusByType(getContext(), 1));
        if (getBackground() == null) {
            background = new ColorDrawable(0);
        } else {
            background = getBackground();
        }
        COUIStateEffectDrawable cOUIStateEffectDrawable = new COUIStateEffectDrawable(new Drawable[]{background, this.mMaskRippleDrawable});
        this.mStateEffectBackground = cOUIStateEffectDrawable;
        super.setBackground(cOUIStateEffectDrawable);
        COUIDarkModeUtil.setForceDarkAllow(this, false);
    }

    private void jumpToCurrentState(Drawable drawable, int i10) {
        if (i10 == 1) {
            drawable.setState(PARTSELECT_SET);
        } else if (i10 == 2) {
            drawable.setState(ALLSELECT_SET);
        }
        drawable.jumpToCurrentState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean requestLock() {
        return this.mAsyncLock.compareAndSet(false, true);
    }

    private void updateButtonDrawableBounds() {
        int height;
        Drawable drawable = this.mButtonDrawable;
        if (drawable != null) {
            int gravity = getGravity() & 112;
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int i10 = 0;
            if (gravity != 16) {
                if (gravity != 80) {
                    height = 0;
                } else {
                    height = getHeight() - intrinsicHeight;
                }
            } else {
                height = (getHeight() - intrinsicHeight) / 2;
            }
            int i11 = intrinsicHeight + height;
            if (S.b(this)) {
                i10 = getWidth() - intrinsicWidth;
            }
            if (S.b(this)) {
                intrinsicWidth = getWidth();
            }
            BUTTON_DRAWABLE_BOUNDS.set(i10, height, intrinsicWidth, i11);
        }
    }

    private void updateStateDescription() {
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        if (this.mAccessibilityManager == null) {
            this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        }
        if (this.mAccessibilityManager.isEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            obtain.setContentChangeTypes(64);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (isEnabled() && motionEvent.getActionMasked() == 9) {
            setHovered(true);
        }
        if (motionEvent.getActionMasked() == 10 && isHovered()) {
            setHovered(false);
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        updateButtonDrawableBounds();
        checkDrawableEnableState();
        configStateDrawable();
        super.draw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mButtonDrawable != null) {
            this.mButtonDrawable.setState(getDrawableState());
            invalidate();
        }
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingLeft() {
        Drawable drawable;
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        if (!S.b(this) && (drawable = this.mButtonDrawable) != null) {
            int intrinsicWidth = compoundPaddingLeft + drawable.getIntrinsicWidth();
            if (!TextUtils.isEmpty(getText())) {
                return intrinsicWidth + this.mDrawableTextMargin;
            }
            return intrinsicWidth;
        }
        return compoundPaddingLeft;
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingRight() {
        Drawable drawable;
        int compoundPaddingRight = super.getCompoundPaddingRight();
        if (S.b(this) && (drawable = this.mButtonDrawable) != null) {
            int intrinsicWidth = compoundPaddingRight + drawable.getIntrinsicWidth();
            if (!TextUtils.isEmpty(getText())) {
                return intrinsicWidth + this.mDrawableTextMargin;
            }
            return intrinsicWidth;
        }
        return compoundPaddingRight;
    }

    @ViewDebug.ExportedProperty
    public int getState() {
        return this.mState;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        if (getState() == 2) {
            return true;
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mButtonDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (getState() == 1) {
            View.mergeDrawableStates(onCreateDrawableState, PARTSELECT_SET);
        }
        if (getState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, ALLSELECT_SET);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.mButtonDrawable;
        if (drawable != null) {
            Rect rect = BUTTON_DRAWABLE_BOUNDS;
            drawable.setBounds(rect);
            drawable.draw(canvas);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(COUICheckBox.class.getName());
        if (this.mState == 2) {
            accessibilityEvent.setChecked(true);
        } else {
            accessibilityEvent.setChecked(false);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(COUICheckBox.class.getName());
        accessibilityNodeInfo.setCheckable(true);
        if (this.mState == 2) {
            accessibilityNodeInfo.setChecked(true);
        } else {
            accessibilityNodeInfo.setChecked(false);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setState(savedState.mState);
        requestLayout();
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mState = getState();
        return savedState;
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void refresh() {
        String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        TypedArray typedArray = null;
        if ("attr".equals(resourceTypeName)) {
            typedArray = getContext().obtainStyledAttributes(null, o.f5199S, this.mStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArray = getContext().obtainStyledAttributes(null, o.f5199S, 0, this.mStyle);
        }
        if (typedArray != null) {
            Drawable drawable = typedArray.getDrawable(o.f5215U);
            if (drawable != null) {
                setButtonDrawable(drawable);
            }
            typedArray.recycle();
        }
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable != null) {
            cOUIStateEffectDrawable.refresh(getContext());
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable != null) {
            if (drawable == null) {
                cOUIStateEffectDrawable.setViewBackground(new ColorDrawable(0));
                return;
            } else {
                cOUIStateEffectDrawable.setViewBackground(drawable);
                return;
            }
        }
        super.setBackground(drawable);
    }

    public void setButtonDrawable(int i10) {
        if (i10 == 0 || i10 != this.mButtonResource) {
            this.mButtonResource = i10;
            setButtonDrawable(i10 != 0 ? h.f(getResources(), this.mButtonResource, getContext().getTheme()) : null);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (z10) {
            setState(2);
        } else {
            setState(0);
        }
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.mOnStateChangeListener = onStateChangeListener;
    }

    public void setState(int i10) {
        if (this.mPendingState != -1) {
            this.mPendingState = i10;
            configDefaultDrawable(i10);
            return;
        }
        if (this.mState != i10) {
            this.mState = i10;
            refreshDrawableState();
            if (this.mBroadcasting) {
                return;
            }
            this.mBroadcasting = true;
            OnStateChangeListener onStateChangeListener = this.mOnStateChangeListener;
            if (onStateChangeListener != null) {
                onStateChangeListener.onStateChanged(this, this.mState);
            }
            this.mBroadcasting = false;
            updateStateDescription();
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        int i10 = 2;
        if (this.mState >= 2) {
            i10 = 0;
        }
        setState(i10);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.mButtonDrawable) {
            return false;
        }
        return true;
    }

    public COUICheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.f4374d);
    }

    public COUICheckBox(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mAsyncLock = new AtomicBoolean(false);
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.mStyle = attributeSet.getStyleAttribute();
        } else {
            this.mStyle = i10;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5199S, i10, 0);
        boolean z10 = obtainStyledAttributes.getBoolean(o.f5207T, false);
        int i11 = o.f5215U;
        int resourceId = obtainStyledAttributes.getResourceId(i11, -1);
        int integer = obtainStyledAttributes.getInteger(o.f5223V, 0);
        this.mPendingState = integer;
        if (COUI_DEBUG) {
            StringBuilder sb = new StringBuilder();
            sb.append("asyncLoad = ");
            sb.append(z10);
            sb.append(" drawable check = ");
            sb.append(resourceId == g.f4857j);
            sb.append(" thread check = ");
            sb.append(Looper.getMainLooper() == Looper.myLooper());
            Log.d(TAG, sb.toString());
        }
        if (z10 && resourceId == g.f4857j && Looper.getMainLooper() == Looper.myLooper()) {
            asyncLoadAnimatedVectorDrawable(new LoadDrawableRunnable(this, attributeSet, i10));
        } else {
            Drawable drawable = obtainStyledAttributes.getDrawable(i11);
            if (drawable != null) {
                setButtonDrawable(drawable);
                this.mPendingState = -1;
                setState(integer);
            }
        }
        obtainStyledAttributes.recycle();
        if (attributeSet != null) {
            int styleAttribute = attributeSet.getStyleAttribute();
            this.mStyle = styleAttribute;
            if (styleAttribute == 0) {
                this.mStyle = i10;
            }
        } else {
            this.mStyle = i10;
        }
        configStateEffectBackground();
        this.mDrawableTextMargin = getContext().getResources().getDimensionPixelSize(f.f4476C0);
    }

    public void setButtonDrawable(Drawable drawable) {
        if (drawable != null) {
            Drawable drawable2 = this.mButtonDrawable;
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.mButtonDrawable);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            drawable.setVisible(getVisibility() == 0, false);
            this.mButtonDrawable = drawable;
            drawable.setState(null);
            setMinHeight(this.mButtonDrawable.getIntrinsicHeight());
        }
        refreshDrawableState();
    }
}
