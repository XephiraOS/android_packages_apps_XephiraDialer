package com.android.incallui.clean.data.datasource;

import I1.d;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt;
import com.android.incallui.mvvm.utils.y;
import v9.l;

/* compiled from: ConfigRepository.kt */
/* loaded from: classes.dex */
public final class ConfigRepository implements I1.d {

    /* renamed from: a, reason: collision with root package name */
    public final y<Boolean> f18303a;

    public ConfigRepository() {
        y<Boolean> u10;
        com.android.incallui.mvvm.utils.h<Integer> h12 = L1.c.f() ? ResponsiveConfigRepository.f18540a.h1() : null;
        this.f18303a = (h12 == null || (u10 = IgnoreEqualsLiveDataKt.u(h12, true, new l<Integer, Boolean>() { // from class: com.android.incallui.clean.data.datasource.ConfigRepository$isDragonflyFlipped$2
            public final Boolean b(int i10) {
                boolean z10;
                if (i10 == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                return b(num.intValue());
            }
        })) == null) ? new y<>(Boolean.FALSE, true) : u10;
    }

    @Override // d2.InterfaceC0949b
    public OplusInCallPresenter C0() {
        return d.a.a(this);
    }

    @Override // d2.InterfaceC0949b
    public void f() {
        d.a.b(this);
    }

    @Override // I1.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public y<Boolean> L0() {
        return this.f18303a;
    }
}
