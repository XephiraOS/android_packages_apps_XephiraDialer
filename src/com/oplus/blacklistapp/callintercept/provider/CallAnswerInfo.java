package com.oplus.blacklistapp.callintercept.provider;

import d.InterfaceC0944a;
import kotlin.jvm.internal.i;

/* compiled from: CallInterceptMarkedNumberCalls.kt */
@InterfaceC0944a
/* loaded from: classes3.dex */
public final class CallAnswerInfo {
    private final AnswerType answerType;
    private final String number;

    public CallAnswerInfo(String number, AnswerType answerType) {
        i.f(number, "number");
        i.f(answerType, "answerType");
        this.number = number;
        this.answerType = answerType;
    }

    public static /* synthetic */ CallAnswerInfo copy$default(CallAnswerInfo callAnswerInfo, String str, AnswerType answerType, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = callAnswerInfo.number;
        }
        if ((i10 & 2) != 0) {
            answerType = callAnswerInfo.answerType;
        }
        return callAnswerInfo.copy(str, answerType);
    }

    public final String component1() {
        return this.number;
    }

    public final AnswerType component2() {
        return this.answerType;
    }

    public final CallAnswerInfo copy(String number, AnswerType answerType) {
        i.f(number, "number");
        i.f(answerType, "answerType");
        return new CallAnswerInfo(number, answerType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallAnswerInfo)) {
            return false;
        }
        CallAnswerInfo callAnswerInfo = (CallAnswerInfo) obj;
        if (i.b(this.number, callAnswerInfo.number) && this.answerType == callAnswerInfo.answerType) {
            return true;
        }
        return false;
    }

    public final AnswerType getAnswerType() {
        return this.answerType;
    }

    public final String getNumber() {
        return this.number;
    }

    public int hashCode() {
        return (this.number.hashCode() * 31) + this.answerType.hashCode();
    }

    public String toString() {
        return "CallAnswerInfo(number=" + this.number + ", answerType=" + this.answerType + ")";
    }
}
