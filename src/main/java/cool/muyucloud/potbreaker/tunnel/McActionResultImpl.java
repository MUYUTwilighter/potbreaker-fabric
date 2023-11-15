package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.util.ActionResult;

@Tunnel
public class McActionResultImpl extends McActionResult {
    ActionResult actionResult;

    public static McActionResultImpl of(ActionResult actionResult) {
        McActionResultImpl mcActionResult = new McActionResultImpl();
        mcActionResult.actionResult = actionResult;
        return mcActionResult;
    }

    @Override
    public Object get() {
        return actionResult;
    }

    @Override
    public void initTunnel() {
        PASS = of(ActionResult.PASS);
        FAIL = of(ActionResult.FAIL);
    }
}
