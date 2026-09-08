package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.core.view.C0455j;
import androidx.core.view.C0469y;
import androidx.core.view.InterfaceC0467w;
import androidx.core.view.InterfaceC0468x;
import androidx.core.view.K;
import androidx.core.view.X;
import androidx.core.view.z;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import x.C1660a;
import y.C1697a;
import y.C1698b;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements InterfaceC0467w, InterfaceC0468x {

    /* renamed from: A, reason: collision with root package name */
    public static final Class<?>[] f9288A;

    /* renamed from: B, reason: collision with root package name */
    public static final ThreadLocal<Map<String, Constructor<Behavior>>> f9289B;

    /* renamed from: C, reason: collision with root package name */
    public static final Comparator<View> f9290C;

    /* renamed from: D, reason: collision with root package name */
    public static final I.e<Rect> f9291D;

    /* renamed from: z, reason: collision with root package name */
    public static final String f9292z;

    /* renamed from: a, reason: collision with root package name */
    public final List<View> f9293a;

    /* renamed from: b, reason: collision with root package name */
    public final C1697a<View> f9294b;

    /* renamed from: c, reason: collision with root package name */
    public final List<View> f9295c;

    /* renamed from: d, reason: collision with root package name */
    public final List<View> f9296d;

    /* renamed from: e, reason: collision with root package name */
    public Paint f9297e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f9298f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f9299g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9300h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9301i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f9302j;

    /* renamed from: k, reason: collision with root package name */
    public View f9303k;

    /* renamed from: l, reason: collision with root package name */
    public View f9304l;

    /* renamed from: m, reason: collision with root package name */
    public f f9305m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f9306n;

    /* renamed from: o, reason: collision with root package name */
    public X f9307o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9308p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f9309q;

    /* renamed from: r, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f9310r;

    /* renamed from: x, reason: collision with root package name */
    public z f9311x;

    /* renamed from: y, reason: collision with root package name */
    public final C0469y f9312y;

    /* loaded from: classes.dex */
    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public static Object getTag(View view) {
            return ((e) view.getLayoutParams()).f9333r;
        }

        public static void setTag(View view, Object obj) {
            ((e) view.getLayoutParams()).f9333r = obj;
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v10) {
            if (getScrimOpacity(coordinatorLayout, v10) > 0.0f) {
                return true;
            }
            return false;
        }

        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v10, Rect rect) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v10) {
            return -16777216;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v10) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v10, View view) {
            return false;
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v10, View view) {
            return false;
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12, int i13) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11, boolean z10) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13) {
        }

        @Deprecated
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10) {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v10, Rect rect, boolean z10) {
            return false;
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v10) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view) {
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr, int i12) {
            if (i12 == 0) {
                onNestedPreScroll(coordinatorLayout, v10, view, i10, i11, iArr);
            }
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14) {
            if (i14 == 0) {
                onNestedScroll(coordinatorLayout, v10, view, i10, i11, i12, i13);
            }
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
            if (i11 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v10, view, view2, i10);
            }
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
            if (i11 == 0) {
                return onStartNestedScroll(coordinatorLayout, v10, view, view2, i10);
            }
            return false;
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10) {
            if (i10 == 0) {
                onStopNestedScroll(coordinatorLayout, v10, view);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
            onNestedScroll(coordinatorLayout, v10, view, i10, i11, i12, i13, i14);
        }

        public void onAttachedToLayoutParams(e eVar) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public X onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v10, X x10) {
            return x10;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v10, View view) {
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v10, Parcelable parcelable) {
        }
    }

    /* loaded from: classes.dex */
    public class a implements z {
        public a() {
        }

        @Override // androidx.core.view.z
        public X onApplyWindowInsets(View view, X x10) {
            return CoordinatorLayout.this.U(x10);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        Behavior getBehavior();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: classes.dex */
    public @interface c {
        Class<? extends Behavior> value();
    }

    /* loaded from: classes.dex */
    public class d implements ViewGroup.OnHierarchyChangeListener {
        public d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f9310r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.F(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f9310r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements ViewTreeObserver.OnPreDrawListener {
        public f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.F(0);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class g implements Comparator<View> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float I10 = K.I(view);
            float I11 = K.I(view2);
            if (I10 > I11) {
                return -1;
            }
            if (I10 < I11) {
                return 1;
            }
            return 0;
        }
    }

    static {
        String str;
        Package r02 = CoordinatorLayout.class.getPackage();
        if (r02 != null) {
            str = r02.getName();
        } else {
            str = null;
        }
        f9292z = str;
        f9290C = new g();
        f9288A = new Class[]{Context.class, AttributeSet.class};
        f9289B = new ThreadLocal<>();
        f9291D = new I.g(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1660a.f37634a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Behavior I(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f9292z;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<Behavior>>> threadLocal = f9289B;
            Map<String, Constructor<Behavior>> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<>();
                threadLocal.set(map);
            }
            Constructor<Behavior> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f9288A);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e10) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e10);
        }
    }

    public static void M(Rect rect) {
        rect.setEmpty();
        f9291D.a(rect);
    }

    public static int P(int i10) {
        if (i10 == 0) {
            return 17;
        }
        return i10;
    }

    public static int Q(int i10) {
        if ((i10 & 7) == 0) {
            i10 |= 8388611;
        }
        if ((i10 & 112) == 0) {
            return i10 | 48;
        }
        return i10;
    }

    public static int R(int i10) {
        if (i10 == 0) {
            return 8388661;
        }
        return i10;
    }

    public static Rect e() {
        Rect b10 = f9291D.b();
        if (b10 == null) {
            return new Rect();
        }
        return b10;
    }

    private static int g(int i10, int i11, int i12) {
        if (i10 < i11) {
            return i11;
        }
        if (i10 > i12) {
            return i12;
        }
        return i10;
    }

    public final void A(View view, int i10) {
        e eVar = (e) view.getLayoutParams();
        Rect e10 = e();
        e10.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        if (this.f9307o != null && K.s(this) && !K.s(view)) {
            e10.left += this.f9307o.k();
            e10.top += this.f9307o.m();
            e10.right -= this.f9307o.l();
            e10.bottom -= this.f9307o.j();
        }
        Rect e11 = e();
        C0455j.a(Q(eVar.f9318c), view.getMeasuredWidth(), view.getMeasuredHeight(), e10, e11, i10);
        view.layout(e11.left, e11.top, e11.right, e11.bottom);
        M(e10);
        M(e11);
    }

    public final void B(View view, View view2, int i10) {
        Rect e10 = e();
        Rect e11 = e();
        try {
            r(view2, e10);
            s(view, i10, e10, e11);
            view.layout(e11.left, e11.top, e11.right, e11.bottom);
        } finally {
            M(e10);
            M(e11);
        }
    }

    public final void C(View view, int i10, int i11) {
        int i12;
        e eVar = (e) view.getLayoutParams();
        int b10 = C0455j.b(R(eVar.f9318c), i11);
        int i13 = b10 & 7;
        int i14 = b10 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i11 == 1) {
            i10 = width - i10;
        }
        int u10 = u(i10) - measuredWidth;
        if (i13 != 1) {
            if (i13 == 5) {
                u10 += measuredWidth;
            }
        } else {
            u10 += measuredWidth / 2;
        }
        if (i14 != 16) {
            if (i14 != 80) {
                i12 = 0;
            } else {
                i12 = measuredHeight;
            }
        } else {
            i12 = measuredHeight / 2;
        }
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(u10, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(i12, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    public final void D(View view, Rect rect, int i10) {
        boolean z10;
        int width;
        int i11;
        int i12;
        int i13;
        int height;
        int i14;
        int i15;
        int i16;
        if (K.O(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            e eVar = (e) view.getLayoutParams();
            Behavior f10 = eVar.f();
            Rect e10 = e();
            Rect e11 = e();
            e11.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (f10 != null && f10.getInsetDodgeRect(this, view, e10)) {
                if (!e11.contains(e10)) {
                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + e10.toShortString() + " | Bounds:" + e11.toShortString());
                }
            } else {
                e10.set(e11);
            }
            M(e11);
            if (e10.isEmpty()) {
                M(e10);
                return;
            }
            int b10 = C0455j.b(eVar.f9323h, i10);
            boolean z11 = true;
            if ((b10 & 48) == 48 && (i15 = (e10.top - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - eVar.f9325j) < (i16 = rect.top)) {
                T(view, i16 - i15);
                z10 = true;
            } else {
                z10 = false;
            }
            if ((b10 & 80) == 80 && (height = ((getHeight() - e10.bottom) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) + eVar.f9325j) < (i14 = rect.bottom)) {
                T(view, height - i14);
            } else if (!z10) {
                T(view, 0);
            }
            if ((b10 & 3) == 3 && (i12 = (e10.left - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - eVar.f9324i) < (i13 = rect.left)) {
                S(view, i13 - i12);
            } else {
                z11 = false;
            }
            if ((b10 & 5) == 5 && (width = ((getWidth() - e10.right) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin) + eVar.f9324i) < (i11 = rect.right)) {
                S(view, width - i11);
            } else if (!z11) {
                S(view, 0);
            }
            M(e10);
        }
    }

    public void E(View view, int i10) {
        Behavior f10;
        e eVar = (e) view.getLayoutParams();
        if (eVar.f9326k != null) {
            Rect e10 = e();
            Rect e11 = e();
            Rect e12 = e();
            r(eVar.f9326k, e10);
            boolean z10 = false;
            o(view, false, e11);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            t(view, i10, e10, e12, eVar, measuredWidth, measuredHeight);
            if (e12.left != e11.left || e12.top != e11.top) {
                z10 = true;
            }
            h(eVar, e12, measuredWidth, measuredHeight);
            int i11 = e12.left - e11.left;
            int i12 = e12.top - e11.top;
            if (i11 != 0) {
                K.T(view, i11);
            }
            if (i12 != 0) {
                K.U(view, i12);
            }
            if (z10 && (f10 = eVar.f()) != null) {
                f10.onDependentViewChanged(this, view, eVar.f9326k);
            }
            M(e10);
            M(e11);
            M(e12);
        }
    }

    public final void F(int i10) {
        boolean z10;
        int v10 = K.v(this);
        int size = this.f9293a.size();
        Rect e10 = e();
        Rect e11 = e();
        Rect e12 = e();
        for (int i11 = 0; i11 < size; i11++) {
            View view = this.f9293a.get(i11);
            e eVar = (e) view.getLayoutParams();
            if (i10 != 0 || view.getVisibility() != 8) {
                for (int i12 = 0; i12 < i11; i12++) {
                    if (eVar.f9327l == this.f9293a.get(i12)) {
                        E(view, v10);
                    }
                }
                o(view, true, e11);
                if (eVar.f9322g != 0 && !e11.isEmpty()) {
                    int b10 = C0455j.b(eVar.f9322g, v10);
                    int i13 = b10 & 112;
                    if (i13 != 48) {
                        if (i13 == 80) {
                            e10.bottom = Math.max(e10.bottom, getHeight() - e11.top);
                        }
                    } else {
                        e10.top = Math.max(e10.top, e11.bottom);
                    }
                    int i14 = b10 & 7;
                    if (i14 != 3) {
                        if (i14 == 5) {
                            e10.right = Math.max(e10.right, getWidth() - e11.left);
                        }
                    } else {
                        e10.left = Math.max(e10.left, e11.right);
                    }
                }
                if (eVar.f9323h != 0 && view.getVisibility() == 0) {
                    D(view, e10, v10);
                }
                if (i10 != 2) {
                    v(view, e12);
                    if (!e12.equals(e11)) {
                        L(view, e11);
                    }
                }
                for (int i15 = i11 + 1; i15 < size; i15++) {
                    View view2 = this.f9293a.get(i15);
                    e eVar2 = (e) view2.getLayoutParams();
                    Behavior f10 = eVar2.f();
                    if (f10 != null && f10.layoutDependsOn(this, view2, view)) {
                        if (i10 == 0 && eVar2.g()) {
                            eVar2.k();
                        } else {
                            if (i10 != 2) {
                                z10 = f10.onDependentViewChanged(this, view2, view);
                            } else {
                                f10.onDependentViewRemoved(this, view2, view);
                                z10 = true;
                            }
                            if (i10 == 1) {
                                eVar2.p(z10);
                            }
                        }
                    }
                }
            }
        }
        M(e10);
        M(e11);
        M(e12);
    }

    public void G(View view, int i10) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.a()) {
            View view2 = eVar.f9326k;
            if (view2 != null) {
                B(view, view2, i10);
                return;
            }
            int i11 = eVar.f9320e;
            if (i11 >= 0) {
                C(view, i11, i10);
                return;
            } else {
                A(view, i10);
                return;
            }
        }
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    public void H(View view, int i10, int i11, int i12, int i13) {
        measureChildWithMargins(view, i10, i11, i12, i13);
    }

    public final boolean J(MotionEvent motionEvent, int i10) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f9295c;
        x(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z10 = false;
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            View view = list.get(i11);
            e eVar = (e) view.getLayoutParams();
            Behavior f10 = eVar.f();
            if ((z10 || z11) && actionMasked != 0) {
                if (f10 != null) {
                    if (motionEvent2 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i10 != 0) {
                        if (i10 == 1) {
                            f10.onTouchEvent(this, view, motionEvent2);
                        }
                    } else {
                        f10.onInterceptTouchEvent(this, view, motionEvent2);
                    }
                }
            } else {
                if (!z10 && f10 != null) {
                    if (i10 != 0) {
                        if (i10 == 1) {
                            z10 = f10.onTouchEvent(this, view, motionEvent);
                        }
                    } else {
                        z10 = f10.onInterceptTouchEvent(this, view, motionEvent);
                    }
                    if (z10) {
                        this.f9303k = view;
                    }
                }
                boolean c10 = eVar.c();
                boolean i12 = eVar.i(this, view);
                if (i12 && !c10) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (i12 && !z11) {
                    break;
                }
            }
        }
        list.clear();
        return z10;
    }

    public final void K() {
        this.f9293a.clear();
        this.f9294b.c();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            e w10 = w(childAt);
            w10.d(this, childAt);
            this.f9294b.b(childAt);
            for (int i11 = 0; i11 < childCount; i11++) {
                if (i11 != i10) {
                    View childAt2 = getChildAt(i11);
                    if (w10.b(this, childAt, childAt2)) {
                        if (!this.f9294b.d(childAt2)) {
                            this.f9294b.b(childAt2);
                        }
                        this.f9294b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f9293a.addAll(this.f9294b.i());
        Collections.reverse(this.f9293a);
    }

    public void L(View view, Rect rect) {
        ((e) view.getLayoutParams()).q(rect);
    }

    public void N() {
        if (this.f9301i && this.f9305m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f9305m);
        }
        this.f9306n = false;
    }

    public final void O(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            Behavior f10 = ((e) childAt.getLayoutParams()).f();
            if (f10 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z10) {
                    f10.onInterceptTouchEvent(this, childAt, obtain);
                } else {
                    f10.onTouchEvent(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            ((e) getChildAt(i11).getLayoutParams()).m();
        }
        this.f9303k = null;
        this.f9300h = false;
    }

    public final void S(View view, int i10) {
        e eVar = (e) view.getLayoutParams();
        int i11 = eVar.f9324i;
        if (i11 != i10) {
            K.T(view, i10 - i11);
            eVar.f9324i = i10;
        }
    }

    public final void T(View view, int i10) {
        e eVar = (e) view.getLayoutParams();
        int i11 = eVar.f9325j;
        if (i11 != i10) {
            K.U(view, i10 - i11);
            eVar.f9325j = i10;
        }
    }

    public final X U(X x10) {
        boolean z10;
        if (!I.c.a(this.f9307o, x10)) {
            this.f9307o = x10;
            boolean z11 = false;
            if (x10 != null && x10.m() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f9308p = z10;
            if (!z10 && getBackground() == null) {
                z11 = true;
            }
            setWillNotDraw(z11);
            X i10 = i(x10);
            requestLayout();
            return i10;
        }
        return x10;
    }

    public final void V() {
        if (K.s(this)) {
            if (this.f9311x == null) {
                this.f9311x = new a();
            }
            K.z0(this, this.f9311x);
            setSystemUiVisibility(1280);
            return;
        }
        K.z0(this, null);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof e) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        e eVar = (e) view.getLayoutParams();
        Behavior behavior = eVar.f9316a;
        if (behavior != null) {
            float scrimOpacity = behavior.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.f9297e == null) {
                    this.f9297e = new Paint();
                }
                this.f9297e.setColor(eVar.f9316a.getScrimColor(this, view));
                this.f9297e.setAlpha(g(Math.round(scrimOpacity * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f9297e);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f9309q;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidate();
        }
    }

    public void f() {
        if (this.f9301i) {
            if (this.f9305m == null) {
                this.f9305m = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f9305m);
        }
        this.f9306n = true;
    }

    public final List<View> getDependencySortedChildren() {
        K();
        return Collections.unmodifiableList(this.f9293a);
    }

    public final X getLastWindowInsets() {
        return this.f9307o;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f9312y.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f9309q;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public final void h(e eVar, Rect rect, int i10, int i11) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i10) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i11) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        rect.set(max, max2, i10 + max, i11 + max2);
    }

    public final X i(X x10) {
        Behavior f10;
        if (x10.q()) {
            return x10;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (K.s(childAt) && (f10 = ((e) childAt.getLayoutParams()).f()) != null) {
                x10 = f10.onApplyWindowInsets(this, childAt, x10);
                if (x10.q()) {
                    break;
                }
            }
        }
        return x10;
    }

    public void j(View view) {
        List g10 = this.f9294b.g(view);
        if (g10 != null && !g10.isEmpty()) {
            for (int i10 = 0; i10 < g10.size(); i10++) {
                View view2 = (View) g10.get(i10);
                Behavior f10 = ((e) view2.getLayoutParams()).f();
                if (f10 != null) {
                    f10.onDependentViewChanged(this, view2, view);
                }
            }
        }
    }

    public void k() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            if (y(getChildAt(i10))) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10 != this.f9306n) {
            if (z10) {
                f();
            } else {
                N();
            }
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new e((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new e(layoutParams);
    }

    public void o(View view, boolean z10, Rect rect) {
        if (!view.isLayoutRequested() && view.getVisibility() != 8) {
            if (z10) {
                r(view, rect);
                return;
            } else {
                rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                return;
            }
        }
        rect.setEmpty();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        O(false);
        if (this.f9306n) {
            if (this.f9305m == null) {
                this.f9305m = new f();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f9305m);
        }
        if (this.f9307o == null && K.s(this)) {
            K.f0(this);
        }
        this.f9301i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O(false);
        if (this.f9306n && this.f9305m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f9305m);
        }
        View view = this.f9304l;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f9301i = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i10;
        super.onDraw(canvas);
        if (this.f9308p && this.f9309q != null) {
            X x10 = this.f9307o;
            if (x10 != null) {
                i10 = x10.m();
            } else {
                i10 = 0;
            }
            if (i10 > 0) {
                this.f9309q.setBounds(0, 0, getWidth(), i10);
                this.f9309q.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            O(true);
        }
        boolean J10 = J(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            O(true);
        }
        return J10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        Behavior f10;
        int v10 = K.v(this);
        int size = this.f9293a.size();
        for (int i14 = 0; i14 < size; i14++) {
            View view = this.f9293a.get(i14);
            if (view.getVisibility() != 8 && ((f10 = ((e) view.getLayoutParams()).f()) == null || !f10.onLayoutChild(this, view, v10))) {
                G(view, v10);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x011c, code lost:
    
        if (r0.onMeasureChild(r30, r20, r11, r21, r23, 0) == false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        Behavior f12;
        int childCount = getChildCount();
        boolean z11 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.j(0) && (f12 = eVar.f()) != null) {
                    z11 |= f12.onNestedFling(this, childAt, view, f10, f11, z10);
                }
            }
        }
        if (z11) {
            F(1);
        }
        return z11;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        Behavior f12;
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.j(0) && (f12 = eVar.f()) != null) {
                    z10 |= f12.onNestedPreFling(this, childAt, view, f10, f11);
                }
            }
        }
        return z10;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        onNestedPreScroll(view, i10, i11, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        onNestedScroll(view, i10, i11, i12, i13, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        onNestedScrollAccepted(view, view2, i10, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.f9313a;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id = childAt.getId();
            Behavior f10 = w(childAt).f();
            if (id != -1 && f10 != null && (parcelable2 = sparseArray.get(id)) != null) {
                f10.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id = childAt.getId();
            Behavior f10 = ((e) childAt.getLayoutParams()).f();
            if (id != -1 && f10 != null && (onSaveInstanceState = f10.onSaveInstanceState(this, childAt)) != null) {
                sparseArray.append(id, onSaveInstanceState);
            }
        }
        savedState.f9313a = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return onStartNestedScroll(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r3 != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f9303k
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.J(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2c
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.f9303k
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.e) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.f()
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f9303k
            boolean r6 = r6.onTouchEvent(r0, r7, r1)
        L2c:
            android.view.View r7 = r0.f9303k
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.O(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public List<View> p(View view) {
        List<View> h10 = this.f9294b.h(view);
        this.f9296d.clear();
        if (h10 != null) {
            this.f9296d.addAll(h10);
        }
        return this.f9296d;
    }

    public List<View> q(View view) {
        List g10 = this.f9294b.g(view);
        this.f9296d.clear();
        if (g10 != null) {
            this.f9296d.addAll(g10);
        }
        return this.f9296d;
    }

    public void r(View view, Rect rect) {
        C1698b.a(this, view, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        Behavior f10 = ((e) view.getLayoutParams()).f();
        if (f10 != null && f10.onRequestChildRectangleOnScreen(this, view, rect, z10)) {
            return true;
        }
        return super.requestChildRectangleOnScreen(view, rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (z10 && !this.f9300h) {
            O(false);
            this.f9300h = true;
        }
    }

    public void s(View view, int i10, Rect rect, Rect rect2) {
        e eVar = (e) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        t(view, i10, rect, rect2, eVar, measuredWidth, measuredHeight);
        h(eVar, rect2, measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z10) {
        super.setFitsSystemWindows(z10);
        V();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f9310r = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        boolean z10;
        Drawable drawable2 = this.f9309q;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f9309q = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f9309q.setState(getDrawableState());
                }
                C.a.m(this.f9309q, K.v(this));
                Drawable drawable4 = this.f9309q;
                if (getVisibility() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                drawable4.setVisible(z10, false);
                this.f9309q.setCallback(this);
            }
            K.Z(this);
        }
    }

    public void setStatusBarBackgroundColor(int i10) {
        setStatusBarBackground(new ColorDrawable(i10));
    }

    public void setStatusBarBackgroundResource(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = androidx.core.content.b.e(getContext(), i10);
        } else {
            drawable = null;
        }
        setStatusBarBackground(drawable);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        boolean z10;
        super.setVisibility(i10);
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable = this.f9309q;
        if (drawable != null && drawable.isVisible() != z10) {
            this.f9309q.setVisible(z10, false);
        }
    }

    public final void t(View view, int i10, Rect rect, Rect rect2, e eVar, int i11, int i12) {
        int width;
        int height;
        int b10 = C0455j.b(P(eVar.f9318c), i10);
        int b11 = C0455j.b(Q(eVar.f9319d), i10);
        int i13 = b10 & 7;
        int i14 = b10 & 112;
        int i15 = b11 & 7;
        int i16 = b11 & 112;
        if (i15 != 1) {
            if (i15 != 5) {
                width = rect.left;
            } else {
                width = rect.right;
            }
        } else {
            width = rect.left + (rect.width() / 2);
        }
        if (i16 != 16) {
            if (i16 != 80) {
                height = rect.top;
            } else {
                height = rect.bottom;
            }
        } else {
            height = rect.top + (rect.height() / 2);
        }
        if (i13 != 1) {
            if (i13 != 5) {
                width -= i11;
            }
        } else {
            width -= i11 / 2;
        }
        if (i14 != 16) {
            if (i14 != 80) {
                height -= i12;
            }
        } else {
            height -= i12 / 2;
        }
        rect2.set(width, height, i11 + width, i12 + height);
    }

    public final int u(int i10) {
        int[] iArr = this.f9302j;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i10);
            return 0;
        }
        if (i10 >= 0 && i10 < iArr.length) {
            return iArr[i10];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i10 + " out of range for " + this);
        return 0;
    }

    public void v(View view, Rect rect) {
        rect.set(((e) view.getLayoutParams()).h());
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f9309q) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e w(View view) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.f9317b) {
            if (view instanceof b) {
                Behavior behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                eVar.o(behavior);
                eVar.f9317b = true;
            } else {
                c cVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    cVar = (c) cls.getAnnotation(c.class);
                    if (cVar != null) {
                        break;
                    }
                }
                if (cVar != null) {
                    try {
                        eVar.o(cVar.value().getDeclaredConstructor(null).newInstance(null));
                    } catch (Exception e10) {
                        Log.e("CoordinatorLayout", "Default behavior class " + cVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e10);
                    }
                }
                eVar.f9317b = true;
            }
        }
        return eVar;
    }

    public final void x(List<View> list) {
        int i10;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            if (isChildrenDrawingOrderEnabled) {
                i10 = getChildDrawingOrder(childCount, i11);
            } else {
                i10 = i11;
            }
            list.add(getChildAt(i10));
        }
        Comparator<View> comparator = f9290C;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    public final boolean y(View view) {
        return this.f9294b.j(view);
    }

    public boolean z(View view, int i10, int i11) {
        Rect e10 = e();
        r(view, e10);
        try {
            return e10.contains(i10, i11);
        } finally {
            M(e10);
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray obtainStyledAttributes;
        this.f9293a = new ArrayList();
        this.f9294b = new C1697a<>();
        this.f9295c = new ArrayList();
        this.f9296d = new ArrayList();
        this.f9298f = new int[2];
        this.f9299g = new int[2];
        this.f9312y = new C0469y(this);
        if (i10 == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x.c.f37637b, 0, x.b.f37635a);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x.c.f37637b, i10, 0);
        }
        if (i10 == 0) {
            saveAttributeDataForStyleable(context, x.c.f37637b, attributeSet, obtainStyledAttributes, 0, x.b.f37635a);
        } else {
            saveAttributeDataForStyleable(context, x.c.f37637b, attributeSet, obtainStyledAttributes, i10, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(x.c.f37638c, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f9302j = resources.getIntArray(resourceId);
            float f10 = resources.getDisplayMetrics().density;
            int length = this.f9302j.length;
            for (int i11 = 0; i11 < length; i11++) {
                this.f9302j[i11] = (int) (r12[i11] * f10);
            }
        }
        this.f9309q = obtainStyledAttributes.getDrawable(x.c.f37639d);
        obtainStyledAttributes.recycle();
        V();
        super.setOnHierarchyChangeListener(new d());
        if (K.t(this) == 0) {
            K.t0(this, 1);
        }
    }

    @Override // androidx.core.view.InterfaceC0467w
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        Behavior f10;
        int childCount = getChildCount();
        boolean z10 = false;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.j(i12) && (f10 = eVar.f()) != null) {
                    int[] iArr2 = this.f9298f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f10.onNestedPreScroll(this, childAt, view, i10, i11, iArr2, i12);
                    int[] iArr3 = this.f9298f;
                    i13 = i10 > 0 ? Math.max(i13, iArr3[0]) : Math.min(i13, iArr3[0]);
                    int[] iArr4 = this.f9298f;
                    i14 = i11 > 0 ? Math.max(i14, iArr4[1]) : Math.min(i14, iArr4[1]);
                    z10 = true;
                }
            }
        }
        iArr[0] = i13;
        iArr[1] = i14;
        if (z10) {
            F(1);
        }
    }

    @Override // androidx.core.view.InterfaceC0467w
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        onNestedScroll(view, i10, i11, i12, i13, 0, this.f9299g);
    }

    @Override // androidx.core.view.InterfaceC0467w
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        Behavior f10;
        this.f9312y.c(view, view2, i10, i11);
        this.f9304l = view2;
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.j(i11) && (f10 = eVar.f()) != null) {
                f10.onNestedScrollAccepted(this, childAt, view, view2, i10, i11);
            }
        }
    }

    @Override // androidx.core.view.InterfaceC0467w
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                Behavior f10 = eVar.f();
                if (f10 != null) {
                    boolean onStartNestedScroll = f10.onStartNestedScroll(this, childAt, view, view2, i10, i11);
                    z10 |= onStartNestedScroll;
                    eVar.r(i11, onStartNestedScroll);
                } else {
                    eVar.r(i11, false);
                }
            }
        }
        return z10;
    }

    @Override // androidx.core.view.InterfaceC0467w
    public void onStopNestedScroll(View view, int i10) {
        this.f9312y.e(view, i10);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.j(i10)) {
                Behavior f10 = eVar.f();
                if (f10 != null) {
                    f10.onStopNestedScroll(this, childAt, view, i10);
                }
                eVar.l(i10);
                eVar.k();
            }
        }
        this.f9304l = null;
    }

    @Override // androidx.core.view.InterfaceC0468x
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        Behavior f10;
        boolean z10;
        int min;
        int childCount = getChildCount();
        boolean z11 = false;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.j(i14) && (f10 = eVar.f()) != null) {
                    int[] iArr2 = this.f9298f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f10.onNestedScroll(this, childAt, view, i10, i11, i12, i13, i14, iArr2);
                    int[] iArr3 = this.f9298f;
                    i15 = i12 > 0 ? Math.max(i15, iArr3[0]) : Math.min(i15, iArr3[0]);
                    if (i13 > 0) {
                        z10 = true;
                        min = Math.max(i16, this.f9298f[1]);
                    } else {
                        z10 = true;
                        min = Math.min(i16, this.f9298f[1]);
                    }
                    i16 = min;
                    z11 = z10;
                }
            }
        }
        iArr[0] = iArr[0] + i15;
        iArr[1] = iArr[1] + i16;
        if (z11) {
            F(1);
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public SparseArray<Parcelable> f9313a;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f9313a = new SparseArray<>(readInt);
            for (int i10 = 0; i10 < readInt; i10++) {
                this.f9313a.append(iArr[i10], readParcelableArray[i10]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            int i11;
            super.writeToParcel(parcel, i10);
            SparseArray<Parcelable> sparseArray = this.f9313a;
            if (sparseArray != null) {
                i11 = sparseArray.size();
            } else {
                i11 = 0;
            }
            parcel.writeInt(i11);
            int[] iArr = new int[i11];
            Parcelable[] parcelableArr = new Parcelable[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                iArr[i12] = this.f9313a.keyAt(i12);
                parcelableArr[i12] = this.f9313a.valueAt(i12);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i10);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* loaded from: classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public Behavior f9316a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f9317b;

        /* renamed from: c, reason: collision with root package name */
        public int f9318c;

        /* renamed from: d, reason: collision with root package name */
        public int f9319d;

        /* renamed from: e, reason: collision with root package name */
        public int f9320e;

        /* renamed from: f, reason: collision with root package name */
        public int f9321f;

        /* renamed from: g, reason: collision with root package name */
        public int f9322g;

        /* renamed from: h, reason: collision with root package name */
        public int f9323h;

        /* renamed from: i, reason: collision with root package name */
        public int f9324i;

        /* renamed from: j, reason: collision with root package name */
        public int f9325j;

        /* renamed from: k, reason: collision with root package name */
        public View f9326k;

        /* renamed from: l, reason: collision with root package name */
        public View f9327l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f9328m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f9329n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f9330o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f9331p;

        /* renamed from: q, reason: collision with root package name */
        public final Rect f9332q;

        /* renamed from: r, reason: collision with root package name */
        public Object f9333r;

        public e(int i10, int i11) {
            super(i10, i11);
            this.f9317b = false;
            this.f9318c = 0;
            this.f9319d = 0;
            this.f9320e = -1;
            this.f9321f = -1;
            this.f9322g = 0;
            this.f9323h = 0;
            this.f9332q = new Rect();
        }

        public boolean a() {
            if (this.f9326k == null && this.f9321f != -1) {
                return true;
            }
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            Behavior behavior;
            if (view2 != this.f9327l && !s(view2, K.v(coordinatorLayout)) && ((behavior = this.f9316a) == null || !behavior.layoutDependsOn(coordinatorLayout, view, view2))) {
                return false;
            }
            return true;
        }

        public boolean c() {
            if (this.f9316a == null) {
                this.f9328m = false;
            }
            return this.f9328m;
        }

        public View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f9321f == -1) {
                this.f9327l = null;
                this.f9326k = null;
                return null;
            }
            if (this.f9326k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f9326k;
        }

        public int e() {
            return this.f9321f;
        }

        public Behavior f() {
            return this.f9316a;
        }

        public boolean g() {
            return this.f9331p;
        }

        public Rect h() {
            return this.f9332q;
        }

        public boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z10;
            boolean z11 = this.f9328m;
            if (z11) {
                return true;
            }
            Behavior behavior = this.f9316a;
            if (behavior != null) {
                z10 = behavior.blocksInteractionBelow(coordinatorLayout, view);
            } else {
                z10 = false;
            }
            boolean z12 = z10 | z11;
            this.f9328m = z12;
            return z12;
        }

        public boolean j(int i10) {
            if (i10 != 0) {
                if (i10 != 1) {
                    return false;
                }
                return this.f9330o;
            }
            return this.f9329n;
        }

        public void k() {
            this.f9331p = false;
        }

        public void l(int i10) {
            r(i10, false);
        }

        public void m() {
            this.f9328m = false;
        }

        public final void n(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f9321f);
            this.f9326k = findViewById;
            if (findViewById != null) {
                if (findViewById == coordinatorLayout) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.f9327l = null;
                        this.f9326k = null;
                        return;
                    }
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                    if (parent == view) {
                        if (coordinatorLayout.isInEditMode()) {
                            this.f9327l = null;
                            this.f9326k = null;
                            return;
                        }
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    if (parent instanceof View) {
                        findViewById = parent;
                    }
                }
                this.f9327l = findViewById;
                return;
            }
            if (coordinatorLayout.isInEditMode()) {
                this.f9327l = null;
                this.f9326k = null;
                return;
            }
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f9321f) + " to anchor view " + view);
        }

        public void o(Behavior behavior) {
            Behavior behavior2 = this.f9316a;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.onDetachedFromLayoutParams();
                }
                this.f9316a = behavior;
                this.f9333r = null;
                this.f9317b = true;
                if (behavior != null) {
                    behavior.onAttachedToLayoutParams(this);
                }
            }
        }

        public void p(boolean z10) {
            this.f9331p = z10;
        }

        public void q(Rect rect) {
            this.f9332q.set(rect);
        }

        public void r(int i10, boolean z10) {
            if (i10 != 0) {
                if (i10 == 1) {
                    this.f9330o = z10;
                    return;
                }
                return;
            }
            this.f9329n = z10;
        }

        public final boolean s(View view, int i10) {
            int b10 = C0455j.b(((e) view.getLayoutParams()).f9322g, i10);
            if (b10 != 0 && (C0455j.b(this.f9323h, i10) & b10) == b10) {
                return true;
            }
            return false;
        }

        public final boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f9326k.getId() != this.f9321f) {
                return false;
            }
            View view2 = this.f9326k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent != null && parent != view) {
                    if (parent instanceof View) {
                        view2 = parent;
                    }
                } else {
                    this.f9327l = null;
                    this.f9326k = null;
                    return false;
                }
            }
            this.f9327l = view2;
            return true;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f9317b = false;
            this.f9318c = 0;
            this.f9319d = 0;
            this.f9320e = -1;
            this.f9321f = -1;
            this.f9322g = 0;
            this.f9323h = 0;
            this.f9332q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x.c.f37640e);
            this.f9318c = obtainStyledAttributes.getInteger(x.c.f37641f, 0);
            this.f9321f = obtainStyledAttributes.getResourceId(x.c.f37642g, -1);
            this.f9319d = obtainStyledAttributes.getInteger(x.c.f37643h, 0);
            this.f9320e = obtainStyledAttributes.getInteger(x.c.f37647l, -1);
            this.f9322g = obtainStyledAttributes.getInt(x.c.f37646k, 0);
            this.f9323h = obtainStyledAttributes.getInt(x.c.f37645j, 0);
            int i10 = x.c.f37644i;
            boolean hasValue = obtainStyledAttributes.hasValue(i10);
            this.f9317b = hasValue;
            if (hasValue) {
                this.f9316a = CoordinatorLayout.I(context, attributeSet, obtainStyledAttributes.getString(i10));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.f9316a;
            if (behavior != null) {
                behavior.onAttachedToLayoutParams(this);
            }
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.f9317b = false;
            this.f9318c = 0;
            this.f9319d = 0;
            this.f9320e = -1;
            this.f9321f = -1;
            this.f9322g = 0;
            this.f9323h = 0;
            this.f9332q = new Rect();
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f9317b = false;
            this.f9318c = 0;
            this.f9319d = 0;
            this.f9320e = -1;
            this.f9321f = -1;
            this.f9322g = 0;
            this.f9323h = 0;
            this.f9332q = new Rect();
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f9317b = false;
            this.f9318c = 0;
            this.f9319d = 0;
            this.f9320e = -1;
            this.f9321f = -1;
            this.f9322g = 0;
            this.f9323h = 0;
            this.f9332q = new Rect();
        }
    }
}
