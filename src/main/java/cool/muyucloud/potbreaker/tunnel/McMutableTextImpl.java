package cool.muyucloud.potbreaker.tunnel;

import cool.muyucloud.tunnel.annotation.Tunnel;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

@Tunnel
public class McMutableTextImpl extends McMutableText {
    private Text text;

    public static McMutableText of(Text text) {
        McMutableTextImpl mcText = new McMutableTextImpl();
        mcText.text = text;
        return mcText;
    }

    @Override
    public McMutableText of(String content) {
        MutableText text = Text.literal(content);
        return of(text);
    }

    @Override
    public Object get() {
        return text;
    }

    @Override
    public void initTunnel() {
        MC_TEXT = new McMutableTextImpl();
    }
}
