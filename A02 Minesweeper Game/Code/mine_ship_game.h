
//------------------------------------
//	Define 
//------------------------------------
#ifndef _GAME_
#define _GAME_

#define _CRT_SECURE_NO_WARNINGS

//------------------------------------
//	Include Libraries 
//------------------------------------
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//------------------------------------
//	Datatype bool
//------------------------------------
enum Bool { False, True };
typedef enum Bool boolean;

//------------------------------------
//	Datatype board_cell
//------------------------------------
struct _board_cell {
	int value;
	boolean visible;
};

typedef struct _board_cell board_cell;

//------------------------------------
//	Datatype game
//------------------------------------
struct _game {
	int mode;
	int status;
	int num_mines;
	int board_size;
	char* p1_name;
	char* p2_name;
	int p1_mines_uncovered;
	int p2_mines_uncovered;
	board_cell** p1_board;
	board_cell** p2_board;
};

typedef struct _game game;

//------------------------------------
// 01. FUNCTION create_new_game
//------------------------------------
game* create_new_game(char* p1, char* p2, int board_size, int num_mines);

//------------------------------------
// 02. gen_num
//------------------------------------
int gen_num(int lb, int ub);

//-------------------------
// 03. FUNCTION my_getchar
//-------------------------
char my_get_char();

//-------------------------------------
// 04. FUNCTION place_mines_on_board
//-------------------------------------
void place_mines_on_board(board_cell** board, int board_size, int num_mines);

//-------------------------------------
// 05. FUNCTION display_board_content
//-------------------------------------
void display_board_content(board_cell** board, int board_size, int mines_uncovered);

//---------------------------------------
// 06. FUNCTION user_get_movement_index
//---------------------------------------
int user_get_movement_index(int status,
							int board_size,
							board_cell** p1_board,
							board_cell** p2_board);

//------------------------------------------
// 07. FUNCTION computer_get_movement_index
//------------------------------------------
int computer_get_movement_index(int status,
								int board_size,
								board_cell** p1_board,
								board_cell** p2_board);

//--------------------------------------
// 08. FUNCTION get_next_movement_index
//--------------------------------------
int get_next_movement_index(int status,
							char* p1_name,
							char* p2_name,
							int board_size,
							board_cell** p1_board,
							board_cell** p2_board);

//------------------------------------
// 09. FUNCTION process_movement
//------------------------------------
void process_movement(int position_to_uncover,
		              int* status,
		              int board_size,
		              board_cell** p1_board,
		              board_cell** p2_board,
		              int* p1_mines_uncovered,
		              int* p2_mines_uncovered);

//------------------------------------
// 10. FUNCTION play_game
//------------------------------------
void play_game(char* p1, char* p2, int board_size, int percentage_mines);

//------------------------------------
//	End of file 
//------------------------------------
#endif

















