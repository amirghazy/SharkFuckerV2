package strategies;

import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.parabot.environment.api.utils.Time;
import org.rev317.min.api.wrappers.Npc;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Tile;

/**
 * Created by Tezi on 12-05-2015.
 */
public class Sharkc implements Strategy {
    Npc[] Spot = Npcs.getNearest(334);

    @Override
    public boolean activate() {

        // TODO Auto-generated method stub

        return !Inventory.isFull();
    }

    @Override
    public void execute() {

        if(Spot.length < 8){
            new Tile(2604, 3421).walkTo();
            Time.sleep(1000);
        }
        if(Inventory.contains(312) && Players.getMyPlayer().getAnimation() == -1 && Players.getMyPlayer().getLocation().equals(new Tile(2604, 3421))){
            Npc[] Spot = Npcs.getNearest(334);
            if(Spot != null){


                Spot[0].interact(Npcs.Option.HARPOON);
                Time.sleep(1000);
                while(Players.getMyPlayer().getAnimation() != -1){
                    Time.sleep(500);
                }
            }
        }
    }
}