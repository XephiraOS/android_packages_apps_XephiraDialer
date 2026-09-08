package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;

/* compiled from: JsonElement.java */
/* loaded from: classes3.dex */
public abstract class j {
    @Deprecated
    public j() {
    }

    public g a() {
        if (g()) {
            return (g) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public l c() {
        if (i()) {
            return (l) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public n e() {
        if (j()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean g() {
        return this instanceof g;
    }

    public boolean h() {
        return this instanceof k;
    }

    public boolean i() {
        return this instanceof l;
    }

    public boolean j() {
        return this instanceof n;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            K4.b bVar = new K4.b(stringWriter);
            bVar.X(true);
            com.google.gson.internal.j.b(this, bVar);
            return stringWriter.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
