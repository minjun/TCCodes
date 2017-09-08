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
#from tzlocal import get_localzone
from pytz import timezone
import time
import json
import datetime
import requests
import sys
import sched
import re

def log(str):
    global tz
    str = datetime.datetime.now(tz).strftime("%m:%d %H:%M:%S ") + str
    print(str)
    f = open('lunjian.log','a')
    f.write(str + '\n')
    f.close()

send_times = 0
def send_notification_via_pushbullet(title, body):
    global send_times,tz
    send_times = send_times + 1
    '''
    if send_times > 5:
        send_times = 0
        log('send failed, aborting...')
        return
    '''
    data_send = {"type": "note", "title": datetime.datetime.now(tz).strftime("%H:%M:%S ") + title, "body": body}
    ACCESS_TOKEN = 'o.FwGROrOxHEXvLVRvJoM8TAeAOLrmCyy3'
    try:
        resp = requests.post('https://api.pushbullet.com/v2/pushes', data=json.dumps(data_send),
                        headers={'Authorization': 'Bearer ' + ACCESS_TOKEN, 'Content-Type': 'application/json'})
        send_times = 0
        if resp.status_code != 200:
           log('send failed:' + str(resp.status_code))
        else:
           log('sent successfully:' + str(send_times))
    except Exception as e:
        #print(e)
        log('send failed ' + str(send_times))
        time.sleep(5)
        send_notification_via_pushbullet(title, body)

def click(e):
    e.click()
    time.sleep(0.5)

def clickIfExists(by, text, tc=1):
    try:
        elem = WebDriverWait(driver, tc).until(EC.presence_of_element_located((by, text)))
        elem.click()
        return True
    except (TimeoutException,StaleElementReferenceException,ElementNotVisibleException):
        pass
    return False

tz_string = 'Asia/Shanghai'
#tz_string = 'America/Denver'
tz = timezone(tz_string)
def isDaytime():
    global tz_string,tz
    h = datetime.datetime.now(tz).time().hour
    if tz_string == 'Asia/Shanghai':
        return h > 6 and h < 24;
    else:
        return h > 6 and h < 23;

def isCap(strNew):
    ql = (
        #'明月鞋','月光宝甲衣','明月戒','明月帽','明月项链','明月手镯',
        '屠龙刀','倚天剑','冰魄银针','墨玄掌套','碧磷鞭','烈日棍','西毒蛇杖',
        #'软猬甲','陨铁盾','孔雀氅','墨磷腰带','扬文',
        #'烈日宝靴','日光宝甲衣','烈日宝戒','烈日帽','烈日宝链','烈日宝镯',
        '斩神刀','诛仙剑','暴雨梨花针','龙象拳套','七星鞭','残阳棍','伏虎杖',
        #'玄铁宝甲','罗刹盾','披星戴月','钨金腰带','清刚',
        #'斩龙宝靴','龙皮至尊甲衣','斩龙宝戒','斩龙帽','斩龙宝链','斩龙宝镯',
        '飞宇天怒刀','九天龙吟剑','小李飞刀','天罡掌套','乌金玄火鞭','开天宝棍','达摩杖',
        #'龙骨宝甲','轩辕神盾','鎏金缦罗','天蚕围腰','龙鳞',
        '明月','月光宝甲衣','烈日','日光宝甲衣','残雪','金丝宝甲衣','斩龙','龙皮至尊甲衣',
        '星河剑','血屠刀','霹雳掌套','生死符','玉清棍','疯魔杖','毒龙鞭',
        '小还丹','狂暴丹','乾坤再造丹','灵草','紫芝','碎片')
    qlsp = (
        '斩龙宝靴','斩龙宝戒','九天龙吟剑','斩龙宝链','斩龙宝镯'
        )
    #key = ('官府：二娘','官府：段老大','段老大','游侠会：')
    key = ('游侠会：')
    #if True or strNew[0:1] != '【':
        #log(strNew)
    for key1 in key:
        if strNew.find('【系统】' + key1) != -1:
            log(strNew)
            return isDaytime()
    if strNew.find('【系统】青龙会组织：') != -1 or strNew.find('【系统】跨服：[16-20区]') != -1:
        for ql1 in qlsp:
            if strNew.find(ql1) != -1:
                log(strNew)
                return True
        for ql1 in ql:
            if strNew.find(ql1) != -1:
                log(strNew)
                return isDaytime()
    return False

def ql_getNext():
    global ql_idx,ql_path,ql_npc,ql_chapter
    ql_idx = ql_idx + 1
    if ql_idx == 1:
        ql_path = ('e','n','e','e','e','e','n')
        ql_npc = '柳绘心'
        ql_chapter = '第一章'
    elif ql_idx == 2:
        ql_path = ('e','n','n','w')
        ql_npc = '王铁匠'
        ql_chapter = '第一章'
    elif ql_idx == 3:
        ql_path = ('e','n','n','n','w')
        ql_npc = '杨掌柜'
        ql_chapter = '第一章'
    elif ql_idx == 4:
        ql_path = ('n','n','e')
        ql_npc = '客商'
        ql_chapter = '第二章'
    elif ql_idx == 5:
        ql_path = ('n','n','n','n','w','s','w')
        ql_npc = '柳小花'
        ql_chapter = '第二章'
    elif ql_idx == 6:
        ql_path = ('n','n','n','n','n','n','n')
        ql_npc = '卖花姑娘'
        ql_chapter = '第二章'
    elif ql_idx == 7:
        ql_path = ('n','n','n','n','n','n','n','e')
        ql_npc = '刘守财'
        ql_chapter = '第二章'
    elif ql_idx == 8:
        ql_path = ('s','s','e')
        ql_npc = '方老板'
        ql_chapter = '第三章'
    elif ql_idx == 9:
        ql_path = ('s','s','w')
        ql_npc = '朱老伯'
        ql_chapter = '第三章'
    elif ql_idx == 10:
        ql_path = ('s','s','w','n')
        ql_npc = '方寡妇'
        ql_chapter = '第三章'
    else:
        ql_idx = 0
        ql_getNext()

ql_time = datetime.datetime.now()
def ql_cango():
    global ql_time
    if ql_idx < 10:
        return True
    now = datetime.datetime.now()
    if ((now - ql_time).seconds > 300):
        #print(now)
        ql_time = now
        return True
    time.sleep(10)
    return False


def check_exists_by_xpath(xpath, bClick=True):
    try:
        elem = driver.find_element_by_xpath(xpath)
        if bClick:
            click(elem)
            time.sleep(0.5)
    except (NoSuchElementException,ElementNotVisibleException,WebDriverException):
        return False
    return True

def ql():
    global ql_idx,ql_path,ql_npc,ql_chapter
    if check_exists_by_xpath('//span[text()="1"]'):
        return
    if check_exists_by_xpath('//button[text()="进入关卡"]'):
        return
    if check_exists_by_xpath('//button[text()="确定"]'):
        return
    if check_exists_by_xpath('//img[@class="prev"]'):
        return
    if check_exists_by_xpath('//button[@class="cmd_out_map"]'):
        return
    if check_exists_by_xpath('//button[@class="cmd_combat_byebye"]'): 
        return
    if not check_exists_by_xpath('//button[@class="cmd_change_line"]',  False):
        return
    #if not ql_cango():
        #return
    if not isDaytime():
        time.sleep(30)
        return
    ql_getNext()
    try:
        click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.CLASS_NAME, 'cmd_main_jh'))))
        click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.XPATH, '//button[text()="其他章节"]'))))
        click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.XPATH, '//span[text()="'+ql_chapter+'"]'))))            
        click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.XPATH, '//button[text()="进入关卡"]'))))
        for d in ql_path:
            click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.CLASS_NAME, 'cmd_click_exits_'+d))))
    except (TimeoutException,StaleElementReferenceException,WebDriverException,ElementNotVisibleException):
        return
    time.sleep(1)
    player = 0
    try:
        player = len(driver.find_elements_by_xpath('//button[contains(@onclick,"score")]'))
    except (NoSuchElementException,ElementNotVisibleException,WebDriverException):
        pass
    if check_exists_by_xpath('//span[text()="金甲符兵"]', False) or check_exists_by_xpath('//span[text()="玄阴符兵"]', False) or player > 1:
        return
    if not check_exists_by_xpath('//button[not(contains(text(),"的尸体")) and ./span[text()="剧盗" or text()="云老四" or text()="岳老三"]]'):
        if not check_exists_by_xpath('//button[not(contains(text(),"的尸体")) and ./span[text()="'+ql_npc+'"]]'):
            return
    times = 0
    while times < 10:
        times = times + 1
        if check_exists_by_xpath('//span[text()="金甲符兵"]', False) or check_exists_by_xpath('//span[text()="玄阴符兵"]', False):
            check_exists_by_xpath('//button[@class="cmd_combat_byebye"]')
            check_exists_by_xpath('//img[@class="prev"]')
            return
        if not check_exists_by_xpath('//button[text()="杀死"]'):
            time.sleep(1)
        check_exists_by_xpath('//button[@class="cmd_combat_auto_fight"]')
        clickIfExists(By.XPATH, '//span[text()="茅山道术"]')
        clickIfExists(By.XPATH, '//span[text()="天师灭神剑"]')

    ql_idx = ql_idx - 1

schedule = sched.scheduler(time.time, time.sleep)
schedule_time = datetime.datetime.now() - datetime.timedelta(hours=1)
timeStart = datetime.time(3, 59, 30)
timeEnd   = datetime.time(4,  0, 30)

def idle(inc):
    global sechedule
    schedule.enter(0,0, idle1, (inc,))
    schedule.run()

def idle1(inc):
    global schedule,schedule_time,timeStart,timeEnd
    now = datetime.datetime.now()
    time = now.time()
    if time > timeStart and time < timeEnd:
        buff()
    elif now - datetime.timedelta(minutes = 10) > schedule_time:
        schedule_time = now
        exp()
    else:
        clickIfExists(By.CLASS_NAME, 'prev')
        pass
    schedule.enter(inc,0, idle1, (inc,))
    
def exp():
    try:
        if not check_exists_by_xpath('//img[@class="prev"'):
            click(WebDriverWait(driver, 5).until(EC.presence_of_element_located((By.CLASS_NAME, 'cmd_main_quest'))))
            time.sleep(1)
        while True:
            if not clickIfExists(By.XPATH,'//span[text()="奖励"]'):
                break
            time.sleep(1)
        clickIfExists(By.CLASS_NAME, 'prev')
        time.sleep(1)
    except (TimeoutException,StaleElementReferenceException,UnexpectedAlertPresentException):
        pass

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
                    send_notification_via_pushbullet("您收到一条新消息！",strNew)
                strOld = text[-300:]
                time.sleep(3)


pfm_buff_time = datetime.datetime.now() - datetime.timedelta(hours=1)
pfm_dodge_time = datetime.datetime.now() - datetime.timedelta(hours=1)

def fight():
    global pfm_buff_time, pfm_dodge_time
    strOld = ""
    regex_exclude = "(希望扰乱|所破|直接对攻|大喝一声，来吧|双目赤红|企图防御)"
    regex = "^\s*(只见)?(店小二|守剑人).*(你|右手小指一弹).*"
    if id == 'nkgd':
        pfm = "九天龙吟剑"
        pfm_buff = '紫霞神功'
    elif id == 'take':
        pfm = "如来神掌"
        pfm_buff = '葵花宝典'
    elif id == 'nkgd1':
        pfm = '降龙十八掌'
        pfm_buff = '葵花宝典'
    else:
        pfm = '没有设置'
    while True:
        check_exists_by_xpath('//button[@class="cmd_combat_auto_fight"]')
        if check_exists_by_xpath('//div[@id="out"]',  False) and check_exists_by_xpath('//td[@id="combat_xdz_text"]', False):
            qi = driver.find_element_by_id('combat_xdz_text').text
            idx = qi.index('/')
            qi = int(qi[:idx])
            text = driver.find_element_by_xpath('//div[@id="out"]').text[-600:]
            idx = 0
            if strOld != "":
                idx = text.rfind(strOld) + len(strOld) + 1
            strNew = text[idx:]
            if False and strNew != "":
                print("strNew:"+strNew)
            bpfm = False
            m = re.search(regex, strNew)
            if m != None:
                print(strNew[m.start():m.end()])
                m = re.search(regex_exclude, strNew)
                if m == None:
                    try: 
                        bpfm = True
                        driver.find_element_by_xpath('//span[text()="'+pfm+'"]').click()
                        print('pfm ok!')
                    except (TimeoutException,StaleElementReferenceException,WebDriverException,ElementNotVisibleException):
                        print('pfm failed!')
            if bpfm == False and qi > 4:
                try: 
                    now = datetime.datetime.now()
                    if   (now - pfm_buff_time).seconds > 60 and (now - pfm_dodge_time).seconds > 2:
                        pfm_buff_time = now
                        driver.find_element_by_xpath('//span[text()="'+pfm_buff+'"]').click()
                        print('buff ok')
                    elif (now - pfm_dodge_time).seconds > 60 and (now - pfm_buff_time).seconds > 2:
                        pfm_dodge_time = now
                        driver.find_element_by_xpath('//span[text()="乾坤大挪移"]').click()
                        print('dodge ok')
                except (TimeoutException,StaleElementReferenceException,WebDriverException,ElementNotVisibleException):
                    print('buff failed!')
            strOld = text[-300:]
        time.sleep(0.2)

buff_times = 0
def buff():
    global buff_times, timeEnd
    buff_times = 0
    while True:
        if datetime.datetime.now().time() > timeEnd:
            #time.sleep(1)
            if check_exists_by_xpath('//button[@class="cmd_change_line"]',  False):
                break
            if check_exists_by_xpath('//button[text()="确定"]'):
                continue
            if check_exists_by_xpath('//button[@class="cmd_out_map"]'):
                continue
            if check_exists_by_xpath('//button[@class="cmd_combat_byebye"]'): 
                continue
            if check_exists_by_xpath('//img[@class="prev"]'):
                continue
        else:
            buff1()

def buff1():
    global buff_times
    buff_times = buff_times + 1
    if buff_times  > 4:
        buff_times = 1
    if check_exists_by_xpath('//button[text()="确定"]'):
        return
    '''
    if check_exists_by_xpath('//button[@class="cmd_combat_byebye"]'): 
        return
    '''
    if check_exists_by_xpath('//img[@class="prev"]'):
        return
    if check_exists_by_xpath('//button[@class="cmd_change_line"]',  False):
        try:
            click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.CLASS_NAME, 'cmd_main_jh'))))
            click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.XPATH, '//button[text()="其他章节"]'))))
            click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.XPATH, '//span[text()="第一章"]'))))
            click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.XPATH, '//button[text()="进入关卡"]'))))
        except (TimeoutException,StaleElementReferenceException,WebDriverException,ElementNotVisibleException):
            return
    if not check_exists_by_xpath('//button[@class="cmd_combat_byebye"]', False):
        try:
            click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.XPATH, '//button[text()="店小二"]'))))
            click(WebDriverWait(driver, tc).until(EC.presence_of_element_located((By.XPATH, '//button[text()="比试"]'))))
        except (TimeoutException,StaleElementReferenceException,WebDriverException,ElementNotVisibleException):
            return
    try:
        if True:
            check_exists_by_xpath('//button[@class="cmd_combat_no_auto_fight"]')
        else:
            check_exists_by_xpath('//button[@class="cmd_combat_auto_fight"]')
            tc1 = 1
            if buff_times == 1:
                click(WebDriverWait(driver, tc1).until(EC.presence_of_element_located((By.XPATH, '//span[text()="混元一气功"]'))))
            if buff_times == 2:
                if id == 'take':
                    click(WebDriverWait(driver, tc1).until(EC.presence_of_element_located((By.XPATH,'//span[text()="葵花宝典"]'))))
                else:
                    click(WebDriverWait(driver, tc1).until(EC.presence_of_element_located((By.XPATH, '//span[text()="紫霞神功"]'))))
            if buff_times == 3:
                click(WebDriverWait(driver, tc1).until(EC.presence_of_element_located((By.XPATH, '//span[text()="天邪神功"]'))))
            if buff_times == 4:
                if id == 'take':
                    click(WebDriverWait(driver, tc1).until(EC.presence_of_element_located((By.XPATH, '//span[text()="如来神掌"]'))))
                else:
                    click(WebDriverWait(driver, tc1).until(EC.presence_of_element_located((By.XPATH,  '//span[text()="九天龙吟剑法"]'))))
            time.sleep(1)
    except (TimeoutException,StaleElementReferenceException,WebDriverException,ElementNotVisibleException):
        return

def killnpc(chapter, npc, path):
    global g_killnpc_count
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
    #while True:
    while g_killnpc_count < 20:
            clickIfExists(By.XPATH, '//button[text()="'+npc+'"]')
            clickIfExists(By.XPATH, '//button[text()="杀死"]')
            check_exists_by_xpath('//button[@class="cmd_combat_no_auto_fight"]')
            clickIfExists(By.XPATH, '//span[text()="'+pfm1+'"]')
            #clickIfExists(By.XPATH, '//span[text()="'+pfm2+'"]')
            if check_exists_by_xpath('//img[@class="prev"]', False):
                g_killnpc_count += 1
            clickIfExists(By.CLASS_NAME, 'prev')
            

def test():
    if check_exists_by_xpath('//button[text()="进入关卡"]'):
        return
    if check_exists_by_xpath('//button[text()="确定"]'):
        return
    if check_exists_by_xpath('//img[@class="prev"]'):
        return
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
ql_idx = 0
ql_path = ()
ql_npc = ''
ql_chapter = ''
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
    elif id == 'leid':
        url="http://sword-direct16.yytou.cn:8083/?id=3663136&time=1497125176527&key=d4298d92690d1ebf689d63b0acd4c6d6&s_line=1"
    elif id == 'qiu':
        url="http://sword-direct16.yytou.cn:8083/?key=291b252f34db634ed632158275270a7a&id=3473347&time=1500513686905&s_line=1"
    else:
        print('unknown user')
        sys.exit()
driver = webdriver.Chrome()        
driver.get(url)
g_killnpc_count = 0
while g_killnpc_count < 20:
    if task == 'zuihan':
        killnpc('第一章','醉汉',('e','n','n'))
    elif task == 'dipi':
        killnpc('第二章','地痞', ('n','n','n','n'))
    elif task == 'she':
        killnpc('第二章','青竹蛇', ('n','n','n','n','n','n','n','n','n','n','e'))
    elif task == 'qinglong':
        qinglong()
    elif task == 'key':
        key()
    elif task == 'ql':
        ql()
        time.sleep(2)
    elif task == 'idle':
        idle(5)
        #buff()
        #exp()
    elif task == 'test':
        test()
        time.sleep(2)
    elif task == 'fight':
        fight()
#driver.close()
