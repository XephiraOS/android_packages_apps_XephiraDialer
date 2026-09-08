package d5;

/* compiled from: DecodedInformation.java */
/* loaded from: classes3.dex */
public final class n extends p {

    /* renamed from: b, reason: collision with root package name */
    public final String f30043b;

    /* renamed from: c, reason: collision with root package name */
    public final int f30044c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f30045d;

    public n(int i10, String str) {
        super(i10);
        this.f30043b = str;
        this.f30045d = false;
        this.f30044c = 0;
    }

    public String b() {
        return this.f30043b;
    }

    public int c() {
        return this.f30044c;
    }

    public boolean d() {
        return this.f30045d;
    }

    public n(int i10, String str, int i11) {
        super(i10);
        this.f30045d = true;
        this.f30044c = i11;
        this.f30043b = str;
    }
}
