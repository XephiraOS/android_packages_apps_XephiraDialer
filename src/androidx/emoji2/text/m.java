package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import java.nio.ByteBuffer;

/* compiled from: MetadataRepo.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final O.b f9824a;

    /* renamed from: b, reason: collision with root package name */
    public final char[] f9825b;

    /* renamed from: c, reason: collision with root package name */
    public final a f9826c = new a(1024);

    /* renamed from: d, reason: collision with root package name */
    public final Typeface f9827d;

    /* compiled from: MetadataRepo.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final SparseArray<a> f9828a;

        /* renamed from: b, reason: collision with root package name */
        public o f9829b;

        public a() {
            this(1);
        }

        public a a(int i10) {
            SparseArray<a> sparseArray = this.f9828a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i10);
        }

        public final o b() {
            return this.f9829b;
        }

        public void c(o oVar, int i10, int i11) {
            a a10 = a(oVar.b(i10));
            if (a10 == null) {
                a10 = new a();
                this.f9828a.put(oVar.b(i10), a10);
            }
            if (i11 > i10) {
                a10.c(oVar, i10 + 1, i11);
            } else {
                a10.f9829b = oVar;
            }
        }

        public a(int i10) {
            this.f9828a = new SparseArray<>(i10);
        }
    }

    public m(Typeface typeface, O.b bVar) {
        this.f9827d = typeface;
        this.f9824a = bVar;
        this.f9825b = new char[bVar.k() * 2];
        a(bVar);
    }

    public static m b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            F.h.a("EmojiCompat.MetadataRepo.create");
            return new m(typeface, l.b(byteBuffer));
        } finally {
            F.h.b();
        }
    }

    public final void a(O.b bVar) {
        int k10 = bVar.k();
        for (int i10 = 0; i10 < k10; i10++) {
            o oVar = new o(this, i10);
            Character.toChars(oVar.f(), this.f9825b, i10 * 2);
            h(oVar);
        }
    }

    public char[] c() {
        return this.f9825b;
    }

    public O.b d() {
        return this.f9824a;
    }

    public int e() {
        return this.f9824a.l();
    }

    public a f() {
        return this.f9826c;
    }

    public Typeface g() {
        return this.f9827d;
    }

    public void h(o oVar) {
        boolean z10;
        I.h.f(oVar, "emoji metadata cannot be null");
        if (oVar.c() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        I.h.b(z10, "invalid metadata codepoint length");
        this.f9826c.c(oVar, 0, oVar.c() - 1);
    }
}
