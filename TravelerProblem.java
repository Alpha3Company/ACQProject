/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author gerard
 */
public class TravelerProblem {

    /**
     * @param args the command line arguments
     */
    public static IStrategy loadStrategy() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Select player1 Strategy:");
        System.out.println("1.- Simple Strategy");
        System.out.println("2.- Composed Strategy");
        String option = br.readLine();
        if (option.equals("1")) {
            System.out.println("1.- Random Strategy");
            System.out.println("2.- Fixed Strategy");
            System.out.println("3.- Brisk Strategy");
            System.out.println("4.- Ambitious Strategy");
            System.out.println("5.- Medium Intelligent Strategy");
            System.out.println("6.- LastRoll Intelligent Strategy");
            System.out.println("7.- Troll Strategy");
            int opt;
            while (true) {
                try {
                    opt = Integer.parseInt(br.readLine());
                    if (opt >= 1 && opt <= 7) {
                        break;
                    } else {
                        System.out.println("Introduce valid option");
                    }
                } catch (Exception e) {
                    System.out.println("Introduce valid option");
                }
            }
            switch (opt) {
                case 1:
                    return new RandomStrategy();
                case 2:
                    System.out.println("Insert the fix value");
                    while (true) {
                        try {
                            int value = Integer.parseInt(br.readLine());
                            return new FixedStrategy(value);
                        } catch (Exception e) {
                            System.out.println("Insert valid value");
                        }
                    }
                case 3:
                    return new BriskStrategy();
                case 4:
                    return new AmbitiousStrategy();
                case 5:
                    return new MediumIntelligentStrategy();
                case 6:
                    return new LastRollIntelligentStrategy();
                case 7:
                    return new TrollStrategy();
            }
        } else if (option.equals("2")) {
            System.out.println("Select composed strategy type:");
            System.out.println("1.- Mean Composed Strategy");
            System.out.println("2.- Max Composed Strategy");
            ComposedStrategy strategy;
            int opt;
            while (true) {
                try {
                    opt = Integer.parseInt(br.readLine());
                    if (opt >= 1 && opt <= 2) {
                        break;
                    } else {
                        System.out.println("Introduce valid option");
                    }
                } catch (Exception e) {
                    System.out.println("Introduce valid option");
                }
                /*Tractament de les excepcions, en tot el codi son de caire informatiu, no es fa
                res per intentar tractarla, i que l'usuari tingui una continuitat amb l'execucio 
                del programa*/
            }
            switch (opt) {
                case 1:
                    strategy = new MeanComposedStrategy();
                    break;
                case 2:
                    strategy = new MaximComposedStrategy();
                    break;
                default:
                    return null;
            }

            while (true) {
                System.out.println("Select a simple strategy to add:");
                System.out.println("1.- Random Strategy");
                System.out.println("2.- Fixed Strategy");
                System.out.println("3.- Brisk Strategy");
                System.out.println("4.- Ambitious Strategy");
                System.out.println("5.- Intelligent Strategy");
                System.out.println("6.- LastRoll Strategy");
                System.out.println("7.- Troll Strategy");
                System.out.println("8.- End Adding");
                while (true) {
                    try {
                        opt = Integer.parseInt(br.readLine());
                        if (opt >= 1 && opt <= 8) {
                            break;
                        } else {
                            System.out.println("Introduce valid option");
                        }
                    } catch (Exception e) {
                        System.out.println("Introduce valid option");
                    }
                }
                switch (opt) {
                    case 1:
                        strategy.addStrategy(new RandomStrategy());
                        break;
                    case 2:
                        System.out.println("Insert the fix value");
                        int value = Integer.parseInt(br.readLine());
                        strategy.addStrategy(new FixedStrategy(value));
                        break;
                    case 3:
                        strategy.addStrategy(new BriskStrategy());
                        break;
                    case 4:
                        strategy.addStrategy(new AmbitiousStrategy());
                        break;
                    case 5:
                        strategy.addStrategy(new MediumIntelligentStrategy());
                        break;
                    case 6:
                        strategy.addStrategy(new LastRollIntelligentStrategy());
                        break;
                    case 7:
                        strategy.addStrategy(new TrollStrategy());
                        break;
                    case 8:
                        return strategy;
                }
            }
        }
        return null;
    }

    public static void addObservers(Game.Builder b) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        while (true) {
            System.out.println("Select the observer to add");
            System.out.println("1.- Winner Observer");
            System.out.println("2.- Acumulated Observer");
            System.out.println("3.- Individual Roll Observer");
            System.out.println("4.- End Adding");
            int opt;
            while (true) {
                try {
                    opt = Integer.parseInt(br.readLine());
                    if (opt >= 1 && opt <= 4) {
                        break;
                    } else {
                        System.out.println("Introduce valid option");
                    }
                } catch (Exception e) {
                    System.out.println("Introduce valid option");
                }
            }
            switch (opt) {
                case 1:
                    b.addObserver(new WinnerObserver());
                    break;
                case 2:
                    b.addObserver(new AcumulatedObserver());
                    break;
                case 3:
                    b.addObserver(new IndividualRollObserver());
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void createPlayers(Game.Builder b) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            System.out.println("Enter player1 name:");
            String name = br.readLine();
            IStrategy strategy = loadStrategy();
            b.addPlayer(new NormalPlayerFactory(), strategy, name);
            System.out.println("Enter player2 name:");
            String name2 = br.readLine();
            IStrategy strategy2 = loadStrategy();
            b.addPlayer(new NormalPlayerFactory(), strategy2, name2);
        } catch (IOException ex) {
        }
    }

    public static void main(String[] args) {
        Game.Builder b = new Game.Builder();
        /*ComposedStrategy composta = new MeanComposedStrategy();
        composta.addStrategy(new FixedStrategy(50));
        //composta.addStrategy(new AmbitiousStrategy());
        composta.addStrategy(new RandomStrategy());
        Game joc = b.addPlayer(new NormalPlayerFactory(), composta, "Joan").addPlayer(new NormalPlayerFactory(), new MediumIntelligentStrategy(), "Ramon").setRolls(new NormalRollFactory(), 4).build();
        joc.addObserver(new IndividualRollObserver());
        joc.addObserver(new WinnerObserver());
        joc.play();*/

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Welcome to the game 'The Traveler Problem'");
        System.out.println("First, create the players");
        createPlayers(b);
        System.out.println("Second, set the rolls");
        System.out.println("Insert number of rolls");
        int opt;
        while (true) {
            try {
                opt = Integer.parseInt(br.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Introduce valid option");
            }
        }
        b.setRolls(new NormalRollFactory(), opt);
        System.out.println("Finally, add the observers");
        addObservers(b);
        Game joc = b.build();
        joc.play();

    }
}
