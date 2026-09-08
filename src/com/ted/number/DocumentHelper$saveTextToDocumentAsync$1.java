package com.ted.number;

import android.content.Context;
import java.util.function.Consumer;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import kotlinx.coroutines.w0;
import p9.InterfaceC1470d;
import v9.InterfaceC1637a;

/* compiled from: DocumentHelper.kt */
@InterfaceC1470d(c = "com.ted.number.DocumentHelper$saveTextToDocumentAsync$1", f = "DocumentHelper.kt", l = {64}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class DocumentHelper$saveTextToDocumentAsync$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ InterfaceC1637a<String> $getFileNameFunc;
    final /* synthetic */ Consumer<String> $resultListener;
    final /* synthetic */ String $text;
    int label;

    /* compiled from: DocumentHelper.kt */
    @InterfaceC1470d(c = "com.ted.number.DocumentHelper$saveTextToDocumentAsync$1$2", f = "DocumentHelper.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.ted.number.DocumentHelper$saveTextToDocumentAsync$1$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
        final /* synthetic */ Object $result;
        final /* synthetic */ Consumer<String> $resultListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Consumer<String> consumer, Object obj, kotlin.coroutines.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$resultListener = consumer;
            this.$result = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass2(this.$resultListener, this.$result, cVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                Consumer<String> consumer = this.$resultListener;
                Object obj2 = this.$result;
                if (Result.f(obj2)) {
                    obj2 = null;
                }
                consumer.accept(obj2);
                return m9.q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
            return ((AnonymousClass2) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentHelper$saveTextToDocumentAsync$1(Context context, InterfaceC1637a<String> interfaceC1637a, String str, Consumer<String> consumer, kotlin.coroutines.c<? super DocumentHelper$saveTextToDocumentAsync$1> cVar) {
        super(2, cVar);
        this.$context = context;
        this.$getFileNameFunc = interfaceC1637a;
        this.$text = str;
        this.$resultListener = consumer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new DocumentHelper$saveTextToDocumentAsync$1(this.$context, this.$getFileNameFunc, this.$text, this.$resultListener, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        Object b10;
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
            Context context = this.$context;
            InterfaceC1637a<String> interfaceC1637a = this.$getFileNameFunc;
            String str = this.$text;
            try {
                Result.a aVar = Result.f34166a;
                b10 = Result.b(DocumentHelper.f29569a.c(context, interfaceC1637a.invoke(), str));
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("DocumentHelper", "saveTextToDocumentAsync exception : " + d10);
            }
            w0 c11 = S.c();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$resultListener, b10, null);
            this.label = 1;
            if (C1244g.g(c11, anonymousClass2, this) == c10) {
                return c10;
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((DocumentHelper$saveTextToDocumentAsync$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
