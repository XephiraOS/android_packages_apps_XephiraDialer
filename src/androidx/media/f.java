package androidx.media;

/* compiled from: MediaSessionManager.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public g f10529a;

    public f(String str, int i10, int i11) {
        this.f10529a = new h(str, i10, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return this.f10529a.equals(((f) obj).f10529a);
    }

    public int hashCode() {
        return this.f10529a.hashCode();
    }
}
