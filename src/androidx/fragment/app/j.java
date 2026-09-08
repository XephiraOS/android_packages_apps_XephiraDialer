package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.N;

/* compiled from: FragmentController.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final l<?> f10171a;

    public j(l<?> lVar) {
        this.f10171a = lVar;
    }

    public static j b(l<?> lVar) {
        return new j((l) I.h.f(lVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        l<?> lVar = this.f10171a;
        lVar.f10177e.n(lVar, lVar, fragment);
    }

    public void c() {
        this.f10171a.f10177e.A();
    }

    @Deprecated
    public void d(Configuration configuration) {
        this.f10171a.f10177e.C(configuration, true);
    }

    public boolean e(MenuItem menuItem) {
        return this.f10171a.f10177e.D(menuItem);
    }

    public void f() {
        this.f10171a.f10177e.E();
    }

    public void g() {
        this.f10171a.f10177e.G();
    }

    public void h() {
        this.f10171a.f10177e.H();
    }

    public void i() {
        this.f10171a.f10177e.P();
    }

    public void j() {
        this.f10171a.f10177e.T();
    }

    public void k() {
        this.f10171a.f10177e.U();
    }

    public void l() {
        this.f10171a.f10177e.W();
    }

    public boolean m() {
        return this.f10171a.f10177e.e0(true);
    }

    public FragmentManager n() {
        return this.f10171a.f10177e;
    }

    public void o() {
        this.f10171a.f10177e.d1();
    }

    public View p(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f10171a.f10177e.A0().onCreateView(view, str, context, attributeSet);
    }

    @Deprecated
    public void q(Parcelable parcelable) {
        l<?> lVar = this.f10171a;
        if (lVar instanceof N) {
            lVar.f10177e.s1(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    @Deprecated
    public Parcelable r() {
        return this.f10171a.f10177e.v1();
    }
}
