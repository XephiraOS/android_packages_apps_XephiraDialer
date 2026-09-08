package com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import com.android.incallui.clean.domain.interactor.UseCase1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;
import v9.l;

/* compiled from: NaviPortraitFloatingWindowViewModel.kt */
/* loaded from: classes.dex */
public final class NaviPortraitFloatingWindowViewModel extends NaviFloatingWindowViewModel {

    /* renamed from: s, reason: collision with root package name */
    public static final a f19037s = new a(null);

    /* renamed from: p, reason: collision with root package name */
    public final NonNullObservableField<Integer> f19038p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f19039q;

    /* renamed from: r, reason: collision with root package name */
    public final LocalObservableField<q> f19040r;

    /* compiled from: NaviPortraitFloatingWindowViewModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NaviPortraitFloatingWindowViewModel(b eventBus) {
        super("NaviPortraitFloatingWindowViewModel", eventBus);
        i.f(eventBus, "eventBus");
        this.f19038p = new NonNullObservableField<>((LiveData<?>[]) new LiveData[]{r().f()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.NaviPortraitFloatingWindowViewModel$layoutWidth$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int o10 = NaviPortraitFloatingWindowViewModel.this.r().o();
                int q10 = NaviPortraitFloatingWindowViewModel.this.r().q();
                int i10 = NaviPortraitFloatingWindowViewModel.this.r().f().getValue().widthPixels;
                int i11 = q10 * 2;
                if (i10 < o10 + i11) {
                    o10 = i10 - i11;
                }
                return Integer.valueOf(o10);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f19040r = new LocalObservableField<>(new androidx.databinding.i[]{o().e()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.NaviPortraitFloatingWindowViewModel$toastForContact$1
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                String s02;
                if (NaviPortraitFloatingWindowViewModel.this.B() || (s02 = NaviPortraitFloatingWindowViewModel.this.o().e().s0()) == null || s02.length() == 0) {
                    return;
                }
                NaviPortraitFloatingWindowViewModel.this.o().k().b(s02, Integer.valueOf(NaviPortraitFloatingWindowViewModel.this.r().m()));
                NaviPortraitFloatingWindowViewModel.this.D(true);
            }
        });
    }

    public final boolean B() {
        return this.f19039q;
    }

    public final NonNullObservableField<Integer> C() {
        return this.f19038p;
    }

    public final void D(boolean z10) {
        this.f19039q = z10;
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.c
    public void u() {
        super.u();
        UseCase1.e(q().c(), 2, t().b(), null, 4, null);
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.NaviFloatingWindowViewModel, com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.c
    public void v() {
        super.v();
        this.f19038p.close();
        this.f19040r.close();
    }
}
