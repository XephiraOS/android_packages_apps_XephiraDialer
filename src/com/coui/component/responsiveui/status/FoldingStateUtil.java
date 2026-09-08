package com.coui.component.responsiveui.status;

import android.content.Context;
import android.database.ContentObserver;
import android.provider.Settings;
import android.util.Log;
import com.coui.appcompat.baseview.util.FoldSettingsHelper;
import com.coui.component.responsiveui.ResponsiveUILog;
import kotlin.jvm.internal.i;

/* compiled from: FoldingStateUtil.kt */
/* loaded from: classes3.dex */
public final class FoldingStateUtil {
    public static final FoldingStateUtil INSTANCE = new FoldingStateUtil();

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f20021a;

    static {
        boolean z10;
        ResponsiveUILog responsiveUILog = ResponsiveUILog.INSTANCE;
        if (!responsiveUILog.getLOG_DEBUG() && !responsiveUILog.isLoggable("FoldingStateUtil", 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        f20021a = z10;
    }

    public static final FoldingState getFoldingState(Context context) {
        FoldingState foldingState;
        i.f(context, "context");
        int i10 = Settings.Global.getInt(context.getContentResolver(), FoldSettingsHelper.SYSTEM_FOLDING_MODE_KEY, -1);
        if (i10 != 0) {
            if (i10 != 1) {
                foldingState = FoldingState.UNKNOWN;
            } else {
                foldingState = FoldingState.UNFOLD;
            }
        } else {
            foldingState = FoldingState.FOLD;
        }
        if (f20021a) {
            Log.d("FoldingStateUtil", "[getFoldingState]: " + foldingState);
        }
        return foldingState;
    }

    public static final void registerFoldingStateObserver(Context context, ContentObserver observer) {
        i.f(context, "context");
        i.f(observer, "observer");
        context.getContentResolver().registerContentObserver(Settings.Global.getUriFor(FoldSettingsHelper.SYSTEM_FOLDING_MODE_KEY), false, observer);
    }

    public static final void unregisterFoldingStateObserver(Context context, ContentObserver observer) {
        i.f(context, "context");
        i.f(observer, "observer");
        context.getContentResolver().unregisterContentObserver(observer);
    }
}
