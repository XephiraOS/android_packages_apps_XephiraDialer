package Q3;

import com.customize.contacts.pushnotification.model.PushNotificationScheduler;
import com.customize.contacts.pushnotification.model.h;

/* compiled from: DuplicateContactsRecommender.java */
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ void b() {
        com.customize.contacts.pushnotification.model.c e10;
        h d10 = h.d();
        if (d10 != null && (e10 = d10.e("duplicate contacts")) != null) {
            int n10 = e10.n();
            H7.b.e("DuplicateContactsRecommender", "updateState: current: " + n10);
            if (n10 != 1) {
                PushNotificationScheduler.b.a(e10, n10, 2);
            } else {
                e10.p(System.currentTimeMillis() / 1000);
            }
            e10.q(0L);
            d10.f(e10);
        }
    }

    public static void c() {
        N7.a.a().execute(new Runnable() { // from class: Q3.a
            @Override // java.lang.Runnable
            public final void run() {
                b.b();
            }
        });
    }
}
