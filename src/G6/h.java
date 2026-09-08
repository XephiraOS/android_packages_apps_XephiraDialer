package g6;

import b6.q;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import f6.m;

/* compiled from: RoundedCorners.java */
/* loaded from: classes3.dex */
public class h implements c {

    /* renamed from: a, reason: collision with root package name */
    public final String f31914a;

    /* renamed from: b, reason: collision with root package name */
    public final m<Float, Float> f31915b;

    public h(String str, m<Float, Float> mVar) {
        this.f31914a = str;
        this.f31915b = mVar;
    }

    @Override // g6.c
    public b6.c a(EffectiveAnimationDrawable effectiveAnimationDrawable, C0820a c0820a, com.oplus.anim.model.layer.a aVar) {
        return new q(effectiveAnimationDrawable, aVar, this);
    }

    public m<Float, Float> b() {
        return this.f31915b;
    }

    public String c() {
        return this.f31914a;
    }
}
