package n7;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.COUIDividerAppBarLayout;
import m7.e;

/* compiled from: DividerAppbarLayoutBindingImpl.java */
/* loaded from: classes3.dex */
public class d extends c {

    /* renamed from: J, reason: collision with root package name */
    public static final ViewDataBinding.i f35637J = null;

    /* renamed from: K, reason: collision with root package name */
    public static final SparseIntArray f35638K;

    /* renamed from: I, reason: collision with root package name */
    public long f35639I;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35638K = sparseIntArray;
        sparseIntArray.put(e.f35183e, 1);
    }

    public d(f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 2, f35637J, f35638K));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        synchronized (this) {
            this.f35639I = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f35639I != 0) {
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
            this.f35639I = 1L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        return true;
    }

    public d(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (COUIDividerAppBarLayout) objArr[0], (COUIToolbar) objArr[1]);
        this.f35639I = -1L;
        this.f35635G.setTag(null);
        c1(view);
        O0();
    }
}
