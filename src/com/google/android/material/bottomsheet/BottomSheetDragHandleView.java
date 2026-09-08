package com.google.android.material.bottomsheet;

import J.d;
import J.g;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.C0446a;
import androidx.core.view.K;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import e4.C0977c;
import e4.k;
import e4.l;

/* loaded from: classes3.dex */
public class BottomSheetDragHandleView extends AppCompatImageView implements AccessibilityManager.AccessibilityStateChangeListener {

    /* renamed from: j, reason: collision with root package name */
    public static final int f22824j = l.f31036s;

    /* renamed from: a, reason: collision with root package name */
    public final AccessibilityManager f22825a;

    /* renamed from: b, reason: collision with root package name */
    public BottomSheetBehavior<?> f22826b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f22827c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f22828d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f22829e;

    /* renamed from: f, reason: collision with root package name */
    public final String f22830f;

    /* renamed from: g, reason: collision with root package name */
    public final String f22831g;

    /* renamed from: h, reason: collision with root package name */
    public final String f22832h;

    /* renamed from: i, reason: collision with root package name */
    public final BottomSheetBehavior.g f22833i;

    /* loaded from: classes3.dex */
    public class b extends C0446a {
        public b() {
        }

        @Override // androidx.core.view.C0446a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            if (accessibilityEvent.getEventType() == 1) {
                BottomSheetDragHandleView.this.k();
            }
        }
    }

    public BottomSheetDragHandleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30667g);
    }

    public static View m(View view) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    private void setBottomSheetBehavior(BottomSheetBehavior<?> bottomSheetBehavior) {
        BottomSheetBehavior<?> bottomSheetBehavior2 = this.f22826b;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.removeBottomSheetCallback(this.f22833i);
            this.f22826b.setAccessibilityDelegateView(null);
        }
        this.f22826b = bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setAccessibilityDelegateView(this);
            o(this.f22826b.getState());
            this.f22826b.addBottomSheetCallback(this.f22833i);
        }
        p();
    }

    public final void j(String str) {
        if (this.f22825a == null) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
        obtain.getText().add(str);
        this.f22825a.sendAccessibilityEvent(obtain);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        if (r1 != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k() {
        /*
            r6 = this;
            boolean r0 = r6.f22828d
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            java.lang.String r0 = r6.f22832h
            r6.j(r0)
            com.google.android.material.bottomsheet.BottomSheetBehavior<?> r0 = r6.f22826b
            boolean r0 = r0.isFitToContents()
            r2 = 1
            if (r0 != 0) goto L1d
            com.google.android.material.bottomsheet.BottomSheetBehavior<?> r0 = r6.f22826b
            boolean r0 = r0.shouldSkipHalfExpandedStateWhenDragging()
            if (r0 != 0) goto L1d
            r1 = r2
        L1d:
            com.google.android.material.bottomsheet.BottomSheetBehavior<?> r0 = r6.f22826b
            int r0 = r0.getState()
            r3 = 6
            r4 = 3
            r5 = 4
            if (r0 != r5) goto L2b
            if (r1 == 0) goto L38
            goto L39
        L2b:
            if (r0 != r4) goto L32
            if (r1 == 0) goto L30
            goto L39
        L30:
            r3 = r5
            goto L39
        L32:
            boolean r0 = r6.f22829e
            if (r0 == 0) goto L37
            goto L38
        L37:
            r4 = r5
        L38:
            r3 = r4
        L39:
            com.google.android.material.bottomsheet.BottomSheetBehavior<?> r6 = r6.f22826b
            r6.setState(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetDragHandleView.k():boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.material.bottomsheet.BottomSheetDragHandleView] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View] */
    public final BottomSheetBehavior<?> l() {
        while (true) {
            this = m(this);
            if (this != 0) {
                ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.e) {
                    CoordinatorLayout.Behavior f10 = ((CoordinatorLayout.e) layoutParams).f();
                    if (f10 instanceof BottomSheetBehavior) {
                        return (BottomSheetBehavior) f10;
                    }
                }
            } else {
                return null;
            }
        }
    }

    public final /* synthetic */ boolean n(View view, g.a aVar) {
        return k();
    }

    public final void o(int i10) {
        String str;
        if (i10 == 4) {
            this.f22829e = true;
        } else if (i10 == 3) {
            this.f22829e = false;
        }
        d.a aVar = d.a.f1394i;
        if (this.f22829e) {
            str = this.f22830f;
        } else {
            str = this.f22831g;
        }
        K.e0(this, aVar, str, new g() { // from class: com.google.android.material.bottomsheet.c
            @Override // J.g
            public final boolean perform(View view, g.a aVar2) {
                boolean n10;
                n10 = BottomSheetDragHandleView.this.n(view, aVar2);
                return n10;
            }
        });
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean z10) {
        this.f22827c = z10;
        p();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBottomSheetBehavior(l());
        AccessibilityManager accessibilityManager = this.f22825a;
        if (accessibilityManager != null) {
            accessibilityManager.addAccessibilityStateChangeListener(this);
            onAccessibilityStateChanged(this.f22825a.isEnabled());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        AccessibilityManager accessibilityManager = this.f22825a;
        if (accessibilityManager != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(this);
        }
        setBottomSheetBehavior(null);
        super.onDetachedFromWindow();
    }

    public final void p() {
        boolean z10;
        int i10 = 1;
        if (this.f22827c && this.f22826b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f22828d = z10;
        if (this.f22826b == null) {
            i10 = 2;
        }
        K.t0(this, i10);
        setClickable(this.f22828d);
    }

    public BottomSheetDragHandleView(Context context, AttributeSet attributeSet, int i10) {
        super(B4.a.c(context, attributeSet, i10, f22824j), attributeSet, i10);
        this.f22830f = getResources().getString(k.f30974b);
        this.f22831g = getResources().getString(k.f30973a);
        this.f22832h = getResources().getString(k.f30976d);
        this.f22833i = new a();
        this.f22825a = (AccessibilityManager) getContext().getSystemService("accessibility");
        p();
        K.j0(this, new b());
    }

    /* loaded from: classes3.dex */
    public class a extends BottomSheetBehavior.g {
        public a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onStateChanged(View view, int i10) {
            BottomSheetDragHandleView.this.o(i10);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onSlide(View view, float f10) {
        }
    }
}
