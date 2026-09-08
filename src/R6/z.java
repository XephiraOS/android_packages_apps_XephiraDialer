package r6;

import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.oplus.utils.C0846g;
import com.oplus.utils.E;
import v6.C1629c;

/* compiled from: IntentProvider.java */
/* loaded from: classes3.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final String f36533a = F6.a.l();

    /* compiled from: IntentProvider.java */
    /* loaded from: classes3.dex */
    public class a extends z {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f36534b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f36535c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f36536d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Uri f36537e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Uri f36538f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f36539g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ long f36540h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f36541i;

        public a(b bVar, int i10, long j10, Uri uri, Uri uri2, String str, long j11, String str2) {
            this.f36534b = bVar;
            this.f36535c = i10;
            this.f36536d = j10;
            this.f36537e = uri;
            this.f36538f = uri2;
            this.f36539g = str;
            this.f36540h = j11;
            this.f36541i = str2;
        }

        @Override // r6.z
        public Intent b(Context context) {
            Uri uri;
            Cursor cursor = this.f36534b.getCursor();
            if (cursor != null && !cursor.isClosed()) {
                cursor.moveToPosition(this.f36535c);
                try {
                    Intent intent = new Intent();
                    long j10 = this.f36536d;
                    if (j10 < 0 && (uri = this.f36537e) != null) {
                        j10 = Long.parseLong(uri.getLastPathSegment());
                        if (C0846g.c()) {
                            Log.d("IntentProvider", "tempContactId = " + j10 + " , contactId = " + this.f36536d);
                        }
                    }
                    if (j10 >= 0) {
                        Uri withAppendedId = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, j10);
                        intent.setPackage(C1629c.f37417c);
                        intent.setAction(z.f36533a);
                        intent.setData(withAppendedId);
                    } else {
                        intent = new Intent("android.intent.action.VIEW");
                        intent.setType("vnd.android.cursor.item/contact");
                        intent.setComponent(new ComponentName(C1629c.f37417c, "com.android.contacts.activities.CallDetailActivity"));
                    }
                    String string = cursor.getString(1);
                    String string2 = cursor.getString(9);
                    if (TextUtils.isEmpty(string2)) {
                        string2 = string;
                    }
                    long j11 = cursor.getInt(12);
                    int i10 = cursor.getInt(4);
                    if (C0846g.c()) {
                        Log.d("IntentProvider", "number = " + C0846g.f(string2) + ", tempContactId = " + j10 + " ,contactUri= " + C0846g.h(this.f36537e) + " ,photoUri = " + this.f36538f + " ,simId = " + j11);
                    }
                    intent.putExtra("simid", j11);
                    intent.putExtra(OplusAutoRedialNotificationUI.TYPE, i10);
                    intent.putExtra("number", string);
                    intent.putExtra("matched_number", string2);
                    intent.putExtra("contact_uri", this.f36537e);
                    intent.putExtra("contact_id", j10);
                    intent.putExtra("name", this.f36539g);
                    intent.putExtra("photo_id", this.f36540h);
                    intent.putExtra("photo_uri", this.f36538f);
                    intent.putExtra("countryiso", this.f36541i);
                    E.a(intent, com.oplus.blacklistapp.u.f27575V, context.getPackageName());
                    return intent;
                } catch (Exception e10) {
                    Log.e("IntentProvider", "Exception: " + e10);
                }
            }
            return null;
        }
    }

    public static z a(b bVar, int i10, Uri uri, long j10, String str, long j11, Uri uri2, String str2) {
        return new a(bVar, i10, j10, uri, uri2, str, j11, str2);
    }

    public abstract Intent b(Context context);
}
