package j;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* compiled from: ActionMode.java */
/* renamed from: j.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1145b {

    /* renamed from: a, reason: collision with root package name */
    public Object f33672a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f33673b;

    /* compiled from: ActionMode.java */
    /* renamed from: j.b$a */
    /* loaded from: classes.dex */
    public interface a {
        boolean a(AbstractC1145b abstractC1145b, Menu menu);

        void b(AbstractC1145b abstractC1145b);

        boolean c(AbstractC1145b abstractC1145b, MenuItem menuItem);

        boolean d(AbstractC1145b abstractC1145b, Menu menu);
    }

    public abstract void a();

    public abstract View b();

    public abstract Menu c();

    public abstract MenuInflater d();

    public abstract CharSequence e();

    public Object f() {
        return this.f33672a;
    }

    public abstract CharSequence g();

    public boolean h() {
        return this.f33673b;
    }

    public abstract void i();

    public abstract boolean j();

    public abstract void k(View view);

    public abstract void l(int i10);

    public abstract void m(CharSequence charSequence);

    public void n(Object obj) {
        this.f33672a = obj;
    }

    public abstract void o(int i10);

    public abstract void p(CharSequence charSequence);

    public void q(boolean z10) {
        this.f33673b = z10;
    }
}
