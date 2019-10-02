# Google Search Tool
# Author: Zachary Dair
# Date: 29/09/19
from googlesearch import search

# Initialise Variables
isValid = False
topLevelDomain = "com"
lang = "en"
amount = "10"
start = 0
stop = "None"
editSettings = False

# Ask to edit search options - error check answers
while not isValid:
    edit = input("Do you want to edit the search settings (y/n): ")
    if edit == "y" or edit == "Y":
        isValid = True
        editSettings = True
    elif edit == "n" or edit == "N":
        editSettings = False
        isValid = True
    else:
        print("Sorry, please try again")

# If we are asked to edit settings print the list and let the user choose an option
# Set settings based on users inputs -  basic error checking (missing still for amount)
if editSettings:
    print("Which would you like to edit: ")
    print("1. Top Level Domain" + "\n" + "2. Language" + "\n" + "3. Amount of results")
    isValid = False
    while not isValid:
        choice = input("What setting do you want to edit (1,2,3): ")
        if choice == 1:
            topLevelDomain = input("Enter the Top Level Domain you wish to use (com for .com websites): ")
            isValid = True
        elif choice == 2:
            lang = input("Enter the language to search in (en for english): ")
            isValid = True

        elif choice == 3:
            amount = input("Enter the amount of results you wish to show: ")
            isValid = True

        else:
            print("Sorry, please try again")

# Take the users query
query = input("Enter your search query here: ")

# Search based on googlesearch tool, using the settings either preset or user defined
# Print each result and count them
count = 0
for result in search(query, topLevelDomain, lang, amount, stop, 2):
    count = count + 1
    print(result)
if count == 0:
    print("Sorry no results were found")
else:
    print("We found" + str(count) + " results")
