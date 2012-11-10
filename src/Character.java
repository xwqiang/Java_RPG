//Java_RPG
//Alpha 1.1.01
//Released 11/09/2012
//©2012 Ryan Cicchiello & Jason Holman
//See LICENCE for details

package txtrpg;
import java.io.IOException;


public class Character {

	private int health; //The players health
	private int cHealth; //The players current health
	private int mana; // The players mana
	private int cMana; //The players current mana
	private int level; // The players level
	private int xp; // The players expierience
	private int str; //The players Strength rating
	private int dex; //The players Dexterity rating
	private int intel; //The players intelligence rating
	private int clv; //The last time they visited the castle
	private int turns; //The amount of turns the player has had.
	private int mapSize; //The size of the map.
	private int locationX; //The x location of the player
	private int locationY; //The y location of the player
	private int weapon; //The weapon the player has
	private int wood; //The amount of wood the player has
	private int gold; //The amount of gold the player has
	private int iron; //The amount of iron the player has
	private boolean axe; //if the player has an axe
	private boolean pick; //if the player has a pick axe

	private final int LVL_XP[] = {100,500,1200,2500,5000,9000,15000,20000,25000}; //xp needed to get to the next level
	private String charName;
	private boolean hasMap;
	Login login;

	public Character(String name) throws NumberFormatException, IOException {
		charName = name;
		login = new Login(charName);
		getStats();
	}

	public void findWeapon(int weaponType) {
		weapon = Math.max(weaponType, weapon);
	}

	public void saveAll() throws IOException {
		login.saveStats(health, cHealth, mana, cMana, level, xp, str, dex, intel, clv, turns, locationX, locationY, weapon, hasMap, axe, pick, wood, gold, iron);
	}
	
	/**
	 * Refreshes the stats from the file
	 */
	private void getStats() {
		health = login.getHealth();
		cHealth = login.getCHealth();
		mana = login.getMana();
		cMana = login.getCMana();
		level = login.getLevel();
		xp = login.getXp();
		str = login.getStr();
		dex = login.getDex();
		intel = login.getIntel();
		clv = login.getCLV();
		turns = login.getTurns();
		mapSize = login.getMapSize();
		locationX = login.getLocationX();
		locationY = login.getLocationY();
		weapon = login.getWeapon();
		hasMap = login.getMap();
		axe = login.getAxe();
		pick = login.getPick();
		wood = login.getWood();
		gold = login.getGold();
		iron = login.getIron();
	}
	/**
	 * Sets that the player found a map		
	 */
	public void findMap() {
		hasMap = true;
	}
	
	/**
	 * Sets that the player has an axe
	 */
	public void findAxe() {
		axe = true;
	}
	
	/**
	 * Sets that the player has a pick axe
	 */
	public void findPick() {
		pick = true;
	}

	/**
	 * Returns the max health of the player
	 * @return health - the max health of the player
	 */
	public int getHealth(){
		getStats();
		return health;
	}

	/**
	 * Returns Current Health
	 * @return CHealth - Current Health of Player
	 */
	public int getCHealth(){
		getStats();
		return cHealth;
	}

	/**
	 * Retrieves Mana Value
	 * @return mana- The Maximum amount of mana
	 */
	public int getMana(){
		getStats();
		return mana;
	}

	/**
	 * Retrieves Current Mana Value
	 * @return Current Mana - The Players Current Amount Of Mana
	 */
	public int getCMana(){
		getStats();
		return cMana;
	}

	/**
	 * Retrieves the Players Level
	 * @return Level- The Current Players Level
	 */
	public int getLevel(){
		getStats();
		return level;
	}

	/**
	 * Retrieves Experience Points
	 * @return Experience - How close you are to the next level
	 */
	public int getXp(){
		getStats();
		return xp;
	}

	/**
	 * Retrieves Strength Rating
	 * @return Strength - The Strength Level
	 */
	public int getStr(){
		getStats();
		return str;
	}

	/**
	 * Retrieves Dexterity Rating
	 * @return Dexterity - Retrieves Dexterity Rating
	 */
	public int getDex(){
		getStats();
		return dex;
	}

	/**
	 * Retrieves Intelligence
	 * @return Intel - The Intelligence rating
	 */
	public int getIntel(){
		getStats();
		return intel;
	}

	/**
	 * Retrieves the last time the player visited the castle
	 * @return Castle Last Visited- The last turn a player was at the castle
	 */
	public int getCLV(){
		getStats();
		return clv;
	}

	/**
	 * Retrieves the amount of turns a player has went through
	 * @return Turns - The amount of turns
	 */
	public int getTurns(){
		getStats();
		return turns;
	}

	/**
	 * Retrieves the size of the map
	 * @return mapSize - the size of the map
	 */
	public int getMapSize(){
		getStats();
		return mapSize;
	}

	/**
	 * Retrieves the X start location
	 * @return locationX - the X location
	 */
	public int getLocationX() {
		getStats();
		return locationX;
	}

	/**
	 * Retrieves the Y start location
	 * @return locationY - the Y location
	 */
	public int getLocationY() {
		getStats();
		return locationY;
	}

	/**
	 * Retrieves the weapon the player has
	 * @return weapon - the weapon the player has
	 */
	public int getWeapon() {
		getStats();
		return weapon;
	}

	/**
	 * Sets the current health
	 * @param setHealth - the current health
	 * @throws IOException
	 */
	public void setCHealth(int setHealth) throws IOException {
		if(setHealth<=health){
			cHealth = setHealth;
			saveAll();
		}
		else{
			cHealth = health;
		}
	}

	/**
	 * Sets the current mana
	 * @param setMana - the current mana
	 * @throws IOException
	 */
	public void changeMana(int setMana) throws IOException{
		cMana = cMana + setMana;
		saveAll();
	}

	/**
	 * Sets the current level
	 * @param setLevel - the current level
	 * @throws IOException
	 */
	private void addLevel() throws IOException {
		if(level<10){
			level++;
			health = getHealth()+30;
			mana = getMana() +30;
			str = getStr() + 3;
			dex  = getDex() + 3;
			intel = getIntel() + 3;
			cHealth = getHealth();
			cMana = getMana();
			H.pln("You are now level "+level+"!");
		}
		else{
			level++;
			health = getHealth()+30;
			mana = getMana() +30;
			str = getStr() + 3;
			dex  = getDex() + 3;
			intel = getIntel() + 3;
			cHealth = getHealth();
			cMana = getMana();
		}
			
		saveAll();
	}

	/**
	 * sets the current xp
	 * @param setXP - the current xp
	 * @throws IOException
	 */
	public void addXP(int addXP) throws IOException {
		xp = xp + addXP;
		if(xp >= LVL_XP[level]){
			xp-=LVL_XP[level];
			addLevel();
		}
		saveAll();
	}

	/**
	 * resets xp upon death
	 */
	public void resetXP() {
		xp = 0;
	}

	/**
	 * sets the current strength
	 * @param setStr - the current strength
	 * @throws IOException
	 */
	public void setStr(int setStr) throws IOException {
		str = setStr;
		saveAll();
	}

	/**
	 * sets the current dexterity
	 * @param setDex - the current dexterity
	 * @throws IOException
	 */
	public void setDex(int setDex) throws IOException {
		dex = setDex;
		saveAll();
	}

	/**
	 * sets the current intel
	 * @param setIntel - the current intel
	 * @throws IOException
	 */
	public void setIntel(int setIntel) throws IOException {
		intel = setIntel;
		saveAll();
	}

	/**
	 * sets the last castle visit
	 * @param cetClv - the last castle visit
	 * @throws IOException
	 */
	public void setClv(int setClv) throws IOException {
		clv = setClv;
		saveAll();
	}

	/**
	 * sets the number of turns
	 * @param setTurn - the number of turns
	 * @throws IOException
	 */
	public void setTurn(int setTurn) throws IOException {
		turns = setTurn;
		saveAll();
	}

	/**
	 * sets the current location
	 * @param x - the x coordinate of the location
	 * @param y - the y coordinate of the location
	 * @throws IOException
	 */
	public void setLocation(int x, int y) throws IOException {
		locationX = x;
		locationY = y;
		saveAll();
	}

	public void update() throws NumberFormatException, IOException{
		login.update();
		getStats();
	}
	
	/**
	 * Tells if the player has the map
	 * @return hasMap - if the player has a map
	 */
	public boolean hasMap() {
		return hasMap;
	}
	
	/**
	 * Retrieves whether or not the player has an axe
	 * @return axe - if the player has an axe
	 */
	public boolean getAxe() {
		return axe;
	}
	
	/**
	 * Retrieves whether or not the player has a pick axe
	 * @return pick - if the player has a pick axe
	 */
	public boolean getPick() {
		return pick;
	}
	
	/**
	 * Retrieves the amount of wood the player has
	 * @return wood - the amount of wood the player has
	 */
	public int getWood() {
		return wood;
	}
	
	/**
	 * Adds the amount of wood to the total amount of
	 * wood the player has
	 * @param aWood - the amount of wood to be added or subtracted
	 * @throws IOException 
	 */
	public void setWood(int aWood) throws IOException {
		wood += aWood;
		saveAll();
	}
	
	/**
	 * Adds the amount of wood to the total amount of
	 * wood the player has
	 * @param aWood - the amount of wood to be added or subtracted
	 * @throws IOException 
	 */
	public void setGold(int aGold) throws IOException {
		gold += aGold;
		saveAll();
	}
	
	/**
	 * Adds the amount of wood to the total amount of
	 * wood the player has
	 * @param aWood - the amount of wood to be added or subtracted
	 * @throws IOException 
	 */
	public void setIron(int aIron) throws IOException {
		iron += aIron;
		saveAll();
	}
}

