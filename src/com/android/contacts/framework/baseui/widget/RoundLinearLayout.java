package com.android.contacts.framework.baseui.widget;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;

/* compiled from: RoundLinearLayout.kt */
/* loaded from: classes.dex */
public final class RoundLinearLayout extends LinearLayout {

    /* compiled from: RoundLinearLayout.kt */
    /* loaded from: classes.dex */
    public static final class a extends ViewOutlineProvider {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16107b;

        public a(int i10) {
            this.f16107b = i10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.i.f(view, "view");
            kotlin.jvm.internal.i.f(outline, "outline");
            outline.setRoundRect(0, 0, RoundLinearLayout.this.getMeasuredWidth(), RoundLinearLayout.this.getMeasuredHeight(), this.f16107b);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(N0.f.f1866B);
        setClipToOutline(true);
        setOutlineProvider(new a(dimensionPixelOffset));
    }

    public /* synthetic */ RoundLinearLayout(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.i.f(context, "context");
    }
}
