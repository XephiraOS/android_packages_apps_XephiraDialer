package B1;

import android.content.Context;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.util.ArraySet;
import com.oplus.foundation.util.scheduler.ThreadUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: VvmAccountManager.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static Set<c> f228a = new ArraySet();

    /* compiled from: VvmAccountManager.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhoneAccountHandle f229a;

        public a(PhoneAccountHandle phoneAccountHandle) {
            this.f229a = phoneAccountHandle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = b.f228a.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(this.f229a, true);
            }
        }
    }

    /* compiled from: VvmAccountManager.java */
    /* renamed from: B1.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0002b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhoneAccountHandle f230a;

        public RunnableC0002b(PhoneAccountHandle phoneAccountHandle) {
            this.f230a = phoneAccountHandle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = b.f228a.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(this.f230a, true);
            }
        }
    }

    /* compiled from: VvmAccountManager.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(PhoneAccountHandle phoneAccountHandle, boolean z10);
    }

    public static void b(Context context, PhoneAccountHandle phoneAccountHandle, A1.e eVar) {
        eVar.i(new D1.c(context, phoneAccountHandle).d()).a();
        h(context, phoneAccountHandle, true);
        ThreadUtilsKt.d(new a(phoneAccountHandle));
    }

    public static List<PhoneAccountHandle> c(Context context) {
        ArrayList arrayList = new ArrayList();
        for (PhoneAccountHandle phoneAccountHandle : ((TelecomManager) context.getSystemService(TelecomManager.class)).getCallCapablePhoneAccounts()) {
            if (e(context, phoneAccountHandle)) {
                arrayList.add(phoneAccountHandle);
            }
        }
        return arrayList;
    }

    public static D1.b d(Context context, PhoneAccountHandle phoneAccountHandle) {
        return new D1.b(context, phoneAccountHandle, C1.d.a(context));
    }

    public static boolean e(Context context, PhoneAccountHandle phoneAccountHandle) {
        if (phoneAccountHandle == null) {
            return false;
        }
        D1.b d10 = d(context, phoneAccountHandle);
        f(context, d10, phoneAccountHandle);
        return d10.e("is_account_activated", false);
    }

    public static void f(Context context, D1.b bVar, PhoneAccountHandle phoneAccountHandle) {
        try {
            if (!P7.e.d(context) || bVar.c("is_account_activated")) {
                return;
            }
            bVar.d().b("is_account_activated", new D1.c(context, phoneAccountHandle).e("is_account_activated", false)).a();
        } catch (Exception e10) {
            C1.a.b("VvmAccountManager", "VvmAccountManager migrateActivationState " + e10);
        }
    }

    public static void g(Context context, PhoneAccountHandle phoneAccountHandle) {
        com.android.contacts.voicemail.impl.c.b(context, phoneAccountHandle);
        h(context, phoneAccountHandle, false);
        new D1.c(context, phoneAccountHandle).d().c("u", null).c("pw", null).a();
        ThreadUtilsKt.d(new RunnableC0002b(phoneAccountHandle));
    }

    public static void h(Context context, PhoneAccountHandle phoneAccountHandle, boolean z10) {
        if (phoneAccountHandle != null) {
            d(context, phoneAccountHandle).d().b("is_account_activated", z10).a();
        }
    }
}
