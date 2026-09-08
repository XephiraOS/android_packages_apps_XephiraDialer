package com.android.contacts.dialpad.view;

import androidx.core.app.ComponentActivity;
import androidx.lifecycle.LiveData;
import com.android.contacts.dialpad.view.DialerHeaderViewManager;
import com.android.contacts.framework.baseui.util.NoNetworkCommUiStateUtil;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import kotlinx.coroutines.w0;
import m9.q;
import p9.InterfaceC1470d;
import v9.l;
import v9.p;

/* compiled from: DialerHeaderViewManager.kt */
@InterfaceC1470d(c = "com.android.contacts.dialpad.view.DialerHeaderViewManager$initDialerHeaderView$4", f = "DialerHeaderViewManager.kt", l = {477}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DialerHeaderViewManager$initDialerHeaderView$4 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    int label;
    final /* synthetic */ DialerHeaderViewManager this$0;

    /* compiled from: DialerHeaderViewManager.kt */
    @InterfaceC1470d(c = "com.android.contacts.dialpad.view.DialerHeaderViewManager$initDialerHeaderView$4$1", f = "DialerHeaderViewManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.android.contacts.dialpad.view.DialerHeaderViewManager$initDialerHeaderView$4$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
        final /* synthetic */ LiveData<Boolean> $noNetworkSupportLiveData;
        int label;
        final /* synthetic */ DialerHeaderViewManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LiveData<Boolean> liveData, DialerHeaderViewManager dialerHeaderViewManager, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$noNetworkSupportLiveData = liveData;
            this.this$0 = dialerHeaderViewManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.$noNetworkSupportLiveData, this.this$0, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                LiveData<Boolean> liveData = this.$noNetworkSupportLiveData;
                ComponentActivity E10 = this.this$0.E();
                final DialerHeaderViewManager dialerHeaderViewManager = this.this$0;
                liveData.i(E10, new DialerHeaderViewManager.c(new l<Boolean, q>() { // from class: com.android.contacts.dialpad.view.DialerHeaderViewManager.initDialerHeaderView.4.1.1
                    {
                        super(1);
                    }

                    public final void b(Boolean bool) {
                        int i10;
                        int i11;
                        H7.b.e("DialerHeaderViewManager", "NoNetworkCommUiStateUtil isSupport : " + bool);
                        if (!bool.booleanValue()) {
                            i10 = DialerHeaderViewManager.this.f14978j;
                            if (i10 != 12) {
                                i11 = DialerHeaderViewManager.this.f14978j;
                                if (i11 != 13) {
                                    return;
                                }
                            }
                            DialerHeaderViewManager.this.K(false);
                        }
                    }

                    @Override // v9.l
                    public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                        b(bool);
                        return q.f35511a;
                    }
                }));
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
    public DialerHeaderViewManager$initDialerHeaderView$4(DialerHeaderViewManager dialerHeaderViewManager, kotlin.coroutines.c<? super DialerHeaderViewManager$initDialerHeaderView$4> cVar) {
        super(2, cVar);
        this.this$0 = dialerHeaderViewManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new DialerHeaderViewManager$initDialerHeaderView$4(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
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
            LiveData<Boolean> i11 = NoNetworkCommUiStateUtil.i();
            w0 c11 = S.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(i11, this.this$0, null);
            this.label = 1;
            if (C1244g.g(c11, anonymousClass1, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((DialerHeaderViewManager$initDialerHeaderView$4) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
