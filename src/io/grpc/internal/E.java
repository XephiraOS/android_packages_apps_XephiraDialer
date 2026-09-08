package io.grpc.internal;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* compiled from: InUseStateAggregator.java */
/* loaded from: classes4.dex */
public abstract class E<T> {
    private final Set<T> inUseObjects = Collections.newSetFromMap(new IdentityHashMap());

    public final boolean anyObjectInUse(Object... objArr) {
        for (Object obj : objArr) {
            if (this.inUseObjects.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract void handleInUse();

    public abstract void handleNotInUse();

    public final boolean isInUse() {
        return !this.inUseObjects.isEmpty();
    }

    public final void updateObjectInUse(T t10, boolean z10) {
        int size = this.inUseObjects.size();
        if (z10) {
            this.inUseObjects.add(t10);
            if (size == 0) {
                handleInUse();
                return;
            }
            return;
        }
        if (this.inUseObjects.remove(t10) && size == 1) {
            handleNotInUse();
        }
    }
}
