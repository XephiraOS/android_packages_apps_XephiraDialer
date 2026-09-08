package O1;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.BR;
import com.android.incallui.R;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.view.FloatingWindowConstraintLayout;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DriveModeFloatingWindowViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel;
import com.android.incallui.oplus.widgets.AutoWrapTextView;

/* compiled from: OplusIncallFloatingDriverModeViewBindingImpl.java */
/* loaded from: classes.dex */
public class B extends A {

    /* renamed from: b0, reason: collision with root package name */
    public static final ViewDataBinding.i f2452b0 = null;

    /* renamed from: c0, reason: collision with root package name */
    public static final SparseIntArray f2453c0;

    /* renamed from: Y, reason: collision with root package name */
    public final TextView f2454Y;

    /* renamed from: Z, reason: collision with root package name */
    public final TextView f2455Z;

    /* renamed from: a0, reason: collision with root package name */
    public long f2456a0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2453c0 = sparseIntArray;
        sparseIntArray.put(R.id.left_btn_decline, 11);
        sparseIntArray.put(R.id.left_btn_speaker, 12);
        sparseIntArray.put(R.id.oplus_display_info_area, 13);
        sparseIntArray.put(R.id.secondline, 14);
        sparseIntArray.put(R.id.right_btn_answer, 15);
        sparseIntArray.put(R.id.right_button_decline_icon, 16);
    }

    public B(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 17, f2452b0, f2453c0));
    }

    private boolean j1(LocalObservableField<String> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2456a0 |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean k1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2456a0 |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean m1(LocalObservableField<String> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2456a0 |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean o1(NonNullObservableField<Boolean> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2456a0 |= 16384;
            }
            return true;
        }
        return false;
    }

    private boolean p1(NonNullObservableField<Boolean> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2456a0 |= 8192;
            }
            return true;
        }
        return false;
    }

    private boolean q1(LocalObservableField<com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2456a0 |= 512;
            }
            return true;
        }
        return false;
    }

    private boolean r1(LocalObservableField<String> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2456a0 |= 1024;
            }
            return true;
        }
        return false;
    }

    private boolean t1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2456a0 |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean u1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2456a0 |= 4096;
            }
            return true;
        }
        return false;
    }

    private boolean v1(LocalObservableField<com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2456a0 |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean w1(LocalObservableField<Integer> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2456a0 |= 16;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01e0  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0() {
        /*
            Method dump skipped, instructions count: 1101
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O1.B.A0():void");
    }

    public void A1(FloatingWindowViewModel floatingWindowViewModel) {
        this.f2450W = floatingWindowViewModel;
        synchronized (this) {
            this.f2456a0 |= 262144;
        }
        r0(BR.commonViewModel);
        super.W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f2456a0 != 0) {
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
            this.f2456a0 = 524288L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        switch (i10) {
            case 0:
                return x1((LocalObservableField) obj, i11);
            case 1:
                return y1((NonNullObservableField) obj, i11);
            case 2:
                return m1((LocalObservableField) obj, i11);
            case 3:
                return v1((LocalObservableField) obj, i11);
            case 4:
                return w1((LocalObservableField) obj, i11);
            case 5:
                return n1((NonNullObservableField) obj, i11);
            case 6:
                return j1((LocalObservableField) obj, i11);
            case 7:
                return t1((NonNullObservableField) obj, i11);
            case 8:
                return k1((NonNullObservableField) obj, i11);
            case 9:
                return q1((LocalObservableField) obj, i11);
            case 10:
                return r1((LocalObservableField) obj, i11);
            case 11:
                return l1((NonNullObservableField) obj, i11);
            case 12:
                return u1((NonNullObservableField) obj, i11);
            case 13:
                return p1((NonNullObservableField) obj, i11);
            case 14:
                return o1((NonNullObservableField) obj, i11);
            case 15:
                return s1((NonNullObservableField) obj, i11);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (BR.commandViewModel == i10) {
            z1((FloatingWindowCommandViewModel) obj);
        } else if (BR.viewModel == i10) {
            i1((DriveModeFloatingWindowViewModel) obj);
        } else if (BR.commonViewModel == i10) {
            A1((FloatingWindowViewModel) obj);
        } else {
            return false;
        }
        return true;
    }

    @Override // O1.A
    public void i1(DriveModeFloatingWindowViewModel driveModeFloatingWindowViewModel) {
        this.f2449V = driveModeFloatingWindowViewModel;
        synchronized (this) {
            this.f2456a0 |= 131072;
        }
        r0(BR.viewModel);
        super.W0();
    }

    public final boolean l1(NonNullObservableField<Boolean> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2456a0 |= 2048;
            }
            return true;
        }
        return false;
    }

    public final boolean n1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2456a0 |= 32;
            }
            return true;
        }
        return false;
    }

    public final boolean s1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2456a0 |= 32768;
            }
            return true;
        }
        return false;
    }

    public final boolean x1(LocalObservableField<String> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2456a0 |= 1;
            }
            return true;
        }
        return false;
    }

    public final boolean y1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2456a0 |= 2;
            }
            return true;
        }
        return false;
    }

    public void z1(FloatingWindowCommandViewModel floatingWindowCommandViewModel) {
        this.f2451X = floatingWindowCommandViewModel;
        synchronized (this) {
            this.f2456a0 |= 65536;
        }
        r0(BR.commandViewModel);
        super.W0();
    }

    public B(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 16, (TextSwitcher) objArr[2], (TextView) objArr[6], (AutoWrapTextView) objArr[7], (TextView) objArr[8], (ImageView) objArr[11], (ImageView) objArr[12], (ImageSwitcher) objArr[1], (ImageView) objArr[5], (LinearLayout) objArr[13], (FloatingWindowConstraintLayout) objArr[0], (ImageView) objArr[15], (ImageSwitcher) objArr[10], (ImageView) objArr[16], (LinearLayout) objArr[14], (TextView) objArr[9]);
        this.f2456a0 = -1L;
        this.f2434G.setTag(null);
        this.f2435H.setTag(null);
        this.f2436I.setTag(null);
        this.f2437J.setTag(null);
        this.f2440M.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f2454Y = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.f2455Z = textView2;
        textView2.setTag(null);
        this.f2441N.setTag(null);
        this.f2443P.setTag(null);
        this.f2445R.setTag(null);
        this.f2448U.setTag(null);
        c1(view);
        O0();
    }
}
