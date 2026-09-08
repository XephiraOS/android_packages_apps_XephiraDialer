package com.oplus.blacklistapp.fragment;

import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.oplus.blacklistapp.u;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import p9.InterfaceC1470d;

/* compiled from: EditNumberFragment.kt */
@InterfaceC1470d(c = "com.oplus.blacklistapp.fragment.EditNumberFragment$onCreate$2$onButtonClick$2$1$1$1", f = "EditNumberFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class EditNumberFragment$onCreate$2$onButtonClick$2$1$1$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    int label;
    final /* synthetic */ EditNumberFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditNumberFragment$onCreate$2$onButtonClick$2$1$1$1(EditNumberFragment editNumberFragment, kotlin.coroutines.c<? super EditNumberFragment$onCreate$2$onButtonClick$2$1$1$1> cVar) {
        super(2, cVar);
        this.this$0 = editNumberFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new EditNumberFragment$onCreate$2$onButtonClick$2$1$1$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                Toast.makeText(activity, u.f27543N, 1).show();
                return m9.q.f35511a;
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((EditNumberFragment$onCreate$2$onButtonClick$2$1$1$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
