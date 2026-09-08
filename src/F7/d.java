package f7;

import android.os.IBinder;
import android.os.RemoteException;
import com.oplus.utils.C0864z;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BinderCache.java */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public static volatile d f31776b;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, IBinder> f31777a = new HashMap();

    public static d c() {
        if (f31776b == null) {
            synchronized (d.class) {
                try {
                    if (f31776b == null) {
                        f31776b = new d();
                    }
                } finally {
                }
            }
        }
        return f31776b;
    }

    public IBinder b(String str) {
        return this.f31777a.get(str);
    }

    public final /* synthetic */ void d(String str) {
        this.f31777a.remove(str);
        C0864z.d("Epona->BinderCache", "unregister cached binder： " + str, new Object[0]);
    }

    public void e(final String str, IBinder iBinder) {
        this.f31777a.put(str, iBinder);
        try {
            iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: f7.c
                @Override // android.os.IBinder.DeathRecipient
                public final void binderDied() {
                    d.this.d(str);
                }
            }, 0);
        } catch (RemoteException e10) {
            C0864z.i("Epona->BinderCache", e10.toString(), new Object[0]);
        }
    }
}
