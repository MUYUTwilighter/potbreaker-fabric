# Pot Breaker

A Minecraft mod that let decorated pot break in a Plant Vs. Zombies way!

Example project of [Tunnel](https://github.com/Nova-Committee/tunnel)

## Dependency

### Fabric

[Fabric API](https://modrinth.com/mod/fabric-api) of any version is required

## Introduction

When a player breaks a decorated pot receiving redstone power, the item in the pot will be *USED* automatically.

For example, if the decorated pot contains a pig spawn egg, and is receiving redstone power

![](https://cdn.modrinth.com/data/g66sVyxT/images/05fb9cc718197a540c428a0238b3cfaee2a1348d.gif)

When a player breaks the pot by hand with tools included in tag `#minecraft:decorated_pot_tools`, or using projectiles, the spawn egg will be used on the block under the pot, which summons a pig

![](https://cdn.modrinth.com/data/g66sVyxT/images/1e32ed2b0a323f4b60a54304b8ecdce3cfc5c4fb.gif)

And don't forget to explore more fun!

![](https://cdn.modrinth.com/data/g66sVyxT/images/76b265e824ea48a5c7c4cfbc1a9b022dad72cc4b.gif)

## Config

Config file is located at "<ConfigDir>/potbreaker.json"

- `onBreak` : allow executing usage when player break decorated pot by hand, default: true;
- `onProject`: allow executing usage when player break decorated pot by projectiles, default: false;
- `redstone`: consider redstone power when trying to invoke usage
- `maxUses`: maximum attempts to invoking item usage
- `whitelist`: a set of items or item tags. When null, all items is allowed be used; when assigned (including empty set), only item(s) assigned are allowed to be used.

## Command

- `potbreaker load`: reload config from file and apply now