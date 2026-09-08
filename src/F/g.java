package F;

import android.os.LocaleList;

/* compiled from: LocaleListPlatformWrapper.java */
/* loaded from: classes.dex */
public final class g implements f {

    /* renamed from: a, reason: collision with root package name */
    public final LocaleList f784a;

    public g(Object obj) {
        this.f784a = (LocaleList) obj;
    }

    @Override // F.f
    public String a() {
        return this.f784a.toLanguageTags();
    }

    @Override // F.f
    public Object b() {
        return this.f784a;
    }

    public boolean equals(Object obj) {
        return this.f784a.equals(((f) obj).b());
    }

    public int hashCode() {
        return this.f784a.hashCode();
    }

    @Override // F.f
    public boolean isEmpty() {
        return this.f784a.isEmpty();
    }

    public String toString() {
        return this.f784a.toString();
    }
}
