package com.oplus.utils;

import android.content.Context;
import android.util.Log;

/* compiled from: OplusCustomizeContactManagerUtils.kt */
/* loaded from: classes3.dex */
public final class G {

    /* renamed from: a, reason: collision with root package name */
    public static final G f29042a = new G();

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f29043b = true;

    /* renamed from: c, reason: collision with root package name */
    public static int f29044c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static int f29045d = -1;

    /* renamed from: e, reason: collision with root package name */
    public static int f29046e = -1;

    public static final int a(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        if (f29043b) {
            try {
                int d10 = F6.b.f998a.d(context);
                if (d10 == -1) {
                    return 0;
                }
                return d10;
            } catch (Throwable th) {
                Log.e("OplusCustomizeContactManagerUtils", "getContactBlockPattern() t: " + th);
                return 0;
            }
        }
        try {
            return z6.b.c(context, 2, C0855p.f29168c, 0);
        } catch (Exception e10) {
            Log.e("OplusCustomizeContactManagerUtils", "getContactBlockPattern() e: " + e10);
            return 0;
        }
    }

    public static final int b(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        if (f29043b) {
            try {
                int e10 = F6.b.f998a.e(context);
                if (e10 == -1) {
                    return 0;
                }
                return e10;
            } catch (Throwable th) {
                Log.e("OplusCustomizeContactManagerUtils", "getContactMatchPattern() t: " + th);
                return 0;
            }
        }
        try {
            return z6.b.c(context, 2, C0855p.f29169d, 0);
        } catch (Exception e11) {
            Log.e("OplusCustomizeContactManagerUtils", "getContactMatchPattern() e: " + e11);
            return 0;
        }
    }

    public static final int c(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        int i10 = 1;
        if (f29043b) {
            if (f29046e == -1) {
                try {
                    int f10 = F6.b.f998a.f(context);
                    if (f10 != -1) {
                        i10 = f10;
                    }
                } catch (Throwable th) {
                    Log.e("OplusCustomizeContactManagerUtils", "getContactNumberHideMode() t: " + th);
                }
                f29046e = i10;
            }
            return f29046e;
        }
        try {
            i10 = z6.b.c(context, 2, C0856q.f29182c, 1);
        } catch (Exception e10) {
            Log.e("OplusCustomizeContactManagerUtils", "getContactNumberHideMode e: " + e10);
        }
        return i10;
    }

    public static final boolean d(Context context) {
        int i10;
        int g10;
        kotlin.jvm.internal.i.f(context, "context");
        if (f29043b) {
            if (f29044c == -1) {
                try {
                    g10 = F6.b.f998a.g(context);
                } catch (Throwable th) {
                    Log.e("OplusCustomizeContactManagerUtils", "getContactNumberMaskEnable() t: " + th);
                }
                if (g10 == 2 || g10 == 1) {
                    i10 = 1;
                    f29044c = i10;
                }
                i10 = 0;
                f29044c = i10;
            }
            if (f29044c != 1) {
                return false;
            }
            return true;
        }
        return l7.b.f34751s;
    }

    public static final boolean e(Context context) {
        int i10;
        kotlin.jvm.internal.i.f(context, "context");
        if (f29043b) {
            if (f29045d == -1) {
                try {
                } catch (Throwable th) {
                    Log.e("OplusCustomizeContactManagerUtils", "getContactNumberMaskSwitch() t: " + th);
                }
                if (F6.b.f998a.g(context) == 1) {
                    i10 = 1;
                    f29045d = i10;
                }
                i10 = 0;
                f29045d = i10;
            }
            if (f29045d != 1) {
                return false;
            }
        } else {
            try {
                if (z6.b.c(context, 2, C0856q.f29181b, 0) != 1) {
                    return false;
                }
            } catch (Exception e10) {
                Log.e("OplusCustomizeContactManagerUtils", "getContactNumberMaskSwitch() e: " + e10);
                return false;
            }
        }
        return true;
    }

    public static final int f(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        if (f29043b) {
            try {
                int h10 = F6.b.f998a.h(context);
                if (h10 == -1) {
                    return 2;
                }
                return h10;
            } catch (Throwable th) {
                Log.e("OplusCustomizeContactManagerUtils", "getContactOutgoOrIncomePattern() t: " + th);
                return 2;
            }
        }
        try {
            return z6.b.c(context, 2, C0855p.f29170e, 2);
        } catch (Exception e10) {
            Log.e("OplusCustomizeContactManagerUtils", "getContactOutgoOrIncomePattern() e: " + e10);
            return 2;
        }
    }

    public static final boolean g(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        if (f29043b) {
            try {
                return F6.b.f998a.j(context);
            } catch (Throwable th) {
                Log.e("OplusCustomizeContactManagerUtils", "isContactBlackListEnable() t: " + th);
                return false;
            }
        }
        return l7.b.f34752t;
    }

    public final void h() {
        f29044c = -1;
        f29045d = -1;
        f29046e = -1;
    }
}
