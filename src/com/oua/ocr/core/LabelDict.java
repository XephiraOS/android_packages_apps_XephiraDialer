package com.oua.ocr.core;

import com.oplus.backup.sdk.common.plugin.BRPluginConfigParser;
import com.oua.util.DebugConfig;
import com.oua.util.FileUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class LabelDict {
    private static final String TAG = "com.oua.ocr.core.LabelDict";
    public final int EOS;
    Map<Integer, String> dict;

    public LabelDict(String str, String str2, int i10) {
        DebugConfig.logd(TAG, FileUtil.getExt(str2));
        if (FileUtil.getExt(str2).equals(BRPluginConfigParser.JSON_ENCODE)) {
            this.dict = (Map) new com.google.gson.d().k(str, new J4.a<HashMap<Integer, String>>() { // from class: com.oua.ocr.core.LabelDict.1
            }.getType());
        } else {
            this.dict = new HashMap();
            for (int i11 = 0; i11 < str.length(); i11++) {
                this.dict.put(Integer.valueOf(i11), String.valueOf(str.charAt(i11)));
            }
        }
        this.EOS = i10;
        DebugConfig.logd(TAG, "dict  " + this.dict.size());
    }

    private String getAtIndex(int i10) {
        if (i10 != this.EOS && i10 >= 0 && i10 < this.dict.size()) {
            return this.dict.get(Integer.valueOf(i10));
        }
        return null;
    }

    public String index2String(int[] iArr) {
        StringBuilder sb = new StringBuilder(iArr.length);
        for (int i10 : iArr) {
            String atIndex = getAtIndex(i10);
            if (atIndex == null) {
                break;
            }
            sb.append(atIndex);
        }
        return sb.toString();
    }

    public String index2String(List<Integer> list) {
        String atIndex;
        StringBuilder sb = new StringBuilder(list.size());
        Iterator<Integer> it = list.iterator();
        while (it.hasNext() && (atIndex = getAtIndex(it.next().intValue())) != null) {
            sb.append(atIndex);
        }
        return sb.toString();
    }
}
