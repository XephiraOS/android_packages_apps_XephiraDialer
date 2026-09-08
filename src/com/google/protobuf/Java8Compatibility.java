package com.google.protobuf;

import java.nio.Buffer;

/* loaded from: classes3.dex */
final class Java8Compatibility {
    private Java8Compatibility() {
    }

    public static void clear(Buffer buffer) {
        buffer.clear();
    }

    public static void flip(Buffer buffer) {
        buffer.flip();
    }

    public static void limit(Buffer buffer, int i10) {
        buffer.limit(i10);
    }

    public static void mark(Buffer buffer) {
        buffer.mark();
    }

    public static void position(Buffer buffer, int i10) {
        buffer.position(i10);
    }

    public static void reset(Buffer buffer) {
        buffer.reset();
    }
}
