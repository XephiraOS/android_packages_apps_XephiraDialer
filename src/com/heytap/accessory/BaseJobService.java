package com.heytap.accessory;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import com.heytap.accessory.BaseJobAgent;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.constant.AFConstants;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import n5.C1371a;

/* loaded from: classes3.dex */
public class BaseJobService extends JobService implements IJobListener {
    private static final AtomicInteger CURRENT_JOB_ID = new AtomicInteger(0);
    private static final int MAXIMUM_JOB_DELAY = 3000;
    private static final int REQUEST_TYPE_CONNECTION = 1;
    private static final int REQUEST_TYPE_MESSAGE = 2;
    private static final String TAG = "[SDK.BaseJobService]";

    /* loaded from: classes3.dex */
    public static class a implements BaseJobAgent.RequestAgentCallback {

        /* renamed from: a, reason: collision with root package name */
        public int f25147a;

        /* renamed from: b, reason: collision with root package name */
        public JobParameters f25148b;

        /* renamed from: c, reason: collision with root package name */
        public BaseJobService f25149c;

        public a(int i10, JobParameters jobParameters, BaseJobService baseJobService) {
            this.f25147a = i10;
            this.f25148b = jobParameters;
            this.f25149c = baseJobService;
        }

        @Override // com.heytap.accessory.BaseJobAgent.RequestAgentCallback
        public void onAgentAvailable(BaseJobAgent baseJobAgent) {
            C1371a.c(BaseJobService.TAG, "onAgentAvailable");
            this.f25149c.onAgentCreated(this.f25147a, baseJobAgent, this.f25148b);
        }

        @Override // com.heytap.accessory.BaseJobAgent.RequestAgentCallback
        public void onError(int i10, String str) {
            C1371a.d(BaseJobService.TAG, "Request failed. Type = " + this.f25147a + ". ErrorCode : " + i10 + ". ErrorMsg: " + str);
        }
    }

    private void handleConnectionRequest(JobParameters jobParameters) {
        C1371a.c(TAG, "handleConnectionRequest ");
        requestAgent(jobParameters.getExtras().getString(AFConstants.EXTRA_AGENT_IMPL_CLASS), new a(1, jobParameters, this));
    }

    private void handleMessageReceived(JobParameters jobParameters) {
        C1371a.c(TAG, "handleMessageReceived ");
        requestAgent(jobParameters.getExtras().getString(AFConstants.EXTRA_AGENT_IMPL_CLASS), new a(2, jobParameters, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAgentCreated(int i10, BaseJobAgent baseJobAgent, JobParameters jobParameters) {
        if (i10 == 1) {
            baseJobAgent.handleConnectionRequest(jobParameters, this);
        }
    }

    private void requestAgent(String str, a aVar) {
        BaseJobAgent.requestAgent(getApplicationContext(), str, aVar);
    }

    private static void scheduleJob(Context context, String str, String str2, long j10, String str3, PeerAgent peerAgent) {
        C1371a.c(TAG, "scheduleJob for class: " + str2);
        JobInfo.Builder builder = new JobInfo.Builder(CURRENT_JOB_ID.getAndIncrement(), new ComponentName(context, (Class<?>) BaseJobService.class));
        builder.setPriority(500);
        builder.setExpedited(true);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(AFConstants.EXTRA_INTENT_ACTION, str);
        persistableBundle.putString(AFConstants.EXTRA_AGENT_IMPL_CLASS, str2);
        persistableBundle.putLong("transactionId", j10);
        persistableBundle.putString(AFConstants.EXTRA_AGENT_ID, str3);
        if (peerAgent == null) {
            persistableBundle.putStringArray("peerAgent", null);
        } else {
            List<String> content = peerAgent.getContent();
            persistableBundle.putStringArray("peerAgent", (String[]) content.toArray(new String[content.size()]));
        }
        builder.setExtras(persistableBundle);
        ((JobScheduler) context.getSystemService("jobscheduler")).schedule(builder.build());
        C1371a.c(TAG, "Schedule a job has been executed");
    }

    public static void scheduleMessageJob(Context context, String str, long j10, String str2, PeerAgent peerAgent) {
        C1371a.c(TAG, "Schedule Message indication Job for class: " + str);
        scheduleJob(context, BaseMessage.ACTION_ACCESSORY_MESSAGE_RECEIVED, str, j10, str2, peerAgent);
    }

    public static void scheduleSCJob(Context context, String str, long j10, String str2, PeerAgent peerAgent) {
        C1371a.c(TAG, "Schedule SC indication Job for class: " + str);
        scheduleJob(context, "com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED", str, j10, str2, peerAgent);
    }

    @Override // android.app.Service
    public void onCreate() {
        C1371a.c(TAG, "onCreate ");
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        C1371a.c(TAG, "onDestroy ");
        super.onDestroy();
    }

    @Override // com.heytap.accessory.IJobListener
    public void onJobFinished(JobParameters jobParameters) {
        C1371a.c(TAG, "onJobFinished ");
        jobFinished(jobParameters, false);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString(AFConstants.EXTRA_INTENT_ACTION);
        C1371a.c(TAG, "onStartJob, action = " + string);
        if (string != null) {
            if ("com.heytap.accessory.action.SERVICE_CONNECTION_REQUESTED".equalsIgnoreCase(string)) {
                C1371a.c(TAG, "Received incoming connection indication");
                handleConnectionRequest(jobParameters);
                return true;
            }
            if (BaseMessage.ACTION_ACCESSORY_MESSAGE_RECEIVED.equalsIgnoreCase(string)) {
                C1371a.c(TAG, "Received message received indication");
                handleMessageReceived(jobParameters);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        C1371a.c(TAG, "onStopJob ");
        return true;
    }
}
