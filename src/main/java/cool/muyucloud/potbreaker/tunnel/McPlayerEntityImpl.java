package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

@Tunnel
public class McPlayerEntityImpl implements McPlayerEntity {
    PlayerEntity playerEntity;

    public static McPlayerEntityImpl of(PlayerEntity playerEntity) {
        McPlayerEntityImpl mcPlayerEntity = new McPlayerEntityImpl();
        mcPlayerEntity.playerEntity = playerEntity;
        return mcPlayerEntity;
    }

    @Override
    public Object get() {
        return playerEntity;
    }

    @Override
    public void initTunnel() {}

    @Override
    public McVec3d getPos() {
        Vec3d pos = playerEntity.getPos();
        return McVec3dImpl.of(pos);
    }
}
