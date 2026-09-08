package com.internal_dependency;

import android.content.Context;
import android.os.PowerManager;
import kotlin.LazyThreadSafetyMode;
import kotlin.a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: ApiAdapterDepends.kt */
/* loaded from: classes3.dex */
public final class ApiAdapterDepends implements ApiAdapterDependsInterface {
    public static final Companion Companion = new Companion(null);
    public static final String LOG_TAG = "ApiAdapterDependsImpl";
    private static final d<ApiAdapterDepends> sInstance$delegate;

    /* compiled from: ApiAdapterDepends.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public final ApiAdapterDepends getSInstance() {
            return (ApiAdapterDepends) ApiAdapterDepends.sInstance$delegate.getValue();
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ void getSInstance$annotations() {
        }
    }

    static {
        d<ApiAdapterDepends> a10;
        a10 = a.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<ApiAdapterDepends>() { // from class: com.internal_dependency.ApiAdapterDepends$Companion$sInstance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final ApiAdapterDepends invoke() {
                return new ApiAdapterDepends();
            }
        });
        sInstance$delegate = a10;
    }

    public static final ApiAdapterDepends getSInstance() {
        return Companion.getSInstance();
    }

    @Override // com.internal_dependency.ApiAdapterDependsInterface
    public boolean getDisplayAodStatus(PowerManager powerManager) {
        return false;
    }

    @Override // com.internal_dependency.ApiAdapterDependsInterface
    public void init(Context context) {
        i.f(context, "context");
    }
}
