package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SimpleItemAnimator.java */
/* loaded from: classes.dex */
public abstract class w extends RecyclerView.l {

    /* renamed from: g, reason: collision with root package name */
    public boolean f11206g = true;

    public final void A(RecyclerView.B b10) {
        I(b10);
        h(b10);
    }

    public final void B(RecyclerView.B b10) {
        J(b10);
    }

    public final void C(RecyclerView.B b10, boolean z10) {
        K(b10, z10);
        h(b10);
    }

    public final void D(RecyclerView.B b10, boolean z10) {
        L(b10, z10);
    }

    public final void E(RecyclerView.B b10) {
        M(b10);
        h(b10);
    }

    public final void F(RecyclerView.B b10) {
        N(b10);
    }

    public final void G(RecyclerView.B b10) {
        O(b10);
        h(b10);
    }

    public final void H(RecyclerView.B b10) {
        P(b10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.B b10, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10;
        int i11;
        if (cVar != null && ((i10 = cVar.f10893a) != (i11 = cVar2.f10893a) || cVar.f10894b != cVar2.f10894b)) {
            return y(b10, i10, cVar.f10894b, i11, cVar2.f10894b);
        }
        return w(b10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(RecyclerView.B b10, RecyclerView.B b11, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10;
        int i11;
        int i12 = cVar.f10893a;
        int i13 = cVar.f10894b;
        if (b11.shouldIgnore()) {
            int i14 = cVar.f10893a;
            i11 = cVar.f10894b;
            i10 = i14;
        } else {
            i10 = cVar2.f10893a;
            i11 = cVar2.f10894b;
        }
        return x(b10, b11, i12, i13, i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(RecyclerView.B b10, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10;
        int i11;
        int i12 = cVar.f10893a;
        int i13 = cVar.f10894b;
        View view = b10.itemView;
        if (cVar2 == null) {
            i10 = view.getLeft();
        } else {
            i10 = cVar2.f10893a;
        }
        int i14 = i10;
        if (cVar2 == null) {
            i11 = view.getTop();
        } else {
            i11 = cVar2.f10894b;
        }
        int i15 = i11;
        if (!b10.isRemoved() && (i12 != i14 || i13 != i15)) {
            view.layout(i14, i15, view.getWidth() + i14, view.getHeight() + i15);
            return y(b10, i12, i13, i14, i15);
        }
        return z(b10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean d(RecyclerView.B b10, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10 = cVar.f10893a;
        int i11 = cVar2.f10893a;
        if (i10 == i11 && cVar.f10894b == cVar2.f10894b) {
            E(b10);
            return false;
        }
        return y(b10, i10, cVar.f10894b, i11, cVar2.f10894b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean f(RecyclerView.B b10) {
        if (this.f11206g && !b10.isInvalid()) {
            return false;
        }
        return true;
    }

    public abstract boolean w(RecyclerView.B b10);

    public abstract boolean x(RecyclerView.B b10, RecyclerView.B b11, int i10, int i11, int i12, int i13);

    public abstract boolean y(RecyclerView.B b10, int i10, int i11, int i12, int i13);

    public abstract boolean z(RecyclerView.B b10);

    public void I(RecyclerView.B b10) {
    }

    public void J(RecyclerView.B b10) {
    }

    public void M(RecyclerView.B b10) {
    }

    public void N(RecyclerView.B b10) {
    }

    public void O(RecyclerView.B b10) {
    }

    public void P(RecyclerView.B b10) {
    }

    public void K(RecyclerView.B b10, boolean z10) {
    }

    public void L(RecyclerView.B b10, boolean z10) {
    }
}
