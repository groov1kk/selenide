package com.codeborne.selenide.commands;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.WebElementSource;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class GetSelectedValue implements Command<String> {
  private final GetSelectedOption getSelectedOption;

  public GetSelectedValue() {
    this(new GetSelectedOption());
  }

  GetSelectedValue(GetSelectedOption getSelectedOption) {
    this.getSelectedOption = getSelectedOption;
  }

  @Override
  @CheckReturnValue
  @Nullable
  public String execute(SelenideElement proxy, WebElementSource selectElement, @Nullable Object[] args) {
    try {
      WebElement option = getSelectedOption.execute(proxy, selectElement, args);
      return option.getAttribute("value");
    }
    catch (NoSuchElementException noSelectedOptions) {
      // TODO fix me: https://github.com/selenide/selenide/issues/1581
      return null;
    }
  }
}
