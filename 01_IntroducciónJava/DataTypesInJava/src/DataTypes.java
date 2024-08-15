public class DataTypes {
    public static void main(String[] args) {

        byte nB = 127;
        short nS = 12345;
        int n = 1234567890;
        long nL = 12345678901L; // Write "L" at the end of the number
        float nF = 123456789012345678901234567890123456789F;
        double nD = 123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789D;

        System.out.println(nB);
        System.out.println(nS);
        System.out.println(n);
        System.out.println(nL);
        System.out.println(nF);
        System.out.println(nD);

        var salary = 1000;
        var pension = salary * 0.03;
        var totalSalary = salary - pension;
        var employeeName = "John Doe";

        System.out.println(salary);
        System.out.println(pension);
        System.out.println("EMPLOYEE: " + employeeName + " SALARY: " + totalSalary);

    }
}
