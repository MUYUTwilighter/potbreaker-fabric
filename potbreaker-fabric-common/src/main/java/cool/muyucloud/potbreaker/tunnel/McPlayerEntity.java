package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;

public abstract class McPlayerEntity extends McEntity {
    public abstract McVec3d getPos();

    public abstract McItemStack getMainHandStack();

    public abstract void setMainHandStack(McItemStack mcItemStack);

    public abstract double getX();

    public abstract double getY();

    public abstract double getZ();

    public abstract void setPos(double x, double y, double z);

    public abstract float getPitch();

    public abstract void setPitch(float pitch);
}
