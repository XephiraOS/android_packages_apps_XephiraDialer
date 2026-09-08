package p2;

import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.os.RemoteException;
import android.provider.Settings;
import com.android.incallui.Log;
import com.android.incallui.R;
import com.internal_dependency.AddOnSdkDepends;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.t;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: FloatingWindowUtils.kt */
/* renamed from: p2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1430a {

    /* renamed from: a, reason: collision with root package name */
    public static final C1430a f35990a = new C1430a();

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList<String> f35991b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList<String> f35992c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public static final AddOnSdkDepends f35993d = AddOnSdkDepends.Companion.getSInstance();

    public static final String[] a(Context context, String str) {
        List Y9;
        if (context == null) {
            return null;
        }
        String appListString = Settings.Global.getString(context.getContentResolver(), str);
        if (Log.sDebug) {
            Log.d("FloatingWindowUtils", "appListString = " + appListString);
        }
        if (appListString == null || appListString.length() == 0) {
            return null;
        }
        try {
            i.e(appListString, "appListString");
            Y9 = StringsKt__StringsKt.Y(appListString, new String[]{"#"}, false, 0, 6, null);
            Object[] array = Y9.toArray(new String[0]);
            String[] strArr = (String[]) array;
            if (Log.sDebug) {
                for (String str2 : strArr) {
                    Log.d("FloatingWindowUtils", "string = " + str2);
                }
            }
            return (String[]) array;
        } catch (Exception e10) {
            Log.d("FloatingWindowUtils", "Exception: " + e10);
            Log.e("FloatingWindowUtils", "getNavigationAppListFromSettings error ");
            return null;
        }
    }

    public static final ComponentName b() {
        return f35993d.getTopActivityComponentName();
    }

    public static final int c(ComponentName componentName) {
        String className;
        if (componentName != null && (className = componentName.getClassName()) != null && className.length() != 0) {
            if (f35991b.contains(className)) {
                if (Log.sDebug) {
                    Log.d("FloatingWindowUtils", "Top activity can not display floating window ");
                    return 3;
                }
                return 3;
            }
            if (f35992c.contains(className)) {
                if (Log.sDebug) {
                    Log.d("FloatingWindowUtils", "Top activity display full screen after answered ");
                    return 4;
                }
                return 4;
            }
            AddOnSdkDepends addOnSdkDepends = f35993d;
            String packageName = componentName.getPackageName();
            i.e(packageName, "topComponentName.packageName");
            if (addOnSdkDepends.isNavigating(packageName)) {
                if (Log.sDebug) {
                    Log.d("FloatingWindowUtils", "Top activity is navigation");
                    return 2;
                }
                return 2;
            }
        }
        return 0;
    }

    public static final void d(Context context, int i10, ArrayList<String> arrayList, String str) {
        String[] strArr;
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            strArr = resources.getStringArray(i10);
        } else {
            strArr = null;
        }
        if (strArr == null) {
            return;
        }
        arrayList.clear();
        for (String str2 : strArr) {
            arrayList.add(str2.toString());
        }
        if (Log.sDebug) {
            Log.d("FloatingWindowUtils", "initDefaultList for " + str + ": " + arrayList);
        }
    }

    public static final void e(Context context) {
        String[] a10 = a(context, "oplus_phone_full_screen_activity_list");
        if (a10 != null && a10.length != 0) {
            if (i.b("closed", a10[0])) {
                if (Log.sDebug) {
                    Log.d("FloatingWindowUtils", "init full screen activity list closed return false");
                }
                f35991b.clear();
                return;
            }
            ArrayList<String> arrayList = f35991b;
            t.s(arrayList, a10);
            if (Log.sDebug) {
                Log.d("FloatingWindowUtils", "init full screen activity list settings bRet = " + arrayList);
                return;
            }
            return;
        }
        d(context, R.array.show_full_screen_activity_list, f35991b, "FullScreen");
        d(context, R.array.answered_show_full_screen_activity_list, f35992c, "AnsweredFullScreen");
    }

    public static final boolean f(ComponentName componentName) {
        String str;
        if (componentName != null) {
            str = componentName.getClassName();
        } else {
            str = null;
        }
        return i.b("com.oplus.ocar.smartdrive.shell.DriveModeActivity", str);
    }

    public static final boolean g() {
        try {
            return f35993d.getTopIsFullscreen();
        } catch (RemoteException e10) {
            Log.w("FloatingWindowUtils", "isTopWindowFullScreen: getTopIsFullscreen throw exception = " + e10.getMessage());
            return false;
        }
    }
}
