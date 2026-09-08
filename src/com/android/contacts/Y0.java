package com.android.contacts;

import android.content.Context;
import android.os.AsyncTask;
import com.android.contacts.ContactLoader;
import com.android.contacts.framework.baseui.sim.SimContactInfo;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: SimContactLoader.java */
/* loaded from: classes.dex */
public class Y0 extends W.c<ContactLoader.Result> {

    /* renamed from: j, reason: collision with root package name */
    public Context f13569j;

    /* renamed from: k, reason: collision with root package name */
    public SimContactInfo f13570k;

    /* renamed from: l, reason: collision with root package name */
    public Executor f13571l;

    /* compiled from: SimContactLoader.java */
    /* loaded from: classes.dex */
    public final class a extends AsyncTask<Void, Void, ContactLoader.Result> {
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ContactLoader.Result doInBackground(Void... voidArr) {
            if (H7.a.b()) {
                H7.b.e("SimContactLoader", "doInBackground: mSimContactInfo = " + Y0.this.f13570k);
            }
            Y0 y02 = Y0.this;
            return y02.G(y02.f13570k);
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(ContactLoader.Result result) {
            Y0.this.f(result);
        }

        public a() {
        }
    }

    public Y0(Context context, SimContactInfo simContactInfo) {
        super(context);
        this.f13569j = context;
        this.f13570k = simContactInfo;
        this.f13571l = Executors.newSingleThreadExecutor();
        F();
    }

    public final void F() {
        new a().executeOnExecutor(this.f13571l, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.android.contacts.ContactLoader.Result G(com.android.contacts.framework.baseui.sim.SimContactInfo r37) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.Y0.G(com.android.contacts.framework.baseui.sim.SimContactInfo):com.android.contacts.ContactLoader$Result");
    }
}
