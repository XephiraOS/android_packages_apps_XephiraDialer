package com.coui.responsiveui.config;

import java.util.Objects;

/* loaded from: classes3.dex */
public class UIConfig {

    /* renamed from: a, reason: collision with root package name */
    public Status f20059a;

    /* renamed from: b, reason: collision with root package name */
    public int f20060b;

    /* renamed from: c, reason: collision with root package name */
    public UIScreenSize f20061c;

    /* renamed from: d, reason: collision with root package name */
    public WindowType f20062d;

    /* loaded from: classes3.dex */
    public enum Status {
        FOLD("fd"),
        UNFOLDING("fding"),
        UNFOLD("ufd"),
        UNKNOWN("unknown");

        private String mName;

        Status(String str) {
            this.mName = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mName;
        }
    }

    /* loaded from: classes3.dex */
    public enum WindowType {
        SMALL,
        MEDIUM,
        LARGE
    }

    public UIConfig(Status status, UIScreenSize uIScreenSize, int i10, WindowType windowType) {
        this.f20059a = status;
        this.f20061c = uIScreenSize;
        this.f20060b = i10;
        this.f20062d = windowType;
    }

    public void a(UIScreenSize uIScreenSize) {
        this.f20061c = uIScreenSize;
    }

    public void b(Status status) {
        this.f20059a = status;
    }

    public void c(WindowType windowType) {
        this.f20062d = windowType;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UIConfig uIConfig = (UIConfig) obj;
        if (this.f20060b == uIConfig.f20060b && this.f20059a == uIConfig.f20059a && Objects.equals(this.f20061c, uIConfig.f20061c)) {
            return true;
        }
        return false;
    }

    public int getOrientation() {
        return this.f20060b;
    }

    public UIScreenSize getScreenSize() {
        return this.f20061c;
    }

    public Status getStatus() {
        return this.f20059a;
    }

    public WindowType getWindowType() {
        return this.f20062d;
    }

    public int hashCode() {
        return Objects.hash(this.f20059a, Integer.valueOf(this.f20060b), this.f20061c);
    }

    public String toString() {
        return "UIConfig{mStatus= " + this.f20059a + ", mOrientation=" + this.f20060b + ", mScreenSize=" + this.f20061c + ", mWindowType=" + this.f20062d + "}";
    }
}
