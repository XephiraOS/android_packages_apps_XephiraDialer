package com.coui.appcompat.viewpager;

import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes3.dex */
public class COUIMarginPageTransformer implements ViewPager2.k {
    private final int mMarginPx;

    public COUIMarginPageTransformer(int i10) {
        if (i10 >= 0) {
            this.mMarginPx = i10;
            return;
        }
        throw new IllegalArgumentException("Margin must be non-negative");
    }

    private COUIViewPager2 requireViewPager(View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof COUIViewPager2)) {
            return (COUIViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.k
    public void transformPage(View view, float f10) {
        COUIViewPager2 requireViewPager = requireViewPager(view);
        float f11 = this.mMarginPx * f10;
        if (requireViewPager.getOrientation() == 0) {
            if (requireViewPager.isRtl()) {
                f11 = -f11;
            }
            view.setTranslationX(f11);
            return;
        }
        view.setTranslationY(f11);
    }
}
