package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.util.math.Direction;

@Tunnel
public class McDirectionImpl extends McDirection {
    Direction direction;

    public static McDirectionImpl of(Direction direction) {
        McDirectionImpl mcDirection = new McDirectionImpl();
        mcDirection.direction = direction;
        return mcDirection;
    }

    @Override
    public Object get() {
        return direction;
    }

    @Override
    public void initTunnel() {
        UP = of(Direction.UP);
        DOWN = of(Direction.DOWN);
    }
}
