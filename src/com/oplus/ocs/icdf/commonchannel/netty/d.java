package com.oplus.ocs.icdf.commonchannel.netty;

import com.heytap.accessory.constant.AFConstants;
import com.oplus.ocs.icdf.utils.HexUtils;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private Socket f28494a;

    /* renamed from: b, reason: collision with root package name */
    private DataOutputStream f28495b;

    /* renamed from: c, reason: collision with root package name */
    private DataInputStream f28496c;

    public d(Socket socket) {
        this.f28494a = socket;
        try {
            if (b()) {
                ICDFLog.i("ICDF.SocketTransport", "SocketTransport server init success");
                socket.setSendBufferSize(524288);
                socket.setReceiveBufferSize(524288);
                socket.setTcpNoDelay(true);
                this.f28495b = new DataOutputStream(socket.getOutputStream());
                this.f28496c = new DataInputStream(socket.getInputStream());
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public void a(String str, int i10) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i10);
        this.f28494a.setSendBufferSize(524288);
        this.f28494a.setReceiveBufferSize(524288);
        this.f28494a.setTcpNoDelay(true);
        this.f28494a.connect(inetSocketAddress, AFConstants.BIND_SERVICE_TIMEOUTMILLIS);
        this.f28495b = new DataOutputStream(this.f28494a.getOutputStream());
        this.f28496c = new DataInputStream(this.f28494a.getInputStream());
        ICDFLog.i("ICDF.SocketTransport", "Socket connect succeed, " + HexUtils.hideAddress(str) + ":" + i10);
    }

    public boolean b() {
        Socket socket = this.f28494a;
        if (socket != null) {
            return socket.isConnected() && !this.f28494a.isClosed();
        }
        ICDFLog.w("ICDF.SocketTransport", "socket not connected, it's already closed");
        return false;
    }

    public int b(byte[] bArr) {
        Boolean bool;
        try {
            bool = Boolean.FALSE;
        } catch (Exception unused) {
            bool = Boolean.TRUE;
        }
        if (!bool.booleanValue()) {
            this.f28495b.write(bArr);
            this.f28495b.flush();
            return bArr.length;
        }
        ICDFLog.e("ICDF.SocketTransport", "write error");
        throw new IOException();
    }

    public void a() {
        ICDFLog.i("ICDF.SocketTransport", "close");
        synchronized (this) {
            try {
                if (this.f28494a != null) {
                    this.f28495b.close();
                    this.f28496c.close();
                    this.f28494a.close();
                    this.f28494a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int a(byte[] bArr) {
        return this.f28496c.read(bArr);
    }

    public void a(boolean z10) {
        try {
            ICDFLog.d("ICDF.SocketTransport", "setTcpNoDelay " + z10);
            this.f28494a.setTcpNoDelay(z10);
        } catch (SocketException e10) {
            e10.printStackTrace();
        }
    }

    public void a(int i10) {
        try {
            ICDFLog.d("ICDF.SocketTransport", "setTcpIpTos " + i10);
            this.f28494a.setTrafficClass(i10);
        } catch (SocketException e10) {
            e10.printStackTrace();
        }
    }
}
