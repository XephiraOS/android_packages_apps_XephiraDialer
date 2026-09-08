package v8;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import y8.C1714f;
import y8.InterfaceC1715g;

/* compiled from: ServiceRecorder.java */
/* loaded from: classes3.dex */
public class k implements g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f37503a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f37504b;

    static {
        byte[] decode = Base64.decode("Y29tLm5lYXJtZS5zdGF0aXN0aWNzLnJvbQ==", 0);
        Charset charset = StandardCharsets.UTF_8;
        f37503a = new String(decode, charset);
        f37504b = new String(Base64.decode("Y29tLm5lYXJtZS5zdGF0aXN0aWNzLnJvbS5zZXJ2aWNlLlJlY2VpdmVyU2VydmljZQ==", 0), charset);
    }

    public static /* synthetic */ String e(Context context) {
        return "add Task failed: bean or context is null. context=" + context;
    }

    public static /* synthetic */ String f(Exception exc) {
        return "startService exception=" + exc;
    }

    @Override // v8.g
    public void a(final Context context, u8.f fVar) {
        if (fVar != null && context != null) {
            try {
                context.startService(d(fVar));
                return;
            } catch (Exception e10) {
                C1714f.f("ServiceRecorder", new InterfaceC1715g() { // from class: v8.j
                    @Override // y8.InterfaceC1715g
                    public final Object get() {
                        String f10;
                        f10 = k.f(e10);
                        return f10;
                    }
                });
                return;
            }
        }
        C1714f.a("ServiceRecorder", new InterfaceC1715g() { // from class: v8.i
            @Override // y8.InterfaceC1715g
            public final Object get() {
                String e11;
                e11 = k.e(context);
                return e11;
            }
        });
    }

    public final Intent d(u8.f fVar) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(f37503a, f37504b));
        for (Map.Entry<String, Object> entry : fVar.h().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                intent.putExtra(key, (String) value);
            } else if (value instanceof Integer) {
                intent.putExtra(key, (Integer) value);
            } else if (value instanceof Long) {
                intent.putExtra(key, (Long) value);
            } else if (value instanceof Boolean) {
                intent.putExtra(key, (Boolean) value);
            }
        }
        return intent;
    }
}
