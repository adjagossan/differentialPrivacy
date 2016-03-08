package differentialprivacy;

import java.util.concurrent.ThreadLocalRandom;

public class Laplace
{
    public static final double[] quota = new double[]{1/4, 1/2, 1/4};
    /**
     * portion du budget consommée
     */
    private double consumedBudget = 0.0;
    /**
     * parametre de confidentialite
     */
    private double budget;
    /**
     * active ou desactive le mode TEST
     */
    private boolean TEST = false;

    public boolean isTEST() {
        return TEST;
    }

    public void setTEST(boolean TEST) {
        this.TEST = TEST;
    }
    /**
     * constructeur
     * @param budget 
     */
    public Laplace(double budget){
        this.budget = budget;
        this.TEST = true;
    }
    
    /**
    * genere une variable aleatoire suivant la distribution de Laplace
    *en fonction du paramètre de confidentialité, de la sensibilite de l'agregat
    *et de la proportion de budget à consommer pour l'appel courant
    */
    public double genNoise(int sensibility, double budgetPortion) throws BudgetException
    { 
        if(!this.TEST)
        {
            consumedBudget += budgetPortion;
            if(consumedBudget > this.budget)
                throw new BudgetException("budget entierement consommé");
        }
        double max = 0.5, min = -0.5;
        double b = (sensibility / this.budget);
        double U = ThreadLocalRandom.current().nextDouble(min, max);
        double mu = 0.0;
        return mu - (b*Math.signum(U)*Math.log(1-2*Math.abs(U)));  
    }
    /**
     * retourne le paramatre de confidentialite
     * @return 
     */
    public double getBudget() {
        return budget;
    }
    /**
     * modifie le parametre de confidentialite
     * @param budget 
     */
    public void setBudget(double budget) {
        this.budget = budget;
    }
}
