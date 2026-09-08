package com.heytap.accessory.file;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.heytap.accessory.file.FileTransfer;
import m5.i;
import m5.j;
import n5.C1371a;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class FileCallbackReceiver extends ResultReceiver {

    /* renamed from: b, reason: collision with root package name */
    public static final String f25285b = "FileCallbackReceiver";

    /* renamed from: a, reason: collision with root package name */
    public FileTransfer.c f25286a;

    public FileCallbackReceiver(Handler handler, FileTransfer.c cVar) {
        super(handler);
        this.f25286a = cVar;
    }

    public final void b(String str) {
        C1371a.d(f25285b, "RESULT_FILE_TRANSFER_CANCEL_ALL");
        m5.g gVar = new m5.g();
        try {
            gVar.a(str);
            this.f25286a.a(gVar.c(), gVar.b());
        } catch (JSONException e10) {
            C1371a.d(f25285b, "onCancelAll ex:" + e10);
        }
    }

    public final void d(String str) {
        j jVar = new j();
        try {
            jVar.a(str);
            this.f25286a.onProgressChanged(jVar.b(), jVar.d(), (int) jVar.c());
        } catch (JSONException e10) {
            C1371a.d(f25285b, "onProgressChange ex:" + e10);
        }
    }

    public final void f(String str) {
        j jVar = new j();
        try {
            jVar.a(str);
            long b10 = jVar.b();
            int d10 = jVar.d();
            C1371a.g(f25285b, "onReceiveResult mConnectionId:" + b10 + " mTransactionId：" + d10);
            this.f25286a.b(b10, d10, "");
        } catch (Exception e10) {
            C1371a.d(f25285b, "onSetupRsp ex:" + e10);
        }
    }

    public final void h(String str) {
        m5.h hVar = new m5.h();
        try {
            C1371a.g(f25285b, "Transfer Complete:" + str);
            hVar.a(str);
            long b10 = hVar.b();
            int e10 = hVar.e();
            String d10 = hVar.d();
            String c10 = hVar.c();
            if (c10.length() == 0) {
                this.f25286a.onTransferCompleted(b10, e10, d10, 0);
            } else {
                this.f25286a.onTransferCompleted(b10, e10, c10, 0);
            }
        } catch (JSONException e11) {
            C1371a.d(f25285b, "onTransferComplete ex:" + e11);
        }
    }

    public final void i(String str) {
        C1371a.d(f25285b, "RESULT_FILE_TRANSFER_ERROR");
        i iVar = new i();
        try {
            iVar.a(str);
            this.f25286a.onTransferCompleted(iVar.b(), iVar.d(), null, iVar.c());
        } catch (JSONException e10) {
            C1371a.d(f25285b, "onTransferError ex:" + e10);
        }
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i10, Bundle bundle) {
        String string = bundle.getString("CallBackJson");
        if (string != null) {
            switch (i10) {
                case 99:
                    f(string);
                    return;
                case 100:
                    d(string);
                    return;
                case 101:
                    h(string);
                    return;
                case 102:
                    i(string);
                    return;
                case 103:
                    b(string);
                    return;
                default:
                    C1371a.d(f25285b, "Wrong resultCode:" + i10);
                    return;
            }
        }
    }
}
