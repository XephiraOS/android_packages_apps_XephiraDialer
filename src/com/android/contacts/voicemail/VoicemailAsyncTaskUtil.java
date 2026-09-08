package com.android.contacts.voicemail;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.android.contacts.calllog.CallLogNotificationsService;
import com.android.contacts.util.C0703d;
import com.android.contacts.util.InterfaceC0702c;
import com.android.incallui.OplusPhoneUtils;

/* loaded from: classes.dex */
public class VoicemailAsyncTaskUtil {

    /* renamed from: a, reason: collision with root package name */
    public static InterfaceC0702c f17815a;

    /* loaded from: classes.dex */
    public enum Tasks {
        DELETE_VOICEMAIL,
        MARK_VOICEMAIL_READ
    }

    /* loaded from: classes.dex */
    public class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f17819a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f17820b;

        public a(Context context, Uri uri) {
            this.f17819a = context;
            this.f17820b = uri;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_read", Boolean.TRUE);
            contentValues.put("dirty", (Integer) 1);
            if (this.f17819a.getContentResolver().update(this.f17820b, contentValues, "is_read = 0", null) > 0) {
                VoicemailAsyncTaskUtil.f(this.f17819a);
            }
            VoicemailAsyncTaskUtil.d(this.f17819a);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f17821a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f17822b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f17823c;

        public b(Context context, Uri uri, c cVar) {
            this.f17821a = context;
            this.f17822b = uri;
            this.f17823c = cVar;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            VoicemailAsyncTaskUtil.b(this.f17821a, this.f17822b);
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            c cVar = this.f17823c;
            if (cVar != null) {
                cVar.g();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void g();
    }

    public static void a(Context context, Uri uri, c cVar) {
        if (f17815a == null) {
            c();
        }
        f17815a.a(Tasks.DELETE_VOICEMAIL, new b(context, uri, cVar), new Void[0]);
    }

    public static void b(Context context, Uri uri) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("deleted", OplusPhoneUtils.DeviceState.LOCK_DEVICE);
        context.getContentResolver().update(uri, contentValues, null, null);
        f(context);
    }

    public static void c() {
        f17815a = C0703d.c();
    }

    public static void d(Context context) {
        Intent intent = new Intent(context, (Class<?>) CallLogNotificationsService.class);
        intent.setAction("com.android.contacts.calllog.ACTION_MARK_NEW_VOICEMAILS_AS_OLD");
        context.startService(intent);
    }

    public static void e(Context context, Uri uri) {
        if (f17815a == null) {
            c();
        }
        f17815a.a(Tasks.MARK_VOICEMAIL_READ, new a(context, uri), new Void[0]);
    }

    public static void f(Context context) {
        Intent intent = new Intent("com.android.voicemail.VoicemailClient.ACTION_UPLOAD");
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }
}
