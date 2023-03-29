import java.util.*;

class Main {
  public static void main(String[] args) {
    char[][] board = new char[3][3];
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        board[row][col] = ' ';
      }
      System.out.println();
    }

    char player = 'X';
    boolean gameOver = false;
    int moves = 0;

    Scanner in = new Scanner(System.in);
    while (!gameOver) {
      gameBoard(board);
      System.out.print("player " + player + " enter : ");
      int row = in.nextInt();
      int col = in.nextInt();
      if (board[row][col] == ' ') {
        // then fill the space
        board[row][col] = player;
        moves++;
        gameOver = haveWon(board, player);
        if (gameOver) {
          System.out.println("player" + player + " has won ");

        }
          else if(moves==9){
            System.out.println("game ended in a tie!!");
            gameOver = true;
          }          
         
         
         
        else {
          // changing player value
          player = (player == 'X') ? '0' : 'X';
        }

      } else {
        System.out.println("Invalid move . Try again");
      }
    }
    System.out.println(board);

  }

  public static boolean haveWon(char[][] board, char player) {
    // check the rows here
    for (int row = 0; row < board.length; row++) {
      if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
        return true;
      }
    }
    // check the column here
    for (int col = 0; col < board.length; col++) {
      if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
        return true;
      }
    }

    // for diagonal
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
      return true;
    }
    if (board[0][2] == player && board[1][1] == player && board[2][1] == player) {
      return true;
    }

    return false;

  }

  

  public static void gameBoard(char[][] board) {
    // we will make a board here
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        System.out.print(board[row][col] + " | ");
      }
      System.out.println();
    }

  }
}