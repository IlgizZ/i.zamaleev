package ru.kpfu.itis.group11408.zamaleev.class4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Ильгиз on 28.04.2015.
 */
public class Chease {
    private int n;
    private Cell start;
    private Cell finish;
    private char[][] a;

    private class Cell{
        private int x;
        private int y;
        private Cell parent;

        public Cell(int x, int y, Cell parent) {
            this.x = x;
            this.y = y;
            this.parent = parent;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Cell getParent() {
            return parent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Cell cell = (Cell) o;

            if (x != cell.x) return false;
            return y == cell.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return "(" + (y + 1) + "; " + (n - x) + ')';
        }
    }

    public Chease(int n, char[][] a) {
        this.n = n;
        this.a = new char[n][n];
        for (int i = 0; i < a.length; i++) {
            System.arraycopy(a[i], 0, this.a[i], 0, n);
        }
    }

    private void setStartFinish(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if (a[i][j] == '#'){
                    if (start == null){
                        start = new Cell(i, j, null);
                    } else {
                        finish = new Cell(i, j, null);
                    }
                    break;
                }
            }
        }
    }

    private void printWay(Cell cell){
        int length = 0;
        Cell c = cell;
        while (c != null){
            length++;
            c = c.getParent();
        }
        Cell[] cells = new Cell[length];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = cell;
            cell = cell.parent;
        }
        for (int i = cells.length - 1; i > 0 ; i--) {
            System.out.print(cells[i] + " --> ");
        }
        System.out.println(cells[0]);
    }

    private void bfs(Queue queue){
        if (queue.isEmpty()){
            System.out.println("Can't find any way.");
        } else {
            Cell cell = (Cell)queue.remove();
            if (cell.equals(finish)){
                printWay(cell);
                queue.clear();
            } else {
                int x = cell.getX();
                int y = cell.getY();
                if ((x + 2 < n) && (y + 1 < n) && (a[x + 2][y + 1] != '1')){
                    queue.add(new Cell(x + 2, y + 1, cell));
                    a[x + 2][y + 1] = '1';
                }
                if ((x + 2 < n) && (y - 1 >= 0) && (a[x + 2][y - 1] != '1')){
                    queue.add(new Cell(x + 2, y - 1, cell));
                    a[x + 2][y - 1] = '1';
                }
                if ((x - 2 >= 0) && (y - 1 >= 0) && (a[x - 2][y - 1] != '1')){
                    queue.add(new Cell(x - 2, y - 1, cell));
                    a[x - 2][y - 1] = '1';
                }
                if ((x - 2 >= 0) && (y + 1 < n) && (a[x - 2][y + 1] != '1')){
                    queue.add(new Cell(x - 2, y + 1, cell));
                    a[x - 2][y + 1] = '1';
                }
                if ((x - 1 >= 0) && (y + 2 < n) && (a[x - 1][y + 2] != '1')){
                    queue.add(new Cell(x - 1, y + 2, cell));
                    a[x - 1][y + 2] = '1';
                }
                if ((x + 1 < n) && (y + 2 < n) && (a[x + 1][y + 2] != '1')){
                    queue.add(new Cell(x + 1, y + 2, cell));
                    a[x + 1][y + 2] = '1';
                }
                if ((x + 1 < n) && (y - 2 >= 0) && (a[x + 1][y - 2] != '1')){
                    queue.add(new Cell(x + 1, y - 2, cell));
                    a[x + 1][y - 2] = '1';
                }
                if ((x - 1 >= 0) && (y - 2 >= 0) && (a[x - 1][y - 2] != '1')){
                    queue.add(new Cell(x - 1, y - 2, cell));
                    a[x - 1][y - 2] = '1';
                }
                bfs(queue);
            }
        }
    }

    public void findWay(){
        setStartFinish();
        Queue queue = new LinkedList();
        queue.add(start);
        bfs(queue);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(a[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
