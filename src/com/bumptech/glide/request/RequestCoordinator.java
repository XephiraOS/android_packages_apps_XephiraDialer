package com.bumptech.glide.request;

import o3.InterfaceC1399c;

/* loaded from: classes.dex */
public interface RequestCoordinator {

    /* loaded from: classes.dex */
    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean isComplete;

        RequestState(boolean z10) {
            this.isComplete = z10;
        }

        public boolean b() {
            return this.isComplete;
        }
    }

    boolean b();

    boolean c(InterfaceC1399c interfaceC1399c);

    void d(InterfaceC1399c interfaceC1399c);

    boolean e(InterfaceC1399c interfaceC1399c);

    RequestCoordinator getRoot();

    boolean i(InterfaceC1399c interfaceC1399c);

    void k(InterfaceC1399c interfaceC1399c);
}
