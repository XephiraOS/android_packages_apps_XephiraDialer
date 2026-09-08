package com.android.contacts.voicemail.impl;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.telecom.PhoneAccountHandle;
import android.telephony.CarrierConfigManager;
import android.telephony.TelephonyManager;
import android.telephony.VisualVoicemailSmsFilterSettings;
import android.text.TextUtils;
import android.util.ArraySet;
import com.android.contacts.voicemail.impl.c;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import t1.C1580a;
import t1.d;
import t1.e;
import w0.C1643c;
import z1.AbstractC1729d;

/* compiled from: OmtpVvmCarrierConfigHelper.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f18027a;

    /* renamed from: b, reason: collision with root package name */
    public final PersistableBundle f18028b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18029c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC1729d f18030d;

    /* renamed from: e, reason: collision with root package name */
    public final PersistableBundle f18031e;

    /* renamed from: f, reason: collision with root package name */
    public final PersistableBundle f18032f;

    /* renamed from: g, reason: collision with root package name */
    public PhoneAccountHandle f18033g;

    public b(Context context, PhoneAccountHandle phoneAccountHandle) {
        TelephonyManager telephonyManager;
        this.f18027a = context;
        this.f18033g = phoneAccountHandle;
        try {
            telephonyManager = ((TelephonyManager) context.getSystemService(TelephonyManager.class)).createForPhoneAccountHandle(this.f18033g);
        } catch (Exception e10) {
            H7.b.c("OmtpVvmCarrierCfgHlpr", e10.toString());
            telephonyManager = null;
        }
        if (telephonyManager == null) {
            H7.b.c("OmtpVvmCarrierCfgHlpr", "PhoneAccountHandle is invalid");
            this.f18028b = null;
            this.f18031e = null;
            this.f18032f = null;
            this.f18029c = null;
            this.f18030d = null;
            return;
        }
        this.f18028b = c(telephonyManager);
        this.f18031e = new e(context).a(telephonyManager.getSimOperator());
        String q10 = q();
        this.f18029c = q10;
        this.f18030d = z1.e.a(this.f18027a.getResources(), q10);
        this.f18032f = null;
    }

    public static Set<String> e(PersistableBundle persistableBundle) {
        String[] stringArray;
        if (persistableBundle == null) {
            return null;
        }
        ArraySet arraySet = new ArraySet();
        if (persistableBundle.containsKey("carrier_vvm_package_name_string")) {
            arraySet.add(persistableBundle.getString("carrier_vvm_package_name_string"));
        }
        if (persistableBundle.containsKey("carrier_vvm_package_name_string_array") && (stringArray = persistableBundle.getStringArray("carrier_vvm_package_name_string_array")) != null && stringArray.length > 0) {
            Collections.addAll(arraySet, stringArray);
        }
        if (arraySet.isEmpty()) {
            return null;
        }
        return arraySet;
    }

    public static Set<String> j(PersistableBundle persistableBundle) {
        String[] stringArray;
        if (persistableBundle == null || !persistableBundle.containsKey("vvm_disabled_capabilities_string_array") || (stringArray = persistableBundle.getStringArray("vvm_disabled_capabilities_string_array")) == null || stringArray.length <= 0) {
            return null;
        }
        ArraySet arraySet = new ArraySet();
        Collections.addAll(arraySet, stringArray);
        return arraySet;
    }

    public void A(ActivationTask activationTask, PhoneAccountHandle phoneAccountHandle, c.b bVar, A1.e eVar, Bundle bundle) {
        this.f18030d.g(activationTask, phoneAccountHandle, this, bVar, eVar, bundle);
    }

    public boolean B() {
        return this.f18030d.h();
    }

    public void a() {
        C1.a.a("OmtpVvmCarrierCfgHlpr", "activateSmsFilter");
        d.b(this.f18027a, k(), new VisualVoicemailSmsFilterSettings.Builder().setClientPrefix(f()).build());
    }

    public int b() {
        return ((Integer) p("vvm_port_number_int", 0)).intValue();
    }

    public final PersistableBundle c(TelephonyManager telephonyManager) {
        if (((CarrierConfigManager) this.f18027a.getSystemService("carrier_config")) == null) {
            H7.b.i("OmtpVvmCarrierCfgHlpr", "No carrier config service found.");
            return null;
        }
        PersistableBundle carrierConfig = telephonyManager.getCarrierConfig();
        if (carrierConfig == null) {
            return null;
        }
        if (TextUtils.isEmpty(carrierConfig.getString("vvm_type_string"))) {
            H7.b.c("OmtpVvmCarrierCfgHlpr", "getCarrierConfig return null");
            return null;
        }
        return carrierConfig;
    }

    public Set<String> d() {
        Set<String> e10 = e(this.f18028b);
        if (e10 != null) {
            return e10;
        }
        return e(this.f18031e);
    }

    public String f() {
        String str = (String) o("vvm_client_prefix_string");
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        C1.a.a("OmtpVvmCarrierCfgHlpr", "getClientPrefix " + str);
        return "//VVM";
    }

    public Context g() {
        return this.f18027a;
    }

    public String h() {
        return (String) o("vvm_destination_number_string");
    }

    public Set<String> i() {
        Set<String> j10 = j(this.f18028b);
        if (j10 != null) {
            return j10;
        }
        return j(this.f18031e);
    }

    public PhoneAccountHandle k() {
        return this.f18033g;
    }

    public AbstractC1729d l() {
        return this.f18030d;
    }

    public int m() {
        return ((Integer) p("vvm_ssl_port_number_int", 0)).intValue();
    }

    public String n(String str) {
        return (String) o(str);
    }

    public final Object o(String str) {
        return p(str, null);
    }

    public final Object p(String str, Object obj) {
        Object obj2;
        Object obj3;
        Object obj4;
        PersistableBundle persistableBundle = this.f18032f;
        if (persistableBundle != null && (obj4 = persistableBundle.get(str)) != null) {
            return obj4;
        }
        PersistableBundle persistableBundle2 = this.f18028b;
        if (persistableBundle2 != null && (obj3 = persistableBundle2.get(str)) != null) {
            return obj3;
        }
        PersistableBundle persistableBundle3 = this.f18031e;
        if (persistableBundle3 != null && (obj2 = persistableBundle3.get(str)) != null) {
            return obj2;
        }
        return obj;
    }

    public String q() {
        return (String) o("vvm_type_string");
    }

    public void r(c.b bVar, OmtpEvents omtpEvents) {
        C1580a.a(w());
        H7.b.e("OmtpVvmCarrierCfgHlpr", "OmtpEvent:" + omtpEvents);
        this.f18030d.c(this.f18027a, this, bVar, omtpEvents);
    }

    public boolean s() {
        return ((Boolean) p("vvm_cellular_data_required_bool", Boolean.valueOf(B3.a.w()))).booleanValue();
    }

    public boolean t() {
        if (!w()) {
            return false;
        }
        Set<String> d10 = d();
        if (d10 == null) {
            return true;
        }
        if (C1643c.q()) {
            String string = PreferenceManager.getDefaultSharedPreferences(this.f18027a).getString("change_voicemail_status", "");
            if (TextUtils.isEmpty(string)) {
                return true;
            }
            return Boolean.parseBoolean(string);
        }
        Iterator<String> it = d10.iterator();
        while (it.hasNext()) {
            try {
                this.f18027a.getPackageManager().getPackageInfo(it.next(), 0);
                return false;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return true;
    }

    public String toString() {
        boolean z10;
        StringBuilder sb = new StringBuilder("OmtpVvmCarrierConfigHelper [");
        sb.append("phoneAccountHandle: ");
        sb.append(this.f18033g);
        sb.append(", carrierConfig: ");
        boolean z11 = false;
        if (this.f18028b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        sb.append(z10);
        sb.append(", telephonyConfig: ");
        if (this.f18031e != null) {
            z11 = true;
        }
        sb.append(z11);
        sb.append(", type: ");
        sb.append(q());
        sb.append(", destinationNumber: ");
        sb.append(h());
        sb.append(", applicationPort: ");
        sb.append(b());
        sb.append(", sslPort: ");
        sb.append(m());
        sb.append(", isEnabledByDefault: ");
        sb.append(t());
        sb.append(", isCellularDataRequired: ");
        sb.append(s());
        sb.append(", isPrefetchEnabled: ");
        sb.append(v());
        sb.append(", isLegacyModeEnabled: ");
        sb.append(u());
        sb.append(", getClientPrefix: ");
        sb.append(f());
        sb.append("]");
        return sb.toString();
    }

    public boolean u() {
        return ((Boolean) p("vvm_legacy_mode_enabled_bool", Boolean.FALSE)).booleanValue();
    }

    public boolean v() {
        return ((Boolean) p("vvm_prefetch_bool", Boolean.TRUE)).booleanValue();
    }

    public boolean w() {
        if (this.f18030d != null) {
            return true;
        }
        return false;
    }

    public void x(PendingIntent pendingIntent) {
        this.f18030d.d(this, pendingIntent);
    }

    public void y() {
        PhoneAccountHandle k10 = k();
        if (k10 == null) {
            return;
        }
        String str = this.f18029c;
        if (str != null && !str.isEmpty()) {
            if (this.f18030d != null) {
                ActivationTask.v(this.f18027a, this.f18033g, null);
            }
        } else {
            H7.b.c("OmtpVvmCarrierCfgHlpr", "startActivation : vvmType is null or empty for account " + k10);
        }
    }

    public void z() {
        H7.b.e("OmtpVvmCarrierCfgHlpr", "startDeactivation");
        if (!u()) {
            d.b(this.f18027a, k(), null);
            H7.b.e("OmtpVvmCarrierCfgHlpr", "filter disabled");
        }
        AbstractC1729d abstractC1729d = this.f18030d;
        if (abstractC1729d != null) {
            abstractC1729d.f(this);
        }
        B1.b.g(this.f18027a, k());
    }
}
