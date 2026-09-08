package com.oplus.aiunit.toolkits;

import android.os.Bundle;
import com.oplus.aiunit.core.protocol.common.ErrorCode;
import com.oplus.aiunit.toolkits.IAICallback;

/* loaded from: classes3.dex */
public final class AISettings$startAuthorizeGuide$c$1 extends IAICallback.Stub {
    @Override // com.oplus.aiunit.toolkits.IAICallback
    public void m7(Bundle bundle) {
        Z5.a.a("AISettings", "onCall " + bundle);
        if (bundle != null) {
            if (bundle.getInt("ai::key::authorize_status", -1) == 1) {
                throw null;
            }
            bundle.getInt("ai::key::authorize_result_code", ErrorCode.UNKNOWN.a());
            throw null;
        }
        ErrorCode.kErrorCommunication.a();
        throw null;
    }
}
