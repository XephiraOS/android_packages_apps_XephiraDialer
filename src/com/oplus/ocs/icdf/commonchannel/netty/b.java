package com.oplus.ocs.icdf.commonchannel.netty;

import android.content.Context;
import com.android.incallui.OplusAutoRedial;
import com.oplus.ocs.icdf.a;
import com.oplus.ocs.icdf.model.PeerAgent;
import com.oplus.ocs.icdf.utils.HexUtils;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/* loaded from: classes3.dex */
public class b extends com.oplus.ocs.icdf.commonchannel.b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f28484a;

    /* renamed from: b, reason: collision with root package name */
    private final String f28485b;

    /* renamed from: c, reason: collision with root package name */
    private ServerSocket f28486c;

    /* renamed from: d, reason: collision with root package name */
    private volatile int f28487d = 1;

    /* loaded from: classes3.dex */
    public class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.b f28488a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PeerAgent f28489b;

        public a(a.b bVar, PeerAgent peerAgent) {
            this.f28488a = bVar;
            this.f28489b = peerAgent;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (b.this) {
                ICDFLog.d("ICDF.SocketCommonChannelServer", "acceptThread start");
                try {
                    Socket accept = b.this.f28486c.accept();
                    ICDFLog.v("ICDF.SocketCommonChannelServer", "accept connection, client " + HexUtils.hideAddress(accept.getInetAddress().getHostAddress()));
                    this.f28488a.a(0, new com.oplus.ocs.icdf.commonchannel.netty.a(b.this.f28484a, this.f28489b, new d(accept)));
                } catch (IOException e10) {
                    ICDFLog.e("ICDF.SocketCommonChannelServer", "timeout: catch close exception!");
                    e10.printStackTrace();
                    this.f28488a.a(1, null);
                }
            }
        }
    }

    public b(Context context, String str) {
        this.f28484a = context;
        this.f28485b = str;
    }

    public synchronized void c() {
        ICDFLog.i("ICDF.SocketCommonChannelServer", "close");
        ServerSocket serverSocket = this.f28486c;
        if (serverSocket == null) {
            return;
        }
        try {
            serverSocket.close();
            this.f28486c = null;
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public synchronized boolean d() {
        boolean z10;
        z10 = true;
        this.f28487d--;
        ICDFLog.v("ICDF.SocketCommonChannelServer", "delReference, ref = " + this.f28487d);
        if (this.f28487d != 0) {
            z10 = false;
        }
        return z10;
    }

    public synchronized boolean e() {
        ServerSocket serverSocket = this.f28486c;
        if (serverSocket != null && !serverSocket.isClosed()) {
            return true;
        }
        try {
            ServerSocket serverSocket2 = new ServerSocket();
            this.f28486c = serverSocket2;
            serverSocket2.setReceiveBufferSize(524288);
            this.f28486c.bind(new InetSocketAddress(InetAddress.getByName(this.f28485b), 0));
            this.f28486c.setSoTimeout(OplusAutoRedial.DELAY_FIVE_SECOND);
            ICDFLog.d("ICDF.SocketCommonChannelServer", "ServerSocket started, " + HexUtils.hideAddress(this.f28486c.getInetAddress().getHostAddress()) + ":" + a());
            return true;
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // com.oplus.ocs.icdf.commonchannel.b
    public int a() {
        ServerSocket serverSocket = this.f28486c;
        if (serverSocket == null) {
            ICDFLog.w("ICDF.SocketCommonChannelServer", "getPort, ServerSocket is null");
            return 0;
        }
        return serverSocket.getLocalPort();
    }

    public synchronized void b() {
        this.f28487d++;
        ICDFLog.v("ICDF.SocketCommonChannelServer", "addReference, ref = " + this.f28487d);
    }

    @Override // com.oplus.ocs.icdf.commonchannel.b
    public synchronized void a(PeerAgent peerAgent, a.b bVar) {
        new a(bVar, peerAgent).start();
    }
}
