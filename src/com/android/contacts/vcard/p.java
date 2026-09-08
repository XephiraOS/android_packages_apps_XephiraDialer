package com.android.contacts.vcard;

import android.app.Activity;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.android.contacts.framework.vcard.VCardEntry;
import com.oplus.dialer.R;

/* compiled from: NotificationImportExportListener.java */
/* loaded from: classes.dex */
public class p implements s, Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f17775a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f17776b = new Handler(this);

    public p(Activity activity) {
        this.f17775a = activity;
    }

    @Override // com.android.contacts.vcard.s
    public void H(f fVar) {
        this.f17776b.obtainMessage(0, this.f17775a.getString(R.string.vcard_export_request_rejected_message)).sendToTarget();
    }

    @Override // com.android.contacts.vcard.s
    public void O(k kVar, int i10, int i11) {
        String string;
        String str = kVar.f17770d;
        if (str != null) {
            string = this.f17775a.getString(R.string.vcard_will_start_importing_reminders, str);
        } else {
            this.f17775a.getString(R.string.vcard_unknown_filename);
            string = this.f17775a.getString(R.string.file_will_imported_later);
        }
        if (i11 == 0) {
            this.f17776b.obtainMessage(0, string).sendToTarget();
        }
    }

    @Override // com.android.contacts.vcard.s
    public void f(k kVar, int i10, VCardEntry vCardEntry, int i11, int i12) {
        vCardEntry.j0();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.oplus.foundation.util.ui.c.c(this.f17775a, (String) message.obj);
        return true;
    }

    @Override // com.android.contacts.vcard.s
    public void y(k kVar) {
        this.f17776b.obtainMessage(0, this.f17775a.getString(R.string.vcard_import_denied_try_again_later)).sendToTarget();
    }

    @Override // com.android.contacts.vcard.s
    public void A(k kVar, int i10) {
    }

    @Override // com.android.contacts.vcard.s
    public void N(f fVar, int i10) {
    }

    @Override // com.android.contacts.vcard.s
    public void b(c cVar, int i10) {
    }

    @Override // com.android.contacts.vcard.s
    public void M(k kVar, int i10, Uri uri) {
    }
}
