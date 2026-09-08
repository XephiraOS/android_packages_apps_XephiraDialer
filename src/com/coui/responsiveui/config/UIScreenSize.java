package com.coui.responsiveui.config;

import java.util.Objects;

/* loaded from: classes3.dex */
public class UIScreenSize {

    /* renamed from: a, reason: collision with root package name */
    public int f20065a;

    /* renamed from: b, reason: collision with root package name */
    public int f20066b;

    /* renamed from: c, reason: collision with root package name */
    public int f20067c;

    public UIScreenSize(int i10, int i11) {
        this.f20065a = i10;
        this.f20066b = i11;
    }

    public int a() {
        return this.f20067c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UIScreenSize uIScreenSize = (UIScreenSize) obj;
        if (this.f20065a == uIScreenSize.f20065a && this.f20066b == uIScreenSize.f20066b) {
            return true;
        }
        return false;
    }

    public int getHeightDp() {
        return this.f20066b;
    }

    public int getWidthDp() {
        return this.f20065a;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f20065a), Integer.valueOf(this.f20066b), Integer.valueOf(this.f20067c));
    }

    public void setHeightDp(int i10) {
        this.f20066b = i10;
    }

    public void setWidthDp(int i10) {
        this.f20065a = i10;
    }

    public String toString() {
        return "UIScreenSize{W-Dp=" + this.f20065a + ", H-Dp=" + this.f20066b + ", SW-Dp=" + this.f20067c + "}";
    }

    public UIScreenSize(int i10, int i11, int i12) {
        this.f20065a = i10;
        this.f20066b = i11;
        this.f20067c = i12;
    }
}
