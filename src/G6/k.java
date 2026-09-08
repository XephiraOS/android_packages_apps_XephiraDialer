package g6;

import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import java.util.Arrays;
import java.util.List;

/* compiled from: ShapeGroup.java */
/* loaded from: classes3.dex */
public class k implements c {

    /* renamed from: a, reason: collision with root package name */
    public final String f31925a;

    /* renamed from: b, reason: collision with root package name */
    public final List<c> f31926b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f31927c;

    public k(String str, List<c> list, boolean z10) {
        this.f31925a = str;
        this.f31926b = list;
        this.f31927c = z10;
    }

    @Override // g6.c
    public b6.c a(EffectiveAnimationDrawable effectiveAnimationDrawable, C0820a c0820a, com.oplus.anim.model.layer.a aVar) {
        return new b6.d(effectiveAnimationDrawable, aVar, this, c0820a);
    }

    public List<c> b() {
        return this.f31926b;
    }

    public String c() {
        return this.f31925a;
    }

    public boolean d() {
        return this.f31927c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f31925a + "' Shapes: " + Arrays.toString(this.f31926b.toArray()) + '}';
    }
}
