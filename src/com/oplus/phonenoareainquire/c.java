package com.oplus.phonenoareainquire;

import android.content.ContentResolver;
import android.provider.Settings;
import j8.C1188a;

/* compiled from: MultiSettings.kt */
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: b, reason: collision with root package name */
    public static final d f28846b = new d(null);

    /* renamed from: a, reason: collision with root package name */
    public f f28847a;

    /* compiled from: MultiSettings.kt */
    /* loaded from: classes3.dex */
    public static final class a extends c {

        /* compiled from: MultiSettings.kt */
        /* renamed from: com.oplus.phonenoareainquire.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0278a implements f {
            public C0278a() {
            }

            @Override // com.oplus.phonenoareainquire.c.e
            public int a(ContentResolver contentResolver, String str, int i10) {
                return C1188a.f.d(contentResolver, str, i10);
            }
        }

        public a() {
            super(null);
        }

        @Override // com.oplus.phonenoareainquire.c
        public f a() {
            return new C0278a();
        }
    }

    /* compiled from: MultiSettings.kt */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f28849a = new b();

        public static final c a(int i10) {
            if (i10 == 2) {
                return new C0279c();
            }
            return new a();
        }
    }

    /* compiled from: MultiSettings.kt */
    /* renamed from: com.oplus.phonenoareainquire.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0279c extends c {

        /* compiled from: MultiSettings.kt */
        /* renamed from: com.oplus.phonenoareainquire.c$c$a */
        /* loaded from: classes3.dex */
        public final class a implements f {
            public a() {
            }

            @Override // com.oplus.phonenoareainquire.c.e
            public int a(ContentResolver contentResolver, String str, int i10) {
                return Settings.System.getInt(contentResolver, str, i10);
            }
        }

        public C0279c() {
            super(null);
        }

        @Override // com.oplus.phonenoareainquire.c
        public f a() {
            return new a();
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
    public interface e {
        int a(ContentResolver contentResolver, String str, int i10);
    }

    /* compiled from: MultiSettings.kt */
    /* loaded from: classes3.dex */
    public interface f extends e {
    }

    public /* synthetic */ c(kotlin.jvm.internal.f fVar) {
        this();
    }

    public abstract f a();

    public c() {
        this.f28847a = a();
    }
}
