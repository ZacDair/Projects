
//--------------------------------------------------
// INCLUDE LIBRARIES
//--------------------------------------------------
#include "word_game.h"

//--------------------------------------------------
// my_getchar
//--------------------------------------------------
char my_get_char() {
    //1. We create the output variable with the value the user has input by keyboard
    char res = getchar();

    //2. We discard any extra character the user has input by keyboard
    boolean finish = False;
    char dummy_char = ' ';

    while (finish == False) {
        dummy_char = getchar();
        if (dummy_char == '\n')
            finish = True;
    }

    //3. We return the output variable
    return res;
}

//--------------------------------------------------
// ask_for_new_command
//--------------------------------------------------
char ask_for_new_command() {
    //1. We create the output variable with an initial value
    char res = ' ';
    boolean valid = False;

    //2. While we have not received a valid command
    while(!valid) {
        //2.1 We ask the user for a new command
        printf("Possible commands are: <, >, a-z \nPlease enter your command: ");
        //2.2. We read the command entered by the user
        res = my_get_char();
        //2.3. We check if the command is correct
        if(res == '<'){
            valid = True;
        }
        else if(res == '>'){
            valid = True;
        }
        else if((res >= 'a' && res <= 'z') || (res >= 'A' && res <= 'Z')) {
            valid = True;
        }
        else{
            printf("Sorry try again\n\n");
        }
    }

    //3. We return the output variable
    return res;
}

//--------------------------------------------------
// process_movement
//--------------------------------------------------
void process_movement(char current_word[NUM_LETTERS], char** letter_ptr_ptr, int* num_movs_ptr, char command){
    //1. We process the different commands
        //1.1. If it is a '<'
        if(command == '<') {
            //1.1.1. If we are not in the left border
            if(current_word[0]!=**letter_ptr_ptr){
                //I. We move the pointer to the left
                (*letter_ptr_ptr) = (*letter_ptr_ptr) - 1;
                //II. We update the number of movements
                *num_movs_ptr = *num_movs_ptr+1;
            }
            else{
                printf("we are in left border\n");
                printf("%s\n",*letter_ptr_ptr);
            }
        }
        //1.2. If it is a '>'
        if(command == '>') {
            int i = 0;
            //1.2.1. If we are not in the right border
            if(*letter_ptr_ptr != &current_word[NUM_LETTERS-1]) {
                //I. We move the pointer to the right
                (*letter_ptr_ptr) = (*letter_ptr_ptr) + 1;
                //II. We update the number of movements
                (*num_movs_ptr) = (*num_movs_ptr) + 1;
            }
            else{
                printf("we are in right border\n");
            }
        }
        //1.3. If it is a letter
        if((command >= 'a' && command <= 'z') || (command >= 'A' && command <= 'Z')) {
            //1.3.1. If the letter is different from the current one
            if (command != **letter_ptr_ptr) {
                //I. We modify the letter
                **letter_ptr_ptr = command;
                //II. We update the number of movements
                *num_movs_ptr = *num_movs_ptr+1;
            }
        }
}

//--------------------------------------------------
// print_status
//--------------------------------------------------
void print_status(char current_word[NUM_LETTERS], char target_word[NUM_LETTERS], char* letter_ptr, int num_movs) {
    //1. We clean the screen
    int i = 0;
    int count = 0;
    while(i<=10){
        printf("\n\n\n\n\n\n\n\n\n\n"); //10 newlines running 10 times, creating 100 blank lines
        i++;
    }
    //2. We print the status
    printf("-----Game Status-----\n");
    //3. We print the target word
    i = 0;
    printf("Target Word is: ");
    while(i<NUM_LETTERS){
        printf("%c",target_word[i]);
        if(current_word[i]==target_word[i]){
            count++;
        }
        i++;
    }
    //4. We print the current word
    i = 0;
    printf("\nCurrent Word is:\n");
    while(i<NUM_LETTERS){
        printf("%c",current_word[i]);
        i++;
    }
    //5. We print the underscore associated to the pointer
    i = 0;
    long pos = letter_ptr - &current_word[0];
    printf("\n");
    while (i<pos) {
        printf(" ");
        i++;
    }
    printf("_\n");

    //6. We print the number_of_movements
    printf("Number of moves: %d\n",num_movs);
    //7. We print a last line
    //Extra print the amount of letters that are right
    printf("You have %d letters right out of %d.\n",count,NUM_LETTERS);
    printf("---------------------\n");

}

//--------------------------------------------------
// is_game_over
//--------------------------------------------------
int is_game_over(char current_word[NUM_LETTERS], char target_word[NUM_LETTERS], int num_movs, int max_movs) {
    //1. We create the output variable with an initial value.
    int res = 0;
    //2. Game is over if current_word matches target_word

    	//2.1. By default we assume current_word and target_word are equal
        boolean equal = True;

    	// 2.2. We traverse them to check if they are actually equal
        int i =0;
        while (i<NUM_LETTERS){
            if(current_word[i] != target_word[i]){
                equal = False;
            }
            i++;
        }

    	//2.3. In case they are equal we set the end of the game
    	if(equal){
    	    res = 1;
    	}

    // 3. Game is over as we have done the max number of movements being allowed
    if(num_movs == max_movs){
        res = -1;
    }

    //4. We return the output variable
    return res;
}


//--------------------------------------------------
// user_game_word
//--------------------------------------------------
void user_game_word(char current_word[NUM_LETTERS], char target_word[NUM_LETTERS]) {
    //1. We initialise the pointer to the first position of the array
    char *pCurrentWord = &current_word[0]; //set pointer to the first value of the array
    char *pTargetWord = &target_word[0];
    char *pLetterPointer = pCurrentWord;

    //2. We initialise the num_mov and max_moves
    int numMove = 0;
    int *pNumMove = &numMove; //set pointer to numMove
    int maxMoves = 8;
    int gameStatus = 0;

    //3. We initialise the game to not to be over
    boolean gameOver = False;

    //4. We print the initial status of the game
    printf("Welcome To the Game\nGet from the current word to the target using the commands: <, >, a-z\nWithout going over %d moves\n",maxMoves);
    printf("\nCurrent word is: ");
    int i = 0;
    while (i<NUM_LETTERS){
        printf("%c",current_word[i]);
        i++;
    }
    i = 0;
    printf("\nTarget word is: ");
    while (i<NUM_LETTERS){
        printf("%c",target_word[i]);
        i++;
    }
    printf("\n\n");
    //5. We perform the main loop
    while(!gameOver) {
        //5.1. We ask for a new command
        char command = ask_for_new_command();
        //5.2. We process the command
        process_movement(pCurrentWord,&pLetterPointer,pNumMove,command);

        // 5.3. We print the current status
        print_status(pCurrentWord,pTargetWord,pLetterPointer,numMove);

        //5.4. We determine if the game is over
         gameStatus = is_game_over(pCurrentWord,pTargetWord,numMove,maxMoves);
        if(gameStatus == -1 || gameStatus == 1){
            gameOver = True;
        }
    }
    //6. Once the game is finished, we display the outcome of it
    if(gameStatus == 1){
        printf("Congratulations You won !!!\n");
    }
    else{
        printf("Game over, Sorry you lost !!!\n");
    }
    printf("You used %d moves out of %d moves\n",numMove,maxMoves);

    // Allow player to play again - EXTRA
    printf("Would you like to play again ? [y/n]");
    boolean valid = False;
    while(!valid) {
        char input = my_get_char();
        if (input == 'y' || input == 'Y') {
            valid = True;
            //Use generateNewTarget(*pTargetWord,otherWords[NUM_LETTERS],posInOtherWords) here
            user_game_word(pCurrentWord,target_word);

        } else if (input == 'n' || input == 'N') {
            valid = True;
        }
        else {
            printf("y to play again, n to quit");
        }
    }

}

/*
 * Extra Function to cycle through a list of words, changing the target to a new word in that list
int generateNewTarget(char target_word[NUM_LETTERS], char otherWords[NUM_LETTERS], int pos){
    int i = 0;
    while(i<NUM_LETTERS){
        target_word[i] = otherWords[i];
        i++;
    }
    int posInOtherWords = pos;
    posInOtherWords = posInOtherWords+i;
    return posInOtherWords;
}
 */
