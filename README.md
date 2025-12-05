# Lantu Dapao - Create Schematicannon Speed Mod

[English](#english) | [中文](#中文)

---

## English

A NeoForge mod that significantly increases the printing speed of Create mod's Schematicannon.

### Features

- **300x faster printing** by default (configurable)
- In-game commands to adjust speed dynamically
- Compatible with Create 6.0.8+

### Requirements

- Minecraft 1.21.1
- NeoForge 21.1.200+
- Create 6.0.8+
- Java 21+

### Installation

1. Download the latest release from [Releases](https://github.com/Viking602/create_schematicannon_speed/releases)
2. Place the `.jar` file in your `mods` folder
3. Make sure Create mod is installed
4. Launch the game

### Usage

Use the `/lantudapao` command to configure the speed:

| Command | Description |
|---------|-------------|
| `/lantudapao speed <1-1000>` | Set speed multiplier |
| `/lantudapao reset` | Reset to default (300x) |

### How It Works

This mod uses Mixin to intercept the `printerCooldown` assignment in `SchematicannonBlockEntity.tickPrinter()`, reducing the delay between block placements.

---

## 中文

一个 NeoForge 模组，大幅提升 Create 模组原理图大炮的打印速度。

### 功能特性

- 默认 **300 倍** 打印速度提升（可配置）
- 游戏内命令动态调整速度
- 兼容 Create 6.0.8+

### 系统要求

- Minecraft 1.21.1
- NeoForge 21.1.200+
- Create 6.0.8+
- Java 21+

### 安装方法

1. 从 [Releases](https://github.com/Viking602/create_schematicannon_speed/releases) 下载最新版本
2. 将 `.jar` 文件放入 `mods` 文件夹
3. 确保已安装 Create 模组
4. 启动游戏

### 使用方法

使用 `/lantudapao` 命令配置速度：

| 命令 | 说明 |
|------|------|
| `/lantudapao speed <1-1000>` | 设置速度倍率 |
| `/lantudapao reset` | 重置为默认值 (300x) |

### 工作原理

此模组使用 Mixin 拦截 `SchematicannonBlockEntity.tickPrinter()` 中的 `printerCooldown` 赋值，减少方块放置之间的延迟。

---

## License

MIT License

## Credits

- [Create Mod](https://github.com/Creators-of-Create/Create) by simibubi
