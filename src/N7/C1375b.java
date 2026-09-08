package n7;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.COUICollapsableAppBarLayout;
import com.google.android.material.appbar.COUICollapsingToolbarLayout;
import m7.e;

/* compiled from: CollapsingAppbarLayoutBindingImpl.java */
/* renamed from: n7.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1375b extends AbstractC1374a {

    /* renamed from: M, reason: collision with root package name */
    public static final ViewDataBinding.i f35632M = null;

    /* renamed from: N, reason: collision with root package name */
    public static final SparseIntArray f35633N;

    /* renamed from: L, reason: collision with root package name */
    public long f35634L;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35633N = sparseIntArray;
        sparseIntArray.put(e.f35180b, 1);
        sparseIntArray.put(e.f35183e, 2);
        sparseIntArray.put(e.f35181c, 3);
        sparseIntArray.put(e.f35182d, 4);
    }

    public C1375b(f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 5, f35632M, f35633N));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        synchronized (this) {
            this.f35634L = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f35634L != 0) {
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
            this.f35634L = 1L;
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

    public C1375b(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (COUICollapsableAppBarLayout) objArr[0], (COUICollapsingToolbarLayout) objArr[1], (ConstraintLayout) objArr[3], (TextView) objArr[4], (COUIToolbar) objArr[2]);
        this.f35634L = -1L;
        this.f35627G.setTag(null);
        c1(view);
        O0();
    }
}
