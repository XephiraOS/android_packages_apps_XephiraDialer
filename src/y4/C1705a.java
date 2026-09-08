package y4;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* compiled from: LeftSheetDelegate.java */
/* renamed from: y4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1705a extends d {

    /* renamed from: a, reason: collision with root package name */
    public final SideSheetBehavior<? extends View> f38136a;

    public C1705a(SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.f38136a = sideSheetBehavior;
    }

    @Override // y4.d
    public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // y4.d
    public float b(int i10) {
        float e10 = e();
        return (i10 - e10) / (d() - e10);
    }

    @Override // y4.d
    public int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    @Override // y4.d
    public int d() {
        return Math.max(0, this.f38136a.z() + this.f38136a.x());
    }

    @Override // y4.d
    public int e() {
        return (-this.f38136a.s()) - this.f38136a.x();
    }

    @Override // y4.d
    public int f() {
        return this.f38136a.x();
    }

    @Override // y4.d
    public int g() {
        return -this.f38136a.s();
    }

    @Override // y4.d
    public <V extends View> int h(V v10) {
        return v10.getRight() + this.f38136a.x();
    }

    @Override // y4.d
    public int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getLeft();
    }

    @Override // y4.d
    public int j() {
        return 1;
    }

    @Override // y4.d
    public boolean k(float f10) {
        if (f10 > 0.0f) {
            return true;
        }
        return false;
    }

    @Override // y4.d
    public boolean l(View view) {
        if (view.getRight() < (d() - e()) / 2) {
            return true;
        }
        return false;
    }

    @Override // y4.d
    public boolean m(float f10, float f11) {
        if (e.a(f10, f11) && Math.abs(f10) > this.f38136a.getSignificantVelocityThreshold()) {
            return true;
        }
        return false;
    }

    @Override // y4.d
    public boolean n(View view, float f10) {
        if (Math.abs(view.getLeft() + (f10 * this.f38136a.getHideFriction())) > this.f38136a.w()) {
            return true;
        }
        return false;
    }

    @Override // y4.d
    public void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        marginLayoutParams.leftMargin = i10;
    }

    @Override // y4.d
    public void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11) {
        if (i10 <= this.f38136a.A()) {
            marginLayoutParams.leftMargin = i11;
        }
    }
}
