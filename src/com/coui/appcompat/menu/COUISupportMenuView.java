package com.coui.appcompat.menu;

import X8.e;
import X8.f;
import X8.g;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.core.view.K;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class COUISupportMenuView extends View {
    private static final int MAX_ITEM_COUNTS = 10;
    private static final String TAG = "COUISupportMenuView";
    static final int VIEW_STATE_ENABLED = 16842910;
    static final int VIEW_STATE_PRESSED = 16842919;
    private COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction mCOUIViewTalkBalkInteraction;
    private Drawable mIconCover;
    private int mIconHeight;
    private int mIconWidth;
    private boolean mIsSelected;
    private int mItemCount;
    private List<COUISupportMenuItem> mItemList;
    private int mItemPadding;
    private int mLineMaxCount;
    private int mNormalColor;
    private int mPaddingBottom;
    private int mPaddingTop;
    private Paint mPaint;
    private Rect mSelectRect;
    private int mSelectedColor;
    private int mSelectedPosition;
    private int mSingleLineViewHeight;
    private int mTextMaxLength;
    private int mTextPaddingSide;
    private int mTextPaddingTop;
    private float mTextSize;
    private COUIViewExplorerByTouchHelper mTouchHelper;
    private int mViewPaddingBottom;
    private int mViewWidth;
    static final int[] STATE_ENABLED = {16842910};
    static final int[] STATE_UNENABLED = {-16842910};
    static final int[] STATE_PRESSED = {16842919, 16842910};
    static final int[] STATE_NORMAL = {-16842919, 16842910};

    public COUISupportMenuView(Context context) {
        this(context, null);
    }

    private void clearState() {
        Iterator<COUISupportMenuItem> it = this.mItemList.iterator();
        while (it.hasNext()) {
            Drawable icon = it.next().getIcon();
            if (icon != null && icon.isStateful()) {
                icon.setState(STATE_NORMAL);
            }
        }
        this.mIsSelected = false;
        invalidate();
    }

    private String getDisplayText(String str, Paint paint, int i10) {
        int breakText = paint.breakText(str, true, i10, null);
        if (breakText != str.length()) {
            return str.substring(0, breakText - 1) + "...";
        }
        return str;
    }

    private void getRect(int i10, Rect rect) {
        int i11 = this.mItemPadding;
        int i12 = (i11 / 2) + ((i11 + this.mIconWidth) * (i10 % this.mLineMaxCount));
        if (isLayoutRtl()) {
            int width = getWidth();
            int i13 = this.mIconWidth;
            int i14 = this.mItemPadding;
            i12 = width - (((i14 / 2) + i13) + ((i14 + i13) * (i10 % this.mLineMaxCount)));
        }
        int i15 = this.mPaddingTop;
        int i16 = this.mLineMaxCount;
        int i17 = i10 / i16;
        if (i10 >= i16) {
            i15 += this.mSingleLineViewHeight;
        }
        rect.set(i12, i15, this.mIconWidth + i12, this.mIconHeight + i15);
    }

    private void initStateListDrawable(int i10) {
        Drawable icon = this.mItemList.get(i10).getIcon();
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] iArr = STATE_PRESSED;
        icon.setState(iArr);
        stateListDrawable.addState(iArr, icon.getCurrent());
        int[] iArr2 = STATE_ENABLED;
        icon.setState(iArr2);
        stateListDrawable.addState(iArr2, icon.getCurrent());
        int[] iArr3 = STATE_UNENABLED;
        icon.setState(iArr3);
        stateListDrawable.addState(iArr3, icon.getCurrent());
        int[] iArr4 = STATE_NORMAL;
        icon.setState(iArr4);
        stateListDrawable.addState(iArr4, icon.getCurrent());
        this.mItemList.get(i10).setIcon(stateListDrawable);
        this.mItemList.get(i10).getIcon().setCallback(this);
        clearState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int selectedIndex(float f10, float f11) {
        int i10;
        int i11 = this.mItemCount;
        if (i11 < 1) {
            return -1;
        }
        if (i11 <= this.mLineMaxCount) {
            if (isLayoutRtl()) {
                f10 = getWidth() - f10;
            }
            i10 = (int) (f10 / (getWidth() / this.mItemCount));
        } else {
            if (isLayoutRtl()) {
                f10 = getWidth() - f10;
            }
            int width = getWidth();
            int i12 = this.mLineMaxCount;
            i10 = (int) (f10 / (width / i12));
            if (f11 > this.mSingleLineViewHeight) {
                i10 += i12;
            }
        }
        if (i10 >= this.mItemCount) {
            return -1;
        }
        return i10;
    }

    public void clearAccessibilityFocus() {
        COUIViewExplorerByTouchHelper cOUIViewExplorerByTouchHelper = this.mTouchHelper;
        if (cOUIViewExplorerByTouchHelper != null) {
            cOUIViewExplorerByTouchHelper.clearFocusedVirtualView();
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        COUIViewExplorerByTouchHelper cOUIViewExplorerByTouchHelper = this.mTouchHelper;
        if (cOUIViewExplorerByTouchHelper != null && cOUIViewExplorerByTouchHelper.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float y10 = motionEvent.getY();
        if (motionEvent.getPointerCount() == 1 && y10 >= 0.0f) {
            if (motionEvent.getAction() == 0) {
                this.mSelectedPosition = selectedIndex(motionEvent.getX(), motionEvent.getY());
            }
        } else {
            clearState();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        Drawable icon;
        int i10 = this.mSelectedPosition;
        if (i10 >= 0 && i10 < this.mItemCount && (icon = this.mItemList.get(i10).getIcon()) != null && icon.isStateful()) {
            icon.setState(getDrawableState());
        }
        super.drawableStateChanged();
    }

    public boolean isLayoutRtl() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i10 = this.mItemCount;
        if (i10 < 1) {
            return;
        }
        if (i10 <= this.mLineMaxCount) {
            int width = getWidth();
            int i11 = this.mIconWidth;
            int i12 = this.mItemCount;
            this.mItemPadding = (width - (i11 * i12)) / i12;
        } else {
            int width2 = getWidth();
            int i13 = this.mIconWidth;
            int i14 = this.mLineMaxCount;
            this.mItemPadding = (width2 - (i13 * i14)) / i14;
        }
        this.mTextMaxLength = (this.mItemPadding + this.mIconWidth) - (this.mTextPaddingSide * 2);
        for (int i15 = 0; i15 < this.mItemCount; i15++) {
            getRect(i15, this.mSelectRect);
            COUISupportMenuItem cOUISupportMenuItem = this.mItemList.get(i15);
            cOUISupportMenuItem.getIcon().setBounds(this.mSelectRect);
            cOUISupportMenuItem.getIcon().draw(canvas);
            this.mPaint.setColor(this.mNormalColor);
            int i16 = -this.mPaint.getFontMetricsInt().top;
            Rect rect = this.mSelectRect;
            canvas.drawText(getDisplayText(cOUISupportMenuItem.getText(), this.mPaint, this.mTextMaxLength), rect.left + (this.mIconWidth / 2), rect.bottom + this.mTextPaddingTop + i16, this.mPaint);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        Paint.FontMetricsInt fontMetricsInt = this.mPaint.getFontMetricsInt();
        int i12 = this.mPaddingTop + this.mIconHeight + this.mTextPaddingTop + (fontMetricsInt.bottom - fontMetricsInt.top) + this.mPaddingBottom;
        this.mSingleLineViewHeight = i12;
        if (this.mItemCount > this.mLineMaxCount) {
            i12 *= 2;
        }
        setMeasuredDimension(this.mViewWidth, i12);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 3) {
                    return true;
                }
                clearState();
                return false;
            }
            int i10 = this.mSelectedPosition;
            if (i10 >= 0) {
                this.mItemList.get(i10).getOnItemClickListener().onCOUIMenuItemClick(this.mSelectedPosition);
            }
            clearState();
            return false;
        }
        this.mIsSelected = true;
        invalidate();
        return true;
    }

    public void setColorSupportMenuItem(List<COUISupportMenuItem> list) {
        this.mItemList = list;
        int size = list.size();
        if (size <= 0) {
            return;
        }
        if (size > 10) {
            this.mItemCount = 10;
            this.mItemList = this.mItemList.subList(0, 10);
        } else if (size == 7) {
            this.mItemCount = 6;
            this.mItemList = this.mItemList.subList(0, 6);
        } else if (size == 9) {
            this.mItemCount = 8;
            this.mItemList = this.mItemList.subList(0, 8);
        } else {
            this.mItemCount = size;
        }
        if (size > 5) {
            this.mLineMaxCount = size / 2;
        } else {
            this.mLineMaxCount = 5;
        }
        for (int i10 = 0; i10 < this.mItemCount; i10++) {
            initStateListDrawable(i10);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        super.verifyDrawable(drawable);
        return true;
    }

    public COUISupportMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUISupportMenuView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mLineMaxCount = 5;
        this.mItemList = new ArrayList();
        this.mSelectRect = new Rect();
        this.mIsSelected = false;
        this.mSelectedPosition = -1;
        this.mTextSize = 30.0f;
        this.mItemCount = 0;
        this.mCOUIViewTalkBalkInteraction = new COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction() { // from class: com.coui.appcompat.menu.COUISupportMenuView.1
            private int mVirtualViewAt = -1;

            @Override // com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction
            public CharSequence getClassName() {
                return Button.class.getName();
            }

            @Override // com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction
            public int getCurrentPosition() {
                return COUISupportMenuView.this.mSelectedPosition;
            }

            @Override // com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction
            public int getDisablePosition() {
                return -1;
            }

            @Override // com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction
            public void getItemBounds(int i11, Rect rect) {
                Paint.FontMetricsInt fontMetricsInt = COUISupportMenuView.this.mPaint.getFontMetricsInt();
                int i12 = (COUISupportMenuView.this.mItemPadding / 2) + ((COUISupportMenuView.this.mItemPadding + COUISupportMenuView.this.mIconWidth) * (i11 % COUISupportMenuView.this.mLineMaxCount));
                if (COUISupportMenuView.this.isLayoutRtl()) {
                    i12 = COUISupportMenuView.this.getWidth() - ((COUISupportMenuView.this.mIconWidth + (COUISupportMenuView.this.mItemPadding / 2)) + ((COUISupportMenuView.this.mItemPadding + COUISupportMenuView.this.mIconWidth) * (i11 % COUISupportMenuView.this.mLineMaxCount)));
                }
                int i13 = COUISupportMenuView.this.mIconWidth + i12;
                int unused = COUISupportMenuView.this.mPaddingTop;
                int i14 = i11 / COUISupportMenuView.this.mLineMaxCount;
                int i15 = i11 < COUISupportMenuView.this.mLineMaxCount ? COUISupportMenuView.this.mPaddingTop : COUISupportMenuView.this.mSingleLineViewHeight;
                rect.set(i12, i15, i13, (((COUISupportMenuView.this.mIconHeight + i15) + COUISupportMenuView.this.mTextPaddingTop) + fontMetricsInt.bottom) - fontMetricsInt.top);
            }

            @Override // com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction
            public int getItemCounts() {
                return COUISupportMenuView.this.mItemCount;
            }

            @Override // com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction
            public CharSequence getItemDescription(int i11) {
                String text = ((COUISupportMenuItem) COUISupportMenuView.this.mItemList.get(i11)).getText();
                if (text != null) {
                    return text;
                }
                return getClass().getSimpleName();
            }

            @Override // com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction
            public int getVirtualViewAt(float f10, float f11) {
                int selectedIndex = COUISupportMenuView.this.selectedIndex((int) f10, (int) f11);
                this.mVirtualViewAt = selectedIndex;
                return selectedIndex;
            }

            @Override // com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction
            public void performAction(int i11, int i12, boolean z10) {
                if (((COUISupportMenuItem) COUISupportMenuView.this.mItemList.get(i11)).getOnItemClickListener() != null) {
                    ((COUISupportMenuItem) COUISupportMenuView.this.mItemList.get(i11)).getOnItemClickListener().onCOUIMenuItemClick(i11);
                }
                COUISupportMenuView.this.mTouchHelper.sendEventForVirtualView(i11, 1);
            }
        };
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setAntiAlias(true);
        this.mViewWidth = (int) getResources().getDimension(f.f4620W4);
        this.mPaddingTop = (int) getResources().getDimension(f.f4585R4);
        this.mPaddingBottom = (int) getResources().getDimension(f.f4578Q4);
        this.mViewPaddingBottom = (int) getResources().getDimension(f.f4613V4);
        this.mIconHeight = (int) getResources().getDimension(f.f4557N4);
        this.mIconWidth = (int) getResources().getDimension(f.f4571P4);
        this.mTextPaddingTop = (int) getResources().getDimension(f.f4606U4);
        this.mTextMaxLength = (int) getResources().getDimension(f.f4592S4);
        this.mTextPaddingSide = (int) getResources().getDimension(f.f4599T4);
        this.mTextSize = (int) getResources().getDimension(f.f4564O4);
        this.mSelectedColor = getResources().getColor(e.f4429F);
        this.mNormalColor = getResources().getColor(e.f4428E);
        this.mIconCover = getResources().getDrawable(g.f4871x);
        float suitableFontSize = (int) COUIChangeTextUtil.getSuitableFontSize(this.mTextSize, getResources().getConfiguration().fontScale, 4);
        this.mTextSize = suitableFontSize;
        this.mPaint.setTextSize(suitableFontSize);
        setClickable(true);
        COUIViewExplorerByTouchHelper cOUIViewExplorerByTouchHelper = new COUIViewExplorerByTouchHelper(this);
        this.mTouchHelper = cOUIViewExplorerByTouchHelper;
        cOUIViewExplorerByTouchHelper.setCOUIViewTalkBalkInteraction(this.mCOUIViewTalkBalkInteraction);
        K.j0(this, this.mTouchHelper);
        K.t0(this, 1);
    }
}
