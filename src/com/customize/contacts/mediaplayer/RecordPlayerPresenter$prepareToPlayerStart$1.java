package com.customize.contacts.mediaplayer;

import android.database.Cursor;
import android.provider.MediaStore;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: RecordPlayerPresenter.kt */
@InterfaceC1470d(c = "com.customize.contacts.mediaplayer.RecordPlayerPresenter$prepareToPlayerStart$1", f = "RecordPlayerPresenter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class RecordPlayerPresenter$prepareToPlayerStart$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    int label;
    final /* synthetic */ RecordPlayerPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordPlayerPresenter$prepareToPlayerStart$1(RecordPlayerPresenter recordPlayerPresenter, kotlin.coroutines.c<? super RecordPlayerPresenter$prepareToPlayerStart$1> cVar) {
        super(2, cVar);
        this.this$0 = recordPlayerPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new RecordPlayerPresenter$prepareToPlayerStart$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        String str3;
        int i10;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            str = this.this$0.f21658l;
            if (str != null) {
                str3 = this.this$0.f21658l;
                if (str3 != null) {
                    i10 = StringsKt__StringsKt.O(str3, "/", 0, false, 6, null);
                } else {
                    i10 = 0;
                }
                str2 = str.substring(i10);
                i.e(str2, "substring(...)");
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = this.this$0.f21658l;
            }
            try {
                Cursor query = this.this$0.U().getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{BreenoCallContract.BaseColumns._ID}, "_data like ?", new String[]{"%" + str2}, null);
                if (query != null) {
                    RecordPlayerPresenter recordPlayerPresenter = this.this$0;
                    try {
                        Ref$LongRef ref$LongRef = new Ref$LongRef();
                        ref$LongRef.element = -1L;
                        query.moveToFirst();
                        if (query.getCount() <= 0 || query.getColumnCount() <= 0) {
                            C1248i.d(recordPlayerPresenter.f21648b, S.c(), null, new RecordPlayerPresenter$prepareToPlayerStart$1$1$2(recordPlayerPresenter, null), 2, null);
                        } else {
                            ref$LongRef.element = query.getLong(0);
                            H7.b.b("RecordPlayerPresenter", "prepareToPlayerStart the cursor count is:" + query.getCount() + ", the id is:" + ref$LongRef.element);
                            C1248i.d(recordPlayerPresenter.f21648b, S.c(), null, new RecordPlayerPresenter$prepareToPlayerStart$1$1$1(recordPlayerPresenter, ref$LongRef, null), 2, null);
                        }
                        kotlin.io.a.a(query, null);
                    } finally {
                    }
                }
            } catch (Exception e10) {
                H7.b.c("RecordPlayerPresenter", "prepareToPlayerStart query media recording id ex:" + e10);
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((RecordPlayerPresenter$prepareToPlayerStart$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
