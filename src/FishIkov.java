

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.events.MessageEvent;
import org.rev317.min.api.events.listeners.MessageListener;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.wrappers.Item;
import strategies.bankit;
import strategies.Sharkc;
import java.awt.*;
import java.util.ArrayList;
import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.api.utils.Timer;




@ScriptManifest(author = "Tezi", category = Category.FISHING,
        description = "Catches Sharks and banks them in Fishing Guild", name = "SharkFucker V2",
        servers = { "Ikov" }, version = 2.0)


public class FishIkov extends Script implements MessageListener, Paintable {

    private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();
    int Caught = 0;

    private final Timer RAN = new Timer();

    public boolean onExecute() {
        strategies.add(new Sharkc());
        strategies.add(new bankit());


        provide(strategies);
        return true;
    }


    public void messageReceived(MessageEvent m)
    {


        if (m.getMessage().contains("You manage to catch a raw shark")) {
            Caught += 1;
        }

    }
    public void onFinish() {
        System.out.println("SharkFucker Made By Tezi");
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("Runtime " + RAN, 80, 300);
        g.drawString("Sharks Caught: " + Caught, 80, 280);
        g.drawString("Made By Tezi", 600, 420);
    }

}


