package com.google.common.util.concurrent;

import com.google.j2objc.annotations.ReflectionSupport;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;

@ReflectionSupport(ReflectionSupport.Level.FULL)
/* loaded from: classes3.dex */
abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {

    /* loaded from: classes3.dex */
    public static final class Blocker extends AbstractOwnableSynchronizer implements Runnable {
        private final InterruptibleTask<?> task;

        public Thread getOwner() {
            return super.getExclusiveOwnerThread();
        }

        public String toString() {
            throw null;
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
