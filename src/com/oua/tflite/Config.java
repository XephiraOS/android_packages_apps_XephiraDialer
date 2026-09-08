package com.oua.tflite;

import com.oua.util.StringUtil;

/* loaded from: classes4.dex */
public class Config {
    public Device device;
    public int maxBatchSize;
    public String modelPath;
    public boolean resetVariable;
    public int threadNum;

    /* loaded from: classes4.dex */
    public enum Device {
        CPU,
        NNAPI,
        GPU,
        NNPilot,
        NNPilot_NNAPI
    }

    public Config() {
        this.modelPath = "";
        this.device = Device.CPU;
        this.threadNum = 4;
        this.maxBatchSize = 1;
        this.resetVariable = true;
    }

    public boolean equals(Object obj) {
        Config config;
        if (!(obj instanceof Config) || (config = (Config) obj) == null) {
            return false;
        }
        if (config != this && (!this.modelPath.equals(config.modelPath) || !this.device.equals(config.device) || this.threadNum != config.threadNum)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        return StringUtil.toString(this);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Config m9clone() {
        return new Config(this);
    }

    public Config(String str) {
        this.modelPath = "";
        this.device = Device.CPU;
        this.threadNum = 4;
        this.maxBatchSize = 1;
        this.resetVariable = true;
        this.modelPath = str;
    }

    public Config(String str, Device device, int i10) {
        this.modelPath = "";
        Device device2 = Device.CPU;
        this.maxBatchSize = 1;
        this.resetVariable = true;
        this.modelPath = str;
        this.device = device;
        this.threadNum = i10;
    }

    public Config(String str, Device device, int i10, int i11) {
        this.modelPath = "";
        Device device2 = Device.CPU;
        this.resetVariable = true;
        this.modelPath = str;
        this.device = device;
        this.threadNum = i10;
        this.maxBatchSize = i11;
    }

    public Config(Config config) {
        this.modelPath = "";
        this.device = Device.CPU;
        this.threadNum = 4;
        this.maxBatchSize = 1;
        this.resetVariable = true;
        this.modelPath = config.modelPath;
        this.device = config.device;
        this.threadNum = config.threadNum;
        this.maxBatchSize = config.maxBatchSize;
        this.resetVariable = config.resetVariable;
    }
}
