package com.android.contacts.voicemail.impl.mail;

import android.content.Context;
import java.io.File;

/* compiled from: TempDirectory.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static File f18102a;

    public static File a() {
        File file = f18102a;
        if (file != null) {
            return file;
        }
        throw new RuntimeException("TempDirectory not set.  If in a unit test, call Email.setTempDirectory(context) in setUp().");
    }

    public static void b(Context context) {
        f18102a = context.getCacheDir();
    }
}
