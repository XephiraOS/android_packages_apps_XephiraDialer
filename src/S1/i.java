package s1;

import android.content.Context;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.util.Pair;
import com.google.common.base.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: TelecomUtil.java */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f36629a = false;

    /* renamed from: b, reason: collision with root package name */
    public static a f36630b = new a();

    /* renamed from: c, reason: collision with root package name */
    public static final Map<Pair<PhoneAccountHandle, String>, Boolean> f36631c = new ConcurrentHashMap();

    /* compiled from: TelecomUtil.java */
    /* loaded from: classes.dex */
    public static class a {
        public boolean a(Context context, String str) {
            if (context.checkSelfPermission(str) == 0) {
                return true;
            }
            return false;
        }

        public boolean b(Context context) {
            boolean equals = TextUtils.equals(context.getPackageName(), P7.d.a(context));
            if (equals) {
                i.f36629a = false;
            } else if (!i.f36629a) {
                C1.a.f("TelecomUtil", "Dialer is not currently set to be default dialer");
                i.f36629a = true;
            }
            return equals;
        }
    }

    public static List<PhoneAccountHandle> c(Context context) {
        if (h(context)) {
            return f(context).getCallCapablePhoneAccounts();
        }
        return new ArrayList();
    }

    public static PhoneAccount d(Context context, PhoneAccountHandle phoneAccountHandle) {
        return f(context).getPhoneAccount(phoneAccountHandle);
    }

    public static Optional<SubscriptionInfo> e(Context context, PhoneAccountHandle phoneAccountHandle) {
        if (TextUtils.isEmpty(phoneAccountHandle.getId())) {
            return Optional.a();
        }
        if (!g(context, "android.permission.READ_PHONE_STATE")) {
            return Optional.a();
        }
        List<SubscriptionInfo> activeSubscriptionInfoList = ((SubscriptionManager) context.getSystemService(SubscriptionManager.class)).getActiveSubscriptionInfoList();
        if (activeSubscriptionInfoList == null) {
            return Optional.a();
        }
        for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
            if (phoneAccountHandle.getId().startsWith(subscriptionInfo.getIccId())) {
                return Optional.d(subscriptionInfo);
            }
        }
        return Optional.a();
    }

    public static TelecomManager f(Context context) {
        return (TelecomManager) context.getSystemService("telecom");
    }

    public static boolean g(Context context, String str) {
        return f36630b.a(context, str);
    }

    public static boolean h(Context context) {
        if (!i(context) && !g(context, "android.permission.READ_PHONE_STATE")) {
            return false;
        }
        return true;
    }

    public static boolean i(Context context) {
        return f36630b.b(context);
    }
}
