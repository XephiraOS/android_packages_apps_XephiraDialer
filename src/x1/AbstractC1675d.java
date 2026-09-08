package x1;

/* compiled from: ImapElement.java */
/* renamed from: x1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1675d {

    /* renamed from: b, reason: collision with root package name */
    public static final AbstractC1675d f37831b = new a();

    /* renamed from: a, reason: collision with root package name */
    public boolean f37832a = false;

    public final void a() {
        if (!this.f37832a) {
        } else {
            throw new RuntimeException("Already destroyed");
        }
    }

    public void b() {
        this.f37832a = true;
    }

    public boolean c() {
        return this.f37832a;
    }

    public abstract boolean d();

    public abstract boolean e();

    /* compiled from: ImapElement.java */
    /* renamed from: x1.d$a */
    /* loaded from: classes.dex */
    public class a extends AbstractC1675d {
        @Override // x1.AbstractC1675d
        public boolean d() {
            return false;
        }

        @Override // x1.AbstractC1675d
        public boolean e() {
            return false;
        }

        public String toString() {
            return "[NO ELEMENT]";
        }

        @Override // x1.AbstractC1675d
        public void b() {
        }
    }
}
