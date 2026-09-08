package com.oplus.ocs.icdf.commonchannel;

import com.heytap.accessory.bean.UnSupportException;
import com.oplus.ocs.icdf.TrafficClass;
import com.oplus.ocs.icdf.model.PeerAgent;
import java.io.FileDescriptor;
import java.io.InputStream;

/* loaded from: classes3.dex */
public abstract class CommonChannel {
    private PeerAgent peerAgent;

    /* loaded from: classes3.dex */
    public interface BytesListener {
        void onBytesReceived(byte[] bArr);
    }

    /* loaded from: classes3.dex */
    public interface ChannelListener {
        void onClosed(int i10);
    }

    /* loaded from: classes3.dex */
    public interface StreamListener {
        void onRequest(PeerAgent peerAgent, int i10);

        void onStreamReceived(InputStream inputStream);

        void onTransportCanceled(int i10, int i11);

        void onTransportCompleted(int i10, int i11);
    }

    public CommonChannel(PeerAgent peerAgent) {
        this.peerAgent = peerAgent;
    }

    public abstract void close();

    public PeerAgent getPeerAgent() {
        return this.peerAgent;
    }

    public int getProtocol() {
        return 0;
    }

    public abstract boolean isClosed();

    public void sendBytes(byte[] bArr) {
        sendBytes(bArr, false);
    }

    public abstract void sendBytes(byte[] bArr, boolean z10);

    public int sendStream(InputStream inputStream) {
        throw new UnSupportException("");
    }

    public void sendBytes(int i10, byte[] bArr, boolean z10) {
        throw new UnSupportException("");
    }

    public int sendStream(FileDescriptor fileDescriptor) {
        throw new UnSupportException("");
    }

    public void cancelAllStreamTransport() {
    }

    public void cancelStreamTransport(int i10) {
    }

    public void receiveStream(int i10) {
    }

    public void rejectStream(int i10) {
    }

    public void setBytesListener(BytesListener bytesListener) {
    }

    public void setChannelListener(ChannelListener channelListener) {
    }

    public void setP2pPowerSave(boolean z10) {
    }

    public void setStreamListener(StreamListener streamListener) {
    }

    public void setTcpIpTos(TrafficClass trafficClass) {
    }

    public void setTcpNoDelay(boolean z10) {
    }
}
