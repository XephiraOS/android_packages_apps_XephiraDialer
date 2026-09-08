package G9;

import kotlin.collections.C1228i;

/* compiled from: Segment.kt */
/* loaded from: classes4.dex */
public final class l {

    /* renamed from: h, reason: collision with root package name */
    public static final a f1152h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f1153a;

    /* renamed from: b, reason: collision with root package name */
    public int f1154b;

    /* renamed from: c, reason: collision with root package name */
    public int f1155c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1156d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1157e;

    /* renamed from: f, reason: collision with root package name */
    public l f1158f;

    /* renamed from: g, reason: collision with root package name */
    public l f1159g;

    /* compiled from: Segment.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public l() {
        this.f1153a = new byte[8192];
        this.f1157e = true;
        this.f1156d = false;
    }

    public final void a() {
        int i10;
        l lVar = this.f1159g;
        if (lVar != this) {
            kotlin.jvm.internal.i.c(lVar);
            if (!lVar.f1157e) {
                return;
            }
            int i11 = this.f1155c - this.f1154b;
            l lVar2 = this.f1159g;
            kotlin.jvm.internal.i.c(lVar2);
            int i12 = 8192 - lVar2.f1155c;
            l lVar3 = this.f1159g;
            kotlin.jvm.internal.i.c(lVar3);
            if (lVar3.f1156d) {
                i10 = 0;
            } else {
                l lVar4 = this.f1159g;
                kotlin.jvm.internal.i.c(lVar4);
                i10 = lVar4.f1154b;
            }
            if (i11 > i12 + i10) {
                return;
            }
            l lVar5 = this.f1159g;
            kotlin.jvm.internal.i.c(lVar5);
            f(lVar5, i11);
            b();
            m.b(this);
            return;
        }
        throw new IllegalStateException("cannot compact".toString());
    }

    public final l b() {
        l lVar = this.f1158f;
        if (lVar == this) {
            lVar = null;
        }
        l lVar2 = this.f1159g;
        kotlin.jvm.internal.i.c(lVar2);
        lVar2.f1158f = this.f1158f;
        l lVar3 = this.f1158f;
        kotlin.jvm.internal.i.c(lVar3);
        lVar3.f1159g = this.f1159g;
        this.f1158f = null;
        this.f1159g = null;
        return lVar;
    }

    public final l c(l segment) {
        kotlin.jvm.internal.i.f(segment, "segment");
        segment.f1159g = this;
        segment.f1158f = this.f1158f;
        l lVar = this.f1158f;
        kotlin.jvm.internal.i.c(lVar);
        lVar.f1159g = segment;
        this.f1158f = segment;
        return segment;
    }

    public final l d() {
        this.f1156d = true;
        return new l(this.f1153a, this.f1154b, this.f1155c, true, false);
    }

    public final l e(int i10) {
        l c10;
        if (i10 > 0 && i10 <= this.f1155c - this.f1154b) {
            if (i10 >= 1024) {
                c10 = d();
            } else {
                c10 = m.c();
                byte[] bArr = this.f1153a;
                byte[] bArr2 = c10.f1153a;
                int i11 = this.f1154b;
                C1228i.k(bArr, bArr2, 0, i11, i11 + i10, 2, null);
            }
            c10.f1155c = c10.f1154b + i10;
            this.f1154b += i10;
            l lVar = this.f1159g;
            kotlin.jvm.internal.i.c(lVar);
            lVar.c(c10);
            return c10;
        }
        throw new IllegalArgumentException("byteCount out of range".toString());
    }

    public final void f(l sink, int i10) {
        kotlin.jvm.internal.i.f(sink, "sink");
        if (sink.f1157e) {
            int i11 = sink.f1155c;
            if (i11 + i10 > 8192) {
                if (!sink.f1156d) {
                    int i12 = sink.f1154b;
                    if ((i11 + i10) - i12 <= 8192) {
                        byte[] bArr = sink.f1153a;
                        C1228i.k(bArr, bArr, 0, i12, i11, 2, null);
                        sink.f1155c -= sink.f1154b;
                        sink.f1154b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.f1153a;
            byte[] bArr3 = sink.f1153a;
            int i13 = sink.f1155c;
            int i14 = this.f1154b;
            C1228i.g(bArr2, bArr3, i13, i14, i14 + i10);
            sink.f1155c += i10;
            this.f1154b += i10;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    public l(byte[] data, int i10, int i11, boolean z10, boolean z11) {
        kotlin.jvm.internal.i.f(data, "data");
        this.f1153a = data;
        this.f1154b = i10;
        this.f1155c = i11;
        this.f1156d = z10;
        this.f1157e = z11;
    }
}
