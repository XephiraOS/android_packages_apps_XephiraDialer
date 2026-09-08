package com.android.incallui.mvvm.base;

import android.content.Context;
import androidx.lifecycle.I;
import com.android.incallui.OplusInCallApp;
import kotlin.jvm.internal.i;

/* compiled from: BaseViewModel.kt */
/* loaded from: classes.dex */
public class BaseViewModel extends I {
    public final Context g() {
        Context defaultDisplayUiContext = OplusInCallApp.getDefaultDisplayUiContext();
        i.e(defaultDisplayUiContext, "getDefaultDisplayUiContext()");
        return defaultDisplayUiContext;
    }
}
