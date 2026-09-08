package com.android.contacts.framework.vcard;

import java.io.InputStream;

/* compiled from: VCardParser.java */
/* loaded from: classes.dex */
public abstract class m {
    public abstract void a(l lVar);

    public abstract void b();

    public abstract void c(InputStream inputStream);

    @Deprecated
    public void d(InputStream inputStream, l lVar) {
        a(lVar);
        c(inputStream);
    }
}
