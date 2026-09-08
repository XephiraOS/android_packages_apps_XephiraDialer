package com.oplus.phonenoareainquire.utils;

import android.content.Context;
import b8.C0530a;
import com.oplus.phonenoareainquire.PhoneNoInquireProvider;
import com.oplus.phonenoareainquire.PhoneNumberAreaApplication;
import com.oplus.phonenoareainquire.c;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: LogUtil.kt */
@InterfaceC1470d(c = "com.oplus.phonenoareainquire.utils.LogUtil$refreshLogSwitch$1", f = "LogUtil.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class LogUtil$refreshLogSwitch$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogUtil$refreshLogSwitch$1(Context context, kotlin.coroutines.c<? super LogUtil$refreshLogSwitch$1> cVar) {
        super(2, cVar);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new LogUtil$refreshLogSwitch$1(this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b10;
        boolean z10;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            Context context = this.$context;
            try {
                Result.a aVar = Result.f34166a;
                boolean z11 = false;
                boolean b11 = C0530a.b("persist.sys.assert.panic", false);
                boolean b12 = C0530a.b("persist.sys.alwayson.enable", false);
                if (c.b.a(2).f28847a.a(context.getContentResolver(), "phonenumberattribution.log.switch", 0) == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                LogUtil.c("LogUtil", "qeOpen = " + b11 + ", alwaysOn = " + b12 + ", switchOn = " + z10);
                if (b11 || b12 || z10) {
                    z11 = true;
                }
                PhoneNoInquireProvider.f28802L = z11;
                PhoneNumberAreaApplication.f28829a = z11;
                b10 = Result.b(q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                LogUtil.b("LogUtil", "th = " + d10);
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((LogUtil$refreshLogSwitch$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
