package com.android.contacts.business.calllog.breenocall.detail;

import android.content.Context;
import com.android.contacts.business.calllog.breenocall.BreenoCallLogEntity;
import com.android.contacts.business.calllog.breenocall.NameInfo;
import com.android.contacts.business.calllog.breenocall.detail.BreenoCallTipManager;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import kotlinx.coroutines.w0;
import m9.q;
import p9.InterfaceC1470d;
import v9.l;
import v9.p;

/* compiled from: BreenoCallTipManager.kt */
@InterfaceC1470d(c = "com.android.contacts.business.calllog.breenocall.detail.BreenoCallTipManager$asyncLoad$1", f = "BreenoCallTipManager.kt", l = {118}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class BreenoCallTipManager$asyncLoad$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ l<String, q> $callback;
    int label;
    final /* synthetic */ BreenoCallTipManager this$0;

    /* compiled from: BreenoCallTipManager.kt */
    @InterfaceC1470d(c = "com.android.contacts.business.calllog.breenocall.detail.BreenoCallTipManager$asyncLoad$1$1", f = "BreenoCallTipManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.android.contacts.business.calllog.breenocall.detail.BreenoCallTipManager$asyncLoad$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<E, c<? super q>, Object> {
        final /* synthetic */ l<String, q> $callback;
        final /* synthetic */ BreenoCallLogEntity $e;
        int label;
        final /* synthetic */ BreenoCallTipManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(BreenoCallTipManager breenoCallTipManager, BreenoCallLogEntity breenoCallLogEntity, l<? super String, q> lVar, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = breenoCallTipManager;
            this.$e = breenoCallLogEntity;
            this.$callback = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<q> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.this$0, this.$e, this.$callback, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            BreenoCallLogEntity breenoCallLogEntity;
            BreenoCallTipManager.ITipController iTipController;
            BreenoCallTipManager.ITipController iTipController2;
            String str;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                this.this$0.entity = this.$e;
                Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                ref$BooleanRef.element = true;
                breenoCallLogEntity = this.this$0.entity;
                if (breenoCallLogEntity != null) {
                    l<String, q> lVar = this.$callback;
                    BreenoCallTipManager breenoCallTipManager = this.this$0;
                    breenoCallLogEntity.nomarlize();
                    if (breenoCallLogEntity.getNameInfoList() != null && (!r6.isEmpty())) {
                        ref$BooleanRef.element = false;
                        if (lVar != null) {
                            List<NameInfo> nameInfoList = breenoCallLogEntity.getNameInfoList();
                            if (nameInfoList != null) {
                                if (nameInfoList.isEmpty()) {
                                    str = "";
                                } else {
                                    str = nameInfoList.get(0).getName();
                                }
                            } else {
                                str = null;
                            }
                            lVar.invoke(str);
                        }
                        iTipController2 = breenoCallTipManager.tipController;
                        iTipController2.onTipUpdated(BreenoCallTipManager.TIP_ID);
                    }
                }
                if (ref$BooleanRef.element) {
                    iTipController = this.this$0.tipController;
                    iTipController.onTipDismiss(BreenoCallTipManager.TIP_ID, false);
                }
                this.this$0.loaded = true;
                return q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(E e10, c<? super q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BreenoCallTipManager$asyncLoad$1(BreenoCallTipManager breenoCallTipManager, l<? super String, q> lVar, c<? super BreenoCallTipManager$asyncLoad$1> cVar) {
        super(2, cVar);
        this.this$0 = breenoCallTipManager;
        this.$callback = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new BreenoCallTipManager$asyncLoad$1(this.this$0, this.$callback, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        Context context;
        String str;
        boolean queryNumberTypeInfo;
        BreenoCallLogEntity breenoCallLogEntity;
        boolean z10;
        Context context2;
        String str2;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            BreenoCallTipManager breenoCallTipManager = this.this$0;
            context = breenoCallTipManager.context;
            str = this.this$0.number;
            queryNumberTypeInfo = breenoCallTipManager.queryNumberTypeInfo(context, str);
            if (queryNumberTypeInfo) {
                BreenoCallTipManager breenoCallTipManager2 = this.this$0;
                context2 = breenoCallTipManager2.context;
                str2 = this.this$0.number;
                breenoCallLogEntity = breenoCallTipManager2.query(context2, str2);
            } else {
                breenoCallLogEntity = null;
            }
            if (breenoCallLogEntity != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            H7.b.b("BreenoCallTipManager", "query[" + queryNumberTypeInfo + "]: get entity: " + z10);
            w0 c11 = S.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, breenoCallLogEntity, this.$callback, null);
            this.label = 1;
            if (C1244g.g(c11, anonymousClass1, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((BreenoCallTipManager$asyncLoad$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
