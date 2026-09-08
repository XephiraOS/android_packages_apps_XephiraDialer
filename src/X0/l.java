package x0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.InterfaceC0492o;
import com.oplus.dialer.R;
import f.C0991a;

/* compiled from: ContactsMainListItemWithHeaderBindingImpl.java */
/* loaded from: classes.dex */
public class l extends k {

    /* renamed from: M, reason: collision with root package name */
    public static final ViewDataBinding.i f37734M;

    /* renamed from: N, reason: collision with root package name */
    public static final SparseIntArray f37735N;

    /* renamed from: J, reason: collision with root package name */
    public final LinearLayout f37736J;

    /* renamed from: K, reason: collision with root package name */
    public androidx.databinding.h f37737K;

    /* renamed from: L, reason: collision with root package name */
    public long f37738L;

    /* compiled from: ContactsMainListItemWithHeaderBindingImpl.java */
    /* loaded from: classes.dex */
    public class a implements androidx.databinding.h {
        public a() {
        }

        @Override // androidx.databinding.h
        public void onChange() {
            String a10 = L.c.a(l.this.f37732H);
            l lVar = l.this;
            String str = lVar.f37733I;
            if (lVar != null) {
                lVar.i1(a10);
            }
        }
    }

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(3);
        f37734M = iVar;
        iVar.a(0, new String[]{"contacts_main_list_item"}, new int[]{2}, new int[]{R.layout.contacts_main_list_item});
        f37735N = null;
    }

    public l(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 3, f37734M, f37735N));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        long j10;
        synchronized (this) {
            j10 = this.f37738L;
            this.f37738L = 0L;
        }
        String str = this.f37733I;
        if ((6 & j10) != 0) {
            L.c.e(this.f37732H, str);
        }
        if ((j10 & 4) != 0) {
            TextView textView = this.f37732H;
            com.oplus.contacts.list.g.b(textView, C0991a.b(textView.getContext(), R.drawable.pb_bg_title));
            L.c.f(this.f37732H, null, null, null, this.f37737K);
        }
        ViewDataBinding.C0(this.f37731G);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f37738L != 0) {
                    return true;
                }
                if (this.f37731G.M0()) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void O0() {
        synchronized (this) {
            this.f37738L = 4L;
        }
        this.f37731G.O0();
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        if (i10 != 0) {
            return false;
        }
        return j1((AbstractC1671i) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void b1(InterfaceC0492o interfaceC0492o) {
        super.b1(interfaceC0492o);
        this.f37731G.b1(interfaceC0492o);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (7 == i10) {
            i1((String) obj);
            return true;
        }
        return false;
    }

    @Override // x0.k
    public void i1(String str) {
        this.f37733I = str;
        synchronized (this) {
            this.f37738L |= 2;
        }
        r0(7);
        super.W0();
    }

    public final boolean j1(AbstractC1671i abstractC1671i, int i10) {
        if (i10 == 0) {
            synchronized (this) {
                this.f37738L |= 1;
            }
            return true;
        }
        return false;
    }

    public l(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (AbstractC1671i) objArr[2], (TextView) objArr[1]);
        this.f37737K = new a();
        this.f37738L = -1L;
        a1(this.f37731G);
        this.f37732H.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f37736J = linearLayout;
        linearLayout.setTag(null);
        c1(view);
        O0();
    }
}
