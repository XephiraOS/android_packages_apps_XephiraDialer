package com.android.contacts.framework.virtualsupport;

import android.content.Context;
import com.oplus.ocs.icdf.BaseJobAgent;
import com.oplus.ocs.icdf.OafBaseJobAgentAdapter;
import com.oplus.ocs.icdf.RequestJobAgentCallback;
import com.oplus.ocs.icdf.model.PeerAgent;
import kotlin.jvm.internal.i;

/* compiled from: ChatCallProvider.kt */
/* loaded from: classes.dex */
public final class ChatCallProvider extends BaseJobAgent {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ChatCallProvider";

    /* compiled from: ChatCallProvider.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final void getInstance(Context context, RequestJobAgentCallback callback) {
            i.f(callback, "callback");
            OafBaseJobAgentAdapter.getInstance(context, ChatCallProvider.class.getName(), callback);
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatCallProvider(Context context) {
        super(context, 1);
        i.f(context, "context");
        H7.b.b(TAG, "init ChatCallProvider");
    }

    @Override // com.oplus.ocs.icdf.BaseJobAgent, com.oplus.ocs.icdf.OafBaseJobAgentAdapter
    public void destroy() {
        H7.b.b(TAG, "destroy ChatCallProvider");
        super.destroy();
    }

    @Override // com.oplus.ocs.icdf.BaseJobAgent
    public void onConnectionRequest(PeerAgent peerAgent) {
        i.f(peerAgent, "peerAgent");
        H7.b.b(TAG, "onConnectionRequest, accept");
        allowConnection(peerAgent);
    }

    @Override // com.oplus.ocs.icdf.BaseJobAgent
    public void onPeerAgentDown(PeerAgent peerAgent, int i10) {
        i.f(peerAgent, "peerAgent");
        H7.b.b(TAG, "onPeerAgentDown " + peerAgent.getAgentId());
    }

    @Override // com.oplus.ocs.icdf.BaseJobAgent
    public String onReadGrpcServiceClassName() {
        H7.b.b(TAG, "onReadGrpcServiceClassName");
        String name = ChatCallImpl.class.getName();
        i.e(name, "ChatCallImpl::class.java.name");
        return name;
    }
}
