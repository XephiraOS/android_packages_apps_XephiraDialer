package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: ActivityCompat.java */
/* loaded from: classes.dex */
public class a extends androidx.core.content.b {

    /* compiled from: ActivityCompat.java */
    /* renamed from: androidx.core.app.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0107a {
        public static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        public static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        public static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        public static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        public static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    /* compiled from: ActivityCompat.java */
    /* loaded from: classes.dex */
    public static class b {
        public static Uri a(Activity activity) {
            return activity.getReferrer();
        }
    }

    /* compiled from: ActivityCompat.java */
    /* loaded from: classes.dex */
    public static class c {
        public static void a(Activity activity, String[] strArr, int i10) {
            activity.requestPermissions(strArr, i10);
        }
    }

    /* compiled from: ActivityCompat.java */
    /* loaded from: classes.dex */
    public static class d {
        public static boolean a(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* compiled from: ActivityCompat.java */
    /* loaded from: classes.dex */
    public interface e {
        void validateRequestPermissionsRequestCode(int i10);
    }

    public static void l(Activity activity) {
        activity.finishAffinity();
    }

    public static void m(Activity activity) {
        C0107a.a(activity);
    }

    public static Uri n(Activity activity) {
        return b.a(activity);
    }

    public static void o(Activity activity) {
        C0107a.b(activity);
    }

    public static void p(Activity activity) {
        activity.recreate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void q(Activity activity, String[] strArr, int i10) {
        String[] strArr2;
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
        }
        int size = hashSet.size();
        if (size > 0) {
            strArr2 = new String[strArr.length - size];
        } else {
            strArr2 = strArr;
        }
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < strArr.length; i12++) {
                if (!hashSet.contains(Integer.valueOf(i12))) {
                    strArr2[i11] = strArr[i12];
                    i11++;
                }
            }
        }
        if (activity instanceof e) {
            ((e) activity).validateRequestPermissionsRequestCode(i10);
        }
        c.a(activity, strArr, i10);
    }

    public static void r(Activity activity, m mVar) {
        C0107a.c(activity, null);
    }

    public static void s(Activity activity, m mVar) {
        C0107a.d(activity, null);
    }

    public static boolean t(Activity activity, String str) {
        return d.a(activity, str);
    }

    public static void u(Activity activity, Intent intent, int i10, Bundle bundle) {
        activity.startActivityForResult(intent, i10, bundle);
    }

    public static void v(Activity activity, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        activity.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    public static void w(Activity activity) {
        C0107a.e(activity);
    }
}
