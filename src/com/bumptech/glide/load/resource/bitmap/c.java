package com.bumptech.glide.load.resource.bitmap;

import X2.e;
import Z2.j;
import a3.d;
import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.a;
import java.io.IOException;
import java.io.InputStream;
import s3.C1533d;
import s3.C1538i;

/* compiled from: StreamBitmapDecoder.java */
/* loaded from: classes.dex */
public class c implements e<InputStream, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.resource.bitmap.a f19685a;

    /* renamed from: b, reason: collision with root package name */
    public final a3.b f19686b;

    /* compiled from: StreamBitmapDecoder.java */
    /* loaded from: classes.dex */
    public static class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final RecyclableBufferedInputStream f19687a;

        /* renamed from: b, reason: collision with root package name */
        public final C1533d f19688b;

        public a(RecyclableBufferedInputStream recyclableBufferedInputStream, C1533d c1533d) {
            this.f19687a = recyclableBufferedInputStream;
            this.f19688b = c1533d;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a.b
        public void a() {
            this.f19687a.c();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a.b
        public void b(d dVar, Bitmap bitmap) {
            IOException a10 = this.f19688b.a();
            if (a10 != null) {
                if (bitmap != null) {
                    dVar.c(bitmap);
                    throw a10;
                }
                throw a10;
            }
        }
    }

    public c(com.bumptech.glide.load.resource.bitmap.a aVar, a3.b bVar) {
        this.f19685a = aVar;
        this.f19686b = bVar;
    }

    @Override // X2.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public j<Bitmap> b(InputStream inputStream, int i10, int i11, X2.d dVar) {
        boolean z10;
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z10 = false;
        } else {
            z10 = true;
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f19686b);
        }
        C1533d c10 = C1533d.c(recyclableBufferedInputStream);
        try {
            return this.f19685a.f(new C1538i(c10), i10, i11, dVar, new a(recyclableBufferedInputStream, c10));
        } finally {
            c10.e();
            if (z10) {
                recyclableBufferedInputStream.e();
            }
        }
    }

    @Override // X2.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, X2.d dVar) {
        return this.f19685a.p(inputStream);
    }
}
