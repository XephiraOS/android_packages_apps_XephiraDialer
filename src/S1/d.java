package s1;

import android.content.Context;

/* compiled from: ConfigProviderBindings.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static InterfaceC1524b f36626a;

    /* renamed from: b, reason: collision with root package name */
    public static InterfaceC1524b f36627b;

    public static InterfaceC1524b a(Context context) {
        try {
            InterfaceC1524b interfaceC1524b = f36626a;
            if (interfaceC1524b != null) {
                return interfaceC1524b;
            }
            if (!P7.e.d(context)) {
                if (f36627b == null) {
                    f36627b = new a();
                }
                return f36627b;
            }
            InterfaceC1524b a10 = C1523a.a(context.getApplicationContext());
            f36626a = a10;
            return a10;
        } catch (Exception e10) {
            C1.a.b("ConfigProviderBindings", "ConfigProviderBindings error " + e10);
            if (f36627b == null) {
                f36627b = new a();
            }
            return f36627b;
        }
    }

    /* compiled from: ConfigProviderBindings.java */
    /* loaded from: classes.dex */
    public static class a implements InterfaceC1524b {
        public a() {
        }

        @Override // s1.InterfaceC1524b
        public boolean a(String str, boolean z10) {
            return z10;
        }

        @Override // s1.InterfaceC1524b
        public String b(String str, String str2) {
            return str2;
        }
    }
}
