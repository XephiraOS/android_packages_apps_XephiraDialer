package com.android.contacts.voicemail.impl.sync;

import H7.b;
import android.content.Context;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import com.android.contacts.voicemail.impl.scheduling.BaseTask;
import com.android.contacts.voicemail.impl.scheduling.c;
import com.android.contacts.voicemail.proguard.UsedByReflection;
import com.android.incallui.OplusAutoRedial;

@UsedByReflection
/* loaded from: classes.dex */
public class UploadTask extends BaseTask {
    public UploadTask() {
        super(1);
        g(new c(OplusAutoRedial.DELAY_FIVE_SECOND));
    }

    public static void r(Context context, PhoneAccountHandle phoneAccountHandle) {
        context.sendBroadcast(BaseTask.h(context, UploadTask.class, phoneAccountHandle));
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.e
    public void a() {
        a aVar = new a(k());
        PhoneAccountHandle l10 = l();
        if (l10 == null) {
            b.c("VvmUploadTask", "null phone account for phoneAccountHandle " + l());
            return;
        }
        aVar.i(this, "upload_only", l10, null, com.android.contacts.voicemail.impl.c.c(k(), l10));
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.BaseTask, com.android.contacts.voicemail.impl.scheduling.e
    public void e(Context context, Bundle bundle) {
        super.e(context, bundle);
    }
}
