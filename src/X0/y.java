package x0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.customize.contacts.widget.FeedbackRelativeLayout;
import com.oplus.dialer.R;

/* compiled from: SceneDualSimLayoutBindingImpl.java */
/* loaded from: classes.dex */
public class y extends x {

    /* renamed from: O, reason: collision with root package name */
    public static final ViewDataBinding.i f37807O = null;

    /* renamed from: P, reason: collision with root package name */
    public static final SparseIntArray f37808P;

    /* renamed from: N, reason: collision with root package name */
    public long f37809N;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37808P = sparseIntArray;
        sparseIntArray.put(R.id.sim1_dial_btn, 1);
        sparseIntArray.put(R.id.sim1_btn, 2);
        sparseIntArray.put(R.id.sim1_name, 3);
        sparseIntArray.put(R.id.sim2_dial_btn, 4);
        sparseIntArray.put(R.id.sim2_btn, 5);
        sparseIntArray.put(R.id.sim2_name, 6);
    }

    public y(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 7, f37807O, f37808P));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        synchronized (this) {
            this.f37809N = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f37809N != 0) {
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
            this.f37809N = 1L;
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

    public y(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (LinearLayout) objArr[0], (ImageView) objArr[2], (FeedbackRelativeLayout) objArr[1], (TextView) objArr[3], (ImageView) objArr[5], (FeedbackRelativeLayout) objArr[4], (TextView) objArr[6]);
        this.f37809N = -1L;
        this.f37800G.setTag(null);
        c1(view);
        O0();
    }
}
