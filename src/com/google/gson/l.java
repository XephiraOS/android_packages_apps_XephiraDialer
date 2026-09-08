package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

/* compiled from: JsonObject.java */
/* loaded from: classes3.dex */
public final class l extends j {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedTreeMap<String, j> f24816a = new LinkedTreeMap<>(false);

    public boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof l) || !((l) obj).f24816a.equals(this.f24816a))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f24816a.hashCode();
    }

    public void k(String str, j jVar) {
        LinkedTreeMap<String, j> linkedTreeMap = this.f24816a;
        if (jVar == null) {
            jVar = k.f24815a;
        }
        linkedTreeMap.put(str, jVar);
    }

    public Set<Map.Entry<String, j>> l() {
        return this.f24816a.entrySet();
    }
}
