package x0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.customize.contacts.widget.FeedbackRelativeLayout;
import com.oplus.dialer.R;

/* compiled from: SceneSingleSimLayoutBindingImpl.java */
/* loaded from: classes.dex */
public class G extends F {

    /* renamed from: J, reason: collision with root package name */
    public static final ViewDataBinding.i f37671J = null;

    /* renamed from: K, reason: collision with root package name */
    public static final SparseIntArray f37672K;

    /* renamed from: I, reason: collision with root package name */
    public long f37673I;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37672K = sparseIntArray;
        sparseIntArray.put(R.id.sim_btn, 1);
    }

    public G(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 2, f37671J, f37672K));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        synchronized (this) {
            this.f37673I = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f37673I != 0) {
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
            this.f37673I = 1L;
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

    public G(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[1], (FeedbackRelativeLayout) objArr[0]);
        this.f37673I = -1L;
        this.f37670H.setTag(null);
        c1(view);
        O0();
    }
}
