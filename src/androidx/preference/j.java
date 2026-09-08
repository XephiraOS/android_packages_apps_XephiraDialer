package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: PreferenceManager.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10608a;

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences f10610c;

    /* renamed from: d, reason: collision with root package name */
    public SharedPreferences.Editor f10611d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10612e;

    /* renamed from: f, reason: collision with root package name */
    public String f10613f;

    /* renamed from: g, reason: collision with root package name */
    public int f10614g;

    /* renamed from: i, reason: collision with root package name */
    public PreferenceScreen f10616i;

    /* renamed from: j, reason: collision with root package name */
    public c f10617j;

    /* renamed from: k, reason: collision with root package name */
    public a f10618k;

    /* renamed from: l, reason: collision with root package name */
    public b f10619l;

    /* renamed from: b, reason: collision with root package name */
    public long f10609b = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f10615h = 0;

    /* compiled from: PreferenceManager.java */
    /* loaded from: classes.dex */
    public interface a {
        void onDisplayPreferenceDialog(Preference preference);
    }

    /* compiled from: PreferenceManager.java */
    /* loaded from: classes.dex */
    public interface b {
        void onNavigateToScreen(PreferenceScreen preferenceScreen);
    }

    /* compiled from: PreferenceManager.java */
    /* loaded from: classes.dex */
    public interface c {
        boolean onPreferenceTreeClick(Preference preference);
    }

    /* compiled from: PreferenceManager.java */
    /* loaded from: classes.dex */
    public static abstract class d {
    }

    public j(Context context) {
        this.f10608a = context;
        s(d(context));
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences(d(context), c());
    }

    public static int c() {
        return 0;
    }

    public static String d(Context context) {
        return context.getPackageName() + "_preferences";
    }

    public <T extends Preference> T a(CharSequence charSequence) {
        PreferenceScreen preferenceScreen = this.f10616i;
        if (preferenceScreen == null) {
            return null;
        }
        return (T) preferenceScreen.findPreference(charSequence);
    }

    public SharedPreferences.Editor e() {
        if (this.f10612e) {
            if (this.f10611d == null) {
                this.f10611d = l().edit();
            }
            return this.f10611d;
        }
        return l().edit();
    }

    public long f() {
        long j10;
        synchronized (this) {
            j10 = this.f10609b;
            this.f10609b = 1 + j10;
        }
        return j10;
    }

    public b g() {
        return this.f10619l;
    }

    public c h() {
        return this.f10617j;
    }

    public d i() {
        return null;
    }

    public e j() {
        return null;
    }

    public PreferenceScreen k() {
        return this.f10616i;
    }

    public SharedPreferences l() {
        Context b10;
        j();
        if (this.f10610c == null) {
            if (this.f10615h != 1) {
                b10 = this.f10608a;
            } else {
                b10 = androidx.core.content.b.b(this.f10608a);
            }
            this.f10610c = b10.getSharedPreferences(this.f10613f, this.f10614g);
        }
        return this.f10610c;
    }

    public PreferenceScreen m(Context context, int i10, PreferenceScreen preferenceScreen) {
        n(true);
        PreferenceScreen preferenceScreen2 = (PreferenceScreen) new i(context, this).d(i10, preferenceScreen);
        preferenceScreen2.onAttachedToHierarchy(this);
        n(false);
        return preferenceScreen2;
    }

    public final void n(boolean z10) {
        SharedPreferences.Editor editor;
        if (!z10 && (editor = this.f10611d) != null) {
            editor.apply();
        }
        this.f10612e = z10;
    }

    public void o(a aVar) {
        this.f10618k = aVar;
    }

    public void p(b bVar) {
        this.f10619l = bVar;
    }

    public void q(c cVar) {
        this.f10617j = cVar;
    }

    public boolean r(PreferenceScreen preferenceScreen) {
        PreferenceScreen preferenceScreen2 = this.f10616i;
        if (preferenceScreen != preferenceScreen2) {
            if (preferenceScreen2 != null) {
                preferenceScreen2.onDetached();
            }
            this.f10616i = preferenceScreen;
            return true;
        }
        return false;
    }

    public void s(String str) {
        this.f10613f = str;
        this.f10610c = null;
    }

    public boolean t() {
        return !this.f10612e;
    }

    public void u(Preference preference) {
        a aVar = this.f10618k;
        if (aVar != null) {
            aVar.onDisplayPreferenceDialog(preference);
        }
    }
}
