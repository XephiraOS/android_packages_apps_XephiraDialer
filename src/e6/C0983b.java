package e6;

import com.oplus.anim.C0820a;
import p.C1422h;

/* compiled from: EffectiveCompositionCache.java */
/* renamed from: e6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0983b {

    /* renamed from: b, reason: collision with root package name */
    public static final C0983b f31632b = new C0983b();

    /* renamed from: a, reason: collision with root package name */
    public final C1422h<String, C0820a> f31633a = new C1422h<>(20);

    public static C0983b b() {
        return f31632b;
    }

    public C0820a a(String str) {
        if (str == null) {
            return null;
        }
        return this.f31633a.get(str);
    }

    public void c(String str, C0820a c0820a) {
        if (str == null) {
            return;
        }
        this.f31633a.put(str, c0820a);
    }
}
