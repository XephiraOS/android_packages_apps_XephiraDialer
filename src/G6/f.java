package g6;

import android.graphics.PointF;
import b6.o;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import f6.C1015b;
import f6.m;

/* compiled from: RectangleShape.java */
/* loaded from: classes3.dex */
public class f implements c {

    /* renamed from: a, reason: collision with root package name */
    public final String f31904a;

    /* renamed from: b, reason: collision with root package name */
    public final m<PointF, PointF> f31905b;

    /* renamed from: c, reason: collision with root package name */
    public final m<PointF, PointF> f31906c;

    /* renamed from: d, reason: collision with root package name */
    public final C1015b f31907d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f31908e;

    public f(String str, m<PointF, PointF> mVar, m<PointF, PointF> mVar2, C1015b c1015b, boolean z10) {
        this.f31904a = str;
        this.f31905b = mVar;
        this.f31906c = mVar2;
        this.f31907d = c1015b;
        this.f31908e = z10;
    }

    @Override // g6.c
    public b6.c a(EffectiveAnimationDrawable effectiveAnimationDrawable, C0820a c0820a, com.oplus.anim.model.layer.a aVar) {
        return new o(effectiveAnimationDrawable, aVar, this);
    }

    public C1015b b() {
        return this.f31907d;
    }

    public String c() {
        return this.f31904a;
    }

    public m<PointF, PointF> d() {
        return this.f31905b;
    }

    public m<PointF, PointF> e() {
        return this.f31906c;
    }

    public boolean f() {
        return this.f31908e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f31905b + ", size=" + this.f31906c + '}';
    }
}
