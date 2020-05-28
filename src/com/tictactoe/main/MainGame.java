package com.tictactoe.main;

/**
 * @author Dhaval
 * May 28, 2020
 */
public class MainGame {
	private char[][] board;
	private char currentPlayer;

	public MainGame() {
		board = new char[3][3];
		currentPlayer = 'x';
		initializeBoard();
	}

	// Gives us access to currentPlayerMark
	public char getCurrentPlayer() {
		return currentPlayer;
	}

	// Set/Reset the board back to all empty values.
	public void initializeBoard() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
	}

	// Print the current board
	public void printBoard() {
		System.out.println("-------");
		for (int i = 0; i < 3; i++) {
			System.out.print("|");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + "|");
			}
			System.out.println();
			System.out.println("-------");
		}
	}

	// Loop through all cells of the board and if one is found to be empty (contains
	// char '-') then return false.
	// Otherwise the board is full.
	public boolean isBoardFull() {
		boolean isFull = true;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '-') {
					isFull = false;
				}
			}
		}

		return isFull;
	}

	public boolean isWinner() {
		return (checkRows() || checkColumns() || checkDiagonals());
	}

	private boolean checkRows() {
		for (int i = 0; i < 3; i++) {
			if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
				return true;
			}
		}
		return false;
	}

	private boolean checkColumns() {
		for (int i = 0; i < 3; i++) {
			if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
				return true;
			}
		}
		return false;
	}

	private boolean checkDiagonals() {
		return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true)
				|| (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
	}

	private boolean checkRowCol(char c1, char c2, char c3) {
		return ((c1 != '-') && (c1 == c2) && (c2 == c3));
	}

	public void changePlayer() {
		if (currentPlayer == 'x') {
			currentPlayer = 'o';
		} else {
			currentPlayer = 'x';
		}
	}

	public boolean placeMark(int row, int col) {
		// Make sure that row and column are in bounds of the board.
		if ((row >= 0) && (row < 3)) {
			if ((col >= 0) && (col < 3)) {
				if (board[row][col] == '-') {
					board[row][col] = currentPlayer;
					return true;
				}
			}
		}

		return false;
	}
}