'''
Created on 2013-12-8

@author: Administrator
'''

class ErasingCharacters:
    def simulate2(self, s):
        i = 0
        old = None
        # while string changed:
        while s != old:
            old = s
            # increase i until we find a case to remove:
            for i in range(0, len(s) - 1):
                if s[i] == s[i + 1]:
                    s = s[0:i] + s[i + 2:]
                    break
        return s
    def simulate(self,s):
        s1 = ""
        for i in range(0,len(s)):
            if s[i:i+1] == s1[-1:]:
                s1 = s1[:-1]
            else:
                s1 += s[i:i+1] 
        return s1
         
if __name__ == '__main__':
    import time
    assert ErasingCharacters().simulate("cieeilll") == "cl"
    assert ErasingCharacters().simulate("topcoder") == "topcoder"
    assert ErasingCharacters().simulate("bacaabaccbaaccabbcabbacabcbba") == "bacbaca"
    assert ErasingCharacters().simulate("eel") == "l"
    t1 = time.time()
    s1 = "abcdefghijklmnopqrstuvwxyyxwvutsrqponmlkjihgfedcba"
    s = ""
    for i in range(1000):
        s += s1
    assert ErasingCharacters().simulate(s) == ""
    t2 = time.time()
    print "executed ts:" + str(t2-t1)
else:
    x = "abc"
    print x[:-1]
