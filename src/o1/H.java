package O1;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import androidx.databinding.ViewDataBinding;
import com.android.incallui.BR;
import com.android.incallui.R;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.view.FloatingWindowView;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowCommandViewModel;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel;
import q2.C1481a;

/* compiled from: OplusIncallFloatingViewBindingImpl.java */
/* loaded from: classes.dex */
public class H extends G {

    /* renamed from: O, reason: collision with root package name */
    public static final ViewDataBinding.i f2510O = null;

    /* renamed from: P, reason: collision with root package name */
    public static final SparseIntArray f2511P;

    /* renamed from: M, reason: collision with root package name */
    public final FloatingWindowView f2512M;

    /* renamed from: N, reason: collision with root package name */
    public long f2513N;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2511P = sparseIntArray;
        sparseIntArray.put(R.id.floating_view_default, 1);
        sparseIntArray.put(R.id.floating_view_drive_mode, 2);
        sparseIntArray.put(R.id.floating_view_navi_landscape, 3);
        sparseIntArray.put(R.id.floating_view_navi_portrait, 4);
    }

    public H(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 5, f2510O, f2511P));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00db  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A0() {
        /*
            Method dump skipped, instructions count: 585
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O1.H.A0():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f2513N != 0) {
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
            this.f2513N = 256L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 != 5) {
                                return false;
                            }
                            return n1((NonNullObservableField) obj, i11);
                        }
                        return q1((NonNullObservableField) obj, i11);
                    }
                    return m1((NonNullObservableField) obj, i11);
                }
                return o1((LocalObservableField) obj, i11);
            }
            return p1((NonNullObservableField) obj, i11);
        }
        return r1((NonNullObservableField) obj, i11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (BR.commandViewModel == i10) {
            k1((FloatingWindowCommandViewModel) obj);
        } else if (BR.viewModel == i10) {
            l1((FloatingWindowViewModel) obj);
        } else {
            return false;
        }
        return true;
    }

    @Override // O1.G
    public void k1(FloatingWindowCommandViewModel floatingWindowCommandViewModel) {
        this.f2509L = floatingWindowCommandViewModel;
        synchronized (this) {
            this.f2513N |= 64;
        }
        r0(BR.commandViewModel);
        super.W0();
    }

    @Override // O1.G
    public void l1(FloatingWindowViewModel floatingWindowViewModel) {
        this.f2508K = floatingWindowViewModel;
        synchronized (this) {
            this.f2513N |= 128;
        }
        r0(BR.viewModel);
        super.W0();
    }

    public final boolean m1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2513N |= 8;
            }
            return true;
        }
        return false;
    }

    public final boolean n1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2513N |= 32;
            }
            return true;
        }
        return false;
    }

    public final boolean o1(LocalObservableField<C1481a> localObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2513N |= 4;
            }
            return true;
        }
        return false;
    }

    public final boolean p1(NonNullObservableField<Float> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2513N |= 2;
            }
            return true;
        }
        return false;
    }

    public final boolean q1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2513N |= 16;
            }
            return true;
        }
        return false;
    }

    public final boolean r1(NonNullObservableField<Integer> nonNullObservableField, int i10) {
        if (i10 == BR._all) {
            synchronized (this) {
                this.f2513N |= 1;
            }
            return true;
        }
        return false;
    }

    public H(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 6, new androidx.databinding.o((ViewStub) objArr[1]), new androidx.databinding.o((ViewStub) objArr[2]), new androidx.databinding.o((ViewStub) objArr[3]), new androidx.databinding.o((ViewStub) objArr[4]));
        this.f2513N = -1L;
        this.f2504G.k(this);
        this.f2505H.k(this);
        this.f2506I.k(this);
        this.f2507J.k(this);
        FloatingWindowView floatingWindowView = (FloatingWindowView) objArr[0];
        this.f2512M = floatingWindowView;
        floatingWindowView.setTag(null);
        c1(view);
        O0();
    }
}
