import java.util.Objects;

public class AssetSetter {
    GamePanel gp;
    int MAP2;
    int JingleJungle = 0;

    public AssetSetter(GamePanel var1) {
        this.gp = var1;
    }

    public void setobject() {
        this.gp.obj[this.MAP2][0] = new OBJ_DOOR(this.gp);
        Entity var10000 = this.gp.obj[this.MAP2][0];
        Objects.requireNonNull(this.gp);
        var10000.worldX = 41 * 48;
        var10000 = this.gp.obj[this.MAP2][0];
        Objects.requireNonNull(this.gp);
        var10000.worldY = 19 * 48;
        this.gp.obj[this.MAP2][1] = new OBJ_DOOR(this.gp);
        var10000 = this.gp.obj[this.MAP2][1];
        Objects.requireNonNull(this.gp);
        var10000.worldX = 53 * 48;
        var10000 = this.gp.obj[this.MAP2][1];
        Objects.requireNonNull(this.gp);
        var10000.worldY = 52 * 48;
        this.gp.obj[this.MAP2][2] = new OBJ_DOOR(this.gp);
        var10000 = this.gp.obj[this.MAP2][2];
        Objects.requireNonNull(this.gp);
        var10000.worldX = 10 * 48;
        var10000 = this.gp.obj[this.MAP2][2];
        Objects.requireNonNull(this.gp);
        var10000.worldY = 25 * 48;
        this.gp.obj[this.MAP2][3] = new OBJ_DOOR(this.gp);
        var10000 = this.gp.obj[this.MAP2][3];
        Objects.requireNonNull(this.gp);
        var10000.worldX = 24 * 48;
        var10000 = this.gp.obj[this.MAP2][3];
        Objects.requireNonNull(this.gp);
        var10000.worldY = 8 * 48;
    }

    public void setNPC() {
        this.gp.npc[this.MAP2][0] = new NPC_OLDMAN(this.gp);
        Entity var10000 = this.gp.npc[this.MAP2][0];
        Objects.requireNonNull(this.gp);
        var10000.worldX = 48 * 15;
        var10000 = this.gp.npc[this.MAP2][0];
        Objects.requireNonNull(this.gp);
        var10000.worldY = 48 * 15;
        this.gp.npc[this.MAP2][1] = new NPC_OLDMAN(this.gp);
        var10000 = this.gp.npc[this.MAP2][1];
        Objects.requireNonNull(this.gp);
        var10000.worldX = 48 * 31;
        var10000 = this.gp.npc[this.MAP2][1];
        Objects.requireNonNull(this.gp);
        var10000.worldY = 48 * 12;
        this.gp.npc[this.MAP2][2] = new NPC_OLDMAN(this.gp);
        var10000 = this.gp.npc[this.MAP2][2];
        Objects.requireNonNull(this.gp);
        var10000.worldX = 48 * 31;
        var10000 = this.gp.npc[this.MAP2][2];
        Objects.requireNonNull(this.gp);
        var10000.worldY = 48 * 37;
        this.gp.npc[this.MAP2][3] = new NPC_OLDMAN(this.gp);
        var10000 = this.gp.npc[this.MAP2][3];
        Objects.requireNonNull(this.gp);
        var10000.worldX = 48 * 24;
        var10000 = this.gp.npc[this.MAP2][3];
        Objects.requireNonNull(this.gp);
        var10000.worldY = 48 * 27;
        this.gp.npc[this.MAP2][4] = new NPC_OLDMAN(this.gp);
        var10000 = this.gp.npc[this.MAP2][4];
        Objects.requireNonNull(this.gp);
        var10000.worldX = 48 * 44;
        var10000 = this.gp.npc[this.MAP2][4];
        Objects.requireNonNull(this.gp);
        var10000.worldY = 48 * 19;
    }

    public void setMonster() {
        this.gp.monster[this.JingleJungle][0] = new MON2(this.gp);
        Entity var10000 = this.gp.monster[this.JingleJungle][0];
        Objects.requireNonNull(this.gp);
        var10000.worldX = 48 * 15;
        var10000 = this.gp.monster[this.JingleJungle][0];
        Objects.requireNonNull(this.gp);
        var10000.worldY = 48 * 11;
        this.gp.monster[this.MAP2][0] = new MON(this.gp);
        var10000 = this.gp.monster[this.MAP2][0];
        Objects.requireNonNull(this.gp);
        var10000.worldX = 48 * 17;
        var10000 = this.gp.monster[this.MAP2][0];
        Objects.requireNonNull(this.gp);
        var10000.worldY = 48 * 7;
        this.gp.monster[this.MAP2][1] = new MON(this.gp);
        var10000 = this.gp.monster[this.MAP2][1];
        Objects.requireNonNull(this.gp);
        var10000.worldX = 48 * 10;
        var10000 = this.gp.monster[this.MAP2][1];
        Objects.requireNonNull(this.gp);
        var10000.worldY = 48 * 16;
        this.gp.monster[this.MAP2][2] = new MON(this.gp);
        var10000 = this.gp.monster[this.MAP2][2];
        Objects.requireNonNull(this.gp);
        var10000.worldX = 48 * 44;
        var10000 = this.gp.monster[this.MAP2][2];
        Objects.requireNonNull(this.gp);
        var10000.worldY = 48 * 30;
        this.gp.monster[this.MAP2][3] = new MON(this.gp);
        var10000 = this.gp.monster[this.MAP2][3];
        Objects.requireNonNull(this.gp);
        var10000.worldX = 48 * 11;
        var10000 = this.gp.monster[this.MAP2][3];
        Objects.requireNonNull(this.gp);
        var10000.worldY = 48 * 39;
        this.gp.monster[this.MAP2][4] = new MON(this.gp);
        var10000 = this.gp.monster[this.MAP2][4];
        Objects.requireNonNull(this.gp);
        var10000.worldX = 48 * 33;
        var10000 = this.gp.monster[this.MAP2][4];
        Objects.requireNonNull(this.gp);
        var10000.worldY = 48 * 36;
        this.gp.monster[this.MAP2][5] = new MON(this.gp);
        var10000 = this.gp.monster[this.MAP2][5];
        Objects.requireNonNull(this.gp);
        var10000.worldX = 48 * 11;
        var10000 = this.gp.monster[this.MAP2][5];
        Objects.requireNonNull(this.gp);
        var10000.worldY = 48 * 39;
    }
}
