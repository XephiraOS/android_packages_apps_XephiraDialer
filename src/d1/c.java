package D1;

import android.content.Context;
import android.preference.PreferenceManager;
import android.telecom.PhoneAccountHandle;

/* compiled from: VisualVoicemailPreferences.java */
/* loaded from: classes.dex */
public class c extends b {
    public c(Context context, PhoneAccountHandle phoneAccountHandle) {
        super(context, phoneAccountHandle, PreferenceManager.getDefaultSharedPreferences(context), "visual_voicemail_");
    }
}
