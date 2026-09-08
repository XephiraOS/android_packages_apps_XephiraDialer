package com.coui.appcompat.scrollbar;

import X8.e;
import X8.f;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Interpolator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import androidx.core.content.b;
import androidx.core.view.K;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import java.util.Locale;

/* loaded from: classes.dex */
public class COUIScrollBar {
    public static final long SCROLLER_FADE_TIMEOUT = 2000;
    private OnCOUIScrollListener mCOUIScrollListener;
    private final COUIScrollable mCOUIScrollable;
    private final float mDensity;
    private float mDownY;
    private boolean mIfShowWhenStateChange;
    private boolean mIsDragging;
    private boolean mIsRTL;
    private final ScrollabilityCache mScrollCache;
    private Drawable mThumbDrawable;
    private boolean mThumbDynamicHeight;
    private int mThumbMinHeight;
    private final Rect mThumbRect;
    private View mView;
    private static final int[] DRAWABLE_STATE_PRESSED = {16842919};
    private static final int[] DRAWABLE_STATE_DEFAULT = new int[0];

    /* loaded from: classes.dex */
    public static class Builder {
        private final COUIScrollable couiScrollable;
        private int height;
        private boolean isDynamicHeight = true;
        public int scrollbar_drawable_default_inset;
        public int scrollbar_drawable_pressed_inset;
        public int scroller_margin_bottom;
        public int scroller_margin_top;
        public int scroller_min_height;
        public int scroller_width;
        private Drawable thumbDrawable;
        private int thumbNormalColor;
        private int thumbPressedColor;
        private int width;

        public Builder(COUIScrollable cOUIScrollable) {
            this.couiScrollable = cOUIScrollable;
            this.width = cOUIScrollable.getCOUIScrollableView().getContext().getResources().getDimensionPixelSize(f.f4819w3);
            this.height = cOUIScrollable.getCOUIScrollableView().getContext().getResources().getDimensionPixelSize(f.f4812v3);
            this.scroller_margin_top = cOUIScrollable.getCOUIScrollableView().getContext().getResources().getDimensionPixelSize(f.f4805u3);
            this.scroller_margin_bottom = cOUIScrollable.getCOUIScrollableView().getContext().getResources().getDimensionPixelSize(f.f4798t3);
            this.scrollbar_drawable_default_inset = cOUIScrollable.getCOUIScrollableView().getContext().getResources().getDimensionPixelSize(f.f4783r3);
            this.scrollbar_drawable_pressed_inset = cOUIScrollable.getCOUIScrollableView().getContext().getResources().getDimensionPixelSize(f.f4791s3);
            Context context = cOUIScrollable.getCOUIScrollableView().getContext();
            int i10 = e.f4424A;
            this.thumbNormalColor = b.c(context, i10);
            this.thumbPressedColor = b.c(cOUIScrollable.getCOUIScrollableView().getContext(), i10);
        }

        private Drawable makeDefaultThumbDrawable() {
            StateListDrawable stateListDrawable = new StateListDrawable();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.thumbPressedColor);
            float f10 = this.width / 2.0f;
            gradientDrawable.setCornerRadius(f10);
            int[] iArr = COUIScrollBar.DRAWABLE_STATE_PRESSED;
            int i10 = this.scrollbar_drawable_pressed_inset;
            stateListDrawable.addState(iArr, new InsetDrawable((Drawable) gradientDrawable, i10, this.scroller_margin_top, i10, this.scroller_margin_bottom));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(this.thumbNormalColor);
            gradientDrawable2.setCornerRadius(f10);
            int[] iArr2 = COUIScrollBar.DRAWABLE_STATE_DEFAULT;
            int i11 = this.scrollbar_drawable_default_inset;
            stateListDrawable.addState(iArr2, new InsetDrawable((Drawable) gradientDrawable2, i11, this.scroller_margin_top, i11, this.scroller_margin_bottom));
            return stateListDrawable;
        }

        public COUIScrollBar build() {
            if (this.thumbDrawable == null) {
                this.thumbDrawable = makeDefaultThumbDrawable();
            }
            return new COUIScrollBar(this.couiScrollable, this.width, this.height, this.thumbDrawable, this.isDynamicHeight);
        }

        public Builder dynamicHeight(boolean z10) {
            this.isDynamicHeight = z10;
            return this;
        }

        public Builder height(int i10) {
            this.height = i10;
            return this;
        }

        public Builder marginBottom(int i10) {
            this.scroller_margin_bottom = i10;
            return this;
        }

        public Builder marginTop(int i10) {
            this.scroller_margin_top = i10;
            return this;
        }

        public Builder thumbDrawable(Drawable drawable) {
            this.thumbDrawable = drawable;
            return this;
        }

        public Builder width(int i10) {
            this.width = i10;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface COUIScrollable {
        COUIScrollBar getCOUIScrollDelegate();

        View getCOUIScrollableView();

        void setNewCOUIScrollDelegate(COUIScrollBar cOUIScrollBar);

        int superComputeVerticalScrollExtent();

        int superComputeVerticalScrollOffset();

        int superComputeVerticalScrollRange();

        void superOnTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface OnCOUIScrollListener {
        void onCOUIScrollEnd(View view, COUIScrollBar cOUIScrollBar);

        void onCOUIScrollStart(View view, COUIScrollBar cOUIScrollBar);

        void onCOUIScrolled(View view, COUIScrollBar cOUIScrollBar, int i10, int i11, float f10);
    }

    /* loaded from: classes.dex */
    public static class ScrollabilityCache implements Runnable {
        public static final int FADING = 2;
        public static final int OFF = 0;
        public static final int ON = 1;
        private static final float[] OPAQUE = {255.0f};
        private static final float[] TRANSPARENT = {0.0f};
        public long fadeStartTime;
        public View host;
        public float[] interpolatorValues;
        public final int RUNNABLE_RETRY_MIN_TIME = 50;
        public final Interpolator scrollBarInterpolator = new Interpolator(1, 2);
        public int state = 0;
        public final int scrollBarDefaultDelayBeforeFade = ViewConfiguration.getScrollDefaultDelay();
        public final int scrollBarFadeDuration = ViewConfiguration.getScrollBarFadeDuration();

        public ScrollabilityCache(ViewConfiguration viewConfiguration, View view) {
            this.host = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j10 = this.fadeStartTime;
            if (currentAnimationTimeMillis >= j10) {
                int i10 = (int) currentAnimationTimeMillis;
                Interpolator interpolator = this.scrollBarInterpolator;
                interpolator.setKeyFrame(0, i10, OPAQUE);
                interpolator.setKeyFrame(1, i10 + this.scrollBarFadeDuration, TRANSPARENT);
                this.state = 2;
                this.host.invalidate();
                return;
            }
            if (Math.abs(currentAnimationTimeMillis - j10) < 50 && (view = this.host) != null) {
                view.post(this);
            }
        }
    }

    private int dp2px(float f10) {
        return (int) ((this.mDensity * f10) + 0.5f);
    }

    private void findAndUploadDrawableColor(StateListDrawable stateListDrawable, int i10, int i11) {
        Drawable stateDrawable = stateListDrawable.getStateDrawable(i10);
        if (!(stateDrawable instanceof InsetDrawable)) {
            return;
        }
        Drawable drawable = ((InsetDrawable) stateDrawable).getDrawable();
        if (!(drawable instanceof GradientDrawable)) {
            return;
        }
        ((GradientDrawable) drawable).setColor(i11);
    }

    private boolean initialAwakenScrollBars() {
        return awakenScrollBars(this.mScrollCache.scrollBarDefaultDelayBeforeFade * 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void onDrawScrollBars(android.graphics.Canvas r9) {
        /*
            r8 = this;
            boolean r0 = r8.mIsDragging
            r1 = 255(0xff, float:3.57E-43)
            r2 = 0
            if (r0 == 0) goto Ld
            android.graphics.drawable.Drawable r0 = r8.mThumbDrawable
            r0.setAlpha(r1)
            goto L40
        Ld:
            com.coui.appcompat.scrollbar.COUIScrollBar$ScrollabilityCache r0 = r8.mScrollCache
            int r3 = r0.state
            if (r3 != 0) goto L14
            return
        L14:
            r4 = 2
            if (r3 != r4) goto L3b
            float[] r1 = r0.interpolatorValues
            r3 = 1
            if (r1 != 0) goto L20
            float[] r1 = new float[r3]
            r0.interpolatorValues = r1
        L20:
            float[] r1 = r0.interpolatorValues
            android.graphics.Interpolator r4 = r0.scrollBarInterpolator
            android.graphics.Interpolator$Result r4 = r4.timeToValues(r1)
            android.graphics.Interpolator$Result r5 = android.graphics.Interpolator.Result.FREEZE_END
            if (r4 != r5) goto L2f
            r0.state = r2
            goto L41
        L2f:
            android.graphics.drawable.Drawable r0 = r8.mThumbDrawable
            r1 = r1[r2]
            int r1 = java.lang.Math.round(r1)
            r0.setAlpha(r1)
            goto L41
        L3b:
            android.graphics.drawable.Drawable r0 = r8.mThumbDrawable
            r0.setAlpha(r1)
        L40:
            r3 = r2
        L41:
            boolean r0 = r8.updateThumbRect(r2)
            if (r0 == 0) goto L6b
            android.view.View r0 = r8.mView
            int r0 = r0.getScrollY()
            android.view.View r1 = r8.mView
            int r1 = r1.getScrollX()
            android.graphics.drawable.Drawable r2 = r8.mThumbDrawable
            android.graphics.Rect r4 = r8.mThumbRect
            int r5 = r4.left
            int r5 = r5 + r1
            int r6 = r4.top
            int r6 = r6 + r0
            int r7 = r4.right
            int r7 = r7 + r1
            int r1 = r4.bottom
            int r1 = r1 + r0
            r2.setBounds(r5, r6, r7, r1)
            android.graphics.drawable.Drawable r0 = r8.mThumbDrawable
            r0.draw(r9)
        L6b:
            if (r3 == 0) goto L72
            android.view.View r8 = r8.mView
            r8.invalidate()
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.scrollbar.COUIScrollBar.onDrawScrollBars(android.graphics.Canvas):void");
    }

    private boolean onInterceptTouchEventInternal(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            return onTouchEventInternal(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r0 != 3) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean onTouchEventInternal(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            float r1 = r8.getY()
            r2 = 3
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L37
            if (r0 == r3) goto L2a
            r8 = 2
            if (r0 == r8) goto L16
            if (r0 == r2) goto L2a
            goto L8e
        L16:
            boolean r8 = r7.mIsDragging
            if (r8 == 0) goto L8e
            float r8 = r7.mDownY
            float r8 = r1 - r8
            int r8 = java.lang.Math.round(r8)
            if (r8 == 0) goto L8e
            r7.updateThumbRect(r8)
            r7.mDownY = r1
            goto L8e
        L2a:
            boolean r8 = r7.mIsDragging
            if (r8 == 0) goto L8e
            r7.setPressedThumb(r4)
            r7.mIsDragging = r4
            r7.awakenScrollBars()
            goto L8e
        L37:
            com.coui.appcompat.scrollbar.COUIScrollBar$ScrollabilityCache r0 = r7.mScrollCache
            int r0 = r0.state
            if (r0 != 0) goto L40
            r7.mIsDragging = r4
            return r4
        L40:
            boolean r0 = r7.mIsDragging
            if (r0 != 0) goto L8e
            r7.updateThumbRect(r4)
            float r0 = r8.getX()
            android.graphics.Rect r5 = r7.mThumbRect
            int r6 = r5.top
            float r6 = (float) r6
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 < 0) goto L8e
            int r6 = r5.bottom
            float r6 = (float) r6
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 > 0) goto L8e
            int r6 = r5.left
            float r6 = (float) r6
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 < 0) goto L8e
            int r5 = r5.right
            float r5 = (float) r5
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 > 0) goto L8e
            r7.mIsDragging = r3
            r7.mDownY = r1
            com.coui.appcompat.scrollbar.COUIScrollBar$COUIScrollable r0 = r7.mCOUIScrollable
            r0.superOnTouchEvent(r8)
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r8)
            r8.setAction(r2)
            com.coui.appcompat.scrollbar.COUIScrollBar$COUIScrollable r0 = r7.mCOUIScrollable
            r0.superOnTouchEvent(r8)
            r8.recycle()
            r7.setPressedThumb(r3)
            r7.updateThumbRect(r4, r3)
            android.view.View r8 = r7.mView
            com.coui.appcompat.scrollbar.COUIScrollBar$ScrollabilityCache r0 = r7.mScrollCache
            r8.removeCallbacks(r0)
        L8e:
            boolean r8 = r7.mIsDragging
            if (r8 == 0) goto La1
            android.view.View r8 = r7.mView
            r8.invalidate()
            android.view.View r7 = r7.mView
            android.view.ViewParent r7 = r7.getParent()
            r7.requestDisallowInterceptTouchEvent(r3)
            return r3
        La1:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.scrollbar.COUIScrollBar.onTouchEventInternal(android.view.MotionEvent):boolean");
    }

    private void setPressedThumb(boolean z10) {
        int[] iArr;
        Drawable drawable = this.mThumbDrawable;
        if (z10) {
            iArr = DRAWABLE_STATE_PRESSED;
        } else {
            iArr = DRAWABLE_STATE_DEFAULT;
        }
        drawable.setState(iArr);
        this.mView.invalidate();
        OnCOUIScrollListener onCOUIScrollListener = this.mCOUIScrollListener;
        if (onCOUIScrollListener != null) {
            if (z10) {
                onCOUIScrollListener.onCOUIScrollStart(this.mView, this);
            } else {
                onCOUIScrollListener.onCOUIScrollEnd(this.mView, this);
            }
        }
    }

    private boolean updateThumbRect(int i10) {
        return updateThumbRect(i10, false);
    }

    public boolean awakenScrollBars() {
        return awakenScrollBars(SCROLLER_FADE_TIMEOUT);
    }

    public void dispatchDrawOver(Canvas canvas) {
        onDrawScrollBars(canvas);
    }

    public View getView() {
        return this.mView;
    }

    public void onAttachedToWindow() {
        if (this.mIfShowWhenStateChange) {
            initialAwakenScrollBars();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return onInterceptTouchEventInternal(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return onTouchEventInternal(motionEvent);
    }

    public void onVisibilityChanged(View view, int i10) {
        if (this.mIfShowWhenStateChange && i10 == 0 && K.N(this.mView)) {
            initialAwakenScrollBars();
        }
    }

    public void onWindowVisibilityChanged(int i10) {
        if (this.mIfShowWhenStateChange && i10 == 0) {
            initialAwakenScrollBars();
        }
    }

    public void refreshScrollBarColor() {
        Drawable drawable = this.mThumbDrawable;
        if (!(drawable instanceof StateListDrawable)) {
            return;
        }
        StateListDrawable stateListDrawable = (StateListDrawable) drawable;
        if (stateListDrawable.getStateCount() < 1) {
            return;
        }
        Context context = this.mView.getContext();
        int i10 = e.f4424A;
        findAndUploadDrawableColor(stateListDrawable, 0, b.c(context, i10));
        findAndUploadDrawableColor(stateListDrawable, 1, b.c(this.mView.getContext(), i10));
    }

    public void release() {
        this.mView = null;
    }

    public void setIfShowWhenStateChange(boolean z10) {
        this.mIfShowWhenStateChange = z10;
    }

    public void setOnCOUIScrollListener(OnCOUIScrollListener onCOUIScrollListener) {
        this.mCOUIScrollListener = onCOUIScrollListener;
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable != null) {
            this.mThumbDrawable = drawable;
            updateThumbRect(0);
            return;
        }
        throw new IllegalArgumentException("setThumbDrawable must NOT be NULL");
    }

    public void setThumbDynamicHeight(boolean z10) {
        if (this.mThumbDynamicHeight != z10) {
            this.mThumbDynamicHeight = z10;
            updateThumbRect(0);
        }
    }

    public void setThumbSize(int i10) {
        Rect rect = this.mThumbRect;
        rect.left = rect.right - i10;
        updateThumbRect(0);
    }

    private COUIScrollBar(COUIScrollable cOUIScrollable, int i10, int i11, Drawable drawable, boolean z10) {
        this.mIsDragging = false;
        this.mIsRTL = false;
        this.mIfShowWhenStateChange = true;
        View cOUIScrollableView = cOUIScrollable.getCOUIScrollableView();
        this.mView = cOUIScrollableView;
        cOUIScrollableView.setVerticalScrollBarEnabled(false);
        COUIDarkModeUtil.setForceDarkAllow(this.mView, false);
        Context context = this.mView.getContext();
        this.mIsRTL = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        this.mDensity = context.getResources().getDisplayMetrics().density;
        this.mThumbMinHeight = this.mView.getContext().getResources().getDimensionPixelSize(f.f4812v3);
        this.mThumbRect = new Rect(0, 0, i10, i11);
        this.mThumbDrawable = drawable;
        this.mCOUIScrollable = cOUIScrollable;
        this.mScrollCache = new ScrollabilityCache(ViewConfiguration.get(context), this.mView);
        this.mThumbDynamicHeight = z10;
    }

    private boolean updateThumbRect(int i10, boolean z10) {
        OnCOUIScrollListener onCOUIScrollListener;
        int width = this.mThumbRect.width();
        this.mThumbRect.right = this.mIsRTL ? width : this.mView.getWidth();
        Rect rect = this.mThumbRect;
        rect.left = this.mIsRTL ? 0 : rect.right - width;
        int superComputeVerticalScrollRange = this.mCOUIScrollable.superComputeVerticalScrollRange();
        if (superComputeVerticalScrollRange <= 0) {
            return false;
        }
        int superComputeVerticalScrollOffset = this.mCOUIScrollable.superComputeVerticalScrollOffset();
        int superComputeVerticalScrollExtent = this.mCOUIScrollable.superComputeVerticalScrollExtent();
        int i11 = superComputeVerticalScrollRange - superComputeVerticalScrollExtent;
        if (i11 <= 0) {
            return false;
        }
        float f10 = i11;
        float f11 = (superComputeVerticalScrollOffset * 1.0f) / f10;
        float f12 = (superComputeVerticalScrollExtent * 1.0f) / superComputeVerticalScrollRange;
        int height = this.mView.getHeight();
        int max = this.mThumbDynamicHeight ? Math.max(this.mThumbMinHeight, Math.round(f12 * height)) : this.mThumbMinHeight;
        Rect rect2 = this.mThumbRect;
        rect2.bottom = rect2.top + max;
        int i12 = height - max;
        float f13 = i12;
        int round = Math.round(f13 * f11);
        Rect rect3 = this.mThumbRect;
        rect3.offsetTo(rect3.left, round);
        if (i10 == 0) {
            if (!z10 || (onCOUIScrollListener = this.mCOUIScrollListener) == null) {
                return true;
            }
            onCOUIScrollListener.onCOUIScrolled(this.mView, this, 0, 0, f11);
            return true;
        }
        int i13 = round + i10;
        if (i13 <= i12) {
            i12 = i13 < 0 ? 0 : i13;
        }
        float f14 = (i12 * 1.0f) / f13;
        int round2 = Math.round(f10 * f14) - superComputeVerticalScrollOffset;
        View view = this.mView;
        if (view instanceof AbsListView) {
            ((AbsListView) view).smoothScrollBy(round2, 0);
        } else {
            view.scrollBy(0, round2);
        }
        OnCOUIScrollListener onCOUIScrollListener2 = this.mCOUIScrollListener;
        if (onCOUIScrollListener2 == null) {
            return true;
        }
        onCOUIScrollListener2.onCOUIScrolled(this.mView, this, i10, round2, f14);
        return true;
    }

    public boolean awakenScrollBars(long j10) {
        K.Z(this.mView);
        if (this.mIsDragging) {
            return false;
        }
        if (this.mScrollCache.state == 0) {
            j10 = Math.max(750L, j10);
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() + j10;
        ScrollabilityCache scrollabilityCache = this.mScrollCache;
        scrollabilityCache.fadeStartTime = currentAnimationTimeMillis;
        scrollabilityCache.state = 1;
        this.mView.removeCallbacks(scrollabilityCache);
        this.mView.postDelayed(this.mScrollCache, currentAnimationTimeMillis - AnimationUtils.currentAnimationTimeMillis());
        return false;
    }
}
