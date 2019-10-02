# Auto Comment System
# Adds a comment for Title, Author and Date Create to the top of any .py file where this file is used in
# path example C:\Users\zacda\PycharmProjects\untitled
# Extra Features:
#   Use cwd if no path given, or possibly ask the user for a path before runing
#   Accept more extensions that just .py (add what symbol is needed for other languages)
#   For safety make a copy of the file first, then add the comment, to the copy, if all goes through successfully,
#   move contents to original file and then delete the copy
# bug check if more than 3 lines (try and except quick fix preventing files with less than 3 lines being used)

import time
import os

# Preset as my own name
username = "Zac Dair"

# Set path to search
cwd = os.getcwd()
myPath = cwd
docsPath = os.path.join(myPath)

# If we find a folder run the program
if os.path.exists(docsPath):

    # Get folder contents
    os.chdir(docsPath)
    docsContents = os.listdir(docsPath)

    # Cycle through the contents
    i = 0
    while i < len(docsContents):

        # If its a python file open it get the first 3 lines of the file
        if docsContents[i].endswith("output.py"):
            try:
                with open(docsContents[i], "r+") as f:
                    head = [next(f) for x in range(3)]

                    # Check if the comment has already been added
                    if str(head[0]).__contains__("Title") and str(head[1]).__contains__("Author") \
                            and str(head[2]).__contains__("Date Created"):
                        print("Intro comment has already been added")

                    # If the comment isn't present add it
                    else:
                        # Add comment details
                        comments = []
                        comments.append("# Title: " + docsContents[i] + "\n")
                        comments.append("# Author: " + username + "\n")
                        pathToFile = os.path.join(docsPath, docsContents[i])
                        createdTime = time.ctime(os.path.getctime(pathToFile))
                        comments.append("# Date Created: " + createdTime + "\n")

                        # Save original contents
                        old = f.read()

                        # Construct head contents into string do the same for comments
                        commentString = ""
                        headString = ""
                        for comment in comments:
                            commentString = commentString + comment
                        for heading in head:
                            headString = headString + heading

                        # Select the start of the file and write the comments, the header, and the oringal contents
                        f.seek(0)
                        f.write(commentString + "\n" + headString + old)
                        print("Comment was added to " + docsContents[i])
            except:
                print("No comment was added to " + docsContents[i])
        i = i + 1
else:
    print("Sorry there is no folder at that path")

