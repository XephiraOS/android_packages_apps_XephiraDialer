package x4;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: ClampedCornerSize.java */
/* loaded from: classes3.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final float f37890a;

    public c(float f10) {
        this.f37890a = f10;
    }

    public static c b(C1679a c1679a) {
        return new c(c1679a.b());
    }

    public static float c(RectF rectF) {
        return Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
    }

    @Override // x4.d
    public float a(RectF rectF) {
        return Math.min(this.f37890a, c(rectF));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof c) && this.f37890a == ((c) obj).f37890a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f37890a)});
    }
}
