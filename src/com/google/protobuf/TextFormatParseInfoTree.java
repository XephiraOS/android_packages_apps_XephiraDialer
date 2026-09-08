package com.google.protobuf;

import com.google.protobuf.Descriptors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class TextFormatParseInfoTree {
    private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
    Map<Descriptors.FieldDescriptor, List<TextFormatParseInfoTree>> subtreesFromField;

    /* loaded from: classes3.dex */
    public static class Builder {
        private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
        private Map<Descriptors.FieldDescriptor, List<Builder>> subtreeBuildersFromField;

        public TextFormatParseInfoTree build() {
            return new TextFormatParseInfoTree(this.locationsFromField, this.subtreeBuildersFromField);
        }

        public Builder getBuilderForSubMessageField(Descriptors.FieldDescriptor fieldDescriptor) {
            List<Builder> list = this.subtreeBuildersFromField.get(fieldDescriptor);
            if (list == null) {
                list = new ArrayList<>();
                this.subtreeBuildersFromField.put(fieldDescriptor, list);
            }
            Builder builder = new Builder();
            list.add(builder);
            return builder;
        }

        public Builder setLocation(Descriptors.FieldDescriptor fieldDescriptor, TextFormatParseLocation textFormatParseLocation) {
            List<TextFormatParseLocation> list = this.locationsFromField.get(fieldDescriptor);
            if (list == null) {
                list = new ArrayList<>();
                this.locationsFromField.put(fieldDescriptor, list);
            }
            list.add(textFormatParseLocation);
            return this;
        }

        private Builder() {
            this.locationsFromField = new HashMap();
            this.subtreeBuildersFromField = new HashMap();
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private static <T> T getFromList(List<T> list, int i10, Descriptors.FieldDescriptor fieldDescriptor) {
        String name;
        if (i10 < list.size() && i10 >= 0) {
            return list.get(i10);
        }
        if (fieldDescriptor == null) {
            name = "<null>";
        } else {
            name = fieldDescriptor.getName();
        }
        throw new IllegalArgumentException(String.format("Illegal index field: %s, index %d", name, Integer.valueOf(i10)));
    }

    public TextFormatParseLocation getLocation(Descriptors.FieldDescriptor fieldDescriptor, int i10) {
        return (TextFormatParseLocation) getFromList(getLocations(fieldDescriptor), i10, fieldDescriptor);
    }

    public List<TextFormatParseLocation> getLocations(Descriptors.FieldDescriptor fieldDescriptor) {
        List<TextFormatParseLocation> list = this.locationsFromField.get(fieldDescriptor);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public TextFormatParseInfoTree getNestedTree(Descriptors.FieldDescriptor fieldDescriptor, int i10) {
        return (TextFormatParseInfoTree) getFromList(getNestedTrees(fieldDescriptor), i10, fieldDescriptor);
    }

    public List<TextFormatParseInfoTree> getNestedTrees(Descriptors.FieldDescriptor fieldDescriptor) {
        List<TextFormatParseInfoTree> list = this.subtreesFromField.get(fieldDescriptor);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    private TextFormatParseInfoTree(Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> map, Map<Descriptors.FieldDescriptor, List<Builder>> map2) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
        }
        this.locationsFromField = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<Descriptors.FieldDescriptor, List<Builder>> entry2 : map2.entrySet()) {
            ArrayList arrayList = new ArrayList();
            Iterator<Builder> it = entry2.getValue().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().build());
            }
            hashMap2.put(entry2.getKey(), Collections.unmodifiableList(arrayList));
        }
        this.subtreesFromField = Collections.unmodifiableMap(hashMap2);
    }
}
