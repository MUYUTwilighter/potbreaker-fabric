package cool.muyucloud.potbreaker;

import java.io.Serializable;
import java.util.HashSet;

public class Config implements Serializable {
    private Boolean use = false;
    private Boolean useOnBlock = true;
    private Integer maxUses = 1;
    private HashSet<String> useWhiteList = null;
}
