package com.android.contacts.voicemail.impl.scheduling;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import com.android.contacts.voicemail.impl.scheduling.TaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t1.C1580a;

/* loaded from: classes.dex */
public class TaskSchedulerJobService extends JobService implements TaskExecutor.c {

    /* renamed from: a, reason: collision with root package name */
    public JobParameters f18172a;

    public static int c(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int i10 = defaultSharedPreferences.getInt("com.android.contacts.voicemail.impl.scheduling.TaskSchedulerJobService.NEXT_JOB_ID", 0);
        defaultSharedPreferences.edit().putInt("com.android.contacts.voicemail.impl.scheduling.TaskSchedulerJobService.NEXT_JOB_ID", i10 + 1).apply();
        return i10;
    }

    public static List<Bundle> d(Parcelable[] parcelableArr) {
        ArrayList arrayList = new ArrayList(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            arrayList.add((Bundle) parcelable);
        }
        return arrayList;
    }

    public static void e(Context context, List<Bundle> list, long j10, boolean z10) {
        C1580a.c();
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(JobScheduler.class);
        JobInfo pendingJob = jobScheduler.getPendingJob(200);
        H7.b.e("TaskSchedulerJobService", "scheduling job with " + list.size() + " tasks");
        if (pendingJob != null) {
            if (z10) {
                List<Bundle> d10 = d(pendingJob.getTransientExtras().getParcelableArray("extra_task_extras_array"));
                H7.b.e("TaskSchedulerJobService", "merging job with " + d10.size() + " existing tasks");
                f fVar = new f();
                fVar.c(context, d10);
                Iterator<Bundle> it = list.iterator();
                while (it.hasNext()) {
                    fVar.a(g.b(context, it.next()));
                }
                list = fVar.i();
            }
            H7.b.e("TaskSchedulerJobService", "canceling existing job.");
            jobScheduler.cancel(200);
        }
        Bundle bundle = new Bundle();
        int c10 = c(context);
        bundle.putInt("extra_job_id", c10);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("com.android.contacts.voicemail.impl.scheduling.TaskSchedulerJobService.EXPECTED_JOB_ID", c10).apply();
        bundle.putParcelableArray("extra_task_extras_array", (Parcelable[]) list.toArray(new Bundle[list.size()]));
        boolean z11 = true;
        JobInfo.Builder requiredNetworkType = new JobInfo.Builder(200, new ComponentName(context, (Class<?>) TaskSchedulerJobService.class)).setTransientExtras(bundle).setMinimumLatency(j10).setRequiredNetworkType(1);
        if (z10) {
            if (j10 != 0) {
                z11 = false;
            }
            C1580a.e(z11);
            requiredNetworkType.setOverrideDeadline(0L);
            H7.b.e("TaskSchedulerJobService", "running job instantly.");
        }
        jobScheduler.schedule(requiredNetworkType.build());
        H7.b.e("TaskSchedulerJobService", "job " + c10 + " scheduled");
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.TaskExecutor.c
    public boolean a() {
        C1580a.c();
        if (((JobScheduler) getSystemService(JobScheduler.class)).getPendingJob(200) == null) {
            return true;
        }
        return false;
    }

    @Override // com.android.contacts.voicemail.impl.scheduling.TaskExecutor.c
    public void b() {
        H7.b.e("TaskSchedulerJobService", "finishing job");
        jobFinished(this.f18172a, false);
        this.f18172a = null;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters == null) {
            return false;
        }
        int i10 = jobParameters.getTransientExtras().getInt("extra_job_id");
        int i11 = PreferenceManager.getDefaultSharedPreferences(this).getInt("com.android.contacts.voicemail.impl.scheduling.TaskSchedulerJobService.EXPECTED_JOB_ID", 0);
        if (i10 != i11) {
            H7.b.c("TaskSchedulerJobService", "Job " + i10 + " is not the last scheduled job " + i11 + ", ignoring");
            return false;
        }
        H7.b.e("TaskSchedulerJobService", "starting " + i10);
        this.f18172a = jobParameters;
        TaskExecutor.k(this);
        TaskExecutor m10 = TaskExecutor.m();
        if (m10 == null) {
            return false;
        }
        m10.r(this, d(this.f18172a.getTransientExtras().getParcelableArray("extra_task_extras_array")));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        TaskExecutor m10 = TaskExecutor.m();
        if (m10 != null) {
            m10.s();
            this.f18172a = null;
            return false;
        }
        return true;
    }
}
