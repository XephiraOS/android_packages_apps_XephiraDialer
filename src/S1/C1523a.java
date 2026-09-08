package s1;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.android.contacts.voicemail.SharedPrefConfigProvider;

/* compiled from: ComponentUtils.java */
/* renamed from: s1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1523a {

    /* renamed from: a, reason: collision with root package name */
    public static o f36623a;

    /* renamed from: b, reason: collision with root package name */
    public static InterfaceC1524b f36624b;

    /* renamed from: c, reason: collision with root package name */
    public static SharedPreferences f36625c;

    public static synchronized InterfaceC1524b a(Context context) {
        synchronized (C1523a.class) {
            InterfaceC1524b interfaceC1524b = f36624b;
            if (interfaceC1524b != null) {
                return interfaceC1524b;
            }
            SharedPrefConfigProvider sharedPrefConfigProvider = new SharedPrefConfigProvider(context);
            f36624b = sharedPrefConfigProvider;
            return sharedPrefConfigProvider;
        }
    }

    public static synchronized o b(Context context) {
        synchronized (C1523a.class) {
            o oVar = f36623a;
            if (oVar != null) {
                return oVar;
            }
            if (!r.b(context)) {
                H7.b.e("VoicemailModule.provideVoicemailClient", "missing permissions " + r.a(context));
                h hVar = new h();
                f36623a = hVar;
                return hVar;
            }
            H7.b.e("VoicemailModule.provideVoicemailClient", "providing VoicemailClientImpl");
            t1.h hVar2 = new t1.h();
            f36623a = hVar2;
            return hVar2;
        }
    }

    public static synchronized SharedPreferences c(Context context) {
        synchronized (C1523a.class) {
            SharedPreferences sharedPreferences = f36625c;
            if (sharedPreferences != null) {
                return sharedPreferences;
            }
            Context createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            if (createDeviceProtectedStorageContext != null) {
                context = createDeviceProtectedStorageContext;
            }
            return PreferenceManager.getDefaultSharedPreferences(context);
        }
    }
}
