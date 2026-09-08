package com.heytap.addon.os;

import com.oplus.os.WaveformEffect;
import com.oppo.os.WaveformEffect;

/* compiled from: WaveformEffect.java */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    public static int f25394c;

    /* renamed from: d, reason: collision with root package name */
    public static int f25395d;

    /* renamed from: e, reason: collision with root package name */
    public static int f25396e;

    /* renamed from: f, reason: collision with root package name */
    public static int f25397f;

    /* renamed from: g, reason: collision with root package name */
    public static int f25398g;

    /* renamed from: h, reason: collision with root package name */
    public static int f25399h;

    /* renamed from: i, reason: collision with root package name */
    public static int f25400i;

    /* renamed from: j, reason: collision with root package name */
    public static int f25401j;

    /* renamed from: k, reason: collision with root package name */
    public static int f25402k;

    /* renamed from: l, reason: collision with root package name */
    public static int f25403l;

    /* renamed from: m, reason: collision with root package name */
    public static int f25404m;

    /* renamed from: a, reason: collision with root package name */
    public WaveformEffect f25405a;

    /* renamed from: b, reason: collision with root package name */
    public com.oppo.os.WaveformEffect f25406b;

    /* compiled from: WaveformEffect.java */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public WaveformEffect.Builder f25407a;

        /* renamed from: b, reason: collision with root package name */
        public WaveformEffect.Builder f25408b;

        public b() {
            if (A5.a.b()) {
                this.f25407a = new WaveformEffect.Builder();
            } else {
                this.f25408b = new WaveformEffect.Builder();
            }
        }

        public d a() {
            if (A5.a.b()) {
                return new d(this.f25407a.build());
            }
            return new d(this.f25408b.build());
        }

        public b b(int i10) {
            if (A5.a.b()) {
                this.f25407a.setEffectType(i10);
            } else {
                this.f25408b.setEffectType(i10);
            }
            return this;
        }
    }

    static {
        if (A5.a.b()) {
            f25394c = 2;
            f25395d = 1;
            f25396e = 0;
            f25397f = 64;
            f25398g = 4;
            f25399h = 5;
            f25400i = 6;
            f25401j = 7;
            f25402k = 8;
            f25403l = 67;
            f25404m = 49;
            return;
        }
        f25394c = 2;
        f25395d = 1;
        f25396e = 0;
        f25397f = 64;
        f25398g = 4;
        f25399h = 5;
        f25400i = 6;
        f25401j = 7;
        f25402k = 8;
        f25403l = 67;
        f25404m = 49;
    }

    public d(com.oplus.os.WaveformEffect waveformEffect) {
        this.f25405a = waveformEffect;
    }

    public d(com.oppo.os.WaveformEffect waveformEffect) {
        this.f25406b = waveformEffect;
    }
}
