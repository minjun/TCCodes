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
import requests
import sys

def log(str):
	print(datetime.datetime.now().strftime("%m:%d %H:%M:%S ") + str)

	
def send_notification_via_pushbullet(title, body):
    """ Sending notification via pushbullet.
        Args:
            title (str) : title of text.
            body (str) : Body of text.
    """
    data_send = {"type": "note", "title": title, "body": body}
 
    ACCESS_TOKEN = 'o.ABm9hO6AqEuXH1tMBYcQhxe5lYpLTHZf'
    resp = requests.post('https://api.pushbullet.com/v2/pushes', data=json.dumps(data_send),
                         headers={'Authorization': 'Bearer ' + ACCESS_TOKEN, 'Content-Type': 'application/json'})
    if resp.status_code != 200:
        log('send failed')
    else:
        log('complete sending')

def click(e):
	e.click()
	time.sleep(0.5)

def clickIfExists(by, text, tc=1):
	try:
		elem = WebDriverWait(driver, tc).until(EC.presence_of_element_located((by, text)))
		elem.click()
	except (TimeoutException,StaleElementReferenceException):
		pass

def isCap(strNew):
	ql = (u'明月鞋',u'月光宝甲衣',u'明月戒',u'明月帽',u'明月项链',u'明月手镯',
		u'屠龙刀',u'倚天剑',u'冰魄银针',u'墨玄掌套',u'碧磷鞭',u'烈日棍',u'西毒蛇杖',
		u'软猬甲',u'陨铁盾',u'孔雀氅',u'墨磷腰带',u'扬文',
		u'烈日宝靴',u'日光宝甲衣',u'烈日宝戒',u'烈日帽',u'烈日宝链',u'烈日宝镯',
		u'斩神刀',u'诛仙剑',u'暴雨梨花针',u'龙象拳套',u'七星鞭',u'残阳棍',u'伏虎杖',
		u'玄铁宝甲',u'罗刹盾',u'披星戴月',u'钨金腰带',u'清刚',
		u'斩龙宝靴',u'龙皮至尊衣',u'斩龙宝戒',u'斩龙帽',u'斩龙宝链',u'斩龙宝镯',
		u'飞宇天怒刀',u'九天龙吟剑',u'小李飞刀',u'天罡掌套',u'乌金玄火鞭',u'开天宝棍',u'达摩杖',
		u'龙骨宝甲',u'轩辕神盾',u'鎏金缦罗',u'天蚕围腰',u'龙鳞')
	if strNew[0:1] != '【':
		log(strNew)
	if strNew.find(u'【系统】游侠会：') != -1:
		return True;
	if strNew.find(u'【系统】青龙会组织：') != -1:
		for ql1 in ql:
			if strNew.find(ql1) != -1:
				return True;
		return False;
	return False;

def qinglong():
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
				time.sleep(5)
				pass
		else:		
			while True:
				try:
					click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.XPATH, '//button[text()="系统"]'))))
				except (TimeoutException,StaleElementReferenceException):
					log('failed2, retrying...')
					time.sleep(5)
					success = False
					break
				except UnexpectedAlertPresentException:
					time.sleep(5)
					break
				text = driver.find_element_by_class_name('out').text[-600:]
				idx = 0
				if strOld != "":
					idx = text.rfind(strOld) + len(strOld) + 1
				strNew = text[idx:]
				if len(strNew) > 0 and isCap(strNew):
					#driver.execute_script("var w = window.open('','','width=500,height=500');w.document.write('游侠青龙会!');w.focus();setTimeout(function() {w.close();}, 30000)")
					try:
						send_notification_via_pushbullet("您收到一条新消息！",strNew)
					except:
						pass
				strOld = text[-300:]
				time.sleep(5)


def killnpc(chapter, npc, path):
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
		except (TimeoutException,StaleElementReferenceException):
			return
	while True:
			clickIfExists(By.XPATH, '//button[text()="'+npc+'"]')
			clickIfExists(By.XPATH, '//button[text()="杀死"]')
			clickIfExists(By.XPATH, '//span[text()="'+pfm1+'"]')
			clickIfExists(By.XPATH, '//span[text()="'+pfm2+'"]')
			clickIfExists(By.CLASS_NAME, 'prev')

'''
#driver.get("file:///Users/minjun/Downloads/TCCodes/python/test.html")
#driver.find_element_by_class_name('prev').click()
browser_url = r'C:\Documents and Settings\Administrator\Local Settings\Application Data\360Chrome\Chrome\Application\360chrome.exe'
chromeOptions = webdriver.ChromeOptions()
chromeOptions.binary_location = browser_url
driver = webdriver.Chrome(chrome_options = chromeOptions)
'''
tc = 5
id = ''
pfm1 = '乾坤大挪移'
pfm2 = '易筋经神功'
task = 'qinglong'
url="http://sword-direct16.yytou.cn:8083/?id=3996817&time=1489858143854&key=39c22dc86d6e92ead011c7ee4f8abd3e&s_line=1"
if len(sys.argv) > 1:
	id = sys.argv[1]
	task = sys.argv[2]
	if id == 'nkgd':
		url="http://sword-direct16.yytou.cn:8083/?id=3704963&time=1488748381067&key=a79f77b6b4eb3de745dd3b2bedca88d2&s_line=1"
	elif id == 'take':
		url="http://sword-direct16.yytou.cn:8083/?key=1ca170f824016f138db234aabcd4c404&id=3502846&name=take777&time=1490724173851"
	elif id == 'nkgd1':
		url="http://sword-direct16.yytou.cn:8083/?id=3766773&time=1488748435257&key=1d07ac13bfe17ac32374a3b7fc67b4ac&s_line=1"
		pfm1 = '无影毒阵'
		pfm2 = '葵花宝典'
driver = webdriver.Chrome()		
driver.get(url)
while True:
	if task == 'zuihan':
		killnpc('第一章','醉汉',('e','n','n'))
	elif task == 'dipi':
		killnpc('第二章','地痞', ('n','n','n','n'))
	elif task == 'qinglong':
		qinglong()
driver.close()
