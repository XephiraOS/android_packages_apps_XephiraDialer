package x4;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: AbsoluteCornerSize.java */
/* renamed from: x4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1679a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final float f37887a;

    public C1679a(float f10) {
        this.f37887a = f10;
    }

    @Override // x4.d
    public float a(RectF rectF) {
        return this.f37887a;
    }

    public float b() {
        return this.f37887a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof C1679a) && this.f37887a == ((C1679a) obj).f37887a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f37887a)});
    }
}
