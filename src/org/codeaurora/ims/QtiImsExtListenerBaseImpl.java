package org.codeaurora.ims;

import org.codeaurora.ims.internal.IQtiImsExtListener;

/* loaded from: classes4.dex */
public class QtiImsExtListenerBaseImpl extends IQtiImsExtListener.Stub {
    @Override // org.codeaurora.ims.internal.IQtiImsExtListener
    public void onGetCallForwardUncondTimer(int i10, int i11, int i12, int i13, int i14, int i15, int i16, String str, int i17) {
    }

    @Override // org.codeaurora.ims.internal.IQtiImsExtListener
    public void notifySsacStatus(int i10, boolean z10) {
    }

    @Override // org.codeaurora.ims.internal.IQtiImsExtListener
    public void notifyVopsStatus(int i10, boolean z10) {
    }

    @Override // org.codeaurora.ims.internal.IQtiImsExtListener
    public void onSetCallForwardUncondTimer(int i10, int i11) {
    }

    @Override // org.codeaurora.ims.internal.IQtiImsExtListener
    public void onSetHandoverConfig(int i10, int i11) {
    }

    @Override // org.codeaurora.ims.internal.IQtiImsExtListener
    public void onVoltePreferenceUpdated(int i10, int i11) {
    }

    @Override // org.codeaurora.ims.internal.IQtiImsExtListener
    public void receiveCallDeflectResponse(int i10, int i11) {
    }

    public void receiveCallTransferResponse(int i10, int i11) {
    }

    @Override // org.codeaurora.ims.internal.IQtiImsExtListener
    public void receiveCancelModifyCallResponse(int i10, int i11) {
    }

    @Override // org.codeaurora.ims.internal.IQtiImsExtListener
    public void notifyParticipantStatusInfo(int i10, int i11, int i12, String str, boolean z10) {
    }

    @Override // org.codeaurora.ims.internal.IQtiImsExtListener
    public void onGetHandoverConfig(int i10, int i11, int i12) {
    }

    @Override // org.codeaurora.ims.internal.IQtiImsExtListener
    public void onGetPacketCount(int i10, int i11, long j10) {
    }

    @Override // org.codeaurora.ims.internal.IQtiImsExtListener
    public void onGetPacketErrorCount(int i10, int i11, long j10) {
    }

    @Override // org.codeaurora.ims.internal.IQtiImsExtListener
    public void onUTReqFailed(int i10, int i11, String str) {
    }

    @Override // org.codeaurora.ims.internal.IQtiImsExtListener
    public void onVoltePreferenceQueried(int i10, int i11, int i12) {
    }
}
