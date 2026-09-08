package l9;

/* compiled from: PerfMark.java */
/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final C1299a f34788a;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r1 = 0
            java.lang.String r2 = "io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> Lb
            r3 = r1
            goto Le
        Lb:
            r2 = move-exception
            r3 = r2
            r2 = r1
        Le:
            if (r2 == 0) goto L2f
            java.lang.Class<l9.a> r4 = l9.C1299a.class
            java.lang.Class r2 = r2.asSubclass(r4)     // Catch: java.lang.Throwable -> L2d
            java.lang.Class<l9.d> r4 = l9.d.class
            java.lang.Class[] r4 = new java.lang.Class[]{r4}     // Catch: java.lang.Throwable -> L2d
            java.lang.reflect.Constructor r2 = r2.getConstructor(r4)     // Catch: java.lang.Throwable -> L2d
            l9.d r4 = l9.C1299a.f34785a     // Catch: java.lang.Throwable -> L2d
            java.lang.Object[] r4 = new java.lang.Object[]{r4}     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r2 = r2.newInstance(r4)     // Catch: java.lang.Throwable -> L2d
            l9.a r2 = (l9.C1299a) r2     // Catch: java.lang.Throwable -> L2d
            goto L30
        L2d:
            r2 = move-exception
            r3 = r2
        L2f:
            r2 = r1
        L30:
            if (r2 == 0) goto L35
            l9.c.f34788a = r2
            goto L3e
        L35:
            l9.a r2 = new l9.a
            l9.d r4 = l9.C1299a.f34785a
            r2.<init>(r4)
            l9.c.f34788a = r2
        L3e:
            if (r3 == 0) goto L8b
            java.lang.String r2 = "io.perfmark.PerfMark.debug"
            boolean r2 = java.lang.Boolean.getBoolean(r2)     // Catch: java.lang.Throwable -> L8b
            if (r2 == 0) goto L8b
            java.lang.String r2 = "java.util.logging.Logger"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L8b
            java.lang.String r4 = "getLogger"
            java.lang.Class[] r5 = new java.lang.Class[]{r0}     // Catch: java.lang.Throwable -> L8b
            java.lang.reflect.Method r4 = r2.getMethod(r4, r5)     // Catch: java.lang.Throwable -> L8b
            java.lang.Class<l9.c> r5 = l9.c.class
            java.lang.String r5 = r5.getName()     // Catch: java.lang.Throwable -> L8b
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch: java.lang.Throwable -> L8b
            java.lang.Object r4 = r4.invoke(r1, r5)     // Catch: java.lang.Throwable -> L8b
            java.lang.String r5 = "java.util.logging.Level"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch: java.lang.Throwable -> L8b
            java.lang.String r6 = "FINE"
            java.lang.reflect.Field r6 = r5.getField(r6)     // Catch: java.lang.Throwable -> L8b
            java.lang.Object r1 = r6.get(r1)     // Catch: java.lang.Throwable -> L8b
            java.lang.String r6 = "log"
            java.lang.Class<java.lang.Throwable> r7 = java.lang.Throwable.class
            java.lang.Class[] r0 = new java.lang.Class[]{r5, r0, r7}     // Catch: java.lang.Throwable -> L8b
            java.lang.reflect.Method r0 = r2.getMethod(r6, r0)     // Catch: java.lang.Throwable -> L8b
            java.lang.String r2 = "Error during PerfMark.<clinit>"
            java.lang.Object[] r1 = new java.lang.Object[]{r1, r2, r3}     // Catch: java.lang.Throwable -> L8b
            r0.invoke(r4, r1)     // Catch: java.lang.Throwable -> L8b
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.c.<clinit>():void");
    }

    public static void a(d dVar) {
        f34788a.a(dVar);
    }

    public static d b(String str, long j10) {
        return f34788a.b(str, j10);
    }

    public static void c(String str, d dVar) {
        f34788a.c(str, dVar);
    }

    public static void d(C1300b c1300b) {
        f34788a.d(c1300b);
    }

    public static C1300b e() {
        return f34788a.e();
    }

    public static void f() {
        f34788a.g();
    }

    public static e g(String str) {
        f34788a.f(str);
        return e.f34791a;
    }
}
