package l3;

import Z2.j;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import g3.C1043e;

/* compiled from: DrawableBytesTranscoder.java */
/* loaded from: classes.dex */
public final class c implements e<Drawable, byte[]> {

    /* renamed from: a, reason: collision with root package name */
    public final a3.d f34680a;

    /* renamed from: b, reason: collision with root package name */
    public final e<Bitmap, byte[]> f34681b;

    /* renamed from: c, reason: collision with root package name */
    public final e<k3.c, byte[]> f34682c;

    public c(a3.d dVar, e<Bitmap, byte[]> eVar, e<k3.c, byte[]> eVar2) {
        this.f34680a = dVar;
        this.f34681b = eVar;
        this.f34682c = eVar2;
    }

    @Override // l3.e
    public j<byte[]> a(j<Drawable> jVar, X2.d dVar) {
        Drawable drawable = jVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f34681b.a(C1043e.f(((BitmapDrawable) drawable).getBitmap(), this.f34680a), dVar);
        }
        if (drawable instanceof k3.c) {
            return this.f34682c.a(b(jVar), dVar);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static j<k3.c> b(j<Drawable> jVar) {
        return jVar;
    }
}
