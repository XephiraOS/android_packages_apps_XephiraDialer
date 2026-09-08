package com.coui.appcompat.tips;

import a9.d;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.hardware.display.DisplayManager;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.view.Display;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.coui.appcompat.animation.COUILinearInterpolator;
import com.coui.appcompat.log.COUILog;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: COUIMarqueeTextView.kt */
/* loaded from: classes3.dex */
public final class COUIMarqueeTextView extends AppCompatTextView {
    public static final Companion Companion = new Companion(null);
    private static final float DEFAULT_DISPLAY_REFRESH = 60.0f;
    private static final long DEFAULT_SCROLL_DELAY_DURATION = 1000;
    private static final String TAG = "MarqueeView";
    private float fadingEdgeStrength;
    private boolean isActualMarqueeByMeasured;
    private boolean isAllCharactersLtR;
    private boolean isMarqueeEnable;
    private boolean mContinueScrollingEnable;
    private float mCurrentScrollLocation;
    private String mFinalDrawText;
    private String mIndividuallyAssembledText;
    private int mIndividuallyAssembledTextWidth;
    private int mInitStringWidth;
    private String mOriginText;
    private int mScrollRepeatCount;
    private ValueAnimator mScroller;
    private float mScrollerSpeed;
    private StartScrollRunnable mStartScrollRunnable;
    private final int mTextViewScrollDistance;

    /* compiled from: COUIMarqueeTextView.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* compiled from: COUIMarqueeTextView.kt */
    /* loaded from: classes3.dex */
    public final class StartScrollRunnable implements Runnable {
        public StartScrollRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            COUIMarqueeTextView.this.continueRoll();
        }
    }

    public COUIMarqueeTextView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void checkAllCharactersDirections() {
        String str = this.mOriginText;
        StaticLayout build = StaticLayout.Builder.obtain(str, 0, str.length(), getPaint(), getWidth()).build();
        this.isAllCharactersLtR = true;
        int length = this.mOriginText.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (build.isRtlCharAt(i10)) {
                this.isAllCharactersLtR = false;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void continueRoll$lambda$2$lambda$1(COUIMarqueeTextView this$0, ValueAnimator valueAnimator) {
        i.f(this$0, "this$0");
        this$0.mCurrentScrollLocation -= this$0.mScrollerSpeed;
        this$0.invalidate();
    }

    private final String generateTextDistance() {
        String str = " ";
        int ceil = (int) Math.ceil(this.mTextViewScrollDistance / getPaint().measureText(" "));
        if (this.mTextViewScrollDistance != 0) {
            str = "";
        }
        if (ceil >= 0) {
            int i10 = 0;
            while (true) {
                str = str + ' ';
                if (i10 == ceil) {
                    break;
                }
                i10++;
            }
        }
        return str;
    }

    private final float getMContentHeight() {
        return Math.abs(getPaint().getFontMetrics().bottom - getPaint().getFontMetrics().top) / 2;
    }

    private final void initSpeed() {
        Display display = ((DisplayManager) getContext().getSystemService(DisplayManager.class)).getDisplay(0);
        getResources().getDisplayMetrics();
        this.mScrollerSpeed = getResources().getDimensionPixelOffset(d.f6524O0) / display.getRefreshRate();
        this.mStartScrollRunnable = new StartScrollRunnable();
    }

    private final void initTextViewAttributes() {
        setHorizontalFadingEdgeEnabled(true);
        setFadingEdgeLength(getResources().getDimensionPixelSize(d.f6522N0));
        this.mCurrentScrollLocation = getResources().getDimensionPixelOffset(d.f6528Q0);
        getPaint().setColor(getCurrentTextColor());
    }

    private final void setActualMarqueeByMeasured(boolean z10) {
        float f10;
        if (z10 && this.isMarqueeEnable) {
            f10 = 1.0f;
        } else {
            f10 = 0.0f;
        }
        setFadingEdgeStrength(f10);
        this.isActualMarqueeByMeasured = z10;
    }

    private final void setContent() {
        this.mIndividuallyAssembledText = this.mOriginText;
        this.mIndividuallyAssembledText += generateTextDistance();
        int i10 = 0;
        this.mScrollRepeatCount = 0;
        this.mIndividuallyAssembledTextWidth = (int) getPaint().measureText(this.mIndividuallyAssembledText);
        int ceil = (int) Math.ceil((getMeasuredWidth() / this.mIndividuallyAssembledTextWidth) + 1.0d);
        this.mFinalDrawText = this.mIndividuallyAssembledText;
        if (ceil >= 0) {
            while (true) {
                this.mFinalDrawText += this.mIndividuallyAssembledText;
                if (i10 == ceil) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        this.mInitStringWidth = (int) getPaint().measureText(this.mFinalDrawText);
        checkAllCharactersDirections();
        super.setText(this.mFinalDrawText, TextView.BufferType.NORMAL);
    }

    private final void setFadingEdgeStrength(float f10) {
        this.fadingEdgeStrength = Math.signum(f10);
    }

    public final void continueRoll() {
        setMarqueeEnable(true);
        if (getPaint().measureText(getText().toString()) > getMeasuredWidth() && !this.mContinueScrollingEnable) {
            ValueAnimator valueAnimator = this.mScroller;
            if (valueAnimator != null) {
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                this.mScroller = null;
            }
            this.mContinueScrollingEnable = true;
            ValueAnimator ofInt = ValueAnimator.ofInt(Integer.MAX_VALUE);
            this.mScroller = ofInt;
            if (ofInt != null) {
                ofInt.setDuration(2147483647L);
                ofInt.setInterpolator(new COUILinearInterpolator());
                ofInt.setRepeatCount(-1);
                ofInt.setRepeatMode(1);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.tips.a
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        COUIMarqueeTextView.continueRoll$lambda$2$lambda$1(COUIMarqueeTextView.this, valueAnimator2);
                    }
                });
                ofInt.start();
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public float getLeftFadingEdgeStrength() {
        return this.fadingEdgeStrength;
    }

    @Override // android.widget.TextView, android.view.View
    public float getRightFadingEdgeStrength() {
        return this.fadingEdgeStrength;
    }

    public final boolean isMarqueeEnable() {
        return this.isMarqueeEnable;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.isMarqueeEnable) {
            stopRoll();
            removeCallbacks(this.mStartScrollRunnable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        i.f(canvas, "canvas");
        if (this.isMarqueeEnable && this.isActualMarqueeByMeasured) {
            float f10 = this.mCurrentScrollLocation;
            if (f10 < 0.0f) {
                int abs = (int) Math.abs(f10 / this.mIndividuallyAssembledTextWidth);
                int i10 = this.mScrollRepeatCount;
                if (abs >= i10) {
                    this.mScrollRepeatCount = i10 + 1;
                    if (this.mCurrentScrollLocation <= (-this.mInitStringWidth)) {
                        String substring = this.mFinalDrawText.substring(this.mIndividuallyAssembledText.length());
                        i.e(substring, "this as java.lang.String).substring(startIndex)");
                        this.mFinalDrawText = substring;
                        this.mCurrentScrollLocation += this.mIndividuallyAssembledTextWidth;
                        this.mScrollRepeatCount--;
                    }
                    String str = this.mFinalDrawText + this.mIndividuallyAssembledText;
                    this.mFinalDrawText = str;
                    super.setText(str, TextView.BufferType.NORMAL);
                }
            }
            if (getLayout() == null) {
                super.onDraw(canvas);
            }
            canvas.save();
            float f11 = this.mCurrentScrollLocation;
            if (!this.isAllCharactersLtR) {
                f11 = -f11;
            }
            canvas.translate(f11, 0.0f);
            getLayout().draw(canvas);
            canvas.restore();
            return;
        }
        COUILog.d(TAG, "onDraw: isMarqueeEnable=" + this.isMarqueeEnable + ", isActualMarqueeByMeasured=" + this.isActualMarqueeByMeasured);
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (getPaint().measureText(getText().toString()) > getMeasuredWidth()) {
            setActualMarqueeByMeasured(true);
            if (this.isMarqueeEnable) {
                setContent();
                return;
            }
            return;
        }
        setActualMarqueeByMeasured(false);
    }

    public final void setMarqueeEnable(boolean z10) {
        float f10;
        if (z10) {
            setSingleLine(true);
            setMaxLines(1);
            f10 = 1.0f;
        } else {
            setSingleLine(false);
            setMaxLines(Integer.MAX_VALUE);
            f10 = 0.0f;
        }
        setFadingEdgeStrength(f10);
        this.isMarqueeEnable = z10;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.mOriginText = String.valueOf(charSequence);
        super.setText(charSequence, bufferType);
    }

    @Override // android.widget.TextView
    public void setTextColor(int i10) {
        super.setTextColor(i10);
        getPaint().setColor(getCurrentTextColor());
    }

    public final void stopRoll() {
        this.mContinueScrollingEnable = false;
        this.mCurrentScrollLocation = getResources().getDimensionPixelOffset(d.f6528Q0);
        ValueAnimator valueAnimator = this.mScroller;
        if (valueAnimator != null && valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mScroller = null;
    }

    public COUIMarqueeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIMarqueeTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.c(context);
        this.mOriginText = "";
        this.mFinalDrawText = "";
        this.mScrollerSpeed = getResources().getDimensionPixelOffset(d.f6524O0);
        this.mCurrentScrollLocation = getResources().getDimensionPixelOffset(d.f6528Q0);
        this.mIndividuallyAssembledText = "";
        this.mTextViewScrollDistance = getResources().getDimensionPixelOffset(d.f6526P0);
        this.isAllCharactersLtR = true;
        initSpeed();
        initTextViewAttributes();
        if (this.isMarqueeEnable) {
            postDelayed(this.mStartScrollRunnable, DEFAULT_SCROLL_DELAY_DURATION);
        }
    }

    public /* synthetic */ COUIMarqueeTextView(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
