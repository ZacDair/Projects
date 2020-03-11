from urllib.request import Request, urlopen
from bs4 import BeautifulSoup

# Data Source Url
url = 'https://www.worldometers.info/coronavirus/'

# Create a request using the url
req = Request(url)

# Add a header to prevent access issues
req.add_header('apikey', 'xxx')

# Open our url and read the contents into a variable
contents = urlopen(req).read()


# Function to get data based on pre-index and post-index
def getData(preIndex, postIndex, data):
    data = data.split(preIndex)
    data = data[1].split(postIndex)
    print(data[0])
    return data[0]


# Remove all html and script code from a string
def refineHtml(data):
    soup = BeautifulSoup(data, features="html.parser")

    # kill all script and style elements
    for script in soup(["script", "style"]):
        script.extract()  # rip it out

    # get text
    text = soup.get_text()

    # break into lines and remove leading and trailing space on each
    lines = (line.strip() for line in text.splitlines())
    # break multi-headlines into a line each
    chunks = (phrase.strip() for line in lines for phrase in line.split("  "))
    # drop blank lines
    text = '\n'.join(chunk for chunk in chunks if chunk)
    return text

# print("Source Code is:")
# print(contents)


# Set pre and post indexes to get the total count of cases
totalCountPreIndex = 'div class="maincounter-number"> <span style="color:#aaa">'
totalCountPostIndex = ' </span>'

# Use our function to display
print("Total Count:")
totalCount = getData(totalCountPreIndex, totalCountPostIndex, str(contents))

# Set pre and post indexes to get the death count
deathCountPreIndex = 'div class="maincounter-number"> <span>'
deathCountPostIndex = '</span>'

# Use our function to display
print("Death Count:")
deathCount = getData(deathCountPreIndex, deathCountPostIndex, str(contents))

# Set pre and post indexes to get the recovered count
recoveredCountPreIndex = '<div class="maincounter-number" style="color:#8ACA2B "> <span>'
recoveredCountPostIndex = '</span>'

# Use our function to display
print("Recovered Count:")
recoveredCount = getData(recoveredCountPreIndex, recoveredCountPostIndex, str(contents))

# Set pre and post indexes to get the recovered count
activeInfectedPreIndex = '<div class="number-table-main">'
activeInfectedPostIndex = '</div>'

# Use our function to display
print("Active Infection Cases:")
activeInfectedTotal = getData(activeInfectedPreIndex, activeInfectedPostIndex, str(contents))

# Set pre and post index to get the mild condition count
mildConditionPreIndex = '<span class="number-table" style="color:#8080FF">'
mildConditionPostIndex = '</span>'

# Use our function to display
print("Amount of Mild Cases:")
mildConditionCount = getData(mildConditionPreIndex, mildConditionPostIndex, str(contents))

# Set pre and post index to get the mild condition count
criticalConditionPreIndex = '<span class="number-table" style="color:red ">'
criticalConditionPostIndex = '</span>'

# Use our function to display
print("Amount of Critical Cases: ")
criticalConditionCount = getData(criticalConditionPreIndex, criticalConditionPostIndex, str(contents))

# Get the data from the countries table
tableDataPreIndex = '<tbody>'
tableDataPostIndex = '</tbody>'

# Use our functions get refine our data
tableData = getData(tableDataPreIndex, totalCountPostIndex, str(contents))

# Replace any missing values with ???
tableData = tableData.replace('<td style="font-weight: bold; text-align:right;"> </td>', "???\n")
tableData = tableData.replace('<td style="font-weight: bold; text-align:right"> </td>', "???\n")
tableData = tableData.replace('<td style="font-weight: bold; text-align:right"></td>', "???\n")

# Use function to clean html
refinedTable = refineHtml(tableData)

# List layout for each countries
# Country Name, Total Cases, New Cases, Total Deaths, New Deaths, Total Recovered, Active Cases, Serious Cases, tot
res = []
tableResults = refinedTable.split('\n')
index = 0
while index < len(tableResults):
    y = 0
    temp = []
    while y <= 8 and index < len(tableResults):
        temp.append(tableResults[index])
        index = index + 1
        y = y + 1
    res.append(temp)

for x in res:
    print(x)
