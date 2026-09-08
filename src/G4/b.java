package g4;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.K;
import com.google.android.material.navigation.c;
import com.google.android.material.navigation.e;
import e4.C0979e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BottomNavigationMenuView.java */
/* loaded from: classes3.dex */
public class b extends e {
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private boolean itemHorizontalTranslationEnabled;
    private final List<Integer> tempChildWidths;

    public b(Context context) {
        super(context);
        this.tempChildWidths = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.inactiveItemMaxWidth = resources.getDimensionPixelSize(C0979e.f30778d);
        this.inactiveItemMinWidth = resources.getDimensionPixelSize(C0979e.f30780e);
        this.activeItemMaxWidth = resources.getDimensionPixelSize(C0979e.f30774b);
        this.activeItemMinWidth = resources.getDimensionPixelSize(C0979e.f30776c);
    }

    @Override // com.google.android.material.navigation.e
    public c createNavigationBarItemView(Context context) {
        return new C1045a(context);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                if (K.v(this) == 1) {
                    int i18 = i14 - i16;
                    childAt.layout(i18 - childAt.getMeasuredWidth(), 0, i18, i15);
                } else {
                    childAt.layout(i16, 0, childAt.getMeasuredWidth() + i16, i15);
                }
                i16 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        MenuBuilder menu = getMenu();
        int size = View.MeasureSpec.getSize(i10);
        int size2 = menu.getVisibleItems().size();
        int childCount = getChildCount();
        this.tempChildWidths.clear();
        int size3 = View.MeasureSpec.getSize(i11);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        int i15 = 1;
        if (isShifting(getLabelVisibilityMode(), size2) && isItemHorizontalTranslationEnabled()) {
            View childAt = getChildAt(getSelectedItemPosition());
            int i16 = this.activeItemMinWidth;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), makeMeasureSpec);
                i16 = Math.max(i16, childAt.getMeasuredWidth());
            }
            if (childAt.getVisibility() != 8) {
                i13 = 1;
            } else {
                i13 = 0;
            }
            int i17 = size2 - i13;
            int min = Math.min(size - (this.inactiveItemMinWidth * i17), Math.min(i16, this.activeItemMaxWidth));
            int i18 = size - min;
            if (i17 != 0) {
                i15 = i17;
            }
            int min2 = Math.min(i18 / i15, this.inactiveItemMaxWidth);
            int i19 = i18 - (i17 * min2);
            for (int i20 = 0; i20 < childCount; i20++) {
                if (getChildAt(i20).getVisibility() != 8) {
                    if (i20 == getSelectedItemPosition()) {
                        i14 = min;
                    } else {
                        i14 = min2;
                    }
                    if (i19 > 0) {
                        i14++;
                        i19--;
                    }
                } else {
                    i14 = 0;
                }
                this.tempChildWidths.add(Integer.valueOf(i14));
            }
        } else {
            if (size2 != 0) {
                i15 = size2;
            }
            int min3 = Math.min(size / i15, this.activeItemMaxWidth);
            int i21 = size - (size2 * min3);
            for (int i22 = 0; i22 < childCount; i22++) {
                if (getChildAt(i22).getVisibility() != 8) {
                    if (i21 > 0) {
                        i12 = min3 + 1;
                        i21--;
                    } else {
                        i12 = min3;
                    }
                } else {
                    i12 = 0;
                }
                this.tempChildWidths.add(Integer.valueOf(i12));
            }
        }
        int i23 = 0;
        for (int i24 = 0; i24 < childCount; i24++) {
            View childAt2 = getChildAt(i24);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths.get(i24).intValue(), 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i23 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(i23, size3);
    }

    public void setItemHorizontalTranslationEnabled(boolean z10) {
        this.itemHorizontalTranslationEnabled = z10;
    }
}
