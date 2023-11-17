# Pot Breaker

A Minecraft mod that let decorated pot break in a Plant Vs. Zombies way!

Example project of [Tunnel](https://github.com/Nova-Committee/tunnel)

## Dependency

### Fabric

[Fabric API](https://modrinth.com/mod/fabric-api) of any version is required

## Introduction

When a player breaks a decorated pot receiving redstone power, the item in the pot will be *USED* automatically.

For example, if the decorated pot contains a pig spawn egg, and is receiving redstone power

![](images/1.gif)

When a player breaks the pot by hand with tools included in tag `#minecraft:decorated_pot_tools`, or using projectiles, the spawn egg will be used on the block under the pot, which summons a pig

![](images/2.gif)

And don't forget to explore more fun!

![](images/3.gif)

## Config

Config file is located at "<ConfigDir>/potbreaker.json"

- `onBreak` : allow executing usage when player break decorated pot by hand, default: true;
- `onProject`: allow executing usage when player break decorated pot by projectiles, default: false;
- `redstone`: consider redstone power when trying to invoke usage
- `maxUses`: maximum attempts to invoking item usage
- `whitelist`: a set of items or item tags. When null, all items is allowed be used; when assigned (including empty set), only item(s) assigned are allowed to be used.

## Command

- `potbreaker load`: reload config from file and apply now