package my.triple.util;

public class Util {
	
	private static boolean isLogAuditTrail = true;
	private static boolean isEnableCommonLogger = true;
	private static boolean isEnableLoggerAccessPage = false;
	
	public static boolean isLogAuditTrail() {
		return isLogAuditTrail;
	}
	public static void setLogAuditTrail(boolean isLogAuditTrail) {
		Util.isLogAuditTrail = isLogAuditTrail;
	}
	public static boolean isEnableCommonLogger() {
		return isEnableCommonLogger;
	}
	public static void setEnableCommonLogger(boolean isEnableCommonLogger) {
		Util.isEnableCommonLogger = isEnableCommonLogger;
	}
	public static boolean isEnableLoggerAccessPage() {
		return isEnableLoggerAccessPage;
	}
	public static void setEnableLoggerAccessPage(boolean isEnableLoggerAccessPage) {
		Util.isEnableLoggerAccessPage = isEnableLoggerAccessPage;
	}
	
}
