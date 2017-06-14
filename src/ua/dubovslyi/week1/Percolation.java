package ua.dubovslyi.week1;

/**
 * Created by yan.paykov on 08.06.2017.
 */
public class Percolation {

    private int[][] parent;
    private int count;
    private int n;

    public Percolation(int n) {
      this.n = n;
      this.parent = new int[n+1][n+1];

        for (int i =1;i<=n;i++){
            for (int y =1;y<=n;y++){
                parent[i][y] =-1;
            }
        }
    } // create n-by-n grid, with all sites blocked

    public   void open(int row, int col)  {
        parent[row][col]=0;
        count++;
    }  // open site (row, col) if it is not open already

    public void union(int row, int col){

    }

    public boolean isOpen(int row, int col) {
        return  parent[row][col] == 0;
    }

    public boolean isFull(int row, int col) {

        if(row ==1 && parent[row][col] == 0){
            parent[row][col] = 1;
            return true;
        }

        if(parent[row][col] == 0){

            if(col != n && parent[row][col+1] == 1 ){
                parent[row][col] = 1;
            }

            if(col != 1 && parent[row][col-1] == 1 ){
                parent[row][col] = 1;
            }

            if(row != 1 && parent[row-1][col] == 1 ){
                parent[row][col] = 1;
            }

            if(row != n && parent[row+1][col] == 1 ){
                parent[row][col] = 1;
            }

        }

        return parent[row][col] == 1;

    }  // is site (row, col) full?

    public     int numberOfOpenSites()  {
        return count;
    }     // number of open sites

    public boolean percolates()  {

        boolean firstRow = false;
        boolean lastRow = false;
        for (int column = 1; column<=n;column++){
            if(parent[1][column] == 1){
                firstRow = true;
                break;
            }
        }

        for (int column = 1; column<=n;column++){
            if(parent[n][column] == 1){
                lastRow = true;
                break;
            }
        }

        return firstRow && lastRow;

    }            // does the system percolate?

    public static void main(String[] args){
      Percolation percolation = new Percolation(1);
    }   // test client (optional)private int n;



}
