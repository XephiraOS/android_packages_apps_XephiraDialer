package com.android.incallui;

import android.os.Bundle;
import android.telecom.Call;
import com.android.incallui.InCallPresenter;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class SessionModificationCauseNotifier implements InCallPresenter.InCallDetailsListener {
    private static SessionModificationCauseNotifier sSessionModificationCauseNotifier;
    private final List<InCallSessionModificationCauseListener> mSessionModificationCauseListeners = new CopyOnWriteArrayList();

    private SessionModificationCauseNotifier() {
    }

    public static synchronized SessionModificationCauseNotifier getInstance() {
        SessionModificationCauseNotifier sessionModificationCauseNotifier;
        synchronized (SessionModificationCauseNotifier.class) {
            try {
                if (sSessionModificationCauseNotifier == null) {
                    sSessionModificationCauseNotifier = new SessionModificationCauseNotifier();
                }
                sessionModificationCauseNotifier = sSessionModificationCauseNotifier;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sessionModificationCauseNotifier;
    }

    public void addListener(InCallSessionModificationCauseListener inCallSessionModificationCauseListener) {
        com.google.common.base.k.o(inCallSessionModificationCauseListener);
        this.mSessionModificationCauseListeners.add(inCallSessionModificationCauseListener);
    }

    @Override // com.android.incallui.InCallPresenter.InCallDetailsListener
    public void onDetailsChanged(Call call, Call.Details details) {
        Bundle bundle;
        Log.d(this, "onDetailsChanged: - call: " + call + "details: " + details);
        if (call != null && details != null) {
            bundle = details.getExtras();
        } else {
            bundle = null;
        }
        int i10 = 0;
        if (bundle != null) {
            i10 = bundle.getInt("SessionModificationCause", 0);
        }
        if (i10 != 0) {
            com.google.common.base.k.o(this.mSessionModificationCauseListeners);
            Iterator<InCallSessionModificationCauseListener> it = this.mSessionModificationCauseListeners.iterator();
            while (it.hasNext()) {
                it.next().onSessionModificationCauseChanged(call, i10);
            }
        }
    }

    public void removeListener(InCallSessionModificationCauseListener inCallSessionModificationCauseListener) {
        if (inCallSessionModificationCauseListener != null) {
            this.mSessionModificationCauseListeners.remove(inCallSessionModificationCauseListener);
        } else {
            Log.e(this, "Can't remove null listener");
        }
    }
}
