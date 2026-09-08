package x0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.InterfaceC0492o;
import com.customize.contacts.widget.ContactTouchSearchView;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;

/* compiled from: ContactsMainListFragmentLayoutBindingImpl.java */
/* renamed from: x0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1666d extends AbstractC1665c {

    /* renamed from: N, reason: collision with root package name */
    public static final ViewDataBinding.i f37698N;

    /* renamed from: O, reason: collision with root package name */
    public static final SparseIntArray f37699O;

    /* renamed from: M, reason: collision with root package name */
    public long f37700M;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(6);
        f37698N = iVar;
        iVar.a(1, new String[]{"contacts_main_list_collapsing_appbar_layout"}, new int[]{2}, new int[]{R.layout.contacts_main_list_collapsing_appbar_layout});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37699O = sparseIntArray;
        sparseIntArray.put(R.id.empty_fragment_container, 3);
        sparseIntArray.put(R.id.contacts_main_list_view, 4);
        sparseIntArray.put(R.id.spell_bar, 5);
    }

    public C1666d(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 6, f37698N, f37699O));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        synchronized (this) {
            this.f37700M = 0L;
        }
        ViewDataBinding.C0(this.f37692G);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f37700M != 0) {
                    return true;
                }
                if (this.f37692G.M0()) {
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
            this.f37700M = 2L;
        }
        this.f37692G.O0();
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        if (i10 != 0) {
            return false;
        }
        return i1((AbstractC1663a) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void b1(InterfaceC0492o interfaceC0492o) {
        super.b1(interfaceC0492o);
        this.f37692G.b1(interfaceC0492o);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        return true;
    }

    public final boolean i1(AbstractC1663a abstractC1663a, int i10) {
        if (i10 == 0) {
            synchronized (this) {
                this.f37700M |= 1;
            }
            return true;
        }
        return false;
    }

    public C1666d(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (AbstractC1663a) objArr[2], (HeaderFooterRecyclerView) objArr[4], (FrameLayout) objArr[3], (CoordinatorLayout) objArr[1], (FrameLayout) objArr[0], (ContactTouchSearchView) objArr[5]);
        this.f37700M = -1L;
        a1(this.f37692G);
        this.f37695J.setTag(null);
        this.f37696K.setTag(null);
        c1(view);
        O0();
    }
}
