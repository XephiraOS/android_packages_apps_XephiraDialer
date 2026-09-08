package O9;

/* compiled from: AbstractField.java */
/* loaded from: classes4.dex */
public abstract class a implements N9.o {

    /* renamed from: a, reason: collision with root package name */
    public final S9.i f2738a;

    /* renamed from: b, reason: collision with root package name */
    public final K9.c f2739b;

    public a(S9.i iVar, K9.c cVar) {
        this.f2738a = iVar;
        this.f2739b = cVar == null ? K9.c.f1690b : cVar;
    }

    @Override // S9.i
    public T9.b a() {
        return this.f2738a.a();
    }

    @Override // S9.i
    public String b() {
        return this.f2738a.b();
    }

    @Override // S9.i
    public String getName() {
        return this.f2738a.getName();
    }

    public String toString() {
        return this.f2738a.toString();
    }
}
