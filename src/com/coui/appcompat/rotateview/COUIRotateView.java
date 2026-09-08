package com.coui.appcompat.rotateview;

import K.a;
import X8.c;
import X8.m;
import X8.o;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.AppCompatImageView;
import com.coui.appcompat.log.COUILog;

/* loaded from: classes.dex */
public class COUIRotateView extends AppCompatImageView {
    private static final int ROTATE_ALONG_X = 0;
    private static final int ROTATE_ALONG_Z = 1;
    private static final int ROTATION_ANGLE = 180;
    private static final String TAG = "COUIRotateView";
    private String mCloseContentDescription;
    private long mDuration;
    private String mExpandContentDescription;
    private Interpolator mInterpolator;
    private boolean mIsExpanded;
    private boolean mIsRotating;
    private OnRotateStateChangeListener mOnRotateStateChangeListener;
    private int mRotateType;
    private static final int[] STATE_CONTENT_EXPANDED = {c.f4419z0};
    private static final int[] STATE_CONTENT_COLLAPSED = {c.f4415x0};
    private static final int[] STATE_CONTENT_EXPANDED_ANIM = {c.f4342A0};
    private static final int[] STATE_CONTENT_COLLAPSED_ANIM = {c.f4417y0};

    /* loaded from: classes.dex */
    public interface OnRotateStateChangeListener {
        void onRotateStateChange(boolean z10);
    }

    public COUIRotateView(Context context) {
        this(context, null);
    }

    private void setState(boolean z10) {
        if (this.mIsExpanded) {
            if (z10) {
                setImageState(STATE_CONTENT_EXPANDED_ANIM, true);
                return;
            } else {
                setImageState(STATE_CONTENT_EXPANDED, true);
                return;
            }
        }
        if (z10) {
            setImageState(STATE_CONTENT_COLLAPSED_ANIM, true);
        } else {
            setImageState(STATE_CONTENT_COLLAPSED, true);
        }
    }

    private void updateContentDescription() {
        String str;
        CharSequence contentDescription = super.getContentDescription();
        if (!TextUtils.isEmpty(contentDescription) && !TextUtils.equals(contentDescription, this.mExpandContentDescription) && !TextUtils.equals(contentDescription, this.mCloseContentDescription)) {
            COUILog.e(TAG, "The user has set the content description, so the default description does not take effect.");
            return;
        }
        if (this.mIsExpanded) {
            str = this.mExpandContentDescription;
        } else {
            str = this.mCloseContentDescription;
        }
        setContentDescription(str);
    }

    public boolean isExpanded() {
        return this.mIsExpanded;
    }

    public void setExpanded(boolean z10) {
        setExpanded(z10, true);
    }

    public void setOnRotateStateChangeListener(OnRotateStateChangeListener onRotateStateChangeListener) {
        this.mOnRotateStateChangeListener = onRotateStateChangeListener;
    }

    @Deprecated
    public void startCollapseAnimation() {
        int i10 = this.mRotateType;
        if (i10 == 1) {
            animate().rotation(0.0f);
            this.mIsExpanded = false;
            updateContentDescription();
        } else if (i10 == 0) {
            setExpanded(false);
        }
    }

    @Deprecated
    public void startExpandAnimation() {
        int i10 = this.mRotateType;
        if (i10 == 1) {
            animate().rotation(180.0f);
            this.mIsExpanded = true;
            updateContentDescription();
        } else if (i10 == 0) {
            setExpanded(true);
        }
    }

    @Deprecated
    public void startRotateAnimation() {
        int i10 = this.mRotateType;
        if (i10 == 1) {
            if (!this.mIsExpanded) {
                startExpandAnimation();
                return;
            } else {
                startCollapseAnimation();
                return;
            }
        }
        if (i10 == 0) {
            setExpanded(!this.mIsExpanded);
        }
    }

    public COUIRotateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setExpanded(boolean z10, boolean z11) {
        if (this.mIsExpanded == z10) {
            return;
        }
        int i10 = this.mRotateType;
        if (i10 == 1) {
            if (this.mIsRotating) {
                return;
            }
            this.mIsExpanded = z10;
            if (z11) {
                animate().rotation(z10 ? 180.0f : 0.0f);
            } else {
                setRotation(z10 ? 180.0f : 0.0f);
            }
        } else if (i10 == 0) {
            this.mIsExpanded = z10;
            setState(z11);
        }
        OnRotateStateChangeListener onRotateStateChangeListener = this.mOnRotateStateChangeListener;
        if (onRotateStateChangeListener != null) {
            onRotateStateChangeListener.onRotateStateChange(this.mIsExpanded);
        }
        updateContentDescription();
    }

    public COUIRotateView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, 0);
        this.mInterpolator = a.a(0.133f, 0.0f, 0.3f, 1.0f);
        this.mDuration = 400L;
        this.mIsExpanded = false;
        this.mIsRotating = false;
        this.mOnRotateStateChangeListener = null;
        if (getContext() != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f5418t4);
            this.mRotateType = obtainStyledAttributes.getInteger(o.f5434v4, 0);
            this.mIsExpanded = obtainStyledAttributes.getBoolean(o.f5426u4, false);
            obtainStyledAttributes.recycle();
        }
        int i11 = this.mRotateType;
        if (i11 == 1) {
            animate().setDuration(this.mDuration).setInterpolator(this.mInterpolator).setListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.rotateview.COUIRotateView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    COUIRotateView.this.mIsRotating = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    COUIRotateView.this.mIsRotating = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    COUIRotateView.this.mIsRotating = true;
                }
            });
        } else if (i11 == 0) {
            setState(true);
        }
        this.mExpandContentDescription = getContext().getString(m.f5017p);
        this.mCloseContentDescription = getContext().getString(m.f5016o);
        updateContentDescription();
    }
}
