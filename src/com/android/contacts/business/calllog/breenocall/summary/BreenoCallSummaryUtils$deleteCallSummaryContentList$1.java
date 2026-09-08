package com.android.contacts.business.calllog.breenocall.summary;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: BreenoCallSummaryUtils.kt */
@InterfaceC1470d(c = "com.android.contacts.business.calllog.breenocall.summary.BreenoCallSummaryUtils$deleteCallSummaryContentList$1", f = "BreenoCallSummaryUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class BreenoCallSummaryUtils$deleteCallSummaryContentList$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ArrayList<String> $uuids;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BreenoCallSummaryUtils$deleteCallSummaryContentList$1(ArrayList<String> arrayList, Context context, kotlin.coroutines.c<? super BreenoCallSummaryUtils$deleteCallSummaryContentList$1> cVar) {
        super(2, cVar);
        this.$uuids = arrayList;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new BreenoCallSummaryUtils$deleteCallSummaryContentList$1(this.$uuids, this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b10;
        String note_authority;
        Integer num;
        Uri uri;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            ArrayList<String> arrayList = this.$uuids;
            Context context = this.$context;
            try {
                Result.a aVar = Result.f34166a;
                ArrayList arrayList2 = new ArrayList();
                for (String str : arrayList) {
                    uri = BreenoCallSummaryUtils.TEXT_NOTE_URI;
                    arrayList2.add(ContentProviderOperation.newDelete(uri.buildUpon().appendQueryParameter("caller_package", context.getPackageName()).appendQueryParameter("speech_log_id", str).build()).build());
                }
                note_authority = BreenoCallSummaryUtils.INSTANCE.getNOTE_AUTHORITY();
                ContentProviderResult[] c10 = G7.a.c(context, note_authority, arrayList2, 500);
                int size = arrayList.size();
                if (c10 != null) {
                    num = C1467a.d(c10.length);
                } else {
                    num = null;
                }
                H7.b.b("BreenoCallSummaryUtils", "deleteCallSummaryContentList: count: " + size + ", result: " + num);
                b10 = Result.b(q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("BreenoCallSummaryUtils", "deleteCallSummaryContentList: exception: " + d10);
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((BreenoCallSummaryUtils$deleteCallSummaryContentList$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
