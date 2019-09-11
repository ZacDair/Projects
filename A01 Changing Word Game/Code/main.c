
//--------------------------------------------------
// INCLUDE LIBRARIES
//--------------------------------------------------
#include "word_game.h"

//-------------------------------------
//	APPLICATION MAIN ENTRY POINT: main
//-------------------------------------
int main() {
    //1. We select the current and target words we want to play with
    char current_word[NUM_LETTERS] = {'b', 'e', 'l', 'l'};
    char target_word[NUM_LETTERS] = {'c', 'o', 'a', 't'};

    //2. We perform the interactive session
    user_game_word(current_word, target_word);

    //4. We finish the program
    return 0;
}
