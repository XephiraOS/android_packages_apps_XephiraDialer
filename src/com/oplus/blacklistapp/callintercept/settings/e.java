package com.oplus.blacklistapp.callintercept.settings;

import android.R;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.oplus.blacklistapp.activities.PhoneNoInquireActivity;
import com.oplus.blacklistapp.activities.PhoneNoInquireForCountryActivity;
import com.oplus.common.data.SettingsWrapper$Global;
import com.oplus.utils.C0844e;
import com.oplus.utils.C0846g;
import com.oplus.utils.StatisticsUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import v6.C1628b;
import v6.C1632f;
import v9.InterfaceC1637a;

/* compiled from: CallHarassInterceptFragment.java */
/* loaded from: classes3.dex */
public class e extends D6.a implements Preference.c {

    /* renamed from: L, reason: collision with root package name */
    public static final String f26824L;

    /* renamed from: M, reason: collision with root package name */
    public static final String f26825M;

    /* renamed from: A, reason: collision with root package name */
    public Dialog f26826A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f26827B;

    /* renamed from: C, reason: collision with root package name */
    public COUISwitchPreference f26828C;

    /* renamed from: D, reason: collision with root package name */
    public COUISwitchPreference f26829D;

    /* renamed from: E, reason: collision with root package name */
    public COUISwitchPreference f26830E;

    /* renamed from: F, reason: collision with root package name */
    public androidx.appcompat.app.b f26831F = null;

    /* renamed from: G, reason: collision with root package name */
    public r f26832G = null;

    /* renamed from: H, reason: collision with root package name */
    public ContentObserver f26833H = null;

    /* renamed from: I, reason: collision with root package name */
    public SharedPreferences.OnSharedPreferenceChangeListener f26834I = null;

    /* renamed from: J, reason: collision with root package name */
    public final A f26835J = new A();

    /* renamed from: K, reason: collision with root package name */
    public Handler f26836K = new i(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    public COUISwitchPreference f26837a;

    /* renamed from: b, reason: collision with root package name */
    public COUISwitchPreference f26838b;

    /* renamed from: c, reason: collision with root package name */
    public COUISwitchPreference f26839c;

    /* renamed from: d, reason: collision with root package name */
    public COUIJumpPreference f26840d;

    /* renamed from: e, reason: collision with root package name */
    public COUISwitchPreference f26841e;

    /* renamed from: f, reason: collision with root package name */
    public COUISwitchPreference f26842f;

    /* renamed from: g, reason: collision with root package name */
    public COUIJumpPreference f26843g;

    /* renamed from: h, reason: collision with root package name */
    public COUIJumpPreference f26844h;

    /* renamed from: i, reason: collision with root package name */
    public COUIPreferenceCategory f26845i;

    /* renamed from: j, reason: collision with root package name */
    public COUIPreferenceCategory f26846j;

    /* renamed from: k, reason: collision with root package name */
    public COUIPreferenceCategory f26847k;

    /* renamed from: l, reason: collision with root package name */
    public COUIPreferenceCategory f26848l;

    /* renamed from: m, reason: collision with root package name */
    public COUIPreferenceCategory f26849m;

    /* renamed from: n, reason: collision with root package name */
    public Preference f26850n;

    /* renamed from: o, reason: collision with root package name */
    public Preference f26851o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f26852p;

    /* renamed from: q, reason: collision with root package name */
    public AppCompatActivity f26853q;

    /* renamed from: r, reason: collision with root package name */
    public Context f26854r;

    /* renamed from: x, reason: collision with root package name */
    public int f26855x;

    /* renamed from: y, reason: collision with root package name */
    public int f26856y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f26857z;

    /* compiled from: CallHarassInterceptFragment.java */
    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            e.this.f26826A = null;
        }
    }

    /* compiled from: CallHarassInterceptFragment.java */
    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.T1(false);
        }
    }

    /* compiled from: CallHarassInterceptFragment.java */
    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            e.this.T1(false);
        }
    }

    /* compiled from: CallHarassInterceptFragment.java */
    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            e eVar = e.this;
            String str = C1632f.f37467u;
            eVar.N1(str, true, 0);
            e.this.T1(true);
            e.this.W1(true);
            e.this.R1(false);
            e.this.a2();
            e eVar2 = e.this;
            eVar2.y1("unknown_block_call", z6.b.c(eVar2.f26854r, 1, str, 0));
        }
    }

    /* compiled from: CallHarassInterceptFragment.java */
    /* renamed from: com.oplus.blacklistapp.callintercept.settings.e$e, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterfaceOnDismissListenerC0242e implements DialogInterface.OnDismissListener {
        public DialogInterfaceOnDismissListenerC0242e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            e.this.f26826A = null;
        }
    }

    /* compiled from: CallHarassInterceptFragment.java */
    /* loaded from: classes3.dex */
    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            int i11;
            if (C1632f.z(e.this.f26854r.getApplicationContext())) {
                i11 = 0;
            } else {
                i11 = 3;
            }
            e eVar = e.this;
            String str = C1632f.f37447a;
            eVar.N1(str, true, i11);
            e.this.U1(true);
            e eVar2 = e.this;
            eVar2.y1("one_ring_block_call", z6.b.c(eVar2.f26854r, 1, str, i11));
        }
    }

    /* compiled from: CallHarassInterceptFragment.java */
    /* loaded from: classes3.dex */
    public class h extends ContentObserver {
        public h(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            super.onChange(z10, uri);
            Context context = e.this.f26854r;
            String str = e.f26824L;
            e eVar = e.this;
            C1632f.V(context, str, eVar.f26836K, eVar.f26856y, 0);
        }
    }

    /* compiled from: CallHarassInterceptFragment.java */
    /* loaded from: classes3.dex */
    public class i extends Handler {
        public i(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z10;
            if (!e.this.isAdded()) {
                return;
            }
            int i10 = message.what;
            if (i10 == 101) {
                e.this.Z1();
                return;
            }
            if (i10 == 102) {
                e.this.O1();
                return;
            }
            if (i10 != 1000) {
                Log.w("CallHarassInterceptFragment", "Message not expected: " + message.what);
                return;
            }
            int i11 = message.arg1;
            e.this.log("EVENT_QUERY_ATTRIBUTION_COMPLETE count = " + i11);
            SharedPreferences b10 = androidx.preference.j.b(e.this.f26854r);
            if (e.this.f26843g != null) {
                boolean C10 = C1632f.C(b10, "harass_intercept_attribution", 3, e.this.f26856y);
                C0846g.i("CallHarassInterceptFragment", e.this.f26856y + "-refresh-isHarassInterceptAttribution : " + C10);
                if (C10) {
                    String string = e.this.getString(com.oplus.blacklistapp.u.f27712x1);
                    if (i11 != 0) {
                        if (l7.b.f34737e) {
                            string = e.this.getString(com.oplus.blacklistapp.u.f27622f1, Integer.valueOf(i11));
                        } else {
                            string = e.this.getString(com.oplus.blacklistapp.u.f27718y2, Integer.valueOf(i11));
                        }
                    }
                    e.this.f26843g.setAssignment(string);
                } else {
                    e.this.f26843g.setAssignment(e.this.getString(com.oplus.blacklistapp.u.f27624f3));
                }
            }
            SharedPreferences.Editor edit = b10.edit();
            String str = "has_attribution_data_" + e.this.f26856y;
            if (i11 != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            edit.putBoolean(str, z10).apply();
            if (e.this.f26856y != 1 || !e.this.E1(C1632f.f37454h, 3)) {
                e.this.a2();
            }
        }
    }

    /* compiled from: CallHarassInterceptFragment.java */
    /* loaded from: classes3.dex */
    public class j implements DialogInterface.OnDismissListener {
        public j() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            e.this.f26826A = null;
        }
    }

    /* compiled from: CallHarassInterceptFragment.java */
    /* loaded from: classes3.dex */
    public class k implements DialogInterface.OnCancelListener {
        public k() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.V1(false);
        }
    }

    /* compiled from: CallHarassInterceptFragment.java */
    /* loaded from: classes3.dex */
    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            e.this.V1(false);
        }
    }

    /* compiled from: CallHarassInterceptFragment.java */
    /* loaded from: classes3.dex */
    public class m implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f26870a;

        public m(String str) {
            this.f26870a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            e eVar = e.this;
            eVar.N1(eVar.B1(this.f26870a), true, 0);
            e.this.V1(true);
            e.this.a2();
            e eVar2 = e.this;
            eVar2.y1("private_numbers_block_call", z6.b.c(eVar2.f26854r, 1, C1632f.f37448b, 0));
        }
    }

    /* compiled from: CallHarassInterceptFragment.java */
    /* loaded from: classes3.dex */
    public class n implements DialogInterface.OnDismissListener {
        public n() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            e.this.f26826A = null;
        }
    }

    /* compiled from: CallHarassInterceptFragment.java */
    /* loaded from: classes3.dex */
    public class o implements DialogInterface.OnCancelListener {
        public o() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            e.this.S1(false);
        }
    }

    /* compiled from: CallHarassInterceptFragment.java */
    /* loaded from: classes3.dex */
    public class p implements DialogInterface.OnClickListener {
        public p() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            e.this.S1(false);
        }
    }

    /* compiled from: CallHarassInterceptFragment.java */
    /* loaded from: classes3.dex */
    public class q implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f26875a;

        public q(String str) {
            this.f26875a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            e eVar = e.this;
            eVar.N1(eVar.B1(this.f26875a), true, 0);
            e.this.W1(false);
            e.this.S1(true);
            e.this.a2();
            e eVar2 = e.this;
            eVar2.y1("all_block_call", z6.b.c(eVar2.f26854r, 1, C1632f.f37464r, 0));
        }
    }

    /* compiled from: CallHarassInterceptFragment.java */
    /* loaded from: classes3.dex */
    public class r extends ContentObserver {
        public r(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            super.onChange(z10, uri);
            if (uri != null) {
                boolean equals = uri.equals(z6.b.f(1, C1632f.f37464r));
                if (uri.equals(z6.b.f(1, C1632f.f37467u))) {
                    equals = true;
                }
                if (uri.equals(z6.b.f(1, C1632f.f37447a))) {
                    equals = true;
                }
                if (uri.equals(z6.b.f(1, C1632f.f37448b))) {
                    equals = true;
                }
                if (uri.equals(z6.b.f(1, C1632f.f37454h))) {
                    e.this.C1();
                    equals = true;
                }
                if (uri.equals(z6.b.f(1, C1632f.f37455i))) {
                    equals = true;
                }
                if (uri.equals(z6.b.f(1, C1632f.f37456j))) {
                    equals = true;
                }
                if (uri.equals(z6.b.f(1, C1632f.f37457k))) {
                    equals = true;
                }
                if (uri.equals(z6.b.f(1, C1632f.f37458l)) || equals) {
                    e.this.f26836K.removeMessages(102);
                    e.this.f26836K.sendEmptyMessageDelayed(102, 200L);
                }
            }
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("content://");
        String str = com.oplus.blacklist.database.a.f26232a;
        sb.append(str);
        sb.append("/area_list");
        f26824L = sb.toString();
        f26825M = "content://" + str + "/bl_area_for_country";
    }

    private HashMap<String, String> A1(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("SlotId", String.valueOf(this.f26856y));
        hashMap.put(str, str2);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        C0846g.i("CallHarassInterceptFragment", "SLOTID:" + this.f26856y + "  " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1(String str, int i10) {
        log("addUserAction tag = " + str + " value = " + i10);
        StatisticsUtils.a(this.f26854r, 2010804, 201082005, StatisticsUtils.f(str, i10, this.f26857z, this.f26856y), false);
    }

    public static e z1(boolean z10, int i10) {
        e eVar = new e();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isSingleSim", z10);
        bundle.putInt("position", i10);
        eVar.setArguments(bundle);
        return eVar;
    }

    public final String B1(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -2096563860:
                if (str.equals("harass_intercept_mark_number_fraud")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1256899426:
                if (str.equals("harass_intercept_mark_number_harassment")) {
                    c10 = 1;
                    break;
                }
                break;
            case -605098738:
                if (str.equals("harass_intercept_all_incoming_calls")) {
                    c10 = 2;
                    break;
                }
                break;
            case -577442154:
                if (str.equals("harass_intercept_unknown")) {
                    c10 = 3;
                    break;
                }
                break;
            case -491915065:
                if (str.equals("harass_intercept_mark_number_intermediary")) {
                    c10 = 4;
                    break;
                }
                break;
            case 1969274924:
                if (str.equals("harass_intercept_mark_number_advertising")) {
                    c10 = 5;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return C1632f.f37455i;
            case 1:
                return C1632f.f37456j;
            case 2:
                return C1632f.f37464r;
            case 3:
                return C1632f.f37448b;
            case 4:
                return C1632f.f37458l;
            case 5:
                return C1632f.f37457k;
            default:
                return "";
        }
    }

    public void C1() {
        log("initSlotInfo slotId = " + this.f26855x);
        int i10 = this.f26855x;
        this.f26856y = i10;
        if (this.f26857z && i10 == 1 && E1(C1632f.f37454h, 3)) {
            this.f26856y = 0;
            log("UseSim1Rules change slotId to 0 " + this.f26856y);
        }
    }

    public boolean D1(int i10) {
        boolean z10 = false;
        if (this.f26856y != 0 ? (i10 & 2) == 2 : (i10 & 1) == 1) {
            z10 = true;
        }
        log("isHarassIntercepOpen " + z10);
        return z10;
    }

    public boolean E1(final String str, int i10) {
        int a10 = SettingsWrapper$Global.a(this.f26854r.getContentResolver(), str, i10, new InterfaceC1637a() { // from class: com.oplus.blacklistapp.callintercept.settings.b
            @Override // v9.InterfaceC1637a
            public final Object invoke() {
                Integer I12;
                I12 = e.this.I1(str);
                return I12;
            }
        });
        C1632f.j0(this.f26854r, str, a10, i10);
        boolean D12 = D1(a10);
        log("isHarassInterceptOpen " + str + " =  " + a10 + " defaultValue = " + i10 + "  isOpen = " + D12);
        return D12;
    }

    public boolean F1(Context context) {
        boolean E12 = E1(C1632f.f37448b, 0);
        C0846g.i("CallHarassInterceptFragment", "isInterceptUnknownOn, isOn = " + E12);
        return E12;
    }

    public final void G1() {
        Intent intent = new Intent(getActivity(), (Class<?>) CallHarassInterceptMarkedNumberActivity.class);
        intent.putExtra("slotId", this.f26856y);
        intent.putExtra("is_single_sim", this.f26857z);
        C1632f.g0(getActivity(), intent);
    }

    public final void H1() {
        Intent intent = new Intent();
        intent.putExtra("navigate_parent_package", this.f26854r.getPackageName());
        intent.putExtra("navigate_title_id", com.oplus.blacklistapp.u.f27665o);
        C0846g.i("CallHarassInterceptFragment", "NavigateUtils.NAVIGATE_UP_PACKAGE == " + this.f26854r.getPackageName());
        intent.putExtra("slotId", this.f26856y);
        intent.putExtra("is_single_sim", this.f26857z);
        if (l7.b.f34737e) {
            intent.setClass(getContext(), PhoneNoInquireForCountryActivity.class);
        } else {
            intent.setClass(getContext(), PhoneNoInquireActivity.class);
        }
        startActivity(intent);
        x1(201110034, "harass_intercept_attribution", true);
    }

    public final /* synthetic */ Integer I1(String str) {
        return Integer.valueOf(z6.b.b(this.f26854r, 1, str));
    }

    public final /* synthetic */ boolean J1(Preference preference) {
        H1();
        return true;
    }

    public final /* synthetic */ boolean K1(Preference preference) {
        G1();
        return true;
    }

    public final /* synthetic */ void L1(SharedPreferences sharedPreferences, String str) {
        str.hashCode();
        if (str.equals("harass_intercept_attribution") || str.equals("harass_intercept_marked_number_v2")) {
            this.f26836K.removeMessages(102);
            this.f26836K.sendEmptyMessageDelayed(102, 200L);
        }
    }

    public final void M1(boolean z10) {
        if (this.f26856y == 1) {
            boolean E12 = E1(C1632f.f37467u, 0);
            boolean E13 = E1(C1632f.f37464r, 0);
            if (E13) {
                R1(false);
            } else if (E12) {
                R1(false);
            } else {
                R1(true);
            }
            W1(!E13);
            Q1(z10);
            if (z10) {
                this.f26849m.setEnabled(false);
            } else {
                a2();
            }
        }
    }

    public void N1(String str, boolean z10, int i10) {
        int i11;
        int c10 = z6.b.c(this.f26854r, 1, str, i10);
        if (this.f26856y == 1) {
            i11 = 2;
        } else {
            i11 = 1;
        }
        int a10 = com.oplus.blacklistapp.callintercept.a.a(c10, i11, z10);
        log("putIntHarassInterceptkeyValue " + str + " =  " + c10 + "  newKeyValue = " + a10);
        z6.b.i(this.f26854r, 1, str, a10);
    }

    public final void O1() {
        int i10;
        boolean z10;
        boolean z11;
        String str;
        SharedPreferences b10 = androidx.preference.j.b(this.f26854r);
        if (C1632f.z(this.f26854r.getApplicationContext())) {
            i10 = 0;
        } else {
            i10 = 3;
        }
        boolean E12 = E1(C1632f.f37447a, i10);
        log("refreshHarassIntercept harass_intercept_ringing = " + E12);
        COUISwitchPreference cOUISwitchPreference = this.f26839c;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setChecked(E12);
        }
        boolean F12 = F1(this.f26854r);
        log("refreshHarassIntercept harass_intercept_unknown = " + F12);
        COUISwitchPreference cOUISwitchPreference2 = this.f26838b;
        if (cOUISwitchPreference2 != null) {
            cOUISwitchPreference2.setChecked(F12);
        }
        if (this.f26827B) {
            StringBuilder sb = new StringBuilder();
            String languageTag = Locale.getDefault().toLanguageTag();
            if (!TextUtils.isEmpty(languageTag)) {
                if (!languageTag.equalsIgnoreCase("zh-CN") && !languageTag.equalsIgnoreCase("zh-TW") && !languageTag.equalsIgnoreCase("zh-HK") && !languageTag.startsWith("zh-Hans") && !languageTag.startsWith("zh-Hant")) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (C0846g.c()) {
                    C0846g.i("CallHarassInterceptFragment", "languageTag : " + languageTag + "\nisChineseLanguage : " + z11);
                }
            } else {
                z11 = false;
            }
            if (z11) {
                str = "、";
            } else {
                str = ",";
            }
            if (E1(C1632f.f37455i, 3)) {
                if (C0844e.m(this.f26854r)) {
                    sb.append(getString(com.oplus.blacklistapp.u.f27501C1));
                    sb.append(str);
                } else {
                    sb.append(getString(com.oplus.blacklistapp.u.f27675q));
                    sb.append(str);
                }
            }
            if (E1(C1632f.f37456j, 0)) {
                sb.append(getString(com.oplus.blacklistapp.u.f27497B1));
                sb.append(str);
            }
            if (E1(C1632f.f37457k, 0)) {
                sb.append(getString(com.oplus.blacklistapp.u.f27722z1));
                sb.append(str);
            }
            if (E1(C1632f.f37458l, 0)) {
                sb.append(getString(com.oplus.blacklistapp.u.f27505D1));
            }
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                sb2 = getString(com.oplus.blacklistapp.u.f27712x1);
            }
            if (sb2.endsWith(str)) {
                sb2 = sb2.substring(0, sb2.lastIndexOf(str));
            }
            C0846g.i("CallHarassInterceptFragment", "info =" + sb2);
            if (this.f26840d != null) {
                boolean C10 = C1632f.C(b10, "harass_intercept_marked_number_v2", 3, this.f26856y);
                C0846g.i("CallHarassInterceptFragment", this.f26856y + "-refresh-isHarassInterceptMarkNumber : " + C10);
                if (C10) {
                    this.f26840d.setAssignment(sb2);
                } else {
                    this.f26840d.setAssignment(getString(com.oplus.blacklistapp.u.f27624f3));
                }
            }
        }
        boolean E13 = E1(C1632f.f37467u, 0);
        log("refreshHarassIntercept isHarassInterceptAllStrangers = " + E13);
        COUISwitchPreference cOUISwitchPreference3 = this.f26841e;
        if (cOUISwitchPreference3 != null) {
            cOUISwitchPreference3.setChecked(E13);
        }
        Z1();
        boolean E14 = E1(C1632f.f37464r, 0);
        log("refreshHarassIntercept isHarassInterceptNonMainland = " + E14);
        COUISwitchPreference cOUISwitchPreference4 = this.f26842f;
        if (cOUISwitchPreference4 != null) {
            cOUISwitchPreference4.setChecked(E14);
        }
        if (this.f26856y == 1) {
            z10 = E1(C1632f.f37454h, 3);
        } else {
            z10 = false;
        }
        if (!l7.b.f34737e) {
            C1632f.V(this.f26854r, f26824L, this.f26836K, this.f26856y, 0);
        } else {
            C1632f.V(this.f26854r, f26825M, this.f26836K, this.f26856y, 0);
        }
        if (E14) {
            R1(false);
        } else if (E13) {
            R1(false);
        } else {
            R1(true);
        }
        COUISwitchPreference cOUISwitchPreference5 = this.f26837a;
        if (cOUISwitchPreference5 != null) {
            cOUISwitchPreference5.setChecked(z10);
        }
        W1(!E14);
        if (!this.f26857z) {
            Q1(z10);
        }
    }

    public final void P1() {
        Uri f10;
        Uri f11;
        Uri f12;
        Uri f13;
        Uri f14;
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver = getContext().getContentResolver();
        if (this.f26842f != null && (f14 = z6.b.f(1, C1632f.f37464r)) != null) {
            arrayList.add(f14);
        }
        if (this.f26841e != null && (f13 = z6.b.f(1, C1632f.f37467u)) != null) {
            arrayList.add(f13);
        }
        if (this.f26839c != null && (f12 = z6.b.f(1, C1632f.f37447a)) != null) {
            arrayList.add(f12);
        }
        if (this.f26838b != null && (f11 = z6.b.f(1, C1632f.f37448b)) != null) {
            arrayList.add(f11);
        }
        if (this.f26837a != null && (f10 = z6.b.f(1, C1632f.f37454h)) != null) {
            arrayList.add(f10);
        }
        if (this.f26840d != null) {
            Uri f15 = z6.b.f(1, C1632f.f37455i);
            if (f15 != null) {
                arrayList.add(f15);
            }
            Uri f16 = z6.b.f(1, C1632f.f37456j);
            if (f16 != null) {
                arrayList.add(f16);
            }
            Uri f17 = z6.b.f(1, C1632f.f37457k);
            if (f17 != null) {
                arrayList.add(f17);
            }
            Uri f18 = z6.b.f(1, C1632f.f37458l);
            if (f18 != null) {
                arrayList.add(f18);
            }
        }
        if (!arrayList.isEmpty()) {
            if (this.f26832G == null) {
                this.f26832G = new r(null);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                contentResolver.registerContentObserver((Uri) it.next(), true, this.f26832G);
            }
        }
        if (this.f26834I == null) {
            this.f26834I = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.oplus.blacklistapp.callintercept.settings.a
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    e.this.L1(sharedPreferences, str);
                }
            };
        }
        getPreferenceManager().l().registerOnSharedPreferenceChangeListener(this.f26834I);
        if (!l7.b.f34737e) {
            if (this.f26833H == null) {
                this.f26833H = new h(this.f26836K);
            }
            getContext().getContentResolver().registerContentObserver(Uri.withAppendedPath(com.oplus.blacklist.database.a.f26233b, "area_list"), true, this.f26833H);
        }
    }

    public final void Q1(boolean z10) {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen == null) {
            return;
        }
        if (z10) {
            preferenceScreen.removePreference(this.f26848l);
            preferenceScreen.removePreference(this.f26845i);
            preferenceScreen.removePreference(this.f26849m);
        } else {
            preferenceScreen.addPreference(this.f26848l);
            preferenceScreen.addPreference(this.f26845i);
            preferenceScreen.addPreference(this.f26849m);
        }
    }

    public final void R1(boolean z10) {
        COUIJumpPreference cOUIJumpPreference;
        if (this.f26843g != null && this.f26845i != null) {
            if (z10 && (!I6.b.c(this.f26854r) || !l7.b.i())) {
                this.f26843g.setEnabled(true);
            } else {
                this.f26843g.setEnabled(false);
            }
        }
        if (this.f26827B && (cOUIJumpPreference = this.f26840d) != null && this.f26845i != null) {
            cOUIJumpPreference.setEnabled(z10);
        }
        this.f26836K.sendEmptyMessage(101);
    }

    public final void S1(boolean z10) {
        COUISwitchPreference cOUISwitchPreference = this.f26842f;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setChecked(z10);
        }
    }

    public final void T1(boolean z10) {
        COUISwitchPreference cOUISwitchPreference = this.f26841e;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setChecked(z10);
        }
    }

    public final void U1(boolean z10) {
        COUISwitchPreference cOUISwitchPreference = this.f26839c;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setChecked(z10);
        }
    }

    public final void V1(boolean z10) {
        COUISwitchPreference cOUISwitchPreference = this.f26838b;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setChecked(z10);
        }
    }

    public final void W1(boolean z10) {
        COUIPreferenceCategory cOUIPreferenceCategory;
        if (getPreferenceScreen() != null && (cOUIPreferenceCategory = this.f26845i) != null) {
            cOUIPreferenceCategory.setEnabled(z10);
        }
    }

    public final void X1(int i10, String str) {
        Dialog dialog = this.f26826A;
        if (dialog != null) {
            dialog.dismiss();
            this.f26826A = null;
        }
        log("showConfirmDialog, id = " + i10 + ", key = " + str);
        S8.b bVar = new S8.b(this.f26853q, X8.n.f5032d);
        if (i10 != 200) {
            if (i10 != 201) {
                if (i10 != 204) {
                    if (i10 == 205) {
                        bVar.setTitle(com.oplus.blacklistapp.u.f27642j1).setMessage(com.oplus.blacklistapp.u.f27637i1).setNeutralButton(com.oplus.blacklistapp.u.f27547O, (DialogInterface.OnClickListener) new g()).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) new f()).setOnDismissListener(new DialogInterfaceOnDismissListenerC0242e());
                    }
                } else {
                    bVar.setTitle(com.oplus.blacklistapp.u.f27613d2).setMessage(com.oplus.blacklistapp.u.f27608c2).setNeutralButton(com.oplus.blacklistapp.u.f27547O, (DialogInterface.OnClickListener) new d()).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) new c()).setOnCancelListener(new b()).setOnDismissListener(new a());
                }
            } else {
                bVar.setTitle(com.oplus.blacklistapp.u.f27551P).setNeutralButton(com.oplus.blacklistapp.u.f27547O, (DialogInterface.OnClickListener) new q(str)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) new p()).setOnCancelListener(new o()).setOnDismissListener(new n());
            }
        } else {
            bVar.setTitle(com.oplus.blacklistapp.u.f27623f2).setMessage(com.oplus.blacklistapp.u.f27618e2).setNeutralButton(com.oplus.blacklistapp.u.f27547O, (DialogInterface.OnClickListener) new m(str)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) new l()).setOnCancelListener(new k()).setOnDismissListener(new j());
        }
        androidx.appcompat.app.b create = bVar.create();
        this.f26826A = create;
        create.setCanceledOnTouchOutside(true);
        this.f26826A.show();
        bVar.updateViewAfterShown();
    }

    public final void Y1() {
        if (this.f26832G != null) {
            getContext().getContentResolver().unregisterContentObserver(this.f26832G);
            this.f26832G = null;
        }
        if (this.f26834I != null) {
            getPreferenceManager().l().registerOnSharedPreferenceChangeListener(this.f26834I);
            this.f26834I = null;
        }
        if (this.f26833H != null) {
            getContext().getContentResolver().unregisterContentObserver(this.f26833H);
            this.f26833H = null;
        }
    }

    public final void Z1() {
        E1(C1632f.f37464r, 0);
        if (this.f26856y == 1) {
            E1(C1632f.f37454h, 3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0035, code lost:
    
        if (r3.getBoolean("has_attribution_data_" + r7.f26856y, false) == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a2() {
        /*
            r7 = this;
            java.lang.String r0 = v6.C1632f.f37467u
            r1 = 0
            boolean r0 = r7.E1(r0, r1)
            java.lang.String r2 = v6.C1632f.f37464r
            boolean r2 = r7.E1(r2, r1)
            android.content.Context r3 = r7.f26854r
            android.content.SharedPreferences r3 = androidx.preference.j.b(r3)
            r4 = 3
            int r5 = r7.f26856y
            java.lang.String r6 = "harass_intercept_attribution"
            boolean r4 = v6.C1632f.C(r3, r6, r4, r5)
            if (r4 == 0) goto L37
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "has_attribution_data_"
            r4.append(r5)
            int r5 = r7.f26856y
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            boolean r3 = r3.getBoolean(r4, r1)
            if (r3 != 0) goto L4b
        L37:
            if (r0 != 0) goto L4b
            if (r2 != 0) goto L4b
            android.content.Context r0 = r7.f26854r
            int r2 = r7.f26856y
            boolean r0 = v6.C1632f.P(r0, r2)
            if (r0 != 0) goto L4b
            com.coui.appcompat.preference.COUIPreferenceCategory r7 = r7.f26849m
            r7.setEnabled(r1)
            goto L51
        L4b:
            com.coui.appcompat.preference.COUIPreferenceCategory r7 = r7.f26849m
            r0 = 1
            r7.setEnabled(r0)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.callintercept.settings.e.a2():void");
    }

    @Override // androidx.preference.Preference.c
    public boolean k0(Preference preference, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        log("onPreferenceChange, key = " + preference.getKey() + ", ischecked = " + booleanValue);
        int i10 = 0;
        if ("harass_intercept_all_incoming_calls".equals(preference.getKey())) {
            if (!booleanValue) {
                String str = C1632f.f37464r;
                N1(str, false, 0);
                R1(!E1(C1632f.f37467u, 0));
                W1(true);
                a2();
                y1("all_block_call", z6.b.c(this.f26854r, 1, str, 0));
            } else {
                X1(201, preference.getKey());
                return false;
            }
        } else if ("harass_intercept_all_strangers_key".equals(preference.getKey())) {
            if (booleanValue) {
                X1(204, preference.getKey());
                return false;
            }
            String str2 = C1632f.f37467u;
            N1(str2, false, 0);
            R1(true);
            W1(true);
            a2();
            y1("unknown_block_call", z6.b.c(this.f26854r, 1, str2, 0));
        } else if ("harass_intercept_unknown".equals(preference.getKey())) {
            if (booleanValue) {
                if (l7.b.f34753u) {
                    String str3 = C1632f.f37448b;
                    N1(str3, true, 0);
                    y1("private_numbers_block_call", z6.b.c(this.f26854r, 1, str3, 0));
                } else {
                    X1(200, preference.getKey());
                    return false;
                }
            } else {
                String str4 = C1632f.f37448b;
                N1(str4, false, 0);
                y1("private_numbers_block_call", z6.b.c(this.f26854r, 1, str4, 0));
            }
        } else if ("harass_intercept_anonymous".equals(preference.getKey())) {
            N1("harass_intercept_anonymous", booleanValue, 0);
        } else if ("harass_intercept_unrecognized".equals(preference.getKey())) {
            N1("harass_intercept_unrecognized", booleanValue, 0);
        } else if ("harass_intercept_payphone".equals(preference.getKey())) {
            N1("harass_intercept_payphone", booleanValue, 0);
        } else if ("harass_intercept_ringing".equals(preference.getKey())) {
            if (booleanValue) {
                X1(205, preference.getKey());
                return false;
            }
            if (!C1632f.z(this.f26854r.getApplicationContext())) {
                i10 = 3;
            }
            String str5 = C1632f.f37447a;
            N1(str5, booleanValue, i10);
            y1("one_ring_block_call", z6.b.c(this.f26854r, 1, str5, i10));
        } else if ("use_sim1_rules".equals(preference.getKey())) {
            COUISwitchPreference cOUISwitchPreference = this.f26837a;
            if (cOUISwitchPreference != null) {
                cOUISwitchPreference.setChecked(booleanValue);
            }
            String str6 = C1632f.f37454h;
            N1(str6, booleanValue, 0);
            M1(booleanValue);
            y1("consistent_with_SIM1", z6.b.c(this.f26854r, 1, str6, 0));
        } else if ("mark_number_blocked_not_intercept_repeat".equals(preference.getKey())) {
            N1(C1632f.f37463q, booleanValue, 0);
        }
        return true;
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        COUIPreferenceCategory cOUIPreferenceCategory;
        boolean z10;
        COUIJumpPreference cOUIJumpPreference;
        COUIPreferenceCategory cOUIPreferenceCategory2;
        COUIJumpPreference cOUIJumpPreference2;
        COUIPreferenceCategory cOUIPreferenceCategory3;
        COUIPreferenceCategory cOUIPreferenceCategory4;
        COUIPreferenceCategory cOUIPreferenceCategory5;
        COUIPreferenceCategory cOUIPreferenceCategory6;
        super.onCreate(bundle);
        log("Creating activity");
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        this.f26853q = appCompatActivity;
        this.f26854r = appCompatActivity.getApplicationContext();
        addPreferencesFromResource(com.oplus.blacklistapp.w.f27735a);
        this.f26857z = getArguments().getBoolean("isSingleSim");
        int i10 = getArguments().getInt("position");
        this.f26855x = i10;
        C1();
        COUIPreferenceCategory cOUIPreferenceCategory7 = (COUIPreferenceCategory) findPreference("harass_intercept_all_incoming_category");
        this.f26848l = cOUIPreferenceCategory7;
        if (cOUIPreferenceCategory7 != null && !this.f26857z && i10 == 1) {
            cOUIPreferenceCategory7.setMarginTopType(0);
        }
        COUISwitchPreference cOUISwitchPreference = (COUISwitchPreference) findPreference("harass_intercept_all_incoming_calls");
        this.f26842f = cOUISwitchPreference;
        if (cOUISwitchPreference != null) {
            cOUISwitchPreference.setOnPreferenceChangeListener(this);
        }
        this.f26847k = (COUIPreferenceCategory) findPreference("slot_id_2_category");
        COUISwitchPreference cOUISwitchPreference2 = (COUISwitchPreference) findPreference("use_sim1_rules");
        this.f26837a = cOUISwitchPreference2;
        if (cOUISwitchPreference2 != null) {
            cOUISwitchPreference2.setOnPreferenceChangeListener(this);
        }
        COUISwitchPreference cOUISwitchPreference3 = (COUISwitchPreference) findPreference("harass_intercept_ringing");
        this.f26839c = cOUISwitchPreference3;
        if (cOUISwitchPreference3 != null) {
            cOUISwitchPreference3.setOnPreferenceChangeListener(this);
        }
        COUISwitchPreference cOUISwitchPreference4 = (COUISwitchPreference) findPreference("harass_intercept_unknown");
        this.f26838b = cOUISwitchPreference4;
        if (cOUISwitchPreference4 != null) {
            cOUISwitchPreference4.setOnPreferenceChangeListener(this);
        }
        COUISwitchPreference cOUISwitchPreference5 = (COUISwitchPreference) findPreference("harass_intercept_anonymous");
        this.f26828C = cOUISwitchPreference5;
        if (cOUISwitchPreference5 != null) {
            cOUISwitchPreference5.setOnPreferenceChangeListener(this);
        }
        COUISwitchPreference cOUISwitchPreference6 = (COUISwitchPreference) findPreference("harass_intercept_unrecognized");
        this.f26829D = cOUISwitchPreference6;
        if (cOUISwitchPreference6 != null) {
            cOUISwitchPreference6.setOnPreferenceChangeListener(this);
        }
        COUISwitchPreference cOUISwitchPreference7 = (COUISwitchPreference) findPreference("harass_intercept_payphone");
        this.f26830E = cOUISwitchPreference7;
        if (cOUISwitchPreference7 != null) {
            cOUISwitchPreference7.setOnPreferenceChangeListener(this);
        }
        COUIJumpPreference cOUIJumpPreference3 = (COUIJumpPreference) findPreference("harass_intercept_attribution");
        this.f26843g = cOUIJumpPreference3;
        if (cOUIJumpPreference3 != null) {
            cOUIJumpPreference3.setOnPreferenceClickListener(new Preference.d() { // from class: com.oplus.blacklistapp.callintercept.settings.c
                @Override // androidx.preference.Preference.d
                public final boolean s0(Preference preference) {
                    boolean J12;
                    J12 = e.this.J1(preference);
                    return J12;
                }
            });
        }
        this.f26841e = (COUISwitchPreference) findPreference("harass_intercept_all_strangers_key");
        this.f26844h = (COUIJumpPreference) findPreference("non_blocked_rules");
        this.f26849m = (COUIPreferenceCategory) findPreference("non_blocked_rules_category");
        a2();
        COUISwitchPreference cOUISwitchPreference8 = this.f26841e;
        if (cOUISwitchPreference8 != null) {
            cOUISwitchPreference8.setOnPreferenceChangeListener(this);
        }
        this.f26845i = (COUIPreferenceCategory) findPreference("first_group_category");
        if (!l7.b.o()) {
            COUISwitchPreference cOUISwitchPreference9 = this.f26828C;
            if (cOUISwitchPreference9 != null && (cOUIPreferenceCategory6 = this.f26845i) != null) {
                cOUIPreferenceCategory6.removePreference(cOUISwitchPreference9);
            }
            COUISwitchPreference cOUISwitchPreference10 = this.f26829D;
            if (cOUISwitchPreference10 != null && (cOUIPreferenceCategory5 = this.f26845i) != null) {
                cOUIPreferenceCategory5.removePreference(cOUISwitchPreference10);
            }
            COUISwitchPreference cOUISwitchPreference11 = this.f26830E;
            if (cOUISwitchPreference11 != null && (cOUIPreferenceCategory4 = this.f26845i) != null) {
                cOUIPreferenceCategory4.removePreference(cOUISwitchPreference11);
            }
        } else {
            COUISwitchPreference cOUISwitchPreference12 = this.f26838b;
            if (cOUISwitchPreference12 != null && (cOUIPreferenceCategory = this.f26845i) != null) {
                cOUIPreferenceCategory.removePreference(cOUISwitchPreference12);
            }
        }
        if (I6.b.c(this.f26854r) && l7.b.i() && (cOUIJumpPreference2 = this.f26843g) != null && (cOUIPreferenceCategory3 = this.f26845i) != null) {
            cOUIPreferenceCategory3.removePreference(cOUIJumpPreference2);
        }
        this.f26846j = (COUIPreferenceCategory) findPreference("mark_number_intercept_category");
        COUIJumpPreference cOUIJumpPreference4 = (COUIJumpPreference) findPreference("harass_intercept_marked_number_v2");
        this.f26840d = cOUIJumpPreference4;
        if (cOUIJumpPreference4 == null) {
            this.f26840d = (COUIJumpPreference) findPreference("harass_intercept_marked_number");
        }
        COUIJumpPreference cOUIJumpPreference5 = this.f26840d;
        if (cOUIJumpPreference5 != null) {
            cOUIJumpPreference5.setOnPreferenceClickListener(new Preference.d() { // from class: com.oplus.blacklistapp.callintercept.settings.d
                @Override // androidx.preference.Preference.d
                public final boolean s0(Preference preference) {
                    boolean K12;
                    K12 = e.this.K1(preference);
                    return K12;
                }
            });
            this.f26840d.setOnPreferenceChangeListener(this);
        }
        if (z6.b.c(this.f26854r, 1, "numberrecognition_switch", 1) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        l7.b.n(getContext());
        C0846g.i("CallHarassInterceptFragment", "canShowNumberRecognition = " + z10 + " isNumberRecognitionEnable =" + l7.b.d());
        if (l7.b.d() && z10) {
            this.f26827B = true;
        } else {
            this.f26827B = false;
        }
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (!this.f26827B && (cOUIJumpPreference = this.f26840d) != null && (cOUIPreferenceCategory2 = this.f26845i) != null) {
            cOUIPreferenceCategory2.removePreference(cOUIJumpPreference);
        }
        if (this.f26856y == 0 || this.f26857z) {
            log("initSlotInfo SLOT_ID0 remove UseSim1Rules");
            preferenceScreen.removePreference(this.f26847k);
        }
        this.f26850n = findPreference("preference_header");
        this.f26851o = findPreference("preference_tab_header");
        COUIJumpPreference cOUIJumpPreference6 = this.f26843g;
        if (cOUIJumpPreference6 != null) {
            cOUIJumpPreference6.setAssignment(" ");
        }
        O1();
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (!this.f26857z) {
            if (preferenceScreen != null) {
                preferenceScreen.removePreference(this.f26850n);
                preferenceScreen.removePreferenceRecursively("single_sim_call_intercept_description");
            }
        } else if (preferenceScreen != null) {
            preferenceScreen.removePreference(this.f26851o);
            preferenceScreen.removePreferenceRecursively("dual_sim_call_intercept_description");
        }
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f26835J.d();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        log("onPause");
        Y1();
        super.onPause();
    }

    @Override // androidx.preference.g, androidx.preference.j.c
    public boolean onPreferenceTreeClick(Preference preference) {
        log("onPreferenceTreeClick, preference.getKey() = " + preference.getKey());
        if ("non_blocked_rules".equals(preference.getKey())) {
            Intent intent = new Intent(getActivity(), (Class<?>) NonBlockedRulesSetting.class);
            intent.putExtra("slotId", this.f26856y);
            intent.putExtra("is_single_sim", this.f26857z);
            intent.setPackage(getActivity().getPackageName());
            startActivity(intent);
            return true;
        }
        return super.onPreferenceTreeClick(preference);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        log("onResume");
        C1632f.f0(this.f26854r, getListView());
        N1(C1632f.f37431F, true, 0);
        O1();
        super.onResume();
        P1();
        if (!this.f26852p) {
            this.f26852p = true;
        }
    }

    public final void x1(int i10, String str, boolean z10) {
        log("addUserAction type = " + i10 + " tag = " + str + " ischecked = " + z10);
        C1628b.a(this.f26854r, "2011101", i10, A1(str, String.valueOf(z10)));
    }

    /* compiled from: CallHarassInterceptFragment.java */
    /* loaded from: classes3.dex */
    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
        }
    }
}
