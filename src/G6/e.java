package g6;

import android.graphics.Path;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.model.content.GradientType;
import f6.C1015b;
import f6.C1016c;
import f6.C1017d;

/* compiled from: GradientFill.java */
/* loaded from: classes3.dex */
public class e implements c {

    /* renamed from: a, reason: collision with root package name */
    public final GradientType f31894a;

    /* renamed from: b, reason: collision with root package name */
    public final Path.FillType f31895b;

    /* renamed from: c, reason: collision with root package name */
    public final C1016c f31896c;

    /* renamed from: d, reason: collision with root package name */
    public final C1017d f31897d;

    /* renamed from: e, reason: collision with root package name */
    public final f6.f f31898e;

    /* renamed from: f, reason: collision with root package name */
    public final f6.f f31899f;

    /* renamed from: g, reason: collision with root package name */
    public final String f31900g;

    /* renamed from: h, reason: collision with root package name */
    public final C1015b f31901h;

    /* renamed from: i, reason: collision with root package name */
    public final C1015b f31902i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f31903j;

    public e(String str, GradientType gradientType, Path.FillType fillType, C1016c c1016c, C1017d c1017d, f6.f fVar, f6.f fVar2, C1015b c1015b, C1015b c1015b2, boolean z10) {
        this.f31894a = gradientType;
        this.f31895b = fillType;
        this.f31896c = c1016c;
        this.f31897d = c1017d;
        this.f31898e = fVar;
        this.f31899f = fVar2;
        this.f31900g = str;
        this.f31901h = c1015b;
        this.f31902i = c1015b2;
        this.f31903j = z10;
    }

    @Override // g6.c
    public b6.c a(EffectiveAnimationDrawable effectiveAnimationDrawable, C0820a c0820a, com.oplus.anim.model.layer.a aVar) {
        return new b6.h(effectiveAnimationDrawable, c0820a, aVar, this);
    }

    public f6.f b() {
        return this.f31899f;
    }

    public Path.FillType c() {
        return this.f31895b;
    }

    public C1016c d() {
        return this.f31896c;
    }

    public GradientType e() {
        return this.f31894a;
    }

    public String f() {
        return this.f31900g;
    }

    public C1017d g() {
        return this.f31897d;
    }

    public f6.f h() {
        return this.f31898e;
    }

    public boolean i() {
        return this.f31903j;
    }
}
