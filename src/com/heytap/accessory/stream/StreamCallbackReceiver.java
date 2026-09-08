package com.heytap.accessory.stream;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.stream.StreamTransfer;
import m5.j;
import n5.C1371a;
import org.json.JSONException;
import p5.d;
import p5.h;

/* loaded from: classes3.dex */
public class StreamCallbackReceiver extends ResultReceiver {

    /* renamed from: b, reason: collision with root package name */
    public static final String f25336b = "StreamCallbackReceiver";

    /* renamed from: a, reason: collision with root package name */
    public StreamTransfer.b f25337a;

    public StreamCallbackReceiver(Handler handler, StreamTransfer.b bVar) {
        super(handler);
        this.f25337a = bVar;
    }

    public final void b(Bundle bundle) {
        int i10 = bundle.getInt("transactionId");
        long j10 = bundle.getLong(AFConstants.EXTRA_CONNECTION_ID);
        C1371a.g(f25336b, "Transfer Complete,transactionId:" + i10);
        this.f25337a.onTransferCompleted(j10, i10, 0);
    }

    public final void d(String str) {
        d dVar = new d();
        try {
            dVar.a(str);
            int[] c10 = dVar.c();
            int b10 = dVar.b();
            C1371a.k(f25336b, "onCancelAllCompleted  errorCode:" + b10);
            this.f25337a.a(c10, b10);
        } catch (JSONException e10) {
            C1371a.d(f25336b, "onMultiTransferError ex:" + e10);
        }
    }

    public final void f(String str) {
        String str2 = f25336b;
        C1371a.d(str2, "ST Error");
        h hVar = new h();
        try {
            hVar.a(str);
            long b10 = hVar.b();
            int d10 = hVar.d();
            int c10 = hVar.c();
            C1371a.k(str2, "transactionId:" + d10 + " errorCode:" + c10);
            this.f25337a.onTransferCompleted(b10, d10, c10);
        } catch (JSONException e10) {
            C1371a.d(f25336b, "onTransferError ex:" + e10);
        }
    }

    public final void h(String str) {
        j jVar = new j();
        try {
            jVar.a(str);
            long b10 = jVar.b();
            int d10 = jVar.d();
            C1371a.g(f25336b, "onReceiveResult mConnectionId:" + b10 + " mTransactionId:" + d10);
            this.f25337a.b(b10, d10);
        } catch (Exception e10) {
            C1371a.d(f25336b, "onTransferSetupRsp ex:" + e10);
        }
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i10, Bundle bundle) {
        String string = bundle.getString("CallBackJson");
        switch (i10) {
            case 99:
                h(string);
                return;
            case 100:
            default:
                C1371a.d(f25336b, "Wrong resultCode");
                return;
            case 101:
                b(bundle);
                return;
            case 102:
                f(string);
                return;
            case 103:
                d(string);
                return;
        }
    }
}
