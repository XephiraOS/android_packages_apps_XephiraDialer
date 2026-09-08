package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcCliDbJNI {
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

    public static final native int Mtc_CliDbApplyAll();

    public static final native int Mtc_CliDbGet2ndRegAddrType();

    public static final native String Mtc_CliDbGet2ndSipRegIp();

    public static final native int Mtc_CliDbGet2ndSipRegStunPort();

    public static final native int Mtc_CliDbGet2ndSipRegTcpPort();

    public static final native int Mtc_CliDbGet2ndSipRegTlsPort();

    public static final native int Mtc_CliDbGet2ndSipRegUdpPort();

    public static final native String Mtc_CliDbGetAccNetInfo();

    public static final native String Mtc_CliDbGetAccNetInfoCity();

    public static final native String Mtc_CliDbGetAccNetInfoCountry();

    public static final native int Mtc_CliDbGetAccNetType();

    public static final native int Mtc_CliDbGetAlwaysUseImsApn();

    public static final native boolean Mtc_CliDbGetApplyChange();

    public static final native String Mtc_CliDbGetAuthName();

    public static final native String Mtc_CliDbGetAuthPass();

    public static final native String Mtc_CliDbGetAuthRealm();

    public static final native int Mtc_CliDbGetAuthType();

    public static final native boolean Mtc_CliDbGetAutoRegEnable();

    public static final native String Mtc_CliDbGetBsfRealm();

    public static final native String Mtc_CliDbGetBsfServAddr();

    public static final native String Mtc_CliDbGetBsfServAddrType();

    public static final native int Mtc_CliDbGetBsfServPort();

    public static final native boolean Mtc_CliDbGetCalibrateTime();

    public static final native String Mtc_CliDbGetCellId();

    public static final native String Mtc_CliDbGetChatBotVer();

    public static final native boolean Mtc_CliDbGetCmccGrpSupt();

    public static final native String Mtc_CliDbGetCnpcHttpServAddr();

    public static final native int Mtc_CliDbGetCnpcHttpServPort();

    public static final native String Mtc_CliDbGetCnpcSyncServRoot();

    public static final native String Mtc_CliDbGetCnpcVerifyServRoot();

    public static final native String Mtc_CliDbGetCompany();

    public static final native boolean Mtc_CliDbGetContactAddrUpdt();

    public static final native boolean Mtc_CliDbGetContactUriObParm();

    public static final native int Mtc_CliDbGetDataBearerType();

    public static final native boolean Mtc_CliDbGetDeactedEnable();

    public static final native String Mtc_CliDbGetDevToken();

    public static final native boolean Mtc_CliDbGetDnsEnableCache();

    public static final native int Mtc_CliDbGetDnsLclPort();

    public static final native int Mtc_CliDbGetDnsServIp(boolean z10);

    public static final native int Mtc_CliDbGetDnsServPort(boolean z10);

    public static final native String Mtc_CliDbGetDtlsCaFile();

    public static final native boolean Mtc_CliDbGetEcscmsAuth();

    public static final native String Mtc_CliDbGetEcscmsNumberPrefixes();

    public static final native String Mtc_CliDbGetEcscmsServAddr();

    public static final native String Mtc_CliDbGetEcscmsServAddrType();

    public static final native int Mtc_CliDbGetFthttpUpSrvType();

    public static final native String Mtc_CliDbGetGrpHttpAuthName();

    public static final native String Mtc_CliDbGetGrpHttpServAddr();

    public static final native int Mtc_CliDbGetGrpHttpServPort();

    public static final native int Mtc_CliDbGetHeartbeatStepLen();

    public static final native int Mtc_CliDbGetHeartbeatTmr();

    public static final native String Mtc_CliDbGetHttpProxySrvAddr();

    public static final native short Mtc_CliDbGetHttpProxySrvPort();

    public static final native int Mtc_CliDbGetHttpProxyType();

    public static final native String Mtc_CliDbGetIMEI();

    public static final native boolean Mtc_CliDbGetIapAuth();

    public static final native String Mtc_CliDbGetIapServAddr();

    public static final native String Mtc_CliDbGetIapServAddrType();

    public static final native String Mtc_CliDbGetImpi();

    public static final native String Mtc_CliDbGetImpu();

    public static final native int Mtc_CliDbGetIntUriFmt();

    public static final native int Mtc_CliDbGetKeepAliveType();

    public static final native String Mtc_CliDbGetLocalIp();

    public static final native int Mtc_CliDbGetLocalIpX();

    public static final native String Mtc_CliDbGetLocalIpv6();

    public static final native int Mtc_CliDbGetMaxHeartbeatTime();

    public static final native int Mtc_CliDbGetMinHeartbeatTime();

    public static final native int Mtc_CliDbGetMsrpKeepAliveIntval();

    public static final native int Mtc_CliDbGetMsrpKeepAliveType();

    public static final native boolean Mtc_CliDbGetMsrpLogFileInfoPrint();

    public static final native boolean Mtc_CliDbGetMsrpLogMsgPrint();

    public static final native boolean Mtc_CliDbGetMsrpSendBodiless();

    public static final native int Mtc_CliDbGetMsrpTptTrunkSize();

    public static final native boolean Mtc_CliDbGetNabAuth();

    public static final native String Mtc_CliDbGetNabServAddr();

    public static final native String Mtc_CliDbGetNabServAddrType();

    public static final native int Mtc_CliDbGetNatTraversalMode();

    public static final native int Mtc_CliDbGetNatUriFmt();

    public static final native String Mtc_CliDbGetNickName();

    public static final native boolean Mtc_CliDbGetPaAuth();

    public static final native String Mtc_CliDbGetPaAuthName();

    public static final native String Mtc_CliDbGetPaAuthPass();

    public static final native String Mtc_CliDbGetPaAuthToken();

    public static final native int Mtc_CliDbGetPaAuthType();

    public static final native String Mtc_CliDbGetPaHttpUserId();

    public static final native String Mtc_CliDbGetPaServAddr();

    public static final native String Mtc_CliDbGetPaServAddrType();

    public static final native int Mtc_CliDbGetPaServPort();

    public static final native String Mtc_CliDbGetPaServRoot();

    public static final native String Mtc_CliDbGetPaUserAgent();

    public static final native String Mtc_CliDbGetPaVers();

    public static final native String Mtc_CliDbGetPcAsServAddr();

    public static final native String Mtc_CliDbGetPcAsServAddrType();

    public static final native int Mtc_CliDbGetPcAsServPort();

    public static final native String Mtc_CliDbGetPcImpu();

    public static final native String Mtc_CliDbGetPhoneContext();

    public static final native boolean Mtc_CliDbGetPnbEnable();

    public static final native boolean Mtc_CliDbGetProfileAuth();

    public static final native String Mtc_CliDbGetProfileAuthName();

    public static final native String Mtc_CliDbGetProfileAuthPass();

    public static final native String Mtc_CliDbGetProfileAuthToken();

    public static final native int Mtc_CliDbGetProfileAuthType();

    public static final native String Mtc_CliDbGetProfileServAddr();

    public static final native String Mtc_CliDbGetProfileServAddrType();

    public static final native int Mtc_CliDbGetProfileServPort();

    public static final native String Mtc_CliDbGetProfileServRoot();

    public static final native boolean Mtc_CliDbGetProxyEnable();

    public static final native String Mtc_CliDbGetQValue();

    public static final native String Mtc_CliDbGetQrcardAuthName();

    public static final native String Mtc_CliDbGetQrcardAuthPass();

    public static final native String Mtc_CliDbGetQrcardAuthToken();

    public static final native int Mtc_CliDbGetQrcardAuthType();

    public static final native String Mtc_CliDbGetQrcardServAddr();

    public static final native String Mtc_CliDbGetQrcardServAddrType();

    public static final native int Mtc_CliDbGetQrcardServPort();

    public static final native String Mtc_CliDbGetQrcardServRoot();

    public static final native boolean Mtc_CliDbGetRcsDisableState();

    public static final native String Mtc_CliDbGetRcseOnlyApn();

    public static final native short Mtc_CliDbGetRcseSwitchType();

    public static final native int Mtc_CliDbGetReconnectGuardTimer();

    public static final native int Mtc_CliDbGetRegAddrType();

    public static final native int Mtc_CliDbGetRegExpire();

    public static final native int Mtc_CliDbGetRegExpireType();

    public static final native boolean Mtc_CliDbGetRegNoDigest();

    public static final native int Mtc_CliDbGetRegRetryCount();

    public static final native boolean Mtc_CliDbGetRegTagConverg();

    public static final native int Mtc_CliDbGetRegTmr1();

    public static final native int Mtc_CliDbGetRegTmr2();

    public static final native boolean Mtc_CliDbGetRegUseLclIp();

    public static final native int Mtc_CliDbGetRoamType();

    public static final native int Mtc_CliDbGetRvkTmrLen();

    public static final native String Mtc_CliDbGetSSOWhiteAddr(int i10);

    public static final native int Mtc_CliDbGetSSOWhiteAddrLstSize();

    public static final native String Mtc_CliDbGetSSOWhiteAddrType(int i10);

    public static final native int Mtc_CliDbGetSipDscpValue();

    public static final native boolean Mtc_CliDbGetSipInstanceEnable();

    public static final native int Mtc_CliDbGetSipLclTcpPort();

    public static final native int Mtc_CliDbGetSipLclTlsPort();

    public static final native int Mtc_CliDbGetSipLclUdpPort();

    public static final native String Mtc_CliDbGetSipRegIp();

    public static final native String Mtc_CliDbGetSipRegRealm();

    public static final native int Mtc_CliDbGetSipRegStunPort();

    public static final native int Mtc_CliDbGetSipRegTcpPort();

    public static final native int Mtc_CliDbGetSipRegTlsPort();

    public static final native short Mtc_CliDbGetSipRegTpt();

    public static final native int Mtc_CliDbGetSipRegUdpPort();

    public static final native String Mtc_CliDbGetSipServIp(boolean z10);

    public static final native int Mtc_CliDbGetSipServPort(boolean z10);

    public static final native int Mtc_CliDbGetSipServPortX(boolean z10, short s10);

    public static final native String Mtc_CliDbGetSipServRealm(boolean z10);

    public static final native short Mtc_CliDbGetSipServTpt(boolean z10);

    public static final native int Mtc_CliDbGetSipTmr1();

    public static final native int Mtc_CliDbGetSipTmr2();

    public static final native int Mtc_CliDbGetSipTmr4();

    public static final native boolean Mtc_CliDbGetSsoAuth();

    public static final native String Mtc_CliDbGetSsoServAddr();

    public static final native String Mtc_CliDbGetSsoServAddrType();

    public static final native String Mtc_CliDbGetStgTunnelIp();

    public static final native int Mtc_CliDbGetStgTunnelPort();

    public static final native boolean Mtc_CliDbGetStgTunnelProxyEnable();

    public static final native String Mtc_CliDbGetStgTunnelProxySrvAddr();

    public static final native short Mtc_CliDbGetStgTunnelProxySrvPort();

    public static final native String Mtc_CliDbGetStgTunnelProxySrvPwd();

    public static final native String Mtc_CliDbGetStgTunnelProxySrvUsername();

    public static final native int Mtc_CliDbGetStgTunnelType();

    public static final native int Mtc_CliDbGetStgUseType();

    public static final native String Mtc_CliDbGetStunServerName();

    public static final native int Mtc_CliDbGetStunServerPort();

    public static final native boolean Mtc_CliDbGetSubsRegEvnt();

    public static final native int Mtc_CliDbGetSubsRegExpire();

    public static final native String Mtc_CliDbGetTlsCliCertFile();

    public static final native int Mtc_CliDbGetTlsCliMethod();

    public static final native String Mtc_CliDbGetTlsCliPrvKeyFile();

    public static final native String Mtc_CliDbGetTlsCliPrvKeyPass();

    public static final native String Mtc_CliDbGetTlsCliTrustCaFile();

    public static final native String Mtc_CliDbGetTlsCliTrustCaPath();

    public static final native int Mtc_CliDbGetTlsCliVeryType();

    public static final native String Mtc_CliDbGetTlsServCertFile();

    public static final native int Mtc_CliDbGetTlsServMethod();

    public static final native String Mtc_CliDbGetTlsServPrvKeyFile();

    public static final native String Mtc_CliDbGetTlsServPrvKeyPass();

    public static final native String Mtc_CliDbGetTlsServTrustCaFile();

    public static final native int Mtc_CliDbGetTlsServVeryType();

    public static final native String Mtc_CliDbGetTokenType();

    public static final native String Mtc_CliDbGetTurnServerName();

    public static final native int Mtc_CliDbGetTurnServerPort();

    public static final native boolean Mtc_CliDbGetUseBackupServer();

    public static final native boolean Mtc_CliDbGetUseDmPwd();

    public static final native boolean Mtc_CliDbGetUseIpv4();

    public static final native boolean Mtc_CliDbGetUseTelUri();

    public static final native String Mtc_CliDbGetUserAgent();

    public static final native boolean Mtc_CliDbGetUserMangerAuth();

    public static final native String Mtc_CliDbGetUserMangerServAddr();

    public static final native String Mtc_CliDbGetUserMangerServAddrType();

    public static final native String Mtc_CliDbGetUserName();

    public static final native boolean Mtc_CliDbGetUserReg();

    public static final native boolean Mtc_CliDbGetUserRegDetect();

    public static final native int Mtc_CliDbGetUserState();

    public static final native boolean Mtc_CliDbGetUxMessagingUX();

    public static final native String Mtc_CliDbGetVoipToken();

    public static final native int Mtc_CliDbGetWifiHeartbeatTmr();

    public static final native int Mtc_CliDbGetWifiMaxHeartbeatTime();

    public static final native int Mtc_CliDbGetWifiMinHeartbeatTime();

    public static final native String Mtc_CliDbGetXcapAgProxyIp();

    public static final native int Mtc_CliDbGetXcapAgProxyPort();

    public static final native String Mtc_CliDbGetXcapAuthName();

    public static final native String Mtc_CliDbGetXcapAuthPass();

    public static final native String Mtc_CliDbGetXcapAuthToken();

    public static final native int Mtc_CliDbGetXcapAuthType();

    public static final native String Mtc_CliDbGetXcapChatGrpUri();

    public static final native String Mtc_CliDbGetXcapHost();

    public static final native int Mtc_CliDbGetXcapHostPort();

    public static final native String Mtc_CliDbGetXcapPreArgGrpUri();

    public static final native String Mtc_CliDbGetXcapRlsSrvUri();

    public static final native String Mtc_CliDbGetXcapRoot();

    public static final native String Mtc_CliDbGetXcapRootUri();

    public static final native boolean Mtc_CliDbGetXcapUriNsSupt();

    public static final native String Mtc_CliDbGetXcapUserId();

    public static final native int Mtc_CliDbGetXcapcTcpListenPort();

    public static final native boolean Mtc_CliDbGetXdmChgSubsEnable();

    public static final native int Mtc_CliDbSet2ndRegAddrType(int i10);

    public static final native int Mtc_CliDbSet2ndSipRegIp(String str);

    public static final native int Mtc_CliDbSet2ndSipRegStunPort(int i10);

    public static final native int Mtc_CliDbSet2ndSipRegTcpPort(int i10);

    public static final native int Mtc_CliDbSet2ndSipRegTlsPort(int i10);

    public static final native int Mtc_CliDbSet2ndSipRegUdpPort(int i10);

    public static final native int Mtc_CliDbSetAccNetInfo(String str);

    public static final native int Mtc_CliDbSetAccNetInfoCity(String str);

    public static final native int Mtc_CliDbSetAccNetInfoCountry(String str);

    public static final native int Mtc_CliDbSetAccNetType(int i10);

    public static final native int Mtc_CliDbSetAcvServAddr(String str);

    public static final native int Mtc_CliDbSetAcvServPort(int i10);

    public static final native int Mtc_CliDbSetAcvUrl(String str);

    public static final native int Mtc_CliDbSetAlwaysUseImsApn(int i10);

    public static final native int Mtc_CliDbSetApplyChange(boolean z10);

    public static final native int Mtc_CliDbSetAuthName(String str);

    public static final native int Mtc_CliDbSetAuthPass(String str);

    public static final native int Mtc_CliDbSetAuthRealm(String str);

    public static final native int Mtc_CliDbSetAuthType(int i10);

    public static final native int Mtc_CliDbSetAutoRegEnable(boolean z10);

    public static final native int Mtc_CliDbSetBsfRealm(String str);

    public static final native int Mtc_CliDbSetBsfServAddr(String str);

    public static final native int Mtc_CliDbSetBsfServAddrType(String str);

    public static final native int Mtc_CliDbSetBsfServPort(int i10);

    public static final native int Mtc_CliDbSetCalibrateTime(boolean z10);

    public static final native int Mtc_CliDbSetCellId(String str);

    public static final native int Mtc_CliDbSetChatBotVer(String str);

    public static final native int Mtc_CliDbSetCmccGrpSupt(boolean z10);

    public static final native int Mtc_CliDbSetCnpcHttpServAddr(String str);

    public static final native int Mtc_CliDbSetCnpcHttpServPort(int i10);

    public static final native int Mtc_CliDbSetCnpcSyncServRoot(String str);

    public static final native int Mtc_CliDbSetCnpcVerifyServRoot(String str);

    public static final native int Mtc_CliDbSetCompany(String str);

    public static final native int Mtc_CliDbSetContactAddrUpdt(boolean z10);

    public static final native int Mtc_CliDbSetContactUriObParm(boolean z10);

    public static final native int Mtc_CliDbSetDataBearerType(int i10);

    public static final native int Mtc_CliDbSetDeactedEnable(boolean z10);

    public static final native int Mtc_CliDbSetDnsEnableCache(boolean z10);

    public static final native int Mtc_CliDbSetDnsLclPort(int i10);

    public static final native int Mtc_CliDbSetDnsServIp(boolean z10, int i10);

    public static final native int Mtc_CliDbSetDnsServPort(boolean z10, int i10);

    public static final native int Mtc_CliDbSetDtlsCaFile(String str);

    public static final native int Mtc_CliDbSetEcscmsAuth(boolean z10);

    public static final native int Mtc_CliDbSetEcscmsNumberPrefixes(String str);

    public static final native int Mtc_CliDbSetEcscmsServAddr(String str);

    public static final native int Mtc_CliDbSetEcscmsServAddrType(String str);

    public static final native int Mtc_CliDbSetFthttpUpSrvType(int i10);

    public static final native int Mtc_CliDbSetGrpHttpAuthName(String str);

    public static final native int Mtc_CliDbSetGrpHttpServAddr(String str);

    public static final native int Mtc_CliDbSetGrpHttpServPort(int i10);

    public static final native int Mtc_CliDbSetHeartbeatStepLen(int i10);

    public static final native int Mtc_CliDbSetHeartbeatTmr(int i10);

    public static final native int Mtc_CliDbSetHttpProxySrvAddr(String str);

    public static final native int Mtc_CliDbSetHttpProxySrvPort(int i10);

    public static final native int Mtc_CliDbSetHttpProxyType(int i10);

    public static final native int Mtc_CliDbSetIMEI(String str);

    public static final native int Mtc_CliDbSetIapAuth(boolean z10);

    public static final native int Mtc_CliDbSetIapServAddr(String str);

    public static final native int Mtc_CliDbSetIapServAddrType(String str);

    public static final native int Mtc_CliDbSetImpi(String str);

    public static final native int Mtc_CliDbSetImpu(String str);

    public static final native int Mtc_CliDbSetKeepAliveType(int i10);

    public static final native int Mtc_CliDbSetLocalIp(String str);

    public static final native int Mtc_CliDbSetLocalIpv6(String str);

    public static final native int Mtc_CliDbSetMaxHeartbeatTime(int i10);

    public static final native int Mtc_CliDbSetMinHeartbeatTime(int i10);

    public static final native int Mtc_CliDbSetMsrpKeepAliveIntval(int i10);

    public static final native int Mtc_CliDbSetMsrpKeepAliveType(int i10);

    public static final native int Mtc_CliDbSetMsrpLogFileInfoPrint(boolean z10);

    public static final native int Mtc_CliDbSetMsrpLogMsgPrint(boolean z10);

    public static final native int Mtc_CliDbSetMsrpSendBodiless(boolean z10);

    public static final native int Mtc_CliDbSetMsrpTptTrunkSize(int i10);

    public static final native int Mtc_CliDbSetNabAuth(boolean z10);

    public static final native int Mtc_CliDbSetNabServAddr(String str);

    public static final native int Mtc_CliDbSetNabServAddrType(String str);

    public static final native int Mtc_CliDbSetNatTraversalMode(int i10);

    public static final native int Mtc_CliDbSetNickName(String str);

    public static final native int Mtc_CliDbSetPaAuth(boolean z10);

    public static final native int Mtc_CliDbSetPaAuthName(String str);

    public static final native int Mtc_CliDbSetPaAuthPass(String str);

    public static final native int Mtc_CliDbSetPaAuthToken(String str);

    public static final native int Mtc_CliDbSetPaAuthType(int i10);

    public static final native int Mtc_CliDbSetPaHttpUserId(String str);

    public static final native int Mtc_CliDbSetPaServAddr(String str);

    public static final native int Mtc_CliDbSetPaServAddrType(String str);

    public static final native int Mtc_CliDbSetPaServPort(int i10);

    public static final native int Mtc_CliDbSetPaServRoot(String str);

    public static final native int Mtc_CliDbSetPaUserAgent(String str);

    public static final native int Mtc_CliDbSetPaVers(String str);

    public static final native int Mtc_CliDbSetPcAsServAddr(String str);

    public static final native int Mtc_CliDbSetPcAsServAddrType(String str);

    public static final native int Mtc_CliDbSetPcImpu(String str);

    public static final native int Mtc_CliDbSetPhoneContext(String str);

    public static final native int Mtc_CliDbSetPnbEnable(boolean z10);

    public static final native int Mtc_CliDbSetProfileAuth(boolean z10);

    public static final native int Mtc_CliDbSetProfileAuthName(String str);

    public static final native int Mtc_CliDbSetProfileAuthPass(String str);

    public static final native int Mtc_CliDbSetProfileAuthToken(String str);

    public static final native int Mtc_CliDbSetProfileAuthType(int i10);

    public static final native int Mtc_CliDbSetProfileServAddr(String str);

    public static final native int Mtc_CliDbSetProfileServAddrType(String str);

    public static final native int Mtc_CliDbSetProfileServPort(int i10);

    public static final native int Mtc_CliDbSetProfileServRoot(String str);

    public static final native int Mtc_CliDbSetProxyEnable(boolean z10);

    public static final native int Mtc_CliDbSetPushToken(String str, String str2, String str3);

    public static final native int Mtc_CliDbSetQrcardAuthName(String str);

    public static final native int Mtc_CliDbSetQrcardAuthPass(String str);

    public static final native int Mtc_CliDbSetQrcardAuthToken(String str);

    public static final native int Mtc_CliDbSetQrcardAuthType(int i10);

    public static final native int Mtc_CliDbSetQrcardServAddr(String str);

    public static final native int Mtc_CliDbSetQrcardServAddrType(String str);

    public static final native int Mtc_CliDbSetQrcardServPort(int i10);

    public static final native int Mtc_CliDbSetQrcardServRoot(String str);

    public static final native int Mtc_CliDbSetRcsDisableState(int i10);

    public static final native int Mtc_CliDbSetRcseOnlyApn(String str);

    public static final native int Mtc_CliDbSetRcseSwitchType(short s10);

    public static final native int Mtc_CliDbSetReconnectGuardTimer(int i10);

    public static final native int Mtc_CliDbSetRegAddrType(int i10);

    public static final native int Mtc_CliDbSetRegExpire(int i10);

    public static final native int Mtc_CliDbSetRegExpireType(int i10);

    public static final native int Mtc_CliDbSetRegNoDigest(boolean z10);

    public static final native int Mtc_CliDbSetRegRetryCount(int i10);

    public static final native int Mtc_CliDbSetRegTagConverg(boolean z10);

    public static final native int Mtc_CliDbSetRegTmr1(int i10);

    public static final native int Mtc_CliDbSetRegTmr2(int i10);

    public static final native int Mtc_CliDbSetRegUseLclIp(boolean z10);

    public static final native int Mtc_CliDbSetRoamType(int i10);

    public static final native int Mtc_CliDbSetSSOWhiteAddr(String str, int i10);

    public static final native int Mtc_CliDbSetSSOWhiteAddrLstSize(int i10);

    public static final native int Mtc_CliDbSetSSOWhiteAddrType(String str, int i10);

    public static final native int Mtc_CliDbSetSipDscpValue(int i10);

    public static final native int Mtc_CliDbSetSipInstanceEnable(boolean z10);

    public static final native int Mtc_CliDbSetSipLclTcpPort(int i10);

    public static final native int Mtc_CliDbSetSipLclTlsPort(int i10);

    public static final native int Mtc_CliDbSetSipLclUdpPort(int i10);

    public static final native int Mtc_CliDbSetSipRegIp(String str);

    public static final native int Mtc_CliDbSetSipRegRealm(String str);

    public static final native int Mtc_CliDbSetSipRegStunPort(int i10);

    public static final native int Mtc_CliDbSetSipRegTcpPort(int i10);

    public static final native int Mtc_CliDbSetSipRegTlsPort(int i10);

    public static final native int Mtc_CliDbSetSipRegTpt(short s10);

    public static final native int Mtc_CliDbSetSipRegUdpPort(int i10);

    public static final native int Mtc_CliDbSetSipServIp(boolean z10, String str);

    public static final native int Mtc_CliDbSetSipServPort(boolean z10, int i10);

    public static final native int Mtc_CliDbSetSipServPortX(boolean z10, short s10, int i10);

    public static final native int Mtc_CliDbSetSipServRealm(boolean z10, String str);

    public static final native int Mtc_CliDbSetSipServTpt(boolean z10, short s10);

    public static final native int Mtc_CliDbSetSipTmr1(int i10);

    public static final native int Mtc_CliDbSetSipTmr2(int i10);

    public static final native int Mtc_CliDbSetSipTmr4(int i10);

    public static final native int Mtc_CliDbSetSsoAuth(boolean z10);

    public static final native int Mtc_CliDbSetSsoServAddr(String str);

    public static final native int Mtc_CliDbSetSsoServAddrType(String str);

    public static final native int Mtc_CliDbSetStgTunnelIp(String str);

    public static final native int Mtc_CliDbSetStgTunnelPort(int i10);

    public static final native int Mtc_CliDbSetStgTunnelProxyEnable(boolean z10);

    public static final native int Mtc_CliDbSetStgTunnelProxySrvAddr(String str);

    public static final native int Mtc_CliDbSetStgTunnelProxySrvPort(int i10);

    public static final native int Mtc_CliDbSetStgTunnelProxySrvPwd(String str);

    public static final native int Mtc_CliDbSetStgTunnelProxySrvUsername(String str);

    public static final native int Mtc_CliDbSetStgTunnelType(int i10);

    public static final native int Mtc_CliDbSetStgUseType(int i10);

    public static final native int Mtc_CliDbSetStunServerName(String str);

    public static final native int Mtc_CliDbSetStunServerPort(int i10);

    public static final native int Mtc_CliDbSetSubsRegEvnt(boolean z10);

    public static final native int Mtc_CliDbSetSubsRegExpire(int i10);

    public static final native int Mtc_CliDbSetTlsCliCertFile(String str);

    public static final native int Mtc_CliDbSetTlsCliMethod(int i10);

    public static final native int Mtc_CliDbSetTlsCliPrvKeyFile(String str);

    public static final native int Mtc_CliDbSetTlsCliPrvKeyPass(String str);

    public static final native int Mtc_CliDbSetTlsCliTrustCaFile(String str);

    public static final native int Mtc_CliDbSetTlsCliTrustCaPath(String str);

    public static final native int Mtc_CliDbSetTlsCliVeryType(int i10);

    public static final native int Mtc_CliDbSetTlsServCertFile(String str);

    public static final native int Mtc_CliDbSetTlsServMethod(int i10);

    public static final native int Mtc_CliDbSetTlsServPrvKeyFile(String str);

    public static final native int Mtc_CliDbSetTlsServPrvKeyPass(String str);

    public static final native int Mtc_CliDbSetTlsServTrustCaFile(String str);

    public static final native int Mtc_CliDbSetTlsServVeryType(int i10);

    public static final native int Mtc_CliDbSetTurnServerName(String str);

    public static final native int Mtc_CliDbSetTurnServerPort(int i10);

    public static final native int Mtc_CliDbSetUseBackupServer(boolean z10);

    public static final native int Mtc_CliDbSetUseDmPwd(boolean z10);

    public static final native int Mtc_CliDbSetUseIpv4(boolean z10);

    public static final native int Mtc_CliDbSetUseTelUri(boolean z10);

    public static final native int Mtc_CliDbSetUserAgent(String str);

    public static final native int Mtc_CliDbSetUserIdPolicy(int i10);

    public static final native int Mtc_CliDbSetUserMangerAuth(boolean z10);

    public static final native int Mtc_CliDbSetUserMangerServAddr(String str);

    public static final native int Mtc_CliDbSetUserMangerServAddrType(String str);

    public static final native int Mtc_CliDbSetUserName(String str);

    public static final native int Mtc_CliDbSetUserReg(boolean z10);

    public static final native int Mtc_CliDbSetUserRegDetect(boolean z10);

    public static final native int Mtc_CliDbSetUserState(int i10);

    public static final native int Mtc_CliDbSetUxMessagingUX(boolean z10);

    public static final native int Mtc_CliDbSetWifiHeartbeatTmr(int i10);

    public static final native int Mtc_CliDbSetWifiMaxHeartbeatTime(int i10);

    public static final native int Mtc_CliDbSetWifiMinHeartbeatTime(int i10);

    public static final native int Mtc_CliDbSetXcapAgProxyIp(String str);

    public static final native int Mtc_CliDbSetXcapAgProxyPort(int i10);

    public static final native int Mtc_CliDbSetXcapAuthName(String str);

    public static final native int Mtc_CliDbSetXcapAuthPass(String str);

    public static final native int Mtc_CliDbSetXcapAuthToken(String str);

    public static final native int Mtc_CliDbSetXcapAuthType(int i10);

    public static final native int Mtc_CliDbSetXcapChatGrpUri(String str);

    public static final native int Mtc_CliDbSetXcapHost(String str);

    public static final native int Mtc_CliDbSetXcapHostPort(int i10);

    public static final native int Mtc_CliDbSetXcapPreArgGrpUri(String str);

    public static final native int Mtc_CliDbSetXcapRlsSrvUri(String str);

    public static final native int Mtc_CliDbSetXcapRoot(String str);

    public static final native int Mtc_CliDbSetXcapRootUri(String str);

    public static final native int Mtc_CliDbSetXcapUriNsSupt(boolean z10);

    public static final native int Mtc_CliDbSetXcapUserId(String str);

    public static final native int Mtc_CliDbSetXcapcTcpListenPort(int i10);

    public static final native int Mtc_CliDbSetXdmChgSubsEnable(boolean z10);

    public static final native int Mtc_CliDbSetpcAsServPort(int i10);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}
