package y4;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* compiled from: RightSheetDelegate.java */
/* loaded from: classes3.dex */
public final class b extends d {

    /* renamed from: a, reason: collision with root package name */
    public final SideSheetBehavior<? extends View> f38137a;

    public b(SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f38137a = sideSheetBehavior;
    }

    @Override // y4.d
    public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // y4.d
    public float b(int i10) {
        float e10 = e();
        return (e10 - i10) / (e10 - d());
    }

    @Override // y4.d
    public int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    @Override // y4.d
    public int d() {
        return Math.max(0, (e() - this.f38137a.s()) - this.f38137a.x());
    }

    @Override // y4.d
    public int e() {
        return this.f38137a.A();
    }

    @Override // y4.d
    public int f() {
        return this.f38137a.A();
    }

    @Override // y4.d
    public int g() {
        return d();
    }

    @Override // y4.d
    public <V extends View> int h(V v10) {
        return v10.getLeft() - this.f38137a.x();
    }

    @Override // y4.d
    public int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    @Override // y4.d
    public int j() {
        return 0;
    }

    @Override // y4.d
    public boolean k(float f10) {
        if (f10 < 0.0f) {
            return true;
        }
        return false;
    }

    @Override // y4.d
    public boolean l(View view) {
        if (view.getLeft() > (e() + d()) / 2) {
            return true;
        }
        return false;
    }

    @Override // y4.d
    public boolean m(float f10, float f11) {
        if (e.a(f10, f11) && Math.abs(f10) > this.f38137a.getSignificantVelocityThreshold()) {
            return true;
        }
        return false;
    }

    @Override // y4.d
    public boolean n(View view, float f10) {
        if (Math.abs(view.getRight() + (f10 * this.f38137a.getHideFriction())) > this.f38137a.w()) {
            return true;
        }
        return false;
    }

    @Override // y4.d
    public void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        marginLayoutParams.rightMargin = i10;
    }

    @Override // y4.d
    public void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11) {
        int A10 = this.f38137a.A();
        if (i10 <= A10) {
            marginLayoutParams.rightMargin = A10 - i10;
        }
    }
}
