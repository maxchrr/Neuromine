package up.neuromine.caracters;

import up.neuromine.tiles.Tile;

public abstract class BaseCaracter {
    
    private String name; /*Name of the caracter */
    private int health; /*The amount of damage the caracter can take before dying */
    private int mana; /*The amount of turns before activating the special capacity */
    private int damage; /*The amount of damage the caracter deals */
    private Tile selectedTile; /*The tile currently selected */

    private int posX;
    private int posY;


    /*The base constructor called by each caracter with their specificities */
    public BaseCaracter(String name, int health, int mana, int damage){
        setName(name);
        setHealth(health);
        setMana(mana);
        setDamage(damage);
    }
    

    /*Moves the player in a specified directon */
    public abstract void move(/*Direction direction */);

    /*Attacks the selected tile */
    public abstract void attack(Tile tile);

    /*Uses the special ability of the said caracter */
    public abstract void speCapacity(Tile tile);

    /*Reveals the selected tile */
    public void reveal(Tile tile){
        tile.Reveal();
    };

    /*Places a flag on the selected tile */
    public void flag(Tile tile){
        tile.coverWithFlag();
    };

    /*Deals threat.damage amount of damage to the caracter */
    public void takeDamage(int damageDealt){
        setDamage(getDamage()-damageDealt);
    };

    /*Return the state of the caracter, if dead the game is over */
    public boolean isDead(){
        return health <= 0;
    };

    /*Rotate the caracter clockwise, the selected Tile moves consequently */
    public void rotate(){
        /*sets the selected Tile as one of the other adjacant Tile of the caracter (clockwise) */
    }


    /*Getters */
    public int getPosX(){
        return this.posX;
    };

    public int getPosY(){
        return this.posY;
    };

    public int getHealth(){
        return this.health;
    };

    public int getMana(){
        return this.mana;
    };

    public String getName(){
        return this.name;
    };

    public int getDamage(){
        return this.damage;
    };

    public Tile getSelectedTile(){
        return this.selectedTile;
    };


    /*Setters */
    public void setPoxX(int posX){
        this.posX = posX;
    };

    public void setPoxY(int posY){
        this.posY = posY;
    };

    public void setHealth(int health){
        this.health = health;;
    };

    public void setMana(int mana){
        this.mana = mana;
    };

    public void setName(String name){
        this.name = name;
    };

    public void setDamage(int damage){
        this.damage = damage;
    };

    public void setSelectedTile(Tile tile){
        this.selectedTile = tile;
    };

}
