gcc -c -o main.o main.c  
gcc -c -o word_game.o word_game.c
gcc -o main_exec main.o word_game.o
