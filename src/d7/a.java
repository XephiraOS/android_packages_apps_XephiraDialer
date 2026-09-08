package D7;

import android.content.Context;
import android.os.OplusBaseEnvironment;
import java.io.File;
import java.util.List;
import kotlin.collections.C1229j;
import kotlin.jvm.internal.i;
import u5.C1609a;
import w5.C1651a;
import z5.C1734a;

/* compiled from: AddonAdapterHelper.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f462a = new a();

    public static final void a(String str, List<String> list) {
        new com.heytap.addon.app.a().a(str, list);
    }

    public static final int[] b(Integer num, Integer num2, Integer num3) {
        List w10;
        w10 = C1229j.w(new Object[]{num, num2, num3});
        if (w10.size() == 3) {
            i.c(num);
            int intValue = num.intValue();
            i.c(num2);
            int intValue2 = num2.intValue();
            i.c(num3);
            return C1734a.a(intValue, intValue2, num3.intValue());
        }
        return null;
    }

    public static final b c(Context context) {
        return new b(context);
    }

    public static final int d() {
        return B5.a.f259a;
    }

    public static final int e(Integer num) {
        if (num != null) {
            return C1734a.b(num.intValue());
        }
        return 0;
    }

    public static final int f(Integer num, Integer num2) {
        List w10;
        Integer num3;
        w10 = C1229j.w(new Object[]{num, num2});
        if (w10.size() == 2) {
            i.c(num);
            int intValue = num.intValue();
            i.c(num2);
            num3 = Integer.valueOf(C1734a.c(intValue, num2.intValue()));
        } else {
            num3 = null;
        }
        if (num3 != null) {
            return num3.intValue();
        }
        return 0;
    }

    public static final int g(Context context) {
        return C1651a.c(context).a();
    }

    public static final int h(Context context) {
        return C1651a.c(context).b();
    }

    public static final String i(Context context) {
        return com.heytap.addon.os.c.a(context);
    }

    public static final String j(Context context) {
        return com.heytap.addon.os.c.b(context);
    }

    public static final File k() {
        return OplusBaseEnvironment.getMyCompanyDirectory();
    }

    public static final int l() {
        return com.heytap.addon.os.b.a();
    }

    public static final boolean m(Context context, String str) {
        return C1609a.a(context).b(str);
    }

    public static final boolean n(Context context) {
        return C1651a.c(context).d();
    }

    public static final int[] o(Integer num, Integer num2, Integer num3) {
        List w10;
        w10 = C1229j.w(new Object[]{num, num2, num3});
        if (w10.size() == 3) {
            i.c(num);
            int intValue = num.intValue();
            i.c(num2);
            int intValue2 = num2.intValue();
            i.c(num3);
            return C1734a.d(intValue, intValue2, num3.intValue());
        }
        return null;
    }

    public static final int p() {
        return y5.b.f38149a;
    }

    public static final int q() {
        return y5.b.f38150b;
    }

    public static final String r() {
        String SUBSCRIPTION_KEY = y5.b.f38151c;
        i.e(SUBSCRIPTION_KEY, "SUBSCRIPTION_KEY");
        return SUBSCRIPTION_KEY;
    }
}
