package i3;

import Z2.j;
import android.graphics.drawable.Drawable;

/* compiled from: NonOwnedDrawableResource.java */
/* renamed from: i3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1095d extends AbstractC1094c<Drawable> {
    public C1095d(Drawable drawable) {
        super(drawable);
    }

    public static j<Drawable> f(Drawable drawable) {
        if (drawable != null) {
            return new C1095d(drawable);
        }
        return null;
    }

    @Override // Z2.j
    public int c() {
        return Math.max(1, this.f32155a.getIntrinsicWidth() * this.f32155a.getIntrinsicHeight() * 4);
    }

    @Override // Z2.j
    public Class<Drawable> d() {
        return this.f32155a.getClass();
    }

    @Override // Z2.j
    public void b() {
    }
}
