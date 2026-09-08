package com.android.contacts.voicemail.impl.mail;

import android.content.Context;
import android.net.Network;
import android.net.TrafficStats;
import com.android.contacts.voicemail.impl.OmtpEvents;
import com.android.contacts.voicemail.impl.imap.ImapHelper;
import com.android.incallui.OplusAutoRedial;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* compiled from: MailTransport.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: k, reason: collision with root package name */
    public static final HostnameVerifier f18081k = HttpsURLConnection.getDefaultHostnameVerifier();

    /* renamed from: a, reason: collision with root package name */
    public final Context f18082a;

    /* renamed from: b, reason: collision with root package name */
    public final ImapHelper f18083b;

    /* renamed from: c, reason: collision with root package name */
    public final Network f18084c;

    /* renamed from: d, reason: collision with root package name */
    public final String f18085d;

    /* renamed from: e, reason: collision with root package name */
    public final int f18086e;

    /* renamed from: f, reason: collision with root package name */
    public Socket f18087f;

    /* renamed from: g, reason: collision with root package name */
    public BufferedInputStream f18088g;

    /* renamed from: h, reason: collision with root package name */
    public BufferedOutputStream f18089h;

    /* renamed from: i, reason: collision with root package name */
    public final int f18090i;

    /* renamed from: j, reason: collision with root package name */
    public InetSocketAddress f18091j;

    public e(Context context, ImapHelper imapHelper, Network network, String str, int i10, int i11) {
        this.f18082a = context;
        this.f18083b = imapHelper;
        this.f18084c = network;
        this.f18085d = str;
        this.f18086e = i10;
        this.f18090i = i11;
    }

    public boolean a() {
        if ((this.f18090i & 8) != 0) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if ((this.f18090i & 1) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e clone() {
        return new e(this.f18082a, this.f18083b, this.f18084c, this.f18085d, this.f18086e, this.f18090i);
    }

    public void d() {
        try {
            this.f18088g.close();
        } catch (Exception unused) {
        }
        try {
            this.f18089h.close();
        } catch (Exception unused2) {
        }
        try {
            this.f18087f.close();
        } catch (Exception unused3) {
        }
        this.f18088g = null;
        this.f18089h = null;
        this.f18087f = null;
    }

    public Socket e() {
        if (this.f18084c == null) {
            C1.a.e("MailTransport", "createSocket: network not specified");
            return new Socket();
        }
        try {
            C1.a.e("MailTransport", "createSocket: network specified");
            TrafficStats.setThreadStatsTag(53250);
            return this.f18084c.getSocketFactory().createSocket();
        } catch (IOException e10) {
            C1.a.a("MailTransport", e10.toString());
            throw new MessagingException(1, e10.toString());
        }
    }

    public String f() {
        return this.f18085d;
    }

    public InputStream g() {
        return this.f18088g;
    }

    public OutputStream h() {
        return this.f18089h;
    }

    public boolean i() {
        Socket socket;
        if (this.f18088g != null && this.f18089h != null && (socket = this.f18087f) != null && socket.isConnected() && !this.f18087f.isClosed()) {
            return true;
        }
        return false;
    }

    public void j() {
        C1.a.a("MailTransport", "*** IMAP open ");
        ArrayList arrayList = new ArrayList();
        Network network = this.f18084c;
        if (network == null) {
            arrayList.add(new InetSocketAddress(this.f18085d, this.f18086e));
        } else {
            try {
                InetAddress[] allByName = network.getAllByName(this.f18085d);
                if (allByName.length != 0) {
                    for (InetAddress inetAddress : allByName) {
                        arrayList.add(new InetSocketAddress(inetAddress, this.f18086e));
                    }
                } else {
                    throw new MessagingException(1, "Host name " + this.f18085d + "cannot be resolved on designated network");
                }
            } catch (IOException e10) {
                C1.a.a("MailTransport", "open erroe " + e10);
                this.f18083b.U(OmtpEvents.DATA_CANNOT_RESOLVE_HOST_ON_NETWORK);
                throw new MessagingException(1, e10.toString());
            }
        }
        while (arrayList.size() > 0) {
            this.f18087f = e();
            try {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) arrayList.remove(0);
                this.f18091j = inetSocketAddress;
                this.f18087f.connect(inetSocketAddress, 10000);
                if (b()) {
                    k();
                    return;
                }
                this.f18088g = new BufferedInputStream(this.f18087f.getInputStream(), 1024);
                this.f18089h = new BufferedOutputStream(this.f18087f.getOutputStream(), 512);
                this.f18087f.setSoTimeout(OplusAutoRedial.DELAY_ONE_MIN);
                return;
            } catch (IOException e11) {
                try {
                    C1.a.a("MailTransport", e11.toString());
                    if (arrayList.size() != 0) {
                        try {
                            this.f18087f.close();
                            this.f18087f = null;
                        } catch (IOException e12) {
                            C1.a.b("MailTransport", "e = " + e12);
                        }
                    } else {
                        this.f18083b.U(OmtpEvents.DATA_ALL_SOCKET_CONNECTION_FAILED);
                        throw new MessagingException(1, e11.toString());
                    }
                } catch (Throwable th) {
                    try {
                        this.f18087f.close();
                        this.f18087f = null;
                    } catch (IOException e13) {
                        C1.a.b("MailTransport", "e = " + e13);
                    }
                    throw th;
                }
            }
        }
    }

    public void k() {
        try {
            C1.a.a("MailTransport", "open: converting to TLS socket");
            this.f18087f = HttpsURLConnection.getDefaultSSLSocketFactory().createSocket(this.f18087f, this.f18091j.getHostName(), this.f18091j.getPort(), true);
            if (!a()) {
                l(this.f18087f, this.f18085d);
            }
            this.f18087f.setSoTimeout(OplusAutoRedial.DELAY_ONE_MIN);
            this.f18088g = new BufferedInputStream(this.f18087f.getInputStream(), 1024);
            this.f18089h = new BufferedOutputStream(this.f18087f.getOutputStream(), 512);
        } catch (SSLException e10) {
            C1.a.a("MailTransport", e10.toString());
            throw new CertificateValidationException(e10.getMessage() + e10);
        } catch (IOException e11) {
            C1.a.a("MailTransport", e11.toString());
            throw new MessagingException(1, e11.toString());
        }
    }

    public final void l(Socket socket, String str) {
        SSLSocket sSLSocket = (SSLSocket) socket;
        sSLSocket.startHandshake();
        SSLSession session = sSLSocket.getSession();
        if (session != null) {
            if (f18081k.verify(str, session)) {
                return;
            }
            this.f18083b.U(OmtpEvents.DATA_SSL_INVALID_HOST_NAME);
            throw new SSLPeerUnverifiedException("Certificate hostname not useable for server: " + session.getPeerPrincipal());
        }
        this.f18083b.U(OmtpEvents.DATA_CANNOT_ESTABLISH_SSL_SESSION);
        throw new SSLException("Cannot verify SSL socket without session");
    }

    public void m(String str, String str2) {
        if (str2 != null) {
            C1.a.a("MailTransport", ">>> " + str2);
        } else {
            C1.a.a("MailTransport", ">>> " + str);
        }
        OutputStream h10 = h();
        h10.write(str.getBytes());
        h10.write(13);
        h10.write(10);
        h10.flush();
    }
}
