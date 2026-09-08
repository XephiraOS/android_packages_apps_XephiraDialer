package O1;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.BR;
import com.android.incallui.R;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.NaviPortraitFloatingWindowViewModel;
import com.android.incallui.oplus.widgets.AutoWrapTextView;

/* compiled from: OplusIncallFloatingNaviPortraitViewBindingImpl.java */
/* loaded from: classes.dex */
public class F extends E {

    /* renamed from: c0, reason: collision with root package name */
    public static final ViewDataBinding.i f2500c0 = null;

    /* renamed from: d0, reason: collision with root package name */
    public static final SparseIntArray f2501d0;

    /* renamed from: a0, reason: collision with root package name */
    public final RelativeLayout f2502a0;

    /* renamed from: b0, reason: collision with root package name */
    public long f2503b0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2501d0 = sparseIntArray;
        sparseIntArray.put(R.id.oplus_display_info_area, 11);
        sparseIntArray.put(R.id.secondline, 12);
        sparseIntArray.put(R.id.left_area_info, 13);
        sparseIntArray.put(R.id.left_btn_decline, 14);
        sparseIntArray.put(R.id.left_btn_speaker, 15);
        sparseIntArray.put(R.id.right_btn_answer, 16);
        sparseIntArray.put(R.id.right_btn_decline, 17);
    }

    public F(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 18, f2500c0, f2501d0));
    }

    private boolean A1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 131072;
            }
            return true;
        }
        return false;
    }

    private boolean B1(LocalObservableField<com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean C1(LocalObservableField<Integer> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 65536;
            }
            return true;
        }
        return false;
    }

    private boolean D1(LocalObservableField<Integer> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean E1(LocalObservableField<String> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean F1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean j1(LocalObservableField<String> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean k1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 2048;
            }
            return true;
        }
        return false;
    }

    private boolean l1(NonNullObservableField<Boolean> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 32768;
            }
            return true;
        }
        return false;
    }

    private boolean m1(LocalObservableField<String> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean n1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean o1(NonNullObservableField<Boolean> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 262144;
            }
            return true;
        }
        return false;
    }

    private boolean p1(NonNullObservableField<Boolean> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean q1(LocalObservableField<com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 4096;
            }
            return true;
        }
        return false;
    }

    private boolean r1(LocalObservableField<String> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 8192;
            }
            return true;
        }
        return false;
    }

    private boolean s1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 2097152;
            }
            return true;
        }
        return false;
    }

    private boolean t1(LocalObservableField<String> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 4194304;
            }
            return true;
        }
        return false;
    }

    private boolean u1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 1048576;
            }
            return true;
        }
        return false;
    }

    private boolean v1(LocalObservableField<String> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 512;
            }
            return true;
        }
        return false;
    }

    private boolean w1(LocalObservableField<Integer> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 524288;
            }
            return true;
        }
        return false;
    }

    private boolean x1(LocalObservableField<Integer> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 16384;
            }
            return true;
        }
        return false;
    }

    private boolean y1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean z1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2503b0 |= 1024;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ed A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01da  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0() {
        /*
            Method dump skipped, instructions count: 1403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O1.F.A0():void");
    }

    public void G1(FloatingWindowCommandViewModel floatingWindowCommandViewModel) {
        this.f2499Z = floatingWindowCommandViewModel;
        synchronized (this) {
            this.f2503b0 |= 8388608;
        }
        r0(BR.commandViewModel);
        super.W0();
    }

    public void H1(FloatingWindowViewModel floatingWindowViewModel) {
        this.f2498Y = floatingWindowViewModel;
        synchronized (this) {
            this.f2503b0 |= 33554432;
        }
        r0(BR.commonViewModel);
        super.W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f2503b0 != 0) {
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
            this.f2503b0 = 67108864L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        switch (i10) {
            case 0:
                return E1((LocalObservableField) obj, i11);
            case 1:
                return F1((NonNullObservableField) obj, i11);
            case 2:
                return m1((LocalObservableField) obj, i11);
            case 3:
                return B1((LocalObservableField) obj, i11);
            case 4:
                return D1((LocalObservableField) obj, i11);
            case 5:
                return y1((NonNullObservableField) obj, i11);
            case 6:
                return p1((NonNullObservableField) obj, i11);
            case 7:
                return n1((NonNullObservableField) obj, i11);
            case 8:
                return j1((LocalObservableField) obj, i11);
            case 9:
                return v1((LocalObservableField) obj, i11);
            case 10:
                return z1((NonNullObservableField) obj, i11);
            case 11:
                return k1((NonNullObservableField) obj, i11);
            case 12:
                return q1((LocalObservableField) obj, i11);
            case 13:
                return r1((LocalObservableField) obj, i11);
            case 14:
                return x1((LocalObservableField) obj, i11);
            case 15:
                return l1((NonNullObservableField) obj, i11);
            case 16:
                return C1((LocalObservableField) obj, i11);
            case 17:
                return A1((NonNullObservableField) obj, i11);
            case 18:
                return o1((NonNullObservableField) obj, i11);
            case 19:
                return w1((LocalObservableField) obj, i11);
            case 20:
                return u1((NonNullObservableField) obj, i11);
            case 21:
                return s1((NonNullObservableField) obj, i11);
            case 22:
                return t1((LocalObservableField) obj, i11);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (BR.commandViewModel == i10) {
            G1((FloatingWindowCommandViewModel) obj);
        } else if (BR.viewModel == i10) {
            i1((NaviPortraitFloatingWindowViewModel) obj);
        } else if (BR.commonViewModel == i10) {
            H1((FloatingWindowViewModel) obj);
        } else {
            return false;
        }
        return true;
    }

    @Override // O1.E
    public void i1(NaviPortraitFloatingWindowViewModel naviPortraitFloatingWindowViewModel) {
        this.f2497X = naviPortraitFloatingWindowViewModel;
        synchronized (this) {
            this.f2503b0 |= 16777216;
        }
        r0(BR.viewModel);
        super.W0();
    }

    public F(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 23, (TextSwitcher) objArr[1], (TextSwitcher) objArr[3], (AutoWrapTextView) objArr[4], (TextView) objArr[5], (RelativeLayout) objArr[13], (ImageView) objArr[14], (ImageView) objArr[15], (ImageSwitcher) objArr[9], (ImageView) objArr[2], (LinearLayout) objArr[11], (TextView) objArr[8], (TextView) objArr[7], (ImageView) objArr[16], (ImageView) objArr[17], (ImageSwitcher) objArr[10], (LinearLayout) objArr[12], (TextView) objArr[6]);
        this.f2503b0 = -1L;
        this.f2480G.setTag(null);
        this.f2481H.setTag(null);
        this.f2482I.setTag(null);
        this.f2483J.setTag(null);
        this.f2487N.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f2502a0 = relativeLayout;
        relativeLayout.setTag(null);
        this.f2488O.setTag(null);
        this.f2490Q.setTag(null);
        this.f2491R.setTag(null);
        this.f2494U.setTag(null);
        this.f2496W.setTag(null);
        c1(view);
        O0();
    }
}
