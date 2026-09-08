package l3;

import Z2.j;
import android.graphics.Bitmap;
import h3.C1078b;
import java.io.ByteArrayOutputStream;

/* compiled from: BitmapBytesTranscoder.java */
/* renamed from: l3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1290a implements e<Bitmap, byte[]> {

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap.CompressFormat f34677a;

    /* renamed from: b, reason: collision with root package name */
    public final int f34678b;

    public C1290a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // l3.e
    public j<byte[]> a(j<Bitmap> jVar, X2.d dVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        jVar.get().compress(this.f34677a, this.f34678b, byteArrayOutputStream);
        jVar.b();
        return new C1078b(byteArrayOutputStream.toByteArray());
    }

    public C1290a(Bitmap.CompressFormat compressFormat, int i10) {
        this.f34677a = compressFormat;
        this.f34678b = i10;
    }
}
