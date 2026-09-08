package com.oplus.phonenoareainquire;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: NumberLocationCache.java */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public static final d f28851b = new d();

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f28852a = new ConcurrentHashMap<>();

    /* compiled from: NumberLocationCache.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f28853a;

        /* renamed from: b, reason: collision with root package name */
        public String f28854b;

        public String a() {
            return this.f28854b;
        }

        public String b() {
            return this.f28853a;
        }

        public void c(String str) {
            this.f28854b = str;
        }

        public void d(String str) {
            this.f28853a = str;
        }
    }

    public static d c() {
        return f28851b;
    }

    public void a() {
        this.f28852a.clear();
    }

    public a b(String str) {
        return this.f28852a.get(str);
    }

    public synchronized void d(String str, String str2, String str3) {
        a aVar = new a();
        aVar.d(str2);
        aVar.c(str3);
        this.f28852a.put(str, aVar);
    }
}
