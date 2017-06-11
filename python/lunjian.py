# -*- coding: UTF-8 -*-

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.common.exceptions import TimeoutException
from selenium.common.exceptions import NoSuchElementException
from selenium.common.exceptions import StaleElementReferenceException
from selenium.common.exceptions import UnexpectedAlertPresentException
from selenium.common.exceptions import WebDriverException
from selenium.common.exceptions import ElementNotVisibleException
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
from multiprocessing import Queue
import time
import json
import datetime
import requests
import sys

def log(str):
    str = datetime.datetime.now().strftime("%m:%d %H:%M:%S ") + str
    print(str)
    f = open('lunjian.log','a')
    f.write(str + '\n')
    f.close()

send_times = 0
def send_notification_via_pushbullet(title, body):
    global send_times 
    send_times = send_times + 1
    if send_times > 5:
        send_times = 0
        log('send failed, aborting...')
        return
    data_send = {"type": "note", "title": title, "body": body}
    ACCESS_TOKEN = 'o.0CuCyQ9NysaI9nNefjZstbIPADUqiuSs'
    try:
        resp = requests.post('https://api.pushbullet.com/v2/pushes', data=json.dumps(data_send),
                        headers={'Authorization': 'Bearer ' + ACCESS_TOKEN, 'Content-Type': 'application/json'})
    except Exception as e:
        print(e)
        log('send failed ' + str(send_times))
        time.sleep(5)
        send_notification_via_pushbullet(title, body)
        return;
    send_times = 0
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
    except (TimeoutException,StaleElementReferenceException,ElementNotVisibleException):
        pass

def isCap(strNew):
    ql = (
        #'明月鞋','月光宝甲衣','明月戒','明月帽','明月项链','明月手镯',
        '屠龙刀','倚天剑','冰魄银针','墨玄掌套','碧磷鞭','烈日棍','西毒蛇杖',
        #'软猬甲','陨铁盾','孔雀氅','墨磷腰带','扬文',
        #'烈日宝靴','日光宝甲衣','烈日宝戒','烈日帽','烈日宝链','烈日宝镯',
        '斩神刀','诛仙剑','暴雨梨花针','龙象拳套','七星鞭','残阳棍','伏虎杖',
        #'玄铁宝甲','罗刹盾','披星戴月','钨金腰带','清刚',
        #'斩龙宝靴','龙皮至尊衣','斩龙宝戒','斩龙帽','斩龙宝链','斩龙宝镯',
        '飞宇天怒刀','九天龙吟剑','小李飞刀','天罡掌套','乌金玄火鞭','开天宝棍','达摩杖',
        #'龙骨宝甲','轩辕神盾','鎏金缦罗','天蚕围腰','龙鳞',
        '明月','月光宝甲衣','烈日','日光宝甲衣','残雪','金丝宝甲衣','斩龙','龙皮至尊甲衣',
        '星河剑','血屠刀','霹雳掌套','生死符','玉清棍','疯魔杖','毒龙鞭',
        '小还丹','狂暴丹','乾坤再造丹','灵草','紫芝')
    #key = ('官府：二娘','官府：段老大','段老大','游侠会：')
    key = ('段老大','游侠会：')
    #if True or strNew[0:1] != '【':
        #log(strNew)
    for key1 in key:
        if strNew.find('【系统】' + key1) != -1:
            return True;
    if strNew.find('【系统】青龙会组织：') != -1:
        for ql1 in ql:
            if strNew.find(ql1) != -1:
                return True;
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
                    log(strNew)
                    #driver.execute_script("var w = window.open('','','width=500,height=500');w.document.write('游侠青龙会!');w.focus();setTimeout(function() {w.close();}, 30000)")
                    send_notification_via_pushbullet("您收到一条新消息！",strNew)
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
        except (TimeoutException,StaleElementReferenceException,WebDriverException,ElementNotVisibleException):
            return
    while True:
            clickIfExists(By.XPATH, '//button[text()="'+npc+'"]')
            clickIfExists(By.XPATH, '//button[text()="杀死"]')
            clickIfExists(By.XPATH, '//span[text()="'+pfm1+'"]')
            #clickIfExists(By.XPATH, '//span[text()="'+pfm2+'"]')
            clickIfExists(By.CLASS_NAME, 'prev')
def key():
    clickIfExists(By.XPATH, '//span[text()="银钥匙"]', 10)
    clickIfExists(By.XPATH, '//button[text()="捡起"]', 10)

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
task = 'qinglong'
url="http://sword-direct16.yytou.cn:8083/?id=4423811&time=1497125692731&key=7099871afff97ccdaa68f8a98de3b372&s_line=1"
#url="http://res.yytou.cn/site/sword/sword.html?key=7099871afff97ccdaa68f8a98de3b372&id=4423811&name=yekai2&time=1497125692731&area=16&port=8083&arg=3704963"
if len(sys.argv) > 1:
    id = sys.argv[1]
    task = sys.argv[2]
    if id == 'nkgd':
        url="http://sword-direct16.yytou.cn:8083/?id=3704963&time=1488748381067&key=a79f77b6b4eb3de745dd3b2bedca88d2&s_line=1"
    elif id == 'take':
        url="http://sword-direct16.yytou.cn:8083/?key=1ca170f824016f138db234aabcd4c404&id=3502846&name=take777&time=1490724173851&s_line=1"
    elif id == 'nkgd1':
        url="http://sword-direct16.yytou.cn:8083/?id=3766773&time=1488748435257&key=1d07ac13bfe17ac32374a3b7fc67b4ac&s_line=1"
driver = webdriver.Chrome()        
driver.get(url)
while True:
    if task == 'zuihan':
        killnpc('第一章','醉汉',('e','n','n'))
    elif task == 'dipi':
        killnpc('第二章','地痞', ('n','n','n','n'))
    elif task == 'qinglong':
        qinglong()
    elif task == 'key':
        key()
#driver.close()
