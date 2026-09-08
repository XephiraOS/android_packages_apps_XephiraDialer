package com.heytap.accessory;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.heytap.accessory.api.IMsgExpCallback;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.UnSupportException;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.utils.buffer.BufferException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import n5.C1371a;
import r5.h;
import r5.j;
import s5.C1551a;

/* loaded from: classes3.dex */
public abstract class BaseMessage {
    public static final String ACTION_ACCESSORY_MESSAGE_DISABLED = "com.heytap.accessory.action.MESSAGE_DISABLED";
    public static final String ACTION_ACCESSORY_MESSAGE_ENABLED = "com.heytap.accessory.action.MESSAGE_ENABLED";
    public static final String ACTION_ACCESSORY_MESSAGE_RECEIVED = "com.heytap.accessory.action.MESSAGE_RECEIVED";
    public static final int ERROR_AUTHENTICATE_FAILED = 10111;
    public static final int ERROR_LOCAL_PEER_AGENT_NOT_SUPPORTED = 10104;
    public static final int ERROR_NONE = 0;
    public static final int ERROR_PEER_AGENT_INVALID = 10109;
    public static final int ERROR_PEER_AGENT_NOT_SUPPORTED = 10105;
    public static final int ERROR_PEER_AGENT_NO_RESPONSE = 10103;
    public static final int ERROR_PEER_AGENT_UNREACHABLE = 10102;
    public static final int ERROR_PEER_SERVICE_NOT_SUPPORTED = 10106;
    public static final int ERROR_SERVICE_NOT_SUPPORTED = 10107;
    public static final int ERROR_TIMED_OUT = 10108;
    public static final int ERROR_TRANSACTION_FAILED = 10110;
    public static final int ERROR_UNKNOWN = 10101;
    public static final String EXTRA_PEER_ACCESSORY = "com.heytap.accessory.device.extra.PeerAccessory";
    private static final String TAG = "BaseMessage";
    private BaseAdapter mAdapter;
    private Handler mHandler;
    private String mLocalAgentId;
    private MexCallback mMexCallback;

    /* loaded from: classes3.dex */
    public static class MexCallback extends IMsgExpCallback.Stub {

        /* renamed from: f, reason: collision with root package name */
        public WeakReference<BaseMessage> f25150f;

        public MexCallback(BaseMessage baseMessage) {
            this.f25150f = new WeakReference<>(baseMessage);
        }

        @Override // com.heytap.accessory.api.IMsgExpCallback
        public void E3(Bundle bundle) {
            BaseMessage baseMessage = this.f25150f.get();
            if (baseMessage == null) {
                C1371a.d(BaseMessage.TAG, "onMessageReceived(): BaseMessage referecnce is null!");
            } else {
                baseMessage.postAsync(bundle);
            }
        }

        @Override // com.heytap.accessory.api.IMsgExpCallback
        public void J2(Bundle bundle) {
            BaseMessage baseMessage = this.f25150f.get();
            if (baseMessage != null) {
                baseMessage.postStatusAsynch(bundle);
            } else {
                C1371a.d(BaseMessage.TAG, "onMessageReceived(): BaseMessage referecnce is null!");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<BaseMessage> f25151a;

        /* renamed from: b, reason: collision with root package name */
        public Bundle f25152b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f25153c;

        public a(BaseMessage baseMessage, Bundle bundle, boolean z10) {
            this.f25151a = new WeakReference<>(baseMessage);
            this.f25152b = bundle;
            this.f25153c = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseMessage baseMessage = this.f25151a.get();
            if (baseMessage == null) {
                C1371a.d(BaseMessage.TAG, "run(): BaseMessage reference is null!");
            } else if (this.f25153c) {
                baseMessage.onMessageReceived(this.f25152b);
            } else {
                baseMessage.onStatusReceived(this.f25152b);
            }
        }
    }

    public BaseMessage(BaseAgent baseAgent) {
        init(baseAgent.getApplicationContext(), baseAgent.getAgentHandler(), baseAgent.registerMessageInstance(this));
    }

    private boolean checkMessageUnSupport(PeerAgent peerAgent) {
        if (peerAgent != null && peerAgent.getAccessory() != null && peerAgent.getAccessory().supportMessage()) {
            return false;
        }
        return true;
    }

    private void init(Context context, Handler handler, String str) {
        this.mAdapter = BaseAdapter.getDefaultAdapter(context);
        this.mMexCallback = new MexCallback(this);
        this.mHandler = handler;
        if (str != null) {
            try {
                registerAgent(str);
            } catch (GeneralException e10) {
                C1371a.d(TAG, "Failed to create BaseMessage instance: " + e10.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMessageReceived(Bundle bundle) {
        int i10;
        if (this.mLocalAgentId == null) {
            C1371a.d(TAG, "onMessageReceived(): Agent info empty!");
            return;
        }
        bundle.setClassLoader(PeerAgent.class.getClassLoader());
        byte[] byteArray = bundle.getByteArray(AFConstants.EXTRA_READ_BYTES);
        int i11 = bundle.getInt(AFConstants.EXTRA_READ_LENGHT);
        int i12 = bundle.getInt(AFConstants.EXTRA_READ_OFFSET);
        PeerAgent peerAgent = (PeerAgent) bundle.getParcelable("peerAgent");
        int i13 = bundle.getInt("transactionId");
        if (peerAgent != null && peerAgent.getAccessory() != null) {
            long id = peerAgent.getAccessory().getId();
            try {
                if (byteArray == null) {
                    i10 = 10101;
                } else {
                    try {
                        C1371a.c(TAG, "onMessageReceived data:" + i11 + " bytes length:" + byteArray.length + " bytes: " + new String(byteArray));
                        byte[] bArr = new byte[i11];
                        j.a(byteArray, i12, bArr, 0, i11);
                        onReceive(peerAgent, bArr);
                        i10 = 0;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        this.mAdapter.recycle(byteArray);
                        return;
                    }
                }
                this.mAdapter.recycle(byteArray);
                if (i10 != -1) {
                    try {
                        C1371a.c(TAG, "onMessageReceived, sendMessageDeliveryStatus");
                        sendMessageDeliveryStatus(id, peerAgent.getAgentId(), i13, i10);
                        return;
                    } catch (IOException e11) {
                        C1371a.d(TAG, "Failed to send message status! " + e11.getLocalizedMessage());
                        return;
                    }
                }
                return;
            } catch (Throwable th) {
                this.mAdapter.recycle(byteArray);
                throw th;
            }
        }
        C1371a.d(TAG, "onMessageReceived(): PeerAgent is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStatusReceived(Bundle bundle) {
        bundle.setClassLoader(PeerAgent.class.getClassLoader());
        PeerAgent peerAgent = (PeerAgent) bundle.getParcelable("peerAgent");
        int i10 = bundle.getInt("transactionId");
        int i11 = bundle.getInt("errorcode");
        if (i11 == 0) {
            onSent(peerAgent, i10);
        } else {
            onError(peerAgent, i10, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postStatusAsynch(Bundle bundle) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new a(this, bundle, false));
        }
    }

    private int sendMessage(PeerAgent peerAgent, byte[] bArr, boolean z10) {
        int encryptionPaddingLength;
        if (bArr.length != 0) {
            if (bArr.length <= peerAgent.getMaxAllowedDataSize()) {
                if (this.mLocalAgentId != null) {
                    if (!checkMessageUnSupport(peerAgent)) {
                        int i10 = ERROR_TRANSACTION_FAILED;
                        C1551a c1551a = null;
                        try {
                            if (z10) {
                                try {
                                    try {
                                        encryptionPaddingLength = peerAgent.getAccessory().getEncryptionPaddingLength();
                                    } catch (BufferException e10) {
                                        String str = TAG;
                                        C1371a.d(str, "BufferException: " + e10.getLocalizedMessage());
                                        if (0 != 0) {
                                            C1371a.c(str, "messageBuffer: recycle");
                                            c1551a.e();
                                        }
                                    }
                                } catch (IOException e11) {
                                    C1371a.d(TAG, "Send Message Failed! <" + ERROR_TRANSACTION_FAILED + " " + e11.getLocalizedMessage());
                                    throw e11;
                                }
                            } else {
                                encryptionPaddingLength = 0;
                            }
                            C1551a c10 = s5.b.c(h.e() + bArr.length + encryptionPaddingLength + h.c());
                            c10.f(h.e());
                            c10.a(bArr, 0, bArr.length);
                            try {
                                i10 = this.mAdapter.sendMessage(this.mLocalAgentId, peerAgent, z10, c10, bArr.length);
                                if (i10 > 0) {
                                    String str2 = TAG;
                                    C1371a.c(str2, "msg<" + i10 + "> sent: " + bArr.length);
                                    C1371a.c(str2, "messageBuffer: recycle");
                                    c10.e();
                                    return i10;
                                }
                                String str3 = "Send Message Failed - internal error! transId " + i10;
                                C1371a.c(TAG, "transId : " + i10);
                                throw new IOException(str3);
                            } catch (GeneralException e12) {
                                throw new IOException("Send Message Failed", e12);
                            }
                        } catch (Throwable th) {
                            if (0 != 0) {
                                C1371a.c(TAG, "messageBuffer: recycle");
                                c1551a.e();
                            }
                            throw th;
                        }
                    }
                    throw new UnSupportException("the peer agent doesn't support the message feature, please check");
                }
                C1371a.d(TAG, "Send: agentId not retrieved!");
                throw new UnSupportException("Failed to send message - Agent info empty!");
            }
            C1371a.d(TAG, "Send: Data too big:" + bArr.length);
            throw new UnSupportException("Data Too long..! Data size:" + bArr.length + "Max allowed Size:" + peerAgent.getMaxAllowedDataSize() + ". Please check PeerAgent.getMaxAllowedDataSize()");
        }
        C1371a.d(TAG, "Send: invalid data length 0");
        throw new UnSupportException("Invalid data length 0");
    }

    private void sendMessageDeliveryStatus(long j10, String str, int i10, int i11) {
        try {
            this.mAdapter.sendMessageDeliveryStatus(j10, str, i10, i11);
        } catch (GeneralException e10) {
            C1371a.d(TAG, "Ack failed! " + e10);
            throw new IOException("Send Failed", e10);
        }
    }

    public abstract void onError(PeerAgent peerAgent, int i10, int i11);

    public abstract void onReceive(PeerAgent peerAgent, byte[] bArr);

    public abstract void onSent(PeerAgent peerAgent, int i10);

    public void postAsync(Bundle bundle) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new a(this, bundle, true));
        }
    }

    public void registerAgent(String str) {
        String str2 = this.mLocalAgentId;
        if (str2 != null && !str.equalsIgnoreCase(str2)) {
            this.mAdapter.unregisterMexCallback(this.mLocalAgentId);
        }
        this.mLocalAgentId = str;
        this.mAdapter.registerMexCallback(str, this.mMexCallback);
    }

    public int secureSend(PeerAgent peerAgent, byte[] bArr) {
        return sendMessage(peerAgent, bArr, true);
    }

    public int send(PeerAgent peerAgent, byte[] bArr) {
        return sendMessage(peerAgent, bArr, false);
    }

    public void unregisterAgent() {
        try {
            String str = this.mLocalAgentId;
            if (str != null) {
                this.mAdapter.unregisterMexCallback(str);
            }
        } catch (GeneralException e10) {
            C1371a.d(TAG, "Failed to un-register Mex callback! " + e10.getLocalizedMessage());
        }
    }

    public BaseMessage(BaseJobAgent baseJobAgent) {
        init(baseJobAgent.getApplicationContext(), baseJobAgent.getAgentHandler(), baseJobAgent.registerMessageInstance(this));
    }
}
