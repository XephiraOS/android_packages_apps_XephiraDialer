package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.K;
import com.google.android.material.transformation.FabTransformationBehavior;
import e4.C0976b;
import f4.C1008i;
import f4.C1010k;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: classes3.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: i, reason: collision with root package name */
    public Map<View, Integer> f24280i;

    public FabTransformationSheetBehavior() {
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    public FabTransformationBehavior.e A(Context context, boolean z10) {
        int i10;
        if (z10) {
            i10 = C0976b.f30623h;
        } else {
            i10 = C0976b.f30622g;
        }
        FabTransformationBehavior.e eVar = new FabTransformationBehavior.e();
        eVar.f24273a = C1008i.d(context, i10);
        eVar.f24274b = new C1010k(17, 0.0f, 0.0f);
        return eVar;
    }

    public final void C(View view, boolean z10) {
        boolean z11;
        ViewParent parent = view.getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        int childCount = coordinatorLayout.getChildCount();
        if (z10) {
            this.f24280i = new HashMap(childCount);
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = coordinatorLayout.getChildAt(i10);
            if ((childAt.getLayoutParams() instanceof CoordinatorLayout.e) && (((CoordinatorLayout.e) childAt.getLayoutParams()).f() instanceof FabTransformationScrimBehavior)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (childAt != view && !z11) {
                if (!z10) {
                    Map<View, Integer> map = this.f24280i;
                    if (map != null && map.containsKey(childAt)) {
                        K.t0(childAt, this.f24280i.get(childAt).intValue());
                    }
                } else {
                    this.f24280i.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    K.t0(childAt, 4);
                }
            }
        }
        if (!z10) {
            this.f24280i = null;
        }
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public boolean d(View view, View view2, boolean z10, boolean z11) {
        C(view2, z10);
        return super.d(view, view2, z10, z11);
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
