package j4;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: MultiBrowseCarouselStrategy.java */
/* loaded from: classes3.dex */
public final class j extends f {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f33869d = {1};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f33870e = {1, 0};

    /* renamed from: c, reason: collision with root package name */
    public int f33871c = 0;

    @Override // j4.f
    public com.google.android.material.carousel.b g(b bVar, View view) {
        float b10 = bVar.b();
        if (bVar.d()) {
            b10 = bVar.a();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f10 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (bVar.d()) {
            f10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f11 = f10;
        float d10 = d() + f11;
        float max = Math.max(c() + f11, d10);
        float min = Math.min(measuredHeight + f11, b10);
        float a10 = E.a.a((measuredHeight / 3.0f) + f11, d10 + f11, max + f11);
        float f12 = (min + a10) / 2.0f;
        int[] iArr = f33869d;
        if (b10 < 2.0f * d10) {
            iArr = new int[]{0};
        }
        int[] iArr2 = f33870e;
        if (bVar.c() == 1) {
            iArr = f.a(iArr);
            iArr2 = f.a(iArr2);
        }
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int max2 = (int) Math.max(1.0d, Math.floor(((b10 - (com.google.android.material.carousel.a.i(iArr4) * f12)) - (com.google.android.material.carousel.a.i(iArr3) * max)) / min));
        int ceil = (int) Math.ceil(b10 / min);
        int i10 = (ceil - max2) + 1;
        int[] iArr5 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr5[i11] = ceil - i11;
        }
        C1162a c10 = C1162a.c(b10, a10, d10, max, iArr3, f12, iArr4, min, iArr5);
        this.f33871c = c10.e();
        if (i(c10, bVar.getItemCount())) {
            c10 = C1162a.c(b10, a10, d10, max, new int[]{c10.f33855c}, f12, new int[]{c10.f33856d}, min, new int[]{c10.f33859g});
        }
        return com.google.android.material.carousel.a.d(view.getContext(), f11, b10, c10, bVar.c());
    }

    @Override // j4.f
    public boolean h(b bVar, int i10) {
        if ((i10 < this.f33871c && bVar.getItemCount() >= this.f33871c) || (i10 >= this.f33871c && bVar.getItemCount() < this.f33871c)) {
            return true;
        }
        return false;
    }

    public boolean i(C1162a c1162a, int i10) {
        boolean z10;
        int e10 = c1162a.e() - i10;
        if (e10 > 0 && (c1162a.f33855c > 0 || c1162a.f33856d > 1)) {
            z10 = true;
        } else {
            z10 = false;
        }
        while (e10 > 0) {
            int i11 = c1162a.f33855c;
            if (i11 > 0) {
                c1162a.f33855c = i11 - 1;
            } else {
                int i12 = c1162a.f33856d;
                if (i12 > 1) {
                    c1162a.f33856d = i12 - 1;
                }
            }
            e10--;
        }
        return z10;
    }
}
