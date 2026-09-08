package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.K;
import java.util.List;
import p4.InterfaceC1439a;

@Deprecated
/* loaded from: classes3.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {

    /* renamed from: a, reason: collision with root package name */
    public int f24249a;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f24250a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f24251b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1439a f24252c;

        public a(View view, int i10, InterfaceC1439a interfaceC1439a) {
            this.f24250a = view;
            this.f24251b = i10;
            this.f24252c = interfaceC1439a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f24250a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f24249a == this.f24251b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                InterfaceC1439a interfaceC1439a = this.f24252c;
                expandableBehavior.d((View) interfaceC1439a, this.f24250a, interfaceC1439a.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f24249a = 0;
    }

    public final boolean b(boolean z10) {
        if (z10) {
            int i10 = this.f24249a;
            if (i10 != 0 && i10 != 2) {
                return false;
            }
            return true;
        }
        if (this.f24249a != 1) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InterfaceC1439a c(CoordinatorLayout coordinatorLayout, View view) {
        List<View> p10 = coordinatorLayout.p(view);
        int size = p10.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = p10.get(i10);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (InterfaceC1439a) view2;
            }
        }
        return null;
    }

    public abstract boolean d(View view, View view2, boolean z10, boolean z11);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        int i10;
        InterfaceC1439a interfaceC1439a = (InterfaceC1439a) view2;
        if (b(interfaceC1439a.a())) {
            if (interfaceC1439a.a()) {
                i10 = 1;
            } else {
                i10 = 2;
            }
            this.f24249a = i10;
            return d((View) interfaceC1439a, view, interfaceC1439a.a(), true);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i10) {
        InterfaceC1439a c10;
        int i11;
        if (!K.O(view) && (c10 = c(coordinatorLayout, view)) != null && b(c10.a())) {
            if (c10.a()) {
                i11 = 1;
            } else {
                i11 = 2;
            }
            this.f24249a = i11;
            view.getViewTreeObserver().addOnPreDrawListener(new a(view, i11, c10));
            return false;
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24249a = 0;
    }
}
