package g3;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;

/* compiled from: BitmapDrawableEncoder.java */
/* renamed from: g3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1040b implements X2.f<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    public final a3.d f31841a;

    /* renamed from: b, reason: collision with root package name */
    public final X2.f<Bitmap> f31842b;

    public C1040b(a3.d dVar, X2.f<Bitmap> fVar) {
        this.f31841a = dVar;
        this.f31842b = fVar;
    }

    @Override // X2.f
    public EncodeStrategy a(X2.d dVar) {
        return this.f31842b.a(dVar);
    }

    @Override // X2.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean b(Z2.j<BitmapDrawable> jVar, File file, X2.d dVar) {
        return this.f31842b.b(new C1043e(jVar.get().getBitmap(), this.f31841a), file, dVar);
    }
}
