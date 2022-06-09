import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;


public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int[][][] mapTileNum;

    public TileManager(GamePanel var1) {
        this.gp = var1;
        this.tile = new Tile[50];
        Objects.requireNonNull(var1);
        Objects.requireNonNull(var1);
        Objects.requireNonNull(var1);
        this.mapTileNum = new int[10][54][50];
        this.getTileImage();
        this.loadMap("JingleJungle.txt", 0);
        this.loadMap("MAP2.txt", 1);
    }

    public void getTileImage() {
        this.setup(0, "OBJ_STONE_2", true);
        this.setup(1, "OBJ_WALL", true);
        this.setup(2, "OBJ_WATER_2", true);
        this.setup(3, "OBJ_GROVE_2", false);
        this.setup(4, "OBJ_TREE_2", true);
        this.setup(5, "OBJ_GRASS_2", false);
    }

    public void setup(int var1, String var2, boolean var3) {
        UtilityTool var4 = new UtilityTool();

        try {
            this.tile[var1] = new Tile();
            this.tile[var1].image = ImageIO.read(this.getClass().getResourceAsStream(var2 + ".png"));
            Tile var10000 = this.tile[var1];
            BufferedImage var10002 = this.tile[var1].image;
            Objects.requireNonNull(this.gp);
            Objects.requireNonNull(this.gp);
            var10000.image = var4.scaledImage(var10002, 48, 48);
            this.tile[var1].collision = var3;
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    public void loadMap(String var1, int var2) {
        try {
            InputStream var3 = this.getClass().getResourceAsStream(var1);
            BufferedReader var4 = new BufferedReader(new InputStreamReader(var3));
            int var5 = 0;
            int var6 = 0;

            while(true) {
                Objects.requireNonNull(this.gp);
                if (var5 >= 54) {
                    break;
                }

                Objects.requireNonNull(this.gp);
                if (var6 >= 50) {
                    break;
                }

                String var7 = var4.readLine();

                while(true) {
                    Objects.requireNonNull(this.gp);
                    if (var5 >= 54) {
                        Objects.requireNonNull(this.gp);
                        if (var5 == 54) {
                            var5 = 0;
                            ++var6;
                        }
                        break;
                    }

                    String[] var8 = var7.split(" ");
                    int var9 = Integer.parseInt(var8[var5], 8);
                    this.mapTileNum[var2][var5][var6] = var9;
                    ++var5;
                }
            }

            var4.close();
        } catch (Exception var10) {
            var10.printStackTrace();
        }

    }

    public void draw(Graphics2D var1) {
        int var2 = 0;
        int var3 = 0;

        while(true) {
            Objects.requireNonNull(this.gp);
            if (var2 >= 54) {
                break;
            }

            Objects.requireNonNull(this.gp);
            if (var3 >= 50) {
                break;
            }

            int var4 = this.mapTileNum[this.gp.currentMap][var2][var3];
            Objects.requireNonNull(this.gp);
            int var5 = var2 * 48;
            Objects.requireNonNull(this.gp);
            int var6 = var3 * 48;
            int var7 = var5 - this.gp.player.worldX + this.gp.player.screenX;
            int var8 = var6 - this.gp.player.worldY + this.gp.player.screenY;
            Objects.requireNonNull(this.gp);
            if (var5 + 48 > this.gp.player.worldX - this.gp.player.screenX) {
                Objects.requireNonNull(this.gp);
                if (var5 - 48 < this.gp.player.worldX + this.gp.player.screenX) {
                    Objects.requireNonNull(this.gp);
                    if (var6 + 48 > this.gp.player.worldY - this.gp.player.screenY) {
                        Objects.requireNonNull(this.gp);
                        if (var6 - 48 < this.gp.player.worldY + this.gp.player.screenY) {
                            BufferedImage var10001 = this.tile[var4].image;
                            Objects.requireNonNull(this.gp);
                            Objects.requireNonNull(this.gp);
                            var1.drawImage(var10001, var7, var8, 48, 48, (ImageObserver)null);
                        }
                    }
                }
            }

            ++var2;
            Objects.requireNonNull(this.gp);
            if (var2 == 54) {
                var2 = 0;
                ++var3;
            }
        }

    }
}