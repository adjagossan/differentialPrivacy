package differentialprivacy;

public class Scenario{
    /**
     * Question 5 du TP: Testez genNoise sur un COUNT calculé sur un tableau d'entiers
     * en affichant la valeur non pertubée, la pertubation générée et la valeur pertubée
     * pour différentes valeurs du parametre de confidentialité (epsilon) et la taille
     * du tableau d'entiers (n)
     * @throws BudgetException 
     */
    public static void question5() throws BudgetException
    {
        System.out.println("\n************ QUESTION 5 *************************\n");
        int maxValue = 10;
        int sizeOne = 5;
        /**
         * sensibilité d'un COUNT
         */
        int sensibility = 1;
        double quota = Laplace.quota[0];
        
        DataHelper firstD = new DataHelper(maxValue, sizeOne);
        firstD.generate();
        int noDisruptedValue = firstD.COUNT();
        
        double epsilonOne = 0.01;
        Laplace laplaceOne = new Laplace(epsilonOne);
        double noiseOne = laplaceOne.genNoise(sensibility, quota*epsilonOne);
        double disruptedValueOne = noDisruptedValue + noiseOne;
        
        System.out.println("Pour le tableau ci-dessus de taille: "+sizeOne+"\nvaleur non pertubée = "+noDisruptedValue+
                "\nPour epsilon = "+epsilonOne+
                "\npertubation generee = "+noiseOne+
                " valeur pertubée = "+disruptedValueOne+"\n");
        
        double epsilonTwo = 0.1;
        Laplace laplaceTwo = new Laplace(epsilonTwo);
        double noiseTwo = laplaceTwo.genNoise(sensibility, quota*epsilonTwo);
        double disruptedValueTwo = noDisruptedValue + noiseTwo;
        System.out.println("Pour epsilon = "+epsilonTwo+
                "\npertubation generee = "+noiseTwo+
                " valeur pertubée = "+disruptedValueTwo+"\n");
        
        int sizeTwo = 10;
        DataHelper secondD = new DataHelper(maxValue, sizeTwo);
        secondD.generate();
        int noDisruptedValueTwo = secondD.COUNT();
        
        
        Laplace laplaceThree = new Laplace(epsilonOne);
        double noiseThree = laplaceThree.genNoise(sensibility, quota*epsilonOne);
        double disruptedValueThree = noDisruptedValueTwo + noiseThree;
        
        System.out.println("Pour un tableau ci-dessus de taille: "+sizeTwo+"\nvaleur non pertubée = "+noDisruptedValueTwo+"\nPour epsilon = "+epsilonOne+
                "\npertubation generee = "+noiseThree+
                " valeur pertubée = "+disruptedValueThree+"\n");
        
        Laplace laplaceFour = new Laplace(epsilonTwo);
        double noiseFour = laplaceFour.genNoise(sensibility, quota*epsilonTwo);
        double disruptedValueFour = noDisruptedValueTwo + noiseFour;
        System.out.println("Pour epsilon = "+epsilonTwo+
                "\npertubation generee = "+noiseFour+""
                +" valeur pertubée = "+disruptedValueFour+"\n");
        
    }
    
    public static void question6()
    {
        int n = (int) Math.pow(10, 3);
        int maxValue = 10;
        double epsilon = Math.pow(10, -4);
        DataHelper data = new DataHelper(maxValue, n);
        data.generate();
    }
    
    public static void question7() throws BudgetException
    {
        System.out.println("\n************ QUESTION 7 *************************\n");
        //Taille du tableau
        int n = (int) Math.pow(10, 3);
        //Parametre de confidentialite
        double epsilon = Math.pow(10, -4);
        //valeur maximale que peut prendre chaque element du tableau
        int m = (int) Math.pow(10, 3);
        //Nombre de pertubations
        int number_of_disruption = (int) Math.pow(10, 3);
        //sensibilite de l'agreggat de type SUM
        int sensibility = m;
        //somme des pertubations
        double amount_of_disruption_error = 0;
        Laplace laplace = new Laplace(epsilon);
        for(int i = 0; i<number_of_disruption; i++)
            amount_of_disruption_error += Math.abs(laplace.genNoise(sensibility, epsilon));
        
        System.out.println("Moyenne des erreurs pour un agregat de type SUM: "+amount_of_disruption_error/number_of_disruption);   
    }
    
    public static void question10() throws BudgetException{
        System.out.println("\n************ QUESTION 10 *************************\n");
        
        int maxValue = (int) Math.pow(10, 3);
        //Nombre de pertubations
        int number_of_disruption = (int) Math.pow(10, 3);
        //sensibilite de l'agreggat de type SUM
        int sensibility = 0;
        //somme des pertubations
        double amount_of_disruption_error = 0;
        //differentes tailles de tableaux
        int[] sizes = new int[]{100, 1000, 10000, 100000, 1000000};
        DataHelper data1 = new DataHelper(maxValue, sizes[0]);
        data1.generate();
        DataHelper data2 = new DataHelper(maxValue, sizes[1]);
        data2.generate();
        DataHelper data3 = new DataHelper(maxValue, sizes[2]);
        data3.generate();
        DataHelper data4 = new DataHelper(maxValue, sizes[3]);
        data4.generate();
        DataHelper data5 = new DataHelper(maxValue, sizes[4]);
        data5.generate();
        int[] noDisruptedValues = new int[]{data1.SUM(), data2.SUM(), data3.SUM(), data4.SUM(), data5.SUM(),};
        //Parametre de confidentialite
        double epsilon = Math.pow(10, -4);
        Laplace laplace = new Laplace(epsilon);
        for(int j=0; j<sizes.length; j++)
        {
            sensibility = sizes[j];
            for(int i = 0; i<number_of_disruption; i++)
                amount_of_disruption_error += Math.abs(laplace.genNoise(sensibility, epsilon));
            System.out.println("Pour le tableau de taille: "+sizes[j]+
                    "\nMoyenne des erreurs = "+amount_of_disruption_error/number_of_disruption+
                    "\nRatio = "+(amount_of_disruption_error/number_of_disruption)/noDisruptedValues[j]+"\n");
        }
    }
}
