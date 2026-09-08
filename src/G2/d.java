package G2;

import com.internal_dependency.AddOnSdkDepends;
import kotlin.jvm.internal.i;

/* compiled from: OplusPropertyUtil.kt */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1090a = new d();

    public static final String a(String key) {
        i.f(key, "key");
        return AddOnSdkDepends.Companion.getSInstance().getOplusSystemProperties(key);
    }

    public static final String b(String key, String def) {
        i.f(key, "key");
        i.f(def, "def");
        return AddOnSdkDepends.Companion.getSInstance().getOplusSystemProperties(key, def);
    }
}
