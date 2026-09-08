package o2;

import android.content.Context;
import android.util.DisplayMetrics;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.R;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.android.incallui.mvvm.utils.y;
import r2.e;

/* compiled from: SystemConfigRepository.kt */
/* loaded from: classes.dex */
public final class l implements r2.e {

    /* renamed from: a, reason: collision with root package name */
    public final com.android.incallui.mvvm.utils.h<Integer> f35724a;

    /* renamed from: b, reason: collision with root package name */
    public final y<Integer> f35725b;

    /* renamed from: c, reason: collision with root package name */
    public final y<Boolean> f35726c;

    /* renamed from: d, reason: collision with root package name */
    public final y<DisplayMetrics> f35727d;

    public l() {
        ResponsiveConfigRepository responsiveConfigRepository = ResponsiveConfigRepository.f18540a;
        this.f35724a = responsiveConfigRepository.h1();
        this.f35725b = responsiveConfigRepository.f1();
        this.f35726c = responsiveConfigRepository.a0();
        this.f35727d = responsiveConfigRepository.L();
    }

    @Override // r2.e
    public int A() {
        return o().getResources().getDimensionPixelSize(R.dimen.floating_window_default_type_top_margin);
    }

    @Override // r2.e
    public int B1() {
        return o().getResources().getDimensionPixelSize(R.dimen.floating_window_navi_landscape_height);
    }

    @Override // d2.InterfaceC0949b
    public OplusInCallPresenter C0() {
        return e.a.b(this);
    }

    @Override // r2.e
    public int C1() {
        return o().getResources().getDimensionPixelSize(R.dimen.oplus_penetrated_incoming_call_prompt_y_offset_landscape);
    }

    @Override // r2.e
    public int G0() {
        return o().getResources().getDimensionPixelSize(R.dimen.floating_window_default_type_small_horizontal_margin);
    }

    @Override // r2.e
    public com.android.incallui.mvvm.utils.h<Integer> H0() {
        return this.f35724a;
    }

    @Override // r2.e
    public int I() {
        return o().getResources().getDimensionPixelSize(R.dimen.floating_window_default_type_not_heteromorphism_top_margin);
    }

    @Override // r2.e
    public y<DisplayMetrics> L() {
        return this.f35727d;
    }

    @Override // r2.e
    public int O() {
        return o().getResources().getDimensionPixelSize(R.dimen.floating_window_navi_third_line_height);
    }

    @Override // r2.e
    public int T() {
        return o().getResources().getDimensionPixelSize(R.dimen.floating_window_drive_mode_horizontal_margin);
    }

    @Override // r2.e
    public int X() {
        return o().getResources().getDimensionPixelSize(R.dimen.floating_window_navi_type_horizontal_margin);
    }

    @Override // r2.e
    public int Z() {
        return o().getResources().getDimensionPixelSize(R.dimen.floating_window_navi_portrait_max_width);
    }

    @Override // r2.e
    public y<Boolean> a0() {
        return this.f35726c;
    }

    @Override // r2.e
    public int b0() {
        return o().getResources().getDimensionPixelSize(R.dimen.floating_window_navi_portrait_height);
    }

    @Override // d2.InterfaceC0949b
    public void f() {
        e.a.c(this);
    }

    @Override // r2.e
    public y<Integer> f1() {
        return this.f35725b;
    }

    @Override // r2.e
    public int l() {
        return o().getResources().getDimensionPixelSize(R.dimen.floating_window_navi_landscape_type_max_width);
    }

    public Context o() {
        return e.a.a(this);
    }

    @Override // r2.e
    public int u0() {
        return o().getResources().getDimensionPixelSize(R.dimen.oplus_penetrated_incoming_call_prompt_y_offset_portrait);
    }

    @Override // r2.e
    public int v() {
        return o().getResources().getDimensionPixelSize(R.dimen.floating_window_default_type_max_width);
    }

    @Override // r2.e
    public boolean v0() {
        return OplusFeatureOption.OPLUS_PHONE_SCREEN_HETEROMORPHISM;
    }

    @Override // r2.e
    public int z0() {
        return o().getResources().getDimensionPixelSize(R.dimen.floating_window_navi_landscape_type_min_width);
    }

    @Override // r2.e
    public int z1() {
        return o().getResources().getDimensionPixelSize(R.dimen.oplus_penetrated_incoming_call_prompt_y_offset_drive_mode);
    }
}
