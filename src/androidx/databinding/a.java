package androidx.databinding;

import androidx.databinding.i;

/* compiled from: BaseObservable.java */
/* loaded from: classes.dex */
public class a implements i {

    /* renamed from: a, reason: collision with root package name */
    public transient n f9648a;

    @Override // androidx.databinding.i
    public void f(i.a aVar) {
        synchronized (this) {
            try {
                if (this.f9648a == null) {
                    this.f9648a = new n();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f9648a.a(aVar);
    }

    @Override // androidx.databinding.i
    public void l0(i.a aVar) {
        synchronized (this) {
            try {
                n nVar = this.f9648a;
                if (nVar == null) {
                    return;
                }
                nVar.i(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void q0() {
        synchronized (this) {
            try {
                n nVar = this.f9648a;
                if (nVar == null) {
                    return;
                }
                nVar.d(this, 0, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void r0(int i10) {
        synchronized (this) {
            try {
                n nVar = this.f9648a;
                if (nVar == null) {
                    return;
                }
                nVar.d(this, i10, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
