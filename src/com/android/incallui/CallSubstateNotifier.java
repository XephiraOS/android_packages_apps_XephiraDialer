package com.android.incallui;

import android.os.Bundle;
import android.telecom.Call;
import com.android.incallui.InCallPresenter;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class CallSubstateNotifier implements InCallPresenter.InCallDetailsListener {
    private static CallSubstateNotifier sCallSubstateNotifier;
    private final List<InCallSubstateListener> mCallSubstateListeners = new CopyOnWriteArrayList();
    private int mCallSubstate = 0;

    private CallSubstateNotifier() {
    }

    public static synchronized CallSubstateNotifier getInstance() {
        CallSubstateNotifier callSubstateNotifier;
        synchronized (CallSubstateNotifier.class) {
            try {
                if (sCallSubstateNotifier == null) {
                    sCallSubstateNotifier = new CallSubstateNotifier();
                }
                callSubstateNotifier = sCallSubstateNotifier;
            } catch (Throwable th) {
                throw th;
            }
        }
        return callSubstateNotifier;
    }

    @Override // com.android.incallui.InCallPresenter.InCallDetailsListener
    public void onDetailsChanged(Call call, Call.Details details) {
        Bundle bundle;
        Log.d(this, "onDetailsChanged - call: " + call + "details: " + details);
        if (call != null && details != null) {
            bundle = details.getExtras();
        } else {
            bundle = null;
        }
        int i10 = 0;
        if (bundle != null) {
            i10 = bundle.getInt("CallSubstate", 0);
        }
        if (i10 != this.mCallSubstate) {
            this.mCallSubstate = i10;
            com.google.common.base.k.o(this.mCallSubstateListeners);
            Iterator<InCallSubstateListener> it = this.mCallSubstateListeners.iterator();
            while (it.hasNext()) {
                it.next().onCallSubstateChanged(call, this.mCallSubstate);
            }
        }
    }
}
