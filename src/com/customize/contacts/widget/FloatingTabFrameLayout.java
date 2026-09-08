package com.customize.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.oplus.dialer.R;

/* compiled from: FloatingTabFrameLayout.kt */
/* loaded from: classes3.dex */
public final class FloatingTabFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public View f22375a;

    /* renamed from: b, reason: collision with root package name */
    public View f22376b;

    /* renamed from: c, reason: collision with root package name */
    public COUIToolbar f22377c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FloatingTabFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f22375a = findViewById(R.id.dummy_toolbar_title);
        this.f22376b = findViewById(R.id.floating_tabview);
        this.f22377c = (COUIToolbar) findViewById(R.id.toolbar);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        View findViewById;
        super.onMeasure(i10, i11);
        COUIToolbar cOUIToolbar = this.f22377c;
        int i13 = 0;
        if (cOUIToolbar != null && (findViewById = cOUIToolbar.findViewById(R.id.coui_toolbar_more_view)) != null) {
            i12 = findViewById.getMeasuredWidth();
        } else {
            i12 = 0;
        }
        COUIToolbar cOUIToolbar2 = this.f22377c;
        if (cOUIToolbar2 != null) {
            i13 = cOUIToolbar2.getPaddingEnd();
        }
        int i14 = i12 + i13;
        View view = this.f22375a;
        if (view != null) {
            int size = View.MeasureSpec.getSize(i10) - (Math.max(view.getMeasuredWidth(), i14) * 2);
            View view2 = this.f22376b;
            if (view2 != null) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), i11);
            }
        }
    }

    public /* synthetic */ FloatingTabFrameLayout(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingTabFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.i.f(context, "context");
    }
}
