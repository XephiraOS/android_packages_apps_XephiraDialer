package com.google.gson;

import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* compiled from: JsonParser.java */
/* loaded from: classes3.dex */
public final class m {
    @Deprecated
    public m() {
    }

    public static j b(K4.a aVar) {
        boolean B10 = aVar.B();
        aVar.l0(true);
        try {
            try {
                return com.google.gson.internal.j.a(aVar);
            } catch (OutOfMemoryError e10) {
                throw new JsonParseException("Failed parsing JSON source: " + aVar + " to Json", e10);
            } catch (StackOverflowError e11) {
                throw new JsonParseException("Failed parsing JSON source: " + aVar + " to Json", e11);
            }
        } finally {
            aVar.l0(B10);
        }
    }

    public static j c(Reader reader) {
        try {
            K4.a aVar = new K4.a(reader);
            j b10 = b(aVar);
            if (!b10.h() && aVar.f0() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return b10;
        } catch (MalformedJsonException e10) {
            throw new JsonSyntaxException(e10);
        } catch (IOException e11) {
            throw new JsonIOException(e11);
        } catch (NumberFormatException e12) {
            throw new JsonSyntaxException(e12);
        }
    }

    public static j d(String str) {
        return c(new StringReader(str));
    }

    @Deprecated
    public j a(String str) {
        return d(str);
    }
}
