import java.util.HashSet;
import java.util.Objects;
public class LeafPile {
    public static void main( String[] args ) {
		Ground map[][] = new Ground[ 5 ][ 10 ];
		generateRandomGround( map );
		printMap( map );
		System.out.println( largestLeafPile( map ) );
    }

    /*****************STUDENT CODE HERE*******************/

	private static class LeafPileLocation{
		private final int x;
		private final int y;
		private static HashSet<LeafPileLocation> MarkedSet;

		public LeafPileLocation(int x, int y){
			this.x=x;
			this.y=y;
		}

		public static boolean DoesNotContains(LeafPileLocation loc){
			return !MarkedSet.contains(loc);
		}

		public static void add(LeafPileLocation loc){
			MarkedSet.add(loc);
		}

		public static void clearSet(){
			MarkedSet = new HashSet<>();
		}

		@Override
		public String toString(){
			return "(" + this.x + ", " + this.y + ")";
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof LeafPileLocation)) return false;
			LeafPileLocation that = (LeafPileLocation) o;
			return this.x == that.x && this.y == that.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

	public static int largestLeafPileUnitTest(Ground[][] map){
		return largestLeafPile(map);
	}
    
    private static int largestLeafPile( Ground map[][] ) {
		int MaxTotalPileSize = 0;
		HashSet<LeafPileLocation> CurrentPile = new HashSet<>();
		LeafPileLocation.clearSet();
		LeafPile leafPile = new LeafPile();
		for(int x = 0; x < map.length; x++){
			for(int y = 0; y<map[x].length; y++){
				if(map[x][y] == Ground.LEAF && LeafPileLocation.DoesNotContains(new LeafPileLocation(x, y))){
					leafPile.subPile(map,x, y, CurrentPile);
				}
				if(CurrentPile.size()>MaxTotalPileSize){
					MaxTotalPileSize=CurrentPile.size();
				}
				CurrentPile = new HashSet<>();
			}
		}
		return MaxTotalPileSize;
    }

	private void subPile(Ground[][] map, int x, int y, HashSet<LeafPileLocation> currentPileSet){
		LeafPileLocation loc = new LeafPileLocation(x, y);
		currentPileSet.add(loc);
		LeafPileLocation.add(loc);
		if(x>0 && y<map[x-1].length && map[x-1][y] == Ground.LEAF && LeafPileLocation.DoesNotContains(new LeafPileLocation(x - 1, y))){
			subPile(map, x-1, y, currentPileSet);
		}
		if(x<map.length-1 && y<map[x+1].length && map[x+1][y] == Ground.LEAF && LeafPileLocation.DoesNotContains(new LeafPileLocation(x + 1, y))){
			subPile(map, x+1, y, currentPileSet);
		}
		if(y>0 && map[x][y-1] == Ground.LEAF && LeafPileLocation.DoesNotContains(new LeafPileLocation(x, y - 1))){
			subPile(map, x, y-1, currentPileSet);
		}
		if(y<map[x].length-1 && map[x][y+1] == Ground.LEAF && LeafPileLocation.DoesNotContains(new LeafPileLocation(x, y + 1))){
			subPile(map, x, y+1, currentPileSet);
		}
	}

	/****************END STUDENT CODE**********************/

    /************ Utility Methods *************/
    
    private static void printMap( Ground map[][] ) {
		for(int r = 0; r < map.length; r++) {
			for(int c = 0; c < map[r].length; c++) {
			if( map[r][c] == Ground.GRASS ) {
				System.out.print( ". " );
			}
			if( map[r][c] == Ground.LEAF ) {
				System.out.print( "~ " );
			}
			}
			System.out.println();
		}
    }

    private static void generateRandomGround( Ground map[][] ) {
		int randGround;
		for(int r = 0; r < map.length; r++) {
			for(int c = 0; c < map[r].length; c++) {
			randGround = (int) ( Math.random() * 2 );
			map[r][c] = randGround == 0 ? Ground.GRASS : Ground.LEAF;
			}
		}
    }
    
    /****************************************/
}
