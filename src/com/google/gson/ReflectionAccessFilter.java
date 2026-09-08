package com.google.gson;

/* loaded from: classes3.dex */
public interface ReflectionAccessFilter {

    /* loaded from: classes3.dex */
    public enum FilterResult {
        ALLOW,
        INDECISIVE,
        BLOCK_INACCESSIBLE,
        BLOCK_ALL
    }

    FilterResult a(Class<?> cls);
}
