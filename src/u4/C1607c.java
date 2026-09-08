package u4;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.appcompat.widget.K;
import e4.m;
import f.C0991a;

/* compiled from: MaterialResources.java */
/* renamed from: u4.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1607c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        ColorStateList a10;
        if (typedArray.hasValue(i10) && (resourceId = typedArray.getResourceId(i10, 0)) != 0 && (a10 = C0991a.a(context, resourceId)) != null) {
            return a10;
        }
        return typedArray.getColorStateList(i10);
    }

    public static ColorStateList b(Context context, K k10, int i10) {
        int n10;
        ColorStateList a10;
        if (k10.s(i10) && (n10 = k10.n(i10, 0)) != 0 && (a10 = C0991a.a(context, n10)) != null) {
            return a10;
        }
        return k10.c(i10);
    }

    public static int c(TypedValue typedValue) {
        return typedValue.getComplexUnit();
    }

    public static int d(Context context, TypedArray typedArray, int i10, int i11) {
        TypedValue typedValue = new TypedValue();
        if (typedArray.getValue(i10, typedValue) && typedValue.type == 2) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i11);
            obtainStyledAttributes.recycle();
            return dimensionPixelSize;
        }
        return typedArray.getDimensionPixelSize(i10, i11);
    }

    public static Drawable e(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        Drawable b10;
        if (typedArray.hasValue(i10) && (resourceId = typedArray.getResourceId(i10, 0)) != 0 && (b10 = C0991a.b(context, resourceId)) != null) {
            return b10;
        }
        return typedArray.getDrawable(i10);
    }

    public static float f(Context context) {
        return context.getResources().getConfiguration().fontScale;
    }

    public static int g(TypedArray typedArray, int i10, int i11) {
        if (typedArray.hasValue(i10)) {
            return i10;
        }
        return i11;
    }

    public static C1608d h(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        if (typedArray.hasValue(i10) && (resourceId = typedArray.getResourceId(i10, 0)) != 0) {
            return new C1608d(context, resourceId);
        }
        return null;
    }

    public static int i(Context context, int i10, int i11) {
        if (i10 == 0) {
            return i11;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, m.Wa);
        TypedValue typedValue = new TypedValue();
        boolean value = obtainStyledAttributes.getValue(m.Xa, typedValue);
        obtainStyledAttributes.recycle();
        if (!value) {
            return i11;
        }
        if (c(typedValue) == 2) {
            return Math.round(TypedValue.complexToFloat(typedValue.data) * context.getResources().getDisplayMetrics().density);
        }
        return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
    }

    public static boolean j(Context context) {
        if (context.getResources().getConfiguration().fontScale >= 1.3f) {
            return true;
        }
        return false;
    }

    public static boolean k(Context context) {
        if (context.getResources().getConfiguration().fontScale >= 2.0f) {
            return true;
        }
        return false;
    }
}
