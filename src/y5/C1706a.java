package y5;

import android.content.Context;
import android.telephony.ColorOSTelephonyManager;
import android.telephony.OplusOSTelephonyManager;
import android.telephony.PhoneStateListener;

/* compiled from: OplusOSTelephonyManager.java */
/* renamed from: y5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1706a {

    /* renamed from: a, reason: collision with root package name */
    public OplusOSTelephonyManager f38147a;

    /* renamed from: b, reason: collision with root package name */
    public ColorOSTelephonyManager f38148b;

    public C1706a(OplusOSTelephonyManager oplusOSTelephonyManager) {
        this.f38147a = oplusOSTelephonyManager;
    }

    public static C1706a a(Context context) {
        if (A5.a.b()) {
            return new C1706a(OplusOSTelephonyManager.getDefault(context));
        }
        return new C1706a(ColorOSTelephonyManager.getDefault(context));
    }

    public static int q(Context context) {
        if (A5.a.b()) {
            return OplusOSTelephonyManager.oplusgetDefaultDataPhoneId(context);
        }
        return ColorOSTelephonyManager.colorgetDefaultDataPhoneId(context);
    }

    public static int r(Context context, int i10) {
        if (A5.a.b()) {
            return OplusOSTelephonyManager.oplusgetSlotId(context, i10);
        }
        return ColorOSTelephonyManager.colorgetSlotId(context, i10);
    }

    public static int s(Context context, int i10) {
        if (A5.a.b()) {
            return OplusOSTelephonyManager.oplusgetSubId(context, i10);
        }
        return ColorOSTelephonyManager.colorgetSubId(context, i10);
    }

    public String b(int i10) {
        if (A5.a.b()) {
            return this.f38147a.getIccCardTypeGemini(i10);
        }
        return this.f38148b.getIccCardTypeGemini(i10);
    }

    public String c(int i10) {
        if (A5.a.b()) {
            return this.f38147a.getLine1NumberGemini(i10);
        }
        return this.f38148b.getLine1NumberGemini(i10);
    }

    public int d(int i10) {
        if (A5.a.b()) {
            return this.f38147a.getSimStateGemini(i10);
        }
        return this.f38148b.getSimStateGemini(i10);
    }

    public String e(int i10) {
        if (A5.a.b()) {
            return this.f38147a.getSubscriberIdGemini(i10);
        }
        return this.f38148b.getSubscriberIdGemini(i10);
    }

    public String f(int i10) {
        if (A5.a.b()) {
            return this.f38147a.getVoiceMailNumberGemini(i10);
        }
        return this.f38148b.getVoiceMailNumberGemini(i10);
    }

    public boolean g(int i10, String str) {
        if (A5.a.b()) {
            return this.f38147a.handlePinMmiForSubscriber(i10, str);
        }
        return this.f38148b.handlePinMmiForSubscriber(i10, str);
    }

    public boolean h(int i10) {
        if (A5.a.b()) {
            return this.f38147a.hasIccCardGemini(i10);
        }
        return this.f38148b.hasIccCardGemini(i10);
    }

    public boolean i() {
        if (A5.a.b()) {
            return this.f38147a.isDualLteSupportedByPlatform();
        }
        return this.f38148b.isDualLteSupportedByPlatform();
    }

    public boolean j(int i10) {
        if (A5.a.b()) {
            return this.f38147a.isNetworkRoamingGemini(i10);
        }
        return this.f38148b.isNetworkRoamingGemini(i10);
    }

    public Boolean k() {
        if (A5.a.b()) {
            return Boolean.valueOf(this.f38147a.isOplusHasSoftSimCard());
        }
        return Boolean.valueOf(this.f38148b.isColorHasSoftSimCard());
    }

    public boolean l() {
        if (A5.a.b()) {
            return this.f38147a.isOplusSingleSimCard();
        }
        return this.f38148b.isOppoSingleSimCard();
    }

    public void m(Context context, PhoneStateListener phoneStateListener, int i10, int i11) {
        if (A5.a.b()) {
            this.f38147a.listenGemini(context, phoneStateListener, i10, i11);
        } else {
            this.f38148b.listenGemini(context, phoneStateListener, i10, i11);
        }
    }

    public int n() {
        if (A5.a.b()) {
            return this.f38147a.oplusGetSoftSimCardSlotId();
        }
        return this.f38148b.colorGetSoftSimCardSlotId();
    }

    public boolean o(int i10) {
        if (A5.a.b()) {
            return this.f38147a.oplusIsQcomSubActive(i10);
        }
        return this.f38148b.colorIsQcomSubActive(i10);
    }

    public boolean p(Context context, int i10) {
        if (A5.a.b()) {
            return this.f38147a.oplusIsVtEnabledByPlatform(context, i10);
        }
        return this.f38148b.colorIsVtEnabledByPlatform(context, i10);
    }

    public C1706a(ColorOSTelephonyManager colorOSTelephonyManager) {
        this.f38148b = colorOSTelephonyManager;
    }
}
