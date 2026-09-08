package D7;

import android.content.Context;
import android.telephony.PhoneStateListener;
import java.util.List;
import kotlin.collections.C1229j;
import kotlin.jvm.internal.i;
import y5.C1706a;

/* compiled from: AddonTelephonyManager.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f464a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static C1706a f465b = C1706a.a(P7.a.f2961a.a());

    public static final String a(Integer num) {
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        C1706a c1706a = f465b;
        if (c1706a == null) {
            return null;
        }
        return c1706a.b(intValue);
    }

    public static final String b(Integer num) {
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        C1706a c1706a = f465b;
        if (c1706a == null) {
            return null;
        }
        return c1706a.c(intValue);
    }

    public static final int c(Integer num) {
        Integer num2;
        if (num != null) {
            int intValue = num.intValue();
            C1706a c1706a = f465b;
            if (c1706a != null) {
                num2 = Integer.valueOf(c1706a.d(intValue));
            } else {
                num2 = null;
            }
            if (num2 != null) {
                return num2.intValue();
            }
        }
        return 0;
    }

    public static final String d(Integer num) {
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        C1706a c1706a = f465b;
        if (c1706a == null) {
            return null;
        }
        return c1706a.e(intValue);
    }

    public static final String e(Integer num) {
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        C1706a c1706a = f465b;
        if (c1706a == null) {
            return null;
        }
        return c1706a.f(intValue);
    }

    public static final boolean f(Integer num, String str) {
        Boolean bool;
        if (num != null) {
            int intValue = num.intValue();
            C1706a c1706a = f465b;
            if (c1706a != null) {
                bool = Boolean.valueOf(c1706a.g(intValue, str));
            } else {
                bool = null;
            }
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    public static final boolean g(Integer num) {
        Boolean bool;
        if (num != null) {
            int intValue = num.intValue();
            C1706a c1706a = f465b;
            if (c1706a != null) {
                bool = Boolean.valueOf(c1706a.h(intValue));
            } else {
                bool = null;
            }
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    public static final boolean h() {
        C1706a c1706a = f465b;
        if (c1706a != null) {
            return c1706a.i();
        }
        return false;
    }

    public static final boolean i(Integer num) {
        Boolean bool;
        if (num != null) {
            int intValue = num.intValue();
            C1706a c1706a = f465b;
            if (c1706a != null) {
                bool = Boolean.valueOf(c1706a.j(intValue));
            } else {
                bool = null;
            }
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    public static final boolean j() {
        Boolean bool;
        C1706a c1706a = f465b;
        if (c1706a != null) {
            bool = c1706a.k();
        } else {
            bool = null;
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static final boolean k() {
        C1706a c1706a = f465b;
        if (c1706a != null) {
            return c1706a.l();
        }
        return false;
    }

    public static final void l(Context context, PhoneStateListener phoneStateListener, Integer num, Integer num2) {
        List w10;
        C1706a c1706a;
        w10 = C1229j.w(new Object[]{num, num2});
        if (w10.size() == 2 && (c1706a = f465b) != null) {
            i.c(num);
            int intValue = num.intValue();
            i.c(num2);
            c1706a.m(context, phoneStateListener, intValue, num2.intValue());
        }
    }

    public static final int m() {
        C1706a c1706a = f465b;
        if (c1706a != null) {
            return c1706a.n();
        }
        return -1;
    }

    public static final boolean n(Integer num) {
        Boolean bool;
        if (num != null) {
            int intValue = num.intValue();
            C1706a c1706a = f465b;
            if (c1706a != null) {
                bool = Boolean.valueOf(c1706a.o(intValue));
            } else {
                bool = null;
            }
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    public static final boolean o(Context context, Integer num) {
        Boolean bool;
        if (num != null) {
            int intValue = num.intValue();
            C1706a c1706a = f465b;
            if (c1706a != null) {
                bool = Boolean.valueOf(c1706a.p(context, intValue));
            } else {
                bool = null;
            }
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    public static final int p(Context context) {
        return C1706a.q(context);
    }

    public static final int q(Context context, Integer num) {
        if (num != null) {
            return C1706a.r(context, num.intValue());
        }
        return -1;
    }

    public static final int r(Context context, Integer num) {
        if (num != null) {
            return C1706a.s(context, num.intValue());
        }
        return -1;
    }
}
