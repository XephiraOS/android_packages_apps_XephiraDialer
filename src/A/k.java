package A;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: TypedArrayUtils.java */
/* loaded from: classes.dex */
public class k {
    public static int a(Context context, int i10, int i11) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i10, typedValue, true);
        if (typedValue.resourceId != 0) {
            return i10;
        }
        return i11;
    }

    public static boolean b(TypedArray typedArray, int i10, int i11, boolean z10) {
        return typedArray.getBoolean(i10, typedArray.getBoolean(i11, z10));
    }

    public static Drawable c(TypedArray typedArray, int i10, int i11) {
        Drawable drawable = typedArray.getDrawable(i10);
        if (drawable == null) {
            return typedArray.getDrawable(i11);
        }
        return drawable;
    }

    public static int d(TypedArray typedArray, int i10, int i11, int i12) {
        return typedArray.getInt(i10, typedArray.getInt(i11, i12));
    }

    public static boolean e(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10, boolean z10) {
        if (!r(xmlPullParser, str)) {
            return z10;
        }
        return typedArray.getBoolean(i10, z10);
    }

    public static int f(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10, int i11) {
        if (!r(xmlPullParser, str)) {
            return i11;
        }
        return typedArray.getColor(i10, i11);
    }

    public static ColorStateList g(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i10) {
        if (r(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i10, typedValue);
            int i11 = typedValue.type;
            if (i11 != 2) {
                if (i11 >= 28 && i11 <= 31) {
                    return h(typedValue);
                }
                return c.d(typedArray.getResources(), typedArray.getResourceId(i10, 0), theme);
            }
            throw new UnsupportedOperationException("Failed to resolve attribute at index " + i10 + ": " + typedValue);
        }
        return null;
    }

    public static ColorStateList h(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static d i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i10, int i11) {
        if (r(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i10, typedValue);
            int i12 = typedValue.type;
            if (i12 >= 28 && i12 <= 31) {
                return d.b(typedValue.data);
            }
            d g10 = d.g(typedArray.getResources(), typedArray.getResourceId(i10, 0), theme);
            if (g10 != null) {
                return g10;
            }
        }
        return d.b(i11);
    }

    public static float j(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10, float f10) {
        if (!r(xmlPullParser, str)) {
            return f10;
        }
        return typedArray.getFloat(i10, f10);
    }

    public static int k(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10, int i11) {
        if (!r(xmlPullParser, str)) {
            return i11;
        }
        return typedArray.getInt(i10, i11);
    }

    public static int l(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10, int i11) {
        if (!r(xmlPullParser, str)) {
            return i11;
        }
        return typedArray.getResourceId(i10, i11);
    }

    public static String m(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10) {
        if (!r(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i10);
    }

    public static int n(TypedArray typedArray, int i10, int i11, int i12) {
        return typedArray.getResourceId(i10, typedArray.getResourceId(i11, i12));
    }

    public static String o(TypedArray typedArray, int i10, int i11) {
        String string = typedArray.getString(i10);
        if (string == null) {
            return typedArray.getString(i11);
        }
        return string;
    }

    public static CharSequence p(TypedArray typedArray, int i10, int i11) {
        CharSequence text = typedArray.getText(i10);
        if (text == null) {
            return typedArray.getText(i11);
        }
        return text;
    }

    public static CharSequence[] q(TypedArray typedArray, int i10, int i11) {
        CharSequence[] textArray = typedArray.getTextArray(i10);
        if (textArray == null) {
            return typedArray.getTextArray(i11);
        }
        return textArray;
    }

    public static boolean r(XmlPullParser xmlPullParser, String str) {
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null) {
            return true;
        }
        return false;
    }

    public static TypedArray s(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
