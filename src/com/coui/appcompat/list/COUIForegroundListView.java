package com.coui.appcompat.list;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.y;
import com.coui.appcompat.poplist.DefaultAdapter;
import com.coui.appcompat.poplist.PopupListItem;

/* loaded from: classes.dex */
public class COUIForegroundListView extends ListView {
    private int mAdvanceKey;
    private y mHoverListener;
    private MenuItem mHoveredMenuItem;
    private boolean mListSelectionHidden;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private RectF mRectF;
    private int mRetreatKey;

    public COUIForegroundListView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.mRadius = 0.0f;
        this.mRectF = null;
        initKeyValue(context);
    }

    private Path genPath() {
        Path path = this.mPath;
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float f10 = this.mRadius;
        path.addRoundRect(rectF, new float[]{f10, f10, f10, f10, f10, f10, f10, f10}, Path.Direction.CW);
        return this.mPath;
    }

    private void initKeyValue(Context context) {
        if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
            this.mAdvanceKey = 21;
            this.mRetreatKey = 22;
        } else {
            this.mAdvanceKey = 22;
            this.mRetreatKey = 21;
        }
    }

    public void clearSelection() {
        setSelection(-1);
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        if (!this.mListSelectionHidden && !super.isInTouchMode()) {
            return false;
        }
        return true;
    }

    public int lookForSelectablePosition(int i10, boolean z10) {
        int min;
        ListAdapter adapter = getAdapter();
        if (adapter != null && !isInTouchMode()) {
            int count = adapter.getCount();
            if (!getAdapter().areAllItemsEnabled()) {
                if (z10) {
                    min = Math.max(0, i10);
                    while (min < count && !adapter.isEnabled(min)) {
                        min++;
                    }
                } else {
                    min = Math.min(i10, count - 1);
                    while (min >= 0 && !adapter.isEnabled(min)) {
                        min--;
                    }
                }
                if (min < 0 || min >= count) {
                    return -1;
                }
                return min;
            }
            if (i10 >= 0 && i10 < count) {
                return i10;
            }
        }
        return -1;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mRadius > 0.0f) {
            canvas.clipPath(this.mPath);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        MenuAdapter menuAdapter;
        int i10;
        MenuItemImpl menuItemImpl;
        int pointToPosition;
        int i11;
        if (this.mHoverListener != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                i10 = headerViewListAdapter.getHeadersCount();
                menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
            } else {
                menuAdapter = (MenuAdapter) adapter;
                i10 = 0;
            }
            if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i11 = pointToPosition - i10) >= 0 && i11 < menuAdapter.getCount()) {
                menuItemImpl = menuAdapter.getItem(i11);
            } else {
                menuItemImpl = null;
            }
            MenuItem menuItem = this.mHoveredMenuItem;
            if (menuItem != menuItemImpl) {
                MenuBuilder adapterMenu = menuAdapter.getAdapterMenu();
                if (menuItem != null) {
                    this.mHoverListener.onItemHoverExit(adapterMenu, menuItem);
                }
                this.mHoveredMenuItem = menuItemImpl;
                if (menuItemImpl != null) {
                    this.mHoverListener.onItemHoverEnter(adapterMenu, menuItemImpl);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        View selectedView = getSelectedView();
        if (!(selectedView instanceof LinearLayout)) {
            return super.onKeyDown(i10, keyEvent);
        }
        LinearLayout linearLayout = (LinearLayout) selectedView;
        ListAdapter adapter = getAdapter();
        if (linearLayout != null && i10 == this.mAdvanceKey && (adapter instanceof DefaultAdapter)) {
            if (linearLayout.isEnabled() && ((PopupListItem) ((DefaultAdapter) adapter).getItem(getSelectedItemPosition())).hasSubArray()) {
                performItemClick(linearLayout, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (linearLayout != null && i10 == this.mRetreatKey) {
            setSelection(-1);
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        Path path = this.mPath;
        if (path == null) {
            this.mPath = new Path();
        } else {
            path.reset();
        }
        this.mRectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        genPath();
    }

    public void setHoverListener(y yVar) {
        this.mHoverListener = yVar;
    }

    public void setListSelectionHidden(boolean z10) {
        this.mListSelectionHidden = z10;
    }

    public void setRadius(float f10) {
        this.mRadius = f10;
    }

    public COUIForegroundListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.mRadius = 0.0f;
        this.mRectF = null;
        initKeyValue(context);
    }

    public COUIForegroundListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mPaint = new Paint();
        this.mRadius = 0.0f;
        this.mRectF = null;
        initKeyValue(context);
    }

    public COUIForegroundListView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mPaint = new Paint();
        this.mRadius = 0.0f;
        this.mRectF = null;
        initKeyValue(context);
    }
}
