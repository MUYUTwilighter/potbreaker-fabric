package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.util.Identifier;

@Tunnel
public class McIdentifierImpl extends McIdentifier {
    Identifier identifier;

    public static McIdentifier of(Identifier identifier) {
        if (identifier == null) {
            return null;
        }
        McIdentifierImpl mcIdentifier = new McIdentifierImpl();
        mcIdentifier.identifier = identifier;
        return mcIdentifier;
    }

    @Override
    public McIdentifier tryParse(String id) {
        Identifier identifier = Identifier.tryParse(id);
        return of(identifier);
    }

    @Override
    public Object get() {
        return identifier;
    }

    @Override
    public void initTunnel() {
        IDENTIFIER = new McIdentifierImpl();
    }
}
