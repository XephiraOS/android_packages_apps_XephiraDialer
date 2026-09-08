package com.oplus.ocs.icdf;

import android.content.Context;
import com.heytap.accessory.BaseJobAgent;
import com.heytap.accessory.BaseSocket;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.ServiceProfile;
import com.oplus.ocs.icdf.commonchannel.oaf.inner.OAFConnectionSocket;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class OafBaseJobAgentAdapter extends com.heytap.accessory.BaseJobAgent {
    private static final String TAG = "ICDF.OafBaseJobAgentAdapter";
    private com.oplus.ocs.icdf.b mClientAdapterListener;
    private HashSet<String> mClientMap;
    private int mOafAgentRole;
    private com.oplus.ocs.icdf.b mServerAdapterListener;
    private final OAFConnectionSocket.b serviceConnListener;

    /* loaded from: classes3.dex */
    public class a implements BaseJobAgent.RequestAgentCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestJobAgentCallback f28450a;

        public a(RequestJobAgentCallback requestJobAgentCallback) {
            this.f28450a = requestJobAgentCallback;
        }

        @Override // com.heytap.accessory.BaseJobAgent.RequestAgentCallback
        public void onAgentAvailable(com.heytap.accessory.BaseJobAgent baseJobAgent) {
            this.f28450a.onJobAgentAvailable((BaseJobAgent) baseJobAgent);
        }

        @Override // com.heytap.accessory.BaseJobAgent.RequestAgentCallback
        public void onError(int i10, String str) {
            this.f28450a.onError(str);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements OAFConnectionSocket.b {
        public b() {
        }

        @Override // com.oplus.ocs.icdf.commonchannel.oaf.inner.OAFConnectionSocket.b
        public void a(PeerAgent peerAgent, int i10) {
            OafBaseJobAgentAdapter oafBaseJobAgentAdapter = OafBaseJobAgentAdapter.this;
            oafBaseJobAgentAdapter.onOafConnectionLost(new com.oplus.ocs.icdf.model.a((BaseJobAgent) oafBaseJobAgentAdapter, peerAgent, -1), i10);
        }
    }

    public OafBaseJobAgentAdapter(Context context) {
        super("icdfchannel", context, OAFConnectionSocket.class);
        this.mOafAgentRole = -1;
        this.mClientMap = new HashSet<>();
        this.serviceConnListener = new b();
    }

    public static void getInstance(Context context, String str, RequestJobAgentCallback requestJobAgentCallback) {
        if (context != null && str != null && requestJobAgentCallback != null) {
            ICDFLog.i(TAG, "get jobAgent instance, implClass " + str);
            com.heytap.accessory.BaseJobAgent.requestAgent(context, str, new a(requestJobAgentCallback));
            return;
        }
        ICDFLog.e(TAG, "get jobAgent instance failed, invalid args");
        if (requestJobAgentCallback != null) {
            requestJobAgentCallback.onError("invalid args");
        }
    }

    private void serviceConnectionResponseHandler(PeerAgent peerAgent, BaseSocket baseSocket, int i10) {
        if (this.mClientMap.contains(peerAgent.getAgentId())) {
            com.oplus.ocs.icdf.b bVar = this.mClientAdapterListener;
            if (bVar != null) {
                bVar.a(new com.oplus.ocs.icdf.model.a((BaseJobAgent) this, peerAgent, 0), baseSocket, i10);
            } else {
                ICDFLog.e(TAG, "clientAdapterListener is null");
            }
            if (i10 != 10009) {
                this.mClientMap.remove(peerAgent.getAgentId());
                return;
            }
            return;
        }
        if (this.mServerAdapterListener != null) {
            com.oplus.ocs.icdf.model.a aVar = new com.oplus.ocs.icdf.model.a((BaseJobAgent) this, peerAgent, 1);
            this.mServerAdapterListener.a(aVar, baseSocket, i10);
            onOafConnectionResponse(aVar, i10);
            return;
        }
        ICDFLog.e(TAG, "serverAdapterListener is null");
    }

    public final void acceptConnection(com.oplus.ocs.icdf.model.a aVar) {
        acceptServiceConnectionRequest(aVar.a());
    }

    public final void connectOafPeerAgent(com.oplus.ocs.icdf.model.a aVar) {
        PeerAgent a10 = aVar.a();
        requestServiceConnection(a10);
        this.mClientMap.add(a10.getAgentId());
    }

    public void destroy() {
        ICDFLog.i(TAG, "destroy, " + getServiceProfile().getName());
        releaseAgent();
    }

    public final void findOafPeerAgents() {
        super.findPeerAgents();
    }

    public final int getAgentRole() {
        int i10 = this.mOafAgentRole;
        if (i10 != -1) {
            return i10;
        }
        ServiceProfile serviceProfile = getServiceProfile();
        if (serviceProfile != null) {
            this.mOafAgentRole = serviceProfile.getRole();
        }
        return this.mOafAgentRole;
    }

    @Override // com.heytap.accessory.BaseJobAgent
    public void onFindPeerAgentsResponse(PeerAgent[] peerAgentArr, int i10) {
        ArrayList arrayList = new ArrayList();
        if (peerAgentArr != null) {
            for (PeerAgent peerAgent : peerAgentArr) {
                arrayList.add(new com.oplus.ocs.icdf.model.a((BaseJobAgent) this, peerAgent, 0));
            }
        }
        onOafFindResponse(i10, arrayList);
    }

    public void onOafConnectionLost(com.oplus.ocs.icdf.model.PeerAgent peerAgent, int i10) {
        ICDFLog.e(TAG, "invalid implementation of OafBaseJobAgentAdapter.onOafConnectionLost, it should be override!");
    }

    public void onOafConnectionRequest(com.oplus.ocs.icdf.model.PeerAgent peerAgent) {
        ICDFLog.e(TAG, "invalid implementation of OafBaseJobAgentAdapter.onOafConnectionRequest, it should be override!");
    }

    public void onOafConnectionResponse(com.oplus.ocs.icdf.model.PeerAgent peerAgent, int i10) {
        ICDFLog.e(TAG, "invalid implementation of OafBaseJobAgentAdapter.onOafConnectionResponse, it should be override!");
    }

    public void onOafFindResponse(int i10, List<com.oplus.ocs.icdf.model.PeerAgent> list) {
        ICDFLog.e(TAG, "invalid implementation of OafBaseJobAgentAdapter.onOafFindResponse, it should be override!");
    }

    @Override // com.heytap.accessory.BaseJobAgent
    public final void onServiceConnectionRequested(PeerAgent peerAgent) {
        ICDFLog.i(TAG, "onServiceConnectionRequested, peerAgent " + peerAgent.getAgentId());
        onOafConnectionRequest(new com.oplus.ocs.icdf.model.a((BaseJobAgent) this, peerAgent, 1));
    }

    @Override // com.heytap.accessory.BaseJobAgent
    public void onServiceConnectionResponse(PeerAgent peerAgent, BaseSocket baseSocket, int i10) {
        ICDFLog.d(TAG, "onServiceConnectionResponse, peerAgent " + peerAgent.getAgentId() + ", result " + i10);
        if (i10 == 10005) {
            serviceConnectionResponseHandler(peerAgent, null, i10);
            return;
        }
        if (baseSocket != null && i10 == 0) {
            if (baseSocket instanceof OAFConnectionSocket) {
                ((OAFConnectionSocket) baseSocket).a(this.serviceConnListener);
            }
            serviceConnectionResponseHandler(peerAgent, baseSocket, i10);
            return;
        }
        serviceConnectionResponseHandler(peerAgent, null, i10);
    }

    public final void rejectConnection(com.oplus.ocs.icdf.model.a aVar) {
        rejectServiceConnectionRequest(aVar.a());
    }

    public final void setClientAdapterListener(com.oplus.ocs.icdf.b bVar) {
        this.mClientAdapterListener = bVar;
    }

    public final void setServerAdapterListener(com.oplus.ocs.icdf.b bVar) {
        this.mServerAdapterListener = bVar;
    }
}
