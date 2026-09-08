package O1;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.BR;
import com.android.incallui.R;
import com.android.incallui.mvvm.command_model.ActionButtonCommandModel;
import com.android.incallui.mvvm.command_model.GlobalCommandModel;
import com.android.incallui.mvvm.view_model.ActionButtonViewModel;
import com.android.incallui.mvvm.view_model.OplusInCallViewModel;
import com.android.incallui.oplus.callbutton.callbuttonview.FunctionButtonLayout;
import com.android.incallui.oplus.widgets.ScaleImageView;
import kotlin.Triple;

/* compiled from: FragmentActionButtonBindingImpl.java */
/* renamed from: O1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0402h extends AbstractC0401g {

    /* renamed from: V, reason: collision with root package name */
    public static final ViewDataBinding.i f2567V = null;

    /* renamed from: W, reason: collision with root package name */
    public static final SparseIntArray f2568W;

    /* renamed from: T, reason: collision with root package name */
    public final LinearLayout f2569T;

    /* renamed from: U, reason: collision with root package name */
    public long f2570U;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2568W = sparseIntArray;
        sparseIntArray.put(R.id.audio_bg_circle, 6);
        sparseIntArray.put(R.id.dialpad_bg_circle, 7);
        sparseIntArray.put(R.id.dialpad_selected_image, 8);
        sparseIntArray.put(R.id.dialpad_image, 9);
    }

    public C0402h(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 10, f2567V, f2568W));
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009a  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0() {
        /*
            Method dump skipped, instructions count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O1.C0402h.A0():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f2570U != 0) {
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
            this.f2570U = 2048L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        switch (i10) {
            case 0:
                return u1((com.android.incallui.mvvm.utils.y) obj, i11);
            case 1:
                return o1((com.android.incallui.mvvm.utils.h) obj, i11);
            case 2:
                return s1((com.android.incallui.mvvm.utils.y) obj, i11);
            case 3:
                return r1((com.android.incallui.mvvm.utils.h) obj, i11);
            case 4:
                return q1((com.android.incallui.mvvm.utils.h) obj, i11);
            case 5:
                return t1((com.android.incallui.mvvm.utils.y) obj, i11);
            case 6:
                return p1((com.android.incallui.mvvm.utils.h) obj, i11);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (BR.mGlobeCommandModel == i10) {
            l1((GlobalCommandModel) obj);
        } else if (BR.mCommandModel == i10) {
            k1((ActionButtonCommandModel) obj);
        } else if (BR.mOplusInCallViewModel == i10) {
            m1((OplusInCallViewModel) obj);
        } else if (BR.mViewModel == i10) {
            n1((ActionButtonViewModel) obj);
        } else {
            return false;
        }
        return true;
    }

    @Override // O1.AbstractC0401g
    public void k1(ActionButtonCommandModel actionButtonCommandModel) {
        this.f2565R = actionButtonCommandModel;
        synchronized (this) {
            this.f2570U |= 256;
        }
        r0(BR.mCommandModel);
        super.W0();
    }

    @Override // O1.AbstractC0401g
    public void l1(GlobalCommandModel globalCommandModel) {
        this.f2566S = globalCommandModel;
    }

    @Override // O1.AbstractC0401g
    public void m1(OplusInCallViewModel oplusInCallViewModel) {
        this.f2564Q = oplusInCallViewModel;
        synchronized (this) {
            this.f2570U |= 512;
        }
        r0(BR.mOplusInCallViewModel);
        super.W0();
    }

    @Override // O1.AbstractC0401g
    public void n1(ActionButtonViewModel actionButtonViewModel) {
        this.f2563P = actionButtonViewModel;
        synchronized (this) {
            this.f2570U |= 1024;
        }
        r0(BR.mViewModel);
        super.W0();
    }

    public final boolean o1(com.android.incallui.mvvm.utils.h<Integer> hVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2570U |= 2;
            }
            return true;
        }
        return false;
    }

    public final boolean p1(com.android.incallui.mvvm.utils.h<Boolean> hVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2570U |= 64;
            }
            return true;
        }
        return false;
    }

    public final boolean q1(com.android.incallui.mvvm.utils.h<Integer> hVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2570U |= 16;
            }
            return true;
        }
        return false;
    }

    public final boolean r1(com.android.incallui.mvvm.utils.h<Boolean> hVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2570U |= 8;
            }
            return true;
        }
        return false;
    }

    public final boolean s1(com.android.incallui.mvvm.utils.y<Triple<Integer, Integer, Integer>> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2570U |= 4;
            }
            return true;
        }
        return false;
    }

    public final boolean t1(com.android.incallui.mvvm.utils.y<Boolean> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2570U |= 32;
            }
            return true;
        }
        return false;
    }

    public final boolean u1(com.android.incallui.mvvm.utils.y<Integer> yVar, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2570U |= 1;
            }
            return true;
        }
        return false;
    }

    public C0402h(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 7, (ImageView) objArr[6], (FunctionButtonLayout) objArr[1], (ImageView) objArr[3], (ImageView) objArr[2], (ImageView) objArr[7], (FunctionButtonLayout) objArr[5], (ImageView) objArr[9], (ImageView) objArr[8], (ScaleImageView) objArr[4]);
        this.f2570U = -1L;
        this.f2555H.setTag(null);
        this.f2556I.setTag(null);
        this.f2557J.setTag(null);
        this.f2559L.setTag(null);
        this.f2562O.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f2569T = linearLayout;
        linearLayout.setTag(null);
        c1(view);
        O0();
    }
}
