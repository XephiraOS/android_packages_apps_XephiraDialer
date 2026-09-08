package androidx.activity;

/* compiled from: BackEventCompat.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final a f7099e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final float f7100a;

    /* renamed from: b, reason: collision with root package name */
    public final float f7101b;

    /* renamed from: c, reason: collision with root package name */
    public final float f7102c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7103d;

    /* compiled from: BackEventCompat.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public b(float f10, float f11, float f12, int i10) {
        this.f7100a = f10;
        this.f7101b = f11;
        this.f7102c = f12;
        this.f7103d = i10;
    }

    public final float a() {
        return this.f7102c;
    }

    public final int b() {
        return this.f7103d;
    }

    public final float c() {
        return this.f7101b;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.f7100a + ", touchY=" + this.f7101b + ", progress=" + this.f7102c + ", swipeEdge=" + this.f7103d + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(android.window.BackEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "backEvent"
            kotlin.jvm.internal.i.f(r5, r0)
            androidx.activity.a r0 = androidx.activity.a.f7098a
            float r1 = r0.d(r5)
            float r2 = r0.e(r5)
            float r3 = r0.b(r5)
            int r5 = r0.c(r5)
            r4.<init>(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.b.<init>(android.window.BackEvent):void");
    }
}
