package C1;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.VoicemailContract;
import android.telecom.PhoneAccountHandle;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.voicemail.impl.Voicemail;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;

/* compiled from: VoicemailDatabaseUtil.java */
/* loaded from: classes.dex */
public class c {
    public static ContentValues a(Voicemail voicemail) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BreenoCallContract.BaseColumns.DATE, String.valueOf(voicemail.n()));
        contentValues.put("number", voicemail.i());
        contentValues.put("duration", String.valueOf(voicemail.f()));
        contentValues.put("source_package", voicemail.m());
        contentValues.put("source_data", voicemail.k());
        contentValues.put("is_read", Integer.valueOf(voicemail.t() ? 1 : 0));
        contentValues.put("is_omtp_voicemail", (Integer) 1);
        PhoneAccountHandle j10 = voicemail.j();
        if (j10 != null) {
            contentValues.put("subscription_component_name", j10.getComponentName().flattenToString());
            contentValues.put("subscription_id", j10.getId());
            try {
                contentValues.put("simid", Integer.valueOf(P6.a.c(j10)));
            } catch (UnSupportedApiVersionException e10) {
                H7.b.c("VoicemailDatabaseUtil", "UnSupportedApiVersionException e: " + e10);
            }
        }
        if (voicemail.p() != null) {
            contentValues.put("transcription", voicemail.p());
        }
        return contentValues;
    }

    public static Uri b(Context context, Voicemail voicemail) {
        try {
            return context.getContentResolver().insert(VoicemailContract.Voicemails.buildSourceUri(context.getPackageName()), a(voicemail));
        } catch (Exception e10) {
            H7.b.c("VoicemailDatabaseUtil", "insert error " + e10);
            return null;
        }
    }
}
