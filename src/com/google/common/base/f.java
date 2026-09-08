package com.google.common.base;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* compiled from: MoreObjects.java */
/* loaded from: classes3.dex */
public final class f {

    /* compiled from: MoreObjects.java */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f24311a;

        /* renamed from: b, reason: collision with root package name */
        public final C0218b f24312b;

        /* renamed from: c, reason: collision with root package name */
        public C0218b f24313c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f24314d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f24315e;

        /* compiled from: MoreObjects.java */
        /* loaded from: classes3.dex */
        public static final class a extends C0218b {
            public a() {
                super();
            }
        }

        /* compiled from: MoreObjects.java */
        /* renamed from: com.google.common.base.f$b$b, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0218b {

            /* renamed from: a, reason: collision with root package name */
            public String f24316a;

            /* renamed from: b, reason: collision with root package name */
            public Object f24317b;

            /* renamed from: c, reason: collision with root package name */
            public C0218b f24318c;

            public C0218b() {
            }
        }

        public static boolean l(Object obj) {
            if (obj instanceof CharSequence) {
                if (((CharSequence) obj).length() != 0) {
                    return false;
                }
                return true;
            }
            if (obj instanceof Collection) {
                return ((Collection) obj).isEmpty();
            }
            if (obj instanceof Map) {
                return ((Map) obj).isEmpty();
            }
            if (obj instanceof Optional) {
                return !((Optional) obj).c();
            }
            if (!obj.getClass().isArray() || Array.getLength(obj) != 0) {
                return false;
            }
            return true;
        }

        public b a(String str, double d10) {
            return j(str, String.valueOf(d10));
        }

        public b b(String str, int i10) {
            return j(str, String.valueOf(i10));
        }

        public b c(String str, long j10) {
            return j(str, String.valueOf(j10));
        }

        public b d(String str, Object obj) {
            return h(str, obj);
        }

        public b e(String str, boolean z10) {
            return j(str, String.valueOf(z10));
        }

        public final C0218b f() {
            C0218b c0218b = new C0218b();
            this.f24313c.f24318c = c0218b;
            this.f24313c = c0218b;
            return c0218b;
        }

        public final b g(Object obj) {
            f().f24317b = obj;
            return this;
        }

        public final b h(String str, Object obj) {
            C0218b f10 = f();
            f10.f24317b = obj;
            f10.f24316a = (String) k.o(str);
            return this;
        }

        public final a i() {
            a aVar = new a();
            this.f24313c.f24318c = aVar;
            this.f24313c = aVar;
            return aVar;
        }

        public final b j(String str, Object obj) {
            a i10 = i();
            i10.f24317b = obj;
            i10.f24316a = (String) k.o(str);
            return this;
        }

        public b k(Object obj) {
            return g(obj);
        }

        public b m() {
            this.f24314d = true;
            return this;
        }

        public String toString() {
            boolean z10 = this.f24314d;
            boolean z11 = this.f24315e;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f24311a);
            sb.append('{');
            String str = "";
            for (C0218b c0218b = this.f24312b.f24318c; c0218b != null; c0218b = c0218b.f24318c) {
                Object obj = c0218b.f24317b;
                if (!(c0218b instanceof a)) {
                    if (obj == null) {
                        if (z10) {
                        }
                    } else if (z11 && l(obj)) {
                    }
                }
                sb.append(str);
                String str2 = c0218b.f24316a;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append('=');
                }
                if (obj != null && obj.getClass().isArray()) {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                } else {
                    sb.append(obj);
                }
                str = ", ";
            }
            sb.append('}');
            return sb.toString();
        }

        public b(String str) {
            C0218b c0218b = new C0218b();
            this.f24312b = c0218b;
            this.f24313c = c0218b;
            this.f24314d = false;
            this.f24315e = false;
            this.f24311a = (String) k.o(str);
        }
    }

    public static <T> T a(T t10, T t11) {
        if (t10 != null) {
            return t10;
        }
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static b b(Class<?> cls) {
        return new b(cls.getSimpleName());
    }

    public static b c(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
