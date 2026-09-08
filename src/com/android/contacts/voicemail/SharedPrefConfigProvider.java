package com.android.contacts.voicemail;

import C1.d;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import s1.InterfaceC1524b;

/* loaded from: classes.dex */
public class SharedPrefConfigProvider implements InterfaceC1524b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f17777a;

    /* loaded from: classes.dex */
    public static class Service extends IntentService {
        public Service() {
            super("SharedPrefConfigProvider.Service");
        }

        public final void a(String str, Object obj) {
            SharedPreferences.Editor edit = SharedPrefConfigProvider.f(getApplicationContext()).edit();
            String str2 = "config_provider_prefs_" + str;
            if (obj instanceof Boolean) {
                edit.putBoolean(str2, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Long) {
                edit.putLong(str2, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                edit.putString(str2, (String) obj);
            } else {
                C1.a.b("SharedPrefConfigProvider", "unsupported extra type: " + obj.getClass());
            }
            edit.apply();
        }

        @Override // android.app.IntentService
        public void onHandleIntent(Intent intent) {
            if (intent != null && intent.getExtras() != null && intent.getExtras().size() == 1) {
                String next = intent.getExtras().keySet().iterator().next();
                a(next, intent.getExtras().get(next));
            } else {
                C1.a.f("SharedPrefConfigProvider.Service.onHandleIntent", "must set exactly one extra");
            }
        }
    }

    /* loaded from: classes.dex */
    public class a implements c<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17778a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17779b;

        public a(String str, String str2) {
            this.f17778a = str;
            this.f17779b = str2;
        }

        @Override // com.android.contacts.voicemail.SharedPrefConfigProvider.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String get() {
            return SharedPrefConfigProvider.f(SharedPrefConfigProvider.this.f17777a).getString("config_provider_prefs_" + this.f17778a, this.f17779b);
        }
    }

    /* loaded from: classes.dex */
    public class b implements c<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17781a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f17782b;

        public b(String str, boolean z10) {
            this.f17781a = str;
            this.f17782b = z10;
        }

        @Override // com.android.contacts.voicemail.SharedPrefConfigProvider.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean get() {
            return Boolean.valueOf(SharedPrefConfigProvider.f(SharedPrefConfigProvider.this.f17777a).getBoolean("config_provider_prefs_" + this.f17781a, this.f17782b));
        }
    }

    /* loaded from: classes.dex */
    public interface c<T> {
        T get();
    }

    public SharedPrefConfigProvider(Context context) {
        this.f17777a = context;
    }

    public static <T> T e(c<T> cVar) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return cVar.get();
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public static SharedPreferences f(Context context) {
        return d.a(context);
    }

    @Override // s1.InterfaceC1524b
    public boolean a(String str, boolean z10) {
        return ((Boolean) e(new b(str, z10))).booleanValue();
    }

    @Override // s1.InterfaceC1524b
    public String b(String str, String str2) {
        return (String) e(new a(str, str2));
    }
}
