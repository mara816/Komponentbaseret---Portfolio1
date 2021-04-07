package dk.sdu.mmmi.cbse.bigasteroid;

import dk.sdu.mmmi.cbse.common.bigasteroid.BigAsteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import org.openide.util.lookup.ServiceProvider;

@ServiceProvider(service = IGamePluginService.class)
public class BigAsteroidPlugin implements IGamePluginService {

    @Override
    public void start(GameData gameData, World world) {
        // Add entities to the world
        Entity bigasteroid = createAsteroid(gameData);
        world.addEntity(bigasteroid);
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        for (Entity bigasteroid : world.getEntities(BigAsteroid.class)) {
            world.removeEntity(bigasteroid);
        }
    }

    private Entity createAsteroid(GameData gameData) {
        Entity bigasteroid = new BigAsteroid();
        float radians = (float) Math.random() * 2 * 3.1415f;
        float speed = (float) Math.random() * 10f + 20f;

        bigasteroid.setRadius(30);
        bigasteroid.add(new MovingPart(0, speed, speed, 0));
        bigasteroid.add(new PositionPart((float) Math.random(), (float) Math.random(), radians));
        bigasteroid.add(new LifePart(3));
        

        return bigasteroid;
    }
}
