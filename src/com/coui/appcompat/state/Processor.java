package com.coui.appcompat.state;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;

/* loaded from: classes.dex */
public abstract class Processor<T, V extends View> implements ComponentCallbacks {
    private SparseArray<T> mSparseArray;
    private final int mState;
    protected V mView;

    public Processor(int i10, SparseArray<T> sparseArray) {
        this(null, i10, sparseArray);
    }

    public SparseArray<T> getSparseArray() {
        return this.mSparseArray;
    }

    public int getState() {
        return this.mState;
    }

    public boolean isLoadedView() {
        if (this.mView != null) {
            return true;
        }
        return false;
    }

    public abstract void onProcess(V v10, int i10, SparseArray<T> sparseArray);

    public void process() {
        process(this.mView);
    }

    public void release() {
        this.mView = null;
        this.mSparseArray.clear();
        this.mSparseArray = null;
    }

    public void setView(V v10) {
        if (v10 != null) {
            this.mView = v10;
            return;
        }
        throw new IllegalArgumentException("Processor: setView() params cannot be null!");
    }

    public Processor(V v10, int i10, SparseArray<T> sparseArray) {
        if (sparseArray != null) {
            this.mView = v10;
            this.mState = i10;
            this.mSparseArray = sparseArray;
            return;
        }
        throw new IllegalArgumentException("Processor: the params cannot be null!");
    }

    public void process(V v10) {
        if (v10 != null) {
            onProcess(v10, this.mState, this.mSparseArray);
        } else {
            Log.e(getClass().getSimpleName(), "Processor: the parameter mView == null");
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }
}
