package K1;

import J1.c;
import J1.d;
import J1.e;
import J1.f;
import J1.g;

/* compiled from: CommonUseCaseProvider.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1620a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final J1.a f1621b;

    /* renamed from: c, reason: collision with root package name */
    public static final e f1622c;

    /* renamed from: d, reason: collision with root package name */
    public static final g f1623d;

    /* renamed from: e, reason: collision with root package name */
    public static final f f1624e;

    static {
        a aVar = a.f1613a;
        f1621b = new J1.a(aVar.a());
        f1622c = new e(aVar.b());
        f1623d = new g(aVar.f());
        f1624e = new f(aVar.c());
    }

    public final J1.a a() {
        return f1621b;
    }

    public final c b() {
        a aVar = a.f1613a;
        return new c(aVar.d(), aVar.e());
    }

    public final d c() {
        a aVar = a.f1613a;
        return new d(aVar.d(), aVar.e());
    }

    public final e d() {
        return f1622c;
    }

    public final f e() {
        return f1624e;
    }

    public final g f() {
        return f1623d;
    }
}
