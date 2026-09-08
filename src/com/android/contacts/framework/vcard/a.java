package com.android.contacts.framework.vcard;

import android.content.Entity;
import android.content.EntityIterator;
import android.database.Cursor;
import android.os.RemoteException;

/* compiled from: VCardComposer.java */
/* loaded from: classes.dex */
public abstract class a implements EntityIterator {

    /* renamed from: a, reason: collision with root package name */
    public final Cursor f16476a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f16477b = false;

    public a(Cursor cursor) {
        this.f16476a = cursor;
    }

    public abstract Entity a(Cursor cursor);

    @Override // java.util.Iterator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Entity next() {
        if (!this.f16477b) {
            if (!this.f16476a.isAfterLast()) {
                try {
                    return a(this.f16476a);
                } catch (RemoteException e10) {
                    throw new RuntimeException("caught a remote exception, this process will die soon" + e10);
                }
            }
            throw new IllegalStateException("you may only call next() if hasNext() is true");
        }
        throw new IllegalStateException("calling next() when the iterator is closed");
    }

    @Override // android.content.EntityIterator
    public final void close() {
        if (this.f16477b) {
            H7.b.c("VCardComposer", "closing when already closed");
        } else {
            this.f16477b = true;
            this.f16476a.close();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f16477b) {
            H7.b.c("VCardComposer", "calling hasNext() when the iterator is closed");
            return false;
        }
        if (this.f16476a.isAfterLast()) {
            return false;
        }
        long j10 = this.f16476a.getLong(13);
        if (!this.f16476a.moveToPrevious()) {
            return false;
        }
        if (j10 == this.f16476a.getLong(13)) {
            this.f16476a.moveToNext();
            return true;
        }
        this.f16476a.moveToNext();
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove not supported by EntityIterators");
    }

    @Override // android.content.EntityIterator
    public final void reset() {
        if (!this.f16477b) {
            this.f16476a.moveToFirst();
            return;
        }
        throw new IllegalStateException("calling reset() when the iterator is closed");
    }
}
