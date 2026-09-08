package com.coui.appcompat.card;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.t;
import kotlin.jvm.internal.i;

/* compiled from: BaseCardInstructionAdapter.kt */
/* loaded from: classes.dex */
public class BaseDisplayInfo {
    private int animHeight;
    private final List<String> animTitles;
    private int animWidth;
    private final List<String> choices;
    private int selectedIndex;
    private CharSequence summary;
    private CharSequence title;

    public BaseDisplayInfo(CharSequence title, CharSequence summary) {
        i.f(title, "title");
        i.f(summary, "summary");
        this.title = title;
        this.summary = summary;
        this.choices = new ArrayList();
        this.animTitles = new ArrayList();
    }

    public final int getAnimHeight() {
        return this.animHeight;
    }

    public final List<String> getAnimTitles() {
        return this.animTitles;
    }

    public final int getAnimWidth() {
        return this.animWidth;
    }

    public final List<String> getChoices() {
        return this.choices;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final CharSequence getSummary() {
        return this.summary;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final void setAnimHeight(int i10) {
        this.animHeight = i10;
    }

    public final void setAnimWidth(int i10) {
        this.animWidth = i10;
    }

    public final void setChoices(String[] choices) {
        i.f(choices, "choices");
        this.choices.clear();
        t.s(this.choices, choices);
    }

    public final void setSelectedChoice(int i10) {
        this.selectedIndex = i10;
    }

    public final void setSelectedIndex(int i10) {
        this.selectedIndex = i10;
    }

    public final void setSummary(CharSequence charSequence) {
        i.f(charSequence, "<set-?>");
        this.summary = charSequence;
    }

    public final void setTitle(CharSequence charSequence) {
        i.f(charSequence, "<set-?>");
        this.title = charSequence;
    }
}
