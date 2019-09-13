# Author Zac Dair

import random, string

class Ai:

    def __init__(self, moves):
        self.memories = []
        self.oldMemories = []
        self.isGuide = False
        self.hasWon = False
        self.hasMutated = False
        i = 0
        while i < moves:
            self.memories.append("")
            i = i + 1
        self.score = 0

    def guessLetter(self, index):
        guess = random.choice(string.ascii_letters)
        self.memories[index] = str(guess).lower()

    def useMemories(self, index):
        guess = self.oldMemories[index]
        self.memories[index] = str(guess).lower()

    def caculatePerformance(self, goalWord):
        i = 0
        wordSize = len(goalWord)
        while i < wordSize:
            if self.memories[i] == goalWord[i]:
                self.score = self.score + 10
            i = i + 1
        if self.score == wordSize*10:
            self.hasWon = True

    def tryToMutate(self):
        randomNum = random.randint(0, 1)
        if randomNum == 1:
            self.hasMutated = True



def main():

    # Initialize Variables

    goalWord = "word"
    print("Word to guess is: ", goalWord)
    gen = 1
    maxGen = 1000
    populationSize = 10000
    moves = len(goalWord)
    bestAi = Ai(moves)
    foundWord = False

    while gen < maxGen and not foundWord:

        # Create Population
        population = []
        i = 0
        while i < populationSize:
            ai = Ai(moves)
            population.append(ai)
            if gen > 1:
                ai.oldMemories = bestAi.memories
            i = i + 1

        # Guess the goal
        if gen == 1:
            i = 0
            while i < moves:
                for x in population:
                    x.guessLetter(i)
                i = i + 1
        else:
            i = 0
            while i < moves:
                bestAiFound = False
                for x in population:
                    if not bestAiFound:
                        x.isGuide = True
                        bestAiFound = True
                    x.tryToMutate()
                    if not x.hasWon and not x.isGuide and x.hasMutated:
                        x.guessLetter(i)
                    else:
                        x.useMemories(i)
                i = i + 1

        # print results
        bestScore = bestAi.score
        for x in population:
            x.caculatePerformance(goalWord)
            if x.hasWon:
                x.score = x.score + 50
                foundWord = True
            if bestScore < x.score:
                bestScore = x.score
                bestAi = x
        print("Gen: ", gen, "Best Score: ", bestScore)
        print("Best guess is: ", bestAi.memories)

        gen = gen + 1


main()
