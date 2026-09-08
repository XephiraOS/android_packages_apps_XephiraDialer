package com.android.contacts.editor;

import com.android.contacts.model.EntityDelta;

/* compiled from: Editor.java */
/* loaded from: classes.dex */
public interface A extends X0.b {

    /* compiled from: Editor.java */
    /* loaded from: classes.dex */
    public interface a {
        void c(int i10);

        void d(A a10);

        void e(String str);
    }

    void a();

    void c();

    void g(com.android.contacts.model.c cVar, EntityDelta.ValuesDelta valuesDelta, EntityDelta entityDelta, boolean z10, ViewIdGenerator viewIdGenerator);

    boolean isEmpty();

    void setDeletable(boolean z10);

    void setEditorListener(a aVar);
}
