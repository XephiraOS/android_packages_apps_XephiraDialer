package x0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.coui.appcompat.button.COUIButton;
import com.oplus.dialer.R;

/* compiled from: SceneNoAgreePermissionOrStatementBindingImpl.java */
/* loaded from: classes.dex */
public class C extends AbstractC1662B {

    /* renamed from: M, reason: collision with root package name */
    public static final ViewDataBinding.i f37661M = null;

    /* renamed from: N, reason: collision with root package name */
    public static final SparseIntArray f37662N;

    /* renamed from: L, reason: collision with root package name */
    public long f37663L;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37662N = sparseIntArray;
        sparseIntArray.put(R.id.title, 1);
        sparseIntArray.put(R.id.imageView, 2);
        sparseIntArray.put(R.id.permission_or_statement_hint, 3);
        sparseIntArray.put(R.id.action_view, 4);
    }

    public C(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 5, f37661M, f37662N));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        synchronized (this) {
            this.f37663L = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f37663L != 0) {
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
            this.f37663L = 1L;
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

    public C(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (COUIButton) objArr[4], (ImageView) objArr[2], (ConstraintLayout) objArr[0], (TextView) objArr[3], (TextView) objArr[1]);
        this.f37663L = -1L;
        this.f37658I.setTag(null);
        c1(view);
        O0();
    }
}
