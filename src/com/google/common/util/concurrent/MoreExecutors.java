package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class MoreExecutors {

    /* loaded from: classes3.dex */
    public static class Application {
        public void addShutdownHook(Thread thread) {
            Runtime.getRuntime().addShutdownHook(thread);
        }
    }

    public static Executor a() {
        return DirectExecutor.INSTANCE;
    }
}
