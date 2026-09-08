package com.oplus.ocs.icdf;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.IBinder;
import com.heytap.accessory.BaseSocket;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.ServiceProfile;
import com.oplus.ocs.icdf.commonchannel.oaf.inner.OAFConnectionSocket;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class OafBaseAgentAdapter extends com.heytap.accessory.BaseAgent {
    private static final String TAG = "ICDF.OafBaseAgentAdapter";
    private b mClientAdapterListener;
    private HashSet<String> mClientMap;
    private boolean mNoticeFlag;
    private int mOafAgentRole;
    private b mServerAdapterListener;
    private final OAFConnectionSocket.b serviceConnListener;

    /* loaded from: classes3.dex */
    public class a implements OAFConnectionSocket.b {
        public a() {
        }

        @Override // com.oplus.ocs.icdf.commonchannel.oaf.inner.OAFConnectionSocket.b
        public void a(PeerAgent peerAgent, int i10) {
            OafBaseAgentAdapter oafBaseAgentAdapter = OafBaseAgentAdapter.this;
            oafBaseAgentAdapter.onOafConnectionLost(new com.oplus.ocs.icdf.model.a((BaseAgent) oafBaseAgentAdapter, peerAgent, -1), i10);
        }
    }

    public OafBaseAgentAdapter(boolean z10) {
        super("icdfchannel", OAFConnectionSocket.class);
        this.mOafAgentRole = -1;
        this.mClientMap = new HashSet<>();
        this.serviceConnListener = new a();
        this.mNoticeFlag = z10;
    }

    private void serviceConnectionResponseHandler(PeerAgent peerAgent, BaseSocket baseSocket, int i10) {
        if (this.mClientMap.contains(peerAgent.getAgentId())) {
            b bVar = this.mClientAdapterListener;
            if (bVar != null) {
                bVar.a(new com.oplus.ocs.icdf.model.a((BaseAgent) this, peerAgent, 0), baseSocket, i10);
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
            com.oplus.ocs.icdf.model.a aVar = new com.oplus.ocs.icdf.model.a((BaseAgent) this, peerAgent, 1);
            this.mServerAdapterListener.a(aVar, baseSocket, i10);
            onOafConnectionResponse(aVar, i10);
            return;
        }
        ICDFLog.e(TAG, "serverAdapterListener is null");
    }

    private void startForeground() {
        if (!this.mNoticeFlag) {
            return;
        }
        String str = getPackageName() + getClass().getName();
        ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel(str, "icdf_channel", 2));
        startForeground(1, new Notification.Builder(getBaseContext(), str).setContentTitle(TAG).setContentText(TAG).setChannelId(str).build());
    }

    private void stopForeground() {
        if (!this.mNoticeFlag) {
            return;
        }
        stopForeground(true);
    }

    public void acceptConnection(com.oplus.ocs.icdf.model.a aVar) {
        acceptServiceConnectionRequest(aVar.a());
    }

    public void connectOafPeerAgent(com.oplus.ocs.icdf.model.a aVar) {
        PeerAgent a10 = aVar.a();
        requestServiceConnection(a10);
        this.mClientMap.add(a10.getAgentId());
    }

    public void findOafPeerAgents() {
        super.findPeerAgents();
    }

    public int getAgentRole() {
        int i10 = this.mOafAgentRole;
        if (i10 != -1) {
            return i10;
        }
        ServiceProfile serviceProfile = getServiceProfile();
        if (serviceProfile != null) {
            this.mOafAgentRole = serviceProfile.getRole();
        }
        ICDFLog.d(TAG, "getAgentRole " + this.mOafAgentRole);
        return this.mOafAgentRole;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.heytap.accessory.BaseAgent, android.app.Service
    public void onCreate() {
        super.onCreate();
        boolean z10 = true;
        if (getAgentRole() == 1 || !this.mNoticeFlag) {
            z10 = false;
        }
        this.mNoticeFlag = z10;
        ICDFLog.i(TAG, "onCreate, " + getServiceProfile().getName() + ", isForeground " + this.mNoticeFlag);
        startForeground();
    }

    @Override // com.heytap.accessory.BaseAgent, android.app.Service
    public void onDestroy() {
        ICDFLog.i(TAG, "onDestroy " + getServiceProfile().getName());
        stopForeground();
        super.onDestroy();
    }

    @Override // com.heytap.accessory.BaseAgent
    public final void onFindPeerAgentsResponse(PeerAgent[] peerAgentArr, int i10) {
        ArrayList arrayList = new ArrayList();
        if (peerAgentArr != null) {
            for (PeerAgent peerAgent : peerAgentArr) {
                arrayList.add(new com.oplus.ocs.icdf.model.a((BaseAgent) this, peerAgent, 0));
            }
        }
        onOafFindResponse(i10, arrayList);
    }

    public void onOafConnectionLost(com.oplus.ocs.icdf.model.PeerAgent peerAgent, int i10) {
        ICDFLog.e(TAG, "invalid implementation of OafBaseAgentAdapter.onOafConnectionLost, it should be override!");
    }

    public void onOafConnectionRequest(com.oplus.ocs.icdf.model.PeerAgent peerAgent) {
        ICDFLog.e(TAG, "invalid implementation of OafBaseAgentAdapter.onOafConnectionRequest, it should be override!");
    }

    public void onOafConnectionResponse(com.oplus.ocs.icdf.model.PeerAgent peerAgent, int i10) {
        ICDFLog.e(TAG, "invalid implementation of OafBaseAgentAdapter.onOafConnectionResponse, it should be override!");
    }

    public void onOafFindResponse(int i10, List<com.oplus.ocs.icdf.model.PeerAgent> list) {
        ICDFLog.e(TAG, "invalid implementation of OafBaseAgentAdapter.onOafFindResponse, it should be override!");
    }

    @Override // com.heytap.accessory.BaseAgent
    public final void onServiceConnectionRequested(PeerAgent peerAgent) {
        ICDFLog.i(TAG, "onServiceConnectionRequested, peerAgent " + peerAgent.getAgentId());
        onOafConnectionRequest(new com.oplus.ocs.icdf.model.a((BaseAgent) this, peerAgent, 1));
    }

    @Override // com.heytap.accessory.BaseAgent
    public final void onServiceConnectionResponse(PeerAgent peerAgent, BaseSocket baseSocket, int i10) {
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

    @Override // com.heytap.accessory.BaseAgent, android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return super.onStartCommand(intent, i10, i11);
    }

    public void rejectConnection(com.oplus.ocs.icdf.model.a aVar) {
        rejectServiceConnectionRequest(aVar.a());
    }

    public void setClientAdapterListener(b bVar) {
        this.mClientAdapterListener = bVar;
    }

    public void setServerAdapterListener(b bVar) {
        this.mServerAdapterListener = bVar;
    }
}
