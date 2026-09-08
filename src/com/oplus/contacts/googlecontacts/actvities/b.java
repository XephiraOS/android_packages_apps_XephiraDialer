package com.oplus.contacts.googlecontacts.actvities;

import android.content.res.ColorStateList;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.preference.COUIMarkPreference;
import com.coui.appcompat.preference.COUIPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment;
import java.util.ArrayList;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.n;

/* compiled from: GoogleAccountListFragment.kt */
/* loaded from: classes3.dex */
public final class b extends COUIPreferenceWithAppbarFragment implements Preference.d {

    /* renamed from: d, reason: collision with root package name */
    public static final a f27829d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public COUIPreferenceCategory f27830a;

    /* renamed from: b, reason: collision with root package name */
    public String f27831b;

    /* renamed from: c, reason: collision with root package name */
    public final Preference.c f27832c = new Preference.c() { // from class: com.oplus.contacts.googlecontacts.actvities.a
        @Override // androidx.preference.Preference.c
        public final boolean k0(Preference preference, Object obj) {
            boolean g12;
            g12 = b.g1(preference, obj);
            return g12;
        }
    };

    /* compiled from: GoogleAccountListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public static final boolean g1(Preference preference, Object obj) {
        i.f(preference, "<anonymous parameter 0>");
        return false;
    }

    public final ArrayList<String> d1() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getStringArrayList("arg_google_account_list");
        }
        return null;
    }

    public final String e1() {
        ArrayList<String> d12 = d1();
        String str = this.f27831b;
        if (str != null && d12 != null && d12.contains(str)) {
            return str;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
    
        if (r0 == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f1(java.util.ArrayList<java.lang.String> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "accounts"
            kotlin.jvm.internal.i.f(r6, r0)
            java.util.ArrayList r0 = r5.d1()
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r2 = "arg_google_account_list"
            r1.putStringArrayList(r2, r6)
            r5.setArguments(r1)
            r1 = 0
            if (r0 == 0) goto L34
            int r2 = r6.size()
            r3 = r1
        L1e:
            if (r3 >= r2) goto L34
            java.lang.Object r4 = r6.get(r3)
            boolean r4 = r0.contains(r4)
            if (r4 != 0) goto L31
            java.lang.Object r0 = r6.get(r3)
            java.lang.String r0 = (java.lang.String) r0
            goto L35
        L31:
            int r3 = r3 + 1
            goto L1e
        L34:
            r0 = 0
        L35:
            if (r0 == 0) goto L3a
            r5.f27831b = r0
            goto L4c
        L3a:
            java.lang.String r0 = r5.f27831b
            if (r0 == 0) goto L44
            boolean r0 = kotlin.collections.m.u(r6, r0)
            if (r0 != 0) goto L4c
        L44:
            java.lang.Object r0 = r6.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r5.f27831b = r0
        L4c:
            r5.i1(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.contacts.googlecontacts.actvities.b.f1(java.util.ArrayList):void");
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment
    public String getTitle() {
        return "";
    }

    public final void h1(ArrayList<String> arrayList) {
        COUIPreferenceCategory cOUIPreferenceCategory = this.f27830a;
        if (cOUIPreferenceCategory != null) {
            int preferenceCount = cOUIPreferenceCategory.getPreferenceCount();
            for (int i10 = 0; i10 < preferenceCount; i10++) {
                Preference preference = cOUIPreferenceCategory.getPreference(i10);
                i.e(preference, "it.getPreference(i)");
                if (preference instanceof COUIMarkPreference) {
                    COUIMarkPreference cOUIMarkPreference = (COUIMarkPreference) preference;
                    String key = cOUIMarkPreference.getKey();
                    i.e(key, "preference.key");
                    String substring = key.substring(14);
                    i.e(substring, "substring(...)");
                    int parseInt = Integer.parseInt(substring);
                    if (parseInt >= 0 && parseInt < arrayList.size()) {
                        cOUIMarkPreference.setChecked(i.b(arrayList.get(parseInt), this.f27831b));
                    }
                }
            }
        }
    }

    public final void i1(ArrayList<String> arrayList) {
        COUIPreferenceCategory cOUIPreferenceCategory;
        FragmentActivity activity = getActivity();
        if (activity != null && (cOUIPreferenceCategory = this.f27830a) != null) {
            cOUIPreferenceCategory.removeAll();
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                String str = arrayList.get(i10);
                i.e(str, "accounts[i]");
                COUIMarkPreference cOUIMarkPreference = new COUIMarkPreference(activity);
                cOUIMarkPreference.setTitle(str);
                cOUIMarkPreference.setKey("google_account" + i10);
                cOUIMarkPreference.setOnPreferenceClickListener(this);
                cOUIMarkPreference.setOnPreferenceChangeListener(this.f27832c);
                cOUIMarkPreference.setPersistent(false);
                cOUIPreferenceCategory.addPreference(cOUIMarkPreference);
            }
            h1(arrayList);
        }
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f27831b = bundle.getString("current_account");
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g
    public void onCreatePreferences(Bundle bundle, String str) {
        COUIPreferenceCategory cOUIPreferenceCategory;
        addPreferencesFromResource(Y6.f.f5559a);
        Preference findPreference = findPreference("google_account_list");
        if (findPreference instanceof COUIPreferenceCategory) {
            cOUIPreferenceCategory = (COUIPreferenceCategory) findPreference;
        } else {
            cOUIPreferenceCategory = null;
        }
        this.f27830a = cOUIPreferenceCategory;
        COUIPreference cOUIPreference = (COUIPreference) findPreference("login_google_account");
        if (cOUIPreference != null) {
            ColorStateList valueOf = ColorStateList.valueOf(COUIContextUtil.getAttrColor(getContext(), N0.c.f1848i));
            i.e(valueOf, "valueOf(COUIContextUtil.…ttr.couiColorLabelTheme))");
            cOUIPreference.setTitleColor(valueOf);
            cOUIPreference.setOnPreferenceClickListener(this);
        }
        ArrayList<String> d12 = d1();
        if (d12 != null && d12.size() > 0) {
            this.f27831b = d12.get(0);
            i1(d12);
        }
    }

    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        i.f(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString("current_account", this.f27831b);
    }

    @Override // androidx.preference.Preference.d
    public boolean s0(Preference preference) {
        boolean v10;
        i.f(preference, "preference");
        if (i.b(preference.getKey(), "login_google_account")) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null && (parentFragment instanceof MoveContactsToGoogleFragment)) {
                ((MoveContactsToGoogleFragment) parentFragment).e1();
            }
            return true;
        }
        String key = preference.getKey();
        i.e(key, "preference.key");
        v10 = n.v(key, "google_account", false, 2, null);
        if (!v10) {
            return false;
        }
        ArrayList<String> d12 = d1();
        String key2 = preference.getKey();
        i.e(key2, "preference.key");
        String substring = key2.substring(14);
        i.e(substring, "substring(...)");
        int parseInt = Integer.parseInt(substring);
        if (d12 != null && parseInt >= 0 && parseInt < d12.size() && !i.b(this.f27831b, d12.get(parseInt))) {
            this.f27831b = d12.get(parseInt);
            h1(d12);
        }
        return true;
    }
}
