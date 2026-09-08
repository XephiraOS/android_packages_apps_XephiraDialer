package r0;

import com.android.contacts.compat.data.WashManager;
import kotlin.text.n;

/* compiled from: VCardConstantsUtils.kt */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f36280a = new k();

    public static final String a(String newKey, boolean z10) {
        kotlin.jvm.internal.i.f(newKey, "newKey");
        if (z10) {
            return newKey;
        }
        return WashManager.b(newKey);
    }

    public static final int b(String line) {
        boolean v10;
        kotlin.jvm.internal.i.f(line, "line");
        v10 = n.v(line, "oppo_assisted_dialing_switch", false, 2, null);
        if (v10) {
            String substring = line.substring(28);
            kotlin.jvm.internal.i.e(substring, "substring(...)");
            Boolean valueOf = Boolean.valueOf(substring);
            kotlin.jvm.internal.i.e(valueOf, "valueOf(assistedDialingSwitch)");
            return valueOf.booleanValue() ? 1 : 0;
        }
        return -1;
    }

    public static final boolean c(String str) {
        if (kotlin.jvm.internal.i.b("OPPO-CBDAY", str)) {
            return true;
        }
        return false;
    }

    public static final boolean d(String str) {
        if (!kotlin.jvm.internal.i.b("X-OPPO-GROUP", str) && !kotlin.jvm.internal.i.b("X-OPPO_GROUP", str)) {
            return false;
        }
        return true;
    }

    public static final boolean e(String str) {
        if (kotlin.jvm.internal.i.b("X-OPPO-MODIFY-DATE", str)) {
            return true;
        }
        return false;
    }

    public static final boolean f(String str) {
        if (kotlin.jvm.internal.i.b("OPPO_RECENT_CALL", str)) {
            return true;
        }
        return false;
    }

    public static final boolean g(String str) {
        if (kotlin.jvm.internal.i.b("X-OPPO-STARRED", str)) {
            return true;
        }
        return false;
    }
}
