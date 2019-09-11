A02 contains the spec for the minesweeper game, and the framework to use, and the launch instructions.
mine_ship_game.c contains my solution
As an additional task, I attempted to code a solution for the AI to play in the best possible way, instead of picking random cells.

This additional code is still in progress, using the basis that the AI will assume a mine is in each available space around an uncovered cell,
Following this it will calculate the probability there is a mine in each cell, by cycling through each probability and picking the one with the lowest value.
