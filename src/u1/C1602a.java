package u1;

import H7.b;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.telecom.PhoneAccountHandle;
import com.oplus.dialer.R;
import java.io.OutputStream;
import v1.c;

/* compiled from: VoicemailFetchedCallback.java */
/* renamed from: u1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1602a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f37302a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentResolver f37303b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f37304c;

    /* renamed from: d, reason: collision with root package name */
    public final PhoneAccountHandle f37305d;

    public C1602a(Context context, Uri uri, PhoneAccountHandle phoneAccountHandle) {
        this.f37302a = context;
        this.f37303b = context.getContentResolver();
        this.f37304c = uri;
        this.f37305d = phoneAccountHandle;
    }

    public void a(c cVar) {
        if (cVar == null) {
            b.e("VoicemailFetchedCallback", "Payload not found, message has unsupported format");
            ContentValues contentValues = new ContentValues();
            contentValues.put("transcription", this.f37302a.getString(R.string.account_phone_tablet));
            b(contentValues);
            return;
        }
        b.b("VoicemailFetchedCallback", String.format("Writing new voicemail content: %s", this.f37304c));
        OutputStream outputStream = null;
        try {
            try {
                outputStream = this.f37303b.openOutputStream(this.f37304c);
                byte[] a10 = cVar.a();
                if (a10 != null && outputStream != null) {
                    outputStream.write(a10);
                }
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("mime_type", cVar.b());
                contentValues2.put("has_content", Boolean.TRUE);
                b(contentValues2);
            } catch (Exception unused) {
                b.i("VoicemailFetchedCallback", String.format("File not found for %s", this.f37304c));
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e10) {
                        C1.a.b("VoicemailFetchedCallback", "Exception = " + e10);
                    }
                }
            }
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e11) {
                    C1.a.b("VoicemailFetchedCallback", "Exception = " + e11);
                }
            }
        }
    }

    public final boolean b(ContentValues contentValues) {
        try {
            int update = this.f37303b.update(this.f37304c, contentValues, null, null);
            if (update == 1) {
                return true;
            }
            b.c("VoicemailFetchedCallback", "Updating voicemail should have updated 1 row, was: " + update);
            return false;
        } catch (Exception e10) {
            C1.a.b("VoicemailFetchedCallback", "updateVoicemail error " + e10);
            return false;
        }
    }
}
