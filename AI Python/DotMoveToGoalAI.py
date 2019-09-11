# Author Zac Dair

from graphics import *
import random


class Brain:

    def __init__(self, moves):
        self.moves = moves
        self.isBest = False
        self.isDead = False
        self.score = 0
        self.hasWon = False

    def caculateScore(self, goalX, goalY, icon, movesUsed):
        center = icon.getCenter()
        myX = center.getX()
        myY = center.getY()
        distanceX = goalX - myX
        distanceY = goalY - myY
        self.score = distanceX + distanceY + (movesUsed*2)
        if self.isDead:
            self.score = self.score + 2000
        return self.score


class Dot:

    def __init__(self, brain):
        self.brain = brain
        self.memories = []
        self.oldMemories = []
        self.icon = Circle(Point(100, 100), 5)
        self.isMutated = False
        self.isGuide = False

    def randomMove(self):
        x = random.randint(-10, 10)
        y = random.randint(-10, 10)
        self.icon.move(x, y)
        self.checkLocation()
        self.memories.append((x, y))

    def checkLocation(self):
        location = self.icon.getCenter()
        x = location.getX()
        y = location.getY()
        if x >= 500:
            self.brain.isDead = True
        if y >= 500:
            self.brain.isDead = True
        if x <= 0:
            self.brain.isDead = True
        if y <= 0:
            self.brain.isDead = True
        if 445 <= x <= 455 and 445 <= y <= 455:
            self.brain.hasWon = True

    def draw(self, win):
        self.icon.draw(win)

    def delete(self):
        self.icon.undraw()

    def move(self, index):
        coords = self.oldMemories[index]
        coordList = str(coords).split(",")
        x = coordList[0].replace("(", "")
        y = coordList[1].replace(")", "")
        self.icon.move(float(x), float(y))
        self.checkLocation()
        self.memories.append((float(x), float(y)))

    def tryToMutate(self):
        randNum = random.randint(0, 100)
        if randNum == 1:
            self.isMutated = True

    def changeColor(self, color):
        self.icon.setFill(color)


def main():

    win = GraphWin("AI", 500, 500)
    maxGen = 10000
    moves = 50
    populationSize = 100
    gen = 1
    bestDot = Dot(Brain(1000))
    bestDot.brain.score = 100000
    while gen <= maxGen:

        # ------------------------------------------------------------------------------------------------------------------
        #  Set Goal
        # ------------------------------------------------------------------------------------------------------------------

        goal = Circle(Point(450, 450), 10)
        goal.setFill("Red")
        goal.draw(win)
        strGen = ("Gen: ", gen)
        genText = Text(Point(400, 10), strGen)
        genText.draw(win)

        # ------------------------------------------------------------------------------------------------------------------
        #  Create Population
        # ------------------------------------------------------------------------------------------------------------------

        i = 0
        population = []
        while i < populationSize:
            brain = Brain(1000)
            dot = Dot(brain)
            population.append(dot)
            if gen > 1:
                dot.oldMemories = bestDot.memories
            dot.draw(win)
            i = i + 1
        # ------------------------------------------------------------------------------------------------------------------
        #  Move population
        # ------------------------------------------------------------------------------------------------------------------

        i = 0
        if gen == 1:
            while i < moves:
                for dot in population:
                    if not dot.brain.isDead and not dot.brain.hasWon:
                        dot.randomMove()
                i = i + 1
        else:
            while i < moves:
                counter = 0
                for dot in population:
                    if counter == 0:
                        dot.isGuide = True
                        dot.icon.setFill("Blue")
                    if not dot.brain.isDead and not dot.brain.hasWon:
                        dot.tryToMutate()
                        if dot.isMutated and not dot.isGuide:
                            dot.randomMove()
                        else:
                            dot.move(i)
                    counter = counter + 1
                i = i + 1
        # ------------------------------------------------------------------------------------------------------------------
        # Cloning
        # ------------------------------------------------------------------------------------------------------------------
        #
        # newBrain = Brain(1000)
        # newDot = Dot(newBrain)
        # newDot.changeColor("Green")
        # newDot.draw(win)
        # newDot.memories = population[0].memories
        # lengthOfMems = len(newDot.memories)
        # i = 0
        # while i < lengthOfMems:
        #    coords = newDot.memories[i]
        #    coordList = str(coords).split(",")
        #    x = coordList[0].replace("(", "")
        #    y = coordList[1].replace(")", "")
        #    newDot.move(float(x), float(y))
        #    i = i + 1

        # ------------------------------------------------------------------------------------------------------------------
        # Show Best
        # ------------------------------------------------------------------------------------------------------------------

        bestScore = 100000
        for x in population:
            score = x.brain.caculateScore(450, 450, x.icon, len(x.memories))
            if score < bestScore:
                bestScore = score
                bestDot = x
        print("Gen: ", gen, "Best Score: ", bestScore, "\n")
        bestDot.brain.isBest = True
        for x in population:
            if x.brain.isBest:
                x.changeColor("Blue")
            else:
                x.delete()

        gen = gen + 1
        genText.undraw()
        bestDot.delete()

    win.getMouse()  # Pause to view result
    win.close()    # Close window when done


main()
