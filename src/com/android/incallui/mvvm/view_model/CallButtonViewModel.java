package com.android.incallui.mvvm.view_model;

import com.android.incallui.R;
import com.android.incallui.mvvm.base.BaseViewModel;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt;
import com.android.incallui.mvvm.utils.y;
import v9.l;

/* compiled from: CallButtonViewModel.kt */
/* loaded from: classes.dex */
public final class CallButtonViewModel extends BaseViewModel {

    /* renamed from: d, reason: collision with root package name */
    public final y<Integer> f18680d;

    /* renamed from: e, reason: collision with root package name */
    public final y<Integer> f18681e;

    public CallButtonViewModel() {
        ResponsiveConfigRepository responsiveConfigRepository = ResponsiveConfigRepository.f18540a;
        this.f18680d = IgnoreEqualsLiveDataKt.D(responsiveConfigRepository.o1(), false, new l<Double, Integer>() { // from class: com.android.incallui.mvvm.view_model.CallButtonViewModel$mBottomShrinkMargin$1
            {
                super(1);
            }

            public final Integer b(double d10) {
                return Integer.valueOf((int) (CallButtonViewModel.this.g().getResources().getDimensionPixelSize(R.dimen.fragment_call_button_bottom_margin) * d10));
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Double d10) {
                return b(d10.doubleValue());
            }
        }, 1, null);
        this.f18681e = IgnoreEqualsLiveDataKt.D(responsiveConfigRepository.o1(), false, new l<Double, Integer>() { // from class: com.android.incallui.mvvm.view_model.CallButtonViewModel$mVerticalShrinkSpacing$1
            {
                super(1);
            }

            public final Integer b(double d10) {
                return Integer.valueOf((int) (CallButtonViewModel.this.g().getResources().getDimensionPixelSize(R.dimen.recycler_view_call_vertical_spacing) * d10));
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Double d10) {
                return b(d10.doubleValue());
            }
        }, 1, null);
    }

    public final y<Integer> h() {
        return this.f18680d;
    }

    public final y<Integer> i() {
        return this.f18681e;
    }
}
