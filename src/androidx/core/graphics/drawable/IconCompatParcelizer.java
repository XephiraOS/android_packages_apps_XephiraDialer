package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import k0.AbstractC1206a;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(AbstractC1206a abstractC1206a) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f9413a = abstractC1206a.p(iconCompat.f9413a, 1);
        iconCompat.f9415c = abstractC1206a.j(iconCompat.f9415c, 2);
        iconCompat.f9416d = abstractC1206a.r(iconCompat.f9416d, 3);
        iconCompat.f9417e = abstractC1206a.p(iconCompat.f9417e, 4);
        iconCompat.f9418f = abstractC1206a.p(iconCompat.f9418f, 5);
        iconCompat.f9419g = (ColorStateList) abstractC1206a.r(iconCompat.f9419g, 6);
        iconCompat.f9421i = abstractC1206a.t(iconCompat.f9421i, 7);
        iconCompat.f9422j = abstractC1206a.t(iconCompat.f9422j, 8);
        iconCompat.b();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, AbstractC1206a abstractC1206a) {
        abstractC1206a.x(true, true);
        iconCompat.c(abstractC1206a.f());
        int i10 = iconCompat.f9413a;
        if (-1 != i10) {
            abstractC1206a.F(i10, 1);
        }
        byte[] bArr = iconCompat.f9415c;
        if (bArr != null) {
            abstractC1206a.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f9416d;
        if (parcelable != null) {
            abstractC1206a.H(parcelable, 3);
        }
        int i11 = iconCompat.f9417e;
        if (i11 != 0) {
            abstractC1206a.F(i11, 4);
        }
        int i12 = iconCompat.f9418f;
        if (i12 != 0) {
            abstractC1206a.F(i12, 5);
        }
        ColorStateList colorStateList = iconCompat.f9419g;
        if (colorStateList != null) {
            abstractC1206a.H(colorStateList, 6);
        }
        String str = iconCompat.f9421i;
        if (str != null) {
            abstractC1206a.J(str, 7);
        }
        String str2 = iconCompat.f9422j;
        if (str2 != null) {
            abstractC1206a.J(str2, 8);
        }
    }
}
