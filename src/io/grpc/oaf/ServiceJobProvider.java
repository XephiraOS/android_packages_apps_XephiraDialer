package io.grpc.oaf;

import android.content.Context;
import com.heytap.accessory.BaseJobAgent;
import com.heytap.accessory.BaseSocket;
import com.oplus.ocs.icdf.BaseJobAgent;
import com.oplus.ocs.icdf.RequestJobAgentCallback;
import com.oplus.ocs.icdf.model.PeerAgent;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;

/* loaded from: classes4.dex */
public abstract class ServiceJobProvider extends BaseJobAgent {
    private static final String TAG = "ICDF.ServiceJobProvider";
    private final String mName;

    /* loaded from: classes4.dex */
    public class a implements RequestJobAgentCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseJobAgent.RequestAgentCallback f33423a;

        public a(BaseJobAgent.RequestAgentCallback requestAgentCallback) {
            this.f33423a = requestAgentCallback;
        }

        @Override // com.oplus.ocs.icdf.RequestJobAgentCallback
        public void onError(String str) {
            this.f33423a.onError(0, str);
        }

        @Override // com.oplus.ocs.icdf.RequestJobAgentCallback
        public void onJobAgentAvailable(com.oplus.ocs.icdf.BaseJobAgent baseJobAgent) {
            this.f33423a.onAgentAvailable(baseJobAgent);
        }
    }

    public ServiceJobProvider(Context context, String str, int i10) {
        super(context, 1);
        this.mName = str;
        ICDFLog.i(TAG, str + " construct");
    }

    public static void getInstance(Context context, String str, BaseJobAgent.RequestAgentCallback requestAgentCallback) {
        com.oplus.ocs.icdf.BaseJobAgent.getInstance(context, str, new a(requestAgentCallback));
    }

    public final void destory() {
        ICDFLog.i(TAG, this.mName + " destroy");
        super.destroy();
    }

    @Override // com.oplus.ocs.icdf.BaseJobAgent
    public final void onConnectionRequest(PeerAgent peerAgent) {
        ICDFLog.i(TAG, this.mName + " onConnectionRequest, peerAgent " + peerAgent.getAgentId());
        com.oplus.ocs.icdf.model.a aVar = (com.oplus.ocs.icdf.model.a) peerAgent;
        if (onConnectionRequest(aVar.a())) {
            allowConnection(aVar);
        } else {
            rejectConnection(aVar);
        }
    }

    public abstract boolean onConnectionRequest(com.heytap.accessory.bean.PeerAgent peerAgent);

    public void onConnectionStateChanged(com.heytap.accessory.bean.PeerAgent peerAgent, int i10) {
        ICDFLog.w(TAG, this.mName + " no Implementation for onConnectionStateChanged(PeerAgent peerAgent, int result)!");
    }

    @Override // com.heytap.accessory.BaseJobAgent
    public void onError(com.heytap.accessory.bean.PeerAgent peerAgent, String str, int i10) {
        super.onError(peerAgent, str, i10);
    }

    @Override // com.oplus.ocs.icdf.BaseJobAgent
    public final void onPeerAgentDown(PeerAgent peerAgent, int i10) {
        ICDFLog.i(TAG, this.mName + " onPeerAgentDown");
        onConnectionStateChanged(((com.oplus.ocs.icdf.model.a) peerAgent).a(), i10 + 10100);
    }

    @Override // com.oplus.ocs.icdf.BaseJobAgent
    public final String onReadGrpcServiceClassName() {
        return readServiceImpl();
    }

    @Override // com.oplus.ocs.icdf.OafBaseJobAgentAdapter, com.heytap.accessory.BaseJobAgent
    public final void onServiceConnectionResponse(com.heytap.accessory.bean.PeerAgent peerAgent, BaseSocket baseSocket, int i10) {
        super.onServiceConnectionResponse(peerAgent, baseSocket, i10);
        onConnectionStateChanged(peerAgent, i10);
    }

    public String readServiceImpl() {
        throw new UnsupportedOperationException(this.mName + " readServiceImpl is not implemented!");
    }
}
