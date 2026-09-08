package com.oplus.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.coui.appcompat.list.COUIListView;

/* loaded from: classes4.dex */
public class MultiChoiceListview extends COUIListView {

    /* renamed from: a, reason: collision with root package name */
    public a f29283a;

    /* loaded from: classes4.dex */
    public interface a {
        void a();
    }

    public MultiChoiceListview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.coui.appcompat.list.COUIListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (motionEvent.getAction() == 0 && (aVar = this.f29283a) != null) {
            aVar.a();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setMultiChoiceListener(a aVar) {
        this.f29283a = aVar;
    }
}
