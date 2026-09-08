package com.oua.task;

import com.oua.task.OUATask;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class OUATaskManager<Input, Output> {
    public abstract List<OUATask.Task> getTaskList();

    public Output run(Input input) {
        return (Output) new OUATaskExecutor().run(input, getTaskList(), getClass().getSimpleName(), getClass().getName());
    }
}
