package com.android.contacts;

import android.database.Cursor;
import android.net.Uri;
import android.provider.VoicemailContract;
import com.android.contacts.voicemail.VoicemailStatusHelperImpl;
import com.customize.contacts.util.HandlerC0795f;

/* compiled from: CallDetailVoicemailQueryHandler.java */
/* renamed from: com.android.contacts.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class HandlerC0582c extends HandlerC0795f {

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f13721g = {"source_package", "has_content"};

    /* renamed from: f, reason: collision with root package name */
    public final a f13722f;

    /* compiled from: CallDetailVoicemailQueryHandler.java */
    /* renamed from: com.android.contacts.c$a */
    /* loaded from: classes.dex */
    public interface a {
        void l(Cursor cursor);
    }

    public HandlerC0582c(a aVar) {
        super(ContactsApplication.h().getContentResolver());
        this.f13722f = aVar;
    }

    @Override // com.customize.contacts.util.HandlerC0795f
    public synchronized void e(int i10, Object obj, Cursor cursor) {
        try {
            if (i10 == 101) {
                if (m(cursor) && l(cursor)) {
                    i(102, null, VoicemailContract.Status.buildSourceUri(k(cursor)), VoicemailStatusHelperImpl.d(), null, null, null);
                } else {
                    a aVar = this.f13722f;
                    if (aVar != null) {
                        aVar.l(null);
                    }
                }
            } else if (i10 == 102) {
                a aVar2 = this.f13722f;
                if (aVar2 != null) {
                    aVar2.l(cursor);
                }
            } else {
                H7.b.i("CallDetail", "Unknown query completed: ignoring: ");
            }
            com.oplus.foundation.util.io.e.a(cursor);
        } finally {
        }
    }

    public final String k(Cursor cursor) {
        return cursor.getString(0);
    }

    public final boolean l(Cursor cursor) {
        if (cursor.getInt(1) == 0) {
            return true;
        }
        return false;
    }

    public final boolean m(Cursor cursor) {
        if (cursor != null && cursor.moveToFirst()) {
            return true;
        }
        H7.b.c("CallDetail", "Cursor not valid, could not move to first");
        return false;
    }

    public void n(Uri uri) {
        i(101, null, uri, f13721g, null, null, null);
    }
}
