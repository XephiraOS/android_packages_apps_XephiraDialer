package com.android.contacts.util;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes.dex */
public class EmptyService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
