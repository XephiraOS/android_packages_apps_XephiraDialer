package b6;

import android.graphics.PointF;
import c6.AbstractC0558a;
import com.oplus.anim.EffectiveAnimationDrawable;
import e6.C0982a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RoundedCornersContent.java */
/* loaded from: classes3.dex */
public class q implements s, AbstractC0558a.b {

    /* renamed from: a, reason: collision with root package name */
    public final EffectiveAnimationDrawable f12313a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12314b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC0558a<Float, Float> f12315c;

    /* renamed from: d, reason: collision with root package name */
    public g6.i f12316d;

    public q(EffectiveAnimationDrawable effectiveAnimationDrawable, com.oplus.anim.model.layer.a aVar, g6.h hVar) {
        this.f12313a = effectiveAnimationDrawable;
        this.f12314b = hVar.c();
        AbstractC0558a<Float, Float> a10 = hVar.b().a();
        this.f12315c = a10;
        aVar.j(a10);
        a10.a(this);
    }

    public static int f(int i10, int i11) {
        int i12 = i10 / i11;
        if ((i10 ^ i11) < 0 && i11 * i12 != i10) {
            return i12 - 1;
        }
        return i12;
    }

    public static int g(int i10, int i11) {
        return i10 - (f(i10, i11) * i11);
    }

    @Override // c6.AbstractC0558a.b
    public void a() {
        this.f12313a.invalidateSelf();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009c, code lost:
    
        if (r6 == (r0.size() - 1)) goto L27;
     */
    @Override // b6.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g6.i c(g6.i r19) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.q.c(g6.i):g6.i");
    }

    public AbstractC0558a<Float, Float> i() {
        return this.f12315c;
    }

    public final g6.i j(g6.i iVar) {
        PointF c10;
        PointF b10;
        boolean z10;
        List<C0982a> a10 = iVar.a();
        boolean d10 = iVar.d();
        int i10 = 0;
        for (int size = a10.size() - 1; size >= 0; size--) {
            C0982a c0982a = a10.get(size);
            C0982a c0982a2 = a10.get(g(size - 1, a10.size()));
            if (size == 0 && !d10) {
                c10 = iVar.b();
            } else {
                c10 = c0982a2.c();
            }
            if (size == 0 && !d10) {
                b10 = c10;
            } else {
                b10 = c0982a2.b();
            }
            PointF a11 = c0982a.a();
            if (!iVar.d() && size == 0 && size == a10.size() - 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (b10.equals(c10) && a11.equals(c10) && !z10) {
                i10 += 2;
            } else {
                i10++;
            }
        }
        g6.i iVar2 = this.f12316d;
        if (iVar2 == null || iVar2.a().size() != i10) {
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList.add(new C0982a());
            }
            this.f12316d = new g6.i(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.f12316d.e(d10);
        return this.f12316d;
    }

    @Override // b6.c
    public void b(List<c> list, List<c> list2) {
    }
}
