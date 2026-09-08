package K3;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;

/* compiled from: CustomizeExportHandler.java */
/* loaded from: classes3.dex */
public class a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1627a = false;

    /* renamed from: b, reason: collision with root package name */
    public long f1628b = 0;

    public void a() {
        this.f1627a = true;
    }

    public void b(int i10) {
        Message obtainMessage = obtainMessage();
        obtainMessage.what = 4;
        obtainMessage.arg1 = i10;
        obtainMessage.sendToTarget();
    }

    public void c(int i10, Uri uri) {
        Message obtainMessage = obtainMessage();
        obtainMessage.what = 2;
        obtainMessage.arg1 = i10;
        obtainMessage.obj = uri;
        h(obtainMessage);
    }

    public void d(int i10, int i11) {
        Message obtainMessage = obtainMessage();
        obtainMessage.what = 3;
        obtainMessage.arg1 = i10;
        obtainMessage.arg2 = i11;
        h(obtainMessage);
    }

    public void e() {
        this.f1628b = System.currentTimeMillis();
        Message obtainMessage = obtainMessage();
        obtainMessage.what = 0;
        obtainMessage.sendToTarget();
    }

    public void f(int i10) {
        Message obtainMessage = obtainMessage();
        obtainMessage.what = 9;
        obtainMessage.arg1 = i10;
        obtainMessage.sendToTarget();
    }

    public void g(String str, int i10) {
        Message obtainMessage = obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.arg1 = i10;
        obtainMessage.obj = str;
        obtainMessage.sendToTarget();
    }

    public final void h(Message message) {
        long currentTimeMillis = System.currentTimeMillis() - this.f1628b;
        if (currentTimeMillis < 1000) {
            sendMessageDelayed(message, 1000 - currentTimeMillis);
        } else {
            sendMessage(message);
        }
    }
}
