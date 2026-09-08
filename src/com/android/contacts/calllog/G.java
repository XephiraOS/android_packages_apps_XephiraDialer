package com.android.contacts.calllog;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.provider.ContactsContract;
import com.android.contacts.activities.CallDetailActivity;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.android.incallui.OplusPhoneUtils;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import java.io.Serializable;
import w0.C1641a;

/* compiled from: IntentProvider.java */
/* loaded from: classes.dex */
public abstract class G {

    /* compiled from: IntentProvider.java */
    /* loaded from: classes.dex */
    public class a extends G {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13803a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f13804b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f13805c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f13806d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f13807e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f13808f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f13809g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ long f13810h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Uri f13811i;

        public a(String str, String str2, String str3, String str4, int i10, int i11, boolean z10, long j10, Uri uri) {
            this.f13803a = str;
            this.f13804b = str2;
            this.f13805c = str3;
            this.f13806d = str4;
            this.f13807e = i10;
            this.f13808f = i11;
            this.f13809g = z10;
            this.f13810h = j10;
            this.f13811i = uri;
        }

        @Override // com.android.contacts.calllog.G
        public Intent b(Context context) {
            Intent intent = new Intent(context, (Class<?>) CallDetailActivity.class);
            intent.putExtra("EXTRA_VOICEMAIL_START_PLAYBACK", false);
            intent.putExtra("number", this.f13803a);
            intent.putExtra(BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, this.f13804b);
            intent.putExtra("person_id", (Serializable) 0L);
            intent.putExtra("IsFromCalllogSearch", true);
            intent.putExtra("countryiso", this.f13805c);
            intent.putExtra("has_recognized", this.f13806d);
            if (CommonOSPublicFeature.h()) {
                intent.putExtra("simid", Long.valueOf(this.f13807e));
                intent.putExtra("roam_call_type", this.f13808f);
            }
            intent.putExtra("isServiceNumber", this.f13809g);
            if (C1641a.k(this.f13810h)) {
                intent.putExtra("contact_id", this.f13810h);
                intent.setData(this.f13811i);
            }
            intent.putExtra("from_dialer", true);
            return intent;
        }
    }

    /* compiled from: IntentProvider.java */
    /* loaded from: classes.dex */
    public class b extends G {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f13812a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f13813b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f13814c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Uri f13815d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f13816e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f13817f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f13818g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f13819h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ long f13820i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ boolean f13821j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ boolean f13822k;

        public b(k kVar, int i10, long j10, Uri uri, String str, String str2, boolean z10, int i11, long j11, boolean z11, boolean z12) {
            this.f13812a = kVar;
            this.f13813b = i10;
            this.f13814c = j10;
            this.f13815d = uri;
            this.f13816e = str;
            this.f13817f = str2;
            this.f13818g = z10;
            this.f13819h = i11;
            this.f13820i = j11;
            this.f13821j = z11;
            this.f13822k = z12;
        }

        @Override // com.android.contacts.calllog.G
        public Intent b(Context context) {
            int i10;
            Uri uri;
            Uri uri2;
            Cursor q10 = this.f13812a.q();
            if (q10 != null && !q10.isClosed()) {
                q10.moveToPosition(this.f13813b);
                try {
                    Intent intent = new Intent(context, (Class<?>) CallDetailActivity.class);
                    long j10 = this.f13814c;
                    if (j10 < 0 && (uri2 = this.f13815d) != null) {
                        String lastPathSegment = uri2.getLastPathSegment();
                        if (lastPathSegment != null) {
                            try {
                                j10 = Long.parseLong(lastPathSegment);
                            } catch (Exception unused) {
                                j10 = -1;
                            }
                        }
                        if (H7.a.b()) {
                            H7.b.b("IntentProvider", "tempContactId = " + j10 + " , contactId = " + this.f13814c);
                        }
                    }
                    if (j10 >= 0) {
                        if (!C1641a.k(j10)) {
                            uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, j10);
                        } else {
                            uri = this.f13815d;
                        }
                        intent.setData(uri);
                    }
                    String string = q10.getString(5);
                    if (string != null) {
                        intent.putExtra("EXTRA_VOICEMAIL_URI", Uri.parse(string));
                    }
                    intent.putExtra("EXTRA_VOICEMAIL_START_PLAYBACK", false);
                    String string2 = q10.getString(1);
                    String string3 = q10.getString(9);
                    if (H7.a.b()) {
                        H7.b.b("IntentProvider", "number = " + H7.a.d(string2) + ", tempContactId = " + j10);
                    }
                    if (B3.a.i()) {
                        long j11 = q10.getInt(12);
                        if (H7.a.b()) {
                            H7.b.b("IntentProvider", "simId = " + j11);
                        }
                        intent.putExtra("simid", j11);
                        if (q10.getInt(4) != 2 && CommonOSPublicFeature.h()) {
                            intent.putExtra("roam_call_type", q10.getInt(19));
                        }
                    }
                    int i11 = q10.getInt(4);
                    String string4 = q10.getString(17);
                    intent.putExtra(OplusAutoRedialNotificationUI.TYPE, i11);
                    intent.putExtra("number", string2);
                    intent.putExtra(BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, string3);
                    intent.putExtra("contact_uri", this.f13815d);
                    intent.putExtra("contact_id", j10);
                    intent.putExtra("name", this.f13816e);
                    intent.putExtra("countryiso", this.f13817f);
                    intent.putExtra("has_recognized", string4);
                    if (this.f13818g) {
                        i10 = 1;
                        intent.putExtra("from_calllog", true);
                    } else {
                        i10 = 1;
                    }
                    int i12 = this.f13819h;
                    if (i12 > i10) {
                        long[] jArr = new long[i12];
                        for (int i13 = 0; i13 < this.f13819h; i13++) {
                            jArr[i13] = q10.getLong(0);
                            q10.moveToNext();
                        }
                        q10.moveToPosition(this.f13813b);
                        intent.putExtra("EXTRA_CALL_LOG_IDS", jArr);
                    } else if (string != null && j10 < 0) {
                        intent.setData(ContentUris.withAppendedId(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, this.f13820i));
                    }
                    intent.putExtra("from_dialer", true);
                    intent.putExtra("isSpecialNumber", this.f13821j);
                    intent.putExtra("isServiceNumber", this.f13822k);
                    return intent;
                } catch (Exception e10) {
                    H7.b.c("IntentProvider", "Exception: " + e10);
                }
            }
            return null;
        }
    }

    /* compiled from: IntentProvider.java */
    /* loaded from: classes.dex */
    public class c extends G {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13823a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f13824b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f13825c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f13826d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f13827e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f13828f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f13829g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f13830h;

        public c(String str, String str2, int i10, boolean z10, int i11, int i12, int i13, int i14) {
            this.f13823a = str;
            this.f13824b = str2;
            this.f13825c = i10;
            this.f13826d = z10;
            this.f13827e = i11;
            this.f13828f = i12;
            this.f13829g = i13;
            this.f13830h = i14;
        }

        @Override // com.android.contacts.calllog.G
        public Intent b(Context context) {
            Intent intent = new Intent(context, (Class<?>) CallDetailActivity.class);
            intent.putExtra("number", this.f13823a);
            intent.putExtra("IsFromCalllogSearch", true);
            intent.putExtra("name", this.f13824b);
            intent.putExtra("simid", Long.valueOf(this.f13825c));
            intent.putExtra("isSpecialNumber", this.f13826d);
            intent.putExtra("position", this.f13827e);
            intent.putExtra("state", this.f13828f);
            intent.putExtra("start_position", this.f13829g);
            intent.putExtra("search_type", this.f13830h);
            return intent;
        }
    }

    /* compiled from: IntentProvider.java */
    /* loaded from: classes.dex */
    public class d extends G {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f13831a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f13832b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f13833c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f13834d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f13835e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Uri f13836f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f13837g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ long f13838h;

        public d(String str, String str2, String str3, int i10, long j10, Uri uri, String str4, long j11) {
            this.f13831a = str;
            this.f13832b = str2;
            this.f13833c = str3;
            this.f13834d = i10;
            this.f13835e = j10;
            this.f13836f = uri;
            this.f13837g = str4;
            this.f13838h = j11;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x009e A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, blocks: (B:13:0x005e, B:17:0x006a, B:18:0x0072, B:19:0x0084, B:21:0x0090, B:23:0x0096, B:25:0x009e, B:27:0x00a6, B:28:0x00ac, B:30:0x00bc, B:32:0x00c2, B:35:0x00d2, B:37:0x00dd, B:38:0x00ca, B:42:0x00fb, B:44:0x0103, B:46:0x0107, B:52:0x010d, B:48:0x0114, B:50:0x011a, B:57:0x014a, B:59:0x0150, B:61:0x0156, B:63:0x015e, B:64:0x0168, B:65:0x017b, B:69:0x0070, B:72:0x007b, B:73:0x0080, B:74:0x007e), top: B:12:0x005e }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00ac A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, blocks: (B:13:0x005e, B:17:0x006a, B:18:0x0072, B:19:0x0084, B:21:0x0090, B:23:0x0096, B:25:0x009e, B:27:0x00a6, B:28:0x00ac, B:30:0x00bc, B:32:0x00c2, B:35:0x00d2, B:37:0x00dd, B:38:0x00ca, B:42:0x00fb, B:44:0x0103, B:46:0x0107, B:52:0x010d, B:48:0x0114, B:50:0x011a, B:57:0x014a, B:59:0x0150, B:61:0x0156, B:63:0x015e, B:64:0x0168, B:65:0x017b, B:69:0x0070, B:72:0x007b, B:73:0x0080, B:74:0x007e), top: B:12:0x005e }] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00dd A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, blocks: (B:13:0x005e, B:17:0x006a, B:18:0x0072, B:19:0x0084, B:21:0x0090, B:23:0x0096, B:25:0x009e, B:27:0x00a6, B:28:0x00ac, B:30:0x00bc, B:32:0x00c2, B:35:0x00d2, B:37:0x00dd, B:38:0x00ca, B:42:0x00fb, B:44:0x0103, B:46:0x0107, B:52:0x010d, B:48:0x0114, B:50:0x011a, B:57:0x014a, B:59:0x0150, B:61:0x0156, B:63:0x015e, B:64:0x0168, B:65:0x017b, B:69:0x0070, B:72:0x007b, B:73:0x0080, B:74:0x007e), top: B:12:0x005e }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x011a A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, blocks: (B:13:0x005e, B:17:0x006a, B:18:0x0072, B:19:0x0084, B:21:0x0090, B:23:0x0096, B:25:0x009e, B:27:0x00a6, B:28:0x00ac, B:30:0x00bc, B:32:0x00c2, B:35:0x00d2, B:37:0x00dd, B:38:0x00ca, B:42:0x00fb, B:44:0x0103, B:46:0x0107, B:52:0x010d, B:48:0x0114, B:50:0x011a, B:57:0x014a, B:59:0x0150, B:61:0x0156, B:63:0x015e, B:64:0x0168, B:65:0x017b, B:69:0x0070, B:72:0x007b, B:73:0x0080, B:74:0x007e), top: B:12:0x005e }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0156 A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, blocks: (B:13:0x005e, B:17:0x006a, B:18:0x0072, B:19:0x0084, B:21:0x0090, B:23:0x0096, B:25:0x009e, B:27:0x00a6, B:28:0x00ac, B:30:0x00bc, B:32:0x00c2, B:35:0x00d2, B:37:0x00dd, B:38:0x00ca, B:42:0x00fb, B:44:0x0103, B:46:0x0107, B:52:0x010d, B:48:0x0114, B:50:0x011a, B:57:0x014a, B:59:0x0150, B:61:0x0156, B:63:0x015e, B:64:0x0168, B:65:0x017b, B:69:0x0070, B:72:0x007b, B:73:0x0080, B:74:0x007e), top: B:12:0x005e }] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0168 A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, blocks: (B:13:0x005e, B:17:0x006a, B:18:0x0072, B:19:0x0084, B:21:0x0090, B:23:0x0096, B:25:0x009e, B:27:0x00a6, B:28:0x00ac, B:30:0x00bc, B:32:0x00c2, B:35:0x00d2, B:37:0x00dd, B:38:0x00ca, B:42:0x00fb, B:44:0x0103, B:46:0x0107, B:52:0x010d, B:48:0x0114, B:50:0x011a, B:57:0x014a, B:59:0x0150, B:61:0x0156, B:63:0x015e, B:64:0x0168, B:65:0x017b, B:69:0x0070, B:72:0x007b, B:73:0x0080, B:74:0x007e), top: B:12:0x005e }] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0077  */
        @Override // com.android.contacts.calllog.G
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public android.content.Intent b(android.content.Context r11) {
            /*
                Method dump skipped, instructions count: 441
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.calllog.G.d.b(android.content.Context):android.content.Intent");
        }
    }

    /* compiled from: IntentProvider.java */
    /* loaded from: classes.dex */
    public class e extends G {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f13839a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f13840b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f13841c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f13842d;

        public e(long j10, String str, boolean z10, int i10) {
            this.f13839a = j10;
            this.f13840b = str;
            this.f13841c = z10;
            this.f13842d = i10;
        }

        @Override // com.android.contacts.calllog.G
        public Intent b(Context context) {
            int i10;
            Intent intent = new Intent(context, (Class<?>) CallDetailActivity.class);
            intent.setData(ContentUris.withAppendedId(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, this.f13839a));
            String str = this.f13840b;
            if (str != null) {
                intent.putExtra("EXTRA_VOICEMAIL_URI", Uri.parse(str));
            }
            intent.putExtra("EXTRA_VOICEMAIL_START_PLAYBACK", true);
            if (this.f13841c) {
                if (B3.a.i()) {
                    i10 = D7.c.q(context, Integer.valueOf(this.f13842d));
                } else {
                    i10 = 0;
                }
                intent.putExtra(OplusPhoneUtils.SUBSCRIPTION_KEY, i10);
            }
            return intent;
        }
    }

    /* compiled from: IntentProvider.java */
    /* loaded from: classes.dex */
    public class f extends G {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f13843a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f13844b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f13845c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f13846d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f13847e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f13848f;

        public f(k kVar, int i10, String str, int i11, int i12, int i13) {
            this.f13843a = kVar;
            this.f13844b = i10;
            this.f13845c = str;
            this.f13846d = i11;
            this.f13847e = i12;
            this.f13848f = i13;
        }

        @Override // com.android.contacts.calllog.G
        public Intent b(Context context) {
            Cursor q10 = this.f13843a.q();
            if (q10 != null && !q10.isClosed() && q10.getColumnCount() >= 3) {
                try {
                    q10.moveToPosition(this.f13844b);
                    String string = q10.getString(2);
                    String string2 = q10.getString(1);
                    long j10 = q10.getLong(0);
                    Intent intent = new Intent();
                    intent.putExtra("number", string);
                    intent.putExtra("name", string2);
                    intent.putExtra("person_id", j10);
                    intent.putExtra("position", this.f13844b);
                    intent.putExtra("countryiso", this.f13845c);
                    intent.putExtra("state", this.f13846d);
                    intent.putExtra("start_position", this.f13847e);
                    intent.putExtra("search_type", this.f13848f);
                    intent.setData(ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, j10));
                    if (j10 > 0 && PrimaryUserUtils.a()) {
                        if (C1641a.k(j10)) {
                            Uri c10 = C1641a.c(string);
                            if (c10 != null) {
                                intent.putExtra(R0.c.f3186d, c10.toString());
                            }
                        } else {
                            intent.putExtra(R0.c.f3186d, ContentUris.withAppendedId(R0.d.c(string), j10).toString());
                        }
                    }
                    return intent;
                } catch (Exception e10) {
                    H7.b.c("IntentProvider", "Exception: " + e10);
                }
            }
            return null;
        }
    }

    public static G a(k kVar, int i10, long j10, int i11, Uri uri, long j11, String str, String str2, boolean z10, boolean z11, boolean z12) {
        return new b(kVar, i10, j11, uri, str, str2, z10, i11, j10, z11, z12);
    }

    public static G c(k kVar, int i10, int i11, int i12, int i13, String str) {
        return new f(kVar, i10, str, i11, i12, i13);
    }

    public static G d(long j10, String str, int i10, boolean z10) {
        return new e(j10, str, z10, i10);
    }

    public static G e(String str, String str2, int i10, String str3, long j10, Uri uri, String str4, long j11) {
        return new d(str, str2, str4, i10, j10, uri, str3, j11);
    }

    public static G f(String str, String str2, String str3, int i10, int i11, String str4, boolean z10, long j10, Uri uri) {
        return new a(str, str2, str3, str4, i10, i11, z10, j10, uri);
    }

    public static G g(String str, String str2, int i10, boolean z10, int i11, int i12, int i13, int i14) {
        return new c(str, str2, i10, z10, i11, i12, i13, i14);
    }

    public abstract Intent b(Context context);
}
