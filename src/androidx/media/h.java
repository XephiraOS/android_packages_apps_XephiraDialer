package androidx.media;

import android.media.session.MediaSessionManager;

/* compiled from: MediaSessionManagerImplApi28.java */
/* loaded from: classes.dex */
public final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    public final MediaSessionManager.RemoteUserInfo f10530a;

    public h(String str, int i10, int i11) {
        this.f10530a = new MediaSessionManager.RemoteUserInfo(str, i10, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        return this.f10530a.equals(((h) obj).f10530a);
    }

    public int hashCode() {
        return I.c.b(this.f10530a);
    }
}
