package g6;

import b6.p;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import f6.C1015b;

/* compiled from: Repeater.java */
/* loaded from: classes3.dex */
public class g implements c {

    /* renamed from: a, reason: collision with root package name */
    public final String f31909a;

    /* renamed from: b, reason: collision with root package name */
    public final C1015b f31910b;

    /* renamed from: c, reason: collision with root package name */
    public final C1015b f31911c;

    /* renamed from: d, reason: collision with root package name */
    public final f6.l f31912d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f31913e;

    public g(String str, C1015b c1015b, C1015b c1015b2, f6.l lVar, boolean z10) {
        this.f31909a = str;
        this.f31910b = c1015b;
        this.f31911c = c1015b2;
        this.f31912d = lVar;
        this.f31913e = z10;
    }

    @Override // g6.c
    public b6.c a(EffectiveAnimationDrawable effectiveAnimationDrawable, C0820a c0820a, com.oplus.anim.model.layer.a aVar) {
        return new p(effectiveAnimationDrawable, aVar, this);
    }

    public C1015b b() {
        return this.f31910b;
    }

    public String c() {
        return this.f31909a;
    }

    public C1015b d() {
        return this.f31911c;
    }

    public f6.l e() {
        return this.f31912d;
    }

    public boolean f() {
        return this.f31913e;
    }
}
