package com.android.contacts.framework.appstore.appinfo;

import androidx.appcompat.app.AppCompatActivity;
import com.android.contacts.framework.appstore.settings.DefaultDialerSettingDialogManager;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: AppInfoCompatApiImpl.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.appstore.appinfo.AppInfoCompatApiImpl$checkDefaultDialerRun$1$1$1", f = "AppInfoCompatApiImpl.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AppInfoCompatApiImpl$checkDefaultDialerRun$1$1$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ String $defaultDialerPackage;
    final /* synthetic */ AppCompatActivity $it;
    final /* synthetic */ Runnable $runnable;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppInfoCompatApiImpl$checkDefaultDialerRun$1$1$1(AppCompatActivity appCompatActivity, String str, Runnable runnable, c<? super AppInfoCompatApiImpl$checkDefaultDialerRun$1$1$1> cVar) {
        super(2, cVar);
        this.$it = appCompatActivity;
        this.$defaultDialerPackage = str;
        this.$runnable = runnable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new AppInfoCompatApiImpl$checkDefaultDialerRun$1$1$1(this.$it, this.$defaultDialerPackage, this.$runnable, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            if (!i.b(this.$it.getPackageName(), this.$defaultDialerPackage)) {
                DefaultDialerSettingDialogManager.d(this.$it);
            } else {
                this.$runnable.run();
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((AppInfoCompatApiImpl$checkDefaultDialerRun$1$1$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
