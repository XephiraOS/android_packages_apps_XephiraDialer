package M7;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.Settings;
import j8.C1188a;

/* compiled from: MultiSettings.kt */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: d, reason: collision with root package name */
    public static final c f1796d = new c(null);

    /* renamed from: a, reason: collision with root package name */
    public e f1797a;

    /* renamed from: b, reason: collision with root package name */
    public h f1798b;

    /* renamed from: c, reason: collision with root package name */
    public f f1799c;

    /* compiled from: MultiSettings.kt */
    /* loaded from: classes3.dex */
    public static final class a extends b {

        /* compiled from: MultiSettings.kt */
        /* renamed from: M7.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0043a implements e {
            public C0043a() {
            }

            @Override // M7.b.g
            public int a(ContentResolver contentResolver, String str, int i10) {
                return C1188a.b.d(contentResolver, str, i10);
            }

            @Override // M7.b.g
            public Uri b(String str) {
                return C1188a.b.h(str);
            }

            @Override // M7.b.g
            public long c(ContentResolver contentResolver, String str, long j10) {
                return C1188a.b.e(contentResolver, str, j10);
            }

            @Override // M7.b.g
            public boolean d(ContentResolver contentResolver, String str, int i10) {
                return C1188a.b.i(contentResolver, str, i10);
            }

            @Override // M7.b.g
            public String e(ContentResolver contentResolver, String str) {
                return C1188a.b.f(contentResolver, str);
            }

            @Override // M7.b.g
            public float f(ContentResolver contentResolver, String str, float f10) {
                return C1188a.b.b(contentResolver, str, f10);
            }

            @Override // M7.b.g
            public boolean g(ContentResolver contentResolver, String str, long j10) {
                return C1188a.b.j(contentResolver, str, j10);
            }

            @Override // M7.b.g
            public boolean h(ContentResolver contentResolver, String str, String str2) {
                return C1188a.b.k(contentResolver, str, str2);
            }
        }

        /* compiled from: MultiSettings.kt */
        /* renamed from: M7.b$a$b, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0044b implements f {
            public C0044b() {
            }

            @Override // M7.b.g
            public int a(ContentResolver contentResolver, String str, int i10) {
                return C1188a.e.d(contentResolver, str, i10);
            }

            @Override // M7.b.g
            public Uri b(String str) {
                return C1188a.e.h(str);
            }

            @Override // M7.b.g
            public long c(ContentResolver contentResolver, String str, long j10) {
                return C1188a.e.e(contentResolver, str, j10);
            }

            @Override // M7.b.g
            public boolean d(ContentResolver contentResolver, String str, int i10) {
                return C1188a.e.i(contentResolver, str, i10);
            }

            @Override // M7.b.g
            public String e(ContentResolver contentResolver, String str) {
                return C1188a.e.f(contentResolver, str);
            }

            @Override // M7.b.g
            public float f(ContentResolver contentResolver, String str, float f10) {
                return C1188a.e.b(contentResolver, str, f10);
            }

            @Override // M7.b.g
            public boolean g(ContentResolver contentResolver, String str, long j10) {
                return C1188a.e.j(contentResolver, str, j10);
            }

            @Override // M7.b.g
            public boolean h(ContentResolver contentResolver, String str, String str2) {
                return C1188a.e.k(contentResolver, str, str2);
            }
        }

        /* compiled from: MultiSettings.kt */
        /* loaded from: classes3.dex */
        public final class c implements h {
            public c() {
            }

            @Override // M7.b.g
            public int a(ContentResolver contentResolver, String str, int i10) {
                return C1188a.f.d(contentResolver, str, i10);
            }

            @Override // M7.b.g
            public Uri b(String str) {
                return C1188a.f.h(str);
            }

            @Override // M7.b.g
            public long c(ContentResolver contentResolver, String str, long j10) {
                return C1188a.f.e(contentResolver, str, j10);
            }

            @Override // M7.b.g
            public boolean d(ContentResolver contentResolver, String str, int i10) {
                return C1188a.f.i(contentResolver, str, i10);
            }

            @Override // M7.b.g
            public String e(ContentResolver contentResolver, String str) {
                return C1188a.f.f(contentResolver, str);
            }

            @Override // M7.b.g
            public float f(ContentResolver contentResolver, String str, float f10) {
                return C1188a.f.b(contentResolver, str, f10);
            }

            @Override // M7.b.g
            public boolean g(ContentResolver contentResolver, String str, long j10) {
                return C1188a.f.j(contentResolver, str, j10);
            }

            @Override // M7.b.g
            public boolean h(ContentResolver contentResolver, String str, String str2) {
                return C1188a.f.k(contentResolver, str, str2);
            }
        }

        public a() {
            super(null);
        }

        @Override // M7.b
        public e a() {
            return new C0043a();
        }

        @Override // M7.b
        public f b() {
            return new C0044b();
        }

        @Override // M7.b
        public h c() {
            return new c();
        }
    }

    /* compiled from: MultiSettings.kt */
    /* renamed from: M7.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0045b {

        /* renamed from: a, reason: collision with root package name */
        public static final C0045b f1803a = new C0045b();

        public static final b a(int i10) {
            if (i10 == 2) {
                return new d();
            }
            return new a();
        }
    }

    /* compiled from: MultiSettings.kt */
    /* loaded from: classes3.dex */
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: MultiSettings.kt */
    /* loaded from: classes3.dex */
    public static final class d extends b {

        /* compiled from: MultiSettings.kt */
        /* loaded from: classes3.dex */
        public final class a implements e {
            public a() {
            }

            @Override // M7.b.g
            public int a(ContentResolver contentResolver, String str, int i10) {
                return Settings.Global.getInt(contentResolver, str, i10);
            }

            @Override // M7.b.g
            public Uri b(String str) {
                return Settings.Global.getUriFor(str);
            }

            @Override // M7.b.g
            public long c(ContentResolver contentResolver, String str, long j10) {
                return Settings.Global.getLong(contentResolver, str, j10);
            }

            @Override // M7.b.g
            public boolean d(ContentResolver contentResolver, String str, int i10) {
                if (C7.b.a(30, 1)) {
                    return Settings.Global.putInt(contentResolver, str, i10);
                }
                return O6.a.b(str, i10);
            }

            @Override // M7.b.g
            public String e(ContentResolver contentResolver, String str) {
                return Settings.Global.getString(contentResolver, str);
            }

            @Override // M7.b.g
            public float f(ContentResolver contentResolver, String str, float f10) {
                return Settings.Global.getFloat(contentResolver, str, f10);
            }

            @Override // M7.b.g
            public boolean g(ContentResolver contentResolver, String str, long j10) {
                if (C7.b.a(30, 1)) {
                    return Settings.Global.putLong(contentResolver, str, j10);
                }
                return O6.a.c(str, j10);
            }

            @Override // M7.b.g
            public boolean h(ContentResolver contentResolver, String str, String str2) {
                if (C7.b.a(30, 1)) {
                    return Settings.Global.putString(contentResolver, str, str2);
                }
                return O6.a.d(str, str2);
            }
        }

        /* compiled from: MultiSettings.kt */
        /* renamed from: M7.b$d$b, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0046b implements f {
            public C0046b() {
            }

            @Override // M7.b.g
            public int a(ContentResolver contentResolver, String str, int i10) {
                return Settings.Secure.getInt(contentResolver, str, i10);
            }

            @Override // M7.b.g
            public Uri b(String str) {
                return Settings.Secure.getUriFor(str);
            }

            @Override // M7.b.g
            public long c(ContentResolver contentResolver, String str, long j10) {
                return Settings.Secure.getLong(contentResolver, str, j10);
            }

            @Override // M7.b.g
            public boolean d(ContentResolver contentResolver, String str, int i10) {
                if (C7.b.a(30, 1)) {
                    return Settings.Secure.putInt(contentResolver, str, i10);
                }
                return O6.b.a(str, i10);
            }

            @Override // M7.b.g
            public String e(ContentResolver contentResolver, String str) {
                return Settings.Secure.getString(contentResolver, str);
            }

            @Override // M7.b.g
            public float f(ContentResolver contentResolver, String str, float f10) {
                return Settings.Secure.getFloat(contentResolver, str, f10);
            }

            @Override // M7.b.g
            public boolean g(ContentResolver contentResolver, String str, long j10) {
                if (C7.b.a(30, 1)) {
                    return Settings.Secure.putLong(contentResolver, str, j10);
                }
                return O6.b.b(str, j10);
            }

            @Override // M7.b.g
            public boolean h(ContentResolver contentResolver, String str, String str2) {
                if (C7.b.a(30, 1)) {
                    return Settings.Secure.putString(contentResolver, str, str2);
                }
                return O6.b.c(str, str2);
            }
        }

        /* compiled from: MultiSettings.kt */
        /* loaded from: classes3.dex */
        public final class c implements h {
            public c() {
            }

            @Override // M7.b.g
            public int a(ContentResolver contentResolver, String str, int i10) {
                return Settings.System.getInt(contentResolver, str, i10);
            }

            @Override // M7.b.g
            public Uri b(String str) {
                return Settings.System.getUriFor(str);
            }

            @Override // M7.b.g
            public long c(ContentResolver contentResolver, String str, long j10) {
                return Settings.System.getLong(contentResolver, str, j10);
            }

            @Override // M7.b.g
            public boolean d(ContentResolver contentResolver, String str, int i10) {
                if (C7.b.a(30, 1)) {
                    return Settings.System.putInt(contentResolver, str, i10);
                }
                return O6.c.a(str, i10);
            }

            @Override // M7.b.g
            public String e(ContentResolver contentResolver, String str) {
                return Settings.System.getString(contentResolver, str);
            }

            @Override // M7.b.g
            public float f(ContentResolver contentResolver, String str, float f10) {
                return Settings.System.getFloat(contentResolver, str, f10);
            }

            @Override // M7.b.g
            public boolean g(ContentResolver contentResolver, String str, long j10) {
                if (C7.b.a(30, 1)) {
                    return Settings.System.putLong(contentResolver, str, j10);
                }
                return O6.c.b(str, j10);
            }

            @Override // M7.b.g
            public boolean h(ContentResolver contentResolver, String str, String str2) {
                if (C7.b.a(30, 1)) {
                    return Settings.System.putString(contentResolver, str, str2);
                }
                return O6.c.c(str, str2);
            }
        }

        public d() {
            super(null);
        }

        @Override // M7.b
        public e a() {
            return new a();
        }

        @Override // M7.b
        public f b() {
            return new C0046b();
        }

        @Override // M7.b
        public h c() {
            return new c();
        }
    }

    /* compiled from: MultiSettings.kt */
    /* loaded from: classes3.dex */
    public interface e extends g {
    }

    /* compiled from: MultiSettings.kt */
    /* loaded from: classes3.dex */
    public interface f extends g {
    }

    /* compiled from: MultiSettings.kt */
    /* loaded from: classes3.dex */
    public interface g {
        int a(ContentResolver contentResolver, String str, int i10);

        Uri b(String str);

        long c(ContentResolver contentResolver, String str, long j10);

        boolean d(ContentResolver contentResolver, String str, int i10);

        String e(ContentResolver contentResolver, String str);

        float f(ContentResolver contentResolver, String str, float f10);

        boolean g(ContentResolver contentResolver, String str, long j10);

        boolean h(ContentResolver contentResolver, String str, String str2);
    }

    /* compiled from: MultiSettings.kt */
    /* loaded from: classes3.dex */
    public interface h extends g {
    }

    public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
        this();
    }

    public abstract e a();

    public abstract f b();

    public abstract h c();

    public b() {
        this.f1797a = a();
        this.f1798b = c();
        this.f1799c = b();
    }
}
