package com.customize.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.coui.appcompat.grid.COUIPercentWidthListView;
import com.oplus.dialer.R;

/* loaded from: classes3.dex */
public class MultiChoiceListView extends COUIPercentWidthListView {

    /* renamed from: a, reason: collision with root package name */
    public b f22392a;

    /* renamed from: b, reason: collision with root package name */
    public a f22393b;

    /* loaded from: classes3.dex */
    public interface a {
        boolean a();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    public MultiChoiceListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22393b = null;
        a();
    }

    private void a() {
        setCheckItemId(R.id.listview_scrollchoice_checkbox);
    }

    @Override // com.coui.appcompat.list.COUIListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        b bVar;
        if (motionEvent.getAction() == 0 && (bVar = this.f22392a) != null) {
            bVar.a();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.coui.appcompat.grid.COUIPercentWidthListView, android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        boolean z10;
        a aVar = this.f22393b;
        if (aVar != null && aVar.a()) {
            if (getRootView().getMeasuredWidth() != View.MeasureSpec.getSize(i10)) {
                z10 = true;
            } else {
                z10 = false;
            }
            setMeasureEnable(z10);
        }
        super.onMeasure(i10, i11);
    }

    public void setFragmentStateListener(a aVar) {
        this.f22393b = aVar;
    }

    public void setMultiChoiceListener(b bVar) {
        this.f22392a = bVar;
    }
}
