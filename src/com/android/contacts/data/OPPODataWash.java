package com.android.contacts.data;

import com.android.contacts.compat.data.a;
import java.util.HashMap;
import kotlin.collections.E;
import kotlin.jvm.internal.i;
import m9.d;
import m9.g;
import v9.InterfaceC1637a;

/* compiled from: OPPODataWash.kt */
/* loaded from: classes.dex */
public final class OPPODataWash implements a {

    /* renamed from: a, reason: collision with root package name */
    public final d f14163a;

    /* renamed from: b, reason: collision with root package name */
    public final d f14164b;

    public OPPODataWash() {
        d b10;
        d b11;
        b10 = kotlin.a.b(new InterfaceC1637a<HashMap<String, String>>() { // from class: com.android.contacts.data.OPPODataWash$accountRenameMap$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final HashMap<String, String> invoke() {
                HashMap<String, String> e10;
                e10 = E.e(g.a("oppo", "local"), g.a("com.oppo.contacts.device", "com.android.local"));
                return e10;
            }
        });
        this.f14163a = b10;
        b11 = kotlin.a.b(new InterfaceC1637a<HashMap<String, String>>() { // from class: com.android.contacts.data.OPPODataWash$backupRestoreKeyMap$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final HashMap<String, String> invoke() {
                HashMap<String, String> e10;
                e10 = E.e(g.a("X-CUSTOMIZE-GROUP", "X-OPPO-GROUP"), g.a("X-CUSTOMIZE-STARRED", "X-OPPO-STARRED"), g.a("X-CUSTOMIZE-MODIFY-DATE", "X-OPPO-MODIFY-DATE"), g.a("CUSTOMIZE-CBDAY", "OPPO-CBDAY"), g.a("CUSTOMIZE_RECENT_CALL", "OPPO_RECENT_CALL"), g.a("oplus_customize_assisted_dialing_switch", "oppo_assisted_dialing_switch"));
                return e10;
            }
        });
        this.f14164b = b11;
    }

    @Override // com.android.contacts.compat.data.a
    public Object a(String key) {
        i.f(key, "key");
        return null;
    }

    @Override // com.android.contacts.compat.data.a
    public String b(String oldString) {
        i.f(oldString, "oldString");
        String str = d().get(oldString);
        if (str != null) {
            return str;
        }
        return oldString;
    }

    @Override // com.android.contacts.compat.data.a
    public String c(String key) {
        i.f(key, "key");
        return e().get(key);
    }

    public final HashMap<String, String> d() {
        return (HashMap) this.f14163a.getValue();
    }

    public final HashMap<String, String> e() {
        return (HashMap) this.f14164b.getValue();
    }
}
