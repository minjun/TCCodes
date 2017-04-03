from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
import time

driver = webdriver.Chrome()
driver.set_page_load_timeout(30)
url = "http://sword-direct16.yytou.cn:8083/?id=3912631&time=1489857020294&key=e2f4aecfd1326bc476f67219ad5f537a&s_line=1&game_skin=3"
while True:
	print('Loading...')
	try:
		driver.get(url)
		driver.refresh();
	except TimeoutException:
		continue;
	while True:
		#try:
			#element = WebDriverWait(driver, 30).until(EC.presence_of_element_located(By.XPATH, '//a[img/@src="http://res.yytou.cn/lunjian/img/ui3/liaotian3.png"]'))
			
		#elem = driver.find_element_by_id('out')
		#print("text:"+elem.get_attribute('innerHTML'))
		element = WebDriverWait(driver, 30).until(EC.presence_of_element_located(By.CLASS_NAME, 'cmd_main_jh'))
		#elem = driver.find_element_by_class_name('cmd_main_jh')
		elem.click()
		'''
		except:
			print("Can't locate chat element")
			time.sleep(5)
			break
		while True:
			time.sleep(5)
			print('Running...')
		'''
		
	


