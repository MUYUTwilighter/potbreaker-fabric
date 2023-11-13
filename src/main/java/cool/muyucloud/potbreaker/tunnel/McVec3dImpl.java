package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.util.math.Vec3d;

@Tunnel
public class McVec3dImpl implements McVec3d {
    private Vec3d vec3d;

    public static McVec3dImpl of(Vec3d vec3d) {
        McVec3dImpl mcVec3d = new McVec3dImpl();
        mcVec3d.vec3d = vec3d;
        return mcVec3d;
    }

    @Override
    public Object get() {
        return vec3d;
    }

    @Override
    public void initTunnel() {}
}
