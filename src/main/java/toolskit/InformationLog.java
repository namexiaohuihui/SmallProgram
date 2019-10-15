package toolskit;

import org.apache.log4j.Logger;

/**
 * @ ClassName: InformationLog
 * @ Author: DingDong
 * @ Date: 2019/8/9 17:39
 * @ Version: 1.0
 * @ desc:
 */
public class InformationLog {
    protected static final Logger logger = Logger.getLogger(InformationLog.class);

    public static void inputLogInfo(String infoData) {
        logger.info(infoData);
    }

    public static void inputLogDebug(String infoData) {
        logger.debug(infoData);
    }

    public static void inputLogWarn(String infoData) {
        logger.warn(infoData);
    }

    public static void inputLogError(String infoData) {
        logger.error(infoData);
    }

    public static void inputLogFatal(String infoData) {
        logger.fatal(infoData);
    }

    public static void main(String[] args) {
        new InformationLog().inputLogDebug("sdsfdfsd");
    }
}

