package com.oua.util;

import java.nio.ByteBuffer;
import java.util.function.ToIntFunction;

/* compiled from: R8$$SyntheticClass */
/* renamed from: com.oua.util.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* synthetic */ class C0940g implements ToIntFunction {
    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        return ((ByteBuffer) obj).remaining();
    }
}
