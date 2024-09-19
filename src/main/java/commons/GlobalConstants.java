package commons;

import java.io.File;

public class GlobalConstants {
	public static final String DEV_USER_URL="https://demo.nopcommerce.com/";
	public static final String ADMIN_USER_URL="https://admin-demo.nopcommerce.com/";
	public static final long SHORT_TIMEOUT=5;
	public static final long LONG_TIMEOUT=30;
	public static final String DEV_ADMIN_USER_NAME="admin@yourstore.com";
	public static final String DEV_ADMIN_PASSWORD="admin";
	public static final String OS_NAME=System.getProperty("os.name");
	public static final String JAVA_VERSION=System.getProperty("java.version");
	public static final String RELATIVE_PROJECT_PATH=System.getProperty("user.dir");
	public static final String UPLOAD_PATH=RELATIVE_PROJECT_PATH+ File.separator+"uploadFiles"+File.separator;
	public static final String DOWNLOAD_PATH=RELATIVE_PROJECT_PATH+File.separator+"downloadFiles"+File.separator;
	public static final String REPORT_IMAGE_PATH=RELATIVE_PROJECT_PATH + File.separator+"ReportNGScreenShots"+File.separator;
	public static final String RESOURCES_PATH="D:\\Automation\\03 - Maven-Hybrid-Framework\\src\\test" + File.separator+"resources"+File.separator;
	public static final String RESOURCES_PROJECT_PATH= RELATIVE_PROJECT_PATH+ File.separator+"src\\test\\resources\\";
	public static final String ENVIRONMENT_CONFIG_PATH= RELATIVE_PROJECT_PATH+ File.separator+"environmentConfig"+ File.separator;
	public static final String BROWSER_USERNAME = "anhtrm_l7rWnE";
	public static final String BROWSER_AUTOMATE_KEY = "ARH7bw3Qz59CHZqpRbqz";
	public static final String BROWSER_STACK_URL = "https://" + BROWSER_USERNAME + ":" +
			BROWSER_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

}


