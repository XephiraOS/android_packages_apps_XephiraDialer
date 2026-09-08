package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.MalformedJsonException;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
public enum ToNumberPolicy implements q {
    DOUBLE { // from class: com.google.gson.ToNumberPolicy.1
        @Override // com.google.gson.q
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(K4.a aVar) {
            return Double.valueOf(aVar.O());
        }
    },
    LAZILY_PARSED_NUMBER { // from class: com.google.gson.ToNumberPolicy.2
        @Override // com.google.gson.q
        public Number a(K4.a aVar) {
            return new LazilyParsedNumber(aVar.a0());
        }
    },
    LONG_OR_DOUBLE { // from class: com.google.gson.ToNumberPolicy.3
        @Override // com.google.gson.q
        public Number a(K4.a aVar) {
            String a02 = aVar.a0();
            try {
                try {
                    return Long.valueOf(Long.parseLong(a02));
                } catch (NumberFormatException unused) {
                    Double valueOf = Double.valueOf(a02);
                    if (!valueOf.isInfinite()) {
                        if (valueOf.isNaN()) {
                        }
                        return valueOf;
                    }
                    if (!aVar.B()) {
                        throw new MalformedJsonException("JSON forbids NaN and infinities: " + valueOf + "; at path " + aVar.u());
                    }
                    return valueOf;
                }
            } catch (NumberFormatException e10) {
                throw new JsonParseException("Cannot parse " + a02 + "; at path " + aVar.u(), e10);
            }
        }
    },
    BIG_DECIMAL { // from class: com.google.gson.ToNumberPolicy.4
        @Override // com.google.gson.q
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(K4.a aVar) {
            String a02 = aVar.a0();
            try {
                return new BigDecimal(a02);
            } catch (NumberFormatException e10) {
                throw new JsonParseException("Cannot parse " + a02 + "; at path " + aVar.u(), e10);
            }
        }
    }
}
