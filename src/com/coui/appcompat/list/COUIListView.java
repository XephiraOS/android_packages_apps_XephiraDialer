package com.coui.appcompat.list;

import X8.f;
import X8.o;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import com.coui.appcompat.scrollbar.COUIScrollBar;

/* loaded from: classes.dex */
public class COUIListView extends ListView implements COUIScrollBar.COUIScrollable {
    private static final float DEFAULT_INTERACTING_NESTED_SCROLL_ANGLE = 20.0f;
    private static final double DEGREE_TO_ARC_CONSTANT = 0.017453292519943295d;
    private static final int INVALID_SCROLL_CHOICE_POSITION = -2;
    private static final int SCROLLBARS_NONE = 0;
    private static final int SCROLLBARS_VERTICAL = 512;
    private static final long SCROLL_CHOICE_SCROLL_DELAY = 50;
    private static final String TAG = "COUIListView";
    private COUIScrollBar mCOUIScrollBar;
    private int mCheckItemId;
    private Runnable mDelayedScroll;
    private boolean mEnableDispatchEventWhileScrolling;
    private float mEventFilterAngle;
    private boolean mFlag;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mLastPosition;
    private int mLastSite;
    private int mLasterPosition;
    private int mLeftOffset;
    private boolean mMultiChoice;
    private int mRightOffset;
    private ScrollMultiChoiceListener mScrollMultiChoiceListener;
    private Drawable mScrollbarThumbVertical;
    private int mScrollbars;
    private int mScrollbarsSize;
    private int mStyle;
    private boolean mUpScroll;

    /* loaded from: classes.dex */
    public interface ScrollMultiChoiceListener {
        void onItemTouch(int i10, View view);
    }

    public COUIListView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alignBottomChild(int i10, int i11) {
        setSelectionFromTop(i10, (((getHeight() - getPaddingTop()) - getPaddingBottom()) - getChildAt(getChildCount() - 1).getHeight()) + i11);
    }

    private void createCOUIScrollDelegate(Context context) {
        this.mCOUIScrollBar = new COUIScrollBar.Builder(this).build();
    }

    private void initAttr(Context context, AttributeSet attributeSet, int i10) {
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.mStyle = attributeSet.getStyleAttribute();
        } else {
            this.mStyle = i10;
        }
        if (context != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f5178P2, i10, 0);
            this.mScrollbars = obtainStyledAttributes.getInteger(o.f5202S2, 0);
            this.mScrollbarsSize = obtainStyledAttributes.getDimensionPixelSize(o.f5186Q2, 0);
            this.mScrollbarThumbVertical = obtainStyledAttributes.getDrawable(o.f5194R2);
            obtainStyledAttributes.recycle();
        }
    }

    private boolean isInScrollRange(MotionEvent motionEvent) {
        int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int rawX = (int) motionEvent.getRawX();
        int[] iArr = new int[2];
        try {
            if (this.mCheckItemId > 0) {
                CheckBox checkBox = (CheckBox) getChildAt(pointToPosition - getFirstVisiblePosition()).findViewById(this.mCheckItemId);
                checkBox.getLocationOnScreen(iArr);
                int i10 = iArr[0];
                int i11 = i10 - this.mLeftOffset;
                int i12 = i10 + this.mRightOffset;
                if (checkBox.getVisibility() == 0 && rawX > i11 && rawX < i12 && pointToPosition > getHeaderViewsCount() - 1 && pointToPosition < getCount() - getFooterViewsCount()) {
                    this.mMultiChoice = true;
                    return true;
                }
                if (motionEvent.getActionMasked() == 0) {
                    this.mMultiChoice = false;
                }
                return false;
            }
            this.mMultiChoice = false;
            return false;
        } catch (Exception unused) {
            if (motionEvent.getActionMasked() == 0) {
                this.mMultiChoice = false;
            }
            return false;
        }
    }

    @Override // android.view.View
    public boolean awakenScrollBars() {
        COUIScrollBar cOUIScrollBar = this.mCOUIScrollBar;
        if (cOUIScrollBar != null) {
            return cOUIScrollBar.awakenScrollBars();
        }
        return super.awakenScrollBars();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        COUIScrollBar cOUIScrollBar = this.mCOUIScrollBar;
        if (cOUIScrollBar != null) {
            cOUIScrollBar.dispatchDrawOver(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mEnableDispatchEventWhileScrolling && (motionEvent.getAction() & 255) == 0) {
            super.onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.coui.appcompat.scrollbar.COUIScrollBar.COUIScrollable
    public COUIScrollBar getCOUIScrollDelegate() {
        return this.mCOUIScrollBar;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        COUIScrollBar cOUIScrollBar = this.mCOUIScrollBar;
        if (cOUIScrollBar != null) {
            cOUIScrollBar.onAttachedToWindow();
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        COUIScrollBar cOUIScrollBar = this.mCOUIScrollBar;
        if (cOUIScrollBar != null) {
            cOUIScrollBar.release();
            this.mCOUIScrollBar = null;
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        COUIScrollBar cOUIScrollBar = this.mCOUIScrollBar;
        if (cOUIScrollBar != null && cOUIScrollBar.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mInitialTouchX = (int) motionEvent.getX();
            this.mInitialTouchY = (int) motionEvent.getY();
            if (isInScrollRange(motionEvent)) {
                return true;
            }
        }
        if (action == 2) {
            float abs = Math.abs(motionEvent.getX() - this.mInitialTouchX);
            float abs2 = Math.abs(motionEvent.getY() - this.mInitialTouchY);
            if (abs != 0.0f && this.mEnableDispatchEventWhileScrolling && Math.abs(abs2 / abs) < Math.tan(this.mEventFilterAngle * DEGREE_TO_ARC_CONSTANT)) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r5 != 2) goto L45;
     */
    @Override // android.widget.AbsListView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            com.coui.appcompat.scrollbar.COUIScrollBar r0 = r7.mCOUIScrollBar
            r1 = 1
            if (r0 == 0) goto Lc
            boolean r0 = r0.onTouchEvent(r8)
            if (r0 == 0) goto Lc
            return r1
        Lc:
            boolean r0 = r7.mMultiChoice
            r2 = -1
            r3 = 0
            r4 = -2
            if (r0 == 0) goto Lad
            boolean r0 = r7.isInScrollRange(r8)
            if (r0 == 0) goto Lad
            float r0 = r8.getX()
            int r0 = (int) r0
            float r5 = r8.getY()
            int r5 = (int) r5
            int r0 = r7.pointToPosition(r0, r5)
            int r5 = r8.getActionMasked()
            if (r5 == 0) goto L3a
            if (r5 == r1) goto L34
            r6 = 2
            if (r5 == r6) goto L3c
            goto Lad
        L34:
            r7.mLastPosition = r4
            r7.mLasterPosition = r4
            goto Lad
        L3a:
            r7.mFlag = r1
        L3c:
            int r8 = r7.getCount()
            int r8 = r8 - r1
            if (r0 != r8) goto L46
            r7.alignBottomChild(r0, r3)
        L46:
            boolean r8 = r7.mFlag
            if (r8 == 0) goto Lac
            int r8 = r7.mLastPosition
            if (r8 == r0) goto Lac
            if (r0 == r2) goto Lac
            com.coui.appcompat.list.COUIListView$ScrollMultiChoiceListener r8 = r7.mScrollMultiChoiceListener
            if (r8 == 0) goto Lac
            java.lang.Runnable r8 = r7.mDelayedScroll
            r7.removeCallbacks(r8)
            com.coui.appcompat.list.COUIListView$ScrollMultiChoiceListener r8 = r7.mScrollMultiChoiceListener
            int r2 = r7.getFirstVisiblePosition()
            int r2 = r0 - r2
            android.view.View r2 = r7.getChildAt(r2)
            r8.onItemTouch(r0, r2)
            int r8 = r7.mLastPosition
            if (r8 == r4) goto L91
            int r8 = r7.getFirstVisiblePosition()
            r4 = 50
            if (r0 != r8) goto L7e
            if (r0 <= 0) goto L7e
            r7.mUpScroll = r1
            java.lang.Runnable r8 = r7.mDelayedScroll
            r7.postDelayed(r8, r4)
            goto L91
        L7e:
            int r8 = r7.getLastVisiblePosition()
            if (r0 != r8) goto L91
            int r8 = r7.getCount()
            if (r0 >= r8) goto L91
            r7.mUpScroll = r3
            java.lang.Runnable r8 = r7.mDelayedScroll
            r7.postDelayed(r8, r4)
        L91:
            int r8 = r7.mLasterPosition
            if (r8 != r0) goto La6
            com.coui.appcompat.list.COUIListView$ScrollMultiChoiceListener r8 = r7.mScrollMultiChoiceListener
            int r2 = r7.mLastPosition
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r2 - r3
            android.view.View r3 = r7.getChildAt(r3)
            r8.onItemTouch(r2, r3)
        La6:
            int r8 = r7.mLastPosition
            r7.mLasterPosition = r8
            r7.mLastPosition = r0
        Lac:
            return r1
        Lad:
            int r0 = r8.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == r1) goto Lb9
            r5 = 3
            if (r0 == r5) goto Lb9
            goto Lc5
        Lb9:
            r7.mUpScroll = r1
            r7.mLastPosition = r4
            r7.mLasterPosition = r4
            r7.mFlag = r3
            r7.mMultiChoice = r1
            r7.mLastSite = r2
        Lc5:
            boolean r7 = super.onTouchEvent(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.list.COUIListView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        COUIScrollBar cOUIScrollBar = this.mCOUIScrollBar;
        if (cOUIScrollBar != null) {
            cOUIScrollBar.onVisibilityChanged(view, i10);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        COUIScrollBar cOUIScrollBar = this.mCOUIScrollBar;
        if (cOUIScrollBar != null) {
            cOUIScrollBar.onWindowVisibilityChanged(i10);
        }
    }

    public void refresh() {
        String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        TypedArray typedArray = null;
        if ("attr".equals(resourceTypeName)) {
            typedArray = getContext().obtainStyledAttributes(null, o.f5178P2, this.mStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArray = getContext().obtainStyledAttributes(null, o.f5178P2, 0, this.mStyle);
        }
        if (typedArray != null) {
            this.mScrollbarThumbVertical = typedArray.getDrawable(o.f5194R2);
            typedArray.recycle();
        }
        if (this.mScrollbars == 512) {
            Drawable drawable = this.mScrollbarThumbVertical;
            if (drawable != null) {
                this.mCOUIScrollBar.setThumbDrawable(drawable);
            } else {
                this.mCOUIScrollBar.refreshScrollBarColor();
            }
        }
        invalidate();
    }

    public void setCheckItemId(int i10) {
        this.mCheckItemId = i10;
    }

    public void setDispatchEventWhileScrolling(boolean z10) {
        this.mEnableDispatchEventWhileScrolling = z10;
    }

    public void setEventFilterTangent(float f10) {
        this.mEventFilterAngle = f10;
    }

    @Override // com.coui.appcompat.scrollbar.COUIScrollBar.COUIScrollable
    public void setNewCOUIScrollDelegate(COUIScrollBar cOUIScrollBar) {
        if (cOUIScrollBar != null) {
            this.mCOUIScrollBar = cOUIScrollBar;
            cOUIScrollBar.onAttachedToWindow();
            return;
        }
        throw new IllegalArgumentException("setNewFastScrollDelegate must NOT be NULL.");
    }

    public void setScrollMultiChoiceListener(ScrollMultiChoiceListener scrollMultiChoiceListener) {
        this.mScrollMultiChoiceListener = scrollMultiChoiceListener;
    }

    @Override // com.coui.appcompat.scrollbar.COUIScrollBar.COUIScrollable
    public int superComputeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // com.coui.appcompat.scrollbar.COUIScrollBar.COUIScrollable
    public int superComputeVerticalScrollOffset() {
        return super.computeVerticalScrollOffset();
    }

    @Override // com.coui.appcompat.scrollbar.COUIScrollBar.COUIScrollable
    public int superComputeVerticalScrollRange() {
        return super.computeVerticalScrollRange();
    }

    @Override // com.coui.appcompat.scrollbar.COUIScrollBar.COUIScrollable
    public void superOnTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
    }

    public COUIListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public COUIListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mMultiChoice = true;
        this.mLastPosition = -2;
        this.mLasterPosition = -2;
        this.mFlag = false;
        this.mUpScroll = true;
        this.mLastSite = -1;
        this.mCheckItemId = -1;
        this.mScrollbars = 0;
        this.mEventFilterAngle = DEFAULT_INTERACTING_NESTED_SCROLL_ANGLE;
        this.mEnableDispatchEventWhileScrolling = false;
        this.mDelayedScroll = new Runnable() { // from class: com.coui.appcompat.list.COUIListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (COUIListView.this.mUpScroll) {
                    COUIListView.this.setSelectionFromTop(r0.getFirstVisiblePosition() - 1, -COUIListView.this.getPaddingTop());
                } else {
                    COUIListView cOUIListView = COUIListView.this;
                    cOUIListView.alignBottomChild(cOUIListView.getLastVisiblePosition() + 1, COUIListView.this.getPaddingBottom());
                }
            }
        };
        initAttr(context, attributeSet, i10);
        if (this.mScrollbars == 512) {
            createCOUIScrollDelegate(context);
            int i11 = this.mScrollbarsSize;
            if (i11 != 0) {
                this.mCOUIScrollBar.setThumbSize(i11);
            }
            Drawable drawable = this.mScrollbarThumbVertical;
            if (drawable != null) {
                this.mCOUIScrollBar.setThumbDrawable(drawable);
            }
        }
        this.mLeftOffset = getResources().getDimensionPixelOffset(f.f4774q2);
        this.mRightOffset = getResources().getDimensionPixelOffset(f.f4782r2);
    }

    @Override // com.coui.appcompat.scrollbar.COUIScrollBar.COUIScrollable
    public View getCOUIScrollableView() {
        return this;
    }
}
