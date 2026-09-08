package u6;

import com.oplus.blacklistapp.callintercept.provider.AnswerType;
import r6.w;

/* compiled from: CallInterceptMarkedNumberCalls.kt */
/* renamed from: u6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1610a {
    public static final AnswerType a(int i10) {
        int abs = Math.abs(i10);
        if (w.b(abs)) {
            return AnswerType.INTERCEPT;
        }
        if (abs != 1) {
            if (abs != 3) {
                if (abs != 10) {
                    if (abs != 101) {
                        return AnswerType.ACCEPT;
                    }
                } else {
                    return AnswerType.REJECT;
                }
            } else {
                return AnswerType.MISS;
            }
        }
        return AnswerType.ACCEPT;
    }
}
