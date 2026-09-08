package g6;

import android.graphics.PointF;
import e6.C0982a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapeData.java */
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final List<C0982a> f31916a;

    /* renamed from: b, reason: collision with root package name */
    public PointF f31917b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f31918c;

    public i(PointF pointF, boolean z10, List<C0982a> list) {
        this.f31917b = pointF;
        this.f31918c = z10;
        this.f31916a = new ArrayList(list);
    }

    public List<C0982a> a() {
        return this.f31916a;
    }

    public PointF b() {
        return this.f31917b;
    }

    public void c(i iVar, i iVar2, float f10) {
        boolean z10;
        if (this.f31917b == null) {
            this.f31917b = new PointF();
        }
        if (!iVar.d() && !iVar2.d()) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f31918c = z10;
        if (iVar.a().size() != iVar2.a().size()) {
            l6.e.c("Curves must have the same number of control points. Shape 1: " + iVar.a().size() + "\tShape 2: " + iVar2.a().size());
        }
        int min = Math.min(iVar.a().size(), iVar2.a().size());
        if (this.f31916a.size() < min) {
            for (int size = this.f31916a.size(); size < min; size++) {
                this.f31916a.add(new C0982a());
            }
        } else if (this.f31916a.size() > min) {
            for (int size2 = this.f31916a.size() - 1; size2 >= min; size2--) {
                List<C0982a> list = this.f31916a;
                list.remove(list.size() - 1);
            }
        }
        PointF b10 = iVar.b();
        PointF b11 = iVar2.b();
        f(l6.g.i(b10.x, b11.x, f10), l6.g.i(b10.y, b11.y, f10));
        for (int size3 = this.f31916a.size() - 1; size3 >= 0; size3--) {
            C0982a c0982a = iVar.a().get(size3);
            C0982a c0982a2 = iVar2.a().get(size3);
            PointF a10 = c0982a.a();
            PointF b12 = c0982a.b();
            PointF c10 = c0982a.c();
            PointF a11 = c0982a2.a();
            PointF b13 = c0982a2.b();
            PointF c11 = c0982a2.c();
            this.f31916a.get(size3).d(l6.g.i(a10.x, a11.x, f10), l6.g.i(a10.y, a11.y, f10));
            this.f31916a.get(size3).e(l6.g.i(b12.x, b13.x, f10), l6.g.i(b12.y, b13.y, f10));
            this.f31916a.get(size3).f(l6.g.i(c10.x, c11.x, f10), l6.g.i(c10.y, c11.y, f10));
        }
    }

    public boolean d() {
        return this.f31918c;
    }

    public void e(boolean z10) {
        this.f31918c = z10;
    }

    public void f(float f10, float f11) {
        if (this.f31917b == null) {
            this.f31917b = new PointF();
        }
        this.f31917b.set(f10, f11);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f31916a.size() + "closed=" + this.f31918c + '}';
    }

    public i() {
        this.f31916a = new ArrayList();
    }
}
