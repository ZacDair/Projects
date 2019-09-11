
#ifndef A01_WORD_GAME_H
#define A01_WORD_GAME_H

//--------------------------------------------------
// INCLUDE LIBRARIES
//--------------------------------------------------
#include <stdio.h>

//--------------------------------------------------
// DATA TYPES DEFINITIONS
//--------------------------------------------------
enum Bool { False, True };
typedef enum Bool boolean;

//--------------------------------------------------
// CONSTANTS
//--------------------------------------------------
#define NUM_LETTERS 4

//--------------------------------------------------
//
// FUNCTIONS
//
//--------------------------------------------------

//--------------------------------------------------
// my_getchar
//--------------------------------------------------
char my_get_char();

//--------------------------------------------------
// ask_for_new_command
//--------------------------------------------------
char ask_for_new_command();

//--------------------------------------------------
// process_movement
//--------------------------------------------------
void process_movement(char current_word[NUM_LETTERS], char** letter_ptr_ptr, int* num_movs_ptr, char command);

//--------------------------------------------------
// print_status
//--------------------------------------------------
void print_status(char current_word[NUM_LETTERS], char target_word[NUM_LETTERS], char* letter_ptr, int num_movs);

//--------------------------------------------------
// is_game_over
//--------------------------------------------------
int is_game_over(char current_word[NUM_LETTERS], char target_word[NUM_LETTERS], int num_movs, int max_movs);

//--------------------------------------------------
// user_game_palindrome
//--------------------------------------------------
void user_game_word(char current_word[NUM_LETTERS], char target_word[NUM_LETTERS]);


#endif //A01_WORD_GAME_H
