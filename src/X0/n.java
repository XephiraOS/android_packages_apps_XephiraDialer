package x0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.InterfaceC0492o;
import com.oplus.dialer.R;
import f.C0991a;

/* compiled from: ContactsMainListItemWithHeaderStarBindingImpl.java */
/* loaded from: classes.dex */
public class n extends m {

    /* renamed from: K, reason: collision with root package name */
    public static final ViewDataBinding.i f37742K;

    /* renamed from: L, reason: collision with root package name */
    public static final SparseIntArray f37743L;

    /* renamed from: I, reason: collision with root package name */
    public final LinearLayout f37744I;

    /* renamed from: J, reason: collision with root package name */
    public long f37745J;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(3);
        f37742K = iVar;
        iVar.a(0, new String[]{"contacts_main_list_item"}, new int[]{2}, new int[]{R.layout.contacts_main_list_item});
        f37743L = null;
    }

    public n(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 3, f37742K, f37743L));
    }

    private boolean i1(AbstractC1671i abstractC1671i, int i10) {
        if (i10 == 0) {
            synchronized (this) {
                this.f37745J |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        long j10;
        synchronized (this) {
            j10 = this.f37745J;
            this.f37745J = 0L;
        }
        if ((j10 & 2) != 0) {
            TextView textView = this.f37741H;
            com.oplus.contacts.list.g.b(textView, C0991a.b(textView.getContext(), R.drawable.pb_bg_title));
        }
        ViewDataBinding.C0(this.f37740G);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f37745J != 0) {
                    return true;
                }
                if (this.f37740G.M0()) {
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
            this.f37745J = 2L;
        }
        this.f37740G.O0();
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        if (i10 != 0) {
            return false;
        }
        return i1((AbstractC1671i) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void b1(InterfaceC0492o interfaceC0492o) {
        super.b1(interfaceC0492o);
        this.f37740G.b1(interfaceC0492o);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        return true;
    }

    public n(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (AbstractC1671i) objArr[2], (TextView) objArr[1]);
        this.f37745J = -1L;
        a1(this.f37740G);
        this.f37741H.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f37744I = linearLayout;
        linearLayout.setTag(null);
        c1(view);
        O0();
    }
}
