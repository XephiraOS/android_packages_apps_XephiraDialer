package com.oplus.ocs.icdf;

import android.content.Intent;
import com.oplus.ocs.icdf.a;
import com.oplus.ocs.icdf.commonchannel.CommonChannel;
import com.oplus.ocs.icdf.grpcchannel.inner.p;
import com.oplus.ocs.icdf.model.PeerAgent;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import io.grpc.z;
import j9.AbstractC1194d;
import j9.InterfaceC1192b;
import java.util.List;

/* loaded from: classes3.dex */
public class BaseAgent extends OafBaseAgentAdapter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ICDF.BaseAgent";
    private com.oplus.ocs.icdf.a mChannelManager;
    private final int mDefaultChannelType;

    /* loaded from: classes3.dex */
    public class a implements a.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PeerAgent f28390a;

        /* renamed from: com.oplus.ocs.icdf.BaseAgent$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0263a implements a.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.oplus.ocs.icdf.grpcchannel.b f28392a;

            public C0263a(a aVar, com.oplus.ocs.icdf.grpcchannel.b bVar) {
                this.f28392a = bVar;
            }

            @Override // com.oplus.ocs.icdf.a.b
            public void a(int i10, CommonChannel commonChannel) {
                if (commonChannel != null) {
                    ICDFLog.d(BaseAgent.TAG, "notify rpc server, create RPCServerTransport and start it");
                    this.f28392a.a(commonChannel);
                }
            }
        }

        public a(PeerAgent peerAgent) {
            this.f28390a = peerAgent;
        }

        @Override // com.oplus.ocs.icdf.a.e
        public void a(int i10, z zVar, com.oplus.ocs.icdf.grpcchannel.b bVar) {
            if (zVar != null) {
                BaseAgent.this.createCommonServerChannel(this.f28390a, new C0263a(this, bVar));
            } else {
                BaseAgent.this.rejectConnection(this.f28390a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PeerAgent f28393a;

        public b(PeerAgent peerAgent) {
            this.f28393a = peerAgent;
        }

        @Override // com.oplus.ocs.icdf.a.b
        public void a(int i10, CommonChannel commonChannel) {
            BaseAgent.this.onCreateCommonChannelResponse(CreateChannelResult.valueToStatus(i10), this.f28393a, commonChannel);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PeerAgent f28395a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a.b f28396b;

        /* loaded from: classes3.dex */
        public class a implements a.b {
            public a() {
            }

            @Override // com.oplus.ocs.icdf.a.b
            public void a(int i10, CommonChannel commonChannel) {
                BaseAgent.this.onCreateExtraCommonChannelResponse(CreateChannelResult.valueToStatus(i10), c.this.f28395a, commonChannel);
            }
        }

        public c(PeerAgent peerAgent, a.b bVar) {
            this.f28395a = peerAgent;
            this.f28396b = bVar;
        }

        @Override // com.oplus.ocs.icdf.a.c
        public void a(int i10, com.oplus.ocs.icdf.commonchannel.b bVar) {
            if (bVar != null) {
                bVar.a(this.f28395a, this.f28396b);
                bVar.b(this.f28395a, new a());
                BaseAgent.this.acceptConnection((com.oplus.ocs.icdf.model.a) this.f28395a);
            } else {
                BaseAgent.this.rejectConnection(this.f28395a);
                BaseAgent.this.onCreateCommonChannelResponse(CreateChannelResult.valueToStatus(0), this.f28395a, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.b, a.InterfaceC0265a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PeerAgent f28399a;

        public d(PeerAgent peerAgent) {
            this.f28399a = peerAgent;
        }

        @Override // com.oplus.ocs.icdf.a.b
        public void a(int i10, CommonChannel commonChannel) {
            BaseAgent.this.onCreateCommonChannelResponse(CreateChannelResult.valueToStatus(i10), this.f28399a, commonChannel);
        }

        @Override // com.oplus.ocs.icdf.a.InterfaceC0265a
        public void a() {
            BaseAgent.this.onPeerAgentDown(this.f28399a, 0);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PeerAgent f28401a;

        public e(PeerAgent peerAgent) {
            this.f28401a = peerAgent;
        }

        @Override // com.oplus.ocs.icdf.a.d
        public void a(int i10, AbstractC1194d abstractC1194d) {
            BaseAgent.this.onCreateGrpcChannelResponse(CreateChannelResult.valueToStatus(i10), this.f28401a, abstractC1194d);
        }

        @Override // com.oplus.ocs.icdf.a.InterfaceC0265a
        public void a() {
            BaseAgent.this.onPeerAgentDown(this.f28401a, 0);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PeerAgent f28403a;

        public f(PeerAgent peerAgent) {
            this.f28403a = peerAgent;
        }

        @Override // com.oplus.ocs.icdf.a.b
        public void a(int i10, CommonChannel commonChannel) {
            BaseAgent.this.onCreateExtraCommonChannelResponse(CreateChannelResult.valueToStatus(i10), this.f28403a, commonChannel);
        }
    }

    public BaseAgent() {
        this(3, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createCommonServerChannel(PeerAgent peerAgent, a.b bVar) {
        this.mChannelManager.a(peerAgent, new c(peerAgent, bVar));
    }

    private int getChannelType(PeerAgent peerAgent) {
        return this.mDefaultChannelType;
    }

    private InterfaceC1192b getGrpcServiceObject() {
        String onReadGrpcServiceClassName = onReadGrpcServiceClassName();
        ICDFLog.d(TAG, "getGrpcServiceObject, serviceImplClass: " + onReadGrpcServiceClassName);
        if (onReadGrpcServiceClassName != null && !onReadGrpcServiceClassName.equals("")) {
            try {
                return (InterfaceC1192b) Class.forName(onReadGrpcServiceClassName).getDeclaredConstructor(null).newInstance(null);
            } catch (Exception e10) {
                ICDFLog.e(TAG, "getGrpcServiceObject failed, " + e10);
                return null;
            }
        }
        return onReadGrpcServiceObject();
    }

    public void allowConnection(PeerAgent peerAgent) {
        ICDFLog.i(TAG, "allow Connection " + peerAgent.getAgentId());
        int channelType = getChannelType(peerAgent);
        if (channelType != 1 && channelType != 2) {
            if (channelType == 3) {
                createCommonServerChannel(peerAgent, new b(peerAgent));
                return;
            }
            ICDFLog.e(TAG, "not support customize channel: " + channelType);
            rejectConnection(peerAgent);
            onCreateCommonChannelResponse(CreateChannelResult.valueToStatus(0), peerAgent, null);
            return;
        }
        InterfaceC1192b grpcServiceObject = getGrpcServiceObject();
        if (grpcServiceObject == null) {
            ICDFLog.e(TAG, "reject connection request from peerAgent " + peerAgent.getAgentId());
            rejectConnection(peerAgent);
            return;
        }
        this.mChannelManager.a(grpcServiceObject, new a(peerAgent));
    }

    public void configRpcMethod(String str, int i10, int i11, boolean z10) {
        ICDFLog.i(TAG, "config rpc method: " + str + ",type " + i10 + ",channel " + i11 + ",encrypt " + z10);
        if (str != null && (i10 == 1 || i10 == 2)) {
            if (i10 == 1) {
                int serviceChannelSize = getServiceChannelSize();
                for (int i12 = 0; i12 < serviceChannelSize; i12++) {
                    if (getServiceChannelId(i12) != i11) {
                    }
                }
                ICDFLog.e(TAG, "config rpc method failed, unknown channelId");
                return;
            }
            this.mChannelManager.a(str, new p(str, i10, i11, false, z10));
            return;
        }
        ICDFLog.e(TAG, "config rpc method failed, invalid args");
    }

    public void createCommonChannel(PeerAgent peerAgent, int i10) {
        if (getAgentRole() != 1) {
            ICDFLog.e(TAG, "can not create CommonChannel from provider");
            onCreateCommonChannelResponse(CreateChannelResult.FAILURE, peerAgent, null);
        } else {
            this.mChannelManager.a(peerAgent, i10, new d(peerAgent));
        }
    }

    public void createExtraCommonChannel(PeerAgent peerAgent, int i10) {
        if (getAgentRole() != 1) {
            ICDFLog.e(TAG, "can not create ExtraCommonChannel from provider");
            onCreateExtraCommonChannelResponse(CreateChannelResult.FAILURE, peerAgent, null);
        } else {
            this.mChannelManager.b(peerAgent, i10, new f(peerAgent));
        }
    }

    public void createGrpcChannel(PeerAgent peerAgent, int i10) {
        if (getAgentRole() != 1) {
            ICDFLog.e(TAG, "can not create GrpcChannel from provider");
            onCreateGrpcChannelResponse(CreateChannelResult.FAILURE, peerAgent, null);
        } else {
            this.mChannelManager.a(peerAgent, i10, new e(peerAgent));
        }
    }

    public void destroyGrpcChannel(PeerAgent peerAgent) {
        this.mChannelManager.a(peerAgent);
    }

    public synchronized void findPeerAgent() {
        super.findOafPeerAgents();
    }

    public void onConnectionRequest(PeerAgent peerAgent) {
        ICDFLog.d(TAG, "invalid implementation of BaseAgent.onConnectionRequest, it should be override!");
    }

    public void onConnectionResponse(PeerAgent peerAgent, CreateChannelResult createChannelResult) {
        ICDFLog.d(TAG, "invalid implementation of BaseAgent.onConnectionResponse, it should be override!");
    }

    @Override // com.oplus.ocs.icdf.OafBaseAgentAdapter, com.heytap.accessory.BaseAgent, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mChannelManager = new com.oplus.ocs.icdf.a(getApplicationContext(), this);
    }

    public void onCreateCommonChannelResponse(CreateChannelResult createChannelResult, PeerAgent peerAgent, CommonChannel commonChannel) {
        ICDFLog.d(TAG, "invalid implementation of BaseAgent.onCreateCommonChannelResponse, it should be override!");
    }

    public void onCreateExtraCommonChannelResponse(CreateChannelResult createChannelResult, PeerAgent peerAgent, CommonChannel commonChannel) {
        ICDFLog.d(TAG, "invalid implementation of BaseAgent.onCreateExtraCommonChannelResponse, it should be override!");
    }

    public void onCreateGrpcChannelResponse(CreateChannelResult createChannelResult, PeerAgent peerAgent, AbstractC1194d abstractC1194d) {
        ICDFLog.d(TAG, "invalid implementation of BaseAgent.onCreateGrpcChannelResponse, it should be override!");
    }

    @Override // com.oplus.ocs.icdf.OafBaseAgentAdapter, com.heytap.accessory.BaseAgent, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mChannelManager.a();
        ICDFLog.d(TAG, "onDestroy finished");
    }

    public void onFindPeerAgentResponse(FindPeerAgentResult findPeerAgentResult, PeerAgent[] peerAgentArr) {
        ICDFLog.d(TAG, "invalid implementation of BaseAgent.onFindPeerAgentResponse, it should be override!");
    }

    @Override // com.oplus.ocs.icdf.OafBaseAgentAdapter
    public final void onOafConnectionLost(PeerAgent peerAgent, int i10) {
        if (getAgentRole() == 0) {
            onPeerAgentDown(peerAgent, i10);
        }
    }

    @Override // com.oplus.ocs.icdf.OafBaseAgentAdapter
    public final void onOafConnectionRequest(PeerAgent peerAgent) {
        onConnectionRequest(peerAgent);
    }

    @Override // com.oplus.ocs.icdf.OafBaseAgentAdapter
    public final void onOafConnectionResponse(PeerAgent peerAgent, int i10) {
        onConnectionResponse(peerAgent, CreateChannelResult.valueToStatus(i10));
    }

    @Override // com.oplus.ocs.icdf.OafBaseAgentAdapter
    public final void onOafFindResponse(int i10, List<PeerAgent> list) {
        PeerAgent[] peerAgentArr;
        if (i10 == 10003) {
            ICDFLog.w(TAG, "Find peerAgent too frequently");
            return;
        }
        FindPeerAgentResult valueToStatus = FindPeerAgentResult.valueToStatus(i10);
        if (list != null) {
            peerAgentArr = (PeerAgent[]) list.toArray(new PeerAgent[0]);
        } else {
            peerAgentArr = null;
        }
        onFindPeerAgentResponse(valueToStatus, peerAgentArr);
    }

    public void onPeerAgentDown(PeerAgent peerAgent, int i10) {
        ICDFLog.d(TAG, "invalid implementation of BaseAgent.onPeerAgentDown, it should be override");
    }

    public String onReadGrpcServiceClassName() {
        ICDFLog.d(TAG, "invalid implementation of BaseAgent.onReadGrpcServiceClassName, it should be override!");
        return "";
    }

    public InterfaceC1192b onReadGrpcServiceObject() {
        ICDFLog.d(TAG, "invalid implementation of BaseAgent.onReadGrpcServiceObjects, it should be override!");
        return null;
    }

    @Override // com.oplus.ocs.icdf.OafBaseAgentAdapter, com.heytap.accessory.BaseAgent, android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return super.onStartCommand(intent, i10, i11);
    }

    public void rejectConnection(PeerAgent peerAgent) {
        super.rejectConnection((com.oplus.ocs.icdf.model.a) peerAgent);
    }

    public BaseAgent(int i10) {
        this(i10, true);
    }

    public BaseAgent(boolean z10) {
        this(3, z10);
    }

    public BaseAgent(int i10, boolean z10) {
        super(z10);
        this.mChannelManager = null;
        this.mDefaultChannelType = i10;
        ICDFLog.i(TAG, "ICDF SDK 2.2.3, commitId , releaseTime 202412251114");
    }
}
