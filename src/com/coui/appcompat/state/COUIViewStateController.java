package com.coui.appcompat.state;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.SparseArray;
import android.view.View;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class COUIViewStateController implements IViewStateController, ComponentCallbacks {
    private SparseArray<List<Processor>> mSparseArray = new SparseArray<>();

    public void addViewStateProcessor(Processor... processorArr) {
        if (processorArr == null) {
            return;
        }
        for (Processor processor : processorArr) {
            if (this.mSparseArray.get(processor.getState()) == null) {
                this.mSparseArray.put(processor.getState(), new LinkedList());
            }
            this.mSparseArray.get(processor.getState()).add(processor);
        }
    }

    public View getProcessView() {
        return null;
    }

    public SparseArray<List<Processor>> getProcessorMap() {
        return this.mSparseArray;
    }

    public void onConfigurationChanged(Configuration configuration) {
        for (int i10 = 0; i10 < this.mSparseArray.size(); i10++) {
            for (Processor processor : this.mSparseArray.valueAt(i10)) {
                if (processor != null) {
                    processor.onConfigurationChanged(configuration);
                }
            }
        }
    }

    @Override // com.coui.appcompat.state.IViewStateController
    public void onViewStateChanged(int i10) {
        List<Processor> list = this.mSparseArray.get(i10);
        if (list == null) {
            return;
        }
        for (Processor processor : list) {
            if (processor.isLoadedView()) {
                processor.process();
            } else {
                processor.process(getProcessView());
            }
        }
    }

    @Override // com.coui.appcompat.state.IViewStateController
    public void release() {
        for (int i10 = 0; i10 < this.mSparseArray.size(); i10++) {
            for (Processor processor : this.mSparseArray.valueAt(i10)) {
                if (processor != null) {
                    processor.release();
                }
            }
        }
        this.mSparseArray.clear();
    }

    public void addViewStateProcessor(List<Processor> list) {
        if (list == null) {
            return;
        }
        addViewStateProcessor((Processor[]) list.toArray(new Processor[0]));
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }
}
