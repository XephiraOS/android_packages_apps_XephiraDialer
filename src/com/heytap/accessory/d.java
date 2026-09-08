package com.heytap.accessory;

import android.content.Intent;
import com.heytap.accessory.BaseJobAgent;
import n5.C1371a;

/* compiled from: AgentCallbackImpl.java */
/* loaded from: classes3.dex */
public class d implements BaseJobAgent.RequestAgentCallback {

    /* renamed from: a, reason: collision with root package name */
    public int f25217a;

    /* renamed from: b, reason: collision with root package name */
    public Intent f25218b;

    public d(int i10, Intent intent) {
        this.f25217a = i10;
        this.f25218b = intent;
    }

    @Override // com.heytap.accessory.BaseJobAgent.RequestAgentCallback
    public void onAgentAvailable(BaseJobAgent baseJobAgent) {
        C1371a.c("AgentCallbackImpl", "onAgentAvailable");
        if (this.f25217a == 1) {
            baseJobAgent.handleConnectionRequest(this.f25218b);
        }
    }

    @Override // com.heytap.accessory.BaseJobAgent.RequestAgentCallback
    public void onError(int i10, String str) {
        C1371a.d("AgentCallbackImpl", "Request failed. Type = " + this.f25217a + ". ErrorCode : " + i10 + ". ErrorMsg: " + str);
    }
}
