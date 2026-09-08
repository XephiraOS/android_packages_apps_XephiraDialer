package com.customize.contacts.util;

import android.content.Context;
import android.content.Intent;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import p9.InterfaceC1470d;

/* compiled from: BlackListUtils.kt */
@InterfaceC1470d(c = "com.customize.contacts.util.BlackListUtils$setBlackList$1", f = "BlackListUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BlackListUtils$setBlackList$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ long $contactId;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $fromCallLog;
    final /* synthetic */ boolean $fromMark;
    final /* synthetic */ Ref$BooleanRef $hasInsertBlacklist;
    final /* synthetic */ Ref$BooleanRef $hasVip;
    final /* synthetic */ boolean $insertToBlack;
    final /* synthetic */ Intent $intentBack;
    final /* synthetic */ ArrayList<String> $phoneList;
    final /* synthetic */ Ref$BooleanRef $success;
    int label;

    /* compiled from: BlackListUtils.kt */
    @InterfaceC1470d(c = "com.customize.contacts.util.BlackListUtils$setBlackList$1$1", f = "BlackListUtils.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.customize.contacts.util.BlackListUtils$setBlackList$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean $fromMark;
        final /* synthetic */ Ref$BooleanRef $hasVip;
        final /* synthetic */ Ref$IntRef $whiteListNumberSize;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Ref$IntRef ref$IntRef, Ref$BooleanRef ref$BooleanRef, Context context, boolean z10, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$whiteListNumberSize = ref$IntRef;
            this.$hasVip = ref$BooleanRef;
            this.$context = context;
            this.$fromMark = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.$whiteListNumberSize, this.$hasVip, this.$context, this.$fromMark, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                int i10 = this.$whiteListNumberSize.element;
                if (i10 > 0 && !this.$hasVip.element) {
                    com.oplus.foundation.util.ui.c.b(this.$context, R.string.oplus_black_not_allow_inert_whitelist);
                } else if (i10 == 0 && !this.$hasVip.element && !this.$fromMark) {
                    com.oplus.foundation.util.ui.c.d(this.$context, R.string.add_from_blacklist);
                }
                return m9.q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
        }
    }

    /* compiled from: BlackListUtils.kt */
    @InterfaceC1470d(c = "com.customize.contacts.util.BlackListUtils$setBlackList$1$2", f = "BlackListUtils.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.customize.contacts.util.BlackListUtils$setBlackList$1$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, kotlin.coroutines.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass2(this.$context, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                com.oplus.foundation.util.ui.c.d(this.$context, R.string.removed_from_the_blacklist);
                return m9.q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
            return ((AnonymousClass2) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlackListUtils$setBlackList$1(boolean z10, ArrayList<String> arrayList, long j10, Context context, Ref$BooleanRef ref$BooleanRef, Intent intent, Ref$BooleanRef ref$BooleanRef2, Ref$BooleanRef ref$BooleanRef3, boolean z11, boolean z12, kotlin.coroutines.c<? super BlackListUtils$setBlackList$1> cVar) {
        super(2, cVar);
        this.$insertToBlack = z10;
        this.$phoneList = arrayList;
        this.$contactId = j10;
        this.$context = context;
        this.$hasVip = ref$BooleanRef;
        this.$intentBack = intent;
        this.$success = ref$BooleanRef2;
        this.$hasInsertBlacklist = ref$BooleanRef3;
        this.$fromMark = z11;
        this.$fromCallLog = z12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new BlackListUtils$setBlackList$1(this.$insertToBlack, this.$phoneList, this.$contactId, this.$context, this.$hasVip, this.$intentBack, this.$success, this.$hasInsertBlacklist, this.$fromMark, this.$fromCallLog, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean h10;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            if (this.$insertToBlack) {
                ArrayList<String> arrayList = new ArrayList<>();
                ArrayList<String> arrayList2 = this.$phoneList;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    if (H7.a.b()) {
                        H7.b.b("BlackListUtils", "setBlackList contactId = " + this.$contactId);
                    }
                    if (this.$contactId >= 0) {
                        Iterator<String> it = this.$phoneList.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!C0811w.i(this.$context, next)) {
                                arrayList.add(next);
                            } else {
                                this.$hasVip.element = true;
                            }
                        }
                    } else {
                        arrayList = this.$phoneList;
                    }
                    if (arrayList.isEmpty()) {
                        this.$hasVip.element = true;
                        this.$intentBack.putExtra("notInsertVipToBlackList", true);
                    } else {
                        Ref$IntRef ref$IntRef = new Ref$IntRef();
                        Iterator<String> it2 = arrayList.iterator();
                        kotlin.jvm.internal.i.e(it2, "tempPhoneList.iterator()");
                        while (it2.hasNext()) {
                            if (BlackListUtils.j(this.$context, it2.next())) {
                                ref$IntRef.element++;
                                it2.remove();
                            }
                        }
                        Ref$BooleanRef ref$BooleanRef = this.$success;
                        h10 = BlackListUtils.f21862a.h(this.$context, this.$contactId, arrayList, 1);
                        ref$BooleanRef.element = h10;
                        Ref$BooleanRef ref$BooleanRef2 = this.$hasInsertBlacklist;
                        Ref$BooleanRef ref$BooleanRef3 = this.$success;
                        ref$BooleanRef2.element = ref$BooleanRef3.element;
                        if (ref$BooleanRef3.element) {
                            BlackListUtils.n(this.$context, arrayList, true);
                        }
                        if (this.$hasVip.element) {
                            this.$intentBack.putExtra("notInsertVipToBlackList", true);
                        }
                        if (H7.a.b()) {
                            H7.b.b("BlackListUtils", "setBlackList: success = " + this.$success.element + " hasVip = " + this.$hasVip.element + " whiteListNumberSize = " + ref$IntRef.element);
                        }
                        C1248i.d(C1241e0.f34422a, kotlinx.coroutines.S.c(), null, new AnonymousClass1(ref$IntRef, this.$hasVip, this.$context, this.$fromMark, null), 2, null);
                    }
                }
            } else {
                this.$success.element = BlackListUtils.k(this.$context, this.$phoneList);
                if (this.$success.element && !this.$fromMark) {
                    C1248i.d(C1241e0.f34422a, kotlinx.coroutines.S.c(), null, new AnonymousClass2(this.$context, null), 2, null);
                }
            }
            if (H7.a.b()) {
                H7.b.b("BlackListUtils", "success = " + this.$success.element);
            }
            if (this.$success.element || this.$hasVip.element) {
                this.$intentBack.putExtra("insertToBlackList", this.$hasInsertBlacklist.element);
                this.$intentBack.putExtra("from_calllog", this.$fromCallLog);
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
        return ((BlackListUtils$setBlackList$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
