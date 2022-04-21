public class PascalTriangleRow {
    int[] triangle;

    PascalTriangleRow(int n) { //konstruktor

        triangle = new int[n + 1];
        triangle[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j > 0; j--)
                triangle[j] = triangle[j] + triangle[j - 1];
        }
    }

    public int index(int m) throws MyException {

        if(m < 0) throw new MyException();
        return triangle[m];
    }
}
