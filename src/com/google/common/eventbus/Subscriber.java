package com.google.common.eventbus;

import com.google.common.base.k;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class Subscriber {

    /* renamed from: a, reason: collision with root package name */
    public final Method f24582a;
    final Object target;

    /* loaded from: classes3.dex */
    public static final class SynchronizedSubscriber extends Subscriber {
        @Override // com.google.common.eventbus.Subscriber
        public void invokeSubscriberMethod(Object obj) {
            synchronized (this) {
                super.invokeSubscriberMethod(obj);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Subscriber)) {
            return false;
        }
        Subscriber subscriber = (Subscriber) obj;
        if (this.target != subscriber.target || !this.f24582a.equals(subscriber.f24582a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((this.f24582a.hashCode() + 31) * 31) + System.identityHashCode(this.target);
    }

    public void invokeSubscriberMethod(Object obj) {
        try {
            this.f24582a.invoke(this.target, k.o(obj));
        } catch (IllegalAccessException e10) {
            throw new Error("Method became inaccessible: " + obj, e10);
        } catch (IllegalArgumentException e11) {
            throw new Error("Method rejected target/argument: " + obj, e11);
        } catch (InvocationTargetException e12) {
            if (e12.getCause() instanceof Error) {
                throw ((Error) e12.getCause());
            }
            throw e12;
        }
    }
}
