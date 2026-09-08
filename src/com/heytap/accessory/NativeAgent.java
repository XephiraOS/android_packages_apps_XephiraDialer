package com.heytap.accessory;

import android.os.Bundle;
import android.os.Message;
import com.heytap.accessory.api.IPeerAgentCallback;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.constant.AFConstants;
import java.util.ArrayList;
import java.util.List;
import n5.C1371a;

/* loaded from: classes3.dex */
public abstract class NativeAgent extends BaseAgent {

    /* renamed from: a, reason: collision with root package name */
    public static final String f25157a = "NativeAgent";

    /* loaded from: classes3.dex */
    public class PeerAgentCallback extends IPeerAgentCallback.Stub {

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ NativeAgent f25158f;

        @Override // com.heytap.accessory.api.IPeerAgentCallback
        public void T2(Bundle bundle) {
            C1371a.i(NativeAgent.f25157a, "FindPeer response received.");
            bundle.setClassLoader(PeerAgent.class.getClassLoader());
            if (bundle.containsKey("errorcode")) {
                int i10 = bundle.getInt("errorcode");
                C1371a.d(NativeAgent.f25157a, "Peer Not Found:Error - " + i10);
                Message obtainMessage = this.f25158f.mBackgroundWorker.obtainMessage();
                obtainMessage.what = 3;
                obtainMessage.arg1 = i10;
                this.f25158f.mBackgroundWorker.sendMessage(obtainMessage);
                return;
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(AFConstants.EXTRA_PEER_AGENTS);
            if (parcelableArrayList != null) {
                C1371a.g(NativeAgent.f25157a, parcelableArrayList.size() + " Peer agent(s) found");
                Message obtainMessage2 = this.f25158f.mBackgroundWorker.obtainMessage();
                obtainMessage2.what = 3;
                obtainMessage2.arg1 = 0;
                obtainMessage2.obj = parcelableArrayList.toArray(new PeerAgent[parcelableArrayList.size()]);
                this.f25158f.mBackgroundWorker.sendMessage(obtainMessage2);
                return;
            }
            C1371a.d(NativeAgent.f25157a, "Find Peer - invalid response from Accessory Framework");
        }

        @Override // com.heytap.accessory.api.IPeerAgentCallback
        public void H7(Bundle bundle) {
        }
    }

    public void b(int i10, List<PeerAgent> list) {
    }
}
