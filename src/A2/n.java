package A2;

import A2.k;
import android.text.TextUtils;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.Log;

/* compiled from: OplusInterceptQuery.java */
/* loaded from: classes.dex */
public class n implements k.b {
    public static boolean a(ContactInfoCache.ContactCacheEntry contactCacheEntry) {
        boolean z10;
        if (b(contactCacheEntry) && contactCacheEntry.lastCallTime == 0 && contactCacheEntry.callLogQueryState == 5) {
            z10 = true;
        } else {
            z10 = false;
        }
        c("isStrangerFirstIncomingCall = " + z10);
        return z10;
    }

    public static boolean b(ContactInfoCache.ContactCacheEntry contactCacheEntry) {
        boolean z10;
        if (d(contactCacheEntry) && TextUtils.isEmpty(contactCacheEntry.name) && TextUtils.isEmpty(contactCacheEntry.yellowPageInfo.f95c) && contactCacheEntry.yellowPageInfo.f99g <= 0 && !D2.f.y(contactCacheEntry.number)) {
            z10 = true;
        } else {
            z10 = false;
        }
        c("isStrangerIncomingCall = " + z10);
        return z10;
    }

    public static void c(String str) {
        if (Log.sDebug) {
            Log.d("OplusInterceptQuery", str);
        }
    }

    public static boolean d(ContactInfoCache.ContactCacheEntry contactCacheEntry) {
        boolean z10;
        int i10 = contactCacheEntry.contactQueryState;
        boolean z11 = true;
        if (i10 != 2 && i10 != 3) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!TextUtils.isEmpty(contactCacheEntry.number)) {
            z11 = z10;
        }
        c("queryContactsComplete   complete = " + z11);
        return z11;
    }
}
