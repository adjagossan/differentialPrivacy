package differentialprivacy;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LaunchMe {

    public static void main(String[] args) {

        //if (args.length == 3) {
            /*
             * taille du tableau
             */
        //    int n = Integer.parseInt(args[0]);
            /*
             * valeur maximale que pourra prendre chaque element du tableau
             *(la valeur minimale etant fixée à 0)
             */
        //    int maxValue = Integer.parseInt(args[1]);
            /*
             * parametre de confidentialite
             */
        //    double epsilon = Double.parseDouble(args[2]);
            /**
             * sensibility
             */
        //    int sensibility = 1;
            
            try
            {
                Scenario.question5();
                //Scenario.question6();
                Scenario.question7();
                Scenario.question10();
            } catch(BudgetException ex){
                Logger.getLogger(LaunchMe.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        //}

    }

}
