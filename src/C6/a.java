package C6;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.internal.i;

/* compiled from: BaseUiUtils.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f379a = new a();

    public static final int a(Context context) {
        i.f(context, "context");
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return context.getResources().getDimensionPixelOffset(f.f387a);
    }

    public static final boolean b(SharedPreferences sp) {
        i.f(sp, "sp");
        return sp.getBoolean("blacklist_net_enable", false);
    }

    public static final boolean c(Context context) {
        i.f(context, "context");
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }
}
