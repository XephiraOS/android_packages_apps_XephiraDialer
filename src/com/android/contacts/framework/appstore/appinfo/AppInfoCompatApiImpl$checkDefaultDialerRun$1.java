package com.android.contacts.framework.appstore.appinfo;

import C7.g;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: AppInfoCompatApiImpl.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.appstore.appinfo.AppInfoCompatApiImpl$checkDefaultDialerRun$1", f = "AppInfoCompatApiImpl.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AppInfoCompatApiImpl$checkDefaultDialerRun$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ g<AppCompatActivity> $act$delegate;
    final /* synthetic */ Runnable $runnable;
    final /* synthetic */ LifecycleCoroutineScope $scope;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppInfoCompatApiImpl$checkDefaultDialerRun$1(g<AppCompatActivity> gVar, LifecycleCoroutineScope lifecycleCoroutineScope, Runnable runnable, c<? super AppInfoCompatApiImpl$checkDefaultDialerRun$1> cVar) {
        super(2, cVar);
        this.$act$delegate = gVar;
        this.$scope = lifecycleCoroutineScope;
        this.$runnable = runnable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new AppInfoCompatApiImpl$checkDefaultDialerRun$1(this.$act$delegate, this.$scope, this.$runnable, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AppCompatActivity w10;
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            w10 = AppInfoCompatApiImpl.w(this.$act$delegate);
            if (w10 != null) {
                LifecycleCoroutineScope lifecycleCoroutineScope = this.$scope;
                Runnable runnable = this.$runnable;
                C1248i.d(lifecycleCoroutineScope, S.c(), null, new AppInfoCompatApiImpl$checkDefaultDialerRun$1$1$1(w10, AppInfoCompatApiImpl.f15636b.b(w10), runnable, null), 2, null);
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((AppInfoCompatApiImpl$checkDefaultDialerRun$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
