public class Main {
	
	public static long[] GeneratoriusA(long A, int dydis) {
		
		// Skaciu Generatorius A
		
		long aKoeff = 16807;
		long dalintiIs = 2147483647;
		
		long[] skaiciaiA = new long[dydis];
		
		for (int i = 0; i < dydis; i++) {
			A *= aKoeff;
			A %= dalintiIs;
			
			skaiciaiA[i] = A;			
		}
		
		return skaiciaiA;
		
	}
	
public static long[] GeneratoriusB(long B, int dydis) {
		
		// Skaciu Generatorius B
		
		long bKoeff = 48271;
		long dalintiIs = 2147483647;
		
		long[] skaiciaiB = new long[dydis];
		
		for (int i = 0; i < dydis; i++) {
			B *= bKoeff;
			B %= dalintiIs;
			skaiciaiB[i] = B;			
		}
		
		return skaiciaiB;
		
	}
	
	public static String Convert(long n) {
		
		/* Takes the number of type long and converts to the binary number. 
		Returns only the last 8 digits of that binary number in the String format */
		
		long a;
		String x = "";		
		int i = 0;
		
		while(n > 0 & i < 8) {
			
			a = n%2;
			x = a + "" + x;
			n = n / 2;
			i++;
					
        }		
		return x;		
	}
	
	public static int Palyginti(long[] A, long[] B) {
		
		int lygu = 0;
		String a;
		String b;
		int dydis = A.length;
		
		for (int i = 0; i < dydis; i++) {
			
			a = Convert(A[i]);
			b = Convert(B[i]);
			if(a.equals(b)) {
				lygu++;
			}
			
		}
		
		return lygu;
		
	}
        
	public static void main(String[] args){
		
		if(args.length != 2) {
			System.out.println("Give me two integers as the arguments, please!");
			return;
		}
		
		int dydis = 1000000;
		
		long A = Long.parseLong(args[0]);
		long B = Long.parseLong(args[1]);
		
		long[] genA = GeneratoriusA(A, dydis);
		long[] genB = GeneratoriusB(B, dydis);
		
		int lygu = Palyginti(genA, genB);
		
		System.out.println(lygu);		

	}

}