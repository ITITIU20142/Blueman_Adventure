import java.awt.*;

public class KeyHandler implements KeyListener {
    GamePanel gp;
    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;
    public boolean enterPressed;
    public boolean monsterPressed;
    public boolean shotPressed;
    boolean checkDrawTime = false;

    public KeyHandler(GamePanel var1) {
        this.gp = var1;
    }

    public void keyTyped(KeyEvent var1) {
    }

    public void keyPressed(KeyEvent var1) {
        int var2 = var1.getKeyCode();
        int var10000 = this.gp.gameState;
        Objects.requireNonNull(this.gp);
        if (var10000 == 0) {
            this.titleState(var2);
        }

        var10000 = this.gp.gameState;
        Objects.requireNonNull(this.gp);
        if (var10000 == 1) {
            this.playState(var2);
        } else {
            var10000 = this.gp.gameState;
            Objects.requireNonNull(this.gp);
            if (var10000 == 2) {
                this.pauseState(var2);
            } else {
                var10000 = this.gp.gameState;
                Objects.requireNonNull(this.gp);
                if (var10000 == 3) {
                    this.dialogueState(var2);
                } else {
                    var10000 = this.gp.gameState;
                    Objects.requireNonNull(this.gp);
                    if (var10000 == 7) {
                        this.dialogueMonsterState(var2);
                    } else {
                        var10000 = this.gp.gameState;
                        Objects.requireNonNull(this.gp);
                        if (var10000 == 4) {
                            this.characterState(var2);
                        } else {
                            var10000 = this.gp.gameState;
                            Objects.requireNonNull(this.gp);
                            if (var10000 == 5) {
                                this.optionState(var2);
                            } else {
                                var10000 = this.gp.gameState;
                                Objects.requireNonNull(this.gp);
                                if (var10000 == 6) {
                                    this.gameOverState(var2);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public void optionState(int var1) {
        if (var1 == 27) {
            GamePanel var10000 = this.gp;
            Objects.requireNonNull(this.gp);
            var10000.gameState = 1;
        }

        if (var1 == 10) {
            this.enterPressed = true;
        }

        byte var2 = 0;
        switch(this.gp.ui.subState) {
        case 0:
            var2 = 5;
        default:
            if (var1 == 87) {
                --this.gp.ui.commandNum;
                if (this.gp.ui.commandNum < 0) {
                    this.gp.ui.commandNum = var2;
                }
            }

            if (var1 == 83) {
                ++this.gp.ui.commandNum;
                if (this.gp.ui.commandNum > var2) {
                    this.gp.ui.commandNum = 0;
                }
            }

        }
    }

    public void gameOverState(int var1) {
        if (var1 == 87 || var1 == 38) {
            --this.gp.ui.commandNum;
            if (this.gp.ui.commandNum < 0) {
                this.gp.ui.commandNum = 1;
            }
        }

        if (var1 == 83 || var1 == 40) {
            ++this.gp.ui.commandNum;
            if (this.gp.ui.commandNum > 1) {
                this.gp.ui.commandNum = 0;
            }
        }

        if (var1 == 10) {
            GamePanel var2;
            if (this.gp.ui.commandNum == 0) {
                var2 = this.gp;
                Objects.requireNonNull(this.gp);
                var2.gameState = 1;
                this.gp.retry();
            } else if (this.gp.ui.commandNum == 1) {
                var2 = this.gp;
                Objects.requireNonNull(this.gp);
                var2.gameState = 0;
                this.gp.restart();
            }
        }

    }

    public void titleState(int var1) {
        if (var1 == 87 || var1 == 38) {
            --this.gp.ui.commandNum;
            if (this.gp.ui.commandNum < 0) {
                this.gp.ui.commandNum = 2;
            }
        }

        if (var1 == 83 || var1 == 40) {
            ++this.gp.ui.commandNum;
            if (this.gp.ui.commandNum > 2) {
                this.gp.ui.commandNum = 0;
            }
        }

        if (var1 == 10) {
            if (this.gp.ui.commandNum == 0) {
                GamePanel var2 = this.gp;
                Objects.requireNonNull(this.gp);
                var2.gameState = 1;
            }

            if (this.gp.ui.commandNum == 1) {
            }

            if (this.gp.ui.commandNum == 2) {
                System.exit(0);
            }
        }

    }

    public void playState(int var1) {
        if (var1 == 87 || var1 == 38) {
            this.upPressed = true;
        }

        if (var1 == 83 || var1 == 40) {
            this.downPressed = true;
        }

        if (var1 == 65 || var1 == 37) {
            this.leftPressed = true;
        }

        if (var1 == 68 || var1 == 39) {
            this.rightPressed = true;
        }

        GamePanel var10000;
        if (var1 == 80) {
            var10000 = this.gp;
            Objects.requireNonNull(this.gp);
            var10000.gameState = 2;
        }

        if (var1 == 67) {
            var10000 = this.gp;
            Objects.requireNonNull(this.gp);
            var10000.gameState = 4;
        }

        if (var1 == 69) {
            this.enterPressed = true;
        }

        if (var1 == 82) {
            this.monsterPressed = true;
        }

        if (var1 == 70) {
            this.shotPressed = true;
        }

        if (var1 == 27) {
            var10000 = this.gp;
            Objects.requireNonNull(this.gp);
            var10000.gameState = 5;
        }

        if (var1 == 84) {
            if (!this.checkDrawTime) {
                this.checkDrawTime = true;
            } else if (this.checkDrawTime) {
                this.checkDrawTime = false;
            }
        }

    }

    public void pauseState(int var1) {
        if (var1 == 80 || var1 == 27) {
            GamePanel var10000 = this.gp;
            Objects.requireNonNull(this.gp);
            var10000.gameState = 1;
        }

    }

    public void dialogueState(int var1) {
        if (var1 == 10) {
            GamePanel var10000 = this.gp;
            Objects.requireNonNull(this.gp);
            var10000.gameState = 1;
        }

    }

    public void dialogueMonsterState(int var1) {
        if (var1 == 10) {
            GamePanel var10000 = this.gp;
            Objects.requireNonNull(this.gp);
            var10000.gameState = 1;
        }

    }

    public void characterState(int var1) {
        if (var1 == 67) {
            GamePanel var10000 = this.gp;
            Objects.requireNonNull(this.gp);
            var10000.gameState = 1;
        }

        if ((var1 == 87 || var1 == 38) && this.gp.ui.slotRow != 0) {
            --this.gp.ui.slotRow;
        }

        if ((var1 == 65 || var1 == 37) && this.gp.ui.slotCol != 0) {
            --this.gp.ui.slotCol;
        }

        if ((var1 == 83 || var1 == 40) && this.gp.ui.slotRow != 3) {
            ++this.gp.ui.slotRow;
        }

        if ((var1 == 68 || var1 == 39) && this.gp.ui.slotCol != 4) {
            ++this.gp.ui.slotCol;
        }

    }

    public void keyReleased(KeyEvent var1) {
        int var2 = var1.getKeyCode();
        if (var2 == 87 || var2 == 38) {
            this.upPressed = false;
        }

        if (var2 == 83 || var2 == 40) {
            this.downPressed = false;
        }

        if (var2 == 65 || var2 == 37) {
            this.leftPressed = false;
        }

        if (var2 == 68 || var2 == 39) {
            this.rightPressed = false;
        }

        if (var2 == 70) {
            this.shotPressed = false;
        }

    }
}