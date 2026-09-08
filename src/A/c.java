package A;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import com.coui.appcompat.uiutil.UIUtil;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import z.C1718a;
import z.C1720c;

/* compiled from: ColorStateListInflaterCompat.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f14a = new ThreadLocal<>();

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return e(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    public static TypedValue c() {
        ThreadLocal<TypedValue> threadLocal = f14a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    public static ColorStateList d(Resources resources, int i10, Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i10), theme);
        } catch (Exception e10) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e10);
            return null;
        }
    }

    public static ColorStateList e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int color;
        float f10;
        Resources resources2 = resources;
        int i10 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20];
        int[] iArr2 = new int[20];
        int i11 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i10 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray h10 = h(resources2, theme, attributeSet, C1720c.f38220b);
                int i12 = C1720c.f38221c;
                int resourceId = h10.getResourceId(i12, -1);
                if (resourceId != -1 && !f(resources2, resourceId)) {
                    try {
                        color = a(resources2, resources2.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception unused) {
                        color = h10.getColor(C1720c.f38221c, -65281);
                    }
                } else {
                    color = h10.getColor(i12, -65281);
                }
                int i13 = C1720c.f38222d;
                float f11 = 1.0f;
                if (h10.hasValue(i13)) {
                    f11 = h10.getFloat(i13, 1.0f);
                } else {
                    int i14 = C1720c.f38224f;
                    if (h10.hasValue(i14)) {
                        f11 = h10.getFloat(i14, 1.0f);
                    }
                }
                int i15 = C1720c.f38223e;
                if (h10.hasValue(i15)) {
                    f10 = h10.getFloat(i15, -1.0f);
                } else {
                    f10 = h10.getFloat(C1720c.f38225g, -1.0f);
                }
                h10.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i16 = 0;
                for (int i17 = 0; i17 < attributeCount; i17++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i17);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != C1718a.f38159a && attributeNameResource != C1718a.f38160b) {
                        int i18 = i16 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i17, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr3[i16] = attributeNameResource;
                        i16 = i18;
                    }
                }
                int[] trimStateSet = StateSet.trimStateSet(iArr3, i16);
                iArr2 = g.a(iArr2, i11, g(color, f11, f10));
                iArr = (int[][]) g.b(iArr, i11, trimStateSet);
                i11++;
            }
            i10 = 1;
            resources2 = resources;
        }
        int[] iArr4 = new int[i11];
        int[][] iArr5 = new int[i11];
        System.arraycopy(iArr2, 0, iArr4, 0, i11);
        System.arraycopy(iArr, 0, iArr5, 0, i11);
        return new ColorStateList(iArr5, iArr4);
    }

    public static boolean f(Resources resources, int i10) {
        TypedValue c10 = c();
        resources.getValue(i10, c10, true);
        int i11 = c10.type;
        if (i11 >= 28 && i11 <= 31) {
            return true;
        }
        return false;
    }

    public static int g(int i10, float f10, float f11) {
        boolean z10;
        if (f11 >= 0.0f && f11 <= 100.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (f10 == 1.0f && !z10) {
            return i10;
        }
        int b10 = E.a.b((int) ((Color.alpha(i10) * f10) + 0.5f), 0, 255);
        if (z10) {
            a c10 = a.c(i10);
            i10 = a.m(c10.j(), c10.i(), f11);
        }
        return (i10 & UIUtil.CONSTANT_COLOR_MASK) | (b10 << 24);
    }

    public static TypedArray h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
