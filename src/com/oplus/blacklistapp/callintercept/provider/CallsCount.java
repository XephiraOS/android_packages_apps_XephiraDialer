package com.oplus.blacklistapp.callintercept.provider;

import d.InterfaceC0944a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: CallInterceptMarkedNumberCalls.kt */
@InterfaceC0944a
/* loaded from: classes3.dex */
public final class CallsCount {
    private int acceptCount;
    private int interceptCount;
    private final String markedType;
    private int missCount;
    private int rejectCount;
    private int totalCount;

    /* compiled from: CallInterceptMarkedNumberCalls.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26757a;

        static {
            int[] iArr = new int[AnswerType.values().length];
            try {
                iArr[AnswerType.ACCEPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnswerType.REJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnswerType.INTERCEPT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnswerType.MISS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f26757a = iArr;
        }
    }

    public CallsCount(String markedType, int i10, int i11, int i12, int i13, int i14) {
        i.f(markedType, "markedType");
        this.markedType = markedType;
        this.acceptCount = i10;
        this.interceptCount = i11;
        this.missCount = i12;
        this.rejectCount = i13;
        this.totalCount = i14;
    }

    public static /* synthetic */ CallsCount copy$default(CallsCount callsCount, String str, int i10, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            str = callsCount.markedType;
        }
        if ((i15 & 2) != 0) {
            i10 = callsCount.acceptCount;
        }
        int i16 = i10;
        if ((i15 & 4) != 0) {
            i11 = callsCount.interceptCount;
        }
        int i17 = i11;
        if ((i15 & 8) != 0) {
            i12 = callsCount.missCount;
        }
        int i18 = i12;
        if ((i15 & 16) != 0) {
            i13 = callsCount.rejectCount;
        }
        int i19 = i13;
        if ((i15 & 32) != 0) {
            i14 = callsCount.totalCount;
        }
        return callsCount.copy(str, i16, i17, i18, i19, i14);
    }

    public final String component1() {
        return this.markedType;
    }

    public final int component2() {
        return this.acceptCount;
    }

    public final int component3() {
        return this.interceptCount;
    }

    public final int component4() {
        return this.missCount;
    }

    public final int component5() {
        return this.rejectCount;
    }

    public final int component6() {
        return this.totalCount;
    }

    public final CallsCount copy(String markedType, int i10, int i11, int i12, int i13, int i14) {
        i.f(markedType, "markedType");
        return new CallsCount(markedType, i10, i11, i12, i13, i14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallsCount)) {
            return false;
        }
        CallsCount callsCount = (CallsCount) obj;
        if (i.b(this.markedType, callsCount.markedType) && this.acceptCount == callsCount.acceptCount && this.interceptCount == callsCount.interceptCount && this.missCount == callsCount.missCount && this.rejectCount == callsCount.rejectCount && this.totalCount == callsCount.totalCount) {
            return true;
        }
        return false;
    }

    public final int getAcceptCount() {
        return this.acceptCount;
    }

    public final int getInterceptCount() {
        return this.interceptCount;
    }

    public final String getMarkedType() {
        return this.markedType;
    }

    public final int getMissCount() {
        return this.missCount;
    }

    public final int getRejectCount() {
        return this.rejectCount;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public int hashCode() {
        return (((((((((this.markedType.hashCode() * 31) + Integer.hashCode(this.acceptCount)) * 31) + Integer.hashCode(this.interceptCount)) * 31) + Integer.hashCode(this.missCount)) * 31) + Integer.hashCode(this.rejectCount)) * 31) + Integer.hashCode(this.totalCount);
    }

    public final void increment(AnswerType answerType) {
        i.f(answerType, "answerType");
        this.totalCount++;
        int i10 = a.f26757a[answerType.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 == 4) {
                        this.missCount++;
                        return;
                    }
                    return;
                }
                this.interceptCount++;
                return;
            }
            this.rejectCount++;
            return;
        }
        this.acceptCount++;
    }

    public final void setAcceptCount(int i10) {
        this.acceptCount = i10;
    }

    public final void setInterceptCount(int i10) {
        this.interceptCount = i10;
    }

    public final void setMissCount(int i10) {
        this.missCount = i10;
    }

    public final void setRejectCount(int i10) {
        this.rejectCount = i10;
    }

    public final void setTotalCount(int i10) {
        this.totalCount = i10;
    }

    public String toString() {
        return "CallsCount(markedType=" + this.markedType + ", acceptCount=" + this.acceptCount + ", interceptCount=" + this.interceptCount + ", missCount=" + this.missCount + ", rejectCount=" + this.rejectCount + ", totalCount=" + this.totalCount + ")";
    }

    public /* synthetic */ CallsCount(String str, int i10, int i11, int i12, int i13, int i14, int i15, f fVar) {
        this(str, (i15 & 2) != 0 ? 0 : i10, (i15 & 4) != 0 ? 0 : i11, (i15 & 8) != 0 ? 0 : i12, (i15 & 16) != 0 ? 0 : i13, (i15 & 32) == 0 ? i14 : 0);
    }
}
