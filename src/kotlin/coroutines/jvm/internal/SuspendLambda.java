package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes4.dex */
public abstract class SuspendLambda extends ContinuationImpl implements h<Object> {
    private final int arity;

    public SuspendLambda(int i10, c<Object> cVar) {
        super(cVar);
        this.arity = i10;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() == null) {
            String f10 = k.f(this);
            i.e(f10, "renderLambdaToString(...)");
            return f10;
        }
        return super.toString();
    }

    public SuspendLambda(int i10) {
        this(i10, null);
    }
}
