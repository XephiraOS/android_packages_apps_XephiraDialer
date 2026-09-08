package com.coui.appcompat.poplist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.poplist.BasePopupMenuAnimationController;
import com.coui.appcompat.poplist.COUIPopupMenuRootView;

/* loaded from: classes.dex */
public class COUIPopupMenuRootView extends FrameLayout {
    private static final boolean DEBUG_DRAW;
    private static final String TAG = "COUIPopupMenuRootView";
    private BasePopupMenuAnimationController mController;
    private final Paint mDebugPaint;
    private BasePopupMenuAnimationController mDefaultScreenController;
    private PopupMenuDomain mDomain;
    private final Rect mDrawingRect;
    private int mMainMenuHeight;
    private ViewGroup mMainMenuRootView;
    private int mMainMenuWidth;
    private OnMenuStateChangedListener mMenuStateChangedListener;
    private boolean mNeedReDispatchDownForNextEvent;
    private final BasePopupMenuAnimationController.OnMenuStateChangedListener mOnSubMenuStateChangedListener;
    private Runnable mShowSubMenuAfterAnimationSkipped;
    private BasePopupMenuAnimationController mSmallScreenController;
    private View.OnClickListener mSubMenuHeaderClickListener;
    private int mSubMenuHeight;
    private ViewGroup mSubMenuRootView;
    private int mSubMenuWidth;

    /* renamed from: com.coui.appcompat.poplist.COUIPopupMenuRootView$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements BasePopupMenuAnimationController.OnMenuStateChangedListener {
        private final View.OnClickListener mCancelSubMenuEnterAndStartExit = new View.OnClickListener() { // from class: com.coui.appcompat.poplist.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                COUIPopupMenuRootView.AnonymousClass1.this.lambda$$0(view);
            }
        };
        private final View.OnClickListener mCancelSubMenuExitAndStartEnter = new View.OnClickListener() { // from class: com.coui.appcompat.poplist.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                COUIPopupMenuRootView.AnonymousClass1.this.lambda$$1(view);
            }
        };

        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$$0(View view) {
            COUIPopupMenuRootView.this.hideSubMenu(true);
            COUIPopupMenuRootView.this.mMainMenuRootView.setOnClickListener(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$$1(View view) {
            COUIPopupMenuRootView.this.showSubMenu();
        }

        @Override // com.coui.appcompat.poplist.BasePopupMenuAnimationController.OnMenuStateChangedListener
        public void onMainMenuEntered() {
            if (COUIPopupMenuRootView.this.mMenuStateChangedListener != null) {
                COUIPopupMenuRootView.this.mMenuStateChangedListener.onMainMenuEntered();
            }
        }

        @Override // com.coui.appcompat.poplist.BasePopupMenuAnimationController.OnMenuStateChangedListener
        public void onMainMenuStartToEnter() {
            if (COUIPopupMenuRootView.this.mMenuStateChangedListener != null) {
                COUIPopupMenuRootView.this.mMenuStateChangedListener.onMainMenuStartToEnter();
            }
        }

        @Override // com.coui.appcompat.poplist.BasePopupMenuAnimationController.OnMenuStateChangedListener
        public void onSubMenuAnimationCanceled() {
            if (COUIPopupMenuRootView.this.mMenuStateChangedListener != null) {
                COUIPopupMenuRootView.this.mMenuStateChangedListener.onSubMenuAnimationCanceled();
            }
        }

        @Override // com.coui.appcompat.poplist.BasePopupMenuAnimationController.OnMenuStateChangedListener
        public void onSubMenuEntered() {
            if (COUIPopupMenuRootView.this.mMenuStateChangedListener != null) {
                COUIPopupMenuRootView.this.mMenuStateChangedListener.onSubMenuEntered();
            }
            COUIPopupMenuRootView cOUIPopupMenuRootView = COUIPopupMenuRootView.this;
            cOUIPopupMenuRootView.allowListViewScroll(cOUIPopupMenuRootView.mSubMenuRootView, true);
            if (COUIPopupMenuRootView.this.mSubMenuRootView instanceof RoundFrameLayout) {
                ((RoundFrameLayout) COUIPopupMenuRootView.this.mSubMenuRootView).clearOverrideOutline();
            }
        }

        @Override // com.coui.appcompat.poplist.BasePopupMenuAnimationController.OnMenuStateChangedListener
        public void onSubMenuExited() {
            COUIPopupMenuRootView.this.mNeedReDispatchDownForNextEvent = false;
            if (COUIPopupMenuRootView.this.mSubMenuRootView instanceof RoundFrameLayout) {
                ((RoundFrameLayout) COUIPopupMenuRootView.this.mSubMenuRootView).setAllowDispatchEvent(true);
            }
            if (COUIPopupMenuRootView.this.mMenuStateChangedListener != null) {
                COUIPopupMenuRootView.this.mMenuStateChangedListener.onSubMenuExited();
            }
            COUIPopupMenuRootView cOUIPopupMenuRootView = COUIPopupMenuRootView.this;
            cOUIPopupMenuRootView.allowListViewScroll(cOUIPopupMenuRootView.mMainMenuRootView, true);
            COUIPopupMenuRootView.this.configSubMenuHeaderOnClick(null);
            COUIPopupMenuRootView.this.removeSubMenuView();
            if (COUIPopupMenuRootView.this.mShowSubMenuAfterAnimationSkipped != null) {
                Runnable runnable = COUIPopupMenuRootView.this.mShowSubMenuAfterAnimationSkipped;
                COUIPopupMenuRootView.this.mShowSubMenuAfterAnimationSkipped = null;
                runnable.run();
            }
        }

        @Override // com.coui.appcompat.poplist.BasePopupMenuAnimationController.OnMenuStateChangedListener
        public void onSubMenuStartToEnter() {
            COUIPopupMenuRootView.this.mNeedReDispatchDownForNextEvent = false;
            if (COUIPopupMenuRootView.this.mSubMenuRootView instanceof RoundFrameLayout) {
                ((RoundFrameLayout) COUIPopupMenuRootView.this.mSubMenuRootView).setAllowDispatchEvent(true);
            }
            if (COUIPopupMenuRootView.this.mMenuStateChangedListener != null) {
                COUIPopupMenuRootView.this.mMenuStateChangedListener.onSubMenuStartToEnter();
            }
            if (COUIPopupMenuRootView.this.mMainMenuRootView != null) {
                COUIPopupMenuRootView cOUIPopupMenuRootView = COUIPopupMenuRootView.this;
                cOUIPopupMenuRootView.allowListViewDispatchTouchEvent(cOUIPopupMenuRootView.mMainMenuRootView, false);
                COUIPopupMenuRootView cOUIPopupMenuRootView2 = COUIPopupMenuRootView.this;
                cOUIPopupMenuRootView2.allowListViewScroll(cOUIPopupMenuRootView2.mMainMenuRootView, false);
                COUIPopupMenuRootView cOUIPopupMenuRootView3 = COUIPopupMenuRootView.this;
                cOUIPopupMenuRootView3.allowListViewScroll(cOUIPopupMenuRootView3.mSubMenuRootView, false);
                COUIPopupMenuRootView.this.configSubMenuHeaderOnClick(this.mCancelSubMenuEnterAndStartExit);
                COUIPopupMenuRootView.this.mMainMenuRootView.setOnClickListener(this.mCancelSubMenuEnterAndStartExit);
            }
        }

        @Override // com.coui.appcompat.poplist.BasePopupMenuAnimationController.OnMenuStateChangedListener
        public void onSubMenuStartToExit() {
            COUIPopupMenuRootView.this.mNeedReDispatchDownForNextEvent = true;
            if (COUIPopupMenuRootView.this.mSubMenuRootView instanceof RoundFrameLayout) {
                ((RoundFrameLayout) COUIPopupMenuRootView.this.mSubMenuRootView).setAllowDispatchEvent(false);
            }
            if (COUIPopupMenuRootView.this.mMenuStateChangedListener != null) {
                COUIPopupMenuRootView.this.mMenuStateChangedListener.onSubMenuStartToExit();
            }
            if (COUIPopupMenuRootView.this.mMainMenuRootView != null) {
                COUIPopupMenuRootView.this.mMainMenuRootView.setFocusable(false);
                COUIPopupMenuRootView.this.mMainMenuRootView.setClickable(false);
                COUIPopupMenuRootView.this.mMainMenuRootView.setOnClickListener(null);
                COUIPopupMenuRootView cOUIPopupMenuRootView = COUIPopupMenuRootView.this;
                cOUIPopupMenuRootView.allowListViewDispatchTouchEvent(cOUIPopupMenuRootView.mMainMenuRootView, true);
                COUIPopupMenuRootView cOUIPopupMenuRootView2 = COUIPopupMenuRootView.this;
                cOUIPopupMenuRootView2.allowListViewScroll(cOUIPopupMenuRootView2.mSubMenuRootView, false);
                COUIPopupMenuRootView.this.configSubMenuHeaderOnClick(this.mCancelSubMenuExitAndStartEnter);
            }
        }
    }

    static {
        boolean z10;
        if (!COUILog.LOG_DEBUG && !COUILog.isLoggable(TAG, 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        DEBUG_DRAW = z10;
    }

    public COUIPopupMenuRootView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void allowListViewDispatchTouchEvent(ViewGroup viewGroup, boolean z10) {
        if (viewGroup != null) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof COUITouchListView) {
                ((COUITouchListView) childAt).allowDispatchEvent(z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void allowListViewScroll(ViewGroup viewGroup, boolean z10) {
        if (viewGroup != null) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof COUITouchListView) {
                ((COUITouchListView) childAt).allowScroll(z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configSubMenuHeaderOnClick(View.OnClickListener onClickListener) {
        this.mSubMenuHeaderClickListener = onClickListener;
    }

    public void addMainMenuView(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = this.mMainMenuRootView;
        if (viewGroup2 != null) {
            removeView(viewGroup2);
        }
        if (this.mSubMenuRootView != null) {
            hideSubMenu(false);
        }
        this.mMainMenuRootView = viewGroup;
        viewGroup.setAlpha(0.0f);
        addView(this.mMainMenuRootView, new ViewGroup.LayoutParams(-2, -2));
        allowListViewScroll(this.mMainMenuRootView, true);
        this.mController.setMainMenuView(this.mMainMenuRootView);
    }

    public void addSubMenuView(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = this.mSubMenuRootView;
        if (viewGroup2 != null) {
            removeView(viewGroup2);
        }
        this.mSubMenuRootView = viewGroup;
        viewGroup.setTranslationZ(1.0f);
        addView(this.mSubMenuRootView, new ViewGroup.LayoutParams(-2, -2));
        allowListViewScroll(this.mSubMenuRootView, true);
        this.mController.setSubMenuView(this.mSubMenuRootView);
        this.mController.setOnSubMenuStateChangedListener(this.mOnSubMenuStateChangedListener);
        showSubMenu();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mNeedReDispatchDownForNextEvent) {
            this.mNeedReDispatchDownForNextEvent = false;
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            super.dispatchTouchEvent(obtain);
            obtain.recycle();
            if (motionEvent.getActionMasked() != 0) {
                MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                obtain2.setAction(0);
                super.dispatchTouchEvent(obtain2);
                obtain2.recycle();
            } else {
                return super.dispatchTouchEvent(motionEvent);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void hideSubMenu(boolean z10) {
        if (z10) {
            View childAt = this.mSubMenuRootView.getChildAt(0);
            if (childAt instanceof COUITouchListView) {
                ((COUITouchListView) childAt).smoothScrollToPosition(0);
            }
            this.mController.startSubMenuExit();
            return;
        }
        this.mController.startSubMenuExit(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup viewGroup = this.mMainMenuRootView;
        if (viewGroup != null && this.mDomain != null) {
            viewGroup.setAlpha(0.0f);
            this.mMainMenuRootView.setVisibility(8);
            this.mController.startMainMenuEnter();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mController.stopAllAnimation();
        this.mMainMenuRootView.setFocusable(false);
        this.mMainMenuRootView.setClickable(false);
        this.mMainMenuRootView.setOnClickListener(null);
        allowListViewDispatchTouchEvent(this.mMainMenuRootView, true);
        allowListViewScroll(this.mSubMenuRootView, false);
        configSubMenuHeaderOnClick(null);
        removeSubMenuView();
        this.mShowSubMenuAfterAnimationSkipped = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (DEBUG_DRAW) {
            ViewGroup viewGroup = this.mMainMenuRootView;
            if (viewGroup != null) {
                viewGroup.setAlpha(0.5f);
            }
            ViewGroup viewGroup2 = this.mSubMenuRootView;
            if (viewGroup2 != null) {
                viewGroup2.setAlpha(0.5f);
            }
            this.mDebugPaint.setColor(Color.parseColor("#33FF0000"));
            canvas.save();
            this.mDomain.getAvailableRect(this.mDrawingRect);
            canvas.clipOutRect(this.mDrawingRect);
            canvas.drawRect(this.mDomain.mWindow, this.mDebugPaint);
            canvas.restore();
            this.mDebugPaint.setColor(Color.parseColor("#330000FF"));
            canvas.save();
            this.mDrawingRect.set(this.mDomain.mAnchor);
            canvas.clipOutRect(this.mDrawingRect);
            this.mDomain.getAnchorRealRect(this.mDrawingRect);
            canvas.drawRect(this.mDrawingRect, this.mDebugPaint);
            canvas.restore();
            this.mDebugPaint.setColor(Color.parseColor("#3300FF00"));
            this.mDrawingRect.set(this.mDomain.mAnchor);
            canvas.drawRect(this.mDrawingRect, this.mDebugPaint);
            this.mDebugPaint.setColor(Color.parseColor("#33FF00FF"));
            this.mDrawingRect.set(this.mDomain.mMainMenu);
            canvas.drawRect(this.mDrawingRect, this.mDebugPaint);
            this.mDebugPaint.setColor(Color.parseColor("#33FFFF00"));
            this.mDrawingRect.set(this.mDomain.mSubMenuAnchor);
            canvas.drawRect(this.mDrawingRect, this.mDebugPaint);
            this.mDebugPaint.setColor(Color.parseColor("#3300FFFF"));
            this.mDrawingRect.set(this.mDomain.mMainMenuRelocated);
            canvas.drawRect(this.mDrawingRect, this.mDebugPaint);
            this.mDebugPaint.setColor(Color.parseColor("#33000000"));
            this.mDrawingRect.set(this.mDomain.mSubMenu);
            canvas.drawRect(this.mDrawingRect, this.mDebugPaint);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        ViewGroup viewGroup = this.mMainMenuRootView;
        if (viewGroup != null) {
            Rect rect = this.mDomain.mMainMenu;
            viewGroup.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
        ViewGroup viewGroup2 = this.mSubMenuRootView;
        if (viewGroup2 != null) {
            Rect rect2 = this.mDomain.mSubMenu;
            viewGroup2.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        ViewGroup viewGroup = this.mMainMenuRootView;
        if (viewGroup != null) {
            viewGroup.measure(View.MeasureSpec.makeMeasureSpec(this.mMainMenuWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mMainMenuHeight, 1073741824));
        }
        ViewGroup viewGroup2 = this.mSubMenuRootView;
        if (viewGroup2 != null) {
            viewGroup2.measure(View.MeasureSpec.makeMeasureSpec(this.mSubMenuWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mSubMenuHeight, 1073741824));
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11));
    }

    public void performSubMenuHeader(View view) {
        View.OnClickListener onClickListener = this.mSubMenuHeaderClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void postSkipExitAnimationAndShowSubMenu(Runnable runnable) {
        this.mShowSubMenuAfterAnimationSkipped = runnable;
    }

    public void removeSubMenuView() {
        ViewGroup viewGroup = this.mSubMenuRootView;
        if (viewGroup != null) {
            removeView(viewGroup);
            this.mSubMenuRootView = null;
            this.mController.detach();
            this.mController.setSubMenuView(null);
            this.mNeedReDispatchDownForNextEvent = true;
        }
    }

    public void setDomain(PopupMenuDomain popupMenuDomain) {
        this.mDomain = popupMenuDomain;
        if (COUIResponsiveUtils.isSmallScreen(getContext(), this.mDomain.mWindow.width())) {
            if (this.mSmallScreenController == null) {
                this.mSmallScreenController = new SmallScreenAnimationController(getContext());
            }
            this.mController = this.mSmallScreenController;
        } else {
            if (this.mDefaultScreenController == null) {
                this.mDefaultScreenController = new DefaultScreenAnimationController();
            }
            this.mController = this.mDefaultScreenController;
        }
        this.mController.setDomain(this.mDomain);
        invalidate();
    }

    public void setMainMenuSize(int i10, int i11) {
        this.mMainMenuWidth = i10;
        this.mMainMenuHeight = i11;
    }

    public void setOnSubMenuStateChangedListener(OnMenuStateChangedListener onMenuStateChangedListener) {
        this.mMenuStateChangedListener = onMenuStateChangedListener;
    }

    public void setSubMenuSize(int i10, int i11) {
        this.mSubMenuWidth = i10;
        this.mSubMenuHeight = i11;
    }

    public void showSubMenu() {
        this.mController.startSubMenuEnter();
    }

    public COUIPopupMenuRootView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIPopupMenuRootView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public COUIPopupMenuRootView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mNeedReDispatchDownForNextEvent = false;
        this.mShowSubMenuAfterAnimationSkipped = null;
        this.mSubMenuHeaderClickListener = null;
        this.mOnSubMenuStateChangedListener = new AnonymousClass1();
        this.mMainMenuRootView = null;
        this.mSubMenuRootView = null;
        this.mMainMenuWidth = 0;
        this.mMainMenuHeight = 0;
        this.mSubMenuWidth = 0;
        this.mSubMenuHeight = 0;
        this.mDebugPaint = new Paint(1);
        this.mDrawingRect = new Rect();
        if (DEBUG_DRAW) {
            setWillNotDraw(false);
        }
        setFocusable(false);
    }

    /* loaded from: classes.dex */
    public interface OnMenuStateChangedListener {
        default void onMainMenuEntered() {
        }

        default void onMainMenuStartToEnter() {
        }

        default void onSubMenuAnimationCanceled() {
        }

        default void onSubMenuEntered() {
        }

        default void onSubMenuExited() {
        }

        default void onSubMenuStartToEnter() {
        }

        default void onSubMenuStartToExit() {
        }
    }
}
