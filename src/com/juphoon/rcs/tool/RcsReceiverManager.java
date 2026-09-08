package com.juphoon.rcs.tool;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.juphoon.rcs.tool.RcsServiceManager;
import com.juphoon.service.rcs.IRcsCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class RcsReceiverManager {

    /* renamed from: a, reason: collision with root package name */
    public static Handler f25513a;

    /* renamed from: b, reason: collision with root package name */
    public static ArrayList<WeakReference<Object>> f25514b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public static ArrayList<WeakReference<Object>> f25515c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public static ArrayList<WeakReference<Object>> f25516d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public static ArrayList<WeakReference<Object>> f25517e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public static ArrayList<WeakReference<Object>> f25518f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    public static final RcsServiceManager.b f25519g = new RcsServiceManager.b() { // from class: com.juphoon.rcs.tool.RcsReceiverManager.1
        @Override // com.juphoon.rcs.tool.RcsServiceManager.b
        public void b(boolean z10, String str) {
            super.b(z10, str);
            if (TextUtils.equals("rcs", str) && z10) {
                try {
                    RcsServiceManager.y().m0(new IRcsCallback.Stub() { // from class: com.juphoon.rcs.tool.RcsReceiverManager.1.1
                        @Override // com.juphoon.service.rcs.IRcsCallback
                        public void m1(String str2, String str3) {
                            Intent intent = new Intent();
                            intent.setAction(str2);
                            intent.putExtra("rcs_json_key", str3);
                            Message obtainMessage = RcsReceiverManager.f25513a.obtainMessage(1);
                            obtainMessage.obj = intent;
                            RcsReceiverManager.f25513a.sendMessage(obtainMessage);
                        }
                    });
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
            }
        }
    };
}
