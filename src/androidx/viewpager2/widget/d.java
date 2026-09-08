package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* compiled from: PageTransformerAdapter.java */
/* loaded from: classes.dex */
public final class d extends ViewPager2.i {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayoutManager f11866a;

    /* renamed from: b, reason: collision with root package name */
    public ViewPager2.k f11867b;

    public d(LinearLayoutManager linearLayoutManager) {
        this.f11866a = linearLayoutManager;
    }

    public ViewPager2.k getPageTransformer() {
        return this.f11867b;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageScrolled(int i10, float f10, int i11) {
        if (this.f11867b == null) {
            return;
        }
        float f11 = -f10;
        for (int i12 = 0; i12 < this.f11866a.getChildCount(); i12++) {
            View childAt = this.f11866a.getChildAt(i12);
            if (childAt != null) {
                this.f11867b.transformPage(childAt, (this.f11866a.getPosition(childAt) - i10) + f11);
            } else {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i12), Integer.valueOf(this.f11866a.getChildCount())));
            }
        }
    }

    public void setPageTransformer(ViewPager2.k kVar) {
        this.f11867b = kVar;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageSelected(int i10) {
    }
}
