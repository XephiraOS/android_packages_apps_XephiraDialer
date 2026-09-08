package com.coui.appcompat.card;

import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: BaseCardInstructionAdapter.kt */
/* loaded from: classes.dex */
public final class ImageDisplayInfo extends BaseDisplayInfo {
    private final Integer[] imageResources;

    public /* synthetic */ ImageDisplayInfo(Integer[] numArr, String str, String str2, int i10, f fVar) {
        this(numArr, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? "" : str2);
    }

    public final Integer[] getImageResources() {
        return this.imageResources;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageDisplayInfo(Integer[] imageResources, CharSequence title, CharSequence summary) {
        super(title, summary);
        i.f(imageResources, "imageResources");
        i.f(title, "title");
        i.f(summary, "summary");
        this.imageResources = imageResources;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageDisplayInfo(Integer[] imageResources, String[] choices) {
        this(imageResources, "", "");
        i.f(imageResources, "imageResources");
        i.f(choices, "choices");
        setChoices(choices);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageDisplayInfo(Integer[] imageResources, List<String> animTitles) {
        this(imageResources, "", "");
        i.f(imageResources, "imageResources");
        i.f(animTitles, "animTitles");
        getAnimTitles().clear();
        getAnimTitles().addAll(animTitles);
    }
}
