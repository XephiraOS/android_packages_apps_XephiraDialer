package com.customize.contacts.cleaner;

import H7.b;
import P7.e;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.j;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.F;
import kotlinx.coroutines.S;

/* compiled from: RawCleanerJobService.kt */
/* loaded from: classes3.dex */
public final class RawCleanerJobService extends JobService {

    /* renamed from: b, reason: collision with root package name */
    public static final a f20875b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public boolean f20876a;

    /* compiled from: RawCleanerJobService.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final void a(Context context, boolean z10, boolean z11) {
            i.f(context, "context");
            if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                b.b("RawCleanerJobService", "startClean: no op in ODialer.");
                return;
            }
            if (e.d(context)) {
                boolean z12 = true;
                int i10 = 0;
                if (!z11) {
                    SharedPreferences b10 = j.b(context);
                    int i11 = b10.getInt("clean_times", 0);
                    long j10 = b10.getLong("last_clean_time_stamp", 0L);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (i11 != 0 && ((i11 != 1 && i11 != 2) || (currentTimeMillis - j10) / 1000 <= 604800)) {
                        z12 = false;
                    }
                    i10 = i11;
                }
                b.b("RawCleanerJobService", "startClean: synced: " + z10 + ", executeImmediately: " + z11 + ", execute: " + z12 + ", cleaned: " + i10);
                if (z12) {
                    JobInfo build = new JobInfo.Builder(901, new ComponentName(context, (Class<?>) RawCleanerJobService.class)).build();
                    build.getExtras().putBoolean("synced", z10);
                    JobScheduler jobScheduler = (JobScheduler) context.getSystemService(JobScheduler.class);
                    if (jobScheduler != null) {
                        jobScheduler.schedule(build);
                    }
                }
            }
        }

        public final void b(Context context) {
            i.f(context, "context");
            if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                b.b("RawCleanerJobService", "startCleanOnce: no op in ODialer.");
                return;
            }
            if (e.d(context)) {
                int i10 = j.b(context).getInt("once_cleaned", 0);
                b.b("RawCleanerJobService", "startCleanOnce: onceCleaned: " + i10);
                if (i10 < 1) {
                    a(context, false, true);
                }
            }
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public static final void b(Context context, boolean z10, boolean z11) {
        f20875b.a(context, z10, z11);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters != null && jobParameters.getJobId() == 901) {
            boolean d10 = e.d(this);
            b.b("RawCleanerJobService", "onStartJob: userUnlocked: " + d10 + ", running: " + this.f20876a);
            if (d10) {
                if (!this.f20876a) {
                    this.f20876a = true;
                    C1248i.d(F.a(S.b()), null, null, new RawCleanerJobService$onStartJob$1(jobParameters, this, this, null), 3, null);
                    return true;
                }
                b.i("RawCleanerJobService", "onStartJob: current job is running.");
            }
        }
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        b.b("RawCleanerJobService", "onStopJob");
        return false;
    }
}
