package com.bumptech.glide;

import com.bumptech.glide.j;
import q3.C1482a;
import q3.InterfaceC1484c;
import s3.C1541l;

/* compiled from: TransitionOptions.java */
/* loaded from: classes.dex */
public abstract class j<CHILD extends j<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1484c<? super TranscodeType> f19379a = C1482a.b();

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final InterfaceC1484c<? super TranscodeType> b() {
        return this.f19379a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return C1541l.d(this.f19379a, ((j) obj).f19379a);
        }
        return false;
    }

    public int hashCode() {
        InterfaceC1484c<? super TranscodeType> interfaceC1484c = this.f19379a;
        if (interfaceC1484c != null) {
            return interfaceC1484c.hashCode();
        }
        return 0;
    }
}
