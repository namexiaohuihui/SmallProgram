package utiltools;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * @ ClassName: InformationLog
 * @ Author: DingDong
 * @ Date: 2019/8/9 17:39
 * @ Version: 1.0
 * @ desc:
 */

public class InformationLog {
    private Log logger;

    public InformationLog(String obj) {
        logger = LogFactory.getLog(obj);
    }

    public void infoRemarks(String info) {
        logger.info(info);
    }

    public static void main(String[] args) {
        InformationLog logs = new InformationLog("run");
        logs.infoRemarks("这是什么情况呀?..");
    }
}
