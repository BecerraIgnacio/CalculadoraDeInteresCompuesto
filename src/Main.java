import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Final = Inicial[1 + Interes/Tiempo]^Tiempo*Division
        double initialAmount;
        double interestAnual;
        int years;
        int monthlyInput;
        double interestMonth;
        double totalInterest;
        double totalContributed;
        double savings;

        Scanner scanner = new Scanner(System.in);


        // Ingreso de datos
        System.out.println("---CALCULADORA DE INTERES COMPUESTO---");
        System.out.print("Ingrese cantidad inicial: ");
        initialAmount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Ingrese interes anual (%): ");
        interestAnual = scanner.nextDouble() / 100;
        scanner.nextLine();
        System.out.print("Ingrese cantidad de años: ");
        years = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese aportes mensuales: ");
        monthlyInput = scanner.nextInt();
        scanner.nextLine();


        // Asignacion de variables para calculo
        totalContributed = initialAmount;
        totalInterest = 0;
        savings = initialAmount + totalInterest;
        interestMonth = Math.pow(1+interestAnual,1.0/12)-1; // interes por mes

        System.out.println("\n");

        // Crecimiento por año
        for(int i=0; i < years*12; i++){
            if(i%12==0){
                System.out.printf("Año: %d, Total contribuido: %.2f, Interes generado: %.2f, Total: %.2f\n",i/12, totalContributed,totalInterest,savings);
            }
            totalContributed = totalContributed + monthlyInput;
            savings = totalContributed + totalInterest;
            totalInterest = totalInterest+interestMonth*savings;
        }

        // Crecimiento total
        System.out.println("- - - - - - - - - - - - - - - -");
        System.out.printf("Año: %d, Total contribuido: %.2f, Interes generado: %.2f, Total: %.2f",years, totalContributed,totalInterest,savings);

        scanner.close();
    }
}