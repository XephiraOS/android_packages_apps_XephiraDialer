package l4;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.b;
import u4.C1606b;

/* compiled from: MaterialColors.java */
/* renamed from: l4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1292a {
    public static int a(int i10, int i11) {
        return B.a.w(i10, (Color.alpha(i10) * i11) / 255);
    }

    public static int b(Context context, int i10, int i11) {
        Integer f10 = f(context, i10);
        if (f10 != null) {
            return f10.intValue();
        }
        return i11;
    }

    public static int c(Context context, int i10, String str) {
        return l(context, C1606b.e(context, i10, str));
    }

    public static int d(View view, int i10) {
        return l(view.getContext(), C1606b.f(view, i10));
    }

    public static int e(View view, int i10, int i11) {
        return b(view.getContext(), i10, i11);
    }

    public static Integer f(Context context, int i10) {
        TypedValue a10 = C1606b.a(context, i10);
        if (a10 != null) {
            return Integer.valueOf(l(context, a10));
        }
        return null;
    }

    public static ColorStateList g(Context context, int i10) {
        TypedValue a10 = C1606b.a(context, i10);
        if (a10 == null) {
            return null;
        }
        int i11 = a10.resourceId;
        if (i11 != 0) {
            return b.d(context, i11);
        }
        int i12 = a10.data;
        if (i12 == 0) {
            return null;
        }
        return ColorStateList.valueOf(i12);
    }

    public static boolean h(int i10) {
        if (i10 != 0 && B.a.k(i10) > 0.5d) {
            return true;
        }
        return false;
    }

    public static int i(int i10, int i11) {
        return B.a.q(i11, i10);
    }

    public static int j(int i10, int i11, float f10) {
        return i(i10, B.a.w(i11, Math.round(Color.alpha(i11) * f10)));
    }

    public static int k(View view, int i10, int i11, float f10) {
        return j(d(view, i10), d(view, i11), f10);
    }

    public static int l(Context context, TypedValue typedValue) {
        int i10 = typedValue.resourceId;
        if (i10 != 0) {
            return b.c(context, i10);
        }
        return typedValue.data;
    }
}
