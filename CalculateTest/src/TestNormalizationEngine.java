
public class TestNormalizationEngine {

	public static void main(String[] args) {
		
		Double posX = 2.0;
		Double posY = 1.0;
		
		Double goalX = 4.0;
		Double goalY = 5.0;
		
		Double x = goalX - posX;
		Double y = goalY - posY;
		
		Double normalizedX;
		Double normalizedY;
		
		Double magnitude;
		
		// Count magnitude
		magnitude = Math.sqrt(x * x + y * y);
		
		System.out.println("Vector magnitude: " + magnitude);
		
		while (posX <= goalX && posY <= goalY) {
			
			normalizedX = x / magnitude / 10;
			
		//	System.out.println("NORMALIZED X: " + normalizedX +" x =  "+ x + " magnitude "+ magnitude);
			
			normalizedY = y / magnitude / 10;
			
			posX += normalizedX;
			posY += normalizedY;
			
			System.out.printf("(%f , %f) \n", posX, posY);
			
		}
		
		
		/* 
		 * Result from testing
		 * 
		 Vector magnitude: 4.47213595499958
			(2.044721 , 1.089443) 
			(2.089443 , 1.178885) 
			(2.134164 , 1.268328) 
			(2.178885 , 1.357771) 
			(2.223607 , 1.447214) 
			(2.268328 , 1.536656) 
			(2.313050 , 1.626099) 
			(2.357771 , 1.715542) 
			(2.402492 , 1.804984) 
			(2.447214 , 1.894427) 
			(2.491935 , 1.983870) 
			(2.536656 , 2.073313) 
			(2.581378 , 2.162755) 
			(2.626099 , 2.252198) 
			(2.670820 , 2.341641) 
			(2.715542 , 2.431084) 
			(2.760263 , 2.520526) 
			(2.804984 , 2.609969) 
			(2.849706 , 2.699412) 
			(2.894427 , 2.788854) 
			(2.939149 , 2.878297) 
			(2.983870 , 2.967740) 
			(3.028591 , 3.057183) 
			(3.073313 , 3.146625) 
			(3.118034 , 3.236068) 
			(3.162755 , 3.325511) 
			(3.207477 , 3.414953) 
			(3.252198 , 3.504396) 
			(3.296919 , 3.593839) 
			(3.341641 , 3.683282) 
			(3.386362 , 3.772724) 
			(3.431084 , 3.862167) 
			(3.475805 , 3.951610) 
			(3.520526 , 4.041052) 
			(3.565248 , 4.130495) 
			(3.609969 , 4.219938) 
			(3.654690 , 4.309381) 
			(3.699412 , 4.398823) 
			(3.744133 , 4.488266) 
			(3.788854 , 4.577709) 
			(3.833576 , 4.667151) 
			(3.878297 , 4.756594) 
			(3.923018 , 4.846037) 
			(3.967740 , 4.935480) 
			(4.012461 , 5.024922) 
*/
		
	}

}