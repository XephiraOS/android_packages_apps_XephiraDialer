package x0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.android.contacts.dialpad.view.DialEditText;
import com.customize.contacts.widget.DialDeleteImageButton;
import com.customize.contacts.widget.DigitsContainer;
import com.oplus.dialer.R;

/* compiled from: SceneDialEditTextContainerBindingImpl.java */
/* loaded from: classes.dex */
public class u extends t {

    /* renamed from: M, reason: collision with root package name */
    public static final ViewDataBinding.i f37787M = null;

    /* renamed from: N, reason: collision with root package name */
    public static final SparseIntArray f37788N;

    /* renamed from: L, reason: collision with root package name */
    public long f37789L;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37788N = sparseIntArray;
        sparseIntArray.put(R.id.dial_edit_text, 1);
        sparseIntArray.put(R.id.dial_del, 2);
        sparseIntArray.put(R.id.location, 3);
        sparseIntArray.put(R.id.bottom_divider_line, 4);
    }

    public u(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 5, f37787M, f37788N));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        synchronized (this) {
            this.f37789L = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f37789L != 0) {
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
            this.f37789L = 1L;
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

    public u(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (View) objArr[4], (DialDeleteImageButton) objArr[2], (DialEditText) objArr[1], (DigitsContainer) objArr[0], (TextView) objArr[3]);
        this.f37789L = -1L;
        this.f37785J.setTag(null);
        c1(view);
        O0();
    }
}
