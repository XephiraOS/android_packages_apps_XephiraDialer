package b6;

import android.graphics.Path;
import c6.AbstractC0558a;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapeContent.java */
/* loaded from: classes3.dex */
public class r implements m, AbstractC0558a.b {

    /* renamed from: b, reason: collision with root package name */
    public final String f12318b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f12319c;

    /* renamed from: d, reason: collision with root package name */
    public final EffectiveAnimationDrawable f12320d;

    /* renamed from: e, reason: collision with root package name */
    public final c6.m f12321e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12322f;

    /* renamed from: a, reason: collision with root package name */
    public final Path f12317a = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final b f12323g = new b();

    public r(EffectiveAnimationDrawable effectiveAnimationDrawable, com.oplus.anim.model.layer.a aVar, g6.l lVar) {
        this.f12318b = lVar.b();
        this.f12319c = lVar.d();
        this.f12320d = effectiveAnimationDrawable;
        c6.m a10 = lVar.c().a();
        this.f12321e = a10;
        aVar.j(a10);
        a10.a(this);
    }

    private void f() {
        this.f12322f = false;
        this.f12320d.invalidateSelf();
    }

    @Override // c6.AbstractC0558a.b
    public void a() {
        f();
    }

    @Override // b6.c
    public void b(List<c> list, List<c> list2) {
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = list.get(i10);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.k() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f12323g.a(uVar);
                    uVar.f(this);
                }
            }
            if (cVar instanceof s) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((s) cVar);
            }
        }
        this.f12321e.q(arrayList);
    }

    @Override // b6.m
    public Path d() {
        if (this.f12322f) {
            return this.f12317a;
        }
        this.f12317a.reset();
        if (this.f12319c) {
            this.f12322f = true;
            return this.f12317a;
        }
        Path h10 = this.f12321e.h();
        if (h10 == null) {
            return this.f12317a;
        }
        this.f12317a.set(h10);
        this.f12317a.setFillType(Path.FillType.EVEN_ODD);
        this.f12323g.b(this.f12317a);
        this.f12322f = true;
        return this.f12317a;
    }
}
