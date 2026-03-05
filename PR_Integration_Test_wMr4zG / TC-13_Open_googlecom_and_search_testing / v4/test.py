
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait,Select
from selenium.webdriver.support import expected_conditions as EC
import time,requests,re,os, traceback
try:
    from condition import Condition, ResolvedCondition, ConcatenationOperator
except Exception as e:
    pass
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
from lambdatest_selenium_driver import smartui_snapshot
options = webdriver.ChromeOptions()
driver = webdriver.Chrome(options=options)
try:

    actions = ActionChains(driver)
    def get_element(driver,locators):
        driver.implicitly_wait(6)
        if isinstance(locators[0], str):
            for locator in locators:
                try:
                    element = driver.find_element(By.XPATH, locator)
                    if element.is_displayed() and element.is_enabled():
                        return element
                except:
                    continue
        else:
            for locator in locators:
                by_method = By.XPATH if str(locator['isXPath']).lower() == "true" else By.CSS_SELECTOR
                try:
                    element = driver.find_element(by_method, locator['selector'])
                    if element.is_displayed() and element.is_enabled():
                        return element
                except:
                    continue
        return None
    driver.implicitly_wait(6)

    # Step - 1 : Open https://google.com
    driver.get("https://google.com")
    driver.implicitly_wait(6)

    # Step - 2 : Click on the search input field below Google logo
    element_locators = ["//textarea[@id='APjFqb' and @name='q']", "//textarea[@name='q' and @title='Search']", "//textarea[@title='Search' and @role='combobox']", '#APjFqb', '[name="q"][title="Search"]', '[title="Search"][aria-label="Search"]', '[title="Search"][role="combobox"]', '[title="Search"]', "//textarea[@title='Search' and @aria-label='Search']", '.gLFyf', "//textarea[starts-with(@title,'Searc')]", "//textarea[contains(@class,'gLFyf')]", "//textarea[contains(@title,'Search')]"]
    element = get_element(driver,element_locators)

    try:
        actions.move_to_element(element).click().perform()
    except:
        element.click()
    driver.implicitly_wait(6)

    # Step - 3 : Click on microsoft windows 12 trending search item in the search suggestions popup
    element_locators = ["//div[@id='Zrbbw']/div[1]/span[1]", "//div[@id='Zrbbw']/div[1]/span[1]", '#Zrbbw > div:nth-child(1) > span:nth-child(1)', '#Zrbbw > div:nth-child(1) > span:nth-child(1)', "//span[text()='microsoft windows 12']", "//span[contains(text(),'microsoft windows 12')]"]
    element = get_element(driver,element_locators)

    try:
        actions.move_to_element(element).click().perform()
    except:
        element.click()
    driver.implicitly_wait(6)

    # Step - 4 : Click on 'Browse Xbox Game Pass Games' link in top left search results
    element_locators = ["//h3[@id='_31Gpabu1Lpne5NoP3bPVQQ_46']", '#_31Gpabu1Lpne5NoP3bPVQQ_46', "//h3[text()='Browse Xbox Game Pass Games']", "//h3[contains(text(),'Browse Xbox Game Pass Games')]", "//div[@id='rso']/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/a[1]/h3[1]", '#rso > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1) > a:nth-child(1) > h3:nth-child(1)']
    element = get_element(driver,element_locators)

    try:
        actions.move_to_element(element).click().perform()
    except:
        element.click()

    driver.quit()
except Exception as e:
    driver.quit()
