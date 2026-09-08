package com.android.contacts.voicemail.impl;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.telecom.PhoneAccountHandle;
import t1.C1580a;

/* loaded from: classes.dex */
public class DeviceProvisionedJobService extends JobService {
    public static void a(Context context, PhoneAccountHandle phoneAccountHandle) {
        JobInfo build = new JobInfo.Builder(202, new ComponentName(context, (Class<?>) DeviceProvisionedJobService.class)).addTriggerContentUri(new JobInfo.TriggerContentUri(Settings.Global.getUriFor("device_provisioned"), 0)).setTriggerContentMaxDelay(0L).build();
        Intent intent = new Intent();
        intent.putExtra("EXTRA_PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
        ((JobScheduler) context.getSystemService(JobScheduler.class)).enqueue(build, new JobWorkItem(intent));
    }

    public final boolean b() {
        if (Settings.Global.getInt(getContentResolver(), "device_provisioned", 0) != 1) {
            return false;
        }
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        C1580a.e(b());
        H7.b.e("DeviceProvisionedJobService.onStartJob", "device provisioned");
        while (true) {
            JobWorkItem dequeueWork = jobParameters.dequeueWork();
            if (dequeueWork != null) {
                PhoneAccountHandle phoneAccountHandle = (PhoneAccountHandle) dequeueWork.getIntent().getParcelableExtra("EXTRA_PHONE_ACCOUNT_HANDLE");
                H7.b.e("DeviceProvisionedJobService.onStartJob", "restarting activation for " + phoneAccountHandle);
                ActivationTask.v(this, phoneAccountHandle, null);
            } else {
                return false;
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
