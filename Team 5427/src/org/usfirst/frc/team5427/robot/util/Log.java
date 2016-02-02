package org.usfirst.frc.team5427.robot.util;


@SuppressWarnings(value = { "all" })
public class Log {

	private static String s = ""; //TODO make into an arraylsit so that the program name can be added later

	public static void pl(String text) {
		System.out.println(text);
	}

	public static void p(String text) {
		System.out.print(text);
	}

	public static void log(String logLevel, String text) {
		if (Config.LOGGING||logLevel == "[ERROR]"||logLevel == "[FATAL]"||logLevel == "[WARN]")
			System.out.println(Config.NAME + " " + logLevel + " " + text);
	}

	public static void warn(String text) {
		log("[WARN]", text);
	}

	public static void debug(String text) {
		if (Config.DEBUG_MODE)
			log("[DEBUG]", text);
	}

	public static void error(String text) {
		log("[ERROR]", text);
	}

	public static void info(String text) {
		log("[INFO]", text);
	}

	public static void fatal(String text) {
		log("[FATAL]", text);
	}
	
	public static void init(String text) {
		log("[INIT]", text);
	}
}
