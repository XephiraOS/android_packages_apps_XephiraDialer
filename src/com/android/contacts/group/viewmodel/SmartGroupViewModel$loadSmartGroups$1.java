package com.android.contacts.group.viewmodel;

import com.android.contacts.group.model.SmartGroupRepository;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: SmartGroupViewModel.kt */
@InterfaceC1470d(c = "com.android.contacts.group.viewmodel.SmartGroupViewModel$loadSmartGroups$1", f = "SmartGroupViewModel.kt", l = {35}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SmartGroupViewModel$loadSmartGroups$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ int $groupMode;
    int label;
    final /* synthetic */ SmartGroupViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartGroupViewModel$loadSmartGroups$1(SmartGroupViewModel smartGroupViewModel, int i10, c<? super SmartGroupViewModel$loadSmartGroups$1> cVar) {
        super(2, cVar);
        this.this$0 = smartGroupViewModel;
        this.$groupMode = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new SmartGroupViewModel$loadSmartGroups$1(this.this$0, this.$groupMode, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        SmartGroupRepository smartGroupRepository;
        c10 = b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            smartGroupRepository = this.this$0.f16711d;
            int i11 = this.$groupMode;
            this.label = 1;
            obj = smartGroupRepository.c(i11, this);
            if (obj == c10) {
                return c10;
            }
        }
        this.this$0.h().m((List) obj);
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((SmartGroupViewModel$loadSmartGroups$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
