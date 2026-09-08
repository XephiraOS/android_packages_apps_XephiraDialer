package com.android.contacts.framework.omoji.utils;

import android.content.Context;
import f1.d;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: OmojiUtils.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.omoji.utils.OmojiUtils$checkIfOmojiSupported$1$1", f = "OmojiUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class OmojiUtils$checkIfOmojiSupported$1$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ d $callback;
    final /* synthetic */ Context $context;
    int label;

    /* compiled from: OmojiUtils.kt */
    @InterfaceC1470d(c = "com.android.contacts.framework.omoji.utils.OmojiUtils$checkIfOmojiSupported$1$1$1", f = "OmojiUtils.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.android.contacts.framework.omoji.utils.OmojiUtils$checkIfOmojiSupported$1$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<E, c<? super q>, Object> {
        final /* synthetic */ d $callback;
        final /* synthetic */ boolean $support;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(d dVar, boolean z10, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$callback = dVar;
            this.$support = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<q> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.$callback, this.$support, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                this.$callback.a(this.$support);
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
    public OmojiUtils$checkIfOmojiSupported$1$1(Context context, d dVar, c<? super OmojiUtils$checkIfOmojiSupported$1$1> cVar) {
        super(2, cVar);
        this.$context = context;
        this.$callback = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new OmojiUtils$checkIfOmojiSupported$1$1(this.$context, this.$callback, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        if (com.android.contacts.framework.omoji.utils.OmojiUtils.l() != false) goto L16;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.a.c()
            int r0 = r8.label
            if (r0 != 0) goto L5c
            kotlin.b.b(r9)
            boolean r9 = com.android.contacts.framework.api.appstore.appinfo.a.k()
            if (r9 != 0) goto L2e
            boolean r9 = com.oplus.foundation.util.feature.CommonFeatureOption.m()
            if (r9 != 0) goto L2e
            boolean r9 = com.android.contacts.framework.omoji.utils.OmojiUtils.b()
            if (r9 == 0) goto L2e
            android.content.Context r9 = r8.$context
            java.lang.String r0 = "com.oplus.omoji"
            r1 = 1
            boolean r9 = P7.c.f(r9, r0, r1)
            if (r9 == 0) goto L2e
            boolean r9 = com.android.contacts.framework.omoji.utils.OmojiUtils.l()
            if (r9 == 0) goto L2e
            goto L2f
        L2e:
            r1 = 0
        L2f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "support = "
            r9.append(r0)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            java.lang.String r0 = "OmojiUtils"
            H7.b.e(r0, r9)
            kotlinx.coroutines.e0 r2 = kotlinx.coroutines.C1241e0.f34422a
            kotlinx.coroutines.w0 r3 = kotlinx.coroutines.S.c()
            com.android.contacts.framework.omoji.utils.OmojiUtils$checkIfOmojiSupported$1$1$1 r5 = new com.android.contacts.framework.omoji.utils.OmojiUtils$checkIfOmojiSupported$1$1$1
            f1.d r8 = r8.$callback
            r9 = 0
            r5.<init>(r8, r1, r9)
            r6 = 2
            r7 = 0
            r4 = 0
            kotlinx.coroutines.C1244g.d(r2, r3, r4, r5, r6, r7)
            m9.q r8 = m9.q.f35511a
            return r8
        L5c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.omoji.utils.OmojiUtils$checkIfOmojiSupported$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((OmojiUtils$checkIfOmojiSupported$1$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
