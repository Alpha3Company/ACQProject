/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelerproblem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author gerard
 */
class NotEnoughtPlayersToPlay extends RuntimeException {
}

class AnyRollToPlay extends RuntimeException {
}

public class Game {

    private static Collection<Player> player_list;
    private static Collection<Roll> rolls_list;
    private static Collection<Observer> observers;

    public static class Builder {

        private Collection<Player> player_list;
        private Collection<Roll> rolls_list;
        private Collection<Observer> observers;

        public Builder() {
            player_list = new ArrayList();
            rolls_list = new ArrayList();
            observers = new ArrayList();
        }

        /**
         *
         * @param factory_player the factory of players
         * @param strategy the strategy to be used
         * @param name the name of the player
         * @return this
         */
        public Builder addPlayer(IPlayerFactory factory_player, IStrategy strategy, String name) {
            player_list.add(factory_player.createNormalPlayer(name, strategy));
            return this;
        }

        /**
         *
         * @param factory_roll the roll factory
         * @param nrolls number of rolls
         * @return this
         */
        public Builder setRolls(IRollFactory factory_roll, int nrolls) {
            for (int i = 0; i < nrolls; i++) {
                rolls_list.add(factory_roll.createNormalRoll());
            }
            return this;
        }

        /**
         *
         * @param o the observer to add
         * @return this
         */
        public Builder addObserver(Observer o) {
            observers.add(o);
            return this;
        }

        /**
         * Build the game
         *
         * @return the game
         */
        public Game build() {
            if (rolls_list.isEmpty()) {
                throw new AnyRollToPlay();
            }
            if (player_list.size() < 2) {
                throw new NotEnoughtPlayersToPlay();
            }
            return new Game(this);
        }
    }

    private Game(Builder builder) {
        player_list = builder.player_list;
        rolls_list = builder.rolls_list;
        observers = builder.observers;
    }

    public void play() {
        Iterator<Roll> it = rolls_list.iterator();
        while (it.hasNext()) {
            Roll r = it.next();
            r.doRound(this);
            notifyObservers(r);
        }
        Historical.deleteInstance();
    }

    /**
     *
     * @return the collection of observers
     */
    public Collection<Observer> getObservers() {
        return observers;
    }

    /**
     *
     * @return the collection of players
     */
    public Collection<Player> getPlayerList() {
        return player_list;
    }

    /**
     *
     * @return the collection of rolls
     */
    public Collection<Roll> getRollsList() {
        return rolls_list;
    }

    /**
     *
     * @param o the observer to add
     */
    public void addObserver(Observer o) {
        observers.add(o);
    }

    /**
     *
     * @param o the observer to quit
     */
    public void quitObserver(Observer o) {
        observers.remove(o);
    }

    private void notifyObservers(Roll roll) {
        for (Observer o : observers) {
            o.updateObserver(this, roll);
        }
    }
}
