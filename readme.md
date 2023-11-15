# Pot Breaker

A Minecraft mod that let decorated pot break in a Plant Vs. Zombies way!

Example project of [Tunnel](https://github.com/Nova-Committee/tunnel)

## Dependency

### Fabric

[Fabric API](https://modrinth.com/mod/fabric-api) of any version is required

## Introduction

When a player breaks a decorated pot, the item in the pot will be *USED* automatically.

For example, if the decorated pot contains a pig spawn egg

![](http://muyucloud.cool:22222/mod/pot_breaker/1.png)

When a player breaks the pot with tools included in tag `#minecraft:decorated_pot_tools`, the spawn egg will be used on the block under the pot, which summons a pig

![](http://muyucloud.cool:22222/mod/pot_breaker/2.png)

## Config

- `place` : allow attempt to invoke item-place, influencing: spawn egg, etc. default: true;
- `use` : allow attempt to invoke item use (won't invoke if item-place is invokable), influencing: splash potions, eggs, etc. default: false;
- `maxExecutes`: maximum attempts of item usage (if more than one item in the pot), 