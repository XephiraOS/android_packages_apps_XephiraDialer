package com.android.contacts.scenecard;

import android.content.Context;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import p9.InterfaceC1470d;

/* compiled from: SceneCallLogAdapter.kt */
@InterfaceC1470d(c = "com.android.contacts.scenecard.SceneCallLogAdapter$onItemClick$2", f = "SceneCallLogAdapter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SceneCallLogAdapter$onItemClick$2 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ long $contactsId;
    final /* synthetic */ String $countryIso;
    final /* synthetic */ String $number;
    final /* synthetic */ Ref$IntRef $slotId;
    int label;
    final /* synthetic */ SceneCallLogAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SceneCallLogAdapter$onItemClick$2(SceneCallLogAdapter sceneCallLogAdapter, String str, long j10, Ref$IntRef ref$IntRef, String str2, kotlin.coroutines.c<? super SceneCallLogAdapter$onItemClick$2> cVar) {
        super(2, cVar);
        this.this$0 = sceneCallLogAdapter;
        this.$number = str;
        this.$contactsId = j10;
        this.$slotId = ref$IntRef;
        this.$countryIso = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new SceneCallLogAdapter$onItemClick$2(this.this$0, this.$number, this.$contactsId, this.$slotId, this.$countryIso, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Context context;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            SceneCallLogAdapter sceneCallLogAdapter = this.this$0;
            context = sceneCallLogAdapter.f17115a;
            String number = this.$number;
            kotlin.jvm.internal.i.e(number, "number");
            sceneCallLogAdapter.v(context, number, this.$contactsId, this.$slotId.element, this.$countryIso);
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((SceneCallLogAdapter$onItemClick$2) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
