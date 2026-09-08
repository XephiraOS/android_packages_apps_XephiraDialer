package t4;

import android.animation.Animator;
import j0.AbstractC1152b;
import java.util.ArrayList;
import java.util.List;
import t4.g;

/* compiled from: IndeterminateAnimatorDelegate.java */
/* loaded from: classes3.dex */
public abstract class h<T extends Animator> {

    /* renamed from: a, reason: collision with root package name */
    public i f37237a;

    /* renamed from: b, reason: collision with root package name */
    public final List<g.a> f37238b = new ArrayList();

    public h(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            this.f37238b.add(new g.a());
        }
    }

    public abstract void a();

    public float b(int i10, int i11, int i12) {
        return (i10 - i11) / i12;
    }

    public abstract void c();

    public abstract void d(AbstractC1152b abstractC1152b);

    public void e(i iVar) {
        this.f37237a = iVar;
    }

    public abstract void f();

    public abstract void g();

    public abstract void h();
}
