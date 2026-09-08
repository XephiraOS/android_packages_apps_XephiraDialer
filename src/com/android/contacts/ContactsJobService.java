package com.android.contacts;

import android.app.job.JobParameters;
import android.app.job.JobService;

/* loaded from: classes.dex */
public class ContactsJobService extends JobService {
    @Override // android.app.Service
    public void onCreate() {
        if (H7.a.b()) {
            H7.b.b("DynamicShortcuts", "ContactsJobService onCreate");
        }
        super.onCreate();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters.getJobId() == 401) {
            DynamicShortcuts.u(this, jobParameters);
            return true;
        }
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
