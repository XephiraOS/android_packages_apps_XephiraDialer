package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.K;
import androidx.core.view.X;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.e;
import e4.C0977c;
import e4.C0978d;
import e4.C0979e;
import e4.l;
import e4.m;

/* loaded from: classes3.dex */
public class BottomNavigationView extends NavigationBarView {
    private static final int MAX_ITEM_COUNT = 5;

    /* loaded from: classes3.dex */
    public class a implements ViewUtils.OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        public X onApplyWindowInsets(View view, X x10, ViewUtils.RelativePadding relativePadding) {
            int i10;
            relativePadding.bottom += x10.j();
            boolean z10 = true;
            if (K.v(view) != 1) {
                z10 = false;
            }
            int k10 = x10.k();
            int l10 = x10.l();
            int i11 = relativePadding.start;
            if (z10) {
                i10 = l10;
            } else {
                i10 = k10;
            }
            relativePadding.start = i11 + i10;
            int i12 = relativePadding.end;
            if (!z10) {
                k10 = l10;
            }
            relativePadding.end = i12 + k10;
            relativePadding.applyToView(view);
            return x10;
        }
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public interface b extends NavigationBarView.b {
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public interface c extends NavigationBarView.c {
    }

    public BottomNavigationView(Context context) {
        this(context, null);
    }

    private void addCompatibilityTopDivider(Context context) {
        View view = new View(context);
        view.setBackgroundColor(androidx.core.content.b.c(context, C0978d.f30707a));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(C0979e.f30784g)));
        addView(view);
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new a());
    }

    private int makeMinHeightSpec(int i10) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i10) != 1073741824 && suggestedMinimumHeight > 0) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), suggestedMinimumHeight + getPaddingTop() + getPaddingBottom()), 1073741824);
        }
        return i10;
    }

    private boolean shouldDrawCompatibilityTopDivider() {
        return false;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public e createNavigationBarMenuView(Context context) {
        return new g4.b(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return ((g4.b) getMenuView()).isItemHorizontalTranslationEnabled();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, makeMinHeightSpec(i11));
    }

    public void setItemHorizontalTranslationEnabled(boolean z10) {
        g4.b bVar = (g4.b) getMenuView();
        if (bVar.isItemHorizontalTranslationEnabled() != z10) {
            bVar.setItemHorizontalTranslationEnabled(z10);
            getPresenter().updateMenuView(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(b bVar) {
        setOnItemReselectedListener(bVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(c cVar) {
        setOnItemSelectedListener(cVar);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30663e);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, l.f31027j);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        Context context2 = getContext();
        androidx.appcompat.widget.K obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, m.f31144J0, i10, i11, new int[0]);
        setItemHorizontalTranslationEnabled(obtainTintedStyledAttributes.a(m.f31177M0, true));
        int i12 = m.f31155K0;
        if (obtainTintedStyledAttributes.s(i12)) {
            setMinimumHeight(obtainTintedStyledAttributes.f(i12, 0));
        }
        if (obtainTintedStyledAttributes.a(m.f31166L0, true) && shouldDrawCompatibilityTopDivider()) {
            addCompatibilityTopDivider(context2);
        }
        obtainTintedStyledAttributes.y();
        applyWindowInsets();
    }
}
