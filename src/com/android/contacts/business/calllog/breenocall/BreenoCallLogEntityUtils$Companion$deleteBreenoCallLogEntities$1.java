package com.android.contacts.business.calllog.breenocall;

import android.content.Context;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Result;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.E;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: BreenoCallLogEntityUtils.kt */
@InterfaceC1470d(c = "com.android.contacts.business.calllog.breenocall.BreenoCallLogEntityUtils$Companion$deleteBreenoCallLogEntities$1", f = "BreenoCallLogEntityUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class BreenoCallLogEntityUtils$Companion$deleteBreenoCallLogEntities$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ArrayList<String> $phonelist;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BreenoCallLogEntityUtils$Companion$deleteBreenoCallLogEntities$1(ArrayList<String> arrayList, Context context, c<? super BreenoCallLogEntityUtils$Companion$deleteBreenoCallLogEntities$1> cVar) {
        super(2, cVar);
        this.$phonelist = arrayList;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new BreenoCallLogEntityUtils$Companion$deleteBreenoCallLogEntities$1(this.$phonelist, this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b10;
        Set P10;
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            ArrayList<String> arrayList = this.$phonelist;
            Context context = this.$context;
            try {
                Result.a aVar = Result.f34166a;
                P10 = CollectionsKt___CollectionsKt.P(arrayList);
                String[] strArr = (String[]) P10.toArray(new String[0]);
                H7.b.b("BreenoCallLogEntityUtils", "deleteBreenoCallLogEntities phones count: " + strArr.length);
                StringBuilder sb = new StringBuilder();
                int length = strArr.length;
                for (int i10 = 0; i10 < length; i10++) {
                    sb.append("?,");
                }
                i.e(sb.deleteCharAt(sb.length() - 1), "deleteCharAt(...)");
                b10 = Result.b(C1467a.d(context.getContentResolver().delete(BreenoCallContract.Call.CONTENT_URI, "number IN (" + ((Object) sb) + ")", strArr)));
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("BreenoCallLogEntityUtils", "deleteBreenoCallLogEntities failed: " + d10);
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((BreenoCallLogEntityUtils$Companion$deleteBreenoCallLogEntities$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
