package com.customize.contacts.util;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import p9.InterfaceC1470d;

/* compiled from: BlackListUtils.kt */
@InterfaceC1470d(c = "com.customize.contacts.util.BlackListUtils$setWhiteList$1", f = "BlackListUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BlackListUtils$setWhiteList$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ long $contactId;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $fromCalLog;
    final /* synthetic */ Ref$BooleanRef $hasInsertWhiteList;
    final /* synthetic */ boolean $insertToWhite;
    final /* synthetic */ Intent $intentBack;
    final /* synthetic */ ArrayList<String> $phoneList;
    final /* synthetic */ Ref$BooleanRef $success;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlackListUtils$setWhiteList$1(boolean z10, ArrayList<String> arrayList, Ref$BooleanRef ref$BooleanRef, Context context, long j10, Ref$BooleanRef ref$BooleanRef2, Intent intent, boolean z11, kotlin.coroutines.c<? super BlackListUtils$setWhiteList$1> cVar) {
        super(2, cVar);
        this.$insertToWhite = z10;
        this.$phoneList = arrayList;
        this.$success = ref$BooleanRef;
        this.$context = context;
        this.$contactId = j10;
        this.$hasInsertWhiteList = ref$BooleanRef2;
        this.$intentBack = intent;
        this.$fromCalLog = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new BlackListUtils$setWhiteList$1(this.$insertToWhite, this.$phoneList, this.$success, this.$context, this.$contactId, this.$hasInsertWhiteList, this.$intentBack, this.$fromCalLog, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean h10;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            if (this.$insertToWhite) {
                ArrayList<String> arrayList = this.$phoneList;
                if (arrayList != null && arrayList.size() > 0) {
                    Ref$BooleanRef ref$BooleanRef = this.$success;
                    h10 = BlackListUtils.f21862a.h(this.$context, this.$contactId, this.$phoneList, 2);
                    ref$BooleanRef.element = h10;
                    Ref$BooleanRef ref$BooleanRef2 = this.$hasInsertWhiteList;
                    Ref$BooleanRef ref$BooleanRef3 = this.$success;
                    ref$BooleanRef2.element = ref$BooleanRef3.element;
                    if (ref$BooleanRef3.element) {
                        BlackListUtils.n(this.$context, this.$phoneList, false);
                    }
                }
            } else {
                this.$success.element = BlackListUtils.m(this.$context, this.$phoneList);
            }
            if (this.$success.element) {
                this.$intentBack.putExtra("insertToWhiteList", this.$hasInsertWhiteList.element);
                this.$intentBack.putExtra("from_calllog", this.$fromCalLog);
                X.a b10 = X.a.b(this.$context);
                kotlin.jvm.internal.i.e(b10, "getInstance(context)");
                b10.d(this.$intentBack);
            }
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((BlackListUtils$setWhiteList$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
