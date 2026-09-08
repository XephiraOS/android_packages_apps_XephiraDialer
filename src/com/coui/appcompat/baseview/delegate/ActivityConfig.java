package com.coui.appcompat.baseview.delegate;

/* compiled from: ActivityConfig.kt */
/* loaded from: classes.dex */
public interface ActivityConfig {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int STATUS_IMMERSE = 0;
    public static final int STATUS_TRANSLUCENT = 1;

    /* compiled from: ActivityConfig.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int STATUS_IMMERSE = 0;
        public static final int STATUS_TRANSLUCENT = 1;

        private Companion() {
        }
    }

    boolean getNeedFoldObserver();

    int getStatusType();

    boolean isHomeAsUpEnabled();
}
