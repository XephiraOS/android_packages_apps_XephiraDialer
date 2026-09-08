package com.android.contacts.calllog;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.CallLog;
import android.provider.VoicemailContract;
import com.android.contacts.ContactsApplication;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.android.incallui.OplusPhoneUtils;
import com.customize.contacts.util.C0801l;
import com.customize.contacts.util.HandlerC0795f;
import com.oplus.foundation.util.scheduler.ThreadUtilsKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import s1.C1523a;
import w0.C1643c;

/* compiled from: CallLogQueryHandler.java */
/* loaded from: classes.dex */
public class r extends HandlerC0795f {

    /* renamed from: f, reason: collision with root package name */
    public final WeakReference<b> f14024f;

    /* compiled from: CallLogQueryHandler.java */
    /* loaded from: classes.dex */
    public class a extends HandlerC0795f.b {
        public a(Looper looper) {
            super(looper);
        }

        @Override // com.customize.contacts.util.HandlerC0795f.b, android.os.Handler
        public void handleMessage(Message message) {
            try {
                super.handleMessage(message);
            } catch (SQLiteDatabaseCorruptException e10) {
                H7.b.i("CallLogQueryHandler", "Exception on background worker thread" + e10);
            } catch (SQLiteDiskIOException e11) {
                H7.b.i("CallLogQueryHandler", "Exception on background worker thread" + e11);
            } catch (SQLiteFullException e12) {
                H7.b.i("CallLogQueryHandler", "Exception on background worker thread" + e12);
            } catch (RuntimeException e13) {
                H7.b.i("CallLogQueryHandler", "Exception:" + e13);
            } catch (Exception e14) {
                H7.b.i("CallLogQueryHandler", "Exception:" + e14);
            }
        }
    }

    /* compiled from: CallLogQueryHandler.java */
    /* loaded from: classes.dex */
    public interface b {
        void L(Cursor cursor);

        void d(Cursor cursor);
    }

    public r(ContentResolver contentResolver, b bVar) {
        super(contentResolver);
        this.f14024f = new WeakReference<>(bVar);
    }

    public static Uri n() {
        return Uri.parse("content://call_log/" + com.android.contacts.compat.data.f.c("calls_with_normalized")).buildUpon().appendQueryParameter("limit", R0.b.f3167a).build();
    }

    @Override // com.customize.contacts.util.HandlerC0795f
    public Handler d(Looper looper) {
        return new a(looper);
    }

    @Override // com.customize.contacts.util.HandlerC0795f
    public synchronized void e(int i10, Object obj, Cursor cursor) {
        try {
            if (H7.a.b()) {
                H7.b.b("CallLogQueryHandler", "onQueryComplete->token=" + i10);
            }
            if (i10 == 58) {
                u(cursor);
                return;
            }
            if (i10 == 52) {
                t(cursor);
                return;
            }
            H7.b.i("CallLogQueryHandler", "Unknown query completed: ignoring: " + i10);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void m(final Context context) {
        final Context applicationContext = context.getApplicationContext();
        final StringBuilder sb = new StringBuilder();
        final ArrayList arrayList = new ArrayList();
        N7.a.a().execute(new Runnable() { // from class: com.android.contacts.calllog.p
            @Override // java.lang.Runnable
            public final void run() {
                r.this.p(context, applicationContext, sb, arrayList);
            }
        });
    }

    public final /* synthetic */ void o(Context context, StringBuilder sb, List list) {
        if (com.android.contacts.util.w.p(context)) {
            i(58, null, VoicemailContract.Status.CONTENT_URI, s1.t.a(), sb.toString(), (String[]) list.toArray(new String[list.size()]), null);
        }
    }

    public final /* synthetic */ void p(Context context, final Context context2, final StringBuilder sb, final List list) {
        C1523a.b(context).b(context2, sb, list);
        ThreadUtilsKt.d(new Runnable() { // from class: com.android.contacts.calllog.q
            @Override // java.lang.Runnable
            public final void run() {
                r.this.o(context2, sb, list);
            }
        });
    }

    public void q() {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("new", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
        j(56, null, CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, contentValues, "new = 1 AND " + OplusAutoRedialNotificationUI.TYPE + " = ?", new String[]{Integer.toString(4)});
    }

    public void r() {
        c(52);
        String f10 = C0801l.f();
        Uri n10 = n();
        String[] a10 = com.android.contacts.framework.baseui.calllog.d.a();
        if (H7.a.b()) {
            H7.b.b("CallLogQueryHandler", "startQuery, where = " + f10 + ", length = " + a10.length);
        }
        i(52, null, n10, a10, f10, null, null);
    }

    public void s() {
        c(52);
        if (C1643c.q()) {
            Uri parse = Uri.parse("content://call_log/" + com.android.contacts.compat.data.f.c("calls_contact_customized"));
            String[] strArr = com.android.contacts.framework.baseui.calllog.d.f15791g;
            i(52, null, parse, strArr, C1643c.n(ContactsApplication.h(), strArr), null, "date DESC");
            return;
        }
        i(52, null, Uri.parse("content://call_log/" + com.android.contacts.compat.data.f.c("customize_voicemail")), com.android.contacts.framework.baseui.calllog.d.f15791g, null, null, "date DESC");
    }

    public final void t(Cursor cursor) {
        if (H7.a.b()) {
            H7.b.b("CallLogQueryHandler", "updateAdapterData");
        }
        b bVar = this.f14024f.get();
        if (bVar != null) {
            bVar.d(cursor);
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public final void u(Cursor cursor) {
        b bVar = this.f14024f.get();
        if (bVar != null) {
            bVar.L(cursor);
        } else if (cursor != null) {
            cursor.close();
        }
    }
}
