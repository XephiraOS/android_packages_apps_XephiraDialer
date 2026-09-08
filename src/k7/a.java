package K7;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.j;
import kotlin.jvm.internal.i;

/* compiled from: NetworkPermissionUtils.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final void a(Context context, boolean z10) {
        i.f(context, "context");
        SharedPreferences.Editor edit = j.b(context).edit();
        edit.putBoolean("has_grant_network_permission", z10);
        edit.apply();
    }
}
