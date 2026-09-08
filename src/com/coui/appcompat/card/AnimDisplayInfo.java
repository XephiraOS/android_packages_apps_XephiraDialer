package com.coui.appcompat.card;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.t;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: BaseCardInstructionAdapter.kt */
/* loaded from: classes.dex */
public final class AnimDisplayInfo extends BaseDisplayInfo {
    private final List<String> animAssets;
    private final List<Integer> animResources;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimDisplayInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final List<String> getAnimAssets() {
        return this.animAssets;
    }

    public final List<Integer> getAnimResources() {
        return this.animResources;
    }

    public /* synthetic */ AnimDisplayInfo(String str, String str2, int i10, f fVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimDisplayInfo(CharSequence title, CharSequence summary) {
        super(title, summary);
        i.f(title, "title");
        i.f(summary, "summary");
        this.animResources = new ArrayList();
        this.animAssets = new ArrayList();
    }

    public /* synthetic */ AnimDisplayInfo(Integer[] numArr, String[] strArr, int i10, int i11, f fVar) {
        this(numArr, strArr, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnimDisplayInfo(Integer[] animResources, String[] choices, int i10) {
        this("", "");
        i.f(animResources, "animResources");
        i.f(choices, "choices");
        this.animResources.clear();
        t.s(this.animResources, animResources);
        setChoices(choices);
        setSelectedIndex(i10);
    }

    public /* synthetic */ AnimDisplayInfo(Integer[] numArr, String str, String str2, int i10, f fVar) {
        this(numArr, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? "" : str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnimDisplayInfo(Integer[] animResources, CharSequence title, CharSequence summary) {
        this(title, summary);
        i.f(animResources, "animResources");
        i.f(title, "title");
        i.f(summary, "summary");
        this.animResources.clear();
        t.s(this.animResources, animResources);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnimDisplayInfo(Integer[] animResources, String[] animTitles) {
        this("", "");
        i.f(animResources, "animResources");
        i.f(animTitles, "animTitles");
        this.animResources.clear();
        t.s(this.animResources, animResources);
        getAnimTitles().clear();
        t.s(getAnimTitles(), animTitles);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnimDisplayInfo(String[] animAssets, String[] animTitles) {
        this("", "");
        i.f(animAssets, "animAssets");
        i.f(animTitles, "animTitles");
        this.animAssets.clear();
        t.s(this.animAssets, animAssets);
        getAnimTitles().clear();
        t.s(getAnimTitles(), animTitles);
    }

    public /* synthetic */ AnimDisplayInfo(String[] strArr, String str, String str2, int i10, f fVar) {
        this(strArr, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? "" : str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnimDisplayInfo(String[] animAssets, CharSequence title, CharSequence summary) {
        this(title, summary);
        i.f(animAssets, "animAssets");
        i.f(title, "title");
        i.f(summary, "summary");
        this.animAssets.clear();
        t.s(this.animAssets, animAssets);
    }

    public /* synthetic */ AnimDisplayInfo(String[] strArr, String[] strArr2, int i10, int i11, f fVar) {
        this(strArr, strArr2, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnimDisplayInfo(String[] animAssets, String[] choices, int i10) {
        this("", "");
        i.f(animAssets, "animAssets");
        i.f(choices, "choices");
        this.animAssets.clear();
        t.s(this.animAssets, animAssets);
        setChoices(choices);
        setSelectedIndex(i10);
    }
}
