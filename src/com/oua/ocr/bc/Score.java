package com.oua.ocr.bc;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: libBCREngine.java */
/* loaded from: classes4.dex */
public class Score {
    public String metric;
    public float positive = 0.0f;
    public float tp = 0.0f;
    public float fp = 1.0E-7f;

    public Score(String str) {
        this.metric = str;
    }

    public void get_score() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%25s", this.metric));
        sb.append(": postive = ");
        sb.append(String.format("%5.0f", Float.valueOf(this.positive)));
        sb.append("; recall = ");
        sb.append(String.format("%6.2f", Float.valueOf((this.tp / this.positive) * 100.0f)));
        sb.append("; precision = ");
        float f10 = this.tp;
        sb.append(String.format("%6.2f", Float.valueOf((f10 / (this.fp + f10)) * 100.0f)));
        LogUtil.println(sb.toString());
    }

    public static void get_score(HashMap<String, Score> hashMap) {
        if (hashMap.size() == 0) {
            return;
        }
        hashMap.get("Phone").get_score();
        hashMap.get("Email").get_score();
        hashMap.get("Website").get_score();
        hashMap.get("Title").get_score();
        hashMap.get("Company").get_score();
        hashMap.get("Address").get_score();
        hashMap.get("Name").get_score();
        LogUtil.println("----------------------------------");
        for (Score score : hashMap.values()) {
            if (!score.metric.equals("Phone") && !score.metric.equals("Email") && !score.metric.equals("Website") && !score.metric.equals("Title") && !score.metric.equals("Address") && !score.metric.equals("Company") && !score.metric.equals("Name")) {
                score.get_score();
            }
        }
    }
}
