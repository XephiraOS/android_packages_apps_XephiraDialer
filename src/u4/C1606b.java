package u4;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;

/* compiled from: MaterialAttributes.java */
/* renamed from: u4.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1606b {
    public static TypedValue a(Context context, int i10) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(Context context, int i10, boolean z10) {
        TypedValue a10 = a(context, i10);
        if (a10 != null && a10.type == 18) {
            if (a10.data != 0) {
                return true;
            }
            return false;
        }
        return z10;
    }

    public static int c(Context context, int i10, int i11) {
        TypedValue a10 = a(context, i10);
        if (a10 != null && a10.type == 16) {
            return a10.data;
        }
        return i11;
    }

    public static int d(Context context, int i10, String str) {
        return e(context, i10, str).data;
    }

    public static TypedValue e(Context context, int i10, String str) {
        TypedValue a10 = a(context, i10);
        if (a10 != null) {
            return a10;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i10)));
    }

    public static TypedValue f(View view, int i10) {
        return e(view.getContext(), i10, view.getClass().getCanonicalName());
    }
}
