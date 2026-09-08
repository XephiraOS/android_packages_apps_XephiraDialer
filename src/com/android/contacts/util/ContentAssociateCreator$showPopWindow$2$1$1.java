package com.android.contacts.util;

import android.view.View;
import com.android.contacts.util.A;
import com.android.contacts.util.ContentAssociateCreator;
import com.customize.contacts.util.SoftKeyboardUtil;
import java.lang.ref.WeakReference;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import p9.InterfaceC1470d;

/* compiled from: ContentAssociateCreator.kt */
@InterfaceC1470d(c = "com.android.contacts.util.ContentAssociateCreator$showPopWindow$2$1$1", f = "ContentAssociateCreator.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ContentAssociateCreator$showPopWindow$2$1$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ ContentAssociateCreator this$0;

    /* compiled from: ContentAssociateCreator.kt */
    @InterfaceC1470d(c = "com.android.contacts.util.ContentAssociateCreator$showPopWindow$2$1$1$1", f = "ContentAssociateCreator.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.android.contacts.util.ContentAssociateCreator$showPopWindow$2$1$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
        final /* synthetic */ int $position;
        int label;
        final /* synthetic */ ContentAssociateCreator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ContentAssociateCreator contentAssociateCreator, int i10, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = contentAssociateCreator;
            this.$position = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.this$0, this.$position, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ContentAssociateCreator.b bVar;
            Object obj2;
            WeakReference weakReference;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                bVar = this.this$0.f17544q;
                View view = null;
                if (bVar != null) {
                    obj2 = bVar.getItem(this.$position);
                } else {
                    obj2 = null;
                }
                if (obj2 instanceof A.b) {
                    SoftKeyboardUtil a10 = SoftKeyboardUtil.a();
                    weakReference = this.this$0.f17543p;
                    if (weakReference != null) {
                        view = (View) weakReference.get();
                    }
                    a10.b(view);
                    A.b bVar2 = (A.b) obj2;
                    this.this$0.D(bVar2.c(), bVar2.e());
                }
                return m9.q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentAssociateCreator$showPopWindow$2$1$1(ContentAssociateCreator contentAssociateCreator, int i10, kotlin.coroutines.c<? super ContentAssociateCreator$showPopWindow$2$1$1> cVar) {
        super(2, cVar);
        this.this$0 = contentAssociateCreator;
        this.$position = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContentAssociateCreator$showPopWindow$2$1$1(this.this$0, this.$position, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            C1248i.d(this.this$0.r(), S.c(), null, new AnonymousClass1(this.this$0, this.$position, null), 2, null);
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((ContentAssociateCreator$showPopWindow$2$1$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
