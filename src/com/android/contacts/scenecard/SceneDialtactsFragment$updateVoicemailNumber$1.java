package com.android.contacts.scenecard;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.w0;
import p9.InterfaceC1470d;

/* compiled from: SceneDialtactsFragment.kt */
@InterfaceC1470d(c = "com.android.contacts.scenecard.SceneDialtactsFragment$updateVoicemailNumber$1", f = "SceneDialtactsFragment.kt", l = {322}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SceneDialtactsFragment$updateVoicemailNumber$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    int label;
    final /* synthetic */ SceneDialtactsFragment this$0;

    /* compiled from: SceneDialtactsFragment.kt */
    @InterfaceC1470d(c = "com.android.contacts.scenecard.SceneDialtactsFragment$updateVoicemailNumber$1$1", f = "SceneDialtactsFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.android.contacts.scenecard.SceneDialtactsFragment$updateVoicemailNumber$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
        int label;
        final /* synthetic */ SceneDialtactsFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SceneDialtactsFragment sceneDialtactsFragment, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = sceneDialtactsFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.this$0, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                SceneCallLogAdapter sceneCallLogAdapter = this.this$0.f17209d;
                if (sceneCallLogAdapter != null) {
                    sceneCallLogAdapter.S();
                    return m9.q.f35511a;
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SceneDialtactsFragment$updateVoicemailNumber$1(SceneDialtactsFragment sceneDialtactsFragment, kotlin.coroutines.c<? super SceneDialtactsFragment$updateVoicemailNumber$1> cVar) {
        super(2, cVar);
        this.this$0 = sceneDialtactsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new SceneDialtactsFragment$updateVoicemailNumber$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        com.android.contacts.calllog.I H10;
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
            SceneCallLogAdapter sceneCallLogAdapter = this.this$0.f17209d;
            if (sceneCallLogAdapter != null && (H10 = sceneCallLogAdapter.H()) != null && H10.l(this.this$0.requireContext())) {
                H7.b.e("SceneDialtactsFragment", "updateVoicemailNumber");
                w0 c11 = kotlinx.coroutines.S.c();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
                this.label = 1;
                if (C1244g.g(c11, anonymousClass1, this) == c10) {
                    return c10;
                }
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((SceneDialtactsFragment$updateVoicemailNumber$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
