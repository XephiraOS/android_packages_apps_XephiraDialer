package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: MetadataListReader.java */
/* loaded from: classes.dex */
public class l {

    /* compiled from: MetadataListReader.java */
    /* loaded from: classes.dex */
    public static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f9821a;

        public a(ByteBuffer byteBuffer) {
            this.f9821a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.l.c
        public int a() {
            return this.f9821a.getInt();
        }

        @Override // androidx.emoji2.text.l.c
        public void b(int i10) {
            ByteBuffer byteBuffer = this.f9821a;
            byteBuffer.position(byteBuffer.position() + i10);
        }

        @Override // androidx.emoji2.text.l.c
        public long c() {
            return l.c(this.f9821a.getInt());
        }

        @Override // androidx.emoji2.text.l.c
        public long getPosition() {
            return this.f9821a.position();
        }

        @Override // androidx.emoji2.text.l.c
        public int readUnsignedShort() {
            return l.d(this.f9821a.getShort());
        }
    }

    /* compiled from: MetadataListReader.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final long f9822a;

        /* renamed from: b, reason: collision with root package name */
        public final long f9823b;

        public b(long j10, long j11) {
            this.f9822a = j10;
            this.f9823b = j11;
        }

        public long a() {
            return this.f9822a;
        }
    }

    /* compiled from: MetadataListReader.java */
    /* loaded from: classes.dex */
    public interface c {
        int a();

        void b(int i10);

        long c();

        long getPosition();

        int readUnsignedShort();
    }

    public static b a(c cVar) {
        long j10;
        cVar.b(4);
        int readUnsignedShort = cVar.readUnsignedShort();
        if (readUnsignedShort <= 100) {
            cVar.b(6);
            int i10 = 0;
            while (true) {
                if (i10 < readUnsignedShort) {
                    int a10 = cVar.a();
                    cVar.b(4);
                    j10 = cVar.c();
                    cVar.b(4);
                    if (1835365473 == a10) {
                        break;
                    }
                    i10++;
                } else {
                    j10 = -1;
                    break;
                }
            }
            if (j10 != -1) {
                cVar.b((int) (j10 - cVar.getPosition()));
                cVar.b(12);
                long c10 = cVar.c();
                for (int i11 = 0; i11 < c10; i11++) {
                    int a11 = cVar.a();
                    long c11 = cVar.c();
                    long c12 = cVar.c();
                    if (1164798569 == a11 || 1701669481 == a11) {
                        return new b(c11 + j10, c12);
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    public static O.b b(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) a(new a(duplicate)).a());
        return O.b.h(duplicate);
    }

    public static long c(int i10) {
        return i10 & 4294967295L;
    }

    public static int d(short s10) {
        return s10 & 65535;
    }
}
