package x4;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: RelativeCornerSize.java */
/* loaded from: classes3.dex */
public final class l implements d {

    /* renamed from: a, reason: collision with root package name */
    public final float f37920a;

    public l(float f10) {
        this.f37920a = f10;
    }

    private static float b(RectF rectF) {
        return Math.min(rectF.width(), rectF.height());
    }

    @Override // x4.d
    public float a(RectF rectF) {
        return this.f37920a * b(rectF);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof l) && this.f37920a == ((l) obj).f37920a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f37920a)});
    }
}
