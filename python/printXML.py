#!/bin/python
import string
import sys

class XMLHelper:
    def printXML(self,filename,linenumber,xmltag, linesbefore=30):
        try:
            f = open(filename, 'r')
            linenum = linenumber - linesbefore
            for _ in range(linenum):
                f.readline()
            begin = -1
            while True:
                linenum += 1
                line = f.readline()
                if begin > 0:
                    print line,
                if line == '':
                    break
                if string.strip(line) == '<'+xmltag+'>':
                    print line,
                    begin = linenum
                elif string.strip(line) == '</'+xmltag+'>':
                    end = linenum
                    break
            f.close
            print begin,end,
            return (begin,end)
        except IOError:
            print "can't open",filename
if __name__ == '__main__':
    if len(sys.argv) < 4:
        print 'usage:'+sys.argv[0]+' filename linenumber xmltag [linesbefore]'
        sys.exit()
    xmlhelper = XMLHelper()
    if len(sys.argv) == 5:
        xmlhelper.printXML(sys.argv[1],int(sys.argv[2]),sys.argv[3],int(sys.argv[4]))
    else:
        xmlhelper.printXML(sys.argv[1],int(sys.argv[2]),sys.argv[3])
    #assert(xmlhelper.printXML('log.txt', 20, 'TWTCePROOrder') == (3,49))
else:
    pass