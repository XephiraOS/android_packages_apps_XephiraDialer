package com.oua.task;

import java.util.List;

/* loaded from: classes4.dex */
public abstract class OUATask {

    /* loaded from: classes4.dex */
    public interface BatchTask<Input, Output> extends Task<List<Input>, List<Output>> {
    }

    @FunctionalInterface
    /* loaded from: classes4.dex */
    public interface GetNameFunc {
        String apply();
    }

    @FunctionalInterface
    /* loaded from: classes4.dex */
    public interface RunFunc<I, O> {
        O apply(I i10);
    }

    /* loaded from: classes4.dex */
    public interface Task<Input, Output> {
        String getName();

        Output run(Input input);
    }

    /* loaded from: classes4.dex */
    public static abstract class TaskBase<Input, Output> implements Task<Input, Output> {
        @Override // com.oua.task.OUATask.Task
        public String getName() {
            return getClass().getSimpleName();
        }
    }

    public static <I, O> Task<I, O> create(final RunFunc<I, O> runFunc) {
        return new Task<I, O>() { // from class: com.oua.task.OUATask.1
            @Override // com.oua.task.OUATask.Task
            public String getName() {
                return getClass().getSimpleName();
            }

            @Override // com.oua.task.OUATask.Task
            public O run(I i10) {
                return (O) RunFunc.this.apply(i10);
            }
        };
    }

    public static <I, O> BatchTask<I, O> createBatch(final GetNameFunc getNameFunc, final RunFunc<List<I>, List<O>> runFunc) {
        return new BatchTask<I, O>() { // from class: com.oua.task.OUATask.3
            @Override // com.oua.task.OUATask.Task
            public String getName() {
                return GetNameFunc.this.apply();
            }

            @Override // com.oua.task.OUATask.Task
            public List<O> run(List<I> list) {
                return (List) runFunc.apply(list);
            }
        };
    }

    public static <I, O> Task<I, O> create(final GetNameFunc getNameFunc, final RunFunc<I, O> runFunc) {
        return new Task<I, O>() { // from class: com.oua.task.OUATask.2
            @Override // com.oua.task.OUATask.Task
            public String getName() {
                return GetNameFunc.this.apply();
            }

            @Override // com.oua.task.OUATask.Task
            public O run(I i10) {
                return (O) runFunc.apply(i10);
            }
        };
    }
}
