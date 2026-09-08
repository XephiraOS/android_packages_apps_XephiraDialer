package com.oplus.contacts.list.viewmodel;

import a7.C0424a;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.flow.i;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: ImportContactsTipsViewModel.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.viewmodel.ImportContactsTipsViewModel$onModeChanged$1", f = "ImportContactsTipsViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ImportContactsTipsViewModel$onModeChanged$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ boolean $isSuperPowerMode;
    int label;
    final /* synthetic */ ImportContactsTipsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportContactsTipsViewModel$onModeChanged$1(ImportContactsTipsViewModel importContactsTipsViewModel, boolean z10, c<? super ImportContactsTipsViewModel$onModeChanged$1> cVar) {
        super(2, cVar);
        this.this$0 = importContactsTipsViewModel;
        this.$isSuperPowerMode = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new ImportContactsTipsViewModel$onModeChanged$1(this.this$0, this.$isSuperPowerMode, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        i iVar;
        Object value;
        C0424a c0424a;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            iVar = this.this$0.f28100e;
            boolean z10 = this.$isSuperPowerMode;
            do {
                value = iVar.getValue();
                c0424a = (C0424a) value;
            } while (!iVar.c(value, C0424a.b(c0424a, false, C0424a.C0094a.b(c0424a.d(), null, z10, 1, null), 1, null)));
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((ImportContactsTipsViewModel$onModeChanged$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
