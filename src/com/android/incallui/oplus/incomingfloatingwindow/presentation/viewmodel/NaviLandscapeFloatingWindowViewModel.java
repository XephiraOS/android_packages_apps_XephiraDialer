package com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import com.android.incallui.clean.domain.interactor.UseCase1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;
import v9.l;

/* compiled from: NaviLandscapeFloatingWindowViewModel.kt */
/* loaded from: classes.dex */
public final class NaviLandscapeFloatingWindowViewModel extends NaviFloatingWindowViewModel {

    /* renamed from: s, reason: collision with root package name */
    public static final a f19033s = new a(null);

    /* renamed from: p, reason: collision with root package name */
    public final NonNullObservableField<Integer> f19034p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f19035q;

    /* renamed from: r, reason: collision with root package name */
    public final LocalObservableField<q> f19036r;

    /* compiled from: NaviLandscapeFloatingWindowViewModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NaviLandscapeFloatingWindowViewModel(b eventBus) {
        super("NaviLandscapeFloatingWindowViewModel", eventBus);
        i.f(eventBus, "eventBus");
        this.f19034p = new NonNullObservableField<>((LiveData<?>[]) new LiveData[]{r().f()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.NaviLandscapeFloatingWindowViewModel$layoutWidth$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int k10 = NaviLandscapeFloatingWindowViewModel.this.r().k();
                int l10 = NaviLandscapeFloatingWindowViewModel.this.r().l();
                int q10 = NaviLandscapeFloatingWindowViewModel.this.r().q();
                int i10 = NaviLandscapeFloatingWindowViewModel.this.r().f().getValue().widthPixels;
                int i11 = q10 * 2;
                if (i10 < l10 + i11) {
                    k10 = l10;
                } else if (i10 < k10 + i11) {
                    k10 = i10 - i11;
                }
                return Integer.valueOf(k10);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f19036r = new LocalObservableField<>(new androidx.databinding.i[]{o().e()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.NaviLandscapeFloatingWindowViewModel$toastForContact$1
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
                if (NaviLandscapeFloatingWindowViewModel.this.B() || (s02 = NaviLandscapeFloatingWindowViewModel.this.o().e().s0()) == null || s02.length() == 0) {
                    return;
                }
                NaviLandscapeFloatingWindowViewModel.this.o().k().b(s02, Integer.valueOf(NaviLandscapeFloatingWindowViewModel.this.r().i()));
                NaviLandscapeFloatingWindowViewModel.this.D(true);
            }
        });
    }

    public final boolean B() {
        return this.f19035q;
    }

    public final NonNullObservableField<Integer> C() {
        return this.f19034p;
    }

    public final void D(boolean z10) {
        this.f19035q = z10;
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.c
    public void u() {
        super.u();
        UseCase1.e(q().c(), 3, t().b(), null, 4, null);
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.NaviFloatingWindowViewModel, com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.c
    public void v() {
        super.v();
        this.f19034p.close();
        this.f19036r.close();
    }
}
