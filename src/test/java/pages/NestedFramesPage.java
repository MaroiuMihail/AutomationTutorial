package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPage extends BasePage {
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    private WebElement childIframeElement;

    public void dealNestedFrames(){
        frameMethods.switchToSpecificIframe("frame1");
        frameMethods.switchToSpecificIframe(childIframeElement);
        System.out.println(childIframeElement.getText());
    }
}
