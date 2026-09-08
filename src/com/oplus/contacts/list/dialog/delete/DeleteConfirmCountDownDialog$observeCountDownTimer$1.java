package com.oplus.contacts.list.dialog.delete;

import android.util.Log;
import android.widget.Button;
import com.oplus.dialer.R;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.flow.m;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: DeleteConfirmCountDownDialog.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.dialog.delete.DeleteConfirmCountDownDialog$observeCountDownTimer$1", f = "DeleteConfirmCountDownDialog.kt", l = {91}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DeleteConfirmCountDownDialog$observeCountDownTimer$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    int label;
    final /* synthetic */ DeleteConfirmCountDownDialog this$0;

    /* compiled from: DeleteConfirmCountDownDialog.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> implements kotlinx.coroutines.flow.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeleteConfirmCountDownDialog f27912a;

        public a(DeleteConfirmCountDownDialog deleteConfirmCountDownDialog) {
            this.f27912a = deleteConfirmCountDownDialog;
        }

        @Override // kotlinx.coroutines.flow.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(Integer num, kotlin.coroutines.c<? super q> cVar) {
            Button button;
            Button button2;
            button = this.f27912a.f27910b;
            Log.d("DeleteConfirmCountDownDialog", "observeCountDownTimer: " + num + ", btn:" + button);
            button2 = this.f27912a.f27910b;
            if (button2 != null) {
                DeleteConfirmCountDownDialog deleteConfirmCountDownDialog = this.f27912a;
                if (num == null) {
                    button2.setEnabled(false);
                } else if (num.intValue() > 0) {
                    button2.setEnabled(false);
                    button2.setText(deleteConfirmCountDownDialog.getString(R.string.countdown_delete_button, num));
                } else {
                    button2.setEnabled(true);
                    button2.setText(R.string.delete_button);
                }
            }
            return q.f35511a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteConfirmCountDownDialog$observeCountDownTimer$1(DeleteConfirmCountDownDialog deleteConfirmCountDownDialog, kotlin.coroutines.c<? super DeleteConfirmCountDownDialog$observeCountDownTimer$1> cVar) {
        super(2, cVar);
        this.this$0 = deleteConfirmCountDownDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new DeleteConfirmCountDownDialog$observeCountDownTimer$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        DeleteConfirmCountDownDialogViewModel g12;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        } else {
            kotlin.b.b(obj);
            g12 = this.this$0.g1();
            m<Integer> h10 = g12.h();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (h10.collect(aVar, this) == c10) {
                return c10;
            }
        }
        throw new KotlinNothingValueException();
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((DeleteConfirmCountDownDialog$observeCountDownTimer$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
