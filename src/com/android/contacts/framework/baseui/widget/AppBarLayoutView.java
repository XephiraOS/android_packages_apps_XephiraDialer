package com.android.contacts.framework.baseui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.appbar.AppBarLayout;

/* compiled from: AppBarLayoutView.kt */
/* loaded from: classes.dex */
public final class AppBarLayoutView extends AppBarLayout {

    /* renamed from: b, reason: collision with root package name */
    public static final a f15996b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public b f15997a;

    /* compiled from: AppBarLayoutView.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: AppBarLayoutView.kt */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBarLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.i.f(context, "context");
        c(context);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        return (i10 - i11) - 1;
    }

    public b getMeasureListener() {
        return this.f15997a;
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        b measureListener = getMeasureListener();
        if (measureListener != null) {
            measureListener.a();
        }
    }

    public final void setDrawingOrderEnabled(boolean z10) {
        super.setChildrenDrawingOrderEnabled(z10);
        H7.b.e("AppBarLayoutView", "setDrawingOrderEnabled " + z10);
    }

    public void setMeasureListener(b bVar) {
        this.f15997a = bVar;
    }

    private final void c(Context context) {
    }
}
