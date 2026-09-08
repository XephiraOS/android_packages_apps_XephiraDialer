package com.oplus.contacts.list.dialog.delete;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: DeleteConfirmCountDownDialogViewModel.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.dialog.delete.DeleteConfirmCountDownDialogViewModel$startCountDown$1", f = "DeleteConfirmCountDownDialogViewModel.kt", l = {44, 45}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DeleteConfirmCountDownDialogViewModel$startCountDown$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ int $totalTime;
    int I$0;
    int label;
    final /* synthetic */ DeleteConfirmCountDownDialogViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteConfirmCountDownDialogViewModel$startCountDown$1(int i10, DeleteConfirmCountDownDialogViewModel deleteConfirmCountDownDialogViewModel, kotlin.coroutines.c<? super DeleteConfirmCountDownDialogViewModel$startCountDown$1> cVar) {
        super(2, cVar);
        this.$totalTime = i10;
        this.this$0 = deleteConfirmCountDownDialogViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new DeleteConfirmCountDownDialogViewModel$startCountDown$1(this.$totalTime, this.this$0, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004a -> B:6:0x004d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.c()
            int r1 = r7.label
            r2 = -1
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L23
            if (r1 == r4) goto L1d
            if (r1 != r3) goto L15
            int r1 = r7.I$0
            kotlin.b.b(r8)
            goto L4d
        L15:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1d:
            int r1 = r7.I$0
            kotlin.b.b(r8)
            goto L40
        L23:
            kotlin.b.b(r8)
            int r8 = r7.$totalTime
        L28:
            if (r2 >= r8) goto L50
            com.oplus.contacts.list.dialog.delete.DeleteConfirmCountDownDialogViewModel r1 = r7.this$0
            kotlinx.coroutines.flow.i r1 = com.oplus.contacts.list.dialog.delete.DeleteConfirmCountDownDialogViewModel.g(r1)
            java.lang.Integer r5 = p9.C1467a.d(r8)
            r7.I$0 = r8
            r7.label = r4
            java.lang.Object r1 = r1.emit(r5, r7)
            if (r1 != r0) goto L3f
            return r0
        L3f:
            r1 = r8
        L40:
            r7.I$0 = r1
            r7.label = r3
            r5 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r8 = kotlinx.coroutines.M.a(r5, r7)
            if (r8 != r0) goto L4d
            return r0
        L4d:
            int r8 = r1 + (-1)
            goto L28
        L50:
            m9.q r7 = m9.q.f35511a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.contacts.list.dialog.delete.DeleteConfirmCountDownDialogViewModel$startCountDown$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((DeleteConfirmCountDownDialogViewModel$startCountDown$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
