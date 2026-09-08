package com.customize.contacts.importcontact;

import android.os.Handler;
import android.os.Message;

/* compiled from: ImportHandler.java */
/* loaded from: classes3.dex */
public class j extends Handler implements k {

    /* renamed from: a, reason: collision with root package name */
    public long f21442a = 0;

    @Override // com.customize.contacts.importcontact.k
    public void a(String str, int i10) {
        Message obtainMessage = obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.arg1 = i10;
        obtainMessage.obj = str;
        obtainMessage.sendToTarget();
    }

    @Override // com.customize.contacts.importcontact.k
    public void b(int i10) {
        Message obtainMessage = obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.arg1 = i10;
        obtainMessage.sendToTarget();
    }

    @Override // com.customize.contacts.importcontact.k
    public void c(int i10) {
        Message obtainMessage = obtainMessage();
        obtainMessage.what = 2;
        obtainMessage.arg1 = i10;
        g(obtainMessage);
    }

    @Override // com.customize.contacts.importcontact.k
    public void d() {
        Message obtainMessage = obtainMessage();
        obtainMessage.what = 9;
        obtainMessage.sendToTarget();
    }

    @Override // com.customize.contacts.importcontact.k
    public void e(int i10, int i11) {
        Message obtainMessage = obtainMessage();
        obtainMessage.what = 3;
        obtainMessage.arg1 = i10;
        obtainMessage.arg2 = i11;
        g(obtainMessage);
    }

    @Override // com.customize.contacts.importcontact.k
    public void f(int i10) {
        Message obtainMessage = obtainMessage();
        obtainMessage.what = 4;
        obtainMessage.arg1 = i10;
        obtainMessage.sendToTarget();
    }

    public final void g(Message message) {
        long currentTimeMillis = System.currentTimeMillis() - this.f21442a;
        if (currentTimeMillis < 1000) {
            sendMessageDelayed(message, 1000 - currentTimeMillis);
        } else {
            sendMessage(message);
        }
    }

    @Override // com.customize.contacts.importcontact.k
    public void onStart() {
        this.f21442a = System.currentTimeMillis();
        Message obtainMessage = obtainMessage();
        obtainMessage.what = 0;
        obtainMessage.sendToTarget();
    }
}
