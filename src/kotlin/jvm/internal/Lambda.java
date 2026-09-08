package kotlin.jvm.internal;

import java.io.Serializable;

/* compiled from: Lambda.kt */
/* loaded from: classes4.dex */
public abstract class Lambda<R> implements h<R>, Serializable {
    private final int arity;

    public Lambda(int i10) {
        this.arity = i10;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String g10 = k.g(this);
        i.e(g10, "renderLambdaToString(...)");
        return g10;
    }
}
