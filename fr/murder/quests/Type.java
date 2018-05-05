public enum Type {
		
		KILL_PLAYER(0, "Tue X joueurs"),
		KILL_MOB(1, "Tu X mobs"),
		MINE_MINERAIS(2, "Mine X minerais"),
		CONNECTED(3, "Reste connecté X minutes"),
		GET_XP(4, "Farm X levels"),
		PLACE_BLOCK(5, "Place X blocks"),
		RUN(6, "Cours X blocks"),
		BREAK_BLOCK(7, "Casse X blocks"),
		CRAFT_ITEM(8, "Craft X"),
		FARM_MONEY(9, "Farm X money");
		
		public static final HashMap<Integer, Type> types = new HashMap<>();
		
		private int id;
		private String name;
		
		private Type(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public int getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		static {
			for(Type t : values()) {
				types.put(t.id, t);
			}
		}
		
	}
