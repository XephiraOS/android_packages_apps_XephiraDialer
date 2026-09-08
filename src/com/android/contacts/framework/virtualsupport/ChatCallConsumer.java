package com.android.contacts.framework.virtualsupport;

import android.content.Context;
import android.util.Log;
import com.oplus.ocs.icdf.BaseJobAgent;
import com.oplus.ocs.icdf.CreateChannelResult;
import com.oplus.ocs.icdf.OafBaseJobAgentAdapter;
import com.oplus.ocs.icdf.RequestJobAgentCallback;
import com.oplus.ocs.icdf.model.PeerAgent;
import j9.AbstractC1194d;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.i;

/* compiled from: ChatCallConsumer.kt */
/* loaded from: classes.dex */
public final class ChatCallConsumer extends BaseJobAgent {
    private static final int CHANNEL_ID = 101;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ChatCallConsumer";
    private static CountDownLatch countDownLatch;
    private AbstractC1194d channel;
    private boolean isCreatingChannel;
    private String packageName;
    private PeerAgent peerAgent;

    /* compiled from: ChatCallConsumer.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final void getInstance(Context context, CountDownLatch countDown, RequestJobAgentCallback callback) {
            i.f(countDown, "countDown");
            i.f(callback, "callback");
            OafBaseJobAgentAdapter.getInstance(context, ChatCallConsumer.class.getName(), callback);
            ChatCallConsumer.countDownLatch = countDown;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatCallConsumer(Context context) {
        super(context, 1);
        i.f(context, "context");
        String packageName = context.getPackageName();
        i.e(packageName, "context.packageName");
        this.packageName = packageName;
        H7.b.b(TAG, "init ChatCallConsumer");
        configRpcMethod("RouteChat/chat", 1, 101, false);
        findPeerAgent();
    }

    @Override // com.oplus.ocs.icdf.BaseJobAgent, com.oplus.ocs.icdf.OafBaseJobAgentAdapter
    public void destroy() {
        H7.b.b(TAG, "destroy ChatCallConsumer");
        super.destroy();
    }

    public final void disconnect() {
        if (this.channel == null) {
            Log.e(TAG, "disconnect failed, Channel is null");
            return;
        }
        destroyGrpcChannel(this.peerAgent);
        this.channel = null;
        this.peerAgent = null;
    }

    public final AbstractC1194d getChannel() {
        return this.channel;
    }

    public final PeerAgent getPeerAgent() {
        return this.peerAgent;
    }

    @Override // com.oplus.ocs.icdf.BaseJobAgent
    public void onCreateGrpcChannelResponse(CreateChannelResult ret, PeerAgent peerAgent, AbstractC1194d abstractC1194d) {
        i.f(ret, "ret");
        i.f(peerAgent, "peerAgent");
        if (!i.b(CreateChannelResult.SUCCESS, ret) && !i.b(CreateChannelResult.SUCCESS_PROTOCOL_DEFAULT, ret)) {
            H7.b.b(TAG, "create grpc channel failed, reason: " + ret);
        } else {
            H7.b.b(TAG, "create grpc channel success, ret: " + ret);
            this.channel = abstractC1194d;
            this.peerAgent = peerAgent;
        }
        this.isCreatingChannel = false;
        CountDownLatch countDownLatch2 = countDownLatch;
        if (countDownLatch2 != null) {
            countDownLatch2.countDown();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
    
        H7.b.b(com.android.contacts.framework.virtualsupport.ChatCallConsumer.TAG, "peerAgents == " + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0080, code lost:
    
        if (r7.isCreatingChannel != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0089, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008a, code lost:
    
        r7.isCreatingChannel = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008c, code lost:
    
        if (r2 == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0086, code lost:
    
        r7 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0087, code lost:
    
        r0 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009a, code lost:
    
        if (r0 != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a0, code lost:
    
        r8.countDown();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a3, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0082, code lost:
    
        createGrpcChannel(r4, 0);
     */
    @Override // com.oplus.ocs.icdf.BaseJobAgent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onFindPeerAgentResponse(com.oplus.ocs.icdf.FindPeerAgentResult r8, com.oplus.ocs.icdf.model.PeerAgent[] r9) {
        /*
            r7 = this;
            java.lang.String r0 = "result"
            kotlin.jvm.internal.i.f(r8, r0)
            java.lang.String r0 = "peerAgents"
            kotlin.jvm.internal.i.f(r9, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onFindPeerAgentResponse, result = "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ChatCallConsumer"
            android.util.Log.i(r1, r0)
            r0 = 1
            int r2 = r9.length     // Catch: java.lang.Throwable -> L31
            if (r2 != 0) goto L33
            java.lang.String r7 = "peerAgents == null || peerAgents.length < 1"
            android.util.Log.e(r1, r7)     // Catch: java.lang.Throwable -> L31
            java.util.concurrent.CountDownLatch r7 = com.android.contacts.framework.virtualsupport.ChatCallConsumer.countDownLatch
            if (r7 == 0) goto L30
            r7.countDown()
        L30:
            return
        L31:
            r7 = move-exception
            goto L9a
        L33:
            com.oplus.ocs.icdf.FindPeerAgentResult r2 = com.oplus.ocs.icdf.FindPeerAgentResult.SUCCESS     // Catch: java.lang.Throwable -> L31
            boolean r2 = kotlin.jvm.internal.i.b(r2, r8)     // Catch: java.lang.Throwable -> L31
            if (r2 != 0) goto L57
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L31
            r7.<init>()     // Catch: java.lang.Throwable -> L31
            java.lang.String r9 = "onFindPeerAgentsResponse result == "
            r7.append(r9)     // Catch: java.lang.Throwable -> L31
            r7.append(r8)     // Catch: java.lang.Throwable -> L31
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L31
            android.util.Log.e(r1, r7)     // Catch: java.lang.Throwable -> L31
            java.util.concurrent.CountDownLatch r7 = com.android.contacts.framework.virtualsupport.ChatCallConsumer.countDownLatch
            if (r7 == 0) goto L56
            r7.countDown()
        L56:
            return
        L57:
            int r8 = r9.length     // Catch: java.lang.Throwable -> L31
            r2 = 0
            r3 = r2
        L5a:
            if (r3 >= r8) goto L92
            r4 = r9[r3]     // Catch: java.lang.Throwable -> L31
            java.lang.String r5 = r4.getAppName()     // Catch: java.lang.Throwable -> L31
            java.lang.String r6 = r7.packageName     // Catch: java.lang.Throwable -> L31
            boolean r5 = android.text.TextUtils.equals(r5, r6)     // Catch: java.lang.Throwable -> L31
            if (r5 == 0) goto L8f
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L31
            r8.<init>()     // Catch: java.lang.Throwable -> L31
            java.lang.String r9 = "peerAgents == "
            r8.append(r9)     // Catch: java.lang.Throwable -> L31
            r8.append(r4)     // Catch: java.lang.Throwable -> L31
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L31
            H7.b.b(r1, r8)     // Catch: java.lang.Throwable -> L31
            boolean r8 = r7.isCreatingChannel     // Catch: java.lang.Throwable -> L31
            if (r8 != 0) goto L89
            r7.createGrpcChannel(r4, r2)     // Catch: java.lang.Throwable -> L86
            goto L8a
        L86:
            r7 = move-exception
            r0 = r2
            goto L9a
        L89:
            r2 = r0
        L8a:
            r7.isCreatingChannel = r0     // Catch: java.lang.Throwable -> L86
            if (r2 == 0) goto L99
            goto L92
        L8f:
            int r3 = r3 + 1
            goto L5a
        L92:
            java.util.concurrent.CountDownLatch r7 = com.android.contacts.framework.virtualsupport.ChatCallConsumer.countDownLatch
            if (r7 == 0) goto L99
            r7.countDown()
        L99:
            return
        L9a:
            if (r0 == 0) goto La3
            java.util.concurrent.CountDownLatch r8 = com.android.contacts.framework.virtualsupport.ChatCallConsumer.countDownLatch
            if (r8 == 0) goto La3
            r8.countDown()
        La3:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.virtualsupport.ChatCallConsumer.onFindPeerAgentResponse(com.oplus.ocs.icdf.FindPeerAgentResult, com.oplus.ocs.icdf.model.PeerAgent[]):void");
    }

    @Override // com.oplus.ocs.icdf.BaseJobAgent
    public void onPeerAgentDown(PeerAgent peerAgent, int i10) {
        i.f(peerAgent, "peerAgent");
        H7.b.b(TAG, "onPeerAgentDown " + peerAgent.getAgentId());
        disconnect();
    }

    public final void reconnect(CountDownLatch countDown) {
        i.f(countDown, "countDown");
        countDownLatch = countDown;
        findPeerAgent();
    }
}
