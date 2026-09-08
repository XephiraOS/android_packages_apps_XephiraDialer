package com.google.protobuf;

import com.google.protobuf.Descriptors;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public class TypeRegistry {
    private static final Logger logger = Logger.getLogger(TypeRegistry.class.getName());
    private final Map<String, Descriptors.Descriptor> types;

    /* loaded from: classes3.dex */
    public static final class Builder {
        private final Set<String> files;
        private Map<String, Descriptors.Descriptor> types;

        private void addFile(Descriptors.FileDescriptor fileDescriptor) {
            if (!this.files.add(fileDescriptor.getFullName())) {
                return;
            }
            Iterator<Descriptors.FileDescriptor> it = fileDescriptor.getDependencies().iterator();
            while (it.hasNext()) {
                addFile(it.next());
            }
            Iterator<Descriptors.Descriptor> it2 = fileDescriptor.getMessageTypes().iterator();
            while (it2.hasNext()) {
                addMessage(it2.next());
            }
        }

        private void addMessage(Descriptors.Descriptor descriptor) {
            Iterator<Descriptors.Descriptor> it = descriptor.getNestedTypes().iterator();
            while (it.hasNext()) {
                addMessage(it.next());
            }
            if (this.types.containsKey(descriptor.getFullName())) {
                TypeRegistry.logger.warning("Type " + descriptor.getFullName() + " is added multiple times.");
                return;
            }
            this.types.put(descriptor.getFullName(), descriptor);
        }

        public Builder add(Descriptors.Descriptor descriptor) {
            if (this.types != null) {
                addFile(descriptor.getFile());
                return this;
            }
            throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
        }

        public TypeRegistry build() {
            TypeRegistry typeRegistry = new TypeRegistry(this.types);
            this.types = null;
            return typeRegistry;
        }

        private Builder() {
            this.files = new HashSet();
            this.types = new HashMap();
        }

        public Builder add(Iterable<Descriptors.Descriptor> iterable) {
            if (this.types != null) {
                Iterator<Descriptors.Descriptor> it = iterable.iterator();
                while (it.hasNext()) {
                    addFile(it.next().getFile());
                }
                return this;
            }
            throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
        }
    }

    /* loaded from: classes3.dex */
    public static class EmptyTypeRegistryHolder {
        private static final TypeRegistry EMPTY = new TypeRegistry(Collections.emptyMap());

        private EmptyTypeRegistryHolder() {
        }
    }

    public TypeRegistry(Map<String, Descriptors.Descriptor> map) {
        this.types = map;
    }

    public static TypeRegistry getEmptyTypeRegistry() {
        return EmptyTypeRegistryHolder.EMPTY;
    }

    private static String getTypeName(String str) {
        String[] split = str.split("/");
        if (split.length != 1) {
            return split[split.length - 1];
        }
        throw new InvalidProtocolBufferException("Invalid type url found: " + str);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Descriptors.Descriptor find(String str) {
        return this.types.get(str);
    }

    public final Descriptors.Descriptor getDescriptorForTypeUrl(String str) {
        return find(getTypeName(str));
    }
}
