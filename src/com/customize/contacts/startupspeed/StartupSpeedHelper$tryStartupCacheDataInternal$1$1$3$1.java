package com.customize.contacts.startupspeed;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: StartupSpeedHelper.kt */
@InterfaceC1470d(c = "com.customize.contacts.startupspeed.StartupSpeedHelper$tryStartupCacheDataInternal$1$1$3$1", f = "StartupSpeedHelper.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class StartupSpeedHelper$tryStartupCacheDataInternal$1$1$3$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    int label;

    public StartupSpeedHelper$tryStartupCacheDataInternal$1$1$3$1(kotlin.coroutines.c<? super StartupSpeedHelper$tryStartupCacheDataInternal$1$1$3$1> cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new StartupSpeedHelper$tryStartupCacheDataInternal$1$1$3$1(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            com.android.contacts.framework.api.breenocall.a.e(true);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((StartupSpeedHelper$tryStartupCacheDataInternal$1$1$3$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
