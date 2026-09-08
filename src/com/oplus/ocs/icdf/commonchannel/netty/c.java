package com.oplus.ocs.icdf.commonchannel.netty;

import android.content.Context;
import com.oplus.ocs.icdf.model.PeerAgent;
import com.oplus.ocs.icdf.utils.HexUtils;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f28491a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<PeerAgent, String> f28492b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, b> f28493c = new ConcurrentHashMap();

    /* loaded from: classes3.dex */
    public class a implements BiConsumer<String, b> {
        public a(c cVar) {
        }

        @Override // java.util.function.BiConsumer
        public void accept(String str, b bVar) {
            bVar.c();
        }
    }

    public c(Context context) {
        this.f28491a = context;
    }

    public synchronized com.oplus.ocs.icdf.commonchannel.b a(PeerAgent peerAgent, String str) {
        ICDFLog.d("ICDF.SocketServerManager", "acquire CommonChannelServer, peerAgent " + peerAgent.getAgentId());
        b bVar = this.f28493c.get(str);
        if (bVar == null) {
            ICDFLog.d("ICDF.SocketServerManager", "Construct new socketServer on " + HexUtils.hideAddress(str));
            bVar = new b(this.f28491a, str);
            if (!bVar.e()) {
                ICDFLog.e("ICDF.SocketServerManager", "socketServer start failed");
                bVar.c();
                return null;
            }
            this.f28493c.put(str, bVar);
            this.f28492b.put(peerAgent, str);
        } else if (!this.f28492b.containsKey(peerAgent)) {
            ICDFLog.d("ICDF.SocketServerManager", "SocketServer reused on another peerAgent " + peerAgent.getAgentId());
            this.f28492b.put(peerAgent, str);
            bVar.b();
        }
        return bVar;
    }

    public synchronized void a(PeerAgent peerAgent) {
        ICDFLog.d("ICDF.SocketServerManager", "release CommonChannelServer, peerAgent " + peerAgent.getAgentId());
        String str = this.f28492b.get(peerAgent);
        if (str == null) {
            return;
        }
        this.f28492b.remove(peerAgent);
        b bVar = this.f28493c.get(str);
        if (bVar == null) {
            return;
        }
        if (bVar.d()) {
            ICDFLog.d("ICDF.SocketServerManager", "All associated peerAgents down, close socketServer");
            bVar.c();
            this.f28493c.remove(str);
        }
    }

    public synchronized void a() {
        ICDFLog.d("ICDF.SocketServerManager", "close");
        this.f28492b.clear();
        this.f28493c.forEach(new a(this));
        this.f28493c.clear();
    }
}
