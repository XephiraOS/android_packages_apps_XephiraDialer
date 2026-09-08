package com.android.contacts.widget;

import H7.b;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.customize.contacts.widget.MultiChoiceListView;

/* loaded from: classes.dex */
public class AutoScrollListView extends MultiChoiceListView {

    /* renamed from: c, reason: collision with root package name */
    public int f18209c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f18210d;

    /* renamed from: e, reason: collision with root package name */
    public View f18211e;

    public AutoScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18209c = -1;
        this.f18211e = null;
    }

    public void b(int i10, boolean z10) {
        this.f18209c = i10;
        this.f18210d = z10;
        requestLayout();
    }

    @Override // com.coui.appcompat.list.COUIListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (Exception e10) {
            b.b("AutoScrollListView", "" + e10);
        }
        if (this.f18211e == null) {
            return;
        }
        View childAt = getChildAt(0);
        View childAt2 = getChildAt(getChildCount() - 1);
        int top = childAt.getTop();
        int left = childAt.getLeft();
        int bottom = childAt2.getBottom();
        this.f18211e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(bottom - top, 1073741824));
        this.f18211e.layout(left, top, this.f18211e.getMeasuredWidth() + left, bottom);
        this.f18211e.draw(canvas);
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        try {
            super.layoutChildren();
            int i10 = this.f18209c;
            if (i10 == -1) {
                return;
            }
            this.f18209c = -1;
            int firstVisiblePosition = getFirstVisiblePosition() + 1;
            int lastVisiblePosition = getLastVisiblePosition();
            if (i10 >= firstVisiblePosition && i10 <= lastVisiblePosition) {
                return;
            }
            int height = (int) (getHeight() * 0.33f);
            if (!this.f18210d) {
                setSelectionFromTop(i10, height);
                super.layoutChildren();
                return;
            }
            int i11 = (lastVisiblePosition - firstVisiblePosition) * 2;
            if (i10 < firstVisiblePosition) {
                int i12 = i11 + i10;
                if (i12 >= getCount()) {
                    i12 = getCount() - 1;
                }
                if (i12 < firstVisiblePosition) {
                    setSelection(i12);
                    super.layoutChildren();
                }
            } else {
                int i13 = i10 - i11;
                if (i13 < 0) {
                    i13 = 0;
                }
                if (i13 > lastVisiblePosition) {
                    setSelection(i13);
                    super.layoutChildren();
                }
            }
            smoothScrollToPositionFromTop(i10, height);
        } catch (Throwable th) {
            b.c("AutoScrollListView", "e = " + th);
        }
    }

    public void setAddView(View view) {
        this.f18211e = view;
    }
}
