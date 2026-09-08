package com.oplus.aiunit.toolkits;

import android.os.Bundle;
import com.oplus.aiunit.core.protocol.common.ErrorCode;
import com.oplus.aiunit.toolkits.IAICallback;

/* loaded from: classes3.dex */
public final class AISettings$startSettingsGuide$c$1 extends IAICallback.Stub {
    @Override // com.oplus.aiunit.toolkits.IAICallback
    public void m7(Bundle bundle) {
        Z5.a.a("AISettings", "onCall " + bundle);
        if (bundle != null) {
            ErrorCode errorCode = ErrorCode.kErrorNone;
            if (bundle.getInt("package::error_code", errorCode.a()) == errorCode.a()) {
                if (bundle.getInt("ai::key::settings_callback_type", 0) == 0) {
                    bundle.getInt("ai::key::settings_status", -1);
                    throw null;
                }
                bundle.getInt("ai::key::settings_ui_status", -1);
                throw null;
            }
            throw null;
        }
        ErrorCode.kErrorCommunication.a();
        throw null;
    }
}
