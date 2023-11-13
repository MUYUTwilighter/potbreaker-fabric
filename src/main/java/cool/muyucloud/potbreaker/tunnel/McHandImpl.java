package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.util.Hand;

@Tunnel
public class McHandImpl extends McHand {
    private Hand hand;

    public static McHandImpl of(Hand hand) {
        McHandImpl mcHand = new McHandImpl();
        mcHand.hand = hand;
        return mcHand;
    }

    @Override
    public Object get() {
        return hand;
    }

    @Override
    public void initTunnel() {
        MAIN_HAND = of(Hand.MAIN_HAND);
    }
}
