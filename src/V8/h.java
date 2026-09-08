package v8;

import android.content.Context;
import y8.C1717i;

/* compiled from: ProxyRecorder.java */
/* loaded from: classes3.dex */
public class h implements g {

    /* renamed from: a, reason: collision with root package name */
    public g f37499a;

    /* compiled from: ProxyRecorder.java */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static h f37500a = new h();
    }

    public h() {
    }

    public static h c() {
        return b.f37500a;
    }

    @Override // v8.g
    public void a(Context context, u8.f fVar) {
        b(context);
        this.f37499a.a(context, fVar);
    }

    public final void b(Context context) {
        if (this.f37499a != null) {
            return;
        }
        if (C1717i.a(context)) {
            this.f37499a = new f();
        } else {
            this.f37499a = new k();
        }
    }
}
