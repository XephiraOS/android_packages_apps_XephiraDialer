package s4;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import com.oplus.backup.sdk.common.utils.Constants;
import u4.C1606b;

/* compiled from: MotionUtils.java */
/* renamed from: s4.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1550i {
    public static float a(String[] strArr, int i10) {
        float parseFloat = Float.parseFloat(strArr[i10]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    public static String b(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    public static TimeInterpolator c(String str) {
        if (e(str, "cubic-bezier")) {
            String[] split = b(str, "cubic-bezier").split(",");
            if (split.length == 4) {
                return K.a.a(a(split, 0), a(split, 1), a(split, 2), a(split, 3));
            }
            throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
        }
        if (e(str, Constants.MessagerConstants.PATH_KEY)) {
            return K.a.b(B.d.e(b(str, Constants.MessagerConstants.PATH_KEY)));
        }
        throw new IllegalArgumentException("Invalid motion easing type: " + str);
    }

    public static boolean d(String str) {
        if (!e(str, "cubic-bezier") && !e(str, Constants.MessagerConstants.PATH_KEY)) {
            return false;
        }
        return true;
    }

    public static boolean e(String str, String str2) {
        if (str.startsWith(str2 + "(") && str.endsWith(")")) {
            return true;
        }
        return false;
    }

    public static int f(Context context, int i10, int i11) {
        return C1606b.c(context, i10, i11);
    }

    public static TimeInterpolator g(Context context, int i10, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type == 3) {
            String valueOf = String.valueOf(typedValue.string);
            if (d(valueOf)) {
                return c(valueOf);
            }
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
    }
}
