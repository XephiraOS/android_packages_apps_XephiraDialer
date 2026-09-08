package com.android.contacts.framework.omoji.viewmodel;

import android.content.Context;
import androidx.lifecycle.J;
import com.android.contacts.framework.omoji.utils.OmojiUtils;
import e1.C0964a;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: OmojiViewModule.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.omoji.viewmodel.OmojiViewModule$getOmojiList$1", f = "OmojiViewModule.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class OmojiViewModule$getOmojiList$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ boolean $firstGetList;
    int label;
    final /* synthetic */ OmojiViewModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OmojiViewModule$getOmojiList$1(Context context, boolean z10, OmojiViewModule omojiViewModule, c<? super OmojiViewModule$getOmojiList$1> cVar) {
        super(2, cVar);
        this.$applicationContext = context;
        this.$firstGetList = z10;
        this.this$0 = omojiViewModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new OmojiViewModule$getOmojiList$1(this.$applicationContext, this.$firstGetList, this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            OmojiRepository omojiRepository = OmojiRepository.f16303a;
            Context context = this.$applicationContext;
            boolean z10 = this.$firstGetList;
            final OmojiViewModule omojiViewModule = this.this$0;
            omojiRepository.b(context, z10, new f1.b() { // from class: com.android.contacts.framework.omoji.viewmodel.OmojiViewModule$getOmojiList$1.1
                @Override // f1.b
                public void a(a omojiData) {
                    i.f(omojiData, "omojiData");
                    Integer num = null;
                    if (!OmojiUtils.j(omojiData, OmojiRepository.f16303a.a())) {
                        C1248i.d(J.a(OmojiViewModule.this), S.c(), null, new OmojiViewModule$getOmojiList$1$1$onResult$1(OmojiViewModule.this, omojiData, null), 2, null);
                        return;
                    }
                    List<C0964a.C0293a> a10 = omojiData.a();
                    if (a10 != null) {
                        num = Integer.valueOf(a10.size());
                    }
                    H7.b.e("OmojiViewModule", "isDataEqual omojiData.size : " + num);
                }
            });
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((OmojiViewModule$getOmojiList$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
