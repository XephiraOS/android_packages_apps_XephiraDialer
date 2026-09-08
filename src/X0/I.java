package x0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.customize.contacts.widget.FeedbackLinearLayout;
import com.oplus.dialer.R;

/* compiled from: SceneSwitchSimLayoutBindingImpl.java */
/* loaded from: classes.dex */
public class I extends H {

    /* renamed from: N, reason: collision with root package name */
    public static final ViewDataBinding.i f37679N = null;

    /* renamed from: O, reason: collision with root package name */
    public static final SparseIntArray f37680O;

    /* renamed from: L, reason: collision with root package name */
    public final FrameLayout f37681L;

    /* renamed from: M, reason: collision with root package name */
    public long f37682M;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37680O = sparseIntArray;
        sparseIntArray.put(R.id.switch_button_parent, 1);
        sparseIntArray.put(R.id.button_switch, 2);
        sparseIntArray.put(R.id.switch_sim_dial_parent, 3);
        sparseIntArray.put(R.id.dial_sim, 4);
        sparseIntArray.put(R.id.sim_name, 5);
    }

    public I(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 6, f37679N, f37680O));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        synchronized (this) {
            this.f37682M = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f37682M != 0) {
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
            this.f37682M = 1L;
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

    public I(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageSwitcher) objArr[2], (ImageView) objArr[4], (TextView) objArr[5], (FeedbackLinearLayout) objArr[1], (FeedbackLinearLayout) objArr[3]);
        this.f37682M = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f37681L = frameLayout;
        frameLayout.setTag(null);
        c1(view);
        O0();
    }
}
