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
        '星河剑','血屠刀','霹雳掌套','生死符','玉清棍','疯魔杖','毒龙鞭')
    '''
    if True or strNew[0:1] != '【':
        log(strNew)
    '''
    if strNew.find('【系统】游侠会：') != -1:
        return True;
    if strNew.find('【系统】青龙会组织：') != -1 or strNew.find('【系统】跨服：[16-20区]') != -1:
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
                    driver.execute_script("var w = window.open('','','width=500,height=500');w.document.write('游侠青龙会!');w.focus();setTimeout(function() {w.close();}, 30000)")
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
            clickIfExists(By.XPATH, '//span[text()="'+pfm2+'"]')
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
pfm1 = '乾坤大挪移'
pfm2 = '混元一气功'
task = 'qinglong'
if len(sys.argv) > 1:
    url = sys.argv[1]
    if len(sys.argv) > 2:
        task = sys.argv[2]
else:
    sys.exit()
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
