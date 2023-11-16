package cool.muyucloud.potbreaker.tunnel;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ProjectileEntity;

public class McProjectileEntityImpl extends McProjectileEntity {
    ProjectileEntity projectileEntity;

    public static McProjectileEntity of(ProjectileEntity projectileEntity) {
        McProjectileEntityImpl mcProjectileEntity = new McProjectileEntityImpl();
        mcProjectileEntity.projectileEntity = projectileEntity;
        return mcProjectileEntity;
    }

    @Override
    public Object get() {
        return projectileEntity;
    }

    @Override
    public void initTunnel() {
    }

    @Override
    public McEntity getOwner() {
        Entity owner = projectileEntity.getOwner();
        return McEntityImpl.of(owner);
    }
}
