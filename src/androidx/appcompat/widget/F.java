package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* compiled from: ThemeUtils.java */
/* loaded from: classes.dex */
public class F {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f7703a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f7704b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f7705c = {16842908};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f7706d = {R.attr.state_activated};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f7707e = {16842919};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f7708f = {R.attr.state_checked};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f7709g = {16842913};

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f7710h = {-16842919, -16842908};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f7711i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f7712j = new int[1];

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(e.j.f30283A0);
        try {
            if (!obtainStyledAttributes.hasValue(e.j.f30308F0)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i10) {
        ColorStateList e10 = e(context, i10);
        if (e10 != null && e10.isStateful()) {
            return e10.getColorForState(f7704b, e10.getDefaultColor());
        }
        TypedValue f10 = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, f10, true);
        return d(context, i10, f10.getFloat());
    }

    public static int c(Context context, int i10) {
        int[] iArr = f7712j;
        iArr[0] = i10;
        K v10 = K.v(context, null, iArr);
        try {
            return v10.b(0, 0);
        } finally {
            v10.y();
        }
    }

    public static int d(Context context, int i10, float f10) {
        return B.a.w(c(context, i10), Math.round(Color.alpha(r0) * f10));
    }

    public static ColorStateList e(Context context, int i10) {
        int[] iArr = f7712j;
        iArr[0] = i10;
        K v10 = K.v(context, null, iArr);
        try {
            return v10.c(0);
        } finally {
            v10.y();
        }
    }

    public static TypedValue f() {
        ThreadLocal<TypedValue> threadLocal = f7703a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }
}
