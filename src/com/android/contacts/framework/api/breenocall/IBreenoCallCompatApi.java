package com.android.contacts.framework.api.breenocall;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: IBreenoCallCompatApi.kt */
/* loaded from: classes.dex */
public interface IBreenoCallCompatApi {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f15556a = Companion.f15557a;

    /* compiled from: IBreenoCallCompatApi.kt */
    /* loaded from: classes.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f15557a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final d<IBreenoCallCompatApi> f15558b;

        static {
            d<IBreenoCallCompatApi> b10;
            b10 = kotlin.a.b(new InterfaceC1637a<IBreenoCallCompatApi>() { // from class: com.android.contacts.framework.api.breenocall.IBreenoCallCompatApi$Companion$instance$2
                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final IBreenoCallCompatApi invoke() {
                    return (IBreenoCallCompatApi) A8.a.f202a.a(IBreenoCallCompatApi.class);
                }
            });
            f15558b = b10;
        }

        public final IBreenoCallCompatApi a() {
            return f15558b.getValue();
        }
    }

    void checkStartBreenoCall(Context context, String str, int i10);

    void deleteBreenoCallLog(Context context, ArrayList<String> arrayList);

    boolean isCallSummaryOpen(Context context);

    boolean isSupportBreenoCall();

    boolean isSupportCallSummary(boolean z10);

    Intent jumpToSettingUIIntent();

    void updateBreenoCallSupport(Runnable runnable);
}
