package c4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SpringConfigRegistry.java */
/* loaded from: classes3.dex */
public class i {

    /* renamed from: b, reason: collision with root package name */
    public static final i f12778b = new i(true);

    /* renamed from: a, reason: collision with root package name */
    public final Map<h, String> f12779a = new HashMap();

    public i(boolean z10) {
        if (z10) {
            a(h.f12775c, "default config");
        }
    }

    public static i c() {
        return f12778b;
    }

    public boolean a(h hVar, String str) {
        if (hVar != null) {
            if (str != null) {
                if (this.f12779a.containsKey(hVar)) {
                    return false;
                }
                this.f12779a.put(hVar, str);
                return true;
            }
            throw new IllegalArgumentException("configName is required");
        }
        throw new IllegalArgumentException("springConfig is required");
    }

    public Map<h, String> b() {
        return Collections.unmodifiableMap(this.f12779a);
    }
}
