package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.i;
import m9.q;
import p9.C1471e;
import p9.C1472f;
import p9.InterfaceC1469c;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes4.dex */
public abstract class BaseContinuationImpl implements c<Object>, InterfaceC1469c, Serializable {
    private final c<Object> completion;

    public BaseContinuationImpl(c<Object> cVar) {
        this.completion = cVar;
    }

    public c<q> create(c<?> completion) {
        i.f(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // p9.InterfaceC1469c
    public InterfaceC1469c getCallerFrame() {
        c<Object> cVar = this.completion;
        if (cVar instanceof InterfaceC1469c) {
            return (InterfaceC1469c) cVar;
        }
        return null;
    }

    public final c<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return C1471e.d(this);
    }

    public abstract Object invokeSuspend(Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.coroutines.c<java.lang.Object>, kotlin.coroutines.c, java.lang.Object] */
    @Override // kotlin.coroutines.c
    public final void resumeWith(Object obj) {
        Object invokeSuspend;
        Object c10;
        while (true) {
            C1472f.b(this);
            BaseContinuationImpl baseContinuationImpl = this;
            ?? r02 = baseContinuationImpl.completion;
            i.c(r02);
            try {
                invokeSuspend = baseContinuationImpl.invokeSuspend(obj);
                c10 = b.c();
            } catch (Throwable th) {
                Result.a aVar = Result.f34166a;
                obj = Result.b(kotlin.b.a(th));
            }
            if (invokeSuspend == c10) {
                return;
            }
            obj = Result.b(invokeSuspend);
            baseContinuationImpl.releaseIntercepted();
            if (r02 instanceof BaseContinuationImpl) {
                this = r02;
            } else {
                r02.resumeWith(obj);
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public c<q> create(Object obj, c<?> completion) {
        i.f(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
