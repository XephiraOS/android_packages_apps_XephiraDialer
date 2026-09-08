package io.grpc.oaf;

import android.content.Context;
import com.heytap.accessory.BaseJobAgent;
import com.heytap.accessory.bean.PeerAgent;
import com.oplus.ocs.icdf.BaseJobAgent;
import com.oplus.ocs.icdf.CreateChannelResult;
import com.oplus.ocs.icdf.RequestJobAgentCallback;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import j9.AbstractC1190B;
import j9.AbstractC1194d;

/* loaded from: classes4.dex */
public abstract class ServiceJobConsumer extends BaseJobAgent {
    public static final int CONNECTION_LOSTED_DEVICE_DETACHED = 10101;
    public static final int CONNECTION_LOSTED_PEER_DISCONNECTED = 10100;
    public static final int CONNECTION_LOSTED_RETRANSMISSION_FAILED = 10102;
    public static final int CONNECTION_LOSTED_UNKNOWN_REASON = 10103;
    public static final int ICDF_CHANNEL_BYTES = 1;
    public static final int ICDF_CHANNEL_STREAM = 2;
    private static final String TAG = "ICDF.ServiceJobConsumer";
    private final String mName;

    /* loaded from: classes4.dex */
    public class a implements RequestJobAgentCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseJobAgent.RequestAgentCallback f33422a;

        public a(BaseJobAgent.RequestAgentCallback requestAgentCallback) {
            this.f33422a = requestAgentCallback;
        }

        @Override // com.oplus.ocs.icdf.RequestJobAgentCallback
        public void onError(String str) {
            this.f33422a.onError(0, str);
        }

        @Override // com.oplus.ocs.icdf.RequestJobAgentCallback
        public void onJobAgentAvailable(com.oplus.ocs.icdf.BaseJobAgent baseJobAgent) {
            this.f33422a.onAgentAvailable(baseJobAgent);
        }
    }

    public ServiceJobConsumer(Context context, String str, int i10) {
        super(context, 1);
        this.mName = str;
        ICDFLog.i(TAG, str + " construct");
    }

    public static void getInstance(Context context, String str, BaseJobAgent.RequestAgentCallback requestAgentCallback) {
        com.oplus.ocs.icdf.BaseJobAgent.getInstance(context, str, new a(requestAgentCallback));
    }

    public final void configMethod(String str, int i10, int i11, boolean z10) {
        configRpcMethod(str, i10, i11, z10);
    }

    public final void connectPeerAgent(PeerAgent peerAgent) {
        ICDFLog.i(TAG, this.mName + " connectPeerAgent " + peerAgent.getAgentId());
        createGrpcChannel(new com.oplus.ocs.icdf.model.a(this, peerAgent, 0), 0);
    }

    public final void destory() {
        ICDFLog.i(TAG, this.mName + " destroy");
        super.destroy();
    }

    public final void disconnectPeerAgent(PeerAgent peerAgent) {
        ICDFLog.i(TAG, this.mName + " disconnect PeerAgent " + peerAgent.getAgentId());
        destroyGrpcChannel(new com.oplus.ocs.icdf.model.a(this, peerAgent, 0));
    }

    public void onConnectionStateChanged(PeerAgent peerAgent, int i10, AbstractC1190B abstractC1190B) {
        ICDFLog.w(TAG, this.mName + " no Implementation for onConnectionStateChanged(PeerAgent peerAgent, int state, ManagedChannel channel)!");
    }

    @Override // com.oplus.ocs.icdf.BaseJobAgent
    public final void onCreateGrpcChannelResponse(CreateChannelResult createChannelResult, com.oplus.ocs.icdf.model.PeerAgent peerAgent, AbstractC1194d abstractC1194d) {
        ICDFLog.i(TAG, this.mName + " onCreateGrpcChannelResponse ret: " + createChannelResult.getValue() + ", peerAgent " + peerAgent.getAgentId());
        onConnectionStateChanged(((com.oplus.ocs.icdf.model.a) peerAgent).a(), createChannelResult.getValue(), (AbstractC1190B) abstractC1194d);
    }

    @Override // com.heytap.accessory.BaseJobAgent
    public void onError(PeerAgent peerAgent, String str, int i10) {
        super.onError(peerAgent, str, i10);
    }

    @Override // com.oplus.ocs.icdf.OafBaseJobAgentAdapter, com.heytap.accessory.BaseJobAgent
    public void onFindPeerAgentsResponse(PeerAgent[] peerAgentArr, int i10) {
        throw new UnsupportedOperationException(this.mName + " onFindPeerAgentsResponse is not implemented!");
    }

    @Override // com.oplus.ocs.icdf.BaseJobAgent
    public final void onPeerAgentDown(com.oplus.ocs.icdf.model.PeerAgent peerAgent, int i10) {
        ICDFLog.i(TAG, this.mName + " onPeerAgentDown");
        onConnectionStateChanged(((com.oplus.ocs.icdf.model.a) peerAgent).a(), i10 + 10100, null);
    }
}
