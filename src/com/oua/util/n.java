package com.oua.util;

import java.util.Map;
import java.util.function.Function;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes4.dex */
public final /* synthetic */ class n implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return (String) ((Map.Entry) obj).getKey();
    }
}
