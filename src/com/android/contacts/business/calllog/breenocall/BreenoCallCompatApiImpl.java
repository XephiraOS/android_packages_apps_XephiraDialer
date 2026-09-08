package com.android.contacts.business.calllog.breenocall;

import android.content.Context;
import android.content.Intent;
import com.android.contacts.framework.api.breenocall.IBreenoCallCompatApi;
import java.util.ArrayList;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: BreenoCallCompatApiImpl.kt */
/* loaded from: classes.dex */
public final class BreenoCallCompatApiImpl implements IBreenoCallCompatApi {
    public static final Companion Companion = new Companion(null);
    private static final BreenoCallCompatApiImpl instance = new BreenoCallCompatApiImpl();

    /* compiled from: BreenoCallCompatApiImpl.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final BreenoCallCompatApiImpl getInstance() {
            return BreenoCallCompatApiImpl.instance;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    @Override // com.android.contacts.framework.api.breenocall.IBreenoCallCompatApi
    public void checkStartBreenoCall(Context context, String uniqueId, int i10) {
        i.f(context, "context");
        i.f(uniqueId, "uniqueId");
        BreenoHelper.checkStartBreenoCall(context, uniqueId, i10);
    }

    public void deleteBreenoCallLog(Context context, String callUniqueId) {
        i.f(context, "context");
        i.f(callUniqueId, "callUniqueId");
        BreenoHelper.deleteBreenoCallLog(context, callUniqueId);
    }

    public boolean isBreenoOpen(Context context) {
        i.f(context, "context");
        return BreenoHelper.isBreenoOpen(context);
    }

    @Override // com.android.contacts.framework.api.breenocall.IBreenoCallCompatApi
    public boolean isCallSummaryOpen(Context context) {
        i.f(context, "context");
        return BreenoHelper.isCallSummaryOpen(context);
    }

    @Override // com.android.contacts.framework.api.breenocall.IBreenoCallCompatApi
    public boolean isSupportBreenoCall() {
        return FeatureOpt.isBreenoCallLogSupport();
    }

    @Override // com.android.contacts.framework.api.breenocall.IBreenoCallCompatApi
    public boolean isSupportCallSummary(boolean z10) {
        if (FeatureOpt.isSupportCallSummary()) {
            return FeatureOpt.INSTANCE.isAiCallSummarySupport(z10);
        }
        return false;
    }

    @Override // com.android.contacts.framework.api.breenocall.IBreenoCallCompatApi
    public Intent jumpToSettingUIIntent() {
        return BreenoHelper.jumpToSettingUIIntent();
    }

    @Override // com.android.contacts.framework.api.breenocall.IBreenoCallCompatApi
    public void updateBreenoCallSupport(Runnable runnable) {
        i.f(runnable, "runnable");
        FeatureOpt.INSTANCE.updateBreenoCallSupport(runnable);
    }

    @Override // com.android.contacts.framework.api.breenocall.IBreenoCallCompatApi
    public void deleteBreenoCallLog(Context context, ArrayList<String> callUniqueIds) {
        i.f(context, "context");
        i.f(callUniqueIds, "callUniqueIds");
        BreenoHelper.deleteBreenoCallLog(context, callUniqueIds);
    }
}
