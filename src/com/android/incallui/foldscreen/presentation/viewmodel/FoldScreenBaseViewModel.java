package com.android.incallui.foldscreen.presentation.viewmodel;

import J1.e;
import J1.f;
import J1.g;
import com.android.incallui.mvvm.base.BaseViewModel;
import kotlin.jvm.internal.i;

/* compiled from: FoldScreenBaseViewModel.kt */
/* loaded from: classes.dex */
public abstract class FoldScreenBaseViewModel extends BaseViewModel {

    /* renamed from: d, reason: collision with root package name */
    public final J1.a f18472d;

    /* renamed from: e, reason: collision with root package name */
    public final g f18473e;

    /* renamed from: f, reason: collision with root package name */
    public final f f18474f;

    /* renamed from: g, reason: collision with root package name */
    public final e f18475g;

    /* renamed from: h, reason: collision with root package name */
    public final U1.a f18476h;

    public FoldScreenBaseViewModel(Y1.a useCaseProvider) {
        i.f(useCaseProvider, "useCaseProvider");
        this.f18472d = useCaseProvider.a();
        this.f18473e = useCaseProvider.g();
        this.f18474f = useCaseProvider.e();
        this.f18475g = useCaseProvider.d();
        this.f18476h = useCaseProvider.f();
    }

    public final J1.a h() {
        return this.f18472d;
    }

    public final g i() {
        return this.f18473e;
    }

    public final e j() {
        return this.f18475g;
    }

    public final f k() {
        return this.f18474f;
    }

    public final U1.a l() {
        return this.f18476h;
    }
}
