package logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static Logger Log = LogManager.getRootLogger();
    private static ExecutionTimer executionTimer = new ExecutionTimer();

    public static void error(String message) {
        Log.error(message);
    }

    public static void info(String message) {
        Log.info(message);
    }

    public static void logStart(String message) {
        Log.info(message);
        executionTimer.start();
    }

    public static void warn(String message) {
        Log.warn(message);
    }

    public static void logEnd(String message) {
        Log.info(executionTimer.toString() + message);
    }
}
