package kotlinx.coroutines;

/* compiled from: MainCoroutineDispatcher.kt */
/* loaded from: classes4.dex */
public abstract class w0 extends CoroutineDispatcher {
    public abstract w0 i0();

    public final String j0() {
        w0 w0Var;
        w0 c10 = S.c();
        if (this == c10) {
            return "Dispatchers.Main";
        }
        try {
            w0Var = c10.i0();
        } catch (UnsupportedOperationException unused) {
            w0Var = null;
        }
        if (this != w0Var) {
            return null;
        }
        return "Dispatchers.Main.immediate";
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String j02 = j0();
        if (j02 == null) {
            return G.a(this) + '@' + G.b(this);
        }
        return j02;
    }
}
