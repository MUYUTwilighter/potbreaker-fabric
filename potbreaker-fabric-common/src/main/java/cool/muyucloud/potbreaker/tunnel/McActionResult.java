package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.McTunnel;
import cool.muyucloud.tunnel.annotation.Tunnel;

@Tunnel
public abstract class McActionResult implements McTunnel {
    public static McActionResult PASS;
    public static McActionResult FAIL;
}
