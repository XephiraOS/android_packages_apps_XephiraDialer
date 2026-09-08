package I6;

import android.content.Context;
import com.oplus.utils.C0846g;
import kotlin.jvm.internal.i;

/* compiled from: CustomizeBrandUtils.kt */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1357a = new b();

    public static final String a(String number) {
        i.f(number, "number");
        C0846g.i("CustomizeBrandUtils", "number is null false");
        return "";
    }

    public static final boolean b(String number) {
        i.f(number, "number");
        C0846g.i("CustomizeBrandUtils", number);
        return false;
    }

    public static final boolean c(Context context) {
        i.f(context, "context");
        C0846g.i("CustomizeBrandUtils", "isTwRemoveNumberAttribution context = " + context);
        return false;
    }

    public static final boolean d() {
        return false;
    }

    public static final boolean e(Context context, String number) {
        boolean z10;
        i.f(number, "number");
        if (context == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        C0846g.i("CustomizeBrandUtils", "context is null " + z10 + "number is null false");
        return false;
    }
}
