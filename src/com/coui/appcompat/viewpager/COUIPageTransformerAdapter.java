package com.coui.appcompat.viewpager;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* loaded from: classes3.dex */
public class COUIPageTransformerAdapter extends ViewPager2.i {
    private final LinearLayoutManager mLayoutManager;
    private ViewPager2.k mPageTransformer;

    public COUIPageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    public ViewPager2.k getPageTransformer() {
        return this.mPageTransformer;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageScrolled(int i10, float f10, int i11) {
        if (this.mPageTransformer == null) {
            return;
        }
        float f11 = -f10;
        for (int i12 = 0; i12 < this.mLayoutManager.getChildCount(); i12++) {
            View childAt = this.mLayoutManager.getChildAt(i12);
            if (childAt != null) {
                this.mPageTransformer.transformPage(childAt, (this.mLayoutManager.getPosition(childAt) - i10) + f11);
            } else {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i12), Integer.valueOf(this.mLayoutManager.getChildCount())));
            }
        }
    }

    public void setPageTransformer(ViewPager2.k kVar) {
        this.mPageTransformer = kVar;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageSelected(int i10) {
    }
}
