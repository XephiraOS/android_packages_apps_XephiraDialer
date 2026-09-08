package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: JsonArray.java */
/* loaded from: classes3.dex */
public final class g extends j implements Iterable<j> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<j> f24746a = new ArrayList<>();

    public boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof g) || !((g) obj).f24746a.equals(this.f24746a))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f24746a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<j> iterator() {
        return this.f24746a.iterator();
    }

    public void k(j jVar) {
        if (jVar == null) {
            jVar = k.f24815a;
        }
        this.f24746a.add(jVar);
    }

    public j l(int i10) {
        return this.f24746a.get(i10);
    }

    public int size() {
        return this.f24746a.size();
    }
}
