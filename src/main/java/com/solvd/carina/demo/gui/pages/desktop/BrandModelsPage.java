package com.solvd.carina.demo.gui.pages.desktop;

import com.solvd.carina.demo.gui.components.ModelItem;
import com.solvd.carina.demo.gui.pages.common.BrandModelsPageBase;
import com.solvd.carina.demo.gui.pages.common.ModelInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = BrandModelsPageBase.class)
public class BrandModelsPage extends BrandModelsPageBase {

    @FindBy(xpath = "//div[@id='review-body']//li")
    private List<ModelItem> models;

    public BrandModelsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ModelInfoPageBase selectModel(String modelName) {
        for (ModelItem model : models) {
            if (model.readModel().equalsIgnoreCase(modelName)) {
                return model.openModelPage();
            }
        }
        throw new RuntimeException("Unable to open model: " + modelName);
    }

    public List<ModelItem> getModels() {
        return models;
    }

}
