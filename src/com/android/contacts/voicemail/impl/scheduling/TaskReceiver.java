package com.android.contacts.voicemail.impl.scheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class TaskReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final List<Intent> f18171a = new ArrayList();

    public static void a(Context context) {
        Iterator<Intent> it = f18171a.iterator();
        while (it.hasNext()) {
            context.sendBroadcast(it.next());
        }
        f18171a.clear();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            H7.b.i("VvmTaskReceiver", "null intent received");
            return;
        }
        H7.b.e("VvmTaskReceiver", "task received");
        TaskExecutor m10 = TaskExecutor.m();
        if (m10 != null) {
            H7.b.e("VvmTaskReceiver", "TaskExecutor already running");
            if (m10.p()) {
                H7.b.i("VvmTaskReceiver", "TaskExecutor is terminating, bouncing task");
                f18171a.add(intent);
                return;
            } else {
                m10.j(g.b(context.getApplicationContext(), intent.getExtras()));
                return;
            }
        }
        H7.b.e("VvmTaskReceiver", "scheduling new job");
        ArrayList arrayList = new ArrayList();
        arrayList.add(intent.getExtras());
        TaskSchedulerJobService.e(context.getApplicationContext(), arrayList, 0L, true);
    }
}
