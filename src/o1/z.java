package O1;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.BR;
import com.android.incallui.R;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.view.FloatingWindowConstraintLayout;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DefaultFloatingWindowViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel;
import com.android.incallui.oplus.widgets.AdaptiveFontWeightTextView;
import com.android.incallui.oplus.widgets.AutoWrapTextView;

/* compiled from: OplusIncallFloatingDefaultViewBindingImpl.java */
/* loaded from: classes.dex */
public class z extends y {

    /* renamed from: f0, reason: collision with root package name */
    public static final ViewDataBinding.i f2669f0 = null;

    /* renamed from: g0, reason: collision with root package name */
    public static final SparseIntArray f2670g0;

    /* renamed from: X, reason: collision with root package name */
    public final FloatingWindowConstraintLayout f2671X;

    /* renamed from: Y, reason: collision with root package name */
    public final View f2672Y;

    /* renamed from: Z, reason: collision with root package name */
    public final TextView f2673Z;

    /* renamed from: a0, reason: collision with root package name */
    public final TextView f2674a0;

    /* renamed from: b0, reason: collision with root package name */
    public final TextView f2675b0;

    /* renamed from: c0, reason: collision with root package name */
    public final AdaptiveFontWeightTextView f2676c0;

    /* renamed from: d0, reason: collision with root package name */
    public final AdaptiveFontWeightTextView f2677d0;

    /* renamed from: e0, reason: collision with root package name */
    public long f2678e0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2670g0 = sparseIntArray;
        sparseIntArray.put(R.id.left_btn_decline, 17);
        sparseIntArray.put(R.id.left_btn_speaker, 18);
        sparseIntArray.put(R.id.right_btn_answer, 19);
        sparseIntArray.put(R.id.right_button_decline_icon, 20);
    }

    public z(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 21, f2669f0, f2670g0));
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0370 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0201  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0() {
        /*
            Method dump skipped, instructions count: 1661
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O1.z.A0():void");
    }

    public final boolean A1(NonNullObservableField<Boolean> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 32;
            }
            return true;
        }
        return false;
    }

    public final boolean B1(LocalObservableField<com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 8192;
            }
            return true;
        }
        return false;
    }

    public final boolean C1(LocalObservableField<Integer> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 64;
            }
            return true;
        }
        return false;
    }

    public final boolean D1(LocalObservableField<Integer> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 4;
            }
            return true;
        }
        return false;
    }

    public final boolean E1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 4096;
            }
            return true;
        }
        return false;
    }

    public final boolean F1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 2048;
            }
            return true;
        }
        return false;
    }

    public void G1(FloatingWindowCommandViewModel floatingWindowCommandViewModel) {
        this.f2668W = floatingWindowCommandViewModel;
        synchronized (this) {
            this.f2678e0 |= 8388608;
        }
        r0(BR.commandViewModel);
        super.W0();
    }

    public void H1(FloatingWindowViewModel floatingWindowViewModel) {
        this.f2667V = floatingWindowViewModel;
        synchronized (this) {
            this.f2678e0 |= 16777216;
        }
        r0(BR.commonViewModel);
        super.W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f2678e0 != 0) {
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
            this.f2678e0 = 67108864L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        switch (i10) {
            case 0:
                return l1((LocalObservableField) obj, i11);
            case 1:
                return w1((NonNullObservableField) obj, i11);
            case 2:
                return D1((LocalObservableField) obj, i11);
            case 3:
                return j1((LocalObservableField) obj, i11);
            case 4:
                return p1((LocalObservableField) obj, i11);
            case 5:
                return A1((NonNullObservableField) obj, i11);
            case 6:
                return C1((LocalObservableField) obj, i11);
            case 7:
                return z1((NonNullObservableField) obj, i11);
            case 8:
                return m1((NonNullObservableField) obj, i11);
            case 9:
                return u1((LocalObservableField) obj, i11);
            case 10:
                return s1((NonNullObservableField) obj, i11);
            case 11:
                return F1((NonNullObservableField) obj, i11);
            case 12:
                return E1((NonNullObservableField) obj, i11);
            case 13:
                return B1((LocalObservableField) obj, i11);
            case 14:
                return y1((NonNullObservableField) obj, i11);
            case 15:
                return n1((NonNullObservableField) obj, i11);
            case 16:
                return t1((LocalObservableField) obj, i11);
            case 17:
                return x1((NonNullObservableField) obj, i11);
            case 18:
                return k1((NonNullObservableField) obj, i11);
            case 19:
                return q1((LocalObservableField) obj, i11);
            case 20:
                return v1((LocalObservableField) obj, i11);
            case 21:
                return o1((NonNullObservableField) obj, i11);
            case 22:
                return r1((LocalObservableField) obj, i11);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (BR.commandViewModel == i10) {
            G1((FloatingWindowCommandViewModel) obj);
        } else if (BR.commonViewModel == i10) {
            H1((FloatingWindowViewModel) obj);
        } else if (BR.viewModel == i10) {
            i1((DefaultFloatingWindowViewModel) obj);
        } else {
            return false;
        }
        return true;
    }

    @Override // O1.y
    public void i1(DefaultFloatingWindowViewModel defaultFloatingWindowViewModel) {
        this.f2666U = defaultFloatingWindowViewModel;
        synchronized (this) {
            this.f2678e0 |= 33554432;
        }
        r0(BR.viewModel);
        super.W0();
    }

    public final boolean j1(LocalObservableField<String> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 8;
            }
            return true;
        }
        return false;
    }

    public final boolean k1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 262144;
            }
            return true;
        }
        return false;
    }

    public final boolean l1(LocalObservableField<String> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 1;
            }
            return true;
        }
        return false;
    }

    public final boolean m1(NonNullObservableField<Boolean> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 256;
            }
            return true;
        }
        return false;
    }

    public final boolean n1(NonNullObservableField<Boolean> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 32768;
            }
            return true;
        }
        return false;
    }

    public final boolean o1(NonNullObservableField<Boolean> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 2097152;
            }
            return true;
        }
        return false;
    }

    public final boolean p1(LocalObservableField<com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 16;
            }
            return true;
        }
        return false;
    }

    public final boolean q1(LocalObservableField<String> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 524288;
            }
            return true;
        }
        return false;
    }

    public final boolean r1(LocalObservableField<String> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 4194304;
            }
            return true;
        }
        return false;
    }

    public final boolean s1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 1024;
            }
            return true;
        }
        return false;
    }

    public final boolean t1(LocalObservableField<String> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 65536;
            }
            return true;
        }
        return false;
    }

    public final boolean u1(LocalObservableField<Integer> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 512;
            }
            return true;
        }
        return false;
    }

    public final boolean v1(LocalObservableField<Integer> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 1048576;
            }
            return true;
        }
        return false;
    }

    public final boolean w1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 2;
            }
            return true;
        }
        return false;
    }

    public final boolean x1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 131072;
            }
            return true;
        }
        return false;
    }

    public final boolean y1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 16384;
            }
            return true;
        }
        return false;
    }

    public final boolean z1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2678e0 |= 128;
            }
            return true;
        }
        return false;
    }

    public z(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 23, (ImageView) objArr[4], (TextSwitcher) objArr[1], (TextSwitcher) objArr[5], (AutoWrapTextView) objArr[8], (TextView) objArr[9], (ImageView) objArr[17], (ImageView) objArr[18], (ImageSwitcher) objArr[10], (ImageView) objArr[19], (ImageSwitcher) objArr[11], (ImageView) objArr[20], (TextView) objArr[15], (TextView) objArr[16], (FrameLayout) objArr[12]);
        this.f2678e0 = -1L;
        this.f2652G.setTag(null);
        this.f2653H.setTag(null);
        this.f2654I.setTag(null);
        this.f2655J.setTag(null);
        this.f2656K.setTag(null);
        this.f2659N.setTag(null);
        FloatingWindowConstraintLayout floatingWindowConstraintLayout = (FloatingWindowConstraintLayout) objArr[0];
        this.f2671X = floatingWindowConstraintLayout;
        floatingWindowConstraintLayout.setTag(null);
        View view2 = (View) objArr[13];
        this.f2672Y = view2;
        view2.setTag(null);
        TextView textView = (TextView) objArr[14];
        this.f2673Z = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f2674a0 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.f2675b0 = textView3;
        textView3.setTag(null);
        AdaptiveFontWeightTextView adaptiveFontWeightTextView = (AdaptiveFontWeightTextView) objArr[6];
        this.f2676c0 = adaptiveFontWeightTextView;
        adaptiveFontWeightTextView.setTag(null);
        AdaptiveFontWeightTextView adaptiveFontWeightTextView2 = (AdaptiveFontWeightTextView) objArr[7];
        this.f2677d0 = adaptiveFontWeightTextView2;
        adaptiveFontWeightTextView2.setTag(null);
        this.f2661P.setTag(null);
        this.f2663R.setTag(null);
        this.f2664S.setTag(null);
        this.f2665T.setTag(null);
        c1(view);
        O0();
    }
}
