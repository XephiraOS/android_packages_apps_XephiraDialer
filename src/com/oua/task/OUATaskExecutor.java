package com.oua.task;

import com.oua.task.OUATask;
import com.oua.util.SimpleTrace;
import java.util.List;

/* loaded from: classes4.dex */
public class OUATaskExecutor<Input, Output> {
    public Output run(Input input, List<OUATask.Task> list, String str, String str2) {
        SimpleTrace.getTrace().startSection(str, str2);
        for (OUATask.Task task : list) {
            input = (Output) task.run(input);
            SimpleTrace.getTrace().addEvent(task.getName());
        }
        SimpleTrace.getTrace().endSection(str);
        return (Output) input;
    }
}
