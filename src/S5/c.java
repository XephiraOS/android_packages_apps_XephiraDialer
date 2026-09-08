package s5;

import android.content.Context;

/* compiled from: BufferPoolConfig.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public Context f36815a;

    /* renamed from: b, reason: collision with root package name */
    public int f36816b;

    /* renamed from: c, reason: collision with root package name */
    public int f36817c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f36818d;

    public c(Context context) {
        if (context != null) {
            this.f36815a = context.getApplicationContext();
            this.f36818d = true;
            return;
        }
        throw new RuntimeException("Failed to configure the Pool!");
    }

    public static c a(Context context) {
        return new c(context);
    }
}
