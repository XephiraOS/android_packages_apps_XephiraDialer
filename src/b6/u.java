package b6;

import c6.AbstractC0558a;
import com.oplus.anim.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrimPathContent.java */
/* loaded from: classes3.dex */
public class u implements c, AbstractC0558a.b {

    /* renamed from: a, reason: collision with root package name */
    public final String f12329a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12330b;

    /* renamed from: c, reason: collision with root package name */
    public final List<AbstractC0558a.b> f12331c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ShapeTrimPath.Type f12332d;

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC0558a<?, Float> f12333e;

    /* renamed from: f, reason: collision with root package name */
    public final AbstractC0558a<?, Float> f12334f;

    /* renamed from: g, reason: collision with root package name */
    public final AbstractC0558a<?, Float> f12335g;

    public u(com.oplus.anim.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.f12329a = shapeTrimPath.c();
        this.f12330b = shapeTrimPath.g();
        this.f12332d = shapeTrimPath.f();
        AbstractC0558a<Float, Float> a10 = shapeTrimPath.e().a();
        this.f12333e = a10;
        AbstractC0558a<Float, Float> a11 = shapeTrimPath.b().a();
        this.f12334f = a11;
        AbstractC0558a<Float, Float> a12 = shapeTrimPath.d().a();
        this.f12335g = a12;
        aVar.j(a10);
        aVar.j(a11);
        aVar.j(a12);
        a10.a(this);
        a11.a(this);
        a12.a(this);
    }

    @Override // c6.AbstractC0558a.b
    public void a() {
        for (int i10 = 0; i10 < this.f12331c.size(); i10++) {
            this.f12331c.get(i10).a();
        }
    }

    public void f(AbstractC0558a.b bVar) {
        this.f12331c.add(bVar);
    }

    public AbstractC0558a<?, Float> g() {
        return this.f12334f;
    }

    public AbstractC0558a<?, Float> i() {
        return this.f12335g;
    }

    public AbstractC0558a<?, Float> j() {
        return this.f12333e;
    }

    public ShapeTrimPath.Type k() {
        return this.f12332d;
    }

    public boolean l() {
        return this.f12330b;
    }

    @Override // b6.c
    public void b(List<c> list, List<c> list2) {
    }
}
