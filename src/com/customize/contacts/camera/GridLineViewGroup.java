package com.customize.contacts.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.coui.responsiveui.config.ResponsiveUIConfig;
import com.coui.responsiveui.config.UIConfig;
import com.oplus.dialer.R;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: GridLineViewGroup.kt */
/* loaded from: classes3.dex */
public final class GridLineViewGroup extends FrameLayout {

    /* renamed from: g, reason: collision with root package name */
    public static final a f20861g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public TextView f20862a;

    /* renamed from: b, reason: collision with root package name */
    public GridLineView f20863b;

    /* renamed from: c, reason: collision with root package name */
    public ViewPropertyAnimator f20864c;

    /* renamed from: d, reason: collision with root package name */
    public int f20865d;

    /* renamed from: e, reason: collision with root package name */
    public float f20866e;

    /* renamed from: f, reason: collision with root package name */
    public int f20867f;

    /* compiled from: GridLineViewGroup.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GridLineViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        i.f(context, "context");
    }

    public final void a(Context context) {
        UIConfig.Status status;
        int i10;
        boolean z10 = true;
        LayoutInflater.from(context).inflate(R.layout.view_grid_line, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.view_grid_line);
        i.d(findViewById, "null cannot be cast to non-null type com.customize.contacts.camera.GridLineView");
        this.f20863b = (GridLineView) findViewById;
        View findViewById2 = findViewById(R.id.tv_grid_line_tip);
        i.d(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.f20862a = (TextView) findViewById2;
        UIConfig value = ResponsiveUIConfig.getDefault(context).getUiConfig().getValue();
        if (value != null) {
            status = value.getStatus();
        } else {
            status = null;
        }
        if (status == UIConfig.Status.UNFOLD) {
            z10 = false;
        }
        if (z10) {
            i10 = 18;
        } else {
            i10 = 44;
        }
        if (z10 && CommonFeatureOption.k()) {
            this.f20867f = DisplayUtil.d(context) + getResources().getDimensionPixelSize(R.dimen.DP_16);
        }
        this.f20866e = DisplayUtil.a(context, i10);
        TextView textView = this.f20862a;
        i.c(textView);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        i.d(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).topMargin = (int) this.f20866e;
    }

    public final void b(int i10, boolean z10) {
        ViewPropertyAnimator viewPropertyAnimator;
        ViewPropertyAnimator viewPropertyAnimator2 = this.f20864c;
        if (viewPropertyAnimator2 != null) {
            viewPropertyAnimator2.cancel();
        }
        TextView textView = this.f20862a;
        if (textView != null) {
            viewPropertyAnimator = textView.animate();
        } else {
            viewPropertyAnimator = null;
        }
        this.f20864c = viewPropertyAnimator;
        TextView textView2 = this.f20862a;
        if (textView2 != null && viewPropertyAnimator != null) {
            if (z10) {
                viewPropertyAnimator.setDuration(300L);
            } else {
                viewPropertyAnimator.setDuration(0L);
            }
            if (i10 != 0) {
                if (i10 != 90) {
                    if (i10 != 180) {
                        if (i10 == 270) {
                            if (textView2.getRotation() < 0.0f && this.f20865d == 180) {
                                textView2.setRotation(180.0f);
                            }
                            viewPropertyAnimator.rotation(90.0f);
                            viewPropertyAnimator.translationX(((getWidth() - textView2.getHeight()) * 0.5f) - this.f20866e);
                            viewPropertyAnimator.translationY(((getHeight() - textView2.getHeight()) * 0.5f) - this.f20866e);
                            viewPropertyAnimator.start();
                        }
                    } else {
                        if (this.f20865d == 90) {
                            viewPropertyAnimator.rotation(-180.0f);
                        } else {
                            viewPropertyAnimator.rotation(180.0f);
                        }
                        viewPropertyAnimator.translationX(0.0f);
                        viewPropertyAnimator.translationY(((getHeight() - textView2.getHeight()) - (this.f20866e * 2.0f)) - this.f20867f);
                        viewPropertyAnimator.start();
                    }
                } else {
                    if (textView2.getRotation() > 0.0f && this.f20865d == 180) {
                        textView2.setRotation(-180.0f);
                    }
                    viewPropertyAnimator.rotation(-90.0f);
                    int i11 = -getWidth();
                    i.c(this.f20862a);
                    viewPropertyAnimator.translationX(((i11 + r1.getHeight()) * 0.5f) + this.f20866e);
                    int height = getHeight();
                    i.c(this.f20862a);
                    viewPropertyAnimator.translationY(((height - r1.getHeight()) * 0.5f) - this.f20866e);
                    viewPropertyAnimator.start();
                }
            } else {
                viewPropertyAnimator.rotation(0.0f);
                viewPropertyAnimator.translationX(0.0f);
                viewPropertyAnimator.translationY(0.0f);
                viewPropertyAnimator.start();
            }
        }
        this.f20865d = i10;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        b(this.f20865d, false);
    }

    public /* synthetic */ GridLineViewGroup(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridLineViewGroup(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        a(context);
    }
}
