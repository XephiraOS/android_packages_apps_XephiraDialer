package D2;

import android.text.TextUtils;
import com.android.incallui.Log;
import java.lang.reflect.InvocationTargetException;

/* compiled from: OplusLogUtils.java */
/* loaded from: classes.dex */
public class g {
    public static void a(String str, String str2) {
        Log.d(str, "ANSWERCALL: " + str2);
    }

    public static void b(String str, String str2) {
        Log.d(str, "HANGUPCALL: " + str2);
    }

    public static void c(String str, String str2) {
        Log.d(str, "REJECTCALL: " + str2);
    }

    public static void d(String str, String str2) {
        Log.d(str, "UPDATECALLCARD: " + str2);
    }

    public static void e(String str, String str2) {
        Log.d(str, "INCALL_QUERY: " + str2);
    }

    public static void f(String str, String str2) {
        Log.e(str, "HANGUPCALL: " + str2);
    }

    public static void g(String str, String str2) {
        android.util.Log.i(str, "ANSWERCALL: " + str2);
    }

    public static void h(String str, String str2) {
        android.util.Log.i(str, "MOCALL: MTCALL: " + str2);
    }

    public static void i(String str, String str2) {
        android.util.Log.i(str, "MTCALL: " + str2);
    }

    public static void j(String str, String str2) {
        android.util.Log.i(str, "REJECTCALL: " + str2);
    }

    public static void k(String str, String str2) {
        Log.i(str, "INCALL_QUERY: " + str2);
    }

    public static String l(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 2) {
            int length = str.length();
            StringBuilder sb = new StringBuilder();
            if (length > 7) {
                sb.append(str.substring(0, 3));
                sb.append("****");
                sb.append(str.substring(length - 4));
                return sb.toString();
            }
            if (length > 2) {
                sb.append(str.substring(0, 1));
                sb.append("****");
                sb.append(str.substring(length - 1));
                return sb.toString();
            }
            sb.append(str.substring(0, 1));
            sb.append("*");
            return sb.toString();
        }
        return str;
    }

    public static void m(String str, String str2) {
        try {
            Class.forName("android.util.Log").getMethod("p", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e10) {
            Log.i("PLACE_CALL: ", "logP: ClassNotFoundException: " + e10.getMessage());
        } catch (IllegalAccessException e11) {
            Log.i("PLACE_CALL: ", "logP: IllegalAccessException: " + e11.getMessage());
        } catch (NoSuchMethodException e12) {
            Log.i("PLACE_CALL: ", "logP: NoSuchMethodException: " + e12.getMessage());
        } catch (InvocationTargetException e13) {
            Log.i("PLACE_CALL: ", "logP: InvocationTargetException: " + e13.getMessage());
        } catch (Exception e14) {
            Log.i("PLACE_CALL: ", "logP: Exception: " + e14.getMessage());
        }
    }

    public static void n() {
        m("HM_APP_GAP", "contacts.place_call end");
    }

    public static String o(Object obj) {
        if (obj == null) {
            return String.valueOf(obj);
        }
        return "***";
    }
}
