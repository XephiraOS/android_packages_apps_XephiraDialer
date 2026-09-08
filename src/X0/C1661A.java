package x0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.android.contacts.dialpad.HighLightNumber;
import com.android.contacts.dialpad.view.HighLightView;
import com.oplus.dialer.R;

/* compiled from: SceneItemCallLogBindingImpl.java */
/* renamed from: x0.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1661A extends z {

    /* renamed from: Q, reason: collision with root package name */
    public static final ViewDataBinding.i f37652Q = null;

    /* renamed from: R, reason: collision with root package name */
    public static final SparseIntArray f37653R;

    /* renamed from: O, reason: collision with root package name */
    public final ConstraintLayout f37654O;

    /* renamed from: P, reason: collision with root package name */
    public long f37655P;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37653R = sparseIntArray;
        sparseIntArray.put(R.id.call_type, 1);
        sparseIntArray.put(R.id.name, 2);
        sparseIntArray.put(R.id.sim_card, 3);
        sparseIntArray.put(R.id.breeno_icon, 4);
        sparseIntArray.put(R.id.breeno_text, 5);
        sparseIntArray.put(R.id.tag, 6);
        sparseIntArray.put(R.id.number, 7);
        sparseIntArray.put(R.id.date, 8);
    }

    public C1661A(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 9, f37652Q, f37653R));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        synchronized (this) {
            this.f37655P = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f37655P != 0) {
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
            this.f37655P = 1L;
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

    public C1661A(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[4], (TextView) objArr[5], (ImageView) objArr[1], (TextView) objArr[8], (HighLightView) objArr[2], (HighLightNumber) objArr[7], (ImageView) objArr[3], (TextView) objArr[6]);
        this.f37655P = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f37654O = constraintLayout;
        constraintLayout.setTag(null);
        c1(view);
        O0();
    }
}
