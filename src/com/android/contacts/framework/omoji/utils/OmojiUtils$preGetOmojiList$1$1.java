package com.android.contacts.framework.omoji.utils;

import android.content.Context;
import com.android.contacts.framework.omoji.viewmodel.OmojiRepository;
import com.android.contacts.framework.omoji.viewmodel.OmojiViewModule;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: OmojiUtils.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.omoji.utils.OmojiUtils$preGetOmojiList$1$1", f = "OmojiUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class OmojiUtils$preGetOmojiList$1$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ Context $it;
    final /* synthetic */ OmojiViewModule $module;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OmojiUtils$preGetOmojiList$1$1(Context context, OmojiViewModule omojiViewModule, c<? super OmojiUtils$preGetOmojiList$1$1> cVar) {
        super(2, cVar);
        this.$it = context;
        this.$module = omojiViewModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new OmojiUtils$preGetOmojiList$1$1(this.$it, this.$module, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            H7.b.e("OmojiUtils", "preGetOmojiList ----------");
            if (OmojiUtils.k(this.$it.getApplicationContext())) {
                OmojiRepository.f16303a.a().d(null);
                return q.f35511a;
            }
            H7.b.e("OmojiUtils", "not first");
            this.$module.h(this.$it.getApplicationContext(), false, false);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((OmojiUtils$preGetOmojiList$1$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
