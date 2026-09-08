package com.oplus.blacklistapp.fragment;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.coui.appcompat.preference.COUIMenuPreference;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import p9.InterfaceC1470d;

/* compiled from: EditFirstMatchFragment.kt */
@InterfaceC1470d(c = "com.oplus.blacklistapp.fragment.EditFirstMatchFragment$onCreate$2$onButtonClick$2$1$1$2", f = "EditFirstMatchFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class EditFirstMatchFragment$onCreate$2$onButtonClick$2$1$1$2 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ String $number;
    int label;
    final /* synthetic */ EditFirstMatchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFirstMatchFragment$onCreate$2$onButtonClick$2$1$1$2(EditFirstMatchFragment editFirstMatchFragment, String str, kotlin.coroutines.c<? super EditFirstMatchFragment$onCreate$2$onButtonClick$2$1$1$2> cVar) {
        super(2, cVar);
        this.this$0 = editFirstMatchFragment;
        this.$number = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new EditFirstMatchFragment$onCreate$2$onButtonClick$2$1$1$2(this.this$0, this.$number, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        COUIMenuPreference cOUIMenuPreference;
        int i10;
        String value;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                EditFirstMatchFragment editFirstMatchFragment = this.this$0;
                String str = this.$number;
                Intent intent = new Intent();
                cOUIMenuPreference = editFirstMatchFragment.f27085b;
                if (cOUIMenuPreference != null && (value = cOUIMenuPreference.getValue()) != null) {
                    kotlin.jvm.internal.i.e(value, "value");
                    i10 = Integer.parseInt(value);
                } else {
                    i10 = 0;
                }
                intent.putExtra("edit_function", i10);
                intent.putExtra("edit_number", str);
                activity.setResult(-1, intent);
                activity.finish();
                return m9.q.f35511a;
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((EditFirstMatchFragment$onCreate$2$onButtonClick$2$1$1$2) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
