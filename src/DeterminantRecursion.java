import java.util.Arrays;
import java.util.Scanner;
public class DeterminantRecursion {
    public static int det(int[][] list){
        int result = 0;

        if(list.length == 2){
            result = list[0][0] * list[1][1] - list[0][1] * list[1][0];
            return result;
        }else{
            int[][] matrix = new int[list.length-1][list.length-1];
            String matrixAdd = "";
            int one = 1;
            int counter = 0;
            for (int i = 0; i < list.length; i++) {
                for (int j = 1; j < list.length; j++) {
                    for (int k = 0; k < list.length; k++) {
                        if(k != i){
                            matrixAdd += String.valueOf(list[j][k]) + " ";
                        }
                    }
                    matrix[counter] = Arrays.stream(matrixAdd.trim().split(" ")).mapToInt(Integer::parseInt).toArray();
                    matrixAdd = "";
                    counter++;
                }
                result += one * list[0][i] * det(matrix);
                one *= -1;
                counter = 0;
            }
            return result;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int matrixLines = Integer.parseInt(in.nextLine());
        int[][] matrix = new int[matrixLines][matrixLines];
        for (int i = 0; i < matrixLines; i++) {
            for (int j = 0; j < matrixLines; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        System.out.println(det(matrix));
    }
}






