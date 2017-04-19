# -*- coding: UTF-8 -*-

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.common.exceptions import TimeoutException
from selenium.common.exceptions import NoSuchElementException
from selenium.common.exceptions import StaleElementReferenceException
from selenium.common.exceptions import UnexpectedAlertPresentException
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
import time
import json
import datetime

def log(str):
	print(datetime.datetime.now().strftime("%I:%M%p on %B %d, %Y:") + str)

def click(e):
	e.click()
	time.sleep(0.5)

def clickIfExists(by, text, tc=1):
	try:
		elem = WebDriverWait(driver, tc).until(EC.presence_of_element_located((by, text)))
		elem.click()
	except (TimeoutException,StaleElementReferenceException):
		pass

def qinglong():
	#driver.execute_script("alert('qwer');")
	success = False
	strOld = ""
	while True:
		if not success:
			try:
				click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.XPATH, '//img[@alt="聊天"]'))))
				click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.XPATH, '//button[text()="系统"]'))))
				success = True
			except (TimeoutException,StaleElementReferenceException,UnexpectedAlertPresentException):
				log('failed1, retrying...')
				time.sleep(2)
				pass
		else:		
			while True:
				try:
					click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.XPATH, '//button[text()="系统"]'))))
				except (TimeoutException,StaleElementReferenceException,UnexpectedAlertPresentException):
					log('failed2, retrying...')
					time.sleep(2)
					break
				text = driver.find_element_by_class_name('out').text[-200:]
				idx = 0
				if strOld != "":
					idx = text.rfind(strOld) + len(strOld) + 1
				strNew = text[idx:]
				if strNew.find(u'【系统】游侠会：') != -1 or strNew.find(u'【系统】青龙会组织：') != -1:
					driver.execute_script("alert('"+strNew+"');")
				strOld = text[-100:]
				time.sleep(5)


def killzuihan():
	chapter = '第一章'
	path = ('e','n','n')
	npc = '醉汉'
	pfm = '乾坤大挪移'
	try:
		driver.find_element_by_class_name('cmd_map')
		log('already in place')
	except NoSuchElementException:
		try:
			click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.CLASS_NAME, 'cmd_main_jh'))))
			click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.XPATH, '//button[text()="其他章节"]'))))
			click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.XPATH, '//span[text()="'+chapter+'"]'))))
			click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.XPATH, '//button[text()="进入关卡"]'))))
			for d in path:
				click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.CLASS_NAME, 'cmd_click_exits_'+d))))
		except TimeoutException,StaleElementReferenceException:
			return
	while True:
			clickIfExists(By.XPATH, '//button[text()="'+npc+'"]')
			clickIfExists(By.XPATH, '//button[text()="杀死"]')
			clickIfExists(By.XPATH, '//span[text()="'+pfm+'"]')
			clickIfExists(By.CLASS_NAME, 'prev')

tc = 5
driver = webdriver.Chrome()
#driver.get("file:///Users/minjun/Downloads/TCCodes/python/test.html")
#driver.find_element_by_class_name('prev').click()
#url = "http://sword-direct16.yytou.cn:8083/?id=3704963&time=1488748381067&key=a79f77b6b4eb3de745dd3b2bedca88d2&s_line=1"
url="http://sword-direct16.yytou.cn:8083/?id=3912631&time=1489857020294&key=e2f4aecfd1326bc476f67219ad5f537a&s_line=1&game_skin=3"
driver.get(url)
while True:
	#killzuihan()
	qinglong()
driver.close()


