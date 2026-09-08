package M0;

import android.content.Context;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import com.android.contacts.framework.api.appstore.simcard.ISimCardApi;
import com.android.contacts.model.Account;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: SimCardApiImpl.kt */
/* loaded from: classes.dex */
public final class b implements ISimCardApi {

    /* renamed from: b, reason: collision with root package name */
    public static final a f1740b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final b f1741c = new b();

    /* compiled from: SimCardApiImpl.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final b a() {
            return b.f1741c;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @Override // com.android.contacts.framework.api.appstore.simcard.ISimCardApi
    public boolean a(Context context) {
        List<SubscriptionInfo> list;
        i.f(context, "context");
        if (androidx.core.content.b.a(context, "android.permission.READ_PHONE_STATE") != 0) {
            return false;
        }
        SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService(SubscriptionManager.class);
        if (subscriptionManager != null) {
            list = subscriptionManager.getActiveSubscriptionInfoList();
        } else {
            list = null;
        }
        if (list == null || list.size() <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.android.contacts.framework.api.appstore.simcard.ISimCardApi
    public boolean b(Context context) {
        i.f(context, "context");
        return M0.a.b(context);
    }

    @Override // com.android.contacts.framework.api.appstore.simcard.ISimCardApi
    public int c(Context context, String str) {
        int i10;
        i.f(context, "context");
        if (str == null) {
            return -1;
        }
        try {
            i10 = Integer.parseInt(str);
        } catch (NumberFormatException e10) {
            H7.b.c("SimCardApiImpl", "getSimCardSlotIdFromIMSI e:\u3000" + e10);
            i10 = -1;
        }
        if (i10 == -1) {
            return -1;
        }
        return SubscriptionManager.getSlotIndex(i10);
    }

    @Override // com.android.contacts.framework.api.appstore.simcard.ISimCardApi
    public String d(Context context, int i10) {
        SubscriptionInfo subscriptionInfo;
        i.f(context, "context");
        if (i10 > -1 && androidx.core.content.b.a(context, "android.permission.READ_PHONE_STATE") == 0) {
            SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService(SubscriptionManager.class);
            if (subscriptionManager != null) {
                subscriptionInfo = subscriptionManager.getActiveSubscriptionInfoForSimSlotIndex(i10);
            } else {
                subscriptionInfo = null;
            }
            if (subscriptionInfo != null) {
                return String.valueOf(subscriptionInfo.getSubscriptionId());
            }
        }
        return null;
    }

    @Override // com.android.contacts.framework.api.appstore.simcard.ISimCardApi
    public ArrayList<Account> e(Context context) {
        List<SubscriptionInfo> list;
        i.f(context, "context");
        if (androidx.core.content.b.a(context, "android.permission.READ_PHONE_STATE") == 0) {
            ArrayList<Account> arrayList = new ArrayList<>();
            SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService(SubscriptionManager.class);
            if (subscriptionManager != null) {
                list = subscriptionManager.getActiveSubscriptionInfoList();
            } else {
                list = null;
            }
            if (list != null) {
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    arrayList.add(new Account(String.valueOf(list.get(i10).getSubscriptionId()), "com.oplus.contacts.sim"));
                }
                return arrayList;
            }
        }
        return null;
    }

    @Override // com.android.contacts.framework.api.appstore.simcard.ISimCardApi
    public boolean f(Context context, int i10) {
        SubscriptionInfo subscriptionInfo;
        i.f(context, "context");
        if (i10 > -1 && androidx.core.content.b.a(context, "android.permission.READ_PHONE_STATE") == 0) {
            SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService(SubscriptionManager.class);
            if (subscriptionManager != null) {
                subscriptionInfo = subscriptionManager.getActiveSubscriptionInfoForSimSlotIndex(i10);
            } else {
                subscriptionInfo = null;
            }
            if (subscriptionInfo != null) {
                return true;
            }
            return false;
        }
        return false;
    }
}
