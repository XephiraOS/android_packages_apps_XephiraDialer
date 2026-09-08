package com.android.contacts;

import W.c;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.android.contacts.ContactLoader;

/* loaded from: classes.dex */
public class ViewNotificationService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13560a = "ViewNotificationService";

    /* loaded from: classes.dex */
    public class a implements c.InterfaceC0078c<ContactLoader.Result> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13561a;

        public a(int i10) {
            this.f13561a = i10;
        }

        @Override // W.c.InterfaceC0078c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void t(W.c<ContactLoader.Result> cVar, ContactLoader.Result result) {
            try {
                cVar.w();
            } catch (RuntimeException e10) {
                H7.b.c(ViewNotificationService.f13560a, "Error reseting loader" + e10);
            }
            try {
                ViewNotificationService.this.stopSelfResult(this.f13561a);
            } catch (RuntimeException e11) {
                H7.b.c(ViewNotificationService.f13560a, "Error stopping service" + e11);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        ContactLoader contactLoader = new ContactLoader(this, intent.getData());
        contactLoader.u(0, new a(i11));
        contactLoader.y();
        return 3;
    }
}
