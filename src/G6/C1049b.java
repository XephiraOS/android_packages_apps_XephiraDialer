package g6;

import android.graphics.PointF;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import f6.m;

/* compiled from: CircleShape.java */
/* renamed from: g6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1049b implements c {

    /* renamed from: a, reason: collision with root package name */
    public final String f31887a;

    /* renamed from: b, reason: collision with root package name */
    public final m<PointF, PointF> f31888b;

    /* renamed from: c, reason: collision with root package name */
    public final f6.f f31889c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f31890d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f31891e;

    public C1049b(String str, m<PointF, PointF> mVar, f6.f fVar, boolean z10, boolean z11) {
        this.f31887a = str;
        this.f31888b = mVar;
        this.f31889c = fVar;
        this.f31890d = z10;
        this.f31891e = z11;
    }

    @Override // g6.c
    public b6.c a(EffectiveAnimationDrawable effectiveAnimationDrawable, C0820a c0820a, com.oplus.anim.model.layer.a aVar) {
        return new b6.f(effectiveAnimationDrawable, aVar, this);
    }

    public String b() {
        return this.f31887a;
    }

    public m<PointF, PointF> c() {
        return this.f31888b;
    }

    public f6.f d() {
        return this.f31889c;
    }

    public boolean e() {
        return this.f31891e;
    }

    public boolean f() {
        return this.f31890d;
    }
}
