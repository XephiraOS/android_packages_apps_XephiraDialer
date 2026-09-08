package com.android.contacts.dialpad;

import android.content.Context;
import com.android.contacts.dialpad.SimInfoManager;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import kotlinx.coroutines.w0;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: SimInfoManager.kt */
@InterfaceC1470d(c = "com.android.contacts.dialpad.SimInfoManager$refreshSimInfoBackground$1", f = "SimInfoManager.kt", l = {72}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SimInfoManager$refreshSimInfoBackground$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ SimInfoManager.b $listener;
    final /* synthetic */ Runnable $runnable;
    int label;
    final /* synthetic */ SimInfoManager this$0;

    /* compiled from: SimInfoManager.kt */
    @InterfaceC1470d(c = "com.android.contacts.dialpad.SimInfoManager$refreshSimInfoBackground$1$1", f = "SimInfoManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.android.contacts.dialpad.SimInfoManager$refreshSimInfoBackground$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
        final /* synthetic */ Runnable $runnable;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Runnable runnable, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$runnable = runnable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.$runnable, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                Runnable runnable = this.$runnable;
                if (runnable != null) {
                    runnable.run();
                }
                return q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimInfoManager$refreshSimInfoBackground$1(SimInfoManager simInfoManager, Context context, SimInfoManager.b bVar, Runnable runnable, kotlin.coroutines.c<? super SimInfoManager$refreshSimInfoBackground$1> cVar) {
        super(2, cVar);
        this.this$0 = simInfoManager;
        this.$context = context;
        this.$runnable = runnable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new SimInfoManager$refreshSimInfoBackground$1(this.this$0, this.$context, null, this.$runnable, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            this.this$0.h(this.$context, null);
            w0 c11 = S.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$runnable, null);
            this.label = 1;
            if (C1244g.g(c11, anonymousClass1, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((SimInfoManager$refreshSimInfoBackground$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
