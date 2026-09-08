package com.android.contacts.dialpad.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: DialerHeaderViewManager.kt */
@InterfaceC1470d(c = "com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowHeaderViewForVocalHighlight$2", f = "DialerHeaderViewManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DialerHeaderViewManager$tryShowHeaderViewForVocalHighlight$2 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref$ObjectRef<ResolveInfo> $resolveInfo;
    int label;
    final /* synthetic */ DialerHeaderViewManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialerHeaderViewManager$tryShowHeaderViewForVocalHighlight$2(Ref$ObjectRef<ResolveInfo> ref$ObjectRef, Context context, DialerHeaderViewManager dialerHeaderViewManager, kotlin.coroutines.c<? super DialerHeaderViewManager$tryShowHeaderViewForVocalHighlight$2> cVar) {
        super(2, cVar);
        this.$resolveInfo = ref$ObjectRef;
        this.$context = context;
        this.this$0 = dialerHeaderViewManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new DialerHeaderViewManager$tryShowHeaderViewForVocalHighlight$2(this.$resolveInfo, this.$context, this.this$0, cVar);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, android.content.pm.ResolveInfo] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        ActivityInfo activityInfo;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.$resolveInfo.element = P7.c.b(new Intent("oplus.intent.action.voice_nc_page_detail"), this.$context, true);
            DialerHeaderViewManager dialerHeaderViewManager = this.this$0;
            ResolveInfo resolveInfo = this.$resolveInfo.element;
            if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null) {
                str = activityInfo.packageName;
            } else {
                str = null;
            }
            dialerHeaderViewManager.f14972d = str;
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((DialerHeaderViewManager$tryShowHeaderViewForVocalHighlight$2) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
