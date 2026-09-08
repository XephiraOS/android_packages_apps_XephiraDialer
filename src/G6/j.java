package g6;

import android.graphics.Path;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import f6.C1014a;
import f6.C1017d;

/* compiled from: ShapeFill.java */
/* loaded from: classes3.dex */
public class j implements c {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f31919a;

    /* renamed from: b, reason: collision with root package name */
    public final Path.FillType f31920b;

    /* renamed from: c, reason: collision with root package name */
    public final String f31921c;

    /* renamed from: d, reason: collision with root package name */
    public final C1014a f31922d;

    /* renamed from: e, reason: collision with root package name */
    public final C1017d f31923e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f31924f;

    public j(String str, boolean z10, Path.FillType fillType, C1014a c1014a, C1017d c1017d, boolean z11) {
        this.f31921c = str;
        this.f31919a = z10;
        this.f31920b = fillType;
        this.f31922d = c1014a;
        this.f31923e = c1017d;
        this.f31924f = z11;
    }

    @Override // g6.c
    public b6.c a(EffectiveAnimationDrawable effectiveAnimationDrawable, C0820a c0820a, com.oplus.anim.model.layer.a aVar) {
        return new b6.g(effectiveAnimationDrawable, aVar, this);
    }

    public C1014a b() {
        return this.f31922d;
    }

    public Path.FillType c() {
        return this.f31920b;
    }

    public String d() {
        return this.f31921c;
    }

    public C1017d e() {
        return this.f31923e;
    }

    public boolean f() {
        return this.f31924f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f31919a + '}';
    }
}
