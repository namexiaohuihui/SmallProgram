package testDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utiltools.drivers.OpenBrowser;

/**
 * @ ClassName: TestDemo
 * @ Author: DingDong
 * @ Date: 2019/8/9 14:36
 * @ Version: 1.0
 * @ desc:
 */
public class TestDemo {
    WebDriver driver;

    @BeforeTest
    public void init() {
        String url = "http://www.baidu.com";
        driver = new OpenBrowser().chromeOpen();
        //打开URL
        driver.get(url);
    }

    @Test
    @Parameters("dingdong")
    public void hanshumingzi(String searchWord) throws InterruptedException {
        //输入搜索字符串
        driver.findElement(By.xpath("//*[@id=\"kw\"]")).sendKeys(searchWord);
        //点击[百度一下]按钮
        driver.findElement(By.xpath("//*[@id=\"su\"]")).click();
        Thread.sleep(2000);
    }

    @Test
    public void startSearch() throws InterruptedException {
        //输入搜索字符串
        driver.findElement(By.xpath("//*[@id=\"kw\"]")).sendKeys("叮咚");
        //点击[百度一下]按钮
        driver.findElement(By.xpath("//*[@id=\"su\"]")).click();
        Thread.sleep(2000);
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
