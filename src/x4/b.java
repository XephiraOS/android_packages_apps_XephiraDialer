package x4;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: AdjustedCornerSize.java */
/* loaded from: classes3.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public final d f37888a;

    /* renamed from: b, reason: collision with root package name */
    public final float f37889b;

    public b(float f10, d dVar) {
        while (dVar instanceof b) {
            dVar = ((b) dVar).f37888a;
            f10 += ((b) dVar).f37889b;
        }
        this.f37888a = dVar;
        this.f37889b = f10;
    }

    @Override // x4.d
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f37888a.a(rectF) + this.f37889b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f37888a.equals(bVar.f37888a) && this.f37889b == bVar.f37889b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f37888a, Float.valueOf(this.f37889b)});
    }
}
