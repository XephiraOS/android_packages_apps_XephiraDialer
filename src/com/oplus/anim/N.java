package com.oplus.anim;

import android.content.Context;
import i6.C1103b;
import java.io.File;

/* compiled from: L.java */
/* loaded from: classes3.dex */
public class N {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f25816a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f25817b = true;

    /* renamed from: c, reason: collision with root package name */
    public static String[] f25818c;

    /* renamed from: d, reason: collision with root package name */
    public static long[] f25819d;

    /* renamed from: e, reason: collision with root package name */
    public static int f25820e;

    /* renamed from: f, reason: collision with root package name */
    public static int f25821f;

    /* renamed from: g, reason: collision with root package name */
    public static i6.e f25822g;

    /* renamed from: h, reason: collision with root package name */
    public static i6.d f25823h;

    /* renamed from: i, reason: collision with root package name */
    public static volatile i6.g f25824i;

    /* renamed from: j, reason: collision with root package name */
    public static volatile i6.f f25825j;

    /* compiled from: L.java */
    /* loaded from: classes3.dex */
    public class a implements i6.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f25826a;

        public a(Context context) {
            this.f25826a = context;
        }

        @Override // i6.d
        public File a() {
            return new File(this.f25826a.getCacheDir(), "anim_network_cache");
        }
    }

    public static void a(String str) {
        if (!f25816a) {
            return;
        }
        int i10 = f25820e;
        if (i10 == 20) {
            f25821f++;
            return;
        }
        f25818c[i10] = str;
        f25819d[i10] = System.nanoTime();
        F.h.a(str);
        f25820e++;
    }

    public static float b(String str) {
        int i10 = f25821f;
        if (i10 > 0) {
            f25821f = i10 - 1;
            return 0.0f;
        }
        if (!f25816a) {
            return 0.0f;
        }
        int i11 = f25820e - 1;
        f25820e = i11;
        if (i11 != -1) {
            if (str.equals(f25818c[i11])) {
                F.h.b();
                return ((float) (System.nanoTime() - f25819d[f25820e])) / 1000000.0f;
            }
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f25818c[f25820e] + ".");
        }
        throw new IllegalStateException("Can't end trace section. There are none.");
    }

    public static i6.f c(Context context) {
        if (!f25817b) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        i6.f fVar = f25825j;
        if (fVar == null) {
            synchronized (i6.f.class) {
                try {
                    fVar = f25825j;
                    if (fVar == null) {
                        i6.d dVar = f25823h;
                        if (dVar == null) {
                            dVar = new a(applicationContext);
                        }
                        fVar = new i6.f(dVar);
                        f25825j = fVar;
                    }
                } finally {
                }
            }
        }
        return fVar;
    }

    public static i6.g d(Context context) {
        i6.g gVar = f25824i;
        if (gVar == null) {
            synchronized (i6.g.class) {
                try {
                    gVar = f25824i;
                    if (gVar == null) {
                        i6.f c10 = c(context);
                        i6.e eVar = f25822g;
                        if (eVar == null) {
                            eVar = new C1103b();
                        }
                        gVar = new i6.g(c10, eVar);
                        f25824i = gVar;
                    }
                } finally {
                }
            }
        }
        return gVar;
    }
}
