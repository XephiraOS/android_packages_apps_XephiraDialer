package v4;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.StateSet;

/* compiled from: RippleUtils.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f37396a = true;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f37397b = {16842919};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f37398c = {16843623, 16842908};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f37399d = {16842908};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f37400e = {16843623};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f37401f = {16842913, 16842919};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f37402g = {16842913, 16843623, 16842908};

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f37403h = {16842913, 16842908};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f37404i = {16842913, 16843623};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f37405j = {16842913};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f37406k = {16842910, 16842919};

    /* renamed from: l, reason: collision with root package name */
    public static final String f37407l = b.class.getSimpleName();

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f37396a) {
            int[] iArr = f37399d;
            return new ColorStateList(new int[][]{f37405j, iArr, StateSet.NOTHING}, new int[]{c(colorStateList, f37401f), c(colorStateList, iArr), c(colorStateList, f37397b)});
        }
        int[] iArr2 = f37401f;
        int[] iArr3 = f37402g;
        int[] iArr4 = f37403h;
        int[] iArr5 = f37404i;
        int[] iArr6 = f37397b;
        int[] iArr7 = f37398c;
        int[] iArr8 = f37399d;
        int[] iArr9 = f37400e;
        return new ColorStateList(new int[][]{iArr2, iArr3, iArr4, iArr5, f37405j, iArr6, iArr7, iArr8, iArr9, StateSet.NOTHING}, new int[]{c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), c(colorStateList, iArr5), 0, c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), c(colorStateList, iArr9), 0});
    }

    public static int b(int i10) {
        return B.a.w(i10, Math.min(Color.alpha(i10) * 2, 255));
    }

    public static int c(ColorStateList colorStateList, int[] iArr) {
        int i10;
        if (colorStateList != null) {
            i10 = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        } else {
            i10 = 0;
        }
        if (f37396a) {
            return b(i10);
        }
        return i10;
    }

    public static ColorStateList d(ColorStateList colorStateList) {
        if (colorStateList != null) {
            return colorStateList;
        }
        return ColorStateList.valueOf(0);
    }

    public static boolean e(int[] iArr) {
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 : iArr) {
            if (i10 == 16842910) {
                z10 = true;
            } else if (i10 == 16842908 || i10 == 16842919 || i10 == 16843623) {
                z11 = true;
            }
        }
        if (!z10 || !z11) {
            return false;
        }
        return true;
    }
}
