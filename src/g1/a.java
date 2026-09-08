package G1;

import A2.A;
import H1.c;
import H1.e;
import H1.f;
import android.content.Context;
import android.telephony.PhoneNumberUtils;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusInCallApp;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.internal_dependency.InternalSdkDepends;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import kotlin.text.Regex;

/* compiled from: CallInfoConverter.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1088a = new a();

    public final c a(Call call) {
        ContactInfoCache.ContactCacheEntry contactInfo;
        if (call != null && (contactInfo = call.getContactInfo()) != null) {
            return new c(contactInfo.person_id, contactInfo.name, contactInfo.photo, contactInfo.company, ContactInfoCache.ContactType.isVipContact(contactInfo.contactType));
        }
        return null;
    }

    public final e b(Call call) {
        ContactInfoCache.ContactCacheEntry contactInfo;
        String str;
        if (call == null || (contactInfo = call.getContactInfo()) == null || !contactInfo.isShowFdnName || (str = contactInfo.fdnName) == null || str.length() == 0) {
            return null;
        }
        return new e(contactInfo.fdnName);
    }

    public final f c(Call call) {
        ContactInfoCache.ContactCacheEntry contactCacheEntry;
        A a10;
        String str;
        String str2;
        String str3;
        Pair pair = null;
        if (call != null) {
            contactCacheEntry = call.getContactInfo();
        } else {
            contactCacheEntry = null;
        }
        if (contactCacheEntry == null || (a10 = contactCacheEntry.yellowPageInfo) == null) {
            return null;
        }
        if (D2.b.t(contactCacheEntry, call.getNumber(), OplusInCallApp.getAppContext())) {
            str = contactCacheEntry.yellowPageInfo.f95c;
        } else {
            str = null;
        }
        if (contactCacheEntry.isWhiteListNumber) {
            str2 = null;
        } else {
            str2 = a10.f96d;
        }
        String str4 = a10.f97e;
        if ((str4 != null && str4.length() != 0) || ((str3 = a10.f98f) != null && str3.length() != 0)) {
            pair = new Pair(a10.f97e, a10.f98f);
        }
        return new f(a10.f101i, str, pair, str2);
    }

    public final H1.a d(Call call) {
        boolean z10;
        String str = null;
        if (call == null) {
            return null;
        }
        Context appContext = OplusInCallApp.getAppContext();
        String number = call.getNumber();
        String str2 = call.getContactInfo().number;
        if (str2 == null) {
            str2 = call.getNumber();
        }
        String e10 = e(str2);
        ContactInfoCache.ContactCacheEntry contactInfo = call.getContactInfo();
        if (contactInfo != null) {
            str = contactInfo.location;
        }
        if (!OplusPhoneUtils.needShowLocation(appContext) || i.b(str, appContext.getString(R.string.unknown)) || i.b(str, appContext.getString(R.string.oplusUnknown))) {
            str = "";
        }
        String str3 = str;
        c a10 = a(call);
        f c10 = c(call);
        boolean isCdmaPhoneActive = CallList.getInstance().oplusCallList().isCdmaPhoneActive();
        boolean isEmergencyCall = call.isEmergencyCall();
        e b10 = b(call);
        String id = call.getId();
        int slotId = call.getSlotId();
        boolean g10 = g(number, str3);
        ContactInfoCache.ContactCacheEntry contactInfo2 = call.getContactInfo();
        if (contactInfo2 != null) {
            z10 = contactInfo2.isVoiceMail;
        } else {
            z10 = false;
        }
        H1.a aVar = new H1.a(id, number, e10, str3, slotId, a10, c10, b10, isCdmaPhoneActive, isEmergencyCall, false, z10, g10, false, 9216, null);
        f(aVar);
        String b11 = aVar.b();
        if (b11 != null && b11.length() != 0) {
            aVar.l((char) 8206 + aVar.b());
        }
        return aVar;
    }

    public final String e(String str) {
        if (str != null && str.length() != 0) {
            return PhoneNumberUtils.formatNumber(new Regex("-").b(new Regex(" ").b(str, ""), ""), null, InternalSdkDepends.Companion.getSInstance().getCurrentCountryIso(OplusInCallApp.getAppContext()));
        }
        return str;
    }

    public final void f(H1.a aVar) {
        String str;
        if (aVar != null) {
            Context appContext = OplusInCallApp.getAppContext();
            int numberHideSettings = OplusPhoneUtils.getNumberHideSettings(appContext);
            if (numberHideSettings != 0) {
                c a10 = aVar.a();
                String str2 = null;
                if (a10 != null) {
                    c a11 = aVar.a();
                    if (a11 != null) {
                        str = a11.b();
                    } else {
                        str = null;
                    }
                    a10.c(OplusPhoneUtils.getHidedNumberInName(str, numberHideSettings, appContext));
                }
                f f10 = aVar.f();
                if (f10 != null) {
                    f10.e(OplusPhoneUtils.getHidedNumberInName(f10.c(), numberHideSettings, appContext));
                    Pair<String, String> b10 = f10.b();
                    if (b10 != null) {
                        new Pair(OplusPhoneUtils.getHidedNumberInName(b10.c(), numberHideSettings, appContext), b10.d());
                    }
                    f10.d(OplusPhoneUtils.getHidedNumberInName(f10.a(), numberHideSettings, appContext));
                }
                e c10 = aVar.c();
                if (c10 != null) {
                    e c11 = aVar.c();
                    if (c11 != null) {
                        str2 = c11.a();
                    }
                    c10.b(OplusPhoneUtils.getHidedNumberInName(str2, numberHideSettings, appContext));
                }
            }
            aVar.l(OplusPhoneUtils.getNumberMaskedStr(aVar.b(), numberHideSettings));
        }
    }

    public final boolean g(String str, String str2) {
        if (!OplusFeatureOption.OPLUS_CMCC_TEST && str2 != null && str2.length() != 0 && D2.f.y(str)) {
            return true;
        }
        return false;
    }
}
