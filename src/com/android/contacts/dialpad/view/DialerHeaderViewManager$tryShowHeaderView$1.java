package com.android.contacts.dialpad.view;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: DialerHeaderViewManager.kt */
@InterfaceC1470d(c = "com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowHeaderView$1", f = "DialerHeaderViewManager.kt", l = {507, 521, 531, 541, 546, 551, 556, 561, 571, 576}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DialerHeaderViewManager$tryShowHeaderView$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DialerHeaderViewManager this$0;

    /* compiled from: DialerHeaderViewManager.kt */
    @InterfaceC1470d(c = "com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowHeaderView$1$1", f = "DialerHeaderViewManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowHeaderView$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
        final /* synthetic */ Ref$ObjectRef<String> $defaultPackage;
        int label;
        final /* synthetic */ DialerHeaderViewManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Ref$ObjectRef<String> ref$ObjectRef, DialerHeaderViewManager dialerHeaderViewManager, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$defaultPackage = ref$ObjectRef;
            this.this$0 = dialerHeaderViewManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.$defaultPackage, this.this$0, cVar);
        }

        /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                this.$defaultPackage.element = P7.d.a(this.this$0.E());
                return q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialerHeaderViewManager$tryShowHeaderView$1(DialerHeaderViewManager dialerHeaderViewManager, kotlin.coroutines.c<? super DialerHeaderViewManager$tryShowHeaderView$1> cVar) {
        super(2, cVar);
        this.this$0 = dialerHeaderViewManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new DialerHeaderViewManager$tryShowHeaderView$1(this.this$0, cVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0081  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            Method dump skipped, instructions count: 504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowHeaderView$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((DialerHeaderViewManager$tryShowHeaderView$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
