package o1;

import R0.c;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.customize.contacts.util.K;
import com.oplus.dialer.R;

/* compiled from: ContactsPreferences.java */
/* renamed from: o1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1393c extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public Context f35681a;

    /* renamed from: b, reason: collision with root package name */
    public int f35682b;

    /* renamed from: c, reason: collision with root package name */
    public int f35683c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f35684d;

    /* renamed from: e, reason: collision with root package name */
    public b f35685e;

    /* renamed from: f, reason: collision with root package name */
    public Handler f35686f;

    /* compiled from: ContactsPreferences.java */
    /* renamed from: o1.c$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1393c.this.f35682b = -1;
            C1393c.this.f35683c = -1;
            C1393c.this.f35684d = null;
            if (C1393c.this.f35685e != null) {
                C1393c.this.f35685e.onChange();
            }
        }
    }

    /* compiled from: ContactsPreferences.java */
    /* renamed from: o1.c$b */
    /* loaded from: classes.dex */
    public interface b {
        void onChange();
    }

    public C1393c(Context context) {
        super(null);
        this.f35682b = -1;
        this.f35683c = -1;
        this.f35684d = null;
        this.f35685e = null;
        this.f35681a = context.getApplicationContext();
        this.f35686f = new Handler();
    }

    public final int e() {
        if (this.f35681a.getResources().getBoolean(R.bool.config_default_display_order_primary)) {
            return 1;
        }
        return 2;
    }

    public final int f() {
        if (this.f35681a.getResources().getBoolean(R.bool.config_default_sort_order_primary)) {
            return 1;
        }
        return 2;
    }

    public int g() {
        if (!i()) {
            return e();
        }
        if (this.f35683c == -1) {
            int e10 = e();
            try {
                this.f35683c = G0.c.d(this.f35681a, 0, "android.contacts.DISPLAY_ORDER", e10);
            } catch (Exception unused) {
                this.f35683c = e10;
            }
        }
        return this.f35683c;
    }

    public int h() {
        if (!k()) {
            return f();
        }
        if (this.f35682b == -1) {
            int f10 = f();
            try {
                this.f35682b = G0.c.d(this.f35681a, 0, "android.contacts.SORT_ORDER", f10);
            } catch (Exception unused) {
                this.f35682b = f10;
            }
        }
        return this.f35682b;
    }

    public final boolean i() {
        if (this.f35681a.getResources().getBoolean(R.bool.config_display_order_user_changeable) || this.f35681a.getResources().getInteger(R.integer.product_flavor) == 1) {
            return true;
        }
        return false;
    }

    public boolean j() {
        boolean z10 = true;
        if (!K.f()) {
            return true;
        }
        if (this.f35684d == null) {
            try {
                if (G0.c.d(this.f35681a, 1, c.a.f3198d, 1) != 1) {
                    z10 = false;
                }
            } catch (Exception e10) {
                H7.b.c("ContactsPreferences", "Exception e: " + e10);
            }
            this.f35684d = Boolean.valueOf(z10);
        }
        return this.f35684d.booleanValue();
    }

    public final boolean k() {
        if (this.f35681a.getResources().getBoolean(R.bool.config_sort_order_user_changeable) || this.f35681a.getResources().getInteger(R.integer.product_flavor) == 1) {
            return true;
        }
        return false;
    }

    public void l(b bVar) {
        if (this.f35685e != null) {
            p();
        }
        this.f35685e = bVar;
        this.f35683c = -1;
        this.f35682b = -1;
        this.f35684d = null;
        ContentResolver contentResolver = this.f35681a.getContentResolver();
        contentResolver.registerContentObserver(Settings.System.getUriFor("android.contacts.SORT_ORDER"), false, this);
        contentResolver.registerContentObserver(Settings.System.getUriFor("android.contacts.DISPLAY_ORDER"), false, this);
        if (K.f()) {
            contentResolver.registerContentObserver(G0.c.m(1, c.a.f3198d, 2), false, this);
        }
    }

    public void m(int i10) {
        this.f35683c = i10;
        G0.c.n(this.f35681a, 0, "android.contacts.DISPLAY_ORDER", i10);
    }

    public void n(boolean z10) {
        this.f35684d = Boolean.valueOf(z10);
        try {
            G0.c.n(this.f35681a, 1, c.a.f3198d, z10 ? 1 : 0);
        } catch (Exception e10) {
            H7.b.c("ContactsPreferences", "setKanaSortEnable Exception e: " + e10);
        }
    }

    public void o(int i10) {
        this.f35682b = i10;
        G0.c.n(this.f35681a, 0, "android.contacts.SORT_ORDER", i10);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        this.f35686f.post(new a());
    }

    public void p() {
        try {
            this.f35681a.getContentResolver().unregisterContentObserver(this);
        } catch (Exception e10) {
            H7.b.c("ContactsPreferences", "unregisterContentObserver: " + e10);
        }
        this.f35685e = null;
    }
}
