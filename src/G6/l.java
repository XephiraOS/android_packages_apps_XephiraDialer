package g6;

import b6.r;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;

/* compiled from: ShapePath.java */
/* loaded from: classes3.dex */
public class l implements c {

    /* renamed from: a, reason: collision with root package name */
    public final String f31928a;

    /* renamed from: b, reason: collision with root package name */
    public final int f31929b;

    /* renamed from: c, reason: collision with root package name */
    public final f6.h f31930c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f31931d;

    public l(String str, int i10, f6.h hVar, boolean z10) {
        this.f31928a = str;
        this.f31929b = i10;
        this.f31930c = hVar;
        this.f31931d = z10;
    }

    @Override // g6.c
    public b6.c a(EffectiveAnimationDrawable effectiveAnimationDrawable, C0820a c0820a, com.oplus.anim.model.layer.a aVar) {
        return new r(effectiveAnimationDrawable, aVar, this);
    }

    public String b() {
        return this.f31928a;
    }

    public f6.h c() {
        return this.f31930c;
    }

    public boolean d() {
        return this.f31931d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f31928a + ", index=" + this.f31929b + '}';
    }
}
