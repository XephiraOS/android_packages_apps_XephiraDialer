package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcImDbJNI {
    public static final native long MtcByteArray_data_get(long j10, MtcByteArray mtcByteArray);

    public static final native void MtcByteArray_data_set(long j10, MtcByteArray mtcByteArray, long j11);

    public static final native long MtcByteArray_size_get(long j10, MtcByteArray mtcByteArray);

    public static final native void MtcByteArray_size_set(long j10, MtcByteArray mtcByteArray, long j11);

    public static final native byte[] MtcByteArray_value_get(long j10, MtcByteArray mtcByteArray);

    public static final native void MtcByteArray_value_set(long j10, MtcByteArray mtcByteArray, byte[] bArr);

    public static final native int MtcNumber_value_get(long j10, MtcNumber mtcNumber);

    public static final native void MtcNumber_value_set(long j10, MtcNumber mtcNumber, int i10);

    public static final native String MtcString_value_get(long j10, MtcString mtcString);

    public static final native void MtcString_value_set(long j10, MtcString mtcString, String str);

    public static final native int Mtc_ImDbDisplayNotificationSwitch(boolean z10);

    public static final native int Mtc_ImDbGet1toManySelectedTech();

    public static final native boolean Mtc_ImDbGetAllowedOffline();

    public static final native boolean Mtc_ImDbGetAllowedSms();

    public static final native int Mtc_ImDbGetAllowedSmsType();

    public static final native boolean Mtc_ImDbGetAutAccept();

    public static final native boolean Mtc_ImDbGetAutAcceptGroupChat();

    public static final native short Mtc_ImDbGetCCAllowedTerminalType();

    public static final native int Mtc_ImDbGetCfsTriggerType();

    public static final native boolean Mtc_ImDbGetChatAuth();

    public static final native String Mtc_ImDbGetChatBotBlcakList();

    public static final native String Mtc_ImDbGetChatBotFqdnRoot();

    public static final native String Mtc_ImDbGetChatBotUri();

    public static final native boolean Mtc_ImDbGetComposerAuth();

    public static final native String Mtc_ImDbGetConfFctyUri();

    public static final native boolean Mtc_ImDbGetCpimBase64EncodeEnable();

    public static final native String Mtc_ImDbGetDeferDelUri();

    public static final native String Mtc_ImDbGetDeferRetvUri();

    public static final native String Mtc_ImDbGetDeferredMsgFuncUri();

    public static final native boolean Mtc_ImDbGetDisplayNotificationSwitch();

    public static final native String Mtc_ImDbGetExploderUri();

    public static final native boolean Mtc_ImDbGetFirstMsgInvite();

    public static final native boolean Mtc_ImDbGetFtAutAccept();

    public static final native boolean Mtc_ImDbGetFtAuth();

    public static final native boolean Mtc_ImDbGetFtCapAlwaysOn();

    public static final native int Mtc_ImDbGetFtDefaultMech();

    public static final native int Mtc_ImDbGetFtFbDefault();

    public static final native String Mtc_ImDbGetFtFileDirect();

    public static final native String Mtc_ImDbGetFtHttpCsPwd();

    public static final native String Mtc_ImDbGetFtHttpCsUri();

    public static final native String Mtc_ImDbGetFtHttpCsUser();

    public static final native int Mtc_ImDbGetFtHttpFallback();

    public static final native String Mtc_ImDbGetFtHttpToken();

    public static final native int Mtc_ImDbGetFtMax1ToNRecipient();

    public static final native int Mtc_ImDbGetFtMax1toManyRecipients();

    public static final native int Mtc_ImDbGetFtMaxRunVusers();

    public static final native boolean Mtc_ImDbGetFtStAndFwEnabled();

    public static final native boolean Mtc_ImDbGetFtThumb();

    public static final native int Mtc_ImDbGetFtWarnSize();

    public static final native boolean Mtc_ImDbGetGroupChatAuth();

    public static final native boolean Mtc_ImDbGetGroupChatFullStandFwd();

    public static final native boolean Mtc_ImDbGetGroupChatOnlyFStandFwd();

    public static final native boolean Mtc_ImDbGetGroupChatSupt();

    public static final native boolean Mtc_ImDbGetGrpHttpsEnable();

    public static final native int Mtc_ImDbGetGrpLstVers();

    public static final native int Mtc_ImDbGetGzipListNumber();

    public static final native int Mtc_ImDbGetHttpGetConfInfoServPort();

    public static final native boolean Mtc_ImDbGetImCapAlwaysOn();

    public static final native boolean Mtc_ImDbGetImCapNonRcs();

    public static final native int Mtc_ImDbGetImChatRevokeTimer();

    public static final native int Mtc_ImDbGetImCmccChatRevokeTimer();

    public static final native boolean Mtc_ImDbGetImMsgTech();

    public static final native int Mtc_ImDbGetImSessionStart();

    public static final native boolean Mtc_ImDbGetImWarnIw();

    public static final native boolean Mtc_ImDbGetImWarnSf();

    public static final native int Mtc_ImDbGetImageShareQuery();

    public static final native boolean Mtc_ImDbGetImdnAutoSendDeliNtfy();

    public static final native boolean Mtc_ImDbGetImdnSendIWReqEnable();

    public static final native boolean Mtc_ImDbGetIsAuth();

    public static final native int Mtc_ImDbGetMax1ToNRecipient();

    public static final native int Mtc_ImDbGetMax1toManyRecipients();

    public static final native int Mtc_ImDbGetMaxAdhocGroupSize();

    public static final native int Mtc_ImDbGetMaxConcurrentSession();

    public static final native int Mtc_ImDbGetMaxSize1To1();

    public static final native int Mtc_ImDbGetMaxSize1ToM();

    public static final native int Mtc_ImDbGetMaxSizeFileTr();

    public static final native int Mtc_ImDbGetMaxSizeFileTrIncoming();

    public static final native int Mtc_ImDbGetMaxSizeImageShare();

    public static final native int Mtc_ImDbGetMaxSizeStandalone();

    public static final native int Mtc_ImDbGetMediaProtoType();

    public static final native int Mtc_ImDbGetMessagingUxType();

    public static final native boolean Mtc_ImDbGetMsAuthArchive();

    public static final native boolean Mtc_ImDbGetMsAuthProt();

    public static final native String Mtc_ImDbGetMsCacheDir();

    public static final native boolean Mtc_ImDbGetMsCmccSupport();

    public static final native int Mtc_ImDbGetMsDataConnSyncTimer();

    public static final native int Mtc_ImDbGetMsEventRptingType();

    public static final native int Mtc_ImDbGetMsServerPort();

    public static final native String Mtc_ImDbGetMsServerUrl();

    public static final native int Mtc_ImDbGetMsSmsStoreType();

    public static final native int Mtc_ImDbGetMsSyncTimer();

    public static final native boolean Mtc_ImDbGetMsUseTls();

    public static final native String Mtc_ImDbGetMsUserMsisdn();

    public static final native String Mtc_ImDbGetMsUserName();

    public static final native String Mtc_ImDbGetMsUserPwd();

    public static final native int Mtc_ImDbGetMsgFbDefault();

    public static final native String Mtc_ImDbGetMsgMatterUri();

    public static final native boolean Mtc_ImDbGetMultiMediaChat();

    public static final native String Mtc_ImDbGetMultiTextUri();

    public static final native boolean Mtc_ImDbGetPostCallAuth();

    public static final native boolean Mtc_ImDbGetPresSrvCap();

    public static final native boolean Mtc_ImDbGetSendDeliFailReqEnable();

    public static final native boolean Mtc_ImDbGetSendDeliFailReqEnableG();

    public static final native boolean Mtc_ImDbGetSendDeliFwdReqEnable();

    public static final native boolean Mtc_ImDbGetSendDeliRspEnable();

    public static final native boolean Mtc_ImDbGetSendDeliSuccReqEnable();

    public static final native boolean Mtc_ImDbGetSendDeliSuccReqEnableG();

    public static final native boolean Mtc_ImDbGetSendDispReqEnable();

    public static final native boolean Mtc_ImDbGetSendDispReqEnableG();

    public static final native boolean Mtc_ImDbGetSendDispRspEnable();

    public static final native boolean Mtc_ImDbGetSharedMapAuth();

    public static final native boolean Mtc_ImDbGetSharedSketchAuth();

    public static final native boolean Mtc_ImDbGetSmsFallbackAuth();

    public static final native String Mtc_ImDbGetSpamUri();

    public static final native boolean Mtc_ImDbGetStandaloneMsgAuth();

    public static final native int Mtc_ImDbGetSubsConfInfoExpire();

    public static final native boolean Mtc_ImDbGetSupInactive();

    public static final native boolean Mtc_ImDbGetThumbBase64EncodeEnable();

    public static final native int Mtc_ImDbGetTimerIdle();

    public static final native boolean Mtc_ImDbGetUseSessModeMsg();

    public static final native boolean Mtc_ImDbGetUserAliasAuth();

    public static final native String Mtc_ImDbGetVemMsgVersion();

    public static final native boolean Mtc_ImDbGetVvmAuth();

    public static final native int Mtc_ImDbRestoreProvision(int i10);

    public static final native int Mtc_ImDbSet1toManySelectedTech(int i10);

    public static final native int Mtc_ImDbSetAllowedOffline(boolean z10);

    public static final native int Mtc_ImDbSetAllowedSms(boolean z10);

    public static final native int Mtc_ImDbSetAllowedSmsType(int i10);

    public static final native int Mtc_ImDbSetAutAccept(boolean z10);

    public static final native int Mtc_ImDbSetAutAcceptGroupChat(boolean z10);

    public static final native int Mtc_ImDbSetCCAllowedTerminalType(short s10);

    public static final native int Mtc_ImDbSetCfsTrigger(int i10);

    public static final native int Mtc_ImDbSetChatAuth(boolean z10);

    public static final native int Mtc_ImDbSetChatBotBlcakList(String str);

    public static final native int Mtc_ImDbSetChatBotFqdnRoot(String str);

    public static final native int Mtc_ImDbSetChatBotUri(String str);

    public static final native int Mtc_ImDbSetComposerAuth(boolean z10);

    public static final native int Mtc_ImDbSetConfFctyUri(String str);

    public static final native int Mtc_ImDbSetCpimBase64EncodeEnable(boolean z10);

    public static final native int Mtc_ImDbSetDeferDelUri(String str);

    public static final native int Mtc_ImDbSetFirstMsgInvite(boolean z10);

    public static final native int Mtc_ImDbSetFtAutAccept(boolean z10);

    public static final native int Mtc_ImDbSetFtAuth(boolean z10);

    public static final native int Mtc_ImDbSetFtCapAlwaysOn(boolean z10);

    public static final native int Mtc_ImDbSetFtDefaultMech(int i10);

    public static final native int Mtc_ImDbSetFtFbDefault(int i10);

    public static final native int Mtc_ImDbSetFtFileDirect(String str);

    public static final native int Mtc_ImDbSetFtHttpCsPwd(String str);

    public static final native int Mtc_ImDbSetFtHttpCsUri(String str);

    public static final native int Mtc_ImDbSetFtHttpCsUser(String str);

    public static final native int Mtc_ImDbSetFtHttpFallback(int i10);

    public static final native int Mtc_ImDbSetFtHttpToken(String str);

    public static final native int Mtc_ImDbSetFtHttpUseApp(boolean z10);

    public static final native int Mtc_ImDbSetFtMax1ToNRecipient(int i10);

    public static final native int Mtc_ImDbSetFtMax1toManyRecipients(int i10);

    public static final native int Mtc_ImDbSetFtMaxRunVusers(int i10);

    public static final native int Mtc_ImDbSetFtStAndFwEnabled(boolean z10);

    public static final native int Mtc_ImDbSetFtThumb(boolean z10);

    public static final native int Mtc_ImDbSetFtWarnSize(int i10);

    public static final native int Mtc_ImDbSetGroupChatAuth(boolean z10);

    public static final native int Mtc_ImDbSetGroupChatFullStandFwd(boolean z10);

    public static final native int Mtc_ImDbSetGroupChatOnlyFStandFwd(boolean z10);

    public static final native int Mtc_ImDbSetGroupChatSupt(boolean z10);

    public static final native int Mtc_ImDbSetGrpHttpsEnable(boolean z10);

    public static final native int Mtc_ImDbSetGrpLstVers(int i10);

    public static final native int Mtc_ImDbSetGzipListNumber(int i10);

    public static final native int Mtc_ImDbSetHttpGetConfInfoServPort(int i10);

    public static final native int Mtc_ImDbSetImCapAlwaysOn(boolean z10);

    public static final native int Mtc_ImDbSetImCapNonRcs(boolean z10);

    public static final native int Mtc_ImDbSetImChatRevokeTimer(int i10);

    public static final native int Mtc_ImDbSetImCmccChatRevokeTimer(int i10);

    public static final native int Mtc_ImDbSetImMsgTech(boolean z10);

    public static final native int Mtc_ImDbSetImSessionStart(int i10);

    public static final native int Mtc_ImDbSetImWarnIw(boolean z10);

    public static final native int Mtc_ImDbSetImWarnSf(boolean z10);

    public static final native int Mtc_ImDbSetImageShareQuery(boolean z10);

    public static final native int Mtc_ImDbSetImdnAutoSendDeliNtfy(boolean z10);

    public static final native int Mtc_ImDbSetImdnSendIWReqEnable(boolean z10);

    public static final native int Mtc_ImDbSetIsAuth(boolean z10);

    public static final native int Mtc_ImDbSetMax1ToNRecipient(int i10);

    public static final native int Mtc_ImDbSetMax1toManyRecipients(int i10);

    public static final native int Mtc_ImDbSetMaxAdhocGroupSize(int i10);

    public static final native int Mtc_ImDbSetMaxSize1ToM(int i10);

    public static final native int Mtc_ImDbSetMaxSizeFileTr(int i10);

    public static final native int Mtc_ImDbSetMaxSizeFileTrIncoming(int i10);

    public static final native int Mtc_ImDbSetMaxSizeImageShare(int i10);

    public static final native int Mtc_ImDbSetMediaProtoType(int i10);

    public static final native int Mtc_ImDbSetMessagingUxType(int i10);

    public static final native int Mtc_ImDbSetMsAuthArchive(boolean z10);

    public static final native int Mtc_ImDbSetMsAuthProt(boolean z10);

    public static final native int Mtc_ImDbSetMsCacheDir(String str);

    public static final native int Mtc_ImDbSetMsCmccSupport(boolean z10);

    public static final native int Mtc_ImDbSetMsDataConnSyncTimer(int i10);

    public static final native int Mtc_ImDbSetMsEventRptingType(int i10);

    public static final native int Mtc_ImDbSetMsMmsStoreType(int i10);

    public static final native int Mtc_ImDbSetMsServerPort(int i10);

    public static final native int Mtc_ImDbSetMsServerUrl(String str);

    public static final native int Mtc_ImDbSetMsSmsStoreType(int i10);

    public static final native int Mtc_ImDbSetMsSyncTimer(int i10);

    public static final native int Mtc_ImDbSetMsUseTls(boolean z10);

    public static final native int Mtc_ImDbSetMsUserMsisdn(String str);

    public static final native int Mtc_ImDbSetMsUserName(String str);

    public static final native int Mtc_ImDbSetMsUserPwd(String str);

    public static final native int Mtc_ImDbSetMsgFbDefault(int i10);

    public static final native int Mtc_ImDbSetMsgMatterUri(String str);

    public static final native int Mtc_ImDbSetMultiTextUri(String str);

    public static final native int Mtc_ImDbSetPostCallAuth(boolean z10);

    public static final native int Mtc_ImDbSetSendDeliFailReqEnable(boolean z10);

    public static final native int Mtc_ImDbSetSendDeliFailReqEnableG(boolean z10);

    public static final native int Mtc_ImDbSetSendDeliFwdReqEnable(boolean z10);

    public static final native int Mtc_ImDbSetSendDeliRspEnable(boolean z10);

    public static final native int Mtc_ImDbSetSendDeliSuccReqEnable(boolean z10);

    public static final native int Mtc_ImDbSetSendDeliSuccReqEnableG(boolean z10);

    public static final native int Mtc_ImDbSetSendDispReqEnable(boolean z10);

    public static final native int Mtc_ImDbSetSendDispReqEnableG(boolean z10);

    public static final native int Mtc_ImDbSetSendDispRspEnable(boolean z10);

    public static final native int Mtc_ImDbSetSharedMapAuth(boolean z10);

    public static final native int Mtc_ImDbSetSharedSketchAuth(boolean z10);

    public static final native int Mtc_ImDbSetSpamUri(String str);

    public static final native int Mtc_ImDbSetStandaloneMsgAuth(boolean z10);

    public static final native int Mtc_ImDbSetSubsConfInfoExpire(int i10);

    public static final native int Mtc_ImDbSetSupInactive(boolean z10);

    public static final native int Mtc_ImDbSetThumbBase64EncodeEnable(boolean z10);

    public static final native int Mtc_ImDbSetUseSessModeMsg(boolean z10);

    public static final native int Mtc_ImDbSetUserAliasAuth(boolean z10);

    public static final native int Mtc_ImDbSetVemMsgVersion(String str);

    public static final native int Mtc_ImDbSetVvmAuth(boolean z10);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}
