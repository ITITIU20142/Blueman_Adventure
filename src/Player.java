//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;

public class Player extends Entity {
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public ArrayList<Entity> inventory = new ArrayList();
    public final int maxInventorySize = 20;
    int standCount = 0;
    int hasKey = 0;

    public Player(GamePanel var1, KeyHandler var2) {
        super(var1);
        this.keyH = var2;
        Objects.requireNonNull(var1);
        int var10001 = 768 / 2;
        Objects.requireNonNull(var1);
        this.screenX = var10001 - 48 / 2;
        Objects.requireNonNull(var1);
        var10001 = 576 / 2;
        Objects.requireNonNull(var1);
        this.screenY = var10001 - 48 / 2;
        this.solidArea = new Rectangle();
        this.solidArea.x = 8;
        this.solidArea.y = 16;
        this.solidAreaDefaultX = this.solidArea.x;
        this.solidAreaDefaultY = this.solidArea.y;
        this.solidArea.width = 30;
        this.solidArea.height = 30;
        this.setDefaultValues();
        this.getPlayerImage();
        this.setItems();
    }

    public void setDefaultValues() {
        Objects.requireNonNull(this.gp);
        this.worldX = 48 * 42;
        Objects.requireNonNull(this.gp);
        this.worldY = 48 * 42;
        this.speed = 4;
        this.direction = "right";
        this.level = 1;
        this.maxLife = 6;
        this.life = this.maxLife;
        this.strength = 1;
        this.dexterity = 1;
        this.currentWeapon = new OBJ_WEAPON_NORMAL(this.gp);
        this.currentShield = new OBJ_SHIELD_WOOD(this.gp);
        this.currentKey = new OBJ_KEY(this.gp);
        this.projectile = new OBJ_FIREBALL(this.gp);
    }

    public void setDefaultPoisitionns() {
        Objects.requireNonNull(this.gp);
        this.worldX = 48 * 42;
        Objects.requireNonNull(this.gp);
        this.worldY = 48 * 42;
        this.direction = "up";
    }

    public void restoreLifeAndMan() {
        this.life = this.maxLife;
        this.invincible = false;
    }

    public void setItems() {
        this.inventory.clear();
        this.inventory.add(this.currentWeapon);
        this.inventory.add(this.currentShield);
    }

    public int getAttack() {
        return this.attack = this.strength;
    }

    public int getDefense() {
        return this.defense = this.dexterity * this.currentWeapon.defenseValue;
    }

    public void getPlayerImage() {
        Objects.requireNonNull(this.gp);
        Objects.requireNonNull(this.gp);
        this.up1 = this.setup("player_up_1", 48, 48);
        Objects.requireNonNull(this.gp);
        Objects.requireNonNull(this.gp);
        this.up2 = this.setup("player_up_2", 48, 48);
        Objects.requireNonNull(this.gp);
        Objects.requireNonNull(this.gp);
        this.down1 = this.setup("player_down_1", 48, 48);
        Objects.requireNonNull(this.gp);
        Objects.requireNonNull(this.gp);
        this.down2 = this.setup("player_down_2", 48, 48);
        Objects.requireNonNull(this.gp);
        Objects.requireNonNull(this.gp);
        this.left1 = this.setup("player_left_1", 48, 48);
        Objects.requireNonNull(this.gp);
        Objects.requireNonNull(this.gp);
        this.left2 = this.setup("player_left_2", 48, 48);
        Objects.requireNonNull(this.gp);
        Objects.requireNonNull(this.gp);
        this.right1 = this.setup("player_right_1", 48, 48);
        Objects.requireNonNull(this.gp);
        Objects.requireNonNull(this.gp);
        this.right2 = this.setup("player_right_2", 48, 48);
    }

    public BufferedImage setup(String var1) {
        UtilityTool var2 = new UtilityTool();
        BufferedImage var3 = null;

        try {
            var3 = ImageIO.read(this.getClass().getResourceAsStream(var1 + ".png"));
            Objects.requireNonNull(this.gp);
            Objects.requireNonNull(this.gp);
            var3 = var2.scaledImage(var3, 48, 48);
        } catch (IOException var5) {
            var5.printStackTrace();
        }

        return var3;
    }

    public void update() {
        if (this.keyH.upPressed || this.keyH.downPressed || this.keyH.leftPressed || this.keyH.rightPressed) {
            if (this.keyH.upPressed) {
                this.direction = "up";
            } else if (this.keyH.downPressed) {
                this.direction = "down";
            } else if (this.keyH.leftPressed) {
                this.direction = "left";
            } else if (this.keyH.rightPressed) {
                this.direction = "right";
            }

            this.collision = false;
            this.gp.cChecker.checkTile(this);
            int var1 = this.gp.cChecker.checkObject(this, true);
            this.pickUpObject(var1);
            int var2 = this.gp.cChecker.checkEntity(this, this.gp.npc);
            this.interactNPC(var2);
            int var3 = this.gp.cChecker.checkEntity(this, this.gp.monster);
            this.interactMonster(var3);
            this.damageMonster(var3, this.attack);
            this.gp.eHandler.checkEvent();
            if (!this.collision) {
                String var4 = this.direction;
                byte var5 = -1;
                switch(var4.hashCode()) {
                case 3739:
                    if (var4.equals("up")) {
                        var5 = 0;
                    }
                    break;
                case 3089570:
                    if (var4.equals("down")) {
                        var5 = 1;
                    }
                    break;
                case 3317767:
                    if (var4.equals("left")) {
                        var5 = 2;
                    }
                    break;
                case 108511772:
                    if (var4.equals("right")) {
                        var5 = 3;
                    }
                }

                switch(var5) {
                case 0:
                    this.worldY -= this.speed;
                    break;
                case 1:
                    this.worldY += this.speed;
                    break;
                case 2:
                    this.worldX -= this.speed;
                    break;
                case 3:
                    this.worldX += this.speed;
                }
            }

            ++this.spriteCounter;
            if (this.spriteCounter > 12) {
                if (this.spriteNum == 1) {
                    this.spriteNum = 2;
                } else if (this.spriteNum == 2) {
                    this.spriteNum = 1;
                }

                this.spriteCounter = 0;
            }
        }

        if (this.gp.keyH.shotPressed && !this.projectile.alive) {
            this.projectile.set(this.worldX, this.worldY, this.direction, true, this);
            this.gp.projectileList.add(this.projectile);
        }

        if (this.invincible) {
            ++this.invincibleCounter;
            if (this.invincibleCounter > 60) {
                this.invincible = false;
                this.invincibleCounter = 0;
            }
        }

        if (this.life <= 0) {
            GamePanel var10000 = this.gp;
            Objects.requireNonNull(this.gp);
            var10000.gameState = 6;
        }

    }

    public void pickUpObject(int var1) {
        if (var1 != 999) {
            String var2 = this.gp.obj[this.gp.currentMap][var1].name;
            byte var4 = -1;
            switch(var2.hashCode()) {
            case 75327:
                if (var2.equals("Key")) {
                    var4 = 0;
                }
                break;
            case 2136014:
                if (var2.equals("Door")) {
                    var4 = 1;
                }
            }

            switch(var4) {
            case 0:
                ++this.hasKey;
                this.inventory.add(this.currentKey);
                this.gp.obj[this.gp.currentMap][var1] = null;
                this.gp.ui.showMessage("You got a key!");
                break;
            case 1:
                if (this.hasKey > 0) {
                    this.gp.obj[this.gp.currentMap][var1] = null;
                    --this.hasKey;
                    this.inventory.remove(this.currentKey);
                    this.gp.ui.showMessage("You opened the door!");
                } else {
                    this.gp.ui.showMessage("You need a key to open!");
                }
            }
        }

    }

    public void interactMonster(int var1) {
        if (var1 != 999) {
            if (this.gp.keyH.monsterPressed) {
                GamePanel var10000 = this.gp;
                Objects.requireNonNull(this.gp);
                var10000.gameState = 7;
                this.gp.monster[this.gp.currentMap][var1].monsterSpeak();
            }

            this.gp.keyH.monsterPressed = false;
        }

        if (var1 != 999 && !this.invincible) {
            --this.life;
            this.invincible = true;
        }

    }

    public void damageMonster(int var1, int var2) {
        if (var1 != 999 && !this.gp.monster[this.gp.currentMap][var1].invincible) {
            int var3 = var2 - this.gp.monster[this.gp.currentMap][var1].defense;
            if (var3 < 0) {
                var3 = 0;
            }

            Entity var10000 = this.gp.monster[this.gp.currentMap][var1];
            var10000.life -= var3;
            this.gp.ui.showMessage(var3 + "damage!");
            this.gp.monster[this.gp.currentMap][var1].invincible = true;
            if (this.gp.monster[this.gp.currentMap][var1].life <= 0) {
                this.gp.monster[this.gp.currentMap][var1].dying = true;
                String var10001 = this.gp.monster[this.gp.currentMap][var1].name;
                this.gp.ui.showMessage("Killed the " + var10001 + "!");
            }
        }

    }

    public void interactNPC(int var1) {
        if (var1 != 999) {
            if (this.gp.keyH.enterPressed) {
                GamePanel var10000 = this.gp;
                Objects.requireNonNull(this.gp);
                var10000.gameState = 3;
                this.gp.npc[this.gp.currentMap][var1].speak();
            }

            this.gp.keyH.enterPressed = false;
        }

    }

    public void draw(Graphics2D var1) {
        BufferedImage var2 = null;
        String var3 = this.direction;
        byte var4 = -1;
        switch(var3.hashCode()) {
        case 3739:
            if (var3.equals("up")) {
                var4 = 0;
            }
            break;
        case 3089570:
            if (var3.equals("down")) {
                var4 = 1;
            }
            break;
        case 3317767:
            if (var3.equals("left")) {
                var4 = 2;
            }
            break;
        case 108511772:
            if (var3.equals("right")) {
                var4 = 3;
            }
        }

        switch(var4) {
        case 0:
            if (this.spriteNum == 1) {
                var2 = this.up1;
            }

            if (this.spriteNum == 2) {
                var2 = this.up2;
            }
            break;
        case 1:
            if (this.spriteNum == 1) {
                var2 = this.down1;
            }

            if (this.spriteNum == 2) {
                var2 = this.down2;
            }
            break;
        case 2:
            if (this.spriteNum == 1) {
                var2 = this.left1;
            }

            if (this.spriteNum == 2) {
                var2 = this.left2;
            }
            break;
        case 3:
            if (this.spriteNum == 1) {
                var2 = this.right1;
            }

            if (this.spriteNum == 2) {
                var2 = this.right2;
            }
        }

        if (this.invincible) {
            var1.setComposite(AlphaComposite.getInstance(3, 0.3F));
        }

        var1.drawImage(var2, this.screenX, this.screenY, (ImageObserver)null);
        var1.setComposite(AlphaComposite.getInstance(3, 1.0F));
    }
}
