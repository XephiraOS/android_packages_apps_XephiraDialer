package com.android.contacts.voicemail.impl.sync;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import com.android.contacts.voicemail.impl.Voicemail;
import com.android.contacts.voicemail.impl.c;
import com.android.contacts.voicemail.impl.scheduling.BaseTask;
import com.android.contacts.voicemail.impl.scheduling.d;
import com.android.contacts.voicemail.proguard.UsedByReflection;
import com.android.incallui.OplusAutoRedial;

@UsedByReflection
/* loaded from: classes.dex */
public class SyncOneTask extends BaseTask {

    /* renamed from: j, reason: collision with root package name */
    public PhoneAccountHandle f18193j;

    /* renamed from: k, reason: collision with root package name */
    public String f18194k;

    /* renamed from: l, reason: collision with root package name */
    public Voicemail f18195l;

    public SyncOneTask() {
        super(-2);
        g(new d(2, OplusAutoRedial.DELAY_FIVE_SECOND));
    }

    public static void r(Context context, PhoneAccountHandle phoneAccountHandle, Voicemail voicemail) {
        Intent h10 = BaseTask.h(context, SyncOneTask.class, phoneAccountHandle);
        h10.putExtra("extra_phone_account_handle", phoneAccountHandle);
        h10.putExtra("extra_sync_type", "download_one_transcription");
        h10.putExtra("extra_voicemail", voicemail);
        context.sendBroadcast(h10);
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.e
    public void a() {
        new a(k()).i(this, this.f18194k, this.f18193j, this.f18195l, c.c(k(), this.f18193j));
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.BaseTask, com.android.contacts.voicemail.impl.scheduling.e
    public void e(Context context, Bundle bundle) {
        super.e(context, bundle);
        this.f18193j = (PhoneAccountHandle) bundle.getParcelable("extra_phone_account_handle");
        this.f18194k = bundle.getString("extra_sync_type");
        this.f18195l = (Voicemail) bundle.getParcelable("extra_voicemail");
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.BaseTask
    public Intent i() {
        Intent i10 = super.i();
        i10.putExtra("extra_phone_account_handle", this.f18193j);
        i10.putExtra("extra_sync_type", this.f18194k);
        i10.putExtra("extra_voicemail", this.f18195l);
        return i10;
    }
}
