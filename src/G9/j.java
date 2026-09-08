package G9;

/* compiled from: PeekSource.kt */
/* loaded from: classes4.dex */
public final class j implements n {

    /* renamed from: a, reason: collision with root package name */
    public final d f1142a;

    /* renamed from: b, reason: collision with root package name */
    public final b f1143b;

    /* renamed from: c, reason: collision with root package name */
    public l f1144c;

    /* renamed from: d, reason: collision with root package name */
    public int f1145d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1146e;

    /* renamed from: f, reason: collision with root package name */
    public long f1147f;

    public j(d upstream) {
        int i10;
        kotlin.jvm.internal.i.f(upstream, "upstream");
        this.f1142a = upstream;
        b w10 = upstream.w();
        this.f1143b = w10;
        l lVar = w10.f1127a;
        this.f1144c = lVar;
        if (lVar != null) {
            i10 = lVar.f1154b;
        } else {
            i10 = -1;
        }
        this.f1145d = i10;
    }

    @Override // G9.n, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        this.f1146e = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if (r3 == r4.f1154b) goto L15;
     */
    @Override // G9.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long z(G9.b r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.i.f(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L7f
            boolean r3 = r8.f1146e
            r3 = r3 ^ 1
            if (r3 == 0) goto L73
            G9.l r3 = r8.f1144c
            if (r3 == 0) goto L31
            G9.b r4 = r8.f1143b
            G9.l r4 = r4.f1127a
            if (r3 != r4) goto L25
            int r3 = r8.f1145d
            kotlin.jvm.internal.i.c(r4)
            int r4 = r4.f1154b
            if (r3 != r4) goto L25
            goto L31
        L25:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Peek source is invalid because upstream source was used"
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L31:
            if (r2 != 0) goto L34
            return r0
        L34:
            G9.d r0 = r8.f1142a
            long r1 = r8.f1147f
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.W(r1)
            if (r0 != 0) goto L44
            r8 = -1
            return r8
        L44:
            G9.l r0 = r8.f1144c
            if (r0 != 0) goto L57
            G9.b r0 = r8.f1143b
            G9.l r0 = r0.f1127a
            if (r0 == 0) goto L57
            r8.f1144c = r0
            kotlin.jvm.internal.i.c(r0)
            int r0 = r0.f1154b
            r8.f1145d = r0
        L57:
            G9.b r0 = r8.f1143b
            long r0 = r0.U()
            long r2 = r8.f1147f
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            G9.b r2 = r8.f1143b
            long r4 = r8.f1147f
            r3 = r9
            r6 = r10
            r2.f(r3, r4, r6)
            long r0 = r8.f1147f
            long r0 = r0 + r10
            r8.f1147f = r0
            return r10
        L73:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "closed"
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L7f:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "byteCount < 0: "
            r8.append(r9)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: G9.j.z(G9.b, long):long");
    }
}
