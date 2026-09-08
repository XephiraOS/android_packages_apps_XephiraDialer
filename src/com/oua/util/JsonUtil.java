package com.oua.util;

import android.content.Context;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class JsonUtil {
    private JsonUtil() {
    }

    public static List<String> asListOfString(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            arrayList.add(jSONArray.getString(i10));
        }
        return arrayList;
    }

    public static Map<String, List<String>> asMapOfListOfString(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(next);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                arrayList.add(jSONArray.getString(i10));
            }
            hashMap.put(next, arrayList);
        }
        return hashMap;
    }

    public static JSONArray readJsonArrayFromFile(String str, Context context, Charset charset) {
        return new JSONArray(new String(FileUtil.toByteArray(str, context), charset));
    }

    public static JSONObject readJsonObjFromFile(String str, Context context, Charset charset) {
        return new JSONObject(new String(FileUtil.toByteArray(str, context), charset));
    }
}
