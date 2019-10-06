import urllib.request
from datetime import date
import time
# Steam Date Format = Oct 03 2019
# Datetime Format = 2019-10-03

todayDate = (date.today())
url = "https://steamcommunity.com/market/listings/730/eSports%202014%20Summer%20Case"

# Get actual date and change it to the format Steam uses
def getCalenderDate(x):
    months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
    dateParts = str(x).split("-")
    month = months[int(dateParts[1])-1]
    yesterday= int(dateParts[2]) - 1
    if len(str(yesterday)) == 1:
        newDate = (month + " 0" + str(yesterday) + " " + dateParts[0])

    else:
        newDate = (month + " " + dateParts[2] + " " + dateParts[0])

    return newDate

# Get todays date, and run getCalenderDate, open our url, split content by date
date = getCalenderDate(todayDate)
with urllib.request.urlopen(url) as url:
    contents = url.read()
    res = (str(contents).split(str(date)))

# ignore first and last (index 0 and len(res)) as they don't contain price information
i = 1
prices = []
while i < len(res)-1:
    temp = (res[i].split(","))
    prices.append(temp[1])
    i = i + 1

# Get average price
avg = 0
for p in prices:
    avg = avg + float(p)
avg = avg / len(prices)

print("The average for " + date + " is " + str(round(avg, 3)) + "$")
time.sleep(5)
