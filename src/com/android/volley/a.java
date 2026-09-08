package com.android.volley;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: Cache.java */
/* loaded from: classes.dex */
public interface a {

    /* compiled from: Cache.java */
    /* renamed from: com.android.volley.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0186a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f19225a;

        /* renamed from: b, reason: collision with root package name */
        public String f19226b;

        /* renamed from: c, reason: collision with root package name */
        public long f19227c;

        /* renamed from: d, reason: collision with root package name */
        public long f19228d;

        /* renamed from: e, reason: collision with root package name */
        public long f19229e;

        /* renamed from: f, reason: collision with root package name */
        public long f19230f;

        /* renamed from: g, reason: collision with root package name */
        public Map<String, String> f19231g = Collections.emptyMap();

        /* renamed from: h, reason: collision with root package name */
        public List<S2.c> f19232h;

        public boolean a() {
            return b(System.currentTimeMillis());
        }

        public boolean b(long j10) {
            if (this.f19229e < j10) {
                return true;
            }
            return false;
        }

        public boolean c(long j10) {
            if (this.f19230f < j10) {
                return true;
            }
            return false;
        }
    }

    void a();

    void b(String str, boolean z10);

    void c(String str, C0186a c0186a);

    C0186a d(String str);
}
