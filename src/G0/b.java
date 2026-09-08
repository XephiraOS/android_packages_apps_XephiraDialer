package G0;

import M7.b;
import android.content.Context;
import android.net.Uri;
import kotlin.Result;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.f;
import m9.q;

/* compiled from: SettingsApiImpl.kt */
/* loaded from: classes.dex */
public final class b implements G0.a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f1084b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public int f1085a = 2;

    /* compiled from: SettingsApiImpl.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    @Override // G0.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(android.content.Context r3, int r4, java.lang.String r5, int r6) {
        /*
            r2 = this;
            kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
            r0.<init>()
            kotlin.Result$a r1 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L1c
            if (r3 == 0) goto L26
            M7.b$g r2 = r2.i(r4)     // Catch: java.lang.Throwable -> L1c
            if (r2 == 0) goto L1e
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L1c
            boolean r2 = r2.d(r3, r5, r6)     // Catch: java.lang.Throwable -> L1c
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L1c
            goto L1f
        L1c:
            r2 = move-exception
            goto L30
        L1e:
            r2 = 0
        L1f:
            if (r2 == 0) goto L26
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L1c
            goto L27
        L26:
            r2 = 0
        L27:
            r0.element = r2     // Catch: java.lang.Throwable -> L1c
            m9.q r2 = m9.q.f35511a     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r2 = kotlin.Result.b(r2)     // Catch: java.lang.Throwable -> L1c
            goto L3a
        L30:
            kotlin.Result$a r3 = kotlin.Result.f34166a
            java.lang.Object r2 = kotlin.b.a(r2)
            java.lang.Object r2 = kotlin.Result.b(r2)
        L3a:
            java.lang.Throwable r2 = kotlin.Result.d(r2)
            if (r2 == 0) goto L56
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "putInt error = "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "SettingsApiImpl"
            H7.b.c(r3, r2)
        L56:
            boolean r2 = r0.element
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: G0.b.a(android.content.Context, int, java.lang.String, int):boolean");
    }

    @Override // G0.a
    public Uri b(int i10, String str) {
        Object b10;
        Uri uri = null;
        try {
            Result.a aVar = Result.f34166a;
            b.g i11 = i(i10);
            if (i11 != null) {
                uri = i11.b(str);
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("SettingsApiImpl", "getUriFor error = " + d10);
        }
        return uri;
    }

    @Override // G0.a
    public int c(Context context, int i10, String str, int i11) {
        Object b10;
        Integer num;
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        int i12 = -1;
        ref$IntRef.element = -1;
        try {
            Result.a aVar = Result.f34166a;
            if (context != null) {
                b.g i13 = i(i10);
                if (i13 != null) {
                    num = Integer.valueOf(i13.a(context.getContentResolver(), str, i11));
                } else {
                    num = null;
                }
                if (num != null) {
                    i12 = num.intValue();
                }
            }
            ref$IntRef.element = i12;
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("SettingsApiImpl", "getInt error = " + d10);
        }
        return ref$IntRef.element;
    }

    @Override // G0.a
    public long d(Context context, int i10, String str, long j10) {
        Object b10;
        Long l10;
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        long j11 = -1;
        ref$LongRef.element = -1L;
        try {
            Result.a aVar = Result.f34166a;
            if (context != null) {
                b.g i11 = i(i10);
                if (i11 != null) {
                    l10 = Long.valueOf(i11.c(context.getContentResolver(), str, j10));
                } else {
                    l10 = null;
                }
                if (l10 != null) {
                    j11 = l10.longValue();
                }
            }
            ref$LongRef.element = j11;
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("SettingsApiImpl", "getLong error = " + d10);
        }
        return ref$LongRef.element;
    }

    @Override // G0.a
    public float e(Context context, int i10, String str, float f10) {
        Object b10;
        Float f11;
        Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        float f12 = -1.0f;
        ref$FloatRef.element = -1.0f;
        try {
            Result.a aVar = Result.f34166a;
            if (context != null) {
                b.g i11 = i(i10);
                if (i11 != null) {
                    f11 = Float.valueOf(i11.f(context.getContentResolver(), str, f10));
                } else {
                    f11 = null;
                }
                if (f11 != null) {
                    f12 = f11.floatValue();
                }
            }
            ref$FloatRef.element = f12;
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("SettingsApiImpl", "getFloat error = " + d10);
        }
        return ref$FloatRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // G0.a
    public String f(Context context, int i10, String str) {
        Object b10;
        String str2;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        String str3 = "";
        ref$ObjectRef.element = "";
        try {
            Result.a aVar = Result.f34166a;
            T t10 = str3;
            if (context != null) {
                b.g i11 = i(i10);
                if (i11 != null) {
                    str2 = i11.e(context.getContentResolver(), str);
                } else {
                    str2 = null;
                }
                t10 = str2 == null ? str3 : str2;
            }
            ref$ObjectRef.element = t10;
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("SettingsApiImpl", "getString error = " + d10);
        }
        return (String) ref$ObjectRef.element;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    @Override // G0.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g(android.content.Context r3, int r4, java.lang.String r5, long r6) {
        /*
            r2 = this;
            kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
            r0.<init>()
            kotlin.Result$a r1 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L1c
            if (r3 == 0) goto L26
            M7.b$g r2 = r2.i(r4)     // Catch: java.lang.Throwable -> L1c
            if (r2 == 0) goto L1e
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L1c
            boolean r2 = r2.g(r3, r5, r6)     // Catch: java.lang.Throwable -> L1c
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L1c
            goto L1f
        L1c:
            r2 = move-exception
            goto L30
        L1e:
            r2 = 0
        L1f:
            if (r2 == 0) goto L26
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L1c
            goto L27
        L26:
            r2 = 0
        L27:
            r0.element = r2     // Catch: java.lang.Throwable -> L1c
            m9.q r2 = m9.q.f35511a     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r2 = kotlin.Result.b(r2)     // Catch: java.lang.Throwable -> L1c
            goto L3a
        L30:
            kotlin.Result$a r3 = kotlin.Result.f34166a
            java.lang.Object r2 = kotlin.b.a(r2)
            java.lang.Object r2 = kotlin.Result.b(r2)
        L3a:
            java.lang.Throwable r2 = kotlin.Result.d(r2)
            if (r2 == 0) goto L56
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "putLong error = "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "SettingsApiImpl"
            H7.b.c(r3, r2)
        L56:
            boolean r2 = r0.element
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: G0.b.g(android.content.Context, int, java.lang.String, long):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    @Override // G0.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean h(android.content.Context r3, int r4, java.lang.String r5, java.lang.String r6) {
        /*
            r2 = this;
            kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
            r0.<init>()
            kotlin.Result$a r1 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L1c
            if (r3 == 0) goto L26
            M7.b$g r2 = r2.i(r4)     // Catch: java.lang.Throwable -> L1c
            if (r2 == 0) goto L1e
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L1c
            boolean r2 = r2.h(r3, r5, r6)     // Catch: java.lang.Throwable -> L1c
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L1c
            goto L1f
        L1c:
            r2 = move-exception
            goto L30
        L1e:
            r2 = 0
        L1f:
            if (r2 == 0) goto L26
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L1c
            goto L27
        L26:
            r2 = 0
        L27:
            r0.element = r2     // Catch: java.lang.Throwable -> L1c
            m9.q r2 = m9.q.f35511a     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r2 = kotlin.Result.b(r2)     // Catch: java.lang.Throwable -> L1c
            goto L3a
        L30:
            kotlin.Result$a r3 = kotlin.Result.f34166a
            java.lang.Object r2 = kotlin.b.a(r2)
            java.lang.Object r2 = kotlin.Result.b(r2)
        L3a:
            java.lang.Throwable r2 = kotlin.Result.d(r2)
            if (r2 == 0) goto L56
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "putString error = "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "SettingsApiImpl"
            H7.b.c(r3, r2)
        L56:
            boolean r2 = r0.element
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: G0.b.h(android.content.Context, int, java.lang.String, java.lang.String):boolean");
    }

    public final b.g i(int i10) {
        M7.b a10 = b.C0045b.a(this.f1085a);
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    return null;
                }
                return a10.f1799c;
            }
            return a10.f1797a;
        }
        return a10.f1798b;
    }

    public void j(int i10) {
        this.f1085a = i10;
    }
}
