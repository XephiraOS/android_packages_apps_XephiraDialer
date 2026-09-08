package c6;

import android.graphics.Color;
import android.graphics.Paint;
import c6.AbstractC0558a;
import j6.C1182j;
import m6.C1335a;
import m6.C1336b;

/* compiled from: DropShadowKeyframeAnimation.java */
/* renamed from: c6.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0560c implements AbstractC0558a.b {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0558a.b f12811a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC0558a<Integer, Integer> f12812b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC0558a<Float, Float> f12813c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC0558a<Float, Float> f12814d;

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC0558a<Float, Float> f12815e;

    /* renamed from: f, reason: collision with root package name */
    public final AbstractC0558a<Float, Float> f12816f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f12817g = true;

    /* compiled from: DropShadowKeyframeAnimation.java */
    /* renamed from: c6.c$a */
    /* loaded from: classes3.dex */
    public class a extends C1336b<Float> {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ C1336b f12818d;

        public a(C1336b c1336b) {
            this.f12818d = c1336b;
        }

        @Override // m6.C1336b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Float a(C1335a<Float> c1335a) {
            Float f10 = (Float) this.f12818d.a(c1335a);
            if (f10 == null) {
                return null;
            }
            return Float.valueOf(f10.floatValue() * 2.55f);
        }
    }

    public C0560c(AbstractC0558a.b bVar, com.oplus.anim.model.layer.a aVar, C1182j c1182j) {
        this.f12811a = bVar;
        AbstractC0558a<Integer, Integer> a10 = c1182j.a().a();
        this.f12812b = a10;
        a10.a(this);
        aVar.j(a10);
        AbstractC0558a<Float, Float> a11 = c1182j.d().a();
        this.f12813c = a11;
        a11.a(this);
        aVar.j(a11);
        AbstractC0558a<Float, Float> a12 = c1182j.b().a();
        this.f12814d = a12;
        a12.a(this);
        aVar.j(a12);
        AbstractC0558a<Float, Float> a13 = c1182j.c().a();
        this.f12815e = a13;
        a13.a(this);
        aVar.j(a13);
        AbstractC0558a<Float, Float> a14 = c1182j.e().a();
        this.f12816f = a14;
        a14.a(this);
        aVar.j(a14);
    }

    @Override // c6.AbstractC0558a.b
    public void a() {
        this.f12817g = true;
        this.f12811a.a();
    }

    public void b(Paint paint) {
        if (!this.f12817g) {
            return;
        }
        this.f12817g = false;
        double floatValue = this.f12814d.h().floatValue() * 0.017453292519943295d;
        float floatValue2 = this.f12815e.h().floatValue();
        float sin = ((float) Math.sin(floatValue)) * floatValue2;
        float cos = ((float) Math.cos(floatValue + 3.141592653589793d)) * floatValue2;
        int intValue = this.f12812b.h().intValue();
        paint.setShadowLayer(this.f12816f.h().floatValue(), sin, cos, Color.argb(Math.round(this.f12813c.h().floatValue()), Color.red(intValue), Color.green(intValue), Color.blue(intValue)));
    }

    public void c(C1336b<Integer> c1336b) {
        this.f12812b.n(c1336b);
    }

    public void d(C1336b<Float> c1336b) {
        this.f12814d.n(c1336b);
    }

    public void e(C1336b<Float> c1336b) {
        this.f12815e.n(c1336b);
    }

    public void f(C1336b<Float> c1336b) {
        if (c1336b == null) {
            this.f12813c.n(null);
        } else {
            this.f12813c.n(new a(c1336b));
        }
    }

    public void g(C1336b<Float> c1336b) {
        this.f12816f.n(c1336b);
    }
}
