package com.yanzhuang.test4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;

public class SeleniumTest
{

    public static void main(String[] args)
    {
//		WebDriver driver = new EdgeDriver();
//		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new InternetExplorerDriver();	//IE浏览器
//		WebDriver driver = new OperaDriver();
//		WebDriver driver = new SafariDriver();

		/*
		 * 指定浏览器驱动的路径
		 * 不指定会报 "org.openqa.selenium.WebDriverException: unknown error: cannot find Chrome binary" 异常
		 * 注意：使用不同浏览器时，此处的key也不一样
		 */
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        //指定浏览器的启动文件路径
        //不指定会报  "java.lang.IllegalStateException: The path to the driver executable must be set by the webdriver.chrome.driver system property" 异常
        options.setBinary("C:\\Users\\言壮\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);	//使用谷歌浏览器测试，运行后会自动打开谷歌浏览器

		/*
		 * 以上两个路径也可以不设置，把浏览器驱动放到浏览器的安装目录下，然后配置环境变量指向浏览器安装目录即可
		 * 注意 环境变量名必须是path，可以不区分大小写
		 * 这时就可以使用无参ChromeDriver()
		 * WebDriver driver = new ChromeDriver();
		 */
        driver.get("http://www.baidu.com/");	//访问外网资源
//	    driver.get("file:///F:\\LGC\\workspace_cloud\\UI-Test\\html\\index.html");	//访问本地资源，开头加不加file:///都可以

        String title = driver.getTitle();		//获得浏览器中的标题
        System.out.printf(title);				//会输出“百度一下，你就知道”

        driver.close();
    }

}

