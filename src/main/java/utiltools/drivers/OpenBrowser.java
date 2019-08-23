package utiltools.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utiltools.utiltools;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ ClassName: OpenBrowser
 * @ Author: DingDong
 * @ Date: 2019/8/9 11:52
 * @ Version: 1.0
 * @ desc: 浏览器打开驱动类
 */
public class OpenBrowser {
    WebDriver driver;


    public WebDriver chromeOpen() {
        /**
         * @Description:    java类作用描述
         * @Author:         dingdong
         * @CreateDate:     2019/8/9 14:47
         * @UpdateUser:     dingdong
         * @UpdateDate:     2019/8/9 14:47
         * @UpdateRemark:   修改内容
         * @param
         * @return: org.openqa.selenium.WebDriver
         * @exception:
         * @Version:        1.0
        */
        String webDriverPath = "E:\\drivers\\Drivers\\chromedriver76.exe";
        System.setProperty("webdriver.chrome.driver", webDriverPath);

        // 驱动插件
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // 启动时自动最大化窗口
        options.addArguments("--disable-popup-blocking"); // 禁用阻止弹出窗口
        options.addArguments("no-sandbox"); // 启动无沙盒模式运行
        options.addArguments("disable-extensions"); // 禁用扩展
        options.addArguments("no-default-browser-check"); // 默认浏览器检查
        Map<String, Object> prefs = new HashMap();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);// 禁用保存密码提示框

        driver = new ChromeDriver(options);
        //设置寻找一个元素的时间
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;

    }

    public WebDriver fireFoxOpen() {
        return driver;
    }

    public WebDriver ieOpen() {
        return driver;
    }
}
