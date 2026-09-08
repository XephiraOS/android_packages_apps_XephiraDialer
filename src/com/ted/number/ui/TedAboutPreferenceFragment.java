package com.ted.number.ui;

import U0.k;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.K;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.baseui.util.NumberIdentifyUtils;
import com.android.contacts.framework.baseui.util.s;
import com.android.contacts.framework.baseui.widget.RevokePreference;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.customize.contacts.FeatureOption;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.FeatureUtil;
import com.ted.number.ui.TedAboutPreferenceFragment;
import f9.C1023a;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class TedAboutPreferenceFragment extends V0.a implements Preference.c, Preference.d {

    /* renamed from: a, reason: collision with root package name */
    public androidx.appcompat.app.b f29753a;

    /* renamed from: b, reason: collision with root package name */
    public androidx.appcompat.app.b f29754b;

    /* renamed from: d, reason: collision with root package name */
    public RevokePreference f29756d;

    /* renamed from: c, reason: collision with root package name */
    public final C1023a f29755c = new C1023a();

    /* renamed from: e, reason: collision with root package name */
    public final N7.a f29757e = N7.a.a();

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            TedAboutPreferenceFragment.this.f29754b = null;
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<TedAboutPreferenceFragment> f29759a;

        public b(TedAboutPreferenceFragment tedAboutPreferenceFragment) {
            this.f29759a = new WeakReference<>(tedAboutPreferenceFragment);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            TedAboutPreferenceFragment tedAboutPreferenceFragment = this.f29759a.get();
            if (tedAboutPreferenceFragment != null) {
                return Boolean.valueOf(tedAboutPreferenceFragment.f29755c.d());
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            TedAboutPreferenceFragment tedAboutPreferenceFragment = this.f29759a.get();
            if (bool != null && tedAboutPreferenceFragment != null && tedAboutPreferenceFragment.isAdded()) {
                tedAboutPreferenceFragment.w1(bool.booleanValue());
            }
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceWithAppbarFragment
    public String getTitle() {
        return getString(R.string.about);
    }

    @Override // androidx.preference.Preference.c
    public boolean k0(Preference preference, Object obj) {
        return false;
    }

    public final void n1(PreferenceScreen preferenceScreen) {
        COUIPreferenceCategory cOUIPreferenceCategory;
        if (preferenceScreen == null) {
            return;
        }
        if (FeatureOption.o() && !FeatureUtil.O() && (cOUIPreferenceCategory = (COUIPreferenceCategory) findPreference("pref_key_statement_category")) != null) {
            COUIJumpPreference cOUIJumpPreference = (COUIJumpPreference) findPreference("pref_key_ted_user_protocol");
            COUIJumpPreference cOUIJumpPreference2 = (COUIJumpPreference) findPreference("pref_key_ted_secret_policy");
            if (cOUIJumpPreference != null) {
                cOUIPreferenceCategory.removePreference(cOUIJumpPreference);
            }
            if (cOUIJumpPreference2 != null) {
                cOUIPreferenceCategory.removePreference(cOUIJumpPreference2);
            }
        }
        COUIPreferenceCategory cOUIPreferenceCategory2 = (COUIPreferenceCategory) findPreference("pref_key_revoke_personal_protection_category");
        if (cOUIPreferenceCategory2 != null) {
            this.f29756d = (RevokePreference) cOUIPreferenceCategory2.findPreference("pref_key_revoke_personal_protection");
            if (this.f29755c.c()) {
                this.f29756d.setOnPreferenceClickListener(this);
                new b(this).executeOnExecutor(this.f29757e, new Void[0]);
            } else {
                preferenceScreen.removePreference(cOUIPreferenceCategory2);
            }
        }
    }

    public final /* synthetic */ void o1(DialogInterface dialogInterface, int i10) {
        this.f29753a.dismiss();
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g
    public void onCreatePreferences(Bundle bundle, String str) {
        addPreferencesFromResource(R.xml.ted_about_preference);
        n1(getPreferenceScreen());
    }

    @Override // V0.a, com.coui.appcompat.preference.COUIPreferenceFragment, androidx.preference.g, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        K.y0(getListView(), true);
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f29757e.shutdown();
        androidx.appcompat.app.b bVar = this.f29753a;
        if (bVar != null) {
            bVar.dismiss();
            this.f29753a = null;
        }
        androidx.appcompat.app.b bVar2 = this.f29754b;
        if (bVar2 != null) {
            bVar2.dismiss();
            this.f29754b = null;
        }
    }

    public final /* synthetic */ void p1() {
        this.f29755c.e();
        new b(this).executeOnExecutor(this.f29757e, new Void[0]);
    }

    public final /* synthetic */ void q1(Context context) {
        NumberIdentifyUtils.l(context, 0, null, new Runnable() { // from class: g9.o
            @Override // java.lang.Runnable
            public final void run() {
                TedAboutPreferenceFragment.this.p1();
            }
        });
        A.c("withdraw");
    }

    @Override // androidx.preference.Preference.d
    public boolean s0(Preference preference) {
        if ("pref_key_revoke_personal_protection".equals(preference.getKey())) {
            v1();
            return false;
        }
        return false;
    }

    public final /* synthetic */ void s1(final Context context, DialogInterface dialogInterface, int i10) {
        this.f29753a.dismiss();
        final Runnable runnable = new Runnable() { // from class: g9.m
            @Override // java.lang.Runnable
            public final void run() {
                TedAboutPreferenceFragment.this.q1(context);
            }
        };
        if (NumberIdentifyUtils.f15874a.d() && s.d(context) > 0) {
            androidx.appcompat.app.b e10 = k.e(context, new DialogInterface.OnClickListener() { // from class: g9.n
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i11) {
                    runnable.run();
                }
            }, null);
            this.f29754b = e10;
            e10.setOnDismissListener(new a());
            return;
        }
        runnable.run();
    }

    public final /* synthetic */ boolean t1(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 == 4 && keyEvent != null && keyEvent.getAction() == 1) {
            this.f29753a.dismiss();
            return true;
        }
        return false;
    }

    public final /* synthetic */ void u1(DialogInterface dialogInterface) {
        this.f29753a = null;
    }

    public final void v1() {
        if (this.f29753a == null) {
            final Context context = getContext();
            if (context == null) {
                return;
            }
            androidx.appcompat.app.b p10 = k.p(context, context.getString(R.string.title_revoke_personal_information_protection_policy), this.f29755c.b(getContext()), this.f29755c.a(getContext()), R.string.negative_btn_revoke_personal_information_protection_policy, R.string.positive_btn_personal_information_protection_policy, new DialogInterface.OnClickListener() { // from class: g9.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    TedAboutPreferenceFragment.this.o1(dialogInterface, i10);
                }
            }, new DialogInterface.OnClickListener() { // from class: g9.j
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    TedAboutPreferenceFragment.this.s1(context, dialogInterface, i10);
                }
            });
            this.f29753a = p10;
            p10.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: g9.k
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                    boolean t12;
                    t12 = TedAboutPreferenceFragment.this.t1(dialogInterface, i10, keyEvent);
                    return t12;
                }
            });
            this.f29753a.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: g9.l
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    TedAboutPreferenceFragment.this.u1(dialogInterface);
                }
            });
        }
        if (!this.f29753a.isShowing()) {
            this.f29753a.show();
        }
    }

    public final void w1(boolean z10) {
        RevokePreference revokePreference = this.f29756d;
        if (revokePreference != null) {
            revokePreference.setEnabled(z10);
        }
    }
}
