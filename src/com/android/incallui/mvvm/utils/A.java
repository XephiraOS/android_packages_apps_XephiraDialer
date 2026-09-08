package com.android.incallui.mvvm.utils;

import b2.InterfaceC0519a;
import com.android.incallui.InCallPresenter;
import com.android.incallui.OplusInCallActivity;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.mvvm.usecase.FragmentStateUseCase;

/* compiled from: UnstableFunctionUtil.kt */
/* loaded from: classes.dex */
public final class A {
    public static final InterfaceC0519a a() {
        OplusInCallActivity activity;
        OplusInCallPresenter realInstance = InCallPresenter.getInstance().realInstance();
        if (realInstance != null && (activity = realInstance.getActivity()) != null) {
            return activity.getInCallFragmentManager();
        }
        return null;
    }

    public static final void b(boolean z10) {
        FragmentStateUseCase.f18563a.b(16, z10);
    }
}
