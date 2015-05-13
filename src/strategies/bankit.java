package strategies;

import org.rev317.min.api.methods.Inventory;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Bank;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;
import org.rev317.min.api.wrappers.Tile;

/**
 * Created by Tezi on 12-05-2015.
 */
public class bankit implements Strategy{


    @Override
    public boolean activate() {
        // TODO Auto-generated method stub
        return Inventory.isFull();
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        if(Players.getMyPlayer().getLocation() != new Tile(2586, 3418)){
            new Tile(2586, 3418).walkTo();
            Time.sleep(1000);
        }
        if(!Bank.isOpen() && Players.getMyPlayer().getLocation().equals(new Tile(2586, 3418))){
            SceneObject[] _Bank = SceneObjects.getNearest(2213);
            _Bank[0].interact(SceneObjects.Option.USE);
            Time.sleep(1000);
        }
        if(Bank.isOpen()){

            Bank.depositAllExcept(312);
            Time.sleep(100);

        }
    }

}


