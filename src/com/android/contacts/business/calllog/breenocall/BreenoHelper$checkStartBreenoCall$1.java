package com.android.contacts.business.calllog.breenocall;

import android.content.Context;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: BreenoHelper.kt */
@InterfaceC1470d(c = "com.android.contacts.business.calllog.breenocall.BreenoHelper$checkStartBreenoCall$1", f = "BreenoHelper.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class BreenoHelper$checkStartBreenoCall$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ String $callUniqueId;
    final /* synthetic */ Context $context;
    final /* synthetic */ int $notExistToast;
    final /* synthetic */ E $scope;
    int label;

    /* compiled from: BreenoHelper.kt */
    @InterfaceC1470d(c = "com.android.contacts.business.calllog.breenocall.BreenoHelper$checkStartBreenoCall$1$1", f = "BreenoHelper.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.android.contacts.business.calllog.breenocall.BreenoHelper$checkStartBreenoCall$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<E, c<? super q>, Object> {
        final /* synthetic */ String $callUniqueId;
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean $isBreenoCallExist;
        final /* synthetic */ int $notExistToast;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z10, Context context, String str, int i10, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$isBreenoCallExist = z10;
            this.$context = context;
            this.$callUniqueId = str;
            this.$notExistToast = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<q> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.$isBreenoCallExist, this.$context, this.$callUniqueId, this.$notExistToast, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                if (this.$isBreenoCallExist) {
                    BreenoHelper.INSTANCE.showBreenoCall(this.$context, this.$callUniqueId);
                } else {
                    BreenoHelper.INSTANCE.toastNotExist(this.$context, this.$notExistToast);
                }
                return q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(E e10, c<? super q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BreenoHelper$checkStartBreenoCall$1(Context context, String str, E e10, int i10, c<? super BreenoHelper$checkStartBreenoCall$1> cVar) {
        super(2, cVar);
        this.$context = context;
        this.$callUniqueId = str;
        this.$scope = e10;
        this.$notExistToast = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new BreenoHelper$checkStartBreenoCall$1(this.$context, this.$callUniqueId, this.$scope, this.$notExistToast, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean isBreenoCallExist;
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            BreenoHelper breenoHelper = BreenoHelper.INSTANCE;
            isBreenoCallExist = breenoHelper.isBreenoCallExist(this.$context, this.$callUniqueId);
            if (!isBreenoCallExist) {
                breenoHelper.clearBreenoCall(this.$context, this.$callUniqueId);
            }
            C1248i.d(this.$scope, S.c(), null, new AnonymousClass1(isBreenoCallExist, this.$context, this.$callUniqueId, this.$notExistToast, null), 2, null);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((BreenoHelper$checkStartBreenoCall$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
