package com.oplus.blacklistapp.fragment;

import android.content.Context;
import android.database.Cursor;
import com.oplus.utils.C0855p;
import java.io.Closeable;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import kotlinx.coroutines.w0;
import p9.InterfaceC1470d;

/* compiled from: EditFirstMatchFragment.kt */
@InterfaceC1470d(c = "com.oplus.blacklistapp.fragment.EditFirstMatchFragment$onCreate$2$onButtonClick$2", f = "EditFirstMatchFragment.kt", l = {103, 109}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class EditFirstMatchFragment$onCreate$2$onButtonClick$2 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ String $number;
    Object L$0;
    int label;
    final /* synthetic */ EditFirstMatchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFirstMatchFragment$onCreate$2$onButtonClick$2(EditFirstMatchFragment editFirstMatchFragment, String str, kotlin.coroutines.c<? super EditFirstMatchFragment$onCreate$2$onButtonClick$2> cVar) {
        super(2, cVar);
        this.this$0 = editFirstMatchFragment;
        this.$number = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new EditFirstMatchFragment$onCreate$2$onButtonClick$2(this.this$0, this.$number, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        Throwable th;
        Closeable closeable;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    closeable = (Closeable) this.L$0;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                closeable = (Closeable) this.L$0;
            }
            try {
                kotlin.b.b(obj);
            } catch (Throwable th2) {
                th = th2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    kotlin.io.a.a(closeable, th);
                    throw th3;
                }
            }
        } else {
            kotlin.b.b(obj);
            Context context = this.this$0.getContext();
            if (context != null) {
                String str = this.$number;
                EditFirstMatchFragment editFirstMatchFragment = this.this$0;
                Cursor query = context.getContentResolver().query(C0855p.a.f29171a, null, "number=? AND list_type=?", new String[]{str, "3"}, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            w0 c11 = S.c();
                            EditFirstMatchFragment$onCreate$2$onButtonClick$2$1$1$1 editFirstMatchFragment$onCreate$2$onButtonClick$2$1$1$1 = new EditFirstMatchFragment$onCreate$2$onButtonClick$2$1$1$1(editFirstMatchFragment, null);
                            this.L$0 = query;
                            this.label = 1;
                            if (C1244g.g(c11, editFirstMatchFragment$onCreate$2$onButtonClick$2$1$1$1, this) == c10) {
                                return c10;
                            }
                        } else {
                            w0 c12 = S.c();
                            EditFirstMatchFragment$onCreate$2$onButtonClick$2$1$1$2 editFirstMatchFragment$onCreate$2$onButtonClick$2$1$1$2 = new EditFirstMatchFragment$onCreate$2$onButtonClick$2$1$1$2(editFirstMatchFragment, str, null);
                            this.L$0 = query;
                            this.label = 2;
                            if (C1244g.g(c12, editFirstMatchFragment$onCreate$2$onButtonClick$2$1$1$2, this) == c10) {
                                return c10;
                            }
                        }
                        closeable = query;
                    } catch (Throwable th4) {
                        th = th4;
                        closeable = query;
                        throw th;
                    }
                }
            }
            return m9.q.f35511a;
        }
        m9.q qVar = m9.q.f35511a;
        kotlin.io.a.a(closeable, null);
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((EditFirstMatchFragment$onCreate$2$onButtonClick$2) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
