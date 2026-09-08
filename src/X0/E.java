package x0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.oplus.dialer.R;

/* compiled from: SceneNoCallLogBindingImpl.java */
/* loaded from: classes.dex */
public class E extends D {

    /* renamed from: J, reason: collision with root package name */
    public static final ViewDataBinding.i f37665J = null;

    /* renamed from: K, reason: collision with root package name */
    public static final SparseIntArray f37666K;

    /* renamed from: H, reason: collision with root package name */
    public final LinearLayout f37667H;

    /* renamed from: I, reason: collision with root package name */
    public long f37668I;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37666K = sparseIntArray;
        sparseIntArray.put(R.id.title, 1);
    }

    public E(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 2, f37665J, f37666K));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        synchronized (this) {
            this.f37668I = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f37668I != 0) {
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
            this.f37668I = 1L;
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

    public E(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TextView) objArr[1]);
        this.f37668I = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f37667H = linearLayout;
        linearLayout.setTag(null);
        c1(view);
        O0();
    }
}
