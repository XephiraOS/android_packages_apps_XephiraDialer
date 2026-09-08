package com.oplus.blacklistapp.fragment;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.coui.appcompat.preference.COUIInputPreference;
import com.coui.appcompat.preference.COUIMenuPreference;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import p9.InterfaceC1470d;

/* compiled from: EditNumberFragment.kt */
@InterfaceC1470d(c = "com.oplus.blacklistapp.fragment.EditNumberFragment$onCreate$2$onButtonClick$2$1$1$2", f = "EditNumberFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class EditNumberFragment$onCreate$2$onButtonClick$2$1$1$2 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ String $number;
    int label;
    final /* synthetic */ EditNumberFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditNumberFragment$onCreate$2$onButtonClick$2$1$1$2(EditNumberFragment editNumberFragment, String str, kotlin.coroutines.c<? super EditNumberFragment$onCreate$2$onButtonClick$2$1$1$2> cVar) {
        super(2, cVar);
        this.this$0 = editNumberFragment;
        this.$number = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new EditNumberFragment$onCreate$2$onButtonClick$2$1$1$2(this.this$0, this.$number, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        COUIMenuPreference cOUIMenuPreference;
        int i10;
        COUIInputPreference cOUIInputPreference;
        String value;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            FragmentActivity activity = this.this$0.getActivity();
            CharSequence charSequence = null;
            if (activity == null) {
                return null;
            }
            EditNumberFragment editNumberFragment = this.this$0;
            String str = this.$number;
            Intent intent = new Intent();
            cOUIMenuPreference = editNumberFragment.f27094c;
            if (cOUIMenuPreference != null && (value = cOUIMenuPreference.getValue()) != null) {
                kotlin.jvm.internal.i.e(value, "value");
                i10 = Integer.parseInt(value);
            } else {
                i10 = 0;
            }
            intent.putExtra("edit_function", i10);
            intent.putExtra("edit_number", str);
            cOUIInputPreference = editNumberFragment.f27093b;
            if (cOUIInputPreference != null) {
                charSequence = cOUIInputPreference.getContent();
            }
            if (charSequence == null) {
                charSequence = "";
            } else {
                kotlin.jvm.internal.i.e(charSequence, "editNote?.content ?: \"\"");
            }
            intent.putExtra("edit_note", charSequence);
            activity.setResult(-1, intent);
            activity.finish();
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((EditNumberFragment$onCreate$2$onButtonClick$2$1$1$2) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
