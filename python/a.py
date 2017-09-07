from tzlocal import get_localzone
from pytz import timezone
import datetime
local_tz = get_localzone()
print(local_tz)
def isDaytime(h):
    return h > 6 and h < 24;
print(isDaytime(5))


tz = timezone('Asia/Shanghai')
tz = timezone('America/Denver')
sa_time = datetime.datetime.now(tz)
print(sa_time.strftime('%Y-%m-%d_%H-%M-%S'))