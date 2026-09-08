package com.android.contacts.voicemail.impl;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import w0.C1643c;

/* loaded from: classes.dex */
public class StatusCheckJobService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        for (PhoneAccountHandle phoneAccountHandle : ((TelecomManager) getSystemService(TelecomManager.class)).getCallCapablePhoneAccounts()) {
            if (B1.b.e(this, phoneAccountHandle)) {
                if (C1643c.q()) {
                    C1643c.H(this, phoneAccountHandle, null);
                } else {
                    StatusCheckTask.r(this, phoneAccountHandle);
                }
            }
        }
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
