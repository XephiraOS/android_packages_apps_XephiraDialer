package x0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.InterfaceC0492o;
import com.customize.contacts.ui.UnfoldContainerView;
import com.oplus.dialer.R;

/* compiled from: ContactsMainListFragmentLayoutUnfoldBindingImpl.java */
/* renamed from: x0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1668f extends AbstractC1667e {

    /* renamed from: K, reason: collision with root package name */
    public static final ViewDataBinding.i f37704K;

    /* renamed from: L, reason: collision with root package name */
    public static final SparseIntArray f37705L;

    /* renamed from: J, reason: collision with root package name */
    public long f37706J;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(3);
        f37704K = iVar;
        iVar.a(0, new String[]{"contacts_main_list_fragment_layout"}, new int[]{1}, new int[]{R.layout.contacts_main_list_fragment_layout});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37705L = sparseIntArray;
        sparseIntArray.put(R.id.foldable_contact_right_container, 2);
    }

    public C1668f(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 3, f37704K, f37705L));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        synchronized (this) {
            this.f37706J = 0L;
        }
        ViewDataBinding.C0(this.f37703I);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f37706J != 0) {
                    return true;
                }
                if (this.f37703I.M0()) {
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
            this.f37706J = 2L;
        }
        this.f37703I.O0();
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        if (i10 != 0) {
            return false;
        }
        return i1((AbstractC1665c) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void b1(InterfaceC0492o interfaceC0492o) {
        super.b1(interfaceC0492o);
        this.f37703I.b1(interfaceC0492o);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        return true;
    }

    public final boolean i1(AbstractC1665c abstractC1665c, int i10) {
        if (i10 == 0) {
            synchronized (this) {
                this.f37706J |= 1;
            }
            return true;
        }
        return false;
    }

    public C1668f(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (UnfoldContainerView) objArr[0], (FrameLayout) objArr[2], (AbstractC1665c) objArr[1]);
        this.f37706J = -1L;
        this.f37701G.setTag(null);
        a1(this.f37703I);
        c1(view);
        O0();
    }
}
