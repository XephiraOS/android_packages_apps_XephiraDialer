package com.android.contacts.framework.baseui.behavior;

import A7.a;
import N0.f;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.android.contacts.framework.baseui.behavior.PrimaryTitleBehavior;
import com.android.contacts.framework.baseui.util.D;
import com.android.contacts.framework.baseui.widget.AppBarLayoutView;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.jvm.internal.i;
import x9.c;

/* compiled from: PrimaryTitleBehavior.kt */
/* loaded from: classes.dex */
public final class PrimaryTitleBehavior extends BaseTitleBehavior {

    /* renamed from: U, reason: collision with root package name */
    public final int f15718U;

    /* renamed from: V, reason: collision with root package name */
    public final D f15719V;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimaryTitleBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.f(context, "context");
        this.f15718U = context.getResources().getDimensionPixelSize(f.f1878d);
        this.f15719V = new D();
    }

    public static final void u0(LinearLayout it, AppBarLayout.LayoutParams layoutParams) {
        i.f(it, "$it");
        it.setLayoutParams(layoutParams);
    }

    public static final void v0(TextView it, LinearLayout.LayoutParams layoutParams) {
        i.f(it, "$it");
        it.setLayoutParams(layoutParams);
    }

    @Override // com.android.contacts.framework.baseui.behavior.BaseTitleBehavior
    public int M() {
        return ((C() + L()) + I()) - n();
    }

    @Override // com.android.contacts.framework.baseui.behavior.BaseTitleBehavior
    public void O(AppBarLayout appBarLayout, View target) {
        boolean z10;
        TextView textView;
        i.f(appBarLayout, "appBarLayout");
        i.f(target, "target");
        if (K() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        super.O(appBarLayout, target);
        if (z10) {
            COUIToolbar K10 = K();
            if (K10 != null) {
                textView = K10.getCOUITitleTextView();
            } else {
                textView = null;
            }
            if (textView != null) {
                textView.setAlpha(0.0f);
            }
        }
    }

    @Override // com.android.contacts.framework.baseui.behavior.BaseTitleBehavior
    public boolean P() {
        return super.P();
    }

    @Override // com.android.contacts.framework.baseui.behavior.BaseTitleBehavior
    public boolean R() {
        return true;
    }

    @Override // com.android.contacts.framework.baseui.behavior.BaseTitleBehavior
    public void Z(boolean z10) {
        TextView textView;
        X(z10);
        AppBarLayoutView appBarLayoutView = null;
        if (!z10) {
            COUIToolbar K10 = K();
            if (K10 != null) {
                textView = K10.getCOUITitleTextView();
            } else {
                textView = null;
            }
            if (textView != null) {
                textView.setAlpha(0.0f);
            }
        }
        AppBarLayout i10 = i();
        if (i10 instanceof AppBarLayoutView) {
            appBarLayoutView = (AppBarLayoutView) i10;
        }
        if (appBarLayoutView != null) {
            appBarLayoutView.setDrawingOrderEnabled(z10);
        }
    }

    @Override // com.android.contacts.framework.baseui.behavior.BaseTitleBehavior
    public void f() {
        t0(0.0f, 0.0f, 0.0f);
    }

    @Override // com.android.contacts.framework.baseui.behavior.BaseTitleBehavior
    public int h(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return -1;
        }
        View childAt = viewGroup.getChildAt(0);
        if (childAt != null) {
            childAt.getLocationInWindow(w());
        }
        return r0(D() - w()[1]);
    }

    public final float o0(float f10) {
        float z10 = f10 / z();
        float f11 = 1.0f;
        if (z10 <= 1.0f) {
            f11 = 0.0f;
            if (z10 >= 0.0f) {
                return z10;
            }
        }
        return f11;
    }

    @Override // com.android.contacts.framework.baseui.behavior.BaseTitleBehavior
    public void onListScroll() {
        int i10;
        View childAt;
        View view = null;
        e0(null);
        ViewGroup A10 = A();
        if (A10 != null && A10.getChildCount() > 0) {
            ViewGroup A11 = A();
            int i11 = 0;
            if (A11 != null) {
                i10 = A11.getChildCount();
            } else {
                i10 = 0;
            }
            while (true) {
                if (i11 >= i10) {
                    break;
                }
                ViewGroup A12 = A();
                if (A12 != null && (childAt = A12.getChildAt(i11)) != null && childAt.getVisibility() == 0) {
                    ViewGroup A13 = A();
                    if (A13 != null) {
                        view = A13.getChildAt(i11);
                    }
                    e0(view);
                } else {
                    i11++;
                }
            }
        }
        if (k() == null) {
            e0(A());
        }
        View k10 = k();
        if (k10 != null) {
            k10.getLocationInWindow(w());
        }
        float D10 = D() - w()[1];
        t0(o0(D10), p0(D10), q0(D10));
    }

    public final float p0(float f10) {
        float m10 = f10 / m();
        float f11 = 1.0f;
        if (m10 <= 1.0f) {
            f11 = 0.0f;
            if (m10 >= 0.0f) {
                return m10;
            }
        }
        return f11;
    }

    public final float q0(float f10) {
        float r10 = (f10 - r()) / r();
        float f11 = 1.0f;
        if (r10 <= 1.0f) {
            f11 = 0.0f;
            if (r10 >= 0.0f) {
                return r10;
            }
        }
        return f11;
    }

    public final int r0(int i10) {
        if (i10 < 0) {
            return 0;
        }
        return i10;
    }

    public final void s0(boolean z10) {
        int L10;
        if (z10) {
            L10 = 0;
        } else {
            L10 = L();
        }
        g0(((C() + L10) + I()) - n());
    }

    public final void t0(float f10, float f11, float f12) {
        int b10;
        LinearLayout.LayoutParams layoutParams;
        int b11;
        final AppBarLayout.LayoutParams layoutParams2;
        View j10;
        int i10;
        Y(f10);
        int i11 = 0;
        if (y() <= 0) {
            AppBarLayout i12 = i();
            if (i12 != null) {
                i10 = i12.getWidth();
            } else {
                i10 = 0;
            }
            f0(i10);
        }
        final LinearLayout.LayoutParams layoutParams3 = null;
        View view = null;
        if (u()) {
            if (j() == null) {
                AppBarLayout i13 = i();
                if (i13 != null) {
                    view = i13.findViewById(N0.i.f1927e);
                }
                d0(view);
                if (a.a() && (j10 = j()) != null) {
                    j10.setVisibility(8);
                }
            }
            View j11 = j();
            if (j11 != null) {
                LinearLayout.LayoutParams q10 = q();
                if (q10 != null) {
                    q10.setMarginStart((int) (p() * (1 - f12)));
                    q10.setMarginEnd(q10.getMarginStart());
                }
                j11.setAlpha(f11);
                if (q() != null) {
                    j11.setLayoutParams(q());
                    return;
                }
                return;
            }
            return;
        }
        View o10 = o();
        if (o10 != null) {
            LinearLayout.LayoutParams q11 = q();
            if (q11 != null) {
                q11.setMarginStart((int) (p() * (1 - f12)));
                q11.setMarginEnd(q11.getMarginStart());
            }
            o10.setAlpha(f11);
            if (q() != null) {
                o10.setLayoutParams(q());
            }
        }
        COUIToolbar K10 = K();
        if (K10 != null && P()) {
            this.f15719V.c(f10, K10.getCOUITitleTextView());
        }
        final LinearLayout l10 = l();
        if (l10 != null) {
            ViewGroup.LayoutParams layoutParams4 = l10.getLayoutParams();
            if (layoutParams4 instanceof AppBarLayout.LayoutParams) {
                layoutParams2 = (AppBarLayout.LayoutParams) layoutParams4;
            } else {
                layoutParams2 = null;
            }
            if (layoutParams2 != null) {
                if (P()) {
                    ((LinearLayout.LayoutParams) layoutParams2).topMargin = (int) (-(I() * f10));
                } else {
                    ((LinearLayout.LayoutParams) layoutParams2).topMargin = (int) (-(L() * f10));
                }
            } else {
                layoutParams2 = null;
            }
            if (l10.isInLayout()) {
                l10.post(new Runnable() { // from class: P0.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        PrimaryTitleBehavior.u0(l10, layoutParams2);
                    }
                });
            } else {
                l10.setLayoutParams(layoutParams2);
            }
        }
        final TextView F10 = F();
        if (F10 != null) {
            if (!t()) {
                b10 = c.b(H() + ((1 - f10) * (J() - H())));
                if (((int) F10.getPaint().getTextSize()) != b10) {
                    F10.getPaint().setTextSize(b10);
                }
                F10.setPaddingRelative(F10.getPaddingStart(), (int) (G() * f10), F10.getPaddingEnd(), F10.getPaddingBottom());
            } else {
                F10.getPaint().setTextSize(J());
                F10.setPaddingRelative(F10.getPaddingStart(), 0, F10.getPaddingEnd(), F10.getPaddingBottom());
            }
            ViewGroup.LayoutParams layoutParams5 = F10.getLayoutParams();
            if (layoutParams5 instanceof LinearLayout.LayoutParams) {
                layoutParams = (LinearLayout.LayoutParams) layoutParams5;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                if (t()) {
                    layoutParams.height = I();
                    layoutParams.width = -1;
                } else {
                    layoutParams.height = (int) (I() - ((I() - L()) * f10));
                    if (t()) {
                        i11 = (int) (s() * f10);
                    }
                    layoutParams.setMarginStart(i11);
                    b11 = c.b(x() + ((y() - x()) * (1 - f10)) + this.f15718U);
                    if (b11 > 0) {
                        layoutParams.width = b11;
                    }
                }
                layoutParams3 = layoutParams;
            }
            if (F10.isInLayout()) {
                F10.post(new Runnable() { // from class: P0.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        PrimaryTitleBehavior.v0(F10, layoutParams3);
                    }
                });
            } else {
                F10.setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout parent, AppBarLayout child, View directTargetChild, View target, int i10, int i11) {
        i.f(parent, "parent");
        i.f(child, "child");
        i.f(directTargetChild, "directTargetChild");
        i.f(target, "target");
        O(child, target);
        return false;
    }
}
