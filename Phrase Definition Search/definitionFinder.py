# Uses as json dataset of words and definitions
# Prints the definiton of the inputted word
# Along with the size of the dictonary and the time it took to find the word
# use phrase as command, split each word, search, print basic descrtiption of what was asked
import timeit
import json
from sys import getsizeof
start = timeit.default_timer()
with open("dictionary_compact.json", "r") as read_it:
    data = json.load(read_it)
command = input("Enter your command here: ")
commandWords = str(command).split(" ")
i = 0
meaning = ""
while i < len(commandWords):
    try:
        meaning = meaning + (str(data[commandWords[i]]))
    except:
        print("I don't understand ", commandWords[i])
    i = i + 1
stop = timeit.default_timer()
print("Time: ", stop-start)
print("The word list is: ", (getsizeof(data)/1024)/1024, "MB")
print("The meaning is: ", meaning)
