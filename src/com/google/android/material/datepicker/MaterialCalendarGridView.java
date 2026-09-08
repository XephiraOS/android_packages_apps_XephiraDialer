package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.C0446a;
import androidx.core.view.K;
import com.coui.appcompat.uiutil.UIUtil;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class MaterialCalendarGridView extends GridView {

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f23156a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f23157b;

    /* loaded from: classes3.dex */
    public class a extends C0446a {
        public a() {
        }

        @Override // androidx.core.view.C0446a
        public void onInitializeAccessibilityNodeInfo(View view, J.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.j0(null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int d(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    public static boolean e(Long l10, Long l11, Long l12, Long l13) {
        if (l10 == null || l11 == null || l12 == null || l13 == null || l12.longValue() > l11.longValue() || l13.longValue() < l10.longValue()) {
            return true;
        }
        return false;
    }

    public final void a(int i10, Rect rect) {
        if (i10 == 33) {
            setSelection(getAdapter().m());
        } else if (i10 == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i10, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public n getAdapter2() {
        return (n) super.getAdapter();
    }

    public final View c(int i10) {
        return getChildAt(i10 - getFirstVisiblePosition());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int a10;
        int d10;
        int a11;
        int d11;
        int i10;
        int i11;
        int i12;
        int i13;
        int left;
        int left2;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        n adapter = getAdapter();
        DateSelector<?> dateSelector = adapter.f23268b;
        b bVar = adapter.f23270d;
        int max = Math.max(adapter.b(), getFirstVisiblePosition());
        int min = Math.min(adapter.m(), getLastVisiblePosition());
        Long item = adapter.getItem(max);
        Long item2 = adapter.getItem(min);
        Iterator<I.d<Long, Long>> it = dateSelector.o().iterator();
        while (it.hasNext()) {
            I.d<Long, Long> next = it.next();
            Long l10 = next.f1295a;
            if (l10 != null) {
                if (next.f1296b != null) {
                    Long l11 = l10;
                    long longValue = l11.longValue();
                    Long l12 = next.f1296b;
                    long longValue2 = l12.longValue();
                    if (!e(item, item2, l11, l12)) {
                        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
                        if (longValue < item.longValue()) {
                            if (adapter.h(max)) {
                                left2 = 0;
                            } else if (!isLayoutRtl) {
                                left2 = materialCalendarGridView.c(max - 1).getRight();
                            } else {
                                left2 = materialCalendarGridView.c(max - 1).getLeft();
                            }
                            d10 = left2;
                            a10 = max;
                        } else {
                            materialCalendarGridView.f23156a.setTimeInMillis(longValue);
                            a10 = adapter.a(materialCalendarGridView.f23156a.get(5));
                            d10 = d(materialCalendarGridView.c(a10));
                        }
                        if (longValue2 > item2.longValue()) {
                            if (adapter.i(min)) {
                                left = getWidth();
                            } else if (!isLayoutRtl) {
                                left = materialCalendarGridView.c(min).getRight();
                            } else {
                                left = materialCalendarGridView.c(min).getLeft();
                            }
                            d11 = left;
                            a11 = min;
                        } else {
                            materialCalendarGridView.f23156a.setTimeInMillis(longValue2);
                            a11 = adapter.a(materialCalendarGridView.f23156a.get(5));
                            d11 = d(materialCalendarGridView.c(a11));
                        }
                        int itemId = (int) adapter.getItemId(a10);
                        int i14 = max;
                        int i15 = min;
                        int itemId2 = (int) adapter.getItemId(a11);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (numColumns + getNumColumns()) - 1;
                            View c10 = materialCalendarGridView.c(numColumns);
                            int top = c10.getTop() + bVar.f23194a.c();
                            n nVar = adapter;
                            int bottom = c10.getBottom() - bVar.f23194a.b();
                            if (!isLayoutRtl) {
                                if (numColumns > a10) {
                                    i13 = 0;
                                } else {
                                    i13 = d10;
                                }
                                if (a11 > numColumns2) {
                                    i12 = getWidth();
                                } else {
                                    i12 = d11;
                                }
                            } else {
                                if (a11 > numColumns2) {
                                    i10 = 0;
                                } else {
                                    i10 = d11;
                                }
                                if (numColumns > a10) {
                                    i11 = getWidth();
                                } else {
                                    i11 = d10;
                                }
                                int i16 = i10;
                                i12 = i11;
                                i13 = i16;
                            }
                            canvas.drawRect(i13, top, i12, bottom, bVar.f23201h);
                            itemId++;
                            materialCalendarGridView = this;
                            it = it;
                            adapter = nVar;
                        }
                        materialCalendarGridView = this;
                        max = i14;
                        min = i15;
                    }
                }
            } else {
                materialCalendarGridView = this;
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        if (z10) {
            a(i10, rect);
        } else {
            super.onFocusChanged(false, i10, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (!super.onKeyDown(i10, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i10) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f23157b) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(UIUtil.CONSTANT_COLOR_MASK, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i10) {
        if (i10 < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i10);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f23156a = t.m();
        if (k.r1(getContext())) {
            setNextFocusLeftId(e4.g.f30864a);
            setNextFocusRightId(e4.g.f30870d);
        }
        this.f23157b = k.t1(getContext());
        K.j0(this, new a());
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof n) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), n.class.getCanonicalName()));
    }
}
