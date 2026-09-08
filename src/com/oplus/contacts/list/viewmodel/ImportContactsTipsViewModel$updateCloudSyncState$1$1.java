package com.oplus.contacts.list.viewmodel;

import P7.e;
import a7.C0424a;
import android.content.Context;
import com.android.contacts.list.ContactListFilter;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.flow.i;
import m1.AbstractC1316l;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: ImportContactsTipsViewModel.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.viewmodel.ImportContactsTipsViewModel$updateCloudSyncState$1$1", f = "ImportContactsTipsViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ImportContactsTipsViewModel$updateCloudSyncState$1$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    int label;
    final /* synthetic */ ImportContactsTipsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportContactsTipsViewModel$updateCloudSyncState$1$1(ImportContactsTipsViewModel importContactsTipsViewModel, c<? super ImportContactsTipsViewModel$updateCloudSyncState$1$1> cVar) {
        super(2, cVar);
        this.this$0 = importContactsTipsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new ImportContactsTipsViewModel$updateCloudSyncState$1$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        i iVar;
        Object value;
        Context k10;
        boolean z10;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            boolean z11 = false;
            if (com.android.contacts.framework.api.cloudsync.a.g()) {
                com.android.contacts.framework.api.cloudsync.a.e();
                com.android.contacts.framework.api.cloudsync.a.b();
                k10 = this.this$0.k();
                ContactListFilter e10 = AbstractC1316l.f(k10).e();
                if (e10 != null && e10.f16738b != -2 && !M3.c.q(e10.f16740d, e10.f16739c)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (!e.c() && z10) {
                    z11 = true;
                }
            }
            iVar = this.this$0.f28100e;
            do {
                value = iVar.getValue();
            } while (!iVar.c(value, C0424a.b((C0424a) value, z11, null, 2, null)));
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((ImportContactsTipsViewModel$updateCloudSyncState$1$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
