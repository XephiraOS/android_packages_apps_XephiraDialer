package com.android.contacts.framework.omoji.utils;

import android.content.Context;
import f1.InterfaceC0995a;
import kotlin.Pair;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: OmojiUtils.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.omoji.utils.OmojiUtils$getOmojiMaterialsStatus$1", f = "OmojiUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class OmojiUtils$getOmojiMaterialsStatus$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ InterfaceC0995a $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $material;
    int label;

    /* compiled from: OmojiUtils.kt */
    @InterfaceC1470d(c = "com.android.contacts.framework.omoji.utils.OmojiUtils$getOmojiMaterialsStatus$1$1", f = "OmojiUtils.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.android.contacts.framework.omoji.utils.OmojiUtils$getOmojiMaterialsStatus$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<E, c<? super q>, Object> {
        final /* synthetic */ InterfaceC0995a $callback;
        final /* synthetic */ Pair<Integer, Boolean> $pair;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC0995a interfaceC0995a, Pair<Integer, Boolean> pair, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$callback = interfaceC0995a;
            this.$pair = pair;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<q> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.$callback, this.$pair, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                this.$callback.a(this.$pair);
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
    public OmojiUtils$getOmojiMaterialsStatus$1(Context context, String str, InterfaceC0995a interfaceC0995a, c<? super OmojiUtils$getOmojiMaterialsStatus$1> cVar) {
        super(2, cVar);
        this.$context = context;
        this.$material = str;
        this.$callback = interfaceC0995a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new OmojiUtils$getOmojiMaterialsStatus$1(this.$context, this.$material, this.$callback, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            C1248i.d(C1241e0.f34422a, S.c(), null, new AnonymousClass1(this.$callback, OmojiUtils.e(this.$context, this.$material), null), 2, null);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((OmojiUtils$getOmojiMaterialsStatus$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
