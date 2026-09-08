package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* renamed from: kotlinx.coroutines.r0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1276r0 extends AbstractC1284z implements T, InterfaceC1245g0 {

    /* renamed from: d, reason: collision with root package name */
    public s0 f34557d;

    @Override // kotlinx.coroutines.T
    public void b() {
        v().x0(this);
    }

    @Override // kotlinx.coroutines.InterfaceC1245g0
    public boolean c() {
        return true;
    }

    @Override // kotlinx.coroutines.InterfaceC1245g0
    public x0 f() {
        return null;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return G.a(this) + '@' + G.b(this) + "[job@" + G.b(v()) + ']';
    }

    public final s0 v() {
        s0 s0Var = this.f34557d;
        if (s0Var != null) {
            return s0Var;
        }
        kotlin.jvm.internal.i.q("job");
        return null;
    }

    public final void w(s0 s0Var) {
        this.f34557d = s0Var;
    }
}
