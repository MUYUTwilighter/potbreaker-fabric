package cool.muyucloud.potbreaker.tunnel;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class McEntityImpl extends McEntity {
    Entity entity;

    public static McEntity of(Entity entity) {
        if (entity instanceof PlayerEntity playerEntity) {
            return McPlayerEntityImpl.of(playerEntity);
        } else {
            McEntityImpl mcEntity = new McEntityImpl();
            mcEntity.entity = entity;
            return mcEntity;
        }
    }

    @Override
    public Object get() {
        return entity;
    }

    @Override
    public void initTunnel() {
    }
}
