package x0;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import com.android.contacts.dialpad.view.DialpadView;
import com.customize.contacts.widget.ScrollRelativeLayout;
import com.oplus.dialer.R;

/* compiled from: SceneDialpadBindingImpl.java */
/* loaded from: classes.dex */
public class w extends v {

    /* renamed from: O, reason: collision with root package name */
    public static final ViewDataBinding.i f37797O = null;

    /* renamed from: P, reason: collision with root package name */
    public static final SparseIntArray f37798P;

    /* renamed from: N, reason: collision with root package name */
    public long f37799N;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37798P = sparseIntArray;
        sparseIntArray.put(R.id.dialpad_parent, 1);
        sparseIntArray.put(R.id.dialpad, 2);
        sparseIntArray.put(R.id.sim_layout_parent, 3);
        sparseIntArray.put(R.id.switch_sim_layout, 4);
        sparseIntArray.put(R.id.single_sim_layout, 5);
        sparseIntArray.put(R.id.dual_sim_layout, 6);
    }

    public w(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 7, f37797O, f37798P));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        synchronized (this) {
            this.f37799N = 0L;
        }
        if (this.f37793J.g() != null) {
            ViewDataBinding.C0(this.f37793J.g());
        }
        if (this.f37795L.g() != null) {
            ViewDataBinding.C0(this.f37795L.g());
        }
        if (this.f37796M.g() != null) {
            ViewDataBinding.C0(this.f37796M.g());
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f37799N != 0) {
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
            this.f37799N = 1L;
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

    public w(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (DialpadView) objArr[2], (ScrollRelativeLayout) objArr[0], (FrameLayout) objArr[1], new androidx.databinding.o((ViewStub) objArr[6]), (FrameLayout) objArr[3], new androidx.databinding.o((ViewStub) objArr[5]), new androidx.databinding.o((ViewStub) objArr[4]));
        this.f37799N = -1L;
        this.f37791H.setTag(null);
        this.f37793J.k(this);
        this.f37795L.k(this);
        this.f37796M.k(this);
        c1(view);
        O0();
    }
}
