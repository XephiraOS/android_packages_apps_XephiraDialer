package C7;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: IntentUtils.java */
/* loaded from: classes3.dex */
public class e {
    public static boolean a(Intent intent, Intent intent2) {
        if (intent == intent2) {
            return true;
        }
        if (intent != null && intent2 != null) {
            return TextUtils.equals(intent.getAction(), intent2.getAction());
        }
        return false;
    }

    public static void b(Activity activity) {
        if (activity != null) {
            try {
                activity.finish();
            } catch (Throwable th) {
                H7.b.c("IntentUtils", th.toString());
            }
        }
    }

    public static boolean c(Intent intent, String str, boolean z10) {
        if (intent == null) {
            return z10;
        }
        try {
            return intent.getBooleanExtra(str, z10);
        } catch (Exception e10) {
            H7.b.c("IntentUtils", e10.toString());
            return z10;
        }
    }

    public static int d(Intent intent, String str, int i10) {
        if (intent == null) {
            return i10;
        }
        try {
            return intent.getIntExtra(str, i10);
        } catch (Exception e10) {
            H7.b.c("IntentUtils", e10.toString());
            return i10;
        }
    }

    public static long[] e(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        try {
            return intent.getLongArrayExtra(str);
        } catch (Exception e10) {
            H7.b.c("IntentUtils", e10.toString());
            return null;
        }
    }

    public static long f(Intent intent, String str, long j10) {
        if (intent == null) {
            return j10;
        }
        try {
            return intent.getLongExtra(str, j10);
        } catch (Exception e10) {
            H7.b.c("IntentUtils", e10.toString());
            return j10;
        }
    }

    public static String g() {
        return P7.a.f2962b.getPackageName();
    }

    public static Parcelable[] h(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        try {
            return intent.getParcelableArrayExtra(str);
        } catch (Exception e10) {
            H7.b.c("IntentUtils", e10.toString());
            return null;
        }
    }

    public static <T extends Parcelable> ArrayList<T> i(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        try {
            return intent.getParcelableArrayListExtra(str);
        } catch (Exception e10) {
            H7.b.c("IntentUtils", e10.toString());
            return null;
        }
    }

    public static <T extends Parcelable> T j(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        try {
            return (T) intent.getParcelableExtra(str);
        } catch (Exception e10) {
            H7.b.c("IntentUtils", e10.toString());
            return null;
        }
    }

    public static ArrayList<String> k(Intent intent, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (intent == null) {
            return arrayList;
        }
        try {
            return intent.getStringArrayListExtra(str);
        } catch (Exception e10) {
            H7.b.c("IntentUtils", e10.toString());
            return arrayList;
        }
    }

    public static String l(Intent intent, String str) {
        if (intent == null) {
            return "";
        }
        try {
            return intent.getStringExtra(str);
        } catch (Exception e10) {
            H7.b.c("IntentUtils", e10.toString());
            return "";
        }
    }

    public static void m(Intent intent, String str, boolean z10) {
        if (intent != null) {
            try {
                intent.putExtra(str, z10);
            } catch (Throwable th) {
                H7.b.c("IntentUtils", th.toString());
            }
        }
    }

    public static void n(Intent intent, String str, Intent intent2) {
        if (intent != null) {
            try {
                intent.putExtra(str, intent2);
            } catch (Throwable th) {
                H7.b.c("IntentUtils", th.toString());
            }
        }
    }
}
