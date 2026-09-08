package C8;

/* compiled from: CanFakedField.kt */
/* loaded from: classes3.dex */
public class c<SCOPE> extends d<SCOPE> {

    /* renamed from: a, reason: collision with root package name */
    public SCOPE f412a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f413b;

    /* renamed from: c, reason: collision with root package name */
    public SCOPE f414c;

    public c(SCOPE scope) {
        this.f412a = scope;
    }

    public final void a() {
        this.f413b = false;
        this.f414c = null;
        c();
    }

    public synchronized SCOPE b() {
        SCOPE scope;
        try {
            if (this.f413b) {
                scope = this.f414c;
            } else {
                scope = this.f412a;
            }
        } catch (Throwable th) {
            throw th;
        }
        return scope;
    }

    public final void c() {
        setChanged();
        notifyObservers(b());
    }

    public synchronized void d(SCOPE scope) {
        this.f413b = true;
        this.f414c = scope;
        c();
    }

    public synchronized void e(SCOPE scope) {
        this.f412a = scope;
        a();
    }
}
