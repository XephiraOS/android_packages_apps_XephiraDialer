package x0;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import com.coui.appcompat.floatingactionbutton.COUIFloatingButton;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;

/* compiled from: FragmentSceneDialtactsBindingImpl.java */
/* loaded from: classes.dex */
public class p extends o {

    /* renamed from: O, reason: collision with root package name */
    public static final ViewDataBinding.i f37752O = null;

    /* renamed from: P, reason: collision with root package name */
    public static final SparseIntArray f37753P;

    /* renamed from: M, reason: collision with root package name */
    public final FrameLayout f37754M;

    /* renamed from: N, reason: collision with root package name */
    public long f37755N;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37753P = sparseIntArray;
        sparseIntArray.put(R.id.recycler_view, 1);
        sparseIntArray.put(R.id.dial_edit_text_container_view_stub, 2);
        sparseIntArray.put(R.id.no_call_log_view_stub, 3);
        sparseIntArray.put(R.id.permission_or_statement_view_stub, 4);
        sparseIntArray.put(R.id.dialpad_container_view_stub, 5);
        sparseIntArray.put(R.id.floating_button, 6);
    }

    public p(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 7, f37752O, f37753P));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        synchronized (this) {
            this.f37755N = 0L;
        }
        if (this.f37746G.g() != null) {
            ViewDataBinding.C0(this.f37746G.g());
        }
        if (this.f37747H.g() != null) {
            ViewDataBinding.C0(this.f37747H.g());
        }
        if (this.f37749J.g() != null) {
            ViewDataBinding.C0(this.f37749J.g());
        }
        if (this.f37750K.g() != null) {
            ViewDataBinding.C0(this.f37750K.g());
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f37755N != 0) {
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
            this.f37755N = 1L;
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

    public p(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, new androidx.databinding.o((ViewStub) objArr[2]), new androidx.databinding.o((ViewStub) objArr[5]), (COUIFloatingButton) objArr[6], new androidx.databinding.o((ViewStub) objArr[3]), new androidx.databinding.o((ViewStub) objArr[4]), (HeaderFooterRecyclerView) objArr[1]);
        this.f37755N = -1L;
        this.f37746G.k(this);
        this.f37747H.k(this);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f37754M = frameLayout;
        frameLayout.setTag(null);
        this.f37749J.k(this);
        this.f37750K.k(this);
        c1(view);
        O0();
    }
}
