package pageUIs.jquery;

public class UploadPageUI {
	public static final String FILE_LOADED_BY_NAME = "xpath=//p[@class='name' and text()='%s']";
	public static final String START_BUTTONS = "css=table button.start";
	public static final String FILE_UPLOADED_BY_NAME = "xpath=//p[@class='name']//a[text()='%s']";
	//gofile.io
	public static final String SPINNER_ICON_AT_MAIN_PAGE = "css=div.spinner-border";
	public static final String FILE_UPLOADED_BUTTON = "xpath=//input[@type='file']";
	public static final String SPINNER_ICON_AFTER_UPLOAD = "xpath=//div[@class='spinner-border']";
	public static final String PROGRESS_BAR_AFTER_UPLOAD = "xpath=//div[@class='progress position-relative mt-1']";
	public static final String SUCCESS_MESSAGE = "xpath=//div[@class='col-auto text-center']//div[@class='alert alert-secondary border border-success text-white']";
}
