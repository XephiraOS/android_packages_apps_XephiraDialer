package com.google.i18n.phonenumbers.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class RegexCache {

    /* renamed from: a, reason: collision with root package name */
    public LRUCache<String, Pattern> f24948a;

    /* loaded from: classes3.dex */
    public static class LRUCache<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public LinkedHashMap<K, V> f24949a;

        /* renamed from: b, reason: collision with root package name */
        public int f24950b;

        public LRUCache(int i10) {
            this.f24950b = i10;
            this.f24949a = new LinkedHashMap<K, V>(((i10 * 4) / 3) + 1, 0.75f, true) { // from class: com.google.i18n.phonenumbers.internal.RegexCache.LRUCache.1
                @Override // java.util.LinkedHashMap
                public boolean removeEldestEntry(Map.Entry<K, V> entry) {
                    if (size() > LRUCache.this.f24950b) {
                        return true;
                    }
                    return false;
                }
            };
        }

        public synchronized V b(K k10) {
            return this.f24949a.get(k10);
        }

        public synchronized void c(K k10, V v10) {
            this.f24949a.put(k10, v10);
        }
    }

    public RegexCache(int i10) {
        this.f24948a = new LRUCache<>(i10);
    }

    public Pattern a(String str) {
        Pattern b10 = this.f24948a.b(str);
        if (b10 == null) {
            Pattern compile = Pattern.compile(str);
            this.f24948a.c(str, compile);
            return compile;
        }
        return b10;
    }
}
