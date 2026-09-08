package com.android.contacts.voicemail.impl.sync;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import com.android.contacts.voicemail.impl.scheduling.BaseTask;
import com.android.contacts.voicemail.impl.scheduling.d;
import com.android.contacts.voicemail.proguard.UsedByReflection;
import com.android.incallui.OplusAutoRedial;

@UsedByReflection
/* loaded from: classes.dex */
public class SyncTask extends BaseTask {

    /* renamed from: j, reason: collision with root package name */
    public final d f18196j;

    /* renamed from: k, reason: collision with root package name */
    public PhoneAccountHandle f18197k;

    /* renamed from: l, reason: collision with root package name */
    public String f18198l;

    public SyncTask() {
        super(2);
        d dVar = new d(4, OplusAutoRedial.DELAY_FIVE_SECOND);
        this.f18196j = dVar;
        g(dVar);
        g(new com.android.contacts.voicemail.impl.scheduling.a(OplusAutoRedial.DELAY_ONE_MIN));
    }

    public static void r(Context context, PhoneAccountHandle phoneAccountHandle, String str) {
        Intent h10 = BaseTask.h(context, SyncTask.class, phoneAccountHandle);
        h10.putExtra("extra_phone_account_handle", phoneAccountHandle);
        h10.putExtra("extra_sync_type", str);
        context.sendBroadcast(h10);
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.e
    public void a() {
        new a(k()).i(this, this.f18198l, this.f18197k, null, this.f18196j.a());
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.BaseTask, com.android.contacts.voicemail.impl.scheduling.e
    public void e(Context context, Bundle bundle) {
        super.e(context, bundle);
        this.f18197k = (PhoneAccountHandle) bundle.getParcelable("extra_phone_account_handle");
        this.f18198l = bundle.getString("extra_sync_type");
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.BaseTask
    public Intent i() {
        Intent i10 = super.i();
        i10.putExtra("extra_phone_account_handle", this.f18197k);
        i10.putExtra("extra_sync_type", this.f18198l);
        return i10;
    }
}
