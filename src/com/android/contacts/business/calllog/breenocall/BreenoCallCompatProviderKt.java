package com.android.contacts.business.calllog.breenocall;

import v9.InterfaceC1637a;

/* compiled from: BreenoCallCompatProvider.kt */
/* loaded from: classes.dex */
public final class BreenoCallCompatProviderKt {
    private static final InterfaceC1637a<BreenoCallCompatApiImpl> providerBreenoCallCompatApi = new InterfaceC1637a<BreenoCallCompatApiImpl>() { // from class: com.android.contacts.business.calllog.breenocall.BreenoCallCompatProviderKt$providerBreenoCallCompatApi$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // v9.InterfaceC1637a
        public final BreenoCallCompatApiImpl invoke() {
            return BreenoCallCompatApiImpl.Companion.getInstance();
        }
    };

    public static final InterfaceC1637a<BreenoCallCompatApiImpl> getProviderBreenoCallCompatApi() {
        return providerBreenoCallCompatApi;
    }

    public static /* synthetic */ void getProviderBreenoCallCompatApi$annotations() {
    }
}
