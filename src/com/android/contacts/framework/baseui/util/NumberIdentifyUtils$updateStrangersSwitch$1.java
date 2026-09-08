package com.android.contacts.framework.baseui.util;

import android.content.Context;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: NumberIdentifyUtils.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.baseui.util.NumberIdentifyUtils$updateStrangersSwitch$1", f = "NumberIdentifyUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class NumberIdentifyUtils$updateStrangersSwitch$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ int $checked;
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumberIdentifyUtils$updateStrangersSwitch$1(Context context, int i10, kotlin.coroutines.c<? super NumberIdentifyUtils$updateStrangersSwitch$1> cVar) {
        super(2, cVar);
        this.$context = context;
        this.$checked = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new NumberIdentifyUtils$updateStrangersSwitch$1(this.$context, this.$checked, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            Context context = this.$context;
            boolean z10 = true;
            if (this.$checked != 1) {
                z10 = false;
            }
            NumberIdentifyUtils.h(context, z10);
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((NumberIdentifyUtils$updateStrangersSwitch$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
