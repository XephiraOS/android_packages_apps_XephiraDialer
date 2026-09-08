package com.customize.contacts.startupspeed;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: CallLogPreload.kt */
@InterfaceC1470d(c = "com.customize.contacts.startupspeed.CallLogPreload$cacheDialCallLog$1", f = "CallLogPreload.kt", l = {71}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CallLogPreload$cacheDialCallLog$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CallLogPreload this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallLogPreload$cacheDialCallLog$1(CallLogPreload callLogPreload, kotlin.coroutines.c<? super CallLogPreload$cacheDialCallLog$1> cVar) {
        super(2, cVar);
        this.this$0 = callLogPreload;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new CallLogPreload$cacheDialCallLog$1(this.this$0, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00be  */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v7, types: [T, android.database.MatrixCursor] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.String r0 = "StartupSpeedHelper"
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.c()
            int r2 = r13.label
            r3 = 1
            if (r2 == 0) goto L2a
            if (r2 != r3) goto L22
            java.lang.Object r0 = r13.L$1
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r13 = r13.L$0
            java.lang.String r13 = (java.lang.String) r13
            kotlin.b.b(r14)     // Catch: java.lang.Throwable -> L1c
            r14 = r0
            r0 = r13
            goto La4
        L1c:
            r14 = move-exception
            r12 = r0
            r0 = r13
        L1f:
            r13 = r12
            goto Lab
        L22:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L2a:
            kotlin.b.b(r14)
            boolean r14 = com.customize.contacts.FeatureOption.i()
            if (r14 == 0) goto L42
            com.customize.contacts.startupspeed.CallLogPreload r14 = r13.this$0
            com.customize.contacts.activities.ContactsTabActivity r14 = r14.f()
            boolean r14 = com.android.contacts.framework.baseui.util.StatementUtils.p(r14)
            if (r14 != 0) goto L42
            m9.q r13 = m9.q.f35511a
            return r13
        L42:
            java.lang.String r14 = "cache dial call log"
            com.customize.contacts.startupspeed.CallLogPreload r2 = r13.this$0
            kotlin.Result$a r4 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L79
            android.net.Uri r6 = com.android.contacts.calllog.r.n()     // Catch: java.lang.Throwable -> L79
            java.lang.String[] r4 = com.android.contacts.framework.baseui.calllog.d.a()     // Catch: java.lang.Throwable -> L79
            java.lang.String r8 = com.customize.contacts.util.C0801l.f()     // Catch: java.lang.Throwable -> L79
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch: java.lang.Throwable -> L79
            r11.<init>()     // Catch: java.lang.Throwable -> L79
            com.customize.contacts.activities.ContactsTabActivity r5 = r2.f()     // Catch: java.lang.Throwable -> L79
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L79
            r9 = 0
            r10 = 0
            r7 = r4
            android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L79
            r11.element = r5     // Catch: java.lang.Throwable -> L79
            if (r5 != 0) goto L7d
            java.lang.String r5 = "cacheDialCallLog but cursor is null"
            H7.b.c(r0, r5)     // Catch: java.lang.Throwable -> L79
            android.database.MatrixCursor r5 = new android.database.MatrixCursor     // Catch: java.lang.Throwable -> L79
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L79
            r11.element = r5     // Catch: java.lang.Throwable -> L79
            goto L7d
        L79:
            r13 = move-exception
            r12 = r14
            r14 = r13
            goto L1f
        L7d:
            com.android.contacts.framework.baseui.calllog.b r4 = new com.android.contacts.framework.baseui.calllog.b     // Catch: java.lang.Throwable -> L79
            r4.<init>()     // Catch: java.lang.Throwable -> L79
            T r5 = r11.element     // Catch: java.lang.Throwable -> L79
            android.database.Cursor r5 = (android.database.Cursor) r5     // Catch: java.lang.Throwable -> L79
            r6 = 12
            r4.f(r5, r6)     // Catch: java.lang.Throwable -> L79
            r4.f15772a = r3     // Catch: java.lang.Throwable -> L79
            kotlinx.coroutines.w0 r5 = kotlinx.coroutines.S.c()     // Catch: java.lang.Throwable -> L79
            com.customize.contacts.startupspeed.CallLogPreload$cacheDialCallLog$1$1$1 r6 = new com.customize.contacts.startupspeed.CallLogPreload$cacheDialCallLog$1$1$1     // Catch: java.lang.Throwable -> L79
            r7 = 0
            r6.<init>(r2, r11, r4, r7)     // Catch: java.lang.Throwable -> L79
            r13.L$0 = r0     // Catch: java.lang.Throwable -> L79
            r13.L$1 = r14     // Catch: java.lang.Throwable -> L79
            r13.label = r3     // Catch: java.lang.Throwable -> L79
            java.lang.Object r13 = kotlinx.coroutines.C1244g.g(r5, r6, r13)     // Catch: java.lang.Throwable -> L79
            if (r13 != r1) goto La4
            return r1
        La4:
            m9.q r13 = m9.q.f35511a     // Catch: java.lang.Throwable -> L79
            java.lang.Object r13 = kotlin.Result.b(r13)     // Catch: java.lang.Throwable -> L79
            goto Lb8
        Lab:
            kotlin.Result$a r1 = kotlin.Result.f34166a
            java.lang.Object r14 = kotlin.b.a(r14)
            java.lang.Object r14 = kotlin.Result.b(r14)
            r12 = r14
            r14 = r13
            r13 = r12
        Lb8:
            java.lang.Throwable r13 = kotlin.Result.d(r13)
            if (r13 == 0) goto Ld5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r14)
            java.lang.String r14 = " : "
            r1.append(r14)
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            android.util.Log.e(r0, r13)
        Ld5:
            m9.q r13 = m9.q.f35511a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.startupspeed.CallLogPreload$cacheDialCallLog$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((CallLogPreload$cacheDialCallLog$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
