package com.oplus.common.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.Settings;
import com.oplus.utils.C0854o;
import j8.C1188a;

/* compiled from: MultiSettings.kt */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: d, reason: collision with root package name */
    public static final d f27760d = new d(null);

    /* renamed from: a, reason: collision with root package name */
    public e f27761a;

    /* renamed from: b, reason: collision with root package name */
    public h f27762b;

    /* renamed from: c, reason: collision with root package name */
    public f f27763c;

    /* compiled from: MultiSettings.kt */
    /* loaded from: classes3.dex */
    public static final class a extends b {

        /* compiled from: MultiSettings.kt */
        /* renamed from: com.oplus.common.data.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0246a extends e {
            public C0246a() {
            }

            @Override // com.oplus.common.data.b.g
            public int c(ContentResolver contentResolver, String str) {
                return C1188a.b.c(contentResolver, str);
            }

            @Override // com.oplus.common.data.b.g
            public int d(ContentResolver contentResolver, String str, int i10) {
                return C1188a.b.d(contentResolver, str, i10);
            }

            @Override // com.oplus.common.data.b.g
            public Uri f(String str) {
                return C1188a.b.h(str);
            }

            @Override // com.oplus.common.data.b.g
            public boolean h(ContentResolver contentResolver, String str, int i10) {
                return C1188a.b.i(contentResolver, str, i10);
            }
        }

        /* compiled from: MultiSettings.kt */
        /* renamed from: com.oplus.common.data.b$a$b, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0247b extends f {
            public C0247b() {
            }

            @Override // com.oplus.common.data.b.g
            public int c(ContentResolver contentResolver, String str) {
                return C1188a.e.c(contentResolver, str);
            }

            @Override // com.oplus.common.data.b.g
            public int d(ContentResolver contentResolver, String str, int i10) {
                return C1188a.e.d(contentResolver, str, i10);
            }

            @Override // com.oplus.common.data.b.g
            public Uri f(String str) {
                return C1188a.e.h(str);
            }

            @Override // com.oplus.common.data.b.g
            public boolean h(ContentResolver contentResolver, String str, int i10) {
                return C1188a.e.i(contentResolver, str, i10);
            }
        }

        /* compiled from: MultiSettings.kt */
        /* loaded from: classes3.dex */
        public final class c extends h {
            public c() {
            }

            @Override // com.oplus.common.data.b.g
            public int c(ContentResolver contentResolver, String str) {
                return C1188a.f.c(contentResolver, str);
            }

            @Override // com.oplus.common.data.b.g
            public int d(ContentResolver contentResolver, String str, int i10) {
                return C1188a.f.d(contentResolver, str, i10);
            }

            @Override // com.oplus.common.data.b.g
            public Uri f(String str) {
                return C1188a.f.h(str);
            }

            @Override // com.oplus.common.data.b.g
            public boolean h(ContentResolver contentResolver, String str, int i10) {
                return C1188a.f.i(contentResolver, str, i10);
            }
        }

        public a() {
            super(null);
        }

        @Override // com.oplus.common.data.b
        public e a() {
            return new C0246a();
        }

        @Override // com.oplus.common.data.b
        public f b() {
            return new C0247b();
        }

        @Override // com.oplus.common.data.b
        public h c() {
            return new c();
        }
    }

    /* compiled from: MultiSettings.kt */
    /* renamed from: com.oplus.common.data.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0248b {

        /* renamed from: a, reason: collision with root package name */
        public static final C0248b f27767a = new C0248b();

        public static final b a(int i10) {
            if (i10 == 2) {
                return new c();
            }
            return new a();
        }
    }

    /* compiled from: MultiSettings.kt */
    /* loaded from: classes3.dex */
    public static final class c extends b {

        /* compiled from: MultiSettings.kt */
        /* loaded from: classes3.dex */
        public final class a extends e {
            public a() {
            }

            @Override // com.oplus.common.data.b.g
            public int c(ContentResolver contentResolver, String str) {
                return Settings.Global.getInt(contentResolver, str);
            }

            @Override // com.oplus.common.data.b.g
            public int d(ContentResolver contentResolver, String str, int i10) {
                return Settings.Global.getInt(contentResolver, str, i10);
            }

            @Override // com.oplus.common.data.b.g
            public Uri f(String str) {
                return Settings.Global.getUriFor(str);
            }

            @Override // com.oplus.common.data.b.g
            public boolean h(ContentResolver contentResolver, String str, int i10) {
                if (C0854o.c(0, 0, 3, null)) {
                    return Settings.Global.putInt(contentResolver, str, i10);
                }
                return O6.a.b(str, i10);
            }
        }

        /* compiled from: MultiSettings.kt */
        /* renamed from: com.oplus.common.data.b$c$b, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0249b extends f {
            public C0249b() {
            }

            @Override // com.oplus.common.data.b.g
            public int c(ContentResolver contentResolver, String str) {
                return Settings.Secure.getInt(contentResolver, str);
            }

            @Override // com.oplus.common.data.b.g
            public int d(ContentResolver contentResolver, String str, int i10) {
                return Settings.Secure.getInt(contentResolver, str, i10);
            }

            @Override // com.oplus.common.data.b.g
            public Uri f(String str) {
                return Settings.Secure.getUriFor(str);
            }

            @Override // com.oplus.common.data.b.g
            public boolean h(ContentResolver contentResolver, String str, int i10) {
                if (C0854o.c(0, 0, 3, null)) {
                    return Settings.Secure.putInt(contentResolver, str, i10);
                }
                return O6.b.a(str, i10);
            }
        }

        /* compiled from: MultiSettings.kt */
        /* renamed from: com.oplus.common.data.b$c$c, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0250c extends h {
            public C0250c() {
            }

            @Override // com.oplus.common.data.b.g
            public int c(ContentResolver contentResolver, String str) {
                return Settings.System.getInt(contentResolver, str);
            }

            @Override // com.oplus.common.data.b.g
            public int d(ContentResolver contentResolver, String str, int i10) {
                return Settings.System.getInt(contentResolver, str, i10);
            }

            @Override // com.oplus.common.data.b.g
            public Uri f(String str) {
                return Settings.System.getUriFor(str);
            }

            @Override // com.oplus.common.data.b.g
            public boolean h(ContentResolver contentResolver, String str, int i10) {
                if (C0854o.c(0, 0, 3, null)) {
                    return Settings.System.putInt(contentResolver, str, i10);
                }
                return O6.c.a(str, i10);
            }
        }

        public c() {
            super(null);
        }

        @Override // com.oplus.common.data.b
        public e a() {
            return new a();
        }

        @Override // com.oplus.common.data.b
        public f b() {
            return new C0249b();
        }

        @Override // com.oplus.common.data.b
        public h c() {
            return new C0250c();
        }
    }

    /* compiled from: MultiSettings.kt */
    /* loaded from: classes3.dex */
    public static final class d {
        public d() {
        }

        public /* synthetic */ d(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: MultiSettings.kt */
    /* loaded from: classes3.dex */
    public static abstract class e extends g {
    }

    /* compiled from: MultiSettings.kt */
    /* loaded from: classes3.dex */
    public static abstract class f extends g {
    }

    /* compiled from: MultiSettings.kt */
    /* loaded from: classes3.dex */
    public static abstract class g {
        public final int a(ContentResolver contentResolver, String str) {
            return c(contentResolver, str);
        }

        public final int b(ContentResolver contentResolver, String str, int i10) {
            try {
                return d(contentResolver, str, i10);
            } catch (Exception unused) {
                return i10;
            }
        }

        public abstract int c(ContentResolver contentResolver, String str);

        public abstract int d(ContentResolver contentResolver, String str, int i10);

        public final Uri e(String str) {
            return f(str);
        }

        public abstract Uri f(String str);

        public final boolean g(ContentResolver contentResolver, String str, int i10) {
            try {
                return h(contentResolver, str, i10);
            } catch (Exception unused) {
                return false;
            }
        }

        public abstract boolean h(ContentResolver contentResolver, String str, int i10);
    }

    /* compiled from: MultiSettings.kt */
    /* loaded from: classes3.dex */
    public static abstract class h extends g {
    }

    public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
        this();
    }

    public abstract e a();

    public abstract f b();

    public abstract h c();

    public b() {
        this.f27761a = a();
        this.f27762b = c();
        this.f27763c = b();
    }
}
