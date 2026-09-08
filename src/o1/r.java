package O1;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.BR;
import com.android.incallui.R;
import e2.C0966a;
import java.io.Serializable;

/* compiled from: ItemAudioModeDialogBindingImpl.java */
/* loaded from: classes.dex */
public class r extends q {

    /* renamed from: O, reason: collision with root package name */
    public static final ViewDataBinding.i f2624O = null;

    /* renamed from: P, reason: collision with root package name */
    public static final SparseIntArray f2625P = null;

    /* renamed from: M, reason: collision with root package name */
    public final LinearLayout f2626M;

    /* renamed from: N, reason: collision with root package name */
    public long f2627N;

    public r(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 4, f2624O, f2625P));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        long j10;
        int i10;
        int i11;
        Serializable serializable;
        boolean z10;
        boolean z11;
        int i12;
        boolean z12;
        Serializable serializable2;
        int i13;
        boolean z13;
        boolean z14;
        Resources resources;
        int i14;
        long j11;
        Resources resources2;
        int i15;
        long j12;
        synchronized (this) {
            j10 = this.f2627N;
            this.f2627N = 0L;
        }
        boolean z15 = this.f2623L;
        boolean z16 = this.f2622K;
        C0966a c0966a = this.f2621J;
        long j13 = j10 & 9;
        if (j13 != 0) {
            if (j13 != 0) {
                if (z15) {
                    j12 = 128;
                } else {
                    j12 = 64;
                }
                j10 |= j12;
            }
            if (z15) {
                resources2 = this.f2626M.getResources();
                i15 = R.dimen.coui_popup_list_window_item_vertical_large_padding;
            } else {
                resources2 = this.f2626M.getResources();
                i15 = R.dimen.coui_popup_list_window_item_vertical_padding;
            }
            i10 = (int) resources2.getDimension(i15);
        } else {
            i10 = 0;
        }
        long j14 = j10 & 10;
        if (j14 != 0) {
            if (j14 != 0) {
                if (z16) {
                    j11 = 32;
                } else {
                    j11 = 16;
                }
                j10 |= j11;
            }
            if (z16) {
                resources = this.f2626M.getResources();
                i14 = R.dimen.coui_popup_list_window_item_vertical_large_padding;
            } else {
                resources = this.f2626M.getResources();
                i14 = R.dimen.coui_popup_list_window_item_vertical_padding;
            }
            i11 = (int) resources.getDimension(i14);
        } else {
            i11 = 0;
        }
        long j15 = j10 & 12;
        Serializable serializable3 = null;
        if (j15 != 0) {
            if (c0966a != null) {
                z13 = c0966a.c();
                serializable = c0966a.f();
                i12 = c0966a.e();
                z14 = c0966a.d();
            } else {
                serializable = null;
                z13 = false;
                i12 = 0;
                z14 = false;
            }
            if (serializable == null) {
                serializable = null;
            }
            if (serializable == null) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (j15 != 0) {
                if (z12) {
                    j10 |= 512;
                } else {
                    j10 |= 256;
                }
            }
            z10 = z13;
            z11 = z14;
        } else {
            serializable = null;
            z10 = false;
            z11 = false;
            i12 = 0;
            z12 = false;
        }
        if ((j10 & 512) != 0) {
            if (c0966a != null) {
                i13 = c0966a.g();
            } else {
                i13 = 0;
            }
            serializable2 = Integer.valueOf(i13);
        } else {
            serializable2 = null;
        }
        long j16 = 12 & j10;
        if (j16 != 0) {
            if (z12) {
                serializable3 = serializable2;
            } else {
                serializable3 = serializable;
            }
        }
        Serializable serializable4 = serializable3;
        if (j16 != 0) {
            com.android.incallui.mvvm.utils.d.c(this.f2618G, z10);
            com.android.incallui.mvvm.utils.d.f(this.f2618G, z11);
            com.android.incallui.mvvm.utils.d.f(this.f2626M, z11);
            com.android.incallui.mvvm.utils.d.f(this.f2619H, z11);
            com.android.incallui.mvvm.utils.d.g(this.f2619H, Integer.valueOf(i12));
            com.android.incallui.mvvm.utils.d.f(this.f2620I, z11);
            com.android.incallui.mvvm.utils.d.q(this.f2620I, serializable4);
            if (ViewDataBinding.I0() >= 11) {
                this.f2626M.setActivated(z10);
            }
        }
        if ((j10 & 9) != 0) {
            com.android.incallui.mvvm.utils.d.n(this.f2626M, i10);
        }
        if ((j10 & 10) != 0) {
            com.android.incallui.mvvm.utils.d.o(this.f2626M, i11);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f2627N != 0) {
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
            this.f2627N = 8L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (BR.isLastItem == i10) {
            k1(((Boolean) obj).booleanValue());
        } else if (BR.isFirstItem == i10) {
            j1(((Boolean) obj).booleanValue());
        } else if (BR.audioModeInfo == i10) {
            i1((C0966a) obj);
        } else {
            return false;
        }
        return true;
    }

    @Override // O1.q
    public void i1(C0966a c0966a) {
        this.f2621J = c0966a;
        synchronized (this) {
            this.f2627N |= 4;
        }
        r0(BR.audioModeInfo);
        super.W0();
    }

    @Override // O1.q
    public void j1(boolean z10) {
        this.f2622K = z10;
        synchronized (this) {
            this.f2627N |= 2;
        }
        r0(BR.isFirstItem);
        super.W0();
    }

    @Override // O1.q
    public void k1(boolean z10) {
        this.f2623L = z10;
        synchronized (this) {
            this.f2627N |= 1;
        }
        r0(BR.isLastItem);
        super.W0();
    }

    public r(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (CheckBox) objArr[3], (ImageView) objArr[1], (TextView) objArr[2]);
        this.f2627N = -1L;
        this.f2618G.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f2626M = linearLayout;
        linearLayout.setTag(null);
        this.f2619H.setTag(null);
        this.f2620I.setTag(null);
        c1(view);
        O0();
    }
}
