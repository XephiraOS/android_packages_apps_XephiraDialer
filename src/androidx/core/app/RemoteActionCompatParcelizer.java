package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import k0.AbstractC1206a;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC1206a abstractC1206a) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f9359a = (IconCompat) abstractC1206a.v(remoteActionCompat.f9359a, 1);
        remoteActionCompat.f9360b = abstractC1206a.l(remoteActionCompat.f9360b, 2);
        remoteActionCompat.f9361c = abstractC1206a.l(remoteActionCompat.f9361c, 3);
        remoteActionCompat.f9362d = (PendingIntent) abstractC1206a.r(remoteActionCompat.f9362d, 4);
        remoteActionCompat.f9363e = abstractC1206a.h(remoteActionCompat.f9363e, 5);
        remoteActionCompat.f9364f = abstractC1206a.h(remoteActionCompat.f9364f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC1206a abstractC1206a) {
        abstractC1206a.x(false, false);
        abstractC1206a.M(remoteActionCompat.f9359a, 1);
        abstractC1206a.D(remoteActionCompat.f9360b, 2);
        abstractC1206a.D(remoteActionCompat.f9361c, 3);
        abstractC1206a.H(remoteActionCompat.f9362d, 4);
        abstractC1206a.z(remoteActionCompat.f9363e, 5);
        abstractC1206a.z(remoteActionCompat.f9364f, 6);
    }
}
