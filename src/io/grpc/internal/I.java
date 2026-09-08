package io.grpc.internal;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: JsonParser.java */
/* loaded from: classes4.dex */
public final class I {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f32544a = Logger.getLogger(I.class.getName());

    /* compiled from: JsonParser.java */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32545a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f32545a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32545a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32545a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32545a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32545a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32545a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static Object a(String str) {
        K4.a aVar = new K4.a(new StringReader(str));
        try {
            return e(aVar);
        } finally {
            try {
                aVar.close();
            } catch (IOException e10) {
                f32544a.log(Level.WARNING, "Failed to close", (Throwable) e10);
            }
        }
    }

    public static List<?> b(K4.a aVar) {
        boolean z10;
        aVar.a();
        ArrayList arrayList = new ArrayList();
        while (aVar.y()) {
            arrayList.add(e(aVar));
        }
        if (aVar.f0() == JsonToken.END_ARRAY) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "Bad token: " + aVar.d());
        aVar.l();
        return Collections.unmodifiableList(arrayList);
    }

    public static Void c(K4.a aVar) {
        aVar.X();
        return null;
    }

    public static Map<String, ?> d(K4.a aVar) {
        boolean z10;
        aVar.c();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (aVar.y()) {
            linkedHashMap.put(aVar.U(), e(aVar));
        }
        if (aVar.f0() == JsonToken.END_OBJECT) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "Bad token: " + aVar.d());
        aVar.o();
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static Object e(K4.a aVar) {
        com.google.common.base.k.v(aVar.y(), "unexpected end of JSON");
        switch (a.f32545a[aVar.f0().ordinal()]) {
            case 1:
                return b(aVar);
            case 2:
                return d(aVar);
            case 3:
                return aVar.a0();
            case 4:
                return Double.valueOf(aVar.O());
            case 5:
                return Boolean.valueOf(aVar.L());
            case 6:
                return c(aVar);
            default:
                throw new IllegalStateException("Bad token: " + aVar.d());
        }
    }
}
