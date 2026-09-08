package com.android.contacts.voicemail.impl.scheduling;

import android.content.Context;
import android.os.Bundle;
import com.android.contacts.voicemail.proguard.UsedByReflection;

@UsedByReflection
/* loaded from: classes.dex */
public class BlockerTask extends BaseTask {
    public BlockerTask() {
        super(-1);
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.BaseTask, com.android.contacts.voicemail.impl.scheduling.e
    public void b(e eVar) {
        H7.b.e("BlockerTask", eVar + "blocked, " + d() + "millis remaining");
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.BaseTask, com.android.contacts.voicemail.impl.scheduling.e
    public void e(Context context, Bundle bundle) {
        super.e(context, bundle);
        q(bundle.getInt("extra_task_id", -1));
        p(m() + bundle.getInt("extra_block_for_millis", 0));
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.e
    public void a() {
    }
}
