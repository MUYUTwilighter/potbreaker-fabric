package cool.muyucloud.potbreaker.tunnel;

public interface McDecoratedPotBlockEntity extends McBlockEntity {
    McItemStack getStack();

    void setStack(McItemStack mcItemStack);
}
