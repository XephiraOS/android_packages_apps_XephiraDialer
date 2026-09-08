package com.oplus.foundation.util.ui;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: ShowUnfoldScreenStatusChecker.kt */
@InterfaceC1470d(c = "com.oplus.foundation.util.ui.ShowUnfoldScreenStatusChecker$refreshIfNeed$1", f = "ShowUnfoldScreenStatusChecker.kt", l = {56, 58}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ShowUnfoldScreenStatusChecker$refreshIfNeed$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ boolean $showUnfoldScreen;
    private /* synthetic */ Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ ShowUnfoldScreenStatusChecker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShowUnfoldScreenStatusChecker$refreshIfNeed$1(ShowUnfoldScreenStatusChecker showUnfoldScreenStatusChecker, AppCompatActivity appCompatActivity, boolean z10, kotlin.coroutines.c<? super ShowUnfoldScreenStatusChecker$refreshIfNeed$1> cVar) {
        super(2, cVar);
        this.this$0 = showUnfoldScreenStatusChecker;
        this.$activity = appCompatActivity;
        this.$showUnfoldScreen = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        ShowUnfoldScreenStatusChecker$refreshIfNeed$1 showUnfoldScreenStatusChecker$refreshIfNeed$1 = new ShowUnfoldScreenStatusChecker$refreshIfNeed$1(this.this$0, this.$activity, this.$showUnfoldScreen, cVar);
        showUnfoldScreenStatusChecker$refreshIfNeed$1.L$0 = obj;
        return showUnfoldScreenStatusChecker$refreshIfNeed$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0078 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.c()
            int r1 = r9.label
            r2 = 2
            java.lang.String r3 = "ResponseUIConfigStatusChecker"
            r4 = 1
            if (r1 == 0) goto L2c
            if (r1 == r4) goto L1e
            if (r1 != r2) goto L16
            kotlin.b.b(r10)     // Catch: java.lang.Throwable -> L14
            goto L7e
        L14:
            r9 = move-exception
            goto L85
        L16:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L1e:
            boolean r1 = r9.Z$0
            java.lang.Object r4 = r9.L$1
            androidx.appcompat.app.AppCompatActivity r4 = (androidx.appcompat.app.AppCompatActivity) r4
            java.lang.Object r5 = r9.L$0
            com.oplus.foundation.util.ui.ShowUnfoldScreenStatusChecker r5 = (com.oplus.foundation.util.ui.ShowUnfoldScreenStatusChecker) r5
            kotlin.b.b(r10)     // Catch: java.lang.Throwable -> L14
            goto L5d
        L2c:
            kotlin.b.b(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.E r10 = (kotlinx.coroutines.E) r10
            com.oplus.foundation.util.ui.ShowUnfoldScreenStatusChecker r5 = r9.this$0
            androidx.appcompat.app.AppCompatActivity r10 = r9.$activity
            boolean r1 = r9.$showUnfoldScreen
            kotlin.Result$a r6 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L14
            android.content.Context r6 = r10.getApplicationContext()     // Catch: java.lang.Throwable -> L14
            java.lang.String r7 = "activity.applicationContext"
            kotlin.jvm.internal.i.e(r6, r7)     // Catch: java.lang.Throwable -> L14
            boolean r6 = com.oplus.foundation.util.ui.ShowUnfoldScreenStatusChecker.a(r5, r6)     // Catch: java.lang.Throwable -> L14
            if (r6 == r1) goto L79
            r9.L$0 = r5     // Catch: java.lang.Throwable -> L14
            r9.L$1 = r10     // Catch: java.lang.Throwable -> L14
            r9.Z$0 = r6     // Catch: java.lang.Throwable -> L14
            r9.label = r4     // Catch: java.lang.Throwable -> L14
            r7 = 350(0x15e, double:1.73E-321)
            java.lang.Object r1 = kotlinx.coroutines.M.a(r7, r9)     // Catch: java.lang.Throwable -> L14
            if (r1 != r0) goto L5b
            return r0
        L5b:
            r4 = r10
            r1 = r6
        L5d:
            java.lang.String r10 = "start refresh"
            H7.b.e(r3, r10)     // Catch: java.lang.Throwable -> L14
            kotlinx.coroutines.w0 r10 = kotlinx.coroutines.S.c()     // Catch: java.lang.Throwable -> L14
            com.oplus.foundation.util.ui.ShowUnfoldScreenStatusChecker$refreshIfNeed$1$1$1 r6 = new com.oplus.foundation.util.ui.ShowUnfoldScreenStatusChecker$refreshIfNeed$1$1$1     // Catch: java.lang.Throwable -> L14
            r7 = 0
            r6.<init>(r5, r1, r4, r7)     // Catch: java.lang.Throwable -> L14
            r9.L$0 = r7     // Catch: java.lang.Throwable -> L14
            r9.L$1 = r7     // Catch: java.lang.Throwable -> L14
            r9.label = r2     // Catch: java.lang.Throwable -> L14
            java.lang.Object r9 = kotlinx.coroutines.C1244g.g(r10, r6, r9)     // Catch: java.lang.Throwable -> L14
            if (r9 != r0) goto L7e
            return r0
        L79:
            java.lang.String r9 = "no need to refresh"
            H7.b.e(r3, r9)     // Catch: java.lang.Throwable -> L14
        L7e:
            m9.q r9 = m9.q.f35511a     // Catch: java.lang.Throwable -> L14
            java.lang.Object r9 = kotlin.Result.b(r9)     // Catch: java.lang.Throwable -> L14
            goto L8f
        L85:
            kotlin.Result$a r10 = kotlin.Result.f34166a
            java.lang.Object r9 = kotlin.b.a(r9)
            java.lang.Object r9 = kotlin.Result.b(r9)
        L8f:
            java.lang.Throwable r9 = kotlin.Result.d(r9)
            if (r9 == 0) goto Lb5
            java.lang.String r10 = r9.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "refreshIfNeed error: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = " "
            r0.append(r9)
            r0.append(r10)
            java.lang.String r9 = r0.toString()
            H7.b.c(r3, r9)
        Lb5:
            m9.q r9 = m9.q.f35511a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.foundation.util.ui.ShowUnfoldScreenStatusChecker$refreshIfNeed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((ShowUnfoldScreenStatusChecker$refreshIfNeed$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
