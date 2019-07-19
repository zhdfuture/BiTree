//蛇形矩阵是一个呈螺旋状的矩阵，它的数字由第一行开始，向右变大，向下变大，向左变大，向上变大
public class SnakePrint {
    public static int size = 0;
    private int value = -1;
    static int[][] array = null;
    enum Direction {
        Right, Down, Left, Up     //有4个方向，右->下->左->上
    }
    private Direction direction = null;
    private Direction detectDirection(int row, int col) {
        Direction direction1 = this.direction;
        switch (direction1) {
            case Right:
                if ((col == size - 1) || (array[row][col + 1] != 0)) {
                    direction1 = Direction.Down;
                }
                break;
            case Down:
                if ((row == size - 1) || (array[row + 1][col] != 0)) {
                    direction1 = Direction.Left;
                }
                break;
            case Left:
                if ((col == 0) || (array[row][col - 1] != 0)) {
                    direction1 = Direction.Up;
                }
                break;
            case Up:
                if (array[row - 1][col] != 0) {
                    direction1 = Direction.Right;
                }
                break;
        }
        return direction1;
    }
    public void ArrayCount() {     //计算数组
        int row = 0, col = 0;
        for (int i = 0; i < size * size; i++) {
            array[row][col] = value;
            direction = detectDirection(row, col);
            switch (direction) {
                case Right:
                    col++;
                    break;
                case Down:
                    row++;
                    break;
                case Left:
                    col--;
                    break;
                case Up:
                    row--;
                    break;
                default:
                    return ;
            }
            value++;
        }
    }

    public SnakePrint(int size) {
        if (size <= 0) {
            return;
        }
        this.size = size;
        this.array = new int[size][size];
        this.value = 1;
        direction = Direction.Right;
        ArrayCount();
    }
    public static void main(String[] args) {
        SnakePrint snakePrint=new SnakePrint(6);
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}

