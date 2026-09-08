package androidx.core.view;

import J.d;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.C0446a;
import androidx.core.view.W;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import z.C1719b;

/* compiled from: ViewCompat.java */
/* loaded from: classes.dex */
public class K {

    /* renamed from: a, reason: collision with root package name */
    public static WeakHashMap<View, Q> f9439a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f9440b = {C1719b.f38177b, C1719b.f38178c, C1719b.f38189n, C1719b.f38200y, C1719b.f38163B, C1719b.f38164C, C1719b.f38165D, C1719b.f38166E, C1719b.f38167F, C1719b.f38168G, C1719b.f38179d, C1719b.f38180e, C1719b.f38181f, C1719b.f38182g, C1719b.f38183h, C1719b.f38184i, C1719b.f38185j, C1719b.f38186k, C1719b.f38187l, C1719b.f38188m, C1719b.f38190o, C1719b.f38191p, C1719b.f38192q, C1719b.f38193r, C1719b.f38194s, C1719b.f38195t, C1719b.f38196u, C1719b.f38197v, C1719b.f38198w, C1719b.f38199x, C1719b.f38201z, C1719b.f38162A};

    /* renamed from: c, reason: collision with root package name */
    public static final A f9441c = new A() { // from class: androidx.core.view.J
    };

    /* renamed from: d, reason: collision with root package name */
    public static final e f9442d = new e();

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public class a extends f<Boolean> {
        public a(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        @Override // androidx.core.view.K.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(l.c(view));
        }

        @Override // androidx.core.view.K.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            l.f(view, bool.booleanValue());
        }

        @Override // androidx.core.view.K.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public class b extends f<CharSequence> {
        public b(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        @Override // androidx.core.view.K.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return l.a(view);
        }

        @Override // androidx.core.view.K.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            l.e(view, charSequence);
        }

        @Override // androidx.core.view.K.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public class c extends f<CharSequence> {
        public c(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        @Override // androidx.core.view.K.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return n.a(view);
        }

        @Override // androidx.core.view.K.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            n.c(view, charSequence);
        }

        @Override // androidx.core.view.K.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public class d extends f<Boolean> {
        public d(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        @Override // androidx.core.view.K.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(l.b(view));
        }

        @Override // androidx.core.view.K.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            l.d(view, bool.booleanValue());
        }

        @Override // androidx.core.view.K.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static abstract class f<T> {

        /* renamed from: a, reason: collision with root package name */
        public final int f9444a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<T> f9445b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9446c;

        /* renamed from: d, reason: collision with root package name */
        public final int f9447d;

        public f(int i10, Class<T> cls, int i11) {
            this(i10, cls, 0, i11);
        }

        public boolean a(Boolean bool, Boolean bool2) {
            boolean z10;
            boolean z11;
            if (bool != null && bool.booleanValue()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (bool2 != null && bool2.booleanValue()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z10 != z11) {
                return false;
            }
            return true;
        }

        public final boolean b() {
            if (Build.VERSION.SDK_INT >= this.f9446c) {
                return true;
            }
            return false;
        }

        public abstract T c(View view);

        public abstract void d(View view, T t10);

        public T e(View view) {
            if (b()) {
                return c(view);
            }
            T t10 = (T) view.getTag(this.f9444a);
            if (this.f9445b.isInstance(t10)) {
                return t10;
            }
            return null;
        }

        public void f(View view, T t10) {
            if (b()) {
                d(view, t10);
            } else if (g(e(view), t10)) {
                K.h(view);
                view.setTag(this.f9444a, t10);
                K.S(view, this.f9447d);
            }
        }

        public abstract boolean g(T t10, T t11);

        public f(int i10, Class<T> cls, int i11, int i12) {
            this.f9444a = i10;
            this.f9445b = cls;
            this.f9447d = i11;
            this.f9446c = i12;
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class g {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static void c(View view) {
            view.requestApplyInsets();
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class h {

        /* compiled from: ViewCompat.java */
        /* loaded from: classes.dex */
        public class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            public X f9448a = null;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f9449b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ z f9450c;

            public a(View view, z zVar) {
                this.f9449b = view;
                this.f9450c = zVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                X y10 = X.y(windowInsets, view);
                this.f9448a = y10;
                return this.f9450c.onApplyWindowInsets(view, y10).w();
            }
        }

        public static X a(View view, X x10, Rect rect) {
            WindowInsets w10 = x10.w();
            if (w10 != null) {
                return X.y(view.computeSystemWindowInsets(w10, rect), view);
            }
            rect.setEmpty();
            return x10;
        }

        public static ColorStateList b(View view) {
            return view.getBackgroundTintList();
        }

        public static PorterDuff.Mode c(View view) {
            return view.getBackgroundTintMode();
        }

        public static float d(View view) {
            return view.getElevation();
        }

        public static String e(View view) {
            return view.getTransitionName();
        }

        public static float f(View view) {
            return view.getTranslationZ();
        }

        public static float g(View view) {
            return view.getZ();
        }

        public static boolean h(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static void i(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void j(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void k(View view, float f10) {
            view.setElevation(f10);
        }

        public static void l(View view, boolean z10) {
            view.setNestedScrollingEnabled(z10);
        }

        public static void m(View view, z zVar) {
            if (zVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(C1719b.f38175N));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, zVar));
            }
        }

        public static void n(View view, String str) {
            view.setTransitionName(str);
        }

        public static void o(View view, float f10) {
            view.setTranslationZ(f10);
        }

        public static void p(View view, float f10) {
            view.setZ(f10);
        }

        public static void q(View view) {
            view.stopNestedScroll();
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class i {
        public static X a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            X x10 = X.x(rootWindowInsets);
            x10.v(x10);
            x10.d(view.getRootView());
            return x10;
        }

        public static void b(View view, int i10, int i11) {
            view.setScrollIndicators(i10, i11);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class j {
        public static void a(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class k {
        public static int a(View view) {
            return view.getImportantForAutofill();
        }

        public static void b(View view, int i10) {
            view.setImportantForAutofill(i10);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class l {
        public static CharSequence a(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean b(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean c(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void d(View view, boolean z10) {
            view.setAccessibilityHeading(z10);
        }

        public static void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void f(View view, boolean z10) {
            view.setScreenReaderFocusable(z10);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class m {
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        public static void b(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class n {
        public static CharSequence a(View view) {
            return view.getStateDescription();
        }

        public static Y b(View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return Y.g(windowInsetsController);
            }
            return null;
        }

        public static void c(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    @Deprecated
    public static int A(View view) {
        return view.getPaddingStart();
    }

    @Deprecated
    public static void A0(View view, int i10, int i11, int i12, int i13) {
        view.setPaddingRelative(i10, i11, i12, i13);
    }

    @Deprecated
    public static ViewParent B(View view) {
        return view.getParentForAccessibility();
    }

    public static void B0(View view, C c10) {
        Object obj;
        if (c10 != null) {
            obj = c10.a();
        } else {
            obj = null;
        }
        j.a(view, (PointerIcon) obj);
    }

    public static X C(View view) {
        return i.a(view);
    }

    public static void C0(View view, int i10, int i11) {
        i.b(view, i10, i11);
    }

    public static CharSequence D(View view) {
        return I0().e(view);
    }

    public static void D0(View view, CharSequence charSequence) {
        I0().f(view, charSequence);
    }

    public static String E(View view) {
        return h.e(view);
    }

    public static void E0(View view, String str) {
        h.n(view, str);
    }

    public static float F(View view) {
        return h.f(view);
    }

    public static void F0(View view, float f10) {
        h.o(view, f10);
    }

    @Deprecated
    public static Y G(View view) {
        return n.b(view);
    }

    public static void G0(View view, W.b bVar) {
        W.c(view, bVar);
    }

    @Deprecated
    public static int H(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static void H0(View view, float f10) {
        h.p(view, f10);
    }

    public static float I(View view) {
        return h.g(view);
    }

    public static f<CharSequence> I0() {
        return new c(C1719b.f38174M, CharSequence.class, 64, 30);
    }

    public static boolean J(View view) {
        if (k(view) != null) {
            return true;
        }
        return false;
    }

    public static void J0(View view) {
        h.q(view);
    }

    @Deprecated
    public static boolean K(View view) {
        return view.hasOnClickListeners();
    }

    @Deprecated
    public static boolean L(View view) {
        return view.hasTransientState();
    }

    public static boolean M(View view) {
        Boolean e10 = a().e(view);
        if (e10 != null && e10.booleanValue()) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static boolean N(View view) {
        return view.isAttachedToWindow();
    }

    @Deprecated
    public static boolean O(View view) {
        return view.isLaidOut();
    }

    public static boolean P(View view) {
        return h.h(view);
    }

    @Deprecated
    public static boolean Q(View view) {
        return view.isPaddingRelative();
    }

    public static boolean R(View view) {
        Boolean e10 = i0().e(view);
        if (e10 != null && e10.booleanValue()) {
            return true;
        }
        return false;
    }

    public static void S(View view, int i10) {
        boolean z10;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (!accessibilityManager.isEnabled()) {
            return;
        }
        if (l(view) != null && view.isShown() && view.getWindowVisibility() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i11 = 32;
        if (view.getAccessibilityLiveRegion() == 0 && !z10) {
            if (i10 == 32) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain);
                obtain.setEventType(32);
                obtain.setContentChangeTypes(i10);
                obtain.setSource(view);
                view.onPopulateAccessibilityEvent(obtain);
                obtain.getText().add(l(view));
                accessibilityManager.sendAccessibilityEvent(obtain);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i10);
                    return;
                } catch (AbstractMethodError e10) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e10);
                    return;
                }
            }
            return;
        }
        AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
        if (!z10) {
            i11 = 2048;
        }
        obtain2.setEventType(i11);
        obtain2.setContentChangeTypes(i10);
        if (z10) {
            obtain2.getText().add(l(view));
            u0(view);
        }
        view.sendAccessibilityEventUnchecked(obtain2);
    }

    public static void T(View view, int i10) {
        view.offsetLeftAndRight(i10);
    }

    public static void U(View view, int i10) {
        view.offsetTopAndBottom(i10);
    }

    public static X V(View view, X x10) {
        WindowInsets w10 = x10.w();
        if (w10 != null) {
            WindowInsets b10 = g.b(view, w10);
            if (!b10.equals(w10)) {
                return X.y(b10, view);
            }
        }
        return x10;
    }

    @Deprecated
    public static void W(View view, J.d dVar) {
        view.onInitializeAccessibilityNodeInfo(dVar.N0());
    }

    public static f<CharSequence> X() {
        return new b(C1719b.f38172K, CharSequence.class, 8, 28);
    }

    @Deprecated
    public static boolean Y(View view, int i10, Bundle bundle) {
        return view.performAccessibilityAction(i10, bundle);
    }

    @Deprecated
    public static void Z(View view) {
        view.postInvalidateOnAnimation();
    }

    public static f<Boolean> a() {
        return new d(C1719b.f38171J, Boolean.class, 28);
    }

    @Deprecated
    public static void a0(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static int b(View view, CharSequence charSequence, J.g gVar) {
        int n10 = n(view, charSequence);
        if (n10 != -1) {
            c(view, new d.a(n10, charSequence, gVar));
        }
        return n10;
    }

    @Deprecated
    public static void b0(View view, Runnable runnable, long j10) {
        view.postOnAnimationDelayed(runnable, j10);
    }

    public static void c(View view, d.a aVar) {
        h(view);
        d0(aVar.b(), view);
        m(view).add(aVar);
        S(view, 0);
    }

    public static void c0(View view, int i10) {
        d0(i10, view);
        S(view, 0);
    }

    @Deprecated
    public static Q d(View view) {
        if (f9439a == null) {
            f9439a = new WeakHashMap<>();
        }
        Q q10 = f9439a.get(view);
        if (q10 == null) {
            Q q11 = new Q(view);
            f9439a.put(view, q11);
            return q11;
        }
        return q10;
    }

    public static void d0(int i10, View view) {
        List<d.a> m10 = m(view);
        for (int i11 = 0; i11 < m10.size(); i11++) {
            if (m10.get(i11).b() == i10) {
                m10.remove(i11);
                return;
            }
        }
    }

    public static X e(View view, X x10, Rect rect) {
        return h.a(view, x10, rect);
    }

    public static void e0(View view, d.a aVar, CharSequence charSequence, J.g gVar) {
        if (gVar == null && charSequence == null) {
            c0(view, aVar.b());
        } else {
            c(view, aVar.a(charSequence, gVar));
        }
    }

    public static X f(View view, X x10) {
        WindowInsets w10 = x10.w();
        if (w10 != null) {
            WindowInsets a10 = g.a(view, w10);
            if (!a10.equals(w10)) {
                return X.y(a10, view);
            }
        }
        return x10;
    }

    public static void f0(View view) {
        g.c(view);
    }

    public static boolean g(View view, KeyEvent keyEvent) {
        return false;
    }

    @Deprecated
    public static int g0(int i10, int i11, int i12) {
        return View.resolveSizeAndState(i10, i11, i12);
    }

    public static void h(View view) {
        C0446a j10 = j(view);
        if (j10 == null) {
            j10 = new C0446a();
        }
        j0(view, j10);
    }

    public static void h0(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
        m.b(view, context, iArr, attributeSet, typedArray, i10, i11);
    }

    @Deprecated
    public static int i() {
        return View.generateViewId();
    }

    public static f<Boolean> i0() {
        return new a(C1719b.f38173L, Boolean.class, 28);
    }

    public static C0446a j(View view) {
        View.AccessibilityDelegate k10 = k(view);
        if (k10 == null) {
            return null;
        }
        if (k10 instanceof C0446a.C0109a) {
            return ((C0446a.C0109a) k10).f9495a;
        }
        return new C0446a(k10);
    }

    public static void j0(View view, C0446a c0446a) {
        View.AccessibilityDelegate bridge;
        if (c0446a == null && (k(view) instanceof C0446a.C0109a)) {
            c0446a = new C0446a();
        }
        u0(view);
        if (c0446a == null) {
            bridge = null;
        } else {
            bridge = c0446a.getBridge();
        }
        view.setAccessibilityDelegate(bridge);
    }

    public static View.AccessibilityDelegate k(View view) {
        return m.a(view);
    }

    public static void k0(View view, boolean z10) {
        a().f(view, Boolean.valueOf(z10));
    }

    public static CharSequence l(View view) {
        return X().e(view);
    }

    @Deprecated
    public static void l0(View view, int i10) {
        view.setAccessibilityLiveRegion(i10);
    }

    public static List<d.a> m(View view) {
        int i10 = C1719b.f38169H;
        ArrayList arrayList = (ArrayList) view.getTag(i10);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(i10, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    public static void m0(View view, CharSequence charSequence) {
        X().f(view, charSequence);
        if (charSequence != null) {
            f9442d.a(view);
        } else {
            f9442d.c(view);
        }
    }

    public static int n(View view, CharSequence charSequence) {
        boolean z10;
        List<d.a> m10 = m(view);
        for (int i10 = 0; i10 < m10.size(); i10++) {
            if (TextUtils.equals(charSequence, m10.get(i10).c())) {
                return m10.get(i10).b();
            }
        }
        int i11 = -1;
        int i12 = 0;
        while (true) {
            int[] iArr = f9440b;
            if (i12 >= iArr.length || i11 != -1) {
                break;
            }
            int i13 = iArr[i12];
            boolean z11 = true;
            for (int i14 = 0; i14 < m10.size(); i14++) {
                if (m10.get(i14).b() != i13) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 &= z10;
            }
            if (z11) {
                i11 = i13;
            }
            i12++;
        }
        return i11;
    }

    @Deprecated
    public static void n0(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static ColorStateList o(View view) {
        return h.b(view);
    }

    public static void o0(View view, ColorStateList colorStateList) {
        h.i(view, colorStateList);
    }

    public static PorterDuff.Mode p(View view) {
        return h.c(view);
    }

    public static void p0(View view, PorterDuff.Mode mode) {
        h.j(view, mode);
    }

    @Deprecated
    public static Display q(View view) {
        return view.getDisplay();
    }

    @Deprecated
    public static void q0(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static float r(View view) {
        return h.d(view);
    }

    public static void r0(View view, float f10) {
        h.k(view, f10);
    }

    @Deprecated
    public static boolean s(View view) {
        return view.getFitsSystemWindows();
    }

    @Deprecated
    public static void s0(View view, boolean z10) {
        view.setFitsSystemWindows(z10);
    }

    @Deprecated
    public static int t(View view) {
        return view.getImportantForAccessibility();
    }

    @Deprecated
    public static void t0(View view, int i10) {
        view.setImportantForAccessibility(i10);
    }

    public static int u(View view) {
        return k.a(view);
    }

    public static void u0(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    @Deprecated
    public static int v(View view) {
        return view.getLayoutDirection();
    }

    public static void v0(View view, int i10) {
        k.b(view, i10);
    }

    @Deprecated
    public static int w(View view) {
        return view.getMeasuredState();
    }

    @Deprecated
    public static void w0(View view, int i10) {
        view.setLabelFor(i10);
    }

    @Deprecated
    public static int x(View view) {
        return view.getMinimumHeight();
    }

    @Deprecated
    public static void x0(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    @Deprecated
    public static int y(View view) {
        return view.getMinimumWidth();
    }

    public static void y0(View view, boolean z10) {
        h.l(view, z10);
    }

    @Deprecated
    public static int z(View view) {
        return view.getPaddingEnd();
    }

    public static void z0(View view, z zVar) {
        h.m(view, zVar);
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final WeakHashMap<View, Boolean> f9443a = new WeakHashMap<>();

        public void a(View view) {
            boolean z10;
            WeakHashMap<View, Boolean> weakHashMap = this.f9443a;
            if (view.isShown() && view.getWindowVisibility() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            weakHashMap.put(view, Boolean.valueOf(z10));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                b(view);
            }
        }

        public final void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void c(View view) {
            this.f9443a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            d(view);
        }

        public final void d(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
