import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.EventListener;
import java.util.Objects;
import javax.imageio.ImageIO;

public class GamePanel extends JPanel implements MouseListener, KeyListener {
    private BufferedImage backGroundImage,floodCardBackImage,treasureCardBackImage, waterMarkerImage;

    private BufferedImage fireImage, earthImage, waterImage, airImage;

    boolean takingAction = false;

    private boolean playerIsMoving = false, playerIsShoringUp = false;
    private Player playerMoving = null, playerShoringUp = null;

    public GamePanel(){
        FloodDeck.gamePanel = this;
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);

        try {
            backGroundImage = ImageIO.read(GamePanel.class.getResource("/Images/background.png"));
            floodCardBackImage = ImageIO.read(GamePanel.class.getResource("/Images/FloodCardBack.png"));
            treasureCardBackImage = ImageIO.read(GamePanel.class.getResource("/Images/TreasureCardBack.png"));
            waterMarkerImage = ImageIO.read(GamePanel.class.getResource("/Images/Watermeter.png"));

            fireImage = ImageIO.read(GamePanel.class.getResource("/Images/Treasures/FEU.png"));
            earthImage = ImageIO.read(GamePanel.class.getResource("/Images/Treasures/TERRE.png"));
            waterImage = ImageIO.read(GamePanel.class.getResource("/Images/Treasures/EAU.png"));
            airImage = ImageIO.read(GamePanel.class.getResource("/Images/Treasures/AIR.png"));

        }
        catch(Exception E)
        {
            System.out.println("Error loading imaged in game panel");
            return;
        }
    }
    public void paint(Graphics g){
        g.drawImage(backGroundImage, 0, 0, 1600, 960, null);

        drawMap(g);
        drawWaterMaker(g);
        drawDecks(g);
        drawFloodDeck(g);
        drawPlayers(g);

        if (playerIsMoving) {
            drawMoveMarkers(g, playerMoving);
        } else if (playerIsShoringUp) {
            drawShoreUpMarkers(g, playerShoringUp);
        }

        drawTreasure(g);
    }

    private void drawShoreUpMarkers(Graphics g, Player p) {
        boolean canTakeAction = false;
        int offsetX = 108, offsetY = 155, spacing = 120;
        g.setColor(new Color(255, 255, 255, 175));

        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 6; c++) {
                if (p.canShoreUp(r, c)) {
                    canTakeAction = true;
                    g.fillRect(offsetX + c * spacing, offsetY + r * spacing, 50, 50);
                }
            }
        }

        if (!canTakeAction) {
            playerIsShoringUp = false;
            takingAction = false;
        }

    }

    private void drawTreasure(Graphics g) {
        if (TreasureManager.waterCaptured) {
            g.drawImage(waterImage, 1361, 723, 101, 101, null);
        } else {
            g.drawImage(waterImage, 107, 66, 168, 165, null);
        }

        if (TreasureManager.airCaptured) {
            g.drawImage(airImage, 1291, 730, 80, 80, null);
        } else {
            g.drawImage(airImage, 109, 731, 150, 143, null);
        }

        if (TreasureManager.fireCaptured) {
            g.drawImage(fireImage, 1451, 724, 103, 95, null);
        } else {
            g.drawImage(fireImage, 590, 75, 155, 152, null);
        }

        if (TreasureManager.earthCaptured) {
            g.drawImage(earthImage, 1187, 724, 96, 92, null);
        } else {
            g.drawImage(earthImage, 581, 723, 176, 166, null);
        }
    }
//TODO: Add canTakeAction Checker
    private void drawMoveMarkers(Graphics g, Player p) {
        boolean canTakeAction = false;
        int offsetX = 108, offsetY = 155, spacing = 120;
        g.setColor(new Color(255, 255, 255, 175));

        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 6; c++) {
                if (p.canMove(r, c)) {
                    canTakeAction = true;
                    g.fillRect(offsetX + c * spacing, offsetY + r * spacing, 50, 50);
                }
            }
        }

        if (!canTakeAction) {
            playerIsMoving = false;
            takingAction = false;
        }
    }

    private void drawPlayers(Graphics g) {
        //Tile info
        int offsetX = 73, offsetY = 120, spacing = 120;

        Pawn p = Main.player.pawn;
        g.drawImage(p.getImage(), offsetX + p.getCol() * spacing, offsetY + p.getRow() * spacing, 30, 45, null);
    }

    private void drawMap(Graphics g) {
        //Draw translucent rectangle behind the map
        int marginX = 22, marginY = 55, containerWidth = 1021, containerHeight = 850;

        g.setColor(new Color(0, 0, 0, 150));
        g.fillRect(marginX, marginY, containerWidth, containerHeight);

        // Draw the actual map
        int tileSize = 120, offsetX = 73, offsetY = 120, spacing = 120;

        Tile[][] map = Map.instance.getMap();
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 6; c++) {
                if (map[r][c] == null) {
                    continue;
                }
                g.drawImage(map[r][c].getCurrentImage(), offsetX + c * spacing, offsetY + r * spacing, tileSize, tileSize, null);
            }
        }
    }
    private void drawDecks(Graphics g){g.drawImage(treasureCardBackImage, 782, 65, 128, 188, null);}
    private void drawWaterMaker(Graphics g) {
        g.drawImage(waterMarkerImage, 869, 262, 160, 440, null);

        //water level

        int x = 839;
        int yOffset = 630;
        int ySpacing = 38;
        g.setColor(Color.red);
        g.fillRect(x, yOffset - ySpacing * (WaterLevel.waterMarkerLevel - 1), 75, 15);
    }
    private void drawFloodDeck(Graphics g) {
        g.drawImage(floodCardBackImage, 782, 708, 128, 188, null);
        g.drawImage(Main.floodDeck.discardPileImage, 910, 708, 128, 188, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Tile info
        int offsetX = 73, offsetY = 120, spacing = 120;
        int clickCol = (e.getX() - offsetX) / spacing;
        int clickRow = (e.getY() - offsetY) / spacing;

        Tile tileClicked = null;

        try {
            tileClicked = Map.instance.getTileAtPosition(clickRow, clickCol);
        } catch (Exception ex) {

        }

        if (Main.player.pawn.getRow() == clickRow && Main.player.pawn.getCol() == clickCol && !takingAction) {
            playerIsMoving = true;
            takingAction = true;
            playerMoving = Main.player;
            repaint();
        }

        if (playerIsMoving && playerMoving.canMove(clickRow, clickCol)) {
            playerIsMoving = false;
            takingAction = false;
            playerMoving.move(clickRow, clickCol);
            repaint();
        } else if (playerIsShoringUp && tileClicked != null && playerShoringUp.canShoreUp(clickRow, clickCol)) {
            tileClicked.shoreUp();
            playerIsShoringUp = false;
            takingAction = false;
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
        if (!takingAction && e.getKeyChar() == 's') {
            playerIsShoringUp = true;
            takingAction = true;
            playerShoringUp = Main.player;
            repaint();
        }


    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}
